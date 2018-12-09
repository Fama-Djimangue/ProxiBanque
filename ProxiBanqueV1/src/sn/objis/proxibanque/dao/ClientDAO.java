package sn.objis.proxibanque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sn.objis.proxibanque.domaine.Client;
import sn.objis.proxibanque.domaine.Employer;
import sn.objis.proxibanque.utils.ConnectionMysql;

public class ClientDAO implements IClientDAO {

	private static Connection connect = ConnectionMysql.getInstance();

	public void create(Client client, Employer conseiller) {
		PreparedStatement prepst;
		try {
			String sql = "INSERT INTO client (nom_client,prenom_client,email_client,adresse_client,code_postal,"
					+ "ville_client,telephone_client,profession_client,id_conseiller) VALUES(?,?,?,?,?,?,?,?,'"
					+ conseiller.getId_employer() + "')";

			prepst = connect.prepareStatement(sql);

			prepst.setString(1, client.getNom_client());
			prepst.setString(2, client.getPrenom_client());
			prepst.setString(3, client.getEmail_client());
			prepst.setString(4, client.getAdresse_client());
			prepst.setString(5, client.getCode_postal());
			prepst.setString(6, client.getVille_client());
			prepst.setString(7, client.getTelephone_client());
			prepst.setString(8, client.getProfession_client());

			prepst.executeUpdate();

			System.out.println("Insertion faite avec succès");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Problème lors de l'insertion");
		}

	}

	@Override
	public void create(Client client) {
		PreparedStatement prepst;
		try {
			String sql = "INSERT INTO client (nom_client,prenom_client,email_client,adresse_client,code_postal,"
					+ "ville_client,telephone_client,profession_client) VALUES(?,?,?,?,?,?,?,?);";

			prepst = connect.prepareStatement(sql);

			prepst.setString(1, client.getNom_client());
			prepst.setString(2, client.getPrenom_client());
			prepst.setString(3, client.getEmail_client());
			prepst.setString(4, client.getAdresse_client());
			prepst.setString(5, client.getCode_postal());
			prepst.setString(6, client.getVille_client());
			prepst.setString(7, client.getTelephone_client());
			prepst.setString(8, client.getProfession_client());

			prepst.executeUpdate();

			System.out.println("Insertion faite avec succès");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Problème lors de l'insertion");
		}

	}

	@Override
	public Client find(long id) {

		Client client = null;

		PreparedStatement prepst;
		try {
			String sql = "SELECT * FROM client WHERE id_client=?";
			prepst = connect.prepareStatement(sql);
			prepst.setLong(1, id);
			ResultSet rs = prepst.executeQuery();
			while (rs.first()) {
				client = new Client();

				client.setNom_client(rs.getString("nom_client"));
				client.setPrenom_client(rs.getString("prenom_client"));
				client.setEmail_client(rs.getNString("email_client"));
				client.setAdresse_client(rs.getString("adresse_client"));
				client.setCode_postal(rs.getString("code_postal"));
				client.setVille_client(rs.getString("ville_client"));
				client.setTelephone_client(rs.getString("telephone_client"));
				client.setProfession_client(rs.getString("profession_client"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return client;
	}

	@Override
	public Client find() {
		Client client = null;

		PreparedStatement prepst;
		try {
			String sql = "SELECT * FROM client";
			prepst = connect.prepareStatement(sql);
			ResultSet rs = prepst.executeQuery();
			while (rs.first()) {
				client = new Client();

				client.setNom_client(rs.getString("nom_client"));
				client.setPrenom_client(rs.getString("prenom_client"));
				client.setEmail_client(rs.getNString("email_client"));
				client.setAdresse_client(rs.getString("adresse_client"));
				client.setCode_postal(rs.getString("code_postal"));
				client.setVille_client(rs.getString("ville_client"));
				client.setTelephone_client(rs.getString("telephone_client"));
				client.setProfession_client(rs.getString("profession_client"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return client;
	}

	@Override
	public Client update(Client client) throws DataAccessException {
		// TODO Auto-generated method stub
		PreparedStatement prepst;
		try {
			String sql = "UPDATE client SET nom_client=?,prenom_client=?"
					+ ",email_client=?,adresse_client=?,adresse_client=?,ville_client=?,telephone_client=?,profession_client=?  WHERE id_client=?";

			prepst = connect.prepareStatement(sql);

			prepst.setString(1, client.getNom_client());
			prepst.setString(2, client.getPrenom_client());
			prepst.setString(3, client.getEmail_client());
			prepst.setString(4, client.getAdresse_client());
			prepst.setString(5, client.getCode_postal());
			prepst.setString(6, client.getVille_client());
			prepst.setString(7, client.getTelephone_client());
			prepst.setString(8, client.getProfession_client());
			prepst.setLong(9, client.getId_client());
			prepst.executeUpdate();
			System.out.println("Mise à jour effectuée avec succès");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Problème de requete lors dela mise à jour");
		}
		return client;
	}

	@Override
	public void delete(Client client) {
		// TODO Auto-generated method stub
		PreparedStatement prepst;
		try {

			String sql = "DELETE FROM client WHERE id_client=?";
			prepst = connect.prepareStatement(sql);

			prepst.setLong(1, client.getId_client());
			prepst.executeUpdate();
			System.out.println("Client supprimé avec succès");
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

			String sql = "DELETE FROM client WHERE id_client=?";
			prepst = connect.prepareStatement(sql);
			prepst.setLong(1, id);
			prepst.executeUpdate();
			System.out.println("Client supprimé avec succès");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Probleme de requete lors de la suppression");
		}

	}

	@Override
	public List<Client> findAll() {

		List<Client> listClient = new ArrayList<Client>();

		PreparedStatement prepst;
		try {
			String sql = "SELECT * FROM client";
			prepst = connect.prepareStatement(sql);
			ResultSet rs = prepst.executeQuery(sql);
			while (rs.next()) {
				Client client = new Client();

				client.setNom_client(rs.getString("nom_client"));
				client.setPrenom_client(rs.getString("prenom_client"));
				client.setEmail_client(rs.getString("email_client"));
				client.setAdresse_client(rs.getString("adresse_client"));
				client.setCode_postal(rs.getString("code_postal"));
				client.setVille_client(rs.getString("ville_client"));
				client.setTelephone_client(rs.getString("telephone_client"));
				client.setProfession_client(rs.getString("profession_client"));
				listClient.add(client);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listClient;
	}

	@Override
	public long dernierId(Client client) {
		long IdPatient = 0;
		PreparedStatement prepst;
		String reqId = "SELECT MAX(id_client)as dernierClient FROM client";

		try {
			prepst = connect.prepareStatement(reqId);
			ResultSet rs = prepst.executeQuery();

			if (rs.first()) {
				IdPatient = rs.getLong("dernierClient");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return IdPatient;
	}

	@Override
	public Client findByEmail(String email) {

			Client client = null;

			PreparedStatement prepst;
			try {
				String sql = "SELECT * FROM client WHERE email_client=?";
				prepst = connect.prepareStatement(sql);
				prepst.setString(1, email);
				ResultSet rs = prepst.executeQuery();
				if (rs.first()) {
					client = new Client();
					client.setId_client(rs.getLong("id_client"));
					client.setNom_client(rs.getString("nom_client"));
					client.setPrenom_client(rs.getString("prenom_client"));
					client.setEmail_client(rs.getString("email_client"));
					client.setAdresse_client(rs.getString("adresse_client"));
					client.setCode_postal(rs.getString("code_postal"));
					client.setVille_client(rs.getString("ville_client"));
					client.setTelephone_client(rs.getString("telephone_client"));
					client.setProfession_client(rs.getString("profession_client"));

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return client;
		}


}
