package sn.objis.proxibanque.services;

import java.util.List;

import sn.objis.proxibanque.dao.DataAccessException;
import sn.objis.proxibanque.dao.TransactionCompteDAO;
import sn.objis.proxibanque.domaine.Client;
import sn.objis.proxibanque.domaine.Compte;
import sn.objis.proxibanque.domaine.Transaction;
import sn.objis.proxibanque.domaine.TransactionCompte;

public class TransactionCompteServive implements ITransactionCompteService{

	private TransactionCompteDAO transactionCompteDAO = new TransactionCompteDAO();
	@Override
	public void create(TransactionCompte t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TransactionCompte find(long id) {
		// TODO Auto-generated method stub
		return null;
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
	public void createTransaction(Transaction transaction, Compte compte) {
		transactionCompteDAO.createTransaction(transaction, compte);
		
	}

	@Override
	public List<TransactionCompte> findAllTransactClient(Client client) {
		// TODO Auto-generated method stub
		return transactionCompteDAO.findAllTransactClient(client);
	}

}
