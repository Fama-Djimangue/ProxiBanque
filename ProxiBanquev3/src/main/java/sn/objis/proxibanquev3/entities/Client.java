package sn.objis.proxibanquev3.entities;

import java.io.Serializable;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "CLIENTS")
public class Client implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CODE_CLI")
	private Long codeClient;
    private String nomClient;
    private String emailClient;
    private String adresseClient;
    private String professionClient;
    
    // un client est géré par un et un seul employe
    // bidirectionnel
    @ManyToOne
    private Employe employe;


	public Long getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(Long codeClient) {
		this.codeClient = codeClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	
	public String getEmailClient() {
		return emailClient;
	}
	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}
	public String getAdresseClient() {
		return adresseClient;
	}
	public void setAdresseCient(String adresseClient) {
		this.adresseClient = adresseClient;
	}
	
	
	public String getProfessionClient() {
		return professionClient;
	}
	public void setProfessionCient(String professionClient) {
		this.professionClient = professionClient;
	}
	
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(String nomClient, String adresseClient) {
		super();
		this.nomClient = nomClient;
		this.adresseClient = adresseClient;
     //  this.comptes = new HashSet<>();
	}
		
	public Client(Long codeClient, String nomClient, String adresseClient, String professionClient,Employe employe) {
		super();
		this.codeClient = codeClient;
		this.nomClient = nomClient;
		this.adresseClient = adresseClient;
		this.professionClient = professionClient;
		this.employe = employe;
	     //this.comptes = new HashSet<>();
	}
	
	public Client(Long codeClient, String nomClient, String emailClient, String adresseClient, String professionClient,
			Employe employe) {
		super();
		this.codeClient = codeClient;
		this.nomClient = nomClient;
		this.emailClient = emailClient;
		this.adresseClient = adresseClient;
		this.professionClient = professionClient;
		this.employe = employe;
	}
	public Client(String nomClient,String professionClient, String adresseClient,String emailClient ,
			Employe employe) {
		super();
		this.nomClient = nomClient;
		this.professionClient = professionClient;
		this.adresseClient = adresseClient;
		this.emailClient = emailClient;
		this.employe = employe;
		//this.comptes = new HashSet<>();
	}
		
}
