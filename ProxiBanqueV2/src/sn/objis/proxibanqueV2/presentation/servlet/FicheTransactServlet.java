package sn.objis.proxibanqueV2.presentation.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.objis.proxibanqueV2.domaine.Compte;
import sn.objis.proxibanqueV2.domaine.Transaction;
import sn.objis.proxibanqueV2.services.CompteService;
import sn.objis.proxibanqueV2.services.ThreadCompteDepot;
import sn.objis.proxibanqueV2.services.ThreadCompteRetrait;
import sn.objis.proxibanqueV2.services.TransactionCompteService;
import sn.objis.proxibanqueV2.services.TransactionService;

/**
 * Servlet implementation class FicheTransactServlet
 */
@WebServlet("/ficheTransact")
public class FicheTransactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ThreadCompteDepot tcd;
	private ThreadCompteRetrait tcr;
	private Compte compte;
	private CompteService compteService = new CompteService();
	private Transaction transactionSelect = null;
	private TransactionService transactionService = new TransactionService();
	private TransactionCompteService transactCptService = new TransactionCompteService();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FicheTransactServlet() {
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
		//Recuperation des donnees saisie SUR L'url
		long idTransact=Long.parseLong(request.getParameter("idTransact"));
		
		transactionSelect=transactionService.find(idTransact);
		request.setAttribute("transactAModif", transactionSelect);
		RequestDispatcher rd = request.getRequestDispatcher("conseiller/ficheTransact.jsp");
		
		rd.forward(request, response);
	}
		
		
}
