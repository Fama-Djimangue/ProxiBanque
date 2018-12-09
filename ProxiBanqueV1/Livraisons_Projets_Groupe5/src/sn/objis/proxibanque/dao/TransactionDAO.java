package sn.objis.proxibanque.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sn.objis.proxibanque.domaine.Compte;
import sn.objis.proxibanque.domaine.Employer;
import sn.objis.proxibanque.domaine.Transaction;
import sn.objis.proxibanque.utils.ConnectionMysql;

public class TransactionDAO implements ITransaction {

	private static Connection connect = ConnectionMysql.getInstance();
	private PreparedStatement prepst;
	private List<Transaction> listeTransaction;

	public void createTransaction(Transaction transaction, Employer employer) {
		String sql ="INSERT INTO transaction(numero_transact, date_transact, montant_transact, type_transact, "
				+ "'"+employer.getId_employer()+"') VALUES(?,?,?,?,?)";
		try {
			prepst= connect.prepareStatement(sql);
			prepst.setString(1, transaction.getNumero_transact());
			prepst.setDate(2, transaction.getDate_transact());
			prepst.setDouble(3, transaction.getMontant_transact());
			prepst.setString(4, transaction.getType_transact());
			
			prepst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public void create(Transaction transaction) {
		String sql ="INSERT INTO transaction(numero_transact, date_transact, montant_transact, type_transact)"
				  + " VALUES(?,?,?,?)";
		try {
			prepst= connect.prepareStatement(sql);
			prepst.setString(1, transaction.getNumero_transact());
			prepst.setDate(2, (Date) transaction.getDate_transact());
			prepst.setDouble(3, transaction.getMontant_transact());
			prepst.setString(4, transaction.getType_transact());
			
			prepst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Transaction find(long id) {
		Transaction transaction = null;
		
		String sql="SELECT * FROM transaction where id_transaction=?";
		try {
			prepst = connect.prepareStatement(sql);
			prepst.setLong(1, id);

			ResultSet resultSet = prepst.executeQuery();
			
			if(resultSet.first()){
				transaction = new Transaction();
				transaction.setId_transact(resultSet.getLong("id_transact"));
				transaction.setNumero_transact(resultSet.getString("numero_transact"));
				transaction.setDate_transact(resultSet.getDate("date_transact"));
				transaction.setMontant_transact(resultSet.getDouble("montant_transact"));
				transaction.setType_transact(resultSet.getString("type_transact"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return transaction;
	}

	@Override
	public Transaction find() {
		Transaction transaction = null;
		
		String sql="SELECT * FROM transaction";
		try {
			prepst = connect.prepareStatement(sql);
	
			ResultSet resultSet = prepst.executeQuery();
			
			if(resultSet.first()){
				transaction = new Transaction();
				
				transaction.setId_transact(resultSet.getLong("id_transact"));
				transaction.setNumero_transact(resultSet.getString("numero_transact"));
				transaction.setDate_transact(resultSet.getDate("date_transact"));
				transaction.setMontant_transact(resultSet.getDouble("montant_transact"));
				transaction.setType_transact(resultSet.getString("type_transact"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return transaction;
	}

	@Override
	public List<Transaction> findAll() {
		listeTransaction = new ArrayList<Transaction>();
		Transaction transaction = null;

		try {
			String sql = "SELECT * FROM transaction";
			prepst = connect.prepareStatement(sql);
			ResultSet resultSet = prepst.executeQuery();

			while (resultSet.next()) {
				transaction = new Transaction();
				transaction.setId_transact(resultSet.getLong("id_transact"));
				transaction.setNumero_transact(resultSet.getString("numero_transact"));
				transaction.setDate_transact(resultSet.getDate("date_transact"));
				transaction.setMontant_transact(resultSet.getDouble("montant_transact"));
				transaction.setType_transact(resultSet.getString("type_transact"));

				listeTransaction.add(transaction);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeTransaction;
	}

	@Override
	public Transaction update(Transaction transaction ) throws DataAccessException {
		if (transaction.getId_transact() < 1)
			throw new DataAccessException("l'identifiant de la transaction ne peut etre inferieur a zero");

		try {

			String sql = "UPDATE Employer SET numero_transact=?, date_transact=?, montant_transact=?, type_transact=?,"
					+ " WHERE id_transact=?";

			prepst = connect.prepareStatement(sql);
			prepst.setString(1, transaction.getNumero_transact());
			prepst.setDate(2, (Date) transaction.getDate_transact());
			prepst.setDouble(3, transaction.getMontant_transact());
			prepst.setString(4, transaction.getType_transact());
	
			transaction = this.find(transaction.getId_transact());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return transaction;

	}

	@Override
	public void delete(Transaction transaction) {
		String sql="DELETE * FROM transaction WHERE id_transact=?";
		try {
			prepst= connect.prepareStatement(sql);
			
			prepst.setLong(1, transaction.getId_transact());
			
			prepst.executeUpdate();
			System.out.println("Transaction supprimé avec succès");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Probleme de requete lors de la suppression");
		}
	}

	@Override
	public void delete(long id) {
		String sql="DELETE * FROM transaction WHERE id_transact=?";
		try {
			prepst= connect.prepareStatement(sql);
			
			prepst.setLong(1, id);
			
			prepst.executeUpdate();
			System.out.println("Transaction supprimé avec succès");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Probleme de requete lors de la suppression");
		}
	}

	@Override
	public void crediter(Compte compte, double montant) {
		double nouveauSolde = compte.getSolde_compte() + montant;

		String sql = "Update compte SET solde_compte=? where numero_compte=?";
		try {
			prepst = connect.prepareStatement(sql);
			prepst.setDouble(1, nouveauSolde);
			prepst.setString(2, compte.getNumero_compte());
			prepst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void debiter(Compte compte, double montant) {
		double soldePlusDecouvert = compte.getSolde_compte() + compte.getDecouvert();
		double nouveauSolde = compte.getSolde_compte() - montant;

		if (soldePlusDecouvert < montant) {
			System.out.println("Vous avez atteint votre découvert autorisé!");

		} else {

			String sql = "Update compte SET solde_compte=? where numero_compte=?";
			try {
				prepst = connect.prepareStatement(sql);
				prepst.setDouble(1, nouveauSolde);
				prepst.setString(2, compte.getNumero_compte());
				prepst.executeUpdate();
				System.out.println("Compte bien débité");
			} catch (SQLException e) {
				System.out.println("Erreur opération débit!");
			}
		}
	}

	@SuppressWarnings("unused")
	@Override
	public void virementComptACompte(Compte compte1, Compte compte2, double montant) {
		double nouveauSolde1 = compte1.getSolde_compte() - montant;
		double nouveauSolde2 = compte2.getSolde_compte() + montant;
		double soldePlusDecouvert1 = compte1.getSolde_compte() + compte1.getDecouvert();
		if (soldePlusDecouvert1 < montant) {
			System.out.println("Vous avez atteint votre découvert autorisé!");
		} else {
			debiter(compte1, montant);
			crediter(compte2, montant);
		}

	}

	@Override
	public void historiqueDesTransaction(Compte compte) {

	}


	@Override
	public double etatSolde(Compte compte) {

		return compte.getSolde_compte();
	}

	@Override
	public long dernierIdTrans(Transaction transaction) {
		long IdTrans = 0;
		PreparedStatement prepst;
		String reqId = "SELECT MAX(id_transact)as dernierTransaction FROM transaction";

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
