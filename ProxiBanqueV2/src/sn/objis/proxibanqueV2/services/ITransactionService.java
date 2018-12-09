package sn.objis.proxibanqueV2.services;

import java.util.List;

import sn.objis.proxibanqueV2.domaine.Compte;
import sn.objis.proxibanqueV2.domaine.Employer;
import sn.objis.proxibanqueV2.domaine.Transaction;

public interface ITransactionService extends IService<Transaction> {

	public abstract void createTransaction(Transaction transaction, Employer employer);

	public void crediter(Compte compte, double montant);

	public void debiter(Compte compte, double montant);

	public void virementComptACompte(Compte compte1, Compte compte2, double montant);

	public double etatSolde(Compte compte);
	
	public abstract long dernierIdTrans(Transaction transaction);
	
	public abstract List<Transaction> historiqueDesTransaction(long idcompte);

}
