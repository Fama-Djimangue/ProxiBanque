package sn.objis.proxibanque.services;

import java.util.List;

import sn.objis.proxibanque.dao.CompteDAO;
import sn.objis.proxibanque.dao.DataAccessException;
import sn.objis.proxibanque.domaine.Client;
import sn.objis.proxibanque.domaine.Compte;


public class CompteService implements ICompteService{

	private CompteDAO compteDAO = new CompteDAO();
	
	public void create(Compte compte, Client client) {
		// TODO Auto-generated method stub
		compteDAO.create(compte, client);
	}

	@Override
	public void create(Compte compte) {
		// TODO Auto-generated method stub
		compteDAO.create(compte);
	}

	@Override
	public Compte find(long id) {
		// TODO Auto-generated method stub
		return compteDAO.find(id);
	}

	@Override
	public Compte find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compte update(Compte compte) throws DataAccessException {
		// TODO Auto-generated method stub
		return compteDAO.update(compte);
	}

	@Override
	public void delete(Compte compte) {
		compteDAO.delete(compte);
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Compte> findAll() {
		
		return compteDAO.findAll();
	}

	@Override
	public Compte findByNumero(String numero) {
		// TODO Auto-generated method stub
		return compteDAO.findByNumero(numero);
	}

	@Override
	public long findIdClient(Compte compte) {
		// TODO Auto-generated method stub
		return compteDAO.findIdClient(compte);
	}

}
