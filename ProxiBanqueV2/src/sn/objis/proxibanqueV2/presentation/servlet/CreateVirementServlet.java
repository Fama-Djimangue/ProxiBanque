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
import sn.objis.proxibanqueV2.services.ThreadCompteVirement;
import sn.objis.proxibanqueV2.services.TransactionCompteService;
import sn.objis.proxibanqueV2.services.TransactionService;
import sn.objis.proxibanqueV2.utils.MethodUtils;

/**
 * Servlet implementation class CreateVirementServlet
 */
@WebServlet("/createVirement")
public class CreateVirementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ThreadCompteVirement tcv;
	private Compte compteDebit = null, compteCredit = null;
	private CompteService compteService = new CompteService();
	private Transaction nveVirement = null;
	private TransactionService transactionService = new TransactionService();
	private TransactionCompteService transactCptService = new TransactionCompteService();
	private TransactionCompte transactionCompte =null;
	private List<Transaction> list;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateVirementServlet() {
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

		String cptDebRecup = request.getParameter("cptDeb");
		String cptCredSaisi = request.getParameter("cptCred");
		double montantSaisi = Double.parseDouble(request.getParameter("montant"));

		// Recpuration du gerant mise en session dans AuthentificationServlet
		HttpSession session = request.getSession();
		Employer conseiller = (Employer) session.getAttribute("employerConnect");
System.out.println("EMP VIR "+conseiller);
		compteDebit = compteService.findByNumero(cptDebRecup);
		double soldeAvantDeb=compteDebit.getSolde_compte();
		double soldcptDeb = compteDebit.getSolde_compte();

		// Vérifier si le compte à créditer saisi existe
		compteCredit = compteService.findByNumero(cptCredSaisi);
		double soldeAvantCred=compteCredit.getSolde_compte();
		double soldcptCred = compteCredit.getSolde_compte()+montantSaisi;


		double maxDispo=0;
		if (compteDebit.getSolde_compte()>0){
			maxDispo=compteDebit.getSolde_compte()+compteDebit.getDecouvert();
			
		}else{
			maxDispo=compteDebit.getDecouvert();
		}
		// Effectuer une nouvelle transaction de type Dépot
		if (compteCredit != null && maxDispo >= montantSaisi) {

			nveVirement = new Transaction(montantSaisi, "VIREMENT");

			tcv = new ThreadCompteVirement("ThreadVirement", compteDebit, compteCredit, montantSaisi);
			tcv.start();

			transactionService.createTransaction(nveVirement, conseiller);
			long idtransact = transactionService.dernierIdTrans(nveVirement);
			nveVirement.setId_transact(idtransact);
			
			soldcptDeb = compteDebit.getSolde_compte()- montantSaisi;
			nveVirement.setSolde_avant(soldeAvantDeb);
			nveVirement.setSolde_apres(soldcptDeb);
			nveVirement.setSolde_avant_cred(soldeAvantCred);
			nveVirement.setSolde_apres_cred(soldcptCred);
			transactCptService.createTransactionVir(nveVirement, compteDebit,compteCredit);
			

		}
		if (maxDispo < montantSaisi) {
			request.setAttribute("montant", false);
			montantSaisi=0;
		}
		if (compteCredit == null) {
			montantSaisi=0;
			request.setAttribute("compte", false);
		}
		
		list = transactionService.historiqueDesTransaction(compteDebit.getId_compte());
		String type=null;
		String compteRef=null;
		for (Transaction transaction : list) {
			
			if(transaction.getType_transact().equals("VIREMENT")){				
				transactionCompte = transactCptService.find(transaction.getId_transact());				
					type=MethodUtils.typeVirement(transactionCompte, compteDebit);
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
		
		//mettre solde dans un scope
		request.setAttribute("soldeCompte", soldcptDeb);
		request.setAttribute("employerConnect", conseiller);
		request.setAttribute("transactions", list);
		request.setAttribute("numCompte", cptDebRecup);

		RequestDispatcher rd = request.getRequestDispatcher("conseiller/listeRelever.jsp");
		rd.forward(request, response);

	}
}
