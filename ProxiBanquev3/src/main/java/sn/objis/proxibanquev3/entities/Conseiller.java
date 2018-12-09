package sn.objis.proxibanquev3.entities;



import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Conseiller")
public class Conseiller extends Employe {
	


	public Conseiller() {
		super();
		// TODO Auto-generated constructor stub
	}

		

	public Conseiller(String nomEmployer, String prenomEmployer, String emailEmployer, Employe gerent) {
		super(nomEmployer, prenomEmployer, emailEmployer, gerent);
		// TODO Auto-generated constructor stub
	}



	public Conseiller(Long codeEmployer, String nomEmployer, String prenomEmployer, String emailEmployer,
			String telEmployer, User user, Employe gerent) {
		super(codeEmployer, nomEmployer, prenomEmployer, emailEmployer, telEmployer, user, gerent);
		// TODO Auto-generated constructor stub
	}



	public Conseiller(Long codeEmployer) {
		super(codeEmployer);
		// TODO Auto-generated constructor stub
	}



	public Conseiller(String nomEmployer, String prenomEmployer, String emailEmployer, String telEmployer, User user,
			Employe gerent) {
		super(nomEmployer, prenomEmployer, emailEmployer, telEmployer, user, gerent);
		// TODO Auto-generated constructor stub
	}

}
