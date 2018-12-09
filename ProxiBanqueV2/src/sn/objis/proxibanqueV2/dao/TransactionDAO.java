package sn.objis.proxibanqueV2.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sn.objis.proxibanqueV2.domaine.Compte;
import sn.objis.proxibanqueV2.domaine.Employer;
import sn.objis.proxibanqueV2.domaine.Transaction;
import sn.objis.proxibanqueV2.utils.ConnectionMySqlDataSourceDBCP;
import sn.objis.proxibanqueV2.utils.MethodUtils;

public class TransactionDAO implements ITransaction {

	private static Connection connect = ConnectionMySqlDataSourceDBCP.getInstance();
	private PreparedStatement prepst;
	private List<Transaction> listeTransaction;

	public void createTransaction(Transaction transaction, Employer employer) {
		String sql = "INSERT INTO transaction(numero_transact,montant_transact, type_transact,id_employer) VALUES(?,?,?, "
				+ "'" + employer.getId_employer() + "')";

		long idcompte = this.dernierIdTrans(transaction) + 1;

		transaction.setNumero_transact(MethodUtils.genererNumero(idcompte, transaction.getType_transact()));

		try {
			prepst = connect.prepareStatement(sql);
			prepst.setString(1, transaction.getNumero_transact());
			prepst.setDouble(2, transaction.getMontant_transact());
			prepst.setString(3, transaction.getType_transact());

			prepst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void create(Transaction transaction) {
		String sql = "INSERT INTO transaction(numero_transact, date_transact, montant_transact, type_transact)"
				+ " VALUES(?,?,?,?)";
		try {
			prepst = connect.prepareStatement(sql);
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

		String sql = "SELECT * FROM transaction where id_transact=?";
		try {
			prepst = connect.prepareStatement(sql);
			prepst.setLong(1, id);

			ResultSet resultSet = prepst.executeQuery();

			if (resultSet.first()) {
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

		String sql = "SELECT * FROM transaction";
		try {
			prepst = connect.prepareStatement(sql);

			ResultSet resultSet = prepst.executeQuery();

			if (resultSet.first()) {
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
	public List<Transaction> historiqueDesTransaction(long idcompte) {
		listeTransaction = new ArrayList<Transaction>();
		Transaction transaction = null;
		try {
			String sql = "SELECT DISTINCT * FROM transaction a, transact_compte b where a.id_transact=b.id_transact and (b.id_compte_debiter=? or b.id_compte_crediter=?)";
			prepst = connect.prepareStatement(sql);
			prepst.setLong(1, idcompte);
			prepst.setLong(2, idcompte);
			ResultSet resultSet = prepst.executeQuery();

			while (resultSet.next()) {
				transaction = new Transaction();
				transaction.setId_transact(resultSet.getLong("id_transact"));
				transaction.setNumero_transact(resultSet.getString("numero_transact"));
				transaction.setDate_transact(resultSet.getDate("date_transact"));
				transaction.setMontant_transact(resultSet.getDouble("montant_transact"));
				transaction.setType_transact(resultSet.getString("type_transact"));

				if (transaction.getType_transact().equals("VIREMENT")) {
						transaction.setSolde_avant(resultSet.getDouble("solde_avant"));
						transaction.setSolde_apres(resultSet.getDouble("solde_apres"));
						transaction.setSolde_avant_cred(resultSet.getDouble("solde_avant_cred"));
						transaction.setSolde_apres_cred(resultSet.getDouble("solde_apres_cred"));
					}else{
						transaction.setSolde_avant(resultSet.getDouble("solde_avant"));
						transaction.setSolde_apres(resultSet.getDouble("solde_apres"));
					}								
				listeTransaction.add(transaction);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listeTransaction;
	}

	@Override
	public Transaction update(Transaction transaction) throws DataAccessException {
		if (transaction.getId_transact() < 1)
			throw new DataAccessException("l'identifiant de la transaction ne peut etre inferieur a zero");

		try {

			String sql = "UPDATE transaction SET solde_avant=?, solde_apres=?, solde_avant_cred=?,"
					+ " solde_apres_cred=? WHERE id_transact=?";

			prepst = connect.prepareStatement(sql);
			prepst.setDouble(1, transaction.getSolde_avant());
			prepst.setDouble(2, transaction.getSolde_apres());
			prepst.setDouble(3, transaction.getSolde_avant_cred());
			prepst.setDouble(4, transaction.getSolde_apres_cred());
			prepst.setLong(5, transaction.getId_transact());
			prepst.executeUpdate();
			transaction = this.find(transaction.getId_transact());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return transaction;


	}

	@Override
	public void delete(Transaction transaction) {
		String sql = "DELETE * FROM transaction WHERE id_transact=?";
		try {
			prepst = connect.prepareStatement(sql);

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
		String sql = "DELETE * FROM transaction WHERE id_transact=?";
		try {
			prepst = connect.prepareStatement(sql);

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
		double decouvertMaj = compte.getDecouvert();
		double decouvertAutoriser = 1000;
		// Remboursement du découvert du
		if (compte.getSolde_compte() < 0) {
			System.out.println("Depot  avec un solde négatif");
			if (nouveauSolde > 0) {
				decouvertMaj = decouvertAutoriser;
			} else {
				decouvertMaj = compte.getDecouvert() + montant;

			}
		}

		String sql = "Update compte SET solde_compte=?, decouvert=? where numero_compte=?";
		try {
			prepst = connect.prepareStatement(sql);
			prepst.setDouble(1, nouveauSolde);
			prepst.setDouble(2, decouvertMaj);
			prepst.setString(3, compte.getNumero_compte());
			prepst.executeUpdate();
			System.out.println("Compte bien créditer");
		} catch (SQLException e) {
			System.out.println("Erreur Opération crédit");
			e.printStackTrace();
		}

	}

	@Override
	public void debiter(Compte compte, double montant) {
		double maxDispo = 0;
		double soldePlusDecouvert = compte.getSolde_compte() + compte.getDecouvert();
		double nouveauSolde = compte.getSolde_compte() - montant;
		double decouvertMaj = compte.getDecouvert();
		if (compte.getSolde_compte() > 0) {
			maxDispo = soldePlusDecouvert;

		} else {
			maxDispo = compte.getDecouvert();
		}
		if (maxDispo < montant) {
			System.out.println("Vous avez atteint votre découvert autorisé!");

		} else {//ici un retrait peut etre effectué
			if (compte.getSolde_compte() > 0) {
				
				if (montant > compte.getSolde_compte())
					decouvertMaj = compte.getDecouvert() + nouveauSolde;
			} else
				decouvertMaj = compte.getDecouvert() - montant;

			String sql = "Update compte SET solde_compte=?,decouvert=? where numero_compte=?";
			try {
				prepst = connect.prepareStatement(sql);
				prepst.setDouble(1, nouveauSolde);
				prepst.setDouble(2, decouvertMaj);
				prepst.setString(3, compte.getNumero_compte());
				prepst.executeUpdate();
				System.out.println("Compte bien débité");
			} catch (SQLException e) {
				System.out.println("Erreur opération débit!");
			}
		}
	}

	@SuppressWarnings("unused")
	@Override
	public void virementComptACompte(Compte compteDeb, Compte compteCred, double montant) {
		double nouveauSolde1 = compteDeb.getSolde_compte() - montant;
		double nouveauSolde2 = compteCred.getSolde_compte() + montant;
		double soldePlusDecouvert1 = compteDeb.getSolde_compte() + compteDeb.getDecouvert();
		if (soldePlusDecouvert1 < montant) {
			System.out.println("Vous avez atteint votre découvert autorisé!");
		} else {
			debiter(compteDeb, montant);
			crediter(compteCred, montant);
		}

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
