package sn.objis.proxibanque.domaine;

import java.sql.Date;

public class Compte {

	// Déclarations

	private long id_compte;
	private long id_client;
	private double solde_compte;
	private String numero_compte;
	private Date date_ouverture;
	private Date date_fermeture;
	private String type_compte;
	private double taux_remuneration;
	private double decouvert;
	// Constructeurs

	/**
	 * 
	 */
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id_client
	 * @param solde_compte
	 * @param numero_compte
	 * @param date_ouverture
	 * @param type_compte
	 * @param taux_remuneration
	 * @param decouvert
	 * @param client
	 */
	public Compte(long id_client, double solde_compte, String numero_compte, String type_compte,
			double taux_remuneration, double decouvert) {
		super();
		this.id_client = id_client;
		this.solde_compte = solde_compte;
		this.numero_compte = numero_compte;
		this.type_compte = type_compte;
		this.taux_remuneration = taux_remuneration;
		this.decouvert = decouvert;
	}

	/**
	 * @param numero_compte
	 * @param date_ouverture
	 * @param type_compte
	 */
	public Compte(String numero_compte) {
		super();
		this.numero_compte = numero_compte;

	}

	/**
	 * @param numero_compte
	 * @param type_compte
	 * @param taux_remuneration
	 */
	public Compte(String numero_compte, String type_compte, double taux_remuneration) {
		super();
		this.numero_compte = numero_compte;
		this.type_compte = type_compte;
		this.taux_remuneration = taux_remuneration;

	}

	/**
	 * @param numero_compte
	 * @param type_compte
	 */
	public Compte(String numero_compte, String type_compte) {
		super();
		this.numero_compte = numero_compte;
		this.type_compte = type_compte;

	}

	/**
	 * @param solde_compte
	 * @param numero_compte
	 * @param date_ouverture
	 * @param type_compte
	 * @param taux_remuneration
	 * @param decouvert
	 */
	public Compte(double solde_compte, String numero_compte, String type_compte,
			double taux_remuneration, double decouvert) {
		super();
		this.solde_compte = solde_compte;
		this.numero_compte = numero_compte;
		this.type_compte = type_compte;
		this.taux_remuneration = taux_remuneration;
		this.decouvert = decouvert;
	}

	// Les getters et setters
	/**
	 * @return the id_compte
	 */
	public long getId_compte() {
		return id_compte;
	}

	/**
	 * @param id_compte
	 *            the id_compte to set
	 */
	public void setId_compte(long id_compte) {
		this.id_compte = id_compte;
	}

	/**
	 * @return the solde_compte
	 */
	public double getSolde_compte() {
		return solde_compte;
	}

	/**
	 * @param solde_compte
	 *            the solde_compte to set
	 */
	public void setSolde_compte(double solde_compte) {
		this.solde_compte = solde_compte;
	}

	/**
	 * @return the numero_compte
	 */
	public String getNumero_compte() {
		return numero_compte;
	}

	/**
	 * @param numero_compte
	 *            the numero_compte to set
	 */
	public void setNumero_compte(String numero_compte) {
		this.numero_compte = numero_compte;
	}

	/**
	 * @return the date_ouverture
	 */
	public Date getDate_ouverture() {
		return date_ouverture;
	}

	/**
	 * @param date_ouverture
	 *            the date_ouverture to set
	 */
	public void setDate_ouverture(Date date_ouverture) {
		this.date_ouverture = date_ouverture;
	}

	/**
	 * @return the date_fermeture
	 */
	public Date getDate_fermeture() {
		return date_fermeture;
	}

	/**
	 * @param date_fermeture
	 *            the date_fermeture to set
	 */
	public void setDate_fermeture(Date date_fermeture) {
		this.date_fermeture = date_fermeture;
	}

	/**
	 * @return the type_compte
	 */
	public String getType_compte() {
		return type_compte;
	}

	/**
	 * @param type_compte
	 *            the type_compte to set
	 */
	public void setType_compte(String type_compte) {
		this.type_compte = type_compte;
	}

	/**
	 * @return the taux_remuneration
	 */
	public double getTaux_remuneration() {
		return taux_remuneration;
	}

	/**
	 * @param taux_remuneration
	 *            the taux_remuneration to set
	 */
	public void setTaux_remuneration(double taux_remuneration) {
		this.taux_remuneration = taux_remuneration;
	}

	/**
	 * @return the decouvert
	 */
	public double getDecouvert() {
		return decouvert;
	}

	/**
	 * @param decouvert
	 *            the decouvert to set
	 */
	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	/**
	 * @return the id_client
	 */
	public long getId_client() {
		return id_client;
	}

	/**
	 * @param id_client
	 *            the id_client to set
	 */
	public void setId_client(long id_client) {
		this.id_client = id_client;
	}

}
