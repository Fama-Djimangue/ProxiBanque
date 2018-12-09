package sn.objis.proxibanque.domaine;

import java.sql.Date;

public class CompteUtilisateur {

	private long id_compte_user;
	private String login;
	private String password;
	private Date date_creation_user;
	
	
	// Constructeur
	
	/**
	 * 
	 */
	public CompteUtilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id_compte_user
	 * @param login
	 * @param password
	 * @param date_creation_user
	 */
	public CompteUtilisateur(long id_compte_user, String login, String password, Date date_creation_user) {
		super();
		this.id_compte_user = id_compte_user;
		this.login = login;
		this.password = password;
		this.date_creation_user = date_creation_user;
	}


	/**
	 * @param login
	 * @param password
	 */
	public CompteUtilisateur(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	//getters et setters		
	/**
	 * @return the id_compte_user
	 */
	public long getId_compte_user() {
		return id_compte_user;
	}
	/**
	 * @param id_compte_user the id_compte_user to set
	 */
	public void setId_compte_user(long id_compte_user) {
		this.id_compte_user = id_compte_user;
	}
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the date_creation_user
	 */
	public Date getDate_creation_user() {
		return date_creation_user;
	}
	/**
	 * @param date_creation_user the date_creation_user to set
	 */
	public void setDate_creation_user(Date date_creation_user) {
		this.date_creation_user = date_creation_user;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompteUtilisateur [login=" + login + ", password=" + password
				+ ", date_creation_user=" + date_creation_user + "]";
	}
	
	
	
	
}
