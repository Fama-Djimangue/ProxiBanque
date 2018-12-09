package sn.objis.proxibanquev3.services;

import java.util.List;

import sn.objis.proxibanquev3.entities.Client;
import sn.objis.proxibanquev3.entities.Employe;
import sn.objis.proxibanquev3.entities.User;

public interface IEmployeService{
	
	public Employe findEmploye(Long codeEmp);
	
	public Employe findByuser(User user);
	
	public Employe editeremp(Long id);
	
	public Employe update(Employe employe);
	
	public Employe createConseiller(Employe conseiller);
	
	public Employe createGerent(Employe gerent);

	public abstract List<Employe> findConseiller();

	public abstract Employe findByEmail(String email);
	
	public void  delete(Long id);

}
