package sn.objis.proxibanqueV2.domaine;

import java.sql.Date;

public class Agence {

	// Déclaration des proprietés
	private long id_agence;
	private String libelle_agence;
	private String numero_identification;
	private Date date_creation;

	// Les constructeurs

	/**
	 * @param id_agence
	 * @param libelle_agence
	 * @param numero_identification
	 * @param date_creation
	 */
	public Agence(long id_agence, String libelle_agence, String numero_identification, Date date_creation) {
		this.id_agence = id_agence;
		this.libelle_agence = libelle_agence;
		this.numero_identification = numero_identification;
		this.date_creation = date_creation;
	}

	/**
	 * 
	 */
	public Agence() {
		super();
	}

	// les getters et setters
	/**
	 * @return the id_agence
	 */
	public long getId_agence() {
		return id_agence;
	}

	/**
	 * @param id_agence
	 *            the id_agence to set
	 */
	public void setId_agence(long id_agence) {
		this.id_agence = id_agence;
	}

	/**
	 * @return the libelle_agence
	 */
	public String getLibelle_agence() {
		return libelle_agence;
	}

	/**
	 * @param libelle_agence
	 *            the libelle_agence to set
	 */
	public void setLibelle_agence(String libelle_agence) {
		this.libelle_agence = libelle_agence;
	}

	/**
	 * @return the numero_identification
	 */
	public String getNumero_identification() {
		return numero_identification;
	}

	/**
	 * @param numero_identification
	 *            the numero_identification to set
	 */
	public void setNumero_identification(String numero_identification) {
		this.numero_identification = numero_identification;
	}

	/**
	 * @return the date_reation
	 */
	public Date getDate_creation() {
		return date_creation;
	}

	/**
	 * @param date_reation
	 *            the date_reation to set
	 */
	public void setDate_reation(Date date_creation) {
		this.date_creation = date_creation;
	}

}
