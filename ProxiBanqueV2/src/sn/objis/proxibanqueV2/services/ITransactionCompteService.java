package sn.objis.proxibanqueV2.services;

import java.util.List;

import sn.objis.proxibanqueV2.dao.IDAO;
import sn.objis.proxibanqueV2.domaine.Client;
import sn.objis.proxibanqueV2.domaine.Compte;
import sn.objis.proxibanqueV2.domaine.Transaction;
import sn.objis.proxibanqueV2.domaine.TransactionCompte;

public interface ITransactionCompteService extends IDAO<TransactionCompte>{

	public abstract List<TransactionCompte> findAllTransactClient(Client client);
	
	public abstract void createTransactionDeb(Transaction transaction, Compte compteDeb);
	
	public abstract void createTransactionCred(Transaction transaction, Compte compteCred);
	
	public abstract void createTransactionVir(Transaction transaction, Compte compteDeb, Compte compteCred);

}
