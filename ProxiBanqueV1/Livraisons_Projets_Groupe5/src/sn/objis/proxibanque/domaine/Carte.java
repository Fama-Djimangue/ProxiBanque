package sn.objis.proxibanque.domaine;

import java.sql.Date;

public class Carte {

	// Déclaration des proprietés

	private long id_carte;
	private double solde_carte;
	private String type_carte;
	private Date date_activation;
	private Date date_desactivation;

	// Constructeurs

	/**
	 * @param id_carte
	 * @param solde_carte
	 * @param type_carte
	 * @param date_activation
	 * @param date_desactivation
	 * @param listClient
	 */
	public Carte(long id_carte, double solde_carte, String type_carte, Date date_activation, Date date_desactivation) {
		super();
		this.id_carte = id_carte;
		this.solde_carte = solde_carte;
		this.type_carte = type_carte;
		this.date_activation = date_activation;
		this.date_desactivation = date_desactivation;

	}

	/**
	 * 
	 */
	public Carte() {
		super();
	}

	// les getters et setters

	/**
	 * @return the id_carte
	 */
	public long getId_carte() {
		return id_carte;
	}

	/**
	 * @param id_carte
	 *            the id_carte to set
	 */
	public void setId_carte(long id_carte) {
		this.id_carte = id_carte;
	}

	/**
	 * @return the solde_carte
	 */
	public double getSolde_carte() {
		return solde_carte;
	}

	/**
	 * @param solde_carte
	 *            the solde_carte to set
	 */
	public void setSolde_carte(double solde_carte) {
		this.solde_carte = solde_carte;
	}

	/**
	 * @return the type_carte
	 */
	public String getType_carte() {
		return type_carte;
	}

	/**
	 * @param type_carte
	 *            the type_carte to set
	 */
	public void setType_carte(String type_carte) {
		this.type_carte = type_carte;
	}

	/**
	 * @return the date_activation
	 */
	public Date getDate_activation() {
		return date_activation;
	}

	/**
	 * @param date_activation
	 *            the date_activation to set
	 */
	public void setDate_activation(Date date_activation) {
		this.date_activation = date_activation;
	}

	/**
	 * @return the date_desactivation
	 */
	public Date getDate_desactivation() {
		return date_desactivation;
	}

	/**
	 * @param date_desactivation
	 *            the date_desactivation to set
	 */
	public void setDate_desactivation(Date date_desactivation) {
		this.date_desactivation = date_desactivation;
	}

}
