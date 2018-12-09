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
import sn.objis.proxibanqueV2.domaine.Transaction;
import sn.objis.proxibanqueV2.domaine.TransactionCompte;
import sn.objis.proxibanqueV2.services.CompteService;
import sn.objis.proxibanqueV2.services.TransactionCompteService;
import sn.objis.proxibanqueV2.services.TransactionService;
import sn.objis.proxibanqueV2.utils.MethodUtils;

/**
 * Servlet implementation class ListTransactServlet
 */
@WebServlet("/relevercompte")
public class ReleverCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Transaction> listTransacts = new ArrayList<>();
	private Compte compte = null;
	private CompteService compteService = new CompteService();
	private TransactionService transactionService = new TransactionService();
	private TransactionCompte transactionCompte = null;
	private TransactionCompteService transactionCompteService = new TransactionCompteService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReleverCompteServlet() {
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

	protected void traitement(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long idCompteRecup = Long.parseLong(request.getParameter("idCompte"));
		compte = compteService.find(idCompteRecup);

		String type = null;
		String compteRef = null;
		System.out.println("id Compte trans :" + idCompteRecup);
		// Fabriquer le données à afficher
		listTransacts = transactionService.historiqueDesTransaction(idCompteRecup);
		for (Transaction transaction : listTransacts) {

			if (transaction.getType_transact().equals("VIREMENT")) {

				transactionCompte = transactionCompteService.find(transaction.getId_transact());
				type = MethodUtils.typeVirement(transactionCompte, compte);
				transaction.setType_affich("VIREMENT " + type);
				if (type.equals("RECUE DE")) {
					compteRef = compteService.find(transactionCompte.getId_compte_debiter()).getNumero_compte();
					request.setAttribute("virement", true);
				} else {
					compteRef = compteService.find(transactionCompte.getId_compte_crediter()).getNumero_compte();
				}
				transaction.setCompteRef(compteRef);
			} else {
				transaction.setType_affich(transaction.getType_transact());
			}
		}

		// Ajout des données dans un scope
		request.setAttribute("transactions", listTransacts);

		// Récupération numero compte
		String numcomtpe = compteService.find(idCompteRecup).getNumero_compte();

		// Récupération solde compte
		double soldcpte = compteService.find(idCompteRecup).getSolde_compte();

		// mettre numero compte dans un scope
		request.setAttribute("numCompte", numcomtpe);

		// mettre solde dans un scope
		request.setAttribute("soldeCompte", soldcpte);

		// Donner la main à la page utilisateur.jsp qui va afficher les donner
		RequestDispatcher dispatcher = request.getRequestDispatcher("conseiller/listeRelever.jsp");
		dispatcher.forward(request, response);

	}
}
