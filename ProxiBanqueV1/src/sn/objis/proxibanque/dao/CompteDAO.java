package sn.objis.proxibanque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sn.objis.proxibanque.domaine.Client;
import sn.objis.proxibanque.domaine.Compte;
import sn.objis.proxibanque.utils.ConnectionMysql;


public class CompteDAO implements ICompteDAO {

	final static Connection connect = ConnectionMysql.getInstance();
	private PreparedStatement prepst;
	private List<Compte> listecompte;

	
	public void create(Compte compte, Client client) {

		try {
			String sql = "INSERT INTO compte (numero_compte, solde_compte,"
					+ " type_compte, decouvert, taux_remuneration,id_client) VALUES (?,?,?,?,"
					+ "?,'"+ client.getId_client() + "')";

			prepst = connect.prepareStatement(sql);
			prepst.setString(1, compte.getNumero_compte());
			prepst.setDouble(2, compte.getSolde_compte());
			prepst.setString(3, compte.getType_compte());
			if(compte.getType_compte()=="COURANT"){
				prepst.setDouble(4, 10000);
				prepst.setDouble(5, compte.getTaux_remuneration());
			}

			if(compte.getType_compte()=="EPARGNE"){
				prepst.setDouble(4, compte.getDecouvert());
				prepst.setDouble(5, 0.03);
			}
			prepst.executeUpdate();

			System.out.println("Insertion Réussie!");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Echec insertion!");
		}

	}

	
	@Override
	public void create(Compte compte) {
		
		try {
			String sql = "INSERT INTO compte (numero_compte, solde_compte, date_ouverture, date_fermeture,"
					+ " type_compte, decouvert, taux_remuneration) VALUES(?,?,?,?,?,?,?)";
			prepst = connect.prepareStatement(sql);

			prepst.setString(1, compte.getNumero_compte());
			prepst.setDouble(2, compte.getSolde_compte());
			prepst.setDate(3, compte.getDate_ouverture());
			prepst.setDate(4, compte.getDate_fermeture());
			prepst.setString(5, compte.getType_compte());
			prepst.setDouble(6, compte.getDecouvert());
			prepst.setDouble(7, compte.getTaux_remuneration());
			//prepst.setDouble(8, compte.getClient().getId_client());
			
			prepst.executeUpdate();
			System.out.println("Insertion Réussie!");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Echec insertion!");
		}

	}

	@Override
	public Compte find(long id) {
		Compte compteTrouve = null;
		try {
			String sql = "SELECT * FROM compte WHERE numero_Compte=?";
			prepst = connect.prepareStatement(sql);

			prepst.setLong(1, id);
			ResultSet rs = prepst.executeQuery();
			if (rs.first()) {
				compteTrouve = new Compte();
				compteTrouve.setNumero_compte(rs.getString("numero_Compte"));
				compteTrouve.setSolde_compte(rs.getDouble("solde_compte"));
				compteTrouve.setDate_ouverture(rs.getDate("date_ouverture"));
				compteTrouve.setDate_fermeture(rs.getDate("date_fermeture"));
				compteTrouve.setType_compte(rs.getString("type_compte"));
				compteTrouve.setDecouvert(rs.getDouble("decouvert"));
				compteTrouve.setTaux_remuneration(rs.getDouble("taux_remuneration"));

				System.out.println("Compte trouvé avec succès");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Problème dans la requete de recherche");
		}

		return compteTrouve;
	}

	@Override
	public Compte find() {
		Compte compteTrouve = null;
		try {
			String sql = "SELECT * FROM compte";
			prepst = connect.prepareStatement(sql);

			ResultSet rs = prepst.executeQuery();
			if (rs.first()) {
				compteTrouve = new Compte();
				compteTrouve.setNumero_compte(rs.getString("numero_Compte"));
				compteTrouve.setSolde_compte(rs.getDouble("solde_compte"));
				compteTrouve.setDate_ouverture(rs.getDate("date_ouverture"));
				compteTrouve.setDate_fermeture(rs.getDate("date_fermeture"));
				compteTrouve.setType_compte(rs.getString("type_compte"));
				compteTrouve.setDecouvert(rs.getDouble("decouvert"));
				compteTrouve.setTaux_remuneration(rs.getDouble("taux_remuneration"));

				System.out.println("Compte trouvé avec succès");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Problème dans la requete de recherche");
		}

		return compteTrouve;

	}

	@Override
	public Compte update(Compte compte) throws DataAccessException {
		if (compte.getId_compte() < 1)
			throw new DataAccessException("l'identifiant du compte ne peut etre inferieur a zero");

		try {
			
			String sql = "UPDATE compte SET numero_compte=?, solde_compte=?, date_ouverture=?, date_ouverture=?, "
					+ "date_fermeture=?,type_compte=?, decouvert=?, taux_remuneration=? WHERE id_compte=?";
			prepst = connect.prepareStatement(sql);

			prepst.setString(1, compte.getNumero_compte());
			prepst.setDouble(2, compte.getSolde_compte());
			prepst.setDate(3, compte.getDate_ouverture());
			prepst.setDate(4, compte.getDate_fermeture());
			prepst.setString(5, compte.getType_compte());
			prepst.setDouble(6, compte.getDecouvert());
			prepst.setDouble(7, compte.getTaux_remuneration());
			prepst.setLong(8, compte.getId_compte());
			
			prepst.executeUpdate();
			System.out.println("Mise à jour effectuée avec succès");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Problème de requete lors dela mise à jour");
		}

		return compte;
	}

	@Override
	public void delete(Compte compte) {
		try {
			String sql = "DELETE FROM compte WHERE numero_compte=?";
			prepst = connect.prepareStatement(sql);
			prepst.setString(1, compte.getNumero_compte());

			prepst.executeUpdate();
			System.out.println("Compte supprimé avec succès");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Probleme de requete lors de la suppression");
		}

	}

	@Override
	public void delete(long id) {
		try {
			String sql = "DELETE FROM compte WHERE id_compte=?";
			prepst = connect.prepareStatement(sql);
			prepst.setLong(1, id);

			prepst.executeUpdate();
			System.out.println("Compte supprimé avec succès");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Probleme de requete lors de la suppression");
		}
	}

	@Override
	public List<Compte> findAll() {
		listecompte = new ArrayList<Compte>();
		Compte compte = null;

		try {
			String sql = "SELECT * FROM compte";
			prepst = connect.prepareStatement(sql);
			ResultSet rs = prepst.executeQuery();

			while (rs.next()) {

				compte = new Compte();
				compte.setNumero_compte(rs.getString("numero_Compte"));
				compte.setSolde_compte(rs.getDouble("solde_compte"));
				compte.setDate_ouverture(rs.getDate("date_ouverture"));
				compte.setType_compte(rs.getString("type_compte"));
				compte.setTaux_remuneration(rs.getDouble("taux_remuneration"));
				compte.setDate_fermeture(rs.getDate("date_fermeture"));				
				compte.setDecouvert(rs.getDouble("decouvert"));
				

				listecompte.add(compte);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listecompte;
	}

	
	@Override
	public Compte findByNumero(String numero) {
		Compte compteTrouve = null;
		try {
			String sql = "SELECT * FROM compte WHERE numero_compte=?";
			prepst = connect.prepareStatement(sql);

			prepst.setString(1, numero);
			ResultSet rs = prepst.executeQuery();
			if (rs.first()) {
				
				compteTrouve = new Compte();
				compteTrouve.setId_compte(rs.getLong("id_compte"));
				compteTrouve.setNumero_compte(rs.getString("numero_compte"));
				compteTrouve.setSolde_compte(rs.getDouble("solde_compte"));
				compteTrouve.setType_compte(rs.getString("type_compte"));
				compteTrouve.setTaux_remuneration(rs.getDouble("taux_remuneration"));
				compteTrouve.setDecouvert(rs.getDouble("decouvert"));
				
				System.out.println("compte trouvé avec succès");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Problème dans la requete de recherche");
		}
		return compteTrouve;
	}
	
	@Override
	public long findIdClient(Compte compte) {
		long IdClient = 0;
		PreparedStatement prepst;
		String reqId = "SELECT id_client FROM compte WHERE id_compte = '" + compte.getId_compte() + "'";

		try {
			prepst = connect.prepareStatement(reqId);
			ResultSet rs = prepst.executeQuery();

			if (rs.first()) {
				IdClient = rs.getLong("id_client");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return IdClient;
	}


}
