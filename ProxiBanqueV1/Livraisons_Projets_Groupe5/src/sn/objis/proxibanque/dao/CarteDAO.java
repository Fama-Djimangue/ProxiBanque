package sn.objis.proxibanque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sn.objis.proxibanque.domaine.Carte;
import sn.objis.proxibanque.utils.ConnectionMysql;

public class CarteDAO implements ICarteDAO {
	
	private static Connection connect = ConnectionMysql.getInstance();
	

	@Override
	public void create(Carte carte) {
		// TODO Auto-generated method stub
		PreparedStatement prepst;
		try {
			String sql = "INSERT INTO agence (solde_carte,type_carte,date_activation,date_desactivation) "
					+ "VALUES(?,?,?,?);";
			
			prepst=connect.prepareStatement(sql);	
			
			prepst.setDouble(1, carte.getSolde_carte());
			prepst.setString(2, carte.getType_carte());
			prepst.setDate(3, carte.getDate_activation());
			prepst.setDate(4,  carte.getDate_desactivation());			
			prepst.executeUpdate();
			
			System.out.println("Insertion faite avec succès");			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Problème lors de l'insertion");
		}
		
	}

	@Override
	public Carte find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Carte find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Carte update(Carte carte) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Carte carte) {
		// TODO Auto-generated method stub
		PreparedStatement prepst;
		try {
			
			String sql="DELETE FROM carte WHERE id_carte=?";
			prepst=connect.prepareStatement(sql);
			prepst.setLong(1, carte.getId_carte());
			prepst.executeUpdate();
			System.out.println("Carte supprimé avec succès");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Probleme de requete lors de la suppression");
		}
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Carte> findAll() {		
		 List<Carte> listcarte=new ArrayList<Carte>();
			
		 PreparedStatement prepst;		
			try {
				
				String sql="SELECT * FROM carte";
				prepst = connect.prepareStatement(sql);
				ResultSet rs=prepst.executeQuery(sql);
				while(rs.next()){
					Carte carte=new Carte();				
					carte.setSolde_carte(rs.getLong("solde_carte"));
					carte.setType_carte(rs.getString("Type_carte"));
					carte.setDate_activation(rs.getDate("date_Activation"));
					carte.setDate_desactivation(rs.getDate("date_desactivation"));
				
					listcarte.add(carte);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return listcarte;

	}

}
