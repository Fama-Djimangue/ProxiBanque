package sn.objis.proxibanque.services;

import java.util.List;


import sn.objis.proxibanque.dao.AgenceDAO;
import sn.objis.proxibanque.dao.DataAccessException;
import sn.objis.proxibanque.domaine.Agence;

public class AgenceService implements IAgenceService {
	
	private AgenceDAO agencedao = new AgenceDAO(); // La couche service a besoin de la couche DAO

	@Override
	public void create(Agence agence) {
		// TODO Auto-generated method stub
	agencedao.create(agence);
		
	}

	@Override
	public Agence find(long id) {
		// TODO Auto-generated method stub
		return agencedao.find(id);
	}

	@Override
	public Agence find() {
		// TODO Auto-generated method stub
		return agencedao.find();
	}

	@Override
	public List<Agence> findAll() {
		// TODO Auto-generated method stub
		return agencedao.findAll();
	}

	@Override
	public Agence update(Agence agence) throws DataAccessException {
		// TODO Auto-generated method stub
		return agencedao.update(agence);
	}

	@Override
	public void delete(Agence agence) {
		// TODO Auto-generated method stub
		agencedao.delete(agence);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		agencedao.delete(id);
	}

}
