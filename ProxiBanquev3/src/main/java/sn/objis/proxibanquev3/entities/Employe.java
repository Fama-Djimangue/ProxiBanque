package sn.objis.proxibanquev3.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Pour dire que tous les types de comptes vont etre enregistres dans une meme table. C'est donc une table pour toute la hierarchie
@DiscriminatorColumn(name = "TYPE_EMP",
        discriminatorType = DiscriminatorType.STRING)  // c'est la colonne qui permet de distinguer le type d'employe( Conseiller ou Gérent)

public class Employe implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeEmployer;
	private String nomEmployer;
    private String prenomEmployer;
	private String emailEmployer;
	private String adresseEmployer;
	private String telEmployer;

	@ManyToOne
    @JoinColumn(name = "CODE_USER")
	private User user;
	
	@ManyToOne
    @JoinColumn(name="CODE_GERENT")
    private Employe gerent; // Un conseiller possede un gérent

	@OneToMany(mappedBy = "employe")
   	private Collection<Client> listeclients;
	
	// LES GETTERS ET SETTERS
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Collection<Client> getListeclients() {
		return listeclients;
	}

	public void setListeclients(Collection<Client> listeclients) {
		this.listeclients = listeclients;
	}


	
	public Employe(Long codeEmployer) {
		super();
		this.codeEmployer = codeEmployer;
	}

	public Long getCodeEmployer() {
		return codeEmployer;
	}



	public void setCodeEmployer(Long codeEmployer) {
		this.codeEmployer = codeEmployer;
	}



	public String getNomEmployer() {
		return nomEmployer;
	}



	public void setNomEmployer(String nomEmployer) {
		this.nomEmployer = nomEmployer;
	}



	public String getPrenomEmployer() {
		return prenomEmployer;
	}



	public void setPrenomEmployer(String prenomEmployer) {
		this.prenomEmployer = prenomEmployer;
	}



	public String getEmailEmployer() {
		return emailEmployer;
	}



	public void setEmailEmployer(String emailEmployer) {
		this.emailEmployer = emailEmployer;
	}



	public String getAdresseEmployer() {
		return adresseEmployer;
	}



	public void setAdresseEmployer(String adresseEmployer) {
		this.adresseEmployer = adresseEmployer;
	}



	public String getTelEmployer() {
		return telEmployer;
	}



	public void setTelEmployer(String telEmployer) {
		this.telEmployer = telEmployer;
	}


	public Employe getGerent() {
		return gerent;
	}

	public void setGerent(Employe gerent) {
		this.gerent = gerent;
	}

	
	public Collection<Client> getClients() {
		return listeclients;
	}

	public void setClients(Collection<Client> listeclients) {
		this.listeclients = listeclients;
	}
	
	//LES CONSTRUCTEURS
	
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employe(String nomEmployer, String prenomEmployer, String emailEmployer, Employe gerent) {
		super();
		this.nomEmployer = nomEmployer;
		this.prenomEmployer = prenomEmployer;
		this.emailEmployer = emailEmployer;
		this.gerent = gerent;
	}


	public Employe(String nomEmployer, String prenomEmployer, String emailEmployer, String telEmployer, User user,
			Employe gerent) {
		super();
		this.nomEmployer = nomEmployer;
		this.prenomEmployer = prenomEmployer;
		this.emailEmployer = emailEmployer;
		this.telEmployer = telEmployer;
		this.user = user;
		this.gerent = gerent;
	}
	
	public Employe(Long codeEmployer,String nomEmployer, String prenomEmployer, String emailEmployer, String telEmployer, User user,
			Employe gerent) {
		super();
		this.codeEmployer = codeEmployer;
		this.nomEmployer = nomEmployer;
		this.prenomEmployer = prenomEmployer;
		this.emailEmployer = emailEmployer;
		this.telEmployer = telEmployer;
		this.user = user;
		this.gerent = gerent;
		}

	
    }
