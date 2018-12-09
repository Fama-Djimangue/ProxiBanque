package sn.objis.proxibanque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sn.objis.proxibanque.domaine.CompteUtilisateur;
import sn.objis.proxibanque.domaine.Employer;
import sn.objis.proxibanque.utils.ConnectionMysql;

public class EmployerDAO implements IEmployerDAO {

	private static Connection connect = ConnectionMysql.getInstance();

	private PreparedStatement prepst;
	private List<Employer> listeEmployer;

	public void createConseiller(Employer conseiller, CompteUtilisateur compteGerant,Employer gerant) {

		try {

			String sql = "INSERT INTO employer (nom_employer, prenom_employer, email_employer, adresse_employer,"
					+ " code_postal, ville_employer, telephone_employer, type_employer, id_compteUser,"
					+ " id_gerant)  VALUES(?,?,?,?,?,?,?,'CCL','" + compteGerant.getId_compte_user() + "','" + gerant.getId_employer() + "');";

			prepst = connect.prepareStatement(sql);

			prepst.setString(1, conseiller.getNom_employer());
			prepst.setString(2, conseiller.getPrenom_employer());
			prepst.setString(3, conseiller.getEmail_employer());
			prepst.setString(4, conseiller.getAdresse_employer());
			prepst.setString(5, conseiller.getCode_postal());
			prepst.setString(6, conseiller.getVille_employer());
			prepst.setString(7, conseiller.getTelephone_employer());
			System.out.println("Conseiller créer de la base");		
			
			prepst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void create(Employer employer) {

		try {

			String sql = "INSERT INTO Employer (nom_employer, prenom_employer, email_employer, adresse_employer,"
					+ "code_postal, ville_employer, telephone_employer,type_employer) VALUES(?,?,?,?,?,?,?,'CCL');";

			prepst = connect.prepareStatement(sql);

			prepst.setString(1, employer.getNom_employer());
			prepst.setString(2, employer.getPrenom_employer());
			prepst.setString(3, employer.getEmail_employer());
			prepst.setString(4, employer.getAdresse_employer());
			prepst.setString(5, employer.getCode_postal());
			prepst.setString(6, employer.getVille_employer());
			prepst.setString(7, employer.getTelephone_employer());

			prepst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Employer find(long id) {
		Employer employer = null;
		try {

			String sql = "SELECT * FROM Employer WHERE id_employer=?";
			prepst = connect.prepareStatement(sql);

			prepst.setLong(1, id);
			ResultSet rs = prepst.executeQuery();

			if (rs.first()) {
				employer = new Employer();

				employer.setId_employer(rs.getLong("id_employer"));
				employer.setNom_employer(rs.getString("nom_employer"));
				employer.setPrenom_employer(rs.getString("prenom_employer"));
				employer.setEmail_employer(rs.getString("email_employer"));
				employer.setAdresse_employer(rs.getString("adresse_employer"));
				employer.setCode_postal(rs.getString("code_postal"));
				employer.setVille_employer(rs.getString("ville_employer"));
				employer.setTelephone_employer(rs.getString("telephone_employer"));
				employer.setType_employer(rs.getString("type_employer"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employer;
	}

	@Override
	public Employer find() {
		Employer employer = null;
		try {
			String sql = "SELECT * FROM Employer";

			prepst = connect.prepareStatement(sql);

			ResultSet rs = prepst.executeQuery();

			if (rs.first()) {
				employer = new Employer();

				employer.setId_employer(rs.getLong("id_employer"));
				employer.setNom_employer(rs.getString("nom_employer"));
				employer.setPrenom_employer(rs.getString("prenom_employer"));
				employer.setEmail_employer(rs.getString("email_employer"));
				employer.setAdresse_employer(rs.getString("adresse_employer"));
				employer.setCode_postal(rs.getString("code_postal"));
				employer.setVille_employer(rs.getString("ville_employer"));
				employer.setTelephone_employer(rs.getString("telephone_employer"));
				employer.setType_employer(rs.getString("type_employer"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employer;
	}

	@Override
	public Employer update(Employer employer) throws DataAccessException {
		if (employer.getId_employer() < 1)
			throw new DataAccessException("l'identifiant de l'Employer ne peut etre inferieur a zero");

		try {

			String sql = "UPDATE employer SET nom_employer=?, prenom_employer=?, email_employer=?, adresse_employer=?, code_postal=?, ville_employer=?, telephone_employer=?  WHERE id_employer=?";

			prepst = connect.prepareStatement(sql);

			prepst.setString(1, employer.getNom_employer());
			prepst.setString(2, employer.getPrenom_employer());
			prepst.setString(3, employer.getEmail_employer());
			prepst.setString(4, employer.getAdresse_employer());
			prepst.setString(5, employer.getCode_postal());
			prepst.setString(6, employer.getVille_employer());
			prepst.setString(7, employer.getTelephone_employer());
			prepst.setLong(8, employer.getId_employer());
			prepst.executeUpdate();

			System.out.println("Mise à jour effectuée avec succès");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employer;
	}

	@Override
	public void delete(Employer employer) {
		String sql = "DELETE FROM employer WHERE id_employer=?";
		try {
			prepst = connect.prepareStatement(sql);

			prepst.setLong(1, employer.getId_employer());

			prepst.executeUpdate();
			System.out.println("Employer supprimé avec succès");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Probleme de requete lors de la suppression");
		}

	}

	@Override
	public void delete(long id) {
		try {
			String sql = "DELETE FROM employer WHERE id_employer=?";
			prepst = connect.prepareStatement(sql);
			prepst.setLong(1, id);

			prepst.executeUpdate();
			System.out.println("Employer supprimé avec succès");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Probleme de requete lors de la suppression");
		}

	}

	@Override
	public List<Employer> findAll() {
		listeEmployer = new ArrayList<Employer>();
		Employer employer = null;

		try {
			String sql = "SELECT * FROM compte";
			prepst = connect.prepareStatement(sql);
			ResultSet rs = prepst.executeQuery();

			while (rs.next()) {

				employer = new Employer();
				// employer.setId_employer(rs.getLong("id_employer"));
				employer.setNom_employer(rs.getString("nom_employer"));
				employer.setPrenom_employer(rs.getString("prenom_employer"));
				employer.setEmail_employer(rs.getString("email_employer"));
				employer.setAdresse_employer(rs.getString("adresse_employer"));
				employer.setCode_postal(rs.getString("code_postal"));
				employer.setVille_employer(rs.getString("ville_employer"));
				employer.setTelephone_employer(rs.getString("telephone_employer"));
				employer.setType_employer(rs.getString("type_employer"));

				listeEmployer.add(employer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeEmployer;

	}

	@Override
	public List<Employer> findConseiller() {
		List<Employer> listeConseiller = new ArrayList<Employer>();
		Employer employer = null;

		try {
			String sql = "SELECT * FROM employer WHERE type_employer ='CCL'";
			prepst = connect.prepareStatement(sql);
			ResultSet rs = prepst.executeQuery();

			while (rs.next()) {

				employer = new Employer();
				employer.setId_employer(rs.getLong("id_employer"));
				employer.setNom_employer(rs.getString("nom_employer"));
				employer.setPrenom_employer(rs.getString("prenom_employer"));
				employer.setEmail_employer(rs.getString("email_employer"));
				employer.setAdresse_employer(rs.getString("adresse_employer"));
				employer.setCode_postal(rs.getString("code_postal"));
				employer.setVille_employer(rs.getString("ville_employer"));
				employer.setTelephone_employer(rs.getString("telephone_employer"));
				employer.setType_employer(rs.getString("type_employer"));

				listeConseiller.add(employer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeConseiller;

	}

	@Override
	public Employer findByEmail(String email) {
		Employer employerTrouve = null;
		try {
			String sql = "SELECT * FROM employer WHERE email_employer=?";
			prepst = connect.prepareStatement(sql);

			prepst.setString(1, email);
			ResultSet rs = prepst.executeQuery();
			if (rs.first()) {
				employerTrouve = new Employer();
				employerTrouve.setId_employer(rs.getLong("id_employer"));
				employerTrouve.setNom_employer(rs.getString("nom_employer"));
				employerTrouve.setPrenom_employer(rs.getString("prenom_employer"));
				employerTrouve.setEmail_employer(rs.getString("email_employer"));
				employerTrouve.setAdresse_employer(rs.getString("adresse_employer"));
				employerTrouve.setCode_postal(rs.getString("code_postal"));
				employerTrouve.setVille_employer(rs.getString("ville_employer"));
				employerTrouve.setTelephone_employer(rs.getString("telephone_employer"));
				employerTrouve.setType_employer(rs.getString("type_employer"));

				System.out.println("Employer trouvé avec succès");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Problème dans la requete de recherche");
		}
		return employerTrouve;

	}


	@Override
	public long findIdAgence(Employer gerant) {
		long IdAgence = 0;
		PreparedStatement prepst;
		String reqId = "SELECT idAgence FROM employer WHERE id_employer = '" + gerant.getId_employer() + "'";

		try {
			prepst = connect.prepareStatement(reqId);
			ResultSet rs = prepst.executeQuery();

			if (rs.first()) {
				IdAgence = rs.getLong("idAgence");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return IdAgence;
	}

	@Override
	public long findIdCompteuser(Employer gerant) {
		long IdUser = 0;
		PreparedStatement prepst;
		String reqId = "SELECT id_compteUser FROM employer WHERE id_employer = '" + gerant.getId_employer() + "'";

		try {
			prepst = connect.prepareStatement(reqId);
			ResultSet rs = prepst.executeQuery();

			if (rs.first()) {
				IdUser = rs.getLong("id_compteUser");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return IdUser;
	}

	@Override
	public Employer findByIdCompteUser(CompteUtilisateur compteUtilisateur) {
		Employer employerTrouve = null;
		try {
			String sql = "SELECT * FROM employer WHERE id_compteUser='" + compteUtilisateur.getId_compte_user() + "'";
			prepst = connect.prepareStatement(sql);

			ResultSet rs = prepst.executeQuery();
			if (rs.first()) {
				employerTrouve = new Employer();
				employerTrouve.setId_employer(rs.getLong("id_employer"));
				employerTrouve.setNom_employer(rs.getString("nom_employer"));
				employerTrouve.setPrenom_employer(rs.getString("prenom_employer"));
				employerTrouve.setEmail_employer(rs.getString("email_employer"));
				employerTrouve.setAdresse_employer(rs.getString("adresse_employer"));
				employerTrouve.setCode_postal(rs.getString("code_postal"));
				employerTrouve.setVille_employer(rs.getString("ville_employer"));
				employerTrouve.setTelephone_employer(rs.getString("telephone_employer"));
				employerTrouve.setType_employer(rs.getString("type_employer"));

				System.out.println("Employer trouvé avec succès");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Problème dans la requete de recherche");
		}
		return employerTrouve;

	}

	
	public long findIdGerantByCons(Employer conseiller) {
		long IdGerant = 0;
		PreparedStatement prepst;
		String reqId = "SELECT id_gerant FROM employer WHERE id_employer = '" + conseiller.getId_employer() + "'";

		try {
			prepst = connect.prepareStatement(reqId);
			ResultSet rs = prepst.executeQuery();

			if (rs.first()) {
				IdGerant = rs.getLong("id_gerant");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return IdGerant;
	}


}