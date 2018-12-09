package sn.objis.proxibanqueV2.utils;

import java.sql.Connection;
import java.sql.SQLException;


/** Configuration d'une dataSource sans JNDI
 *  Implementation de type DBCP en utilisant directement l'implementation BasicDataSource
 *
 */
public class ConnectionMySqlDataSourceDBCP {
	
	
	@SuppressWarnings("unused")
	private String user;
	
	@SuppressWarnings("unused")
	private String password;
	
	@SuppressWarnings("unused")
	private String url;
	
	@SuppressWarnings("unused")
	private String driver;
	
	private static Connection connection;	
	
	@SuppressWarnings("static-access")
	public ConnectionMySqlDataSourceDBCP(String user, String password, String url, String driver, Connection c) {
		super();
		this.user = user;
		this.password = password;
		this.url = url;
		this.driver = driver;
		this.connection= c;
	}
	public static Connection getInstance(){
		
				return connection;
		
	}
	public void closeConnection(){
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
