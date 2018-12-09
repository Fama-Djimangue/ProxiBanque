package sn.objis.proxibanqueV2.services;

import java.util.List;

import sn.objis.proxibanqueV2.dao.DataAccessException;
import sn.objis.proxibanqueV2.dao.TransactionDAO;
import sn.objis.proxibanqueV2.domaine.Compte;
import sn.objis.proxibanqueV2.domaine.Employer;
import sn.objis.proxibanqueV2.domaine.Transaction;

public class TransactionService implements ITransactionService{

	private TransactionDAO transactionDAO = new TransactionDAO();
	
	@Override
	public void createTransaction(Transaction transaction, Employer employer){
		transactionDAO.createTransaction(transaction, employer);
	}
	@Override
	public void create(Transaction transaction) {
		transactionDAO.create(transaction);
		
	}

	@Override
	public Transaction find(long id) {

		return transactionDAO.find(id);
	}

	@Override
	public Transaction find() {

		return transactionDAO.find();
	}

	@Override
	public List<Transaction> findAll() {

		return transactionDAO.findAll();
	}

	@Override
	public Transaction update(Transaction transaction) throws DataAccessException {

		return transactionDAO.update(transaction);
	}

	@Override
	public void delete(Transaction transaction) {
		
		transactionDAO.delete(transaction);
	}

	@Override
	public void delete(long id) {
		transactionDAO.delete(id);
		
	}

	@Override
	public void crediter(Compte compte, double montant) {

		transactionDAO.crediter(compte, montant);
		
	}

	@Override
	public void debiter(Compte compte, double montant) {

		transactionDAO.debiter(compte, montant);
		
	}

	@Override
	public void virementComptACompte(Compte compte1, Compte compte2, double montant) {

		transactionDAO.virementComptACompte(compte1, compte2, montant);
		
	}

	@Override
	public double etatSolde(Compte compte) {

		return transactionDAO.etatSolde(compte);
	}
	@Override
	public long dernierIdTrans(Transaction transaction) {
		// TODO Auto-generated method stub
		return transactionDAO.dernierIdTrans(transaction);
	}
	@Override
	public List<Transaction> historiqueDesTransaction(long idcompte) {
		
		return transactionDAO.historiqueDesTransaction(idcompte);
	}
}
