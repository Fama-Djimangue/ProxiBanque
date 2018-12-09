package sn.objis.proxibanqueV2.services;

import java.util.List;

import sn.objis.proxibanqueV2.dao.DataAccessException;
import sn.objis.proxibanqueV2.dao.EmployerDAO;
import sn.objis.proxibanqueV2.domaine.CompteUtilisateur;
import sn.objis.proxibanqueV2.domaine.Employer;

public class EmployerService implements IEmployerService {
	private EmployerDAO employerDAO = new EmployerDAO();

	@Override
	public void createConseiller(Employer conseiller, CompteUtilisateur compteGerant,Employer gerant) {

		employerDAO.createConseiller(conseiller, compteGerant, gerant);
	}

	@Override
	public void create(Employer employer) {
		employerDAO.create(employer);
	}

	@Override
	public Employer find(long id) {
		// TODO Auto-generated method stub
		return employerDAO.find(id);
	}

	@Override
	public Employer find() {
		// TODO Auto-generated method stub
		return employerDAO.find();
	}

	@Override
	public Employer update(Employer employer) throws DataAccessException {
		// TODO Auto-generated method stub
		return employerDAO.update(employer);
	}

	@Override
	public void delete(Employer employer) {
		employerDAO.delete(employer);

	}

	@Override
	public void delete(long id) {
		employerDAO.delete(id);

	}

	@Override
	public List<Employer> findAll() {
		// TODO Auto-generated method stub
		return employerDAO.findAll();
	}

	@Override
	public List<Employer> findConseiller() {

		return employerDAO.findConseiller();
	}

	@Override
	public Employer findByEmail(String email) {

		return employerDAO.findByEmail(email);
	}

	@Override
	public long findIdAgence(Employer gerant){
		return employerDAO.findIdAgence(gerant);
	}
	
	@Override
	public long findIdCompteuser(Employer gerant) {
		return employerDAO.findIdCompteuser(gerant);
	}

	@Override
	public Employer findByIdCompteUser(CompteUtilisateur compteUtilisateur) {

		return employerDAO.findByIdCompteUser(compteUtilisateur);
	}
	
	public long findIdGerantByCons(Employer conseiller) {
		return employerDAO.findIdGerantByCons(conseiller);
	}
}
