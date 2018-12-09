package sn.objis.proxibanquev3.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity

public   class Operations implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idOperation;
    private String numeroOperation;
    private String typeOperation;
    private Date dateOperation;
    private double montant;

	@Transient
    private Collection<Compte> listeComptes=new HashSet<>(); 
	
    @ManyToOne
    @JoinColumn(name="CODE_EMP")
    private Employe employe;
	
	public Long getIdOperation() {
		return idOperation;
	}
	public void setIdOperation(Long idOperation) {
		this.idOperation = idOperation;
	}
	public String getNumeroOperation() {
		return numeroOperation;
	}
	public void setNumeroOperation(String numeroOperation) {
		this.numeroOperation = numeroOperation;
	}
	public Date getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	
	public String getTypeOperation() {
		return typeOperation;
	}
	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
	}

	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	
	public Collection<Compte> getListeComptes() {
		return listeComptes;
	}
	public void setListeComptes(Collection<Compte> listeComptes) {
		this.listeComptes = listeComptes;
	}
	public Operations() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Operations(String typeOperation, double montant) {
		this.typeOperation = typeOperation;
		this.montant = montant;
		this.dateOperation= new Date();
		//this.listeComptes= new HashSet<>();
	}

}
