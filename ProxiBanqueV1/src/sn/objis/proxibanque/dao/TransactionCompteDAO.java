package sn.objis.proxibanque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sn.objis.proxibanque.domaine.Client;
import sn.objis.proxibanque.domaine.Compte;
import sn.objis.proxibanque.domaine.Transaction;
import sn.objis.proxibanque.domaine.TransactionCompte;
import sn.objis.proxibanque.utils.ConnectionMysql;

public class TransactionCompteDAO implements ITransactionCompte {

	private static Connection connect = ConnectionMysql.getInstance();
	private PreparedStatement prepst;
	private List<TransactionCompte> listeTransactionCompte;

	@Override
	public void createTransaction(Transaction transaction, Compte compte) {
		String sql = "INSERT INTO transact_compte(id_transact, id_compte) VALUES ('" + transaction.getId_transact()
				+ "'," + "'" + compte.getId_compte() + "')";

		try {
			prepst = connect.prepareStatement(sql);
			prepst.executeUpdate();
			
			System.out.println("TransactionCompte effectif!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<TransactionCompte> findAll() {

		listeTransactionCompte = new ArrayList<TransactionCompte>();
		TransactionCompte transactionCompte;
		Transaction transaction = null;
		Compte compte = null;

		try {
			String sql = "SELECT * FROM transact_compte";
			prepst = connect.prepareStatement(sql);
			ResultSet rs = prepst.executeQuery();

			while (rs.next()) {
				transaction = new Transaction();
				compte = new Compte();
				transactionCompte= new TransactionCompte();
				transaction.setId_transact(rs.getLong("id_transact"));
				compte.setId_compte(rs.getLong("id_compte"));

				listeTransactionCompte.add(transactionCompte);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeTransactionCompte;
	}

	@Override
	public List<TransactionCompte> findAllTransactClient(Client client) {

		listeTransactionCompte = new ArrayList<TransactionCompte>();
		TransactionCompte transactionCompte;
		Transaction transaction = null;
		Compte compte = null;
		
		try {
			String sql = "SELECT * FROM transact_compte WHERE id_compte in (SELECT * FROM compte WHERE"
					+ "id_client='"+client.getId_client()+"')";
			prepst = connect.prepareStatement(sql);
			ResultSet rs = prepst.executeQuery();

			while (rs.next()) {
				transaction = new Transaction();
				compte = new Compte();
				transactionCompte= new TransactionCompte();
				transaction.setId_transact(rs.getLong("id_transact"));
				compte.setId_compte(rs.getLong("id_compte"));

				listeTransactionCompte.add(transactionCompte);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeTransactionCompte;
	}		
		
		

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

}
