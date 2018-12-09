package sn.objis.proxibanque.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Classe qui contient les informations sur la connection à la base via une
 * ressource Statement ou PreStatement
 * 
 *@author Djimangue-Fama
 *@version 2.0 ProxiBanquev1
 *
 */
public class ConnectionMysql {
	private static Connection connection;

	/**
	 * méthode qui permet d'établir la connexion à la base de données
	 * 
	 * @return connection
	 */
	public static Connection getInstance()  {

		if (connection == null) {

			try {
				//Création d'une instance de la classe Properties
				Properties prop = new Properties();
				// Etablissement de la communication entre le programme et le fichier
				InputStream input = new FileInputStream("config.properties");
				//Chargement du fichier dans l'objet prop
				prop.load(input);
				//Propriétés du fichier et récupération des valeurs des clés
				String driver=prop.getProperty("driver");
				String url=prop.getProperty("url");
				String login=prop.getProperty("user");
				String pwd=prop.getProperty("password");
				//Chargement du driver
				Class.forName(driver).newInstance();
				//Création de la connection avec la base de données
				connection= DriverManager.getConnection(url,login,pwd);
	
						
				System.out.println("Connextion Etabli!");
			} catch (Exception e) {
				System.out.println("Erreur Connextion");
			} finally {

			}
		}

		return connection;
	}

}