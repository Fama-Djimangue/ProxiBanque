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

import sn.objis.proxibanqueV2.domaine.Client;
import sn.objis.proxibanqueV2.domaine.Employer;
import sn.objis.proxibanqueV2.services.ClientService;

/**
 * Servlet implementation class ModifierClientServlet
 */
@WebServlet("/modifierclient")
public class ModifierClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  //Recuperation des donnees saisie SUR L'url
		long idClient=Long.parseLong(request.getParameter("idclient"));
		Client clientFound = new Client();
		ClientService clientservice = new ClientService();
		clientFound=clientservice.find(idClient);
		request.setAttribute("client", clientFound);

		
		RequestDispatcher dispo = request.getRequestDispatcher("conseiller/modifclient.jsp");
		dispo.forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 ClientService serviceclient = new ClientService();
     Client clientAmod;
     
     String idclientAmod = request.getParameter("idclient");
     long idclient = Long.parseLong(idclientAmod);
     String prenomMod = request.getParameter("prenomclient");
	 String nomMod = request.getParameter("nomclient");
	 String emailMod = request.getParameter("emailclient");
	 String adresseMod = request.getParameter("adresseclient");
	 String codepostalMod = request.getParameter("codepostal");
	 String villeMod = request.getParameter("villeclient");
	 String telMod = request.getParameter("telclient");
	 String professionMod = request.getParameter("professionclient");
	 
	 clientAmod = new Client(idclient, nomMod, prenomMod, emailMod, adresseMod, codepostalMod, villeMod, telMod, professionMod);

	  // Modifier les données
		serviceclient.update(clientAmod);
		System.out.println("ADRE-BOUBESS" + adresseMod);
		
		
	      //Recpuration du gerant mise en session dans AuthentificationServlet
				HttpSession session = request.getSession();
				Employer conseillerClient = (Employer) session.getAttribute("employerConnect");

				   //Fabriquer le données à afficher
				List<Client> listClients = new ArrayList<>();
				ClientService clientService = new ClientService();
				listClients = clientService.findClientsDuConseiller(conseillerClient);
		
		
		request.setAttribute("clients", listClients);
		request.setAttribute("modif", true);
		RequestDispatcher dispo = request.getRequestDispatcher("conseiller/listClient.jsp");
	    dispo.forward(request, response);
		
		

	}

}
