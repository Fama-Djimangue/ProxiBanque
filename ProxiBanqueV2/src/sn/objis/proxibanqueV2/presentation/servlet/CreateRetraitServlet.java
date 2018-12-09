package sn.objis.proxibanqueV2.presentation.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sn.objis.proxibanqueV2.domaine.Compte;
import sn.objis.proxibanqueV2.domaine.Employer;
import sn.objis.proxibanqueV2.domaine.Transaction;
import sn.objis.proxibanqueV2.domaine.TransactionCompte;
import sn.objis.proxibanqueV2.services.CompteService;
import sn.objis.proxibanqueV2.services.ThreadCompteRetrait;
import sn.objis.proxibanqueV2.services.TransactionCompteService;
import sn.objis.proxibanqueV2.services.TransactionService;
import sn.objis.proxibanqueV2.utils.MethodUtils;

/**
 * Servlet implementation class CreateRetraitServlet
 */
@WebServlet("/createRetrait")
public class CreateRetraitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ThreadCompteRetrait tcr;
	private Compte compte;
	private CompteService compteService = new CompteService();
	private Transaction nveRetrait = null;
	private TransactionService transactionService = new TransactionService();
	private TransactionCompteService transactCptService = new TransactionCompteService();
	private TransactionCompte transactionCompte =null;
	private List<Transaction> list;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateRetraitServlet() {
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
		// Recuperation des donnees saisie au formulaire
		String numcompteRecup = request.getParameter("compte");
		double montantSaisi = Double.parseDouble(request.getParameter("montant"));

		compte = compteService.findByNumero(numcompteRecup);
		double soldeAvant=compte.getSolde_compte();
		double soldcpte = compte.getSolde_compte();

		// Recpuration du gerant mise en session dans AuthentificationServlet
		HttpSession session = request.getSession();
		Employer conseiller = (Employer) session.getAttribute("employerConnect");

		double maxDispo=0;
		if (compte.getSolde_compte()>0){
			maxDispo=compte.getSolde_compte()+compte.getDecouvert();
			
		}else{
			maxDispo=compte.getDecouvert();
		}
			
		if ( maxDispo>= montantSaisi) {
			// Effectuer une nouvelle transaction de type Dépot
			nveRetrait = new Transaction(montantSaisi, "RETRAIT");

			tcr = new ThreadCompteRetrait("ThreadRetrait", compte, montantSaisi);
			tcr.start();
			
			transactionService.createTransaction(nveRetrait, conseiller);

			long idtransact = transactionService.dernierIdTrans(nveRetrait);
			nveRetrait.setId_transact(idtransact);
			
			soldcpte = compte.getSolde_compte() - montantSaisi;
			nveRetrait.setSolde_avant(soldeAvant);
			nveRetrait.setSolde_apres(soldcpte);
			transactCptService.createTransactionDeb(nveRetrait, compte);

		} else {
			request.setAttribute("montant", false);
			montantSaisi=0;
		}		
		list = transactionService.historiqueDesTransaction(compte.getId_compte());
		String type=null;
		String compteRef=null;
		for (Transaction transaction : list) {
			
			if(transaction.getType_transact().equals("VIREMENT")){
				
				transactionCompte = transactCptService.find(transaction.getId_transact());				
					type=MethodUtils.typeVirement(transactionCompte, compte);
					transaction.setType_affich("VIREMENT "+type);
					if (type.equals("RECUE DE")) {
						compteRef = compteService.find(transactionCompte.getId_compte_debiter()).getNumero_compte();
						request.setAttribute("virement", true);
					} else {
						compteRef = compteService.find(transactionCompte.getId_compte_crediter()).getNumero_compte();
					}
					transaction.setCompteRef(compteRef);
			}else {
				transaction.setType_affich(transaction.getType_transact());
			}			
		}

		// mettre solde dans un scope
		request.setAttribute("soldeCompte", soldcpte);
		request.setAttribute("employerConnect", conseiller);
		request.setAttribute("transactions", list);
		request.setAttribute("numCompte", numcompteRecup);

		RequestDispatcher rd = request.getRequestDispatcher("conseiller/listeRelever.jsp");
		rd.forward(request, response);

	}

}
