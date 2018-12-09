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

import sn.objis.proxibanqueV2.domaine.Compte;
import sn.objis.proxibanqueV2.services.ClientService;
import sn.objis.proxibanqueV2.services.CompteService;

/**
 * Servlet implementation class ListeCompteServlet
 */
@WebServlet("/listecompte")
public class ListeCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeCompteServlet() {
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
		
		   long idclientRecup = Long.parseLong(request.getParameter("idclient"));
		  // System.out.println("id :"+idclientRecup);
		   
		   // Récupération du nom du client
	       ClientService clientservice = new ClientService();
	       String nom = clientservice.find(idclientRecup).getPrenom_client() +" "+ clientservice.find(idclientRecup).getNom_client();
	     
		   
		       //Fabriquer le données à afficher
		       List<Compte> listcomptes = new ArrayList<>();
		       CompteService compteservice = new CompteService();
		       
		       String typeCompe=null;
		       
		       
		       listcomptes = compteservice.findByIdClient(idclientRecup);
		       if (listcomptes.size()==1) {
		    	   
		    	   for (Compte compte : listcomptes) {
		    		   typeCompe=compte.getType_compte();
					request.setAttribute("TypeCompte",typeCompe );
				}
		    	  if (typeCompe.equals("EPARGNE")) {
		    		  request.setAttribute("TypeACreer","COURANT" );
		    		  
				}
		    	  if (typeCompe.equals("COURANT")) {
		    		  request.setAttribute("TypeACreer","EPARGNE" );		    		  
				}
			}
		       
		     	       
				//Ajout des données dans un scope
				request.setAttribute("listecomptes", listcomptes);
				request.setAttribute("nomclient", nom);
				request.setAttribute("nbCompte", listcomptes.size());
				request.setAttribute("idclt", idclientRecup);

			     //request.setAttribute("nomclient", nom);

				
				
				//Donner la main à la page utilisateur.jsp qui va afficher les donner
				RequestDispatcher dispatcher = request.getRequestDispatcher("conseiller/listCompte.jsp");
				dispatcher.forward(request, response);
	}
}
