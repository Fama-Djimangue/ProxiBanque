package sn.objis.proxibanqueV2.presentation.Listener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import sn.objis.proxibanqueV2.utils.ConnectionMySqlDataSourceDBCP;

/**
 * Cette listener est activée pour la création de la connexion avec base de données
 * Application Lifecycle Listener implementation class ConnexionListener
 * 
 *
 */
@WebListener
public class ConnexionListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ConnexionListener() {

    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 

    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
		//Recup du context de l'appli
		ServletContext ctx = arg0.getServletContext();
		//Recuperation des param de connexion
    	String user = ctx.getInitParameter("DBUSER");
    	String mdp = ctx.getInitParameter("DBPWD");
    	String url = ctx.getInitParameter("DBURL");
    	String driver = ctx.getInitParameter("DBDRIVE");
    	
    	
    	try {
			//Creation d'une dataSource : Tomcat intégre l'API DBCP
			BasicDataSource dataSource = new BasicDataSource();

			//Parametrage du dataSource

			dataSource.setDriverClassName(driver);
			dataSource.setUrl(url);
			dataSource.setUsername(user);
			dataSource.setPassword(mdp);

    		//Creation d'une connexion à la bd
	//		Connection cn = dataSource.getConnection(user, mdp);

			//Recuperation d'une connexion
			Connection cn = dataSource.getConnection();
			System.out.println("Connexion avec la BD reussie !");

			//Ajout d'une instance de ConnectionMySql dans le context
			ConnectionMySqlDataSourceDBCP connectionMySql = new ConnectionMySqlDataSourceDBCP(url, user, mdp, driver, cn);
			ctx.setAttribute("DBManager",connectionMySql);
			System.out.println("Connection Listener établit!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erreur Connection Listener!");
		}
    	
    }
	
}
