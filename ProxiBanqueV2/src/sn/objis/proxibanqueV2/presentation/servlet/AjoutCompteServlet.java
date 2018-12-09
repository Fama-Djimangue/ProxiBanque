package sn.objis.proxibanqueV2.presentation.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.objis.proxibanqueV2.domaine.Compte;
import sn.objis.proxibanqueV2.services.ClientService;
import sn.objis.proxibanqueV2.services.CompteService;

/**
 * Servlet implementation class AjoutCompteServlet
 */
@WebServlet("/ajoutCompte")
public class AjoutCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CompteService compteservice = new CompteService();
	private ClientService clientservice = new ClientService();
	private Compte newcompte = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutCompteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request, response);
	}
	protected void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   long idclientRecup = Long.parseLong(request.getParameter("idDuclient"));
		   String typeRecup = request.getParameter("typeCompte");
		   String nomClient = request.getParameter("nomclient");
		   
		   if (typeRecup.equals("COURANT")) {
			// compte epargne du client
				newcompte = new Compte("EPARGNE", 0.3, 0);
				
		}else {
			// compte courant du client
			newcompte = new Compte("COURANT", 0, 1000);
		}
		// Creation du compte
		   compteservice.create(newcompte, clientservice.find(idclientRecup));
		   request.setAttribute("listecomptes", compteservice.findByIdClient(idclientRecup));
		   request.setAttribute("nomclient", nomClient);
			//Donner la main à la page utilisateur.jsp qui va afficher les donner
			RequestDispatcher dispatcher = request.getRequestDispatcher("conseiller/listCompte.jsp");
			dispatcher.forward(request, response);
		
	}

}
