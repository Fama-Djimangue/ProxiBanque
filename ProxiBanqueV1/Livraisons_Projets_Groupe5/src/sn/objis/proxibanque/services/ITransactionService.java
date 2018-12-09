package sn.objis.proxibanque.services;

import sn.objis.proxibanque.domaine.Compte;
import sn.objis.proxibanque.domaine.Employer;
import sn.objis.proxibanque.domaine.Transaction;

public interface ITransactionService extends IService<Transaction> {

	public abstract void createTransaction(Transaction transaction, Employer employer);

	public void crediter(Compte compte, double montant);

	public void debiter(Compte compte, double montant);

	public void virementComptACompte(Compte compte1, Compte compte2, double montant);

	public void historiqueDesTransaction(Compte compte);

	public double etatSolde(Compte compte);
	
	public abstract long dernierIdTrans(Transaction transaction);

}
