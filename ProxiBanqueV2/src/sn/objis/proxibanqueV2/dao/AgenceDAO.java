package sn.objis.proxibanqueV2.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sn.objis.proxibanqueV2.domaine.Agence;
import sn.objis.proxibanqueV2.utils.ConnectionMySqlDataSourceDBCP;
import sn.objis.proxibanqueV2.utils.MethodUtils;

public class AgenceDAO implements IAgenceDAO {

	private static Connection connect = ConnectionMySqlDataSourceDBCP.getInstance();
	
	

	@Override
	public void create(Agence agence) {
		// TODO Auto-generated method stub
		PreparedStatement prepst;
		try {
			String sql = "INSERT INTO agence (libelle_agence,numero_identification,date_creation) " + "VALUES(?,?,?);";

			long idAgence= this.dernierId()+1;
			agence.setNumero_identification(MethodUtils.genererNumAgence(idAgence, agence.getLibelle_agence()));
			prepst = connect.prepareStatement(sql);
			prepst.setString(1, agence.getLibelle_agence());
			prepst.setString(2, agence.getNumero_identification());
			prepst.setDate(3, (Date) agence.getDate_creation());

			prepst.executeUpdate();

			System.out.println("Insertion faite avec succès");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Problème lors de l'insertion");
		}

	}

	@Override
	public Agence find(long id) {

		Agence agence = null;

		try {
			PreparedStatement prepst;
			String sql = "SELECT * FROM agence WHERE id_agence=?";
			prepst = connect.prepareStatement(sql);
			prepst.setLong(1, id);
			ResultSet rs = prepst.executeQuery();
			if (rs.first()) {
				agence = new Agence();
				agence.setLibelle_agence(rs.getString("Libelle_agence"));
				agence.setNumero_identification(rs.getString("Numero_identification"));
				agence.setDate_reation(rs.getDate("date_creation"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return agence;
	}

	@Override
	public Agence find() {

		Agence agence = null;

		try {
			PreparedStatement prepst;
			String sql = "SELECT * FROM agence";
			prepst = connect.prepareStatement(sql);
			ResultSet rs = prepst.executeQuery();
			while (rs.first()) {
				agence = new Agence();
				agence.setLibelle_agence(rs.getString("Libelle_agence"));
				agence.setNumero_identification(rs.getString("Numero_identification"));
				// agence.getDate_creation(rs.getDate("Date_creation"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return agence;
	}

	@Override
	public Agence update(Agence agence) throws DataAccessException {
		// TODO Auto-generated method stub
		PreparedStatement prepst;
		try {
			String sql = "UPDATE agence SET libelle_agence=?,prenom_etudiant=?" + ",date_creation=?  WHERE id_agence=?";

			agence.setNumero_identification(MethodUtils.genererNumAgence(agence.getId_agence(), agence.getLibelle_agence()));
			
			prepst = connect.prepareStatement(sql);

			prepst.setString(1, agence.getLibelle_agence());
			prepst.setString(2, agence.getNumero_identification());
			prepst.setDate(3, (Date) agence.getDate_creation());

			prepst.executeUpdate();
			System.out.println("Mise à jour effectuée avec succès");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Problème de requete lors dela mise à jour");
		}
		return agence;
	}

	@Override
	public void delete(Agence agence) {
		// TODO Auto-generated method stub
		PreparedStatement prepst;
		try {

			String sql = "DELETE FROM agence WHERE id_agence=?";
			prepst = connect.prepareStatement(sql);
			prepst.setLong(1, agence.getId_agence());
			prepst.executeUpdate();
			System.out.println("Agence supprimé avec succès");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Probleme de requete lors de la suppression");
		}

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		PreparedStatement prepst;
		try {

			String sql = "DELETE FROM agence WHERE id_agence=?";
			prepst = connect.prepareStatement(sql);
			prepst.setLong(1, id);
			prepst.executeUpdate();
			System.out.println("Agence supprimé avec succès");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Probleme de requete lors de la suppression");
		}

	}

	@Override
	public List<Agence> findAll() {
		List<Agence> listAgence = new ArrayList<Agence>();
		PreparedStatement prepst;
		try {

			String sql = "SELECT * FROM agence";
			prepst = connect.prepareStatement(sql);
			ResultSet rs = prepst.executeQuery();
			while (rs.next()) {
				Agence agence = new Agence();
				agence.setLibelle_agence(rs.getString("Libelle_agence"));
				agence.setNumero_identification(rs.getString("Numero_identification"));
				// agence.getDate_creation(rs.getDate("Date_creation"));

				listAgence.add(agence);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listAgence;
	}
	public long dernierId() {
		long IdAgence = 0;
		PreparedStatement prepst;
		String reqId = "SELECT MAX(id_agence)as dernierAgence FROM agence";

		try {
			prepst = connect.prepareStatement(reqId);
			ResultSet rs = prepst.executeQuery();

			if (rs.first()) {
				IdAgence = rs.getLong("dernierAgence");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return IdAgence;
	}

}