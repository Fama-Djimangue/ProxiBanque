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
 * Servlet implementation class ListClientServlet
 */
@WebServlet("/listeclient")
public class ListClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		traitement(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		traitement(request, response);
	}

	
	protected void traitement(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		//Recpuration du gerant mise en session dans AuthentificationServlet
		HttpSession session = request.getSession();
		Employer conseillerClient = (Employer) session.getAttribute("employerConnect");
System.out.println("Liste client empl "+conseillerClient);
		       //Fabriquer le données à afficher
				List<Client> listClients = new ArrayList<>();
				ClientService clientService = new ClientService();
				listClients = clientService.findClientsDuConseiller(conseillerClient);
				
				System.out.println("Liste conseiller!"+ conseillerClient);		
				//Ajout des données dans un scope
				request.setAttribute("clients", listClients);

				//Donner la main à la page utilisateur.jsp qui va afficher les donner
				RequestDispatcher dispatcher = request.getRequestDispatcher("conseiller/listClient.jsp");
				dispatcher.forward(request, response);
	}
	
}
