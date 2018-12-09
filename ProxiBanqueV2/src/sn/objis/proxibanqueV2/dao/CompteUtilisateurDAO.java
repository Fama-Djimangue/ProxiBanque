package sn.objis.proxibanqueV2.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sn.objis.proxibanqueV2.domaine.CompteUtilisateur;
import sn.objis.proxibanqueV2.utils.ConnectionMySqlDataSourceDBCP;
import sn.objis.proxibanqueV2.utils.CrypterChaine;

public class CompteUtilisateurDAO implements ICompteUtilisateurDAO {

	private String mdpDansLaBase;
	private static Connection connect = ConnectionMySqlDataSourceDBCP.getInstance();
	

	private PreparedStatement prepst;
	private List<CompteUtilisateur> listeCompteUtilisateur;

	@Override
	public void create(CompteUtilisateur compteUtilisateur) {
		
		
		String sql = "INSERT INTO compteutilisateur(login, password) VALUES (?,?)";
		try {
			prepst = connect.prepareStatement(sql);
			mdpDansLaBase= CrypterChaine.crypter(compteUtilisateur.getPassword());
			prepst.setString(1, compteUtilisateur.getLogin());
			prepst.setString(2, mdpDansLaBase);
			
			prepst.executeUpdate();
			System.out.println("Insertion Réussie!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Problème lors de l'insertion");
		}
	}

	@Override
	public CompteUtilisateur find(long id) {
		CompteUtilisateur compteUtilisateur = null;
		String sql = "SELECT * FROM compteutilisateur WHERE id_compte_user=?";
		try {
			prepst = connect.prepareStatement(sql);
			prepst.setLong(1, id);
			ResultSet rs = prepst.executeQuery();

			if (rs.first()) {
				compteUtilisateur = new CompteUtilisateur();
				compteUtilisateur.setId_compte_user(rs.getLong("id_compte_user"));
				compteUtilisateur.setLogin(rs.getString("login"));
				compteUtilisateur.setPassword(rs.getString("password"));
				compteUtilisateur.setDate_creation_user(rs.getDate("date_creation_user"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return compteUtilisateur;
	}

	@Override
	public CompteUtilisateur find() {
		CompteUtilisateur compteUtilisateur = null;

		String sql = "SELECT * FROM compteutilisateur";
		try {
			prepst = connect.prepareStatement(sql);

			ResultSet rs = prepst.executeQuery();

			if (rs.last()) {
				compteUtilisateur = new CompteUtilisateur();
				compteUtilisateur.setId_compte_user(rs.getLong("id_compte_user"));
				compteUtilisateur.setLogin(rs.getString("login"));
				compteUtilisateur.setPassword(rs.getString("password"));
				compteUtilisateur.setDate_creation_user(rs.getDate("date_creation_user"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return compteUtilisateur;

	}

	@Override
	public List<CompteUtilisateur> findAll() {
		listeCompteUtilisateur = new ArrayList<CompteUtilisateur>();
		CompteUtilisateur compteUtilisateur = null;
		String sql = "SELECT * FROM compteutilisateur";
		try {
			prepst = connect.prepareStatement(sql);

			ResultSet rs = prepst.executeQuery();

			if (rs.next()) {
				compteUtilisateur = new CompteUtilisateur();
				compteUtilisateur.setId_compte_user(rs.getLong("id_compte_user"));
				compteUtilisateur.setLogin(rs.getString("login"));
				compteUtilisateur.setPassword(rs.getString("password"));
				compteUtilisateur.setDate_creation_user(rs.getDate("date_creation_user"));

				listeCompteUtilisateur.add(compteUtilisateur);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listeCompteUtilisateur;

	}

	@Override
	public CompteUtilisateur update(CompteUtilisateur compteUtilisateur) throws DataAccessException {
		if (compteUtilisateur.getId_compte_user() < 1)
			throw new DataAccessException("l'identifiant de le compte utilisateur ne peut etre inferieur a zero");

		String sql = "UPDATE compteutilisateur SET login=?, password=?, dateCreationUser=?  WHERE id_compteUser=?";

		try {
			prepst = connect.prepareStatement(sql);
			prepst.setString(1, compteUtilisateur.getLogin());
			prepst.setString(2, compteUtilisateur.getPassword());
			prepst.setDate(3, (Date) compteUtilisateur.getDate_creation_user());
			prepst.setLong(4, compteUtilisateur.getId_compte_user());
			prepst.executeUpdate();

			compteUtilisateur = this.find(compteUtilisateur.getId_compte_user());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return compteUtilisateur;
	}

	@Override
	public void delete(CompteUtilisateur compteUtilisateur) {
		String sql = "DELETE * FROM compteutilisateur WHERE id_compteUser=?";
		try {
			prepst = connect.prepareStatement(sql);

			prepst.setLong(1, compteUtilisateur.getId_compte_user());

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
		String sql = "DELETE * FROM compteutilisateur WHERE id_compteUser=?";
		try {
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
	public CompteUtilisateur authentifierUser(String login, String pwd) {
		mdpDansLaBase = CrypterChaine.crypter(pwd);

		CompteUtilisateur compteUtilisateur = null;
		try {
			String sql = "SELECT * FROM compteutilisateur WHERE login=? and password=?";
			prepst = connect.prepareStatement(sql);

			prepst.setString(1, login);
			prepst.setString(2, mdpDansLaBase);
			ResultSet rs = prepst.executeQuery();
			if (rs.first()) {
				compteUtilisateur = new CompteUtilisateur();
				compteUtilisateur.setId_compte_user(rs.getLong("id_compte_user"));
				compteUtilisateur.setLogin(rs.getString("login"));
				compteUtilisateur.setPassword(rs.getString("password"));
				compteUtilisateur.setDate_creation_user(rs.getDate("date_creation_user"));

				System.out.println("Compte utilisateur trouvé avec succès");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Problème dans la requete de recherche");
		}
		return compteUtilisateur;
	}

	@Override
	public CompteUtilisateur recupererUtilisateurParLogin(String login) {
		CompteUtilisateur compteUtilisateur = null;
		try {
			String sql = "SELECT * FROM compteutilisateur WHERE login=?";
			prepst = connect.prepareStatement(sql);

			prepst.setString(1, login);
			ResultSet rs = prepst.executeQuery();
			if (rs.first()) {
				compteUtilisateur = new CompteUtilisateur();
				compteUtilisateur.setId_compte_user(rs.getLong("id_compte_user"));
				compteUtilisateur.setLogin(rs.getString("login"));
				compteUtilisateur.setPassword(rs.getString("password"));
				compteUtilisateur.setDate_creation_user(rs.getDate("date_creation_user"));

				System.out.println("compte utilisateur trouvé avec succès");
			}

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("Problème dans la requete de recherche");
		}
		return compteUtilisateur;
	}

	@Override
	public CompteUtilisateur updateMdp(CompteUtilisateur compteUtilisateur, String nveMdp) {
		mdpDansLaBase = CrypterChaine.crypter(nveMdp);

		try {

			String sql = "UPDATE compteutilisateur SET  password=? WHERE id_compte_user=?";

			prepst = connect.prepareStatement(sql);

			prepst.setString(1, mdpDansLaBase);
			prepst.setLong(2, compteUtilisateur.getId_compte_user());
			prepst.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return compteUtilisateur;

	}
	public long dernierIdCompteUser(CompteUtilisateur compteUtilisateur){
		long IdCompteUser = 0;
		PreparedStatement prepst;
		String reqId = "SELECT MAX(id_compte_user)as dernierCompteUtilisateur FROM compteutilisateur";
		
		try {
			prepst = connect.prepareStatement(reqId);
			ResultSet rs = prepst.executeQuery();

			if (rs.first()) {
				IdCompteUser = rs.getLong("dernierCompteUtilisateur");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return IdCompteUser;
	}

}
