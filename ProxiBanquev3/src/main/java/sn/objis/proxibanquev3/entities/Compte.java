package sn.objis.proxibanquev3.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


import org.springframework.beans.factory.annotation.Autowired;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Pour dire que tous les types de comptes vont etre enregistres dans une meme table. C'est donc une table pour toute la hierarchie
@DiscriminatorColumn(name = "TYPE_CPTE",
        discriminatorType = DiscriminatorType.STRING)  // c'est la colonne qui permet de distinguer le type de compte( compte courant ou compte epargne)
public class Compte implements Serializable {
	 @Id
	 @GeneratedValue
	   private long idCompte;
	   private String numeroCompte;
	    private Date dateCreation;
	    private double solde;
	    
		 // Un compte appartient a un seul client et un client peut avoir plusieurs comptes
	    @ManyToOne
	     private Client client; 
	   
	    @ManyToOne
	    private Employe employe; // Un compte est cree par un seul employe. Ici on a une relation unidirectionnelle ie on a pas besoin de declarer une collection de comptes dans l entite Employe
	  
	  //au niveau du diagramme on a fait une relation bidirestionnelle entre compte et op�ration  

	    @ManyToMany(cascade=CascadeType.PERSIST)
		private Collection<Operations> listeOperations;// Un compte peut sublir plusieurs operations : idem relation bidirec tionnelle
	    
		public Date getDateCreation() {
			return dateCreation;
		}
		public void setDateCreation(Date dateCreation) {
			this.dateCreation = dateCreation;
			
			
		}
		public double getSolde() {
			return solde;
		}
		public void setSolde(double solde) {
			this.solde = solde;
		}
		public Client getClient() {
			return client;
		}
		public void setClient(Client client) {
			this.client = client;
		}
		public Employe getEmploye() {
			return employe;
		}
		public void setEmploye(Employe employe) {
			this.employe = employe;
		}


		public Collection<Operations> getListeOperations() {
			return listeOperations;
		}
		public void setListeOperations(Collection<Operations> listeOperations) {
			this.listeOperations = listeOperations;
		}
		public Compte() {
			super();
			
		}
		
				
		public Compte(double solde) {
			super();
			this.solde = solde;
			this.dateCreation = new Date();
		}
		public Compte(String numeroCompte, Date dateCreation, double solde, Client client, Employe employe) {
			super();
			this.numeroCompte = numeroCompte;
			this.dateCreation = dateCreation;
			this.solde = solde;
			this.client = client;
			this.employe = employe;
			//this.listeOperations=new HashSet<>();
		}
	
		public long getIdCompte() {
			return idCompte;
		}
		public void setIdCompte(long idCompte) {
			this.idCompte = idCompte;
		}
		public String getNumeroCompte() {
			return numeroCompte;
		}
		public void setNumeroCompte(String numeroCompte) {
			this.numeroCompte = numeroCompte;
			
		}
	
}
