package sn.objis.proxibanqueV2.domaine;

public class Employer {
	
	private long id_employer;
	private String nom_employer;
	private String prenom_employer;
	private String email_employer;
	private String adresse_employer;
	private String code_postal;
	private String ville_employer;
	private String telephone_employer;
	private String type_employer;
		
	private long compteUser, agence, gerant;
	
	// Constructeurs
	/**
	 * 
	 */
	public Employer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	/**
	 * @param id_employer
	 * @param nom_employer
	 * @param prenom_employer
	 * @param email_employer
	 * @param adresse_employer
	 * @param code_postal
	 * @param ville_employer
	 * @param telephone_employer
	 */
	public Employer(long id_employer, String nom_employer,
			String prenom_employer, String email_employer,
			String adresse_employer, String code_postal, String ville_employer,
			String telephone_employer) {
		super();
		this.id_employer = id_employer;
		this.nom_employer = nom_employer;
		this.prenom_employer = prenom_employer;
		this.email_employer = email_employer;
		this.adresse_employer = adresse_employer;
		this.code_postal = code_postal;
		this.ville_employer = ville_employer;
		this.telephone_employer = telephone_employer;
	}





	/**
	 * @param nom_employer
	 * @param prenom_employer
	 * @param email_employer
	 * @param adresse_employer
	 * @param code_postal
	 * @param ville_employer
	 * @param telephone_employer
	 * @param type_employer
	 */
	public Employer(String nom_employer, String prenom_employer, String email_employer,
			String adresse_employer, String code_postal, String ville_employer, String telephone_employer,
			String type_employer) {
		super();
		this.nom_employer = nom_employer;
		this.prenom_employer = prenom_employer;
		this.email_employer = email_employer;
		this.adresse_employer = adresse_employer;
		this.code_postal = code_postal;
		this.ville_employer = ville_employer;
		this.telephone_employer = telephone_employer;
		this.type_employer = type_employer;
	}
	
	
	
	/**
	 * @param nom_employer
	 * @param prenom_employer
	 * @param email_employer
	 * @param adresse_employer
	 * @param code_postal
	 * @param ville_employer
	 * @param telephone_employer
	 */
	public Employer(String nom_employer, String prenom_employer,
			String email_employer, String adresse_employer, String code_postal,
			String ville_employer, String telephone_employer) {
		super();
		this.nom_employer = nom_employer;
		this.prenom_employer = prenom_employer;
		this.email_employer = email_employer;
		this.adresse_employer = adresse_employer;
		this.code_postal = code_postal;
		this.ville_employer = ville_employer;
		this.telephone_employer = telephone_employer;
	}

	//getters et setters
	
	/**
	 * @return the id_employer
	 */
	public long getId_employer() {
		return id_employer;
	}
	/**
	 * @param id_employer the id_employer to set
	 */
	public void setId_employer(long id_employer) {
		this.id_employer = id_employer;
	}
	/**
	 * @return the nom_employer
	 */
	public String getNom_employer() {
		return nom_employer;
	}
	/**
	 * @param nom_employer the nom_employer to set
	 */
	public void setNom_employer(String nom_employer) {
		this.nom_employer = nom_employer;
	}
	/**
	 * @return the prenom_employer
	 */
	public String getPrenom_employer() {
		return prenom_employer;
	}
	/**
	 * @param prenom_employer the prenom_employer to set
	 */
	public void setPrenom_employer(String prenom_employer) {
		this.prenom_employer = prenom_employer;
	}
	/**
	 * @return the email_employer
	 */
	public String getEmail_employer() {
		return email_employer;
	}
	/**
	 * @param email_employer the email_employer to set
	 */
	public void setEmail_employer(String email_employer) {
		this.email_employer = email_employer;
	}
	/**
	 * @return the adresse_employer
	 */
	public String getAdresse_employer() {
		return adresse_employer;
	}
	/**
	 * @param adresse_employer the adresse_employer to set
	 */
	public void setAdresse_employer(String adresse_employer) {
		this.adresse_employer = adresse_employer;
	}
	/**
	 * @return the code_postal
	 */
	public String getCode_postal() {
		return code_postal;
	}
	/**
	 * @param code_postal the code_postal to set
	 */
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}
	/**
	 * @return the ville_employer
	 */
	public String getVille_employer() {
		return ville_employer;
	}
	/**
	 * @param ville_employer the ville_employer to set
	 */
	public void setVille_employer(String ville_employer) {
		this.ville_employer = ville_employer;
	}
	/**
	 * @return the telephone_employer
	 */
	public String getTelephone_employer() {
		return telephone_employer;
	}
	/**
	 * @param telephone_employer the telephone_employer to set
	 */
	public void setTelephone_employer(String telephone_employer) {
		this.telephone_employer = telephone_employer;
	}
	/**
	 * @return the type_employer
	 */
	public String getType_employer() {
		return type_employer;
	}
	/**
	 * @param type_employer the type_employer to set
	 */
	public void setType_employer(String type_employer) {
		this.type_employer = type_employer;
	}

	



	/**
	 * @return the compteUser
	 */
	public long getCompteUser() {
		return compteUser;
	}





	/**
	 * @param compteUser the compteUser to set
	 */
	public void setCompteUser(long compteUser) {
		this.compteUser = compteUser;
	}





	/**
	 * @return the agence
	 */
	public long getAgence() {
		return agence;
	}





	/**
	 * @param agence the agence to set
	 */
	public void setAgence(long agence) {
		this.agence = agence;
	}





	/**
	 * @return the gerant
	 */
	public long getGerant() {
		return gerant;
	}





	/**
	 * @param gerant the gerant to set
	 */
	public void setGerant(long gerant) {
		this.gerant = gerant;
	}





	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employer [id_employer=" + id_employer + ", nom_employer="+ nom_employer + ", prenom_employer=" 
			+ prenom_employer + ", email_employer=" + email_employer + ", adresse_employer="+ adresse_employer +""
			+ ", code_postal=" + code_postal+ ", ville_employer=" + ville_employer + ", telephone_employer=" +
			telephone_employer + ", type_employer=" + type_employer + ", id_user=" + compteUser + ","
			+ " id_agence=" + agence + ", id_gerant=" + gerant + "]";
	}

	
}
