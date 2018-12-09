package sn.objis.proxibanqueV2.presentation.servlet;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class CreateConseiller
 */
@WebServlet("/createCons")
public class CreateConseillerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Employer conseiller=null;
	private CompteUtilisateur compteuser=null;
	private CompteUtilisateurService compteuserService = new CompteUtilisateurService();
	private EmployerService employerService=new EmployerService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateConseillerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperation des donnees saisie au formulaire
		String prenomRecup=request.getParameter("prenom");
		String nomRecup=request.getParameter("nom");
		String emailRecup=request.getParameter("email");
		String adresseRecup=request.getParameter("adresse");
		String villeRecup=request.getParameter("ville");
		String telephoneRecup=request.getParameter("telephone");
		String codeposteRecup=request.getParameter("codePostal");

		String loginRecup=request.getParameter("login");
		String pswRecup=request.getParameter("password");
		 
		
		conseiller=new Employer(nomRecup, prenomRecup, emailRecup, adresseRecup, codeposteRecup, villeRecup, telephoneRecup);
		
		compteuser = new CompteUtilisateur(loginRecup, pswRecup);
		compteuserService.create(compteuser);

		long dernierId = compteuserService.dernierIdCompteUser(compteuser);
		compteuser.setId_compte_user(dernierId);

		//Recpuration du gerant mise en session dans AuthentificationServlet
		HttpSession session = request.getSession();
		Employer gerant = (Employer) session.getAttribute("employerConnect");

		employerService.createConseiller(conseiller, compteuser, gerant);
		
		request.setAttribute("conseillers", employerService.findAll());
		/*List<Employer> listConseillers = (List<Employer>) session.getAttribute("conseillers");
		request.setAttribute("conseillers", listConseillers);*/
		RequestDispatcher rd=request.getRequestDispatcher("gerant/listConseillers.jsp");
		rd.forward(request, response);

	}

}
