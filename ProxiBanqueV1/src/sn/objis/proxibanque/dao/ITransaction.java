package sn.objis.proxibanque.dao;

import sn.objis.proxibanque.domaine.Compte;
import sn.objis.proxibanque.domaine.Employer;
import sn.objis.proxibanque.domaine.Transaction;

public interface ITransaction extends IDAO<Transaction> {

	public abstract void createTransaction(Transaction transaction, Employer employer);

	public abstract void crediter(Compte compte, double montant);

	public abstract void debiter(Compte compte, double montant);

	public abstract void virementComptACompte(Compte compte1, Compte compte2, double montant);

	public abstract void historiqueDesTransaction(Compte compte);

	public abstract double etatSolde(Compte compte);

	public abstract long dernierIdTrans(Transaction transaction);
}
