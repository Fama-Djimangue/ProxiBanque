package sn.objis.proxibanque.services;

import java.util.List;





import sn.objis.proxibanque.dao.CarteDAO;
import sn.objis.proxibanque.dao.DataAccessException;
import sn.objis.proxibanque.domaine.Carte;

public class CarteService implements ICarteService {
	
	private CarteDAO cartedao = new CarteDAO(); // La couche service a besoin de la couche DAO

	@Override
	public void create(Carte carte) {
		// TODO Auto-generated method stub
		cartedao.create(carte);
	}

	@Override
	public Carte find(long id) {
		// TODO Auto-generated method stub
		return cartedao.find(id);
	}

	@Override
	public Carte find() {
		// TODO Auto-generated method stub
		return cartedao.find();
	}

	@Override
	public List<Carte> findAll() {
		// TODO Auto-generated method stub
		return cartedao.findAll();
	}

	@Override
	public Carte update(Carte t) throws DataAccessException {
		// TODO Auto-generated method stub
		return cartedao.update(t);
	}

	@Override
	public void delete(Carte carte) {
		// TODO Auto-generated method stub
		cartedao.create(carte);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		cartedao.delete(id);
	}


}
