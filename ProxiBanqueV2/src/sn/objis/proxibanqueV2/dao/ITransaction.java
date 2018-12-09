package sn.objis.proxibanqueV2.dao;

import java.util.List;

import sn.objis.proxibanqueV2.domaine.Compte;
import sn.objis.proxibanqueV2.domaine.Employer;
import sn.objis.proxibanqueV2.domaine.Transaction;

public interface ITransaction extends IDAO<Transaction> {

	public abstract void createTransaction(Transaction transaction, Employer employer);

	public abstract void crediter(Compte compte, double montant);

	public abstract void debiter(Compte compte, double montant);

	public abstract void virementComptACompte(Compte compte1, Compte compte2, double montant);

	public abstract double etatSolde(Compte compte);

	public abstract long dernierIdTrans(Transaction transaction);
	
	public abstract List<Transaction> historiqueDesTransaction(long idcompte);
	
}
