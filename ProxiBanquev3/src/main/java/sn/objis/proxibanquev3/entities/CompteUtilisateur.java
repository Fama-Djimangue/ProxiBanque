package sn.objis.proxibanquev3.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CompteUtilisateur implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long code_compte_user;
	private String login;
	private String password;
	private Date date_creation_user;
	
	public CompteUtilisateur(String login, String password, Date date_creation_user) {
		super();
		this.login = login;
		this.password = password;
		this.date_creation_user = date_creation_user;
	}

	public CompteUtilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getCode_compte_user() {
		return code_compte_user;
	}

	public void setCode_compte_user(long code_compte_user) {
		this.code_compte_user = code_compte_user;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDate_creation_user() {
		return date_creation_user;
	}

	public void setDate_creation_user(Date date_creation_user) {
		this.date_creation_user = date_creation_user;
	}

		
}
