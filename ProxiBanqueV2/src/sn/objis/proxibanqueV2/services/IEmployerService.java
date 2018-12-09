package sn.objis.proxibanqueV2.services;

import java.util.List;

import sn.objis.proxibanqueV2.domaine.CompteUtilisateur;
import sn.objis.proxibanqueV2.domaine.Employer;

public interface IEmployerService extends IService<Employer> {

	public void createConseiller(Employer conseiller, CompteUtilisateur compteGerant, Employer gerant);

	public abstract List<Employer> findConseiller();

	public abstract Employer findByEmail(String email);

	public long findIdCompteuser(Employer gerant);

	public abstract long findIdAgence(Employer gerant);
	
	public  abstract Employer findByIdCompteUser(CompteUtilisateur compteUtilisateur);
}
