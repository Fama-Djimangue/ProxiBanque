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

import sn.objis.proxibanqueV2.domaine.Employer;
import sn.objis.proxibanqueV2.services.EmployerService;


/**
 * Servlet implementation class ListUserServlet
 */
@WebServlet("/listConseiller")
public class ListConseillerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Employer> listEmplyers = new ArrayList<>();
	private List<Employer> listConseillers = new ArrayList<>();				
	private EmployerService employerService = new EmployerService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListConseillerServlet() {
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
	protected void traitement(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

				//Donner la main à la page utilisateur.jsp qui va afficher les donner
				RequestDispatcher dispatcher = request.getRequestDispatcher("gerant/listConseillers.jsp");
				dispatcher.forward(request, response);
	}
}
