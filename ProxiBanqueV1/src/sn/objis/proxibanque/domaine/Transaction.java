package sn.objis.proxibanque.domaine;

import java.sql.Date;
import java.util.List;

public class Transaction {

	//Declaration des pro
	private long id_transact;

	private String numero_transact;
	private Date date_transact;
	private double montant_transact;
	private String type_transact;
	private List<Employer> listEmployer;
	
	//constructeurs
	
	/**
	 * 
	 */
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param numero_transact
	 * @param montant_transact
	 * @param type_transact
	 * @param compte
	 */
	public Transaction(String numero_transact, double montant_transact, String type_transact) {
		super();
		this.numero_transact = numero_transact;
		this.montant_transact = montant_transact;
		this.type_transact = type_transact;
	}

	
	/**
	 * @param id_transact
	 * @param idEmployer
	 * @param numero_transact
	 * @param date_transact
	 * @param montant_transact
	 * @param type_transact
	 * @param listEmployer
	 */
	public Transaction(long id_transact, String numero_transact, Date date_transact,
			double montant_transact, String type_transact, List<Employer> listEmployer) {
		super();
		this.id_transact = id_transact;
		this.numero_transact = numero_transact;
		this.date_transact = date_transact;
		this.montant_transact = montant_transact;
		this.type_transact = type_transact;
		this.listEmployer = listEmployer;
	}

	//getters et setters
	/**
	 * @return the id_transact
	 */
	public long getId_transact() {
		return id_transact;
	}
	/**
	 * @param id_transact the id_transact to set
	 */
	public void setId_transact(long id_transact) {
		this.id_transact = id_transact;
	}
	/**
	 * @return the numero_transact
	 */
	public String getNumero_transact() {
		return numero_transact;
	}
	/**
	 * @param numero_transact the numero_transact to set
	 */
	public void setNumero_transact(String numero_transact) {
		this.numero_transact = numero_transact;
	}
	/**
	 * @return the date_transact
	 */
	public Date getDate_transact() {
		return date_transact;
	}
	/**
	 * @param date_transact the date_transact to set
	 */
	public void setDate_transact(Date date_transact) {
		this.date_transact = date_transact;
	}
	/**
	 * @return the montant_transact
	 */
	public double getMontant_transact() {
		return montant_transact;
	}
	/**
	 * @param montant_transact the montant_transact to set
	 */
	public void setMontant_transact(double montant_transact) {
		this.montant_transact = montant_transact;
	}
	/**
	 * @return the type_transact
	 */
	public String getType_transact() {
		return type_transact;
	}
	/**
	 * @param type_transact the type_transact to set
	 */
	public void setType_transact(String type_transact) {
		this.type_transact = type_transact;
	}
	/**
	 * @return the listEmployer
	 */
	public List<Employer> getListEmployer() {
		return listEmployer;
	}
	/**
	 * @param listEmployer the listEmployer to set
	 */
	public void setListEmployer(List<Employer> listEmployer) {
		this.listEmployer = listEmployer;
	}
	
	
	
}
