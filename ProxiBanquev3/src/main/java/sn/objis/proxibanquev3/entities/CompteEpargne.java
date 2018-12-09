package sn.objis.proxibanquev3.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "EPARGNE")
public class CompteEpargne extends Compte {

	protected double taux;

	public CompteEpargne() {
		super();

	}

	public CompteEpargne(double solde, double taux) {
		super(solde);
		this.taux = taux;
	}


public CompteEpargne(String codeCompte, Date dateCreation, double solde, Client client, Employe employe,
			double taux) {
		super(codeCompte, dateCreation, solde, client, employe);
		this.taux = taux;
	}

	public CompteEpargne(String numeroCompte, Date dateCreation, double solde, Client client, Employe employe) {
		super(numeroCompte, dateCreation, solde, client, employe);
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}


}
