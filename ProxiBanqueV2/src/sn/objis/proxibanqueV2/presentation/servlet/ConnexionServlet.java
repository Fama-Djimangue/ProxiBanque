package sn.objis.proxibanqueV2.presentation.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sn.objis.proxibanqueV2.domaine.CompteUtilisateur;
import sn.objis.proxibanqueV2.domaine.Employer;
import sn.objis.proxibanqueV2.services.CompteUtilisateurService;
import sn.objis.proxibanqueV2.services.EmployerService;

/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Employer employer = null;
	private EmployerService employerService = new EmployerService();
	private CompteUtilisateur compteUtilisateur = null;
	private CompteUtilisateurService compteUtilisateurService = new CompteUtilisateurService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConnexionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		traitement(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		traitement(request, response);
	}
	protected void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recup données
		String user = request.getParameter("username");
		String mdp = request.getParameter("password");
		System.out.println(user);
		System.out.println(mdp);

		// Recuperer l'employer connecté
		compteUtilisateur = compteUtilisateurService.recupererUtilisateurParLogin(user);

		employer = employerService.findByIdCompteUser(compteUtilisateur);

		// recuperation de la session de l'utilisateur
		HttpSession session = request.getSession();

		//Ajout de l'employer connecté dans la session
		session.setAttribute("employerConnect", employer);
		session.setAttribute("CompteConnect", compteUtilisateur);


		RequestDispatcher dispatcher = null;
		try {
			
				request.login(user, mdp);

				if (request.isUserInRole("SuperAdmin")) {
					dispatcher = request.getRequestDispatcher("admin/accueilAdmin.jsp");
					dispatcher.forward(request, response);

				}
				if (request.isUserInRole("GAG")) {					
					dispatcher = request.getRequestDispatcher("gerant/accueilGerant.jsp");
					dispatcher.forward(request, response);

				}
				if (request.isUserInRole("CCL")) {
					dispatcher = request.getRequestDispatcher("listeclient");
					dispatcher.forward(request, response);

				}
		} catch (Exception e) {

			System.out.println("Mot de passe ou login ne correspond pas");
			dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}
	}

		
}
