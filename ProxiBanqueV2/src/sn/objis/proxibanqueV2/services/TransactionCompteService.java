package sn.objis.proxibanqueV2.services;

import java.util.List;

import sn.objis.proxibanqueV2.dao.DataAccessException;
import sn.objis.proxibanqueV2.dao.TransactionCompteDAO;
import sn.objis.proxibanqueV2.domaine.Client;
import sn.objis.proxibanqueV2.domaine.Compte;
import sn.objis.proxibanqueV2.domaine.Transaction;
import sn.objis.proxibanqueV2.domaine.TransactionCompte;

public class TransactionCompteService implements ITransactionCompteService{

	private TransactionCompteDAO transactionCompteDAO = new TransactionCompteDAO();
	@Override
	public void create(TransactionCompte t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TransactionCompte find(long id) {
		// TODO Auto-generated method stub
		return transactionCompteDAO.find(id);
	}

	@Override
	public TransactionCompte find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransactionCompte> findAll() {
		// TODO Auto-generated method stub
		return transactionCompteDAO.findAll();
	}

	@Override
	public TransactionCompte update(TransactionCompte t) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(TransactionCompte t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<TransactionCompte> findAllTransactClient(Client client) {
		// TODO Auto-generated method stub
		return transactionCompteDAO.findAllTransactClient(client);
	}

	@Override
	public void createTransactionDeb(Transaction transaction, Compte compteDeb) {
		transactionCompteDAO.createTransactionDeb(transaction, compteDeb);
		
	}

	@Override
	public void createTransactionCred(Transaction transaction, Compte compteCred) {
		transactionCompteDAO.createTransactionCred(transaction, compteCred);

		
	}

	@Override
	public void createTransactionVir(Transaction transaction, Compte compteDeb, Compte compteCred) {
		transactionCompteDAO.createTransactionVir(transaction, compteDeb, compteCred);
		
	}

}
