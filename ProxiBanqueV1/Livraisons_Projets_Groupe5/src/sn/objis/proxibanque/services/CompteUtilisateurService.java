package sn.objis.proxibanque.services;

import java.util.List;

import sn.objis.proxibanque.dao.CompteUtilisateurDAO;
import sn.objis.proxibanque.dao.DataAccessException;
import sn.objis.proxibanque.domaine.CompteUtilisateur;

public class CompteUtilisateurService implements ICompteUtilisateurService{

	
	private CompteUtilisateurDAO compteUtilisateurDAO= new CompteUtilisateurDAO();
	
	
	@Override
	public void create(CompteUtilisateur compteUtilisateur) {
		compteUtilisateurDAO.create(compteUtilisateur);
		
	}

	@Override
	public CompteUtilisateur find(long id) {
		
		return compteUtilisateurDAO.find(id);
	}

	@Override
	public CompteUtilisateur find() {
		
		return compteUtilisateurDAO.find();
	}

	@Override
	public List<CompteUtilisateur> findAll() {
		
		return compteUtilisateurDAO.findAll();
	}

	@Override
	public CompteUtilisateur update(CompteUtilisateur compteUtilisateur) throws DataAccessException {
		
		return compteUtilisateurDAO.update(compteUtilisateur);
	}

	@Override
	public void delete(CompteUtilisateur compteUtilisateur) {
		compteUtilisateurDAO.delete(compteUtilisateur);
		
	}

	@Override
	public void delete(long id) {
		compteUtilisateurDAO.delete(id);
		
	}

	@Override
	public CompteUtilisateur authentifierUser(String login, String pwd) {
		
		return compteUtilisateurDAO.authentifierUser(login, pwd);
	}

	@Override
	public CompteUtilisateur recupererUtilisateurParLogin(String login) {
		
		return compteUtilisateurDAO.recupererUtilisateurParLogin(login);
	}

	@Override
	public CompteUtilisateur updateMdp(CompteUtilisateur compteUtilisateur, String nveMdp) {

		return compteUtilisateurDAO.updateMdp(compteUtilisateur, nveMdp);
	}
	
	public long dernierIdCompteUser(CompteUtilisateur compteUtilisateur){
		return compteUtilisateurDAO.dernierIdCompteUser(compteUtilisateur);
	}

	
}
