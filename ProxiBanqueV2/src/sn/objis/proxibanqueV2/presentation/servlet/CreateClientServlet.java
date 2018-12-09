package sn.objis.proxibanqueV2.presentation.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sn.objis.proxibanqueV2.domaine.Client;
import sn.objis.proxibanqueV2.domaine.Compte;
import sn.objis.proxibanqueV2.domaine.Employer;
import sn.objis.proxibanqueV2.services.ClientService;
import sn.objis.proxibanqueV2.services.CompteService;

/**
 * Servlet implementation class CreateClientServlet
 */
@WebServlet("/creatclient")
public class CreateClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Client newclient = null;
	private Compte newcompteCou = null;
	private Compte newcompteEpa = null;
	private Employer conseillerClient = null;
	private ClientService clientservice = new ClientService();
	private CompteService compteservice = new CompteService();
	private boolean testCreate = false;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateClientServlet() {
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
		// Recuperation des donnees saisie au formulaire
		String prenomRecup = request.getParameter("prenomclient");
		String nomRecup = request.getParameter("nomclient");
		String emailRecup = request.getParameter("emailclient");
		String adresseRecup = request.getParameter("adresseclient");
		String villeRecup = request.getParameter("villeclient");
		String telephoneRecup = request.getParameter("telclient");
		String codeposteRecup = request.getParameter("codepostal");
		String professionRecup = request.getParameter("professionclient");

		// Récupération des données saisie pour Compte
		String typeEpaRecup = request.getParameter("checkBoxCptEpargne");
		String typeCouRecup = request.getParameter("checkBoxCptCourant");

		// Recpuration du gerant mise en session dans AuthentificationServlet
		HttpSession session = request.getSession();
		conseillerClient = (Employer) session.getAttribute("employerConnect");

		// Ajout information new client
		newclient = new Client(nomRecup, prenomRecup, emailRecup, adresseRecup, codeposteRecup, villeRecup,
				telephoneRecup, professionRecup);

		RequestDispatcher rd =null;
		// Creation information Compte client

		if (typeEpaRecup != null && typeCouRecup == null) {
			testCreate = true;
			// Creation du client
			clientservice.create(newclient, conseillerClient);

			// Recupérer dernier id_client enregistrer
			long id = clientservice.AfficherLastId();
			newclient.setId_client(id);

			// Creation du compte epargne du client
			newcompteEpa = new Compte(typeEpaRecup, 0.3, 0);
			compteservice.create(newcompteEpa, newclient);
		} else if (typeEpaRecup == null && typeCouRecup != null) {
			testCreate = true;
			// Creation du client
			clientservice.create(newclient, conseillerClient);

			// Recupérer dernier id_client enregistrer
			long id = clientservice.AfficherLastId();
			newclient.setId_client(id);

			// Creation du compte courant du client
			newcompteCou = new Compte(typeCouRecup, 0, 1000);
			compteservice.create(newcompteCou, newclient);
		}

		else if (typeEpaRecup != null && typeCouRecup != null) {
			testCreate = true;
			// Creation du client
			clientservice.create(newclient, conseillerClient);

			// Recupérer dernier id_client enregistrer
			long id = clientservice.AfficherLastId();
			newclient.setId_client(id);

			// Creation du compte epargne du client
			newcompteEpa = new Compte(typeEpaRecup, 0.3, 0);
			compteservice.create(newcompteEpa, newclient);

			// Creation du compte courant du client
			newcompteCou = new Compte(typeCouRecup, 0, 1000);
			compteservice.create(newcompteCou, newclient);
		} else {
			
			request.setAttribute("creation", false);
			rd= request.getRequestDispatcher("conseiller/AjoutClient.jsp");
			rd.include(request, response);
			
		}
			
		if (testCreate==true) {
			request.setAttribute("creation", true);
			request.setAttribute("clients", clientservice.findClientsDuConseiller(conseillerClient));
			rd= request.getRequestDispatcher("conseiller/listClient.jsp");
			rd.forward(request, response);
			
		}
	}
}
