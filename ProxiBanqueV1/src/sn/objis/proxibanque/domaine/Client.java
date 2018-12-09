package sn.objis.proxibanque.domaine;

public class Client {

	// Déclarations

	
	private long id_client;
	private String nom_client;
	private String prenom_client;
	private String email_client;
	private String adresse_client;
	private String code_postal;
	private String ville_client;
	private String telephone_client;
	private String profession_client;

	// Construteurs

	/**
	 * @param id_client
	 * @param nom_client
	 * @param prenom_client
	 * @param email_client
	 * @param adresse_client
	 * @param code_postal
	 * @param ville_client
	 * @param telephone_client
	 * @param profession_client
	 */
	public Client(long id_client, String nom_client, String prenom_client, String email_client, String adresse_client,
			String code_postal, String ville_client, String telephone_client, String profession_client) {
		this.id_client = id_client;
		this.nom_client = nom_client;
		this.prenom_client = prenom_client;
		this.email_client = email_client;
		this.adresse_client = adresse_client;
		this.code_postal = code_postal;
		this.ville_client = ville_client;
		this.telephone_client = telephone_client;
		this.profession_client = profession_client;

	}

	/**
	 * @param nom_client
	 * @param prenom_client
	 * @param email_client
	 * @param adresse_client
	 * @param code_postal
	 * @param ville_client
	 * @param telephone_client
	 * @param profession_client
	 */
	public Client(String nom_client, String prenom_client, String email_client, String adresse_client,
			String code_postal, String ville_client, String telephone_client, String profession_client) {
		super();
		this.nom_client = nom_client;
		this.prenom_client = prenom_client;
		this.email_client = email_client;
		this.adresse_client = adresse_client;
		this.code_postal = code_postal;
		this.ville_client = ville_client;
		this.telephone_client = telephone_client;
		this.profession_client = profession_client;
	}

	
	
	/**
	 * @param nom_client
	 * @param prenom_client
	 * @param email_client
	 * @param adresse_client
	 * @param code_postal
	 * @param ville_client
	 * @param telephone_client
	 * @param profession_client
	 * @param id_conseiller
	 */
/*	public Client(String nom_client, String prenom_client,
			String email_client, String adresse_client, String code_postal,
			String ville_client, String telephone_client,
			String profession_client,long id_conseiller) {
		super();
		this.id_conseiller = id_conseiller;
		this.nom_client = nom_client;
		this.prenom_client = prenom_client;
		this.email_client = email_client;
		this.adresse_client = adresse_client;
		this.code_postal = code_postal;
		this.ville_client = ville_client;
		this.telephone_client = telephone_client;
		this.profession_client = profession_client;
	}
*/
	
	/**
	 * 
	 */
	public Client() {
		super();
	}

	// les getters et setters

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

	/**
	 * @return the nom_client
	 */
	public String getNom_client() {
		return nom_client;
	}

	/**
	 * @param nom_client
	 *            the nom_client to set
	 */
	public void setNom_client(String nom_client) {
		this.nom_client = nom_client;
	}

	/**
	 * @return the prenom_client
	 */
	public String getPrenom_client() {
		return prenom_client;
	}

	/**
	 * @param prenom_client
	 *            the prenom_client to set
	 */
	public void setPrenom_client(String prenom_client) {
		this.prenom_client = prenom_client;
	}

	/**
	 * @return the email_client
	 */
	public String getEmail_client() {
		return email_client;
	}

	/**
	 * @param email_client
	 *            the email_client to set
	 */
	public void setEmail_client(String email_client) {
		this.email_client = email_client;
	}

	/**
	 * @return the adresse_client
	 */
	public String getAdresse_client() {
		return adresse_client;
	}

	/**
	 * @param adresse_client
	 *            the adresse_client to set
	 */
	public void setAdresse_client(String adresse_client) {
		this.adresse_client = adresse_client;
	}

	/**
	 * @return the code_postal
	 */
	public String getCode_postal() {
		return code_postal;
	}

	/**
	 * @param code_postal
	 *            the code_postal to set
	 */
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	/**
	 * @return the ville_client
	 */
	public String getVille_client() {
		return ville_client;
	}

	/**
	 * @param ville_client
	 *            the ville_client to set
	 */
	public void setVille_client(String ville_client) {
		this.ville_client = ville_client;
	}

	/**
	 * @return the telephone_client
	 */
	public String getTelephone_client() {
		return telephone_client;
	}

	/**
	 * @param telephone_client
	 *            the telephone_client to set
	 */
	public void setTelephone_client(String telephone_client) {
		this.telephone_client = telephone_client;
	}

	/**
	 * @return the profession_client
	 */
	public String getProfession_client() {
		return profession_client;
	}

	/**
	 * @param profession_client
	 *            the profession_client to set
	 */
	public void setProfession_client(String profession_client) {
		this.profession_client = profession_client;
	}

	

}