package sn.objis.proxibanquev3.entities;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value = "Gérent")
public class Gérent extends Employe {
	
	@ManyToOne
    @JoinColumn(name="CODE_ADMIN")
    private Employe admin; // Un admin creer un gérent

	public Gérent() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Employe getAdmin() {
		return admin;
	}

	public void setAdmin(Employe admin) {
		this.admin = admin;
	}

	public Gérent(Employe admin) {
		super();
		this.admin = admin;
	}

	
	
	}

	
	
	
