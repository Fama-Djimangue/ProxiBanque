package sn.objis.proxibanqueV2.presentation.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sn.objis.proxibanqueV2.dao.DataAccessException;
import sn.objis.proxibanqueV2.domaine.CompteUtilisateur;
import sn.objis.proxibanqueV2.domaine.Employer;
import sn.objis.proxibanqueV2.services.CompteUtilisateurService;
import sn.objis.proxibanqueV2.services.EmployerService;

/**
 * Servlet implementation class ModifierConseillerServlet
 */
@WebServlet("/modifConseiller")
public class ModifierFicheConseillerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Employer conseiller = null;
	private CompteUtilisateur compteuser = null;
	private CompteUtilisateurService compteuserService = new CompteUtilisateurService();
	private EmployerService employerService = new EmployerService();

	private List<Employer> listEmplyers = new ArrayList<>();
	private List<Employer> listConseillers = new ArrayList<>();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifierFicheConseillerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recuperation des donnees saisie au formulaire
		long idRecup = Long.parseLong(request.getParameter("id"));
		String prenomRecup = request.getParameter("prenom");
		String nomRecup = request.getParameter("nom");
		String emailRecup = request.getParameter("email");
		String adresseRecup = request.getParameter("adresse");
		String villeRecup = request.getParameter("ville");
		String telephoneRecup = request.getParameter("telephone");
		String codeposteRecup = request.getParameter("codePostal");

		conseiller = new Employer(idRecup, nomRecup, prenomRecup, emailRecup, adresseRecup, codeposteRecup, villeRecup,
				telephoneRecup);
		try {
			employerService.update(conseiller);
			
			//Fabriquer le données à afficher
			
			listEmplyers = employerService.findAll();
			//Parcourir la liste pour déterminer celui de l'id trouvé
			for(Employer conseiller: listEmplyers){
				if(conseiller.getType_employer().equals("CCL")){
					//Ranger lesconseillers dans une liste
					listConseillers.add(conseiller);
				}
			}
			//Ajout des données dans un scope
			request.setAttribute("conseillers", listConseillers);


			RequestDispatcher rd = request.getRequestDispatcher("gerant/listConseillers.jsp");
			rd.forward(request, response);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
