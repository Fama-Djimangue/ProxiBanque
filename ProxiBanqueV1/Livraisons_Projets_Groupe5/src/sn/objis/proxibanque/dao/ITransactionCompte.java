package sn.objis.proxibanque.dao;

import java.util.List;

import sn.objis.proxibanque.domaine.Client;
import sn.objis.proxibanque.domaine.Compte;
import sn.objis.proxibanque.domaine.Transaction;
import sn.objis.proxibanque.domaine.TransactionCompte;

public interface ITransactionCompte extends IDAO<TransactionCompte> {

	public abstract void createTransaction(Transaction transaction, Compte compte);

	public List<TransactionCompte> findAllTransactClient(Client client);

}
