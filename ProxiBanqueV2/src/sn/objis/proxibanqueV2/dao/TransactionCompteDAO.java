package sn.objis.proxibanqueV2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sn.objis.proxibanqueV2.domaine.Client;
import sn.objis.proxibanqueV2.domaine.Compte;
import sn.objis.proxibanqueV2.domaine.Transaction;
import sn.objis.proxibanqueV2.domaine.TransactionCompte;
import sn.objis.proxibanqueV2.utils.ConnectionMySqlDataSourceDBCP;

public class TransactionCompteDAO implements ITransactionCompte {

	private static Connection connect = ConnectionMySqlDataSourceDBCP.getInstance();
	private PreparedStatement prepst;
	private List<TransactionCompte> listeTransactionCompte;
	private TransactionDAO transactionDAO = new TransactionDAO();
	/*
	 * @Override public void createTransaction(Transaction transaction, Compte
	 * compte) { String sql =
	 * "INSERT INTO transact_compte(id_transact, id_compte) VALUES ('" +
	 * transaction.getId_transact() + "'," + "'" + compte.getId_compte() + "')";
	 * 
	 * try { prepst = connect.prepareStatement(sql); prepst.executeUpdate();
	 * 
	 * System.out.println("TransactionCompte effectif!"); } catch (SQLException
	 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * 
	 * }
	 */

	@Override
	public void createTransactionCred(Transaction transaction, Compte compteCred) {
		String sql = "INSERT INTO transact_compte(id_transact, id_compte_crediter) VALUES ('" + transaction.getId_transact()
				+ "'," + "'" + compteCred.getId_compte() + "')";

		try {
			prepst = connect.prepareStatement(sql);
			prepst.executeUpdate();
			transactionDAO.update(transaction);
		} catch (SQLException | DataAccessException e) {
			
			e.printStackTrace();
		}

	}

	@Override
	public void createTransactionDeb(Transaction transaction, Compte compteDeb) {
		String sql = "INSERT INTO transact_compte(id_transact, id_compte_debiter) VALUES ('"
				+ transaction.getId_transact() + "'," + "'" + compteDeb.getId_compte() + "')";

		try {
			prepst = connect.prepareStatement(sql);
			prepst.executeUpdate();
			transactionDAO.update(transaction);
		} catch (SQLException | DataAccessException e) {
			
			e.printStackTrace();
		}

	}

	@Override
	public void createTransactionVir(Transaction transaction, Compte compteDeb, Compte compteCred) {
		String sql = "INSERT INTO transact_compte(id_transact, id_compte_debiter, id_compte_crediter) VALUES ('"
				+ transaction.getId_transact() + "','" + compteDeb.getId_compte() + "','" + compteCred.getId_compte()
				+ "')";

		try {
			prepst = connect.prepareStatement(sql);
			prepst.executeUpdate();
			transactionDAO.update(transaction);
		} catch (SQLException | DataAccessException e) {
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
				transactionCompte = new TransactionCompte();
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
			String sql = "SELECT * FROM transact_compte WHERE id_compte in (SELECT * FROM compte WHERE" + "id_client='"
					+ client.getId_client() + "')";
			prepst = connect.prepareStatement(sql);
			ResultSet rs = prepst.executeQuery();

			while (rs.next()) {
				transaction = new Transaction();
				compte = new Compte();
				transactionCompte = new TransactionCompte();
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
		TransactionCompte transactionCompte= null;

		String sql = "SELECT * FROM transact_compte where id_transact=?";
		try {
			prepst = connect.prepareStatement(sql);
			prepst.setLong(1, id);

			ResultSet resultSet = prepst.executeQuery();

			if (resultSet.first()) {
				transactionCompte = new TransactionCompte();
				transactionCompte.setId_transact(resultSet.getLong("id_transact"));
				transactionCompte.setId_compte_debiter(resultSet.getLong("id_compte_debiter"));
				transactionCompte.setId_compte_crediter(resultSet.getLong("id_compte_crediter"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return transactionCompte;

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
	public long dernierIdTransCpt(TransactionCompte transactionCompte) {
		long IdTrans = 0;
		PreparedStatement prepst;
		String reqId = "SELECT MAX(id_transact)as dernierTransaction FROM transact_compte";

		try {
			prepst = connect.prepareStatement(reqId);
			ResultSet rs = prepst.executeQuery();

			if (rs.first()) {
				IdTrans = rs.getLong("dernierTransaction");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return IdTrans;
	}

}
