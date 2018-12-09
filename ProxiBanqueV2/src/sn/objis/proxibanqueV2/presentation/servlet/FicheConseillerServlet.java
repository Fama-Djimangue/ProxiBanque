package sn.objis.proxibanqueV2.presentation.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.objis.proxibanqueV2.domaine.CompteUtilisateur;
import sn.objis.proxibanqueV2.domaine.Employer;
import sn.objis.proxibanqueV2.services.CompteUtilisateurService;
import sn.objis.proxibanqueV2.services.EmployerService;

/**
 * Servlet implementation class FicheConseillerServlet
 */
@WebServlet("/ficheConseiller")
public class FicheConseillerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Employer conseillerSelect = null;
	private EmployerService employerService = new EmployerService();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FicheConseillerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recuperation de l'identifiant du patient selectionné
				String idRecup = request.getParameter("idConseiller");
				long idConseiller = Long.parseLong(idRecup);
				
				conseillerSelect= employerService.find(idConseiller);
				request.setAttribute("conseillerAmodifier", conseillerSelect);
				//request.setAttribute("conseillers", employerService.findAll());

				RequestDispatcher rd = request.getRequestDispatcher("/gerant/ficheConseiller.jsp");
				
				rd.forward(request, response);
				// donnees
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		


	}

}
