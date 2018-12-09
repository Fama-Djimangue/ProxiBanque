package sn.objis.proxibanque.services;

import java.util.List;

import sn.objis.proxibanque.dao.ClientDAO;
import sn.objis.proxibanque.dao.DataAccessException;
import sn.objis.proxibanque.domaine.Client;
import sn.objis.proxibanque.domaine.Employer;

public class ClientService implements IClientService{
	
	private ClientDAO clientdao = new ClientDAO(); // La couche service a besoin de la couche DAO

	public void create(Client client, Employer conseiller) {
		clientdao.create(client, conseiller);
	}
	@Override
	public void create(Client client) {
		// TODO Auto-generated method stub
		clientdao.create(client);
	}

	@Override
	public Client find(long id) {
		// TODO Auto-generated method stub
		return clientdao.find(id);
	}

	@Override
	public Client find() {
		// TODO Auto-generated method stub
		return clientdao.find();
	}

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return clientdao.findAll();
	}

	@Override
	public Client update(Client client) throws DataAccessException {
		// TODO Auto-generated method stub
		return clientdao.update(client);
	}

	@Override
	public void delete(Client client) {
		// TODO Auto-generated method stub
		clientdao.delete(client);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		clientdao.delete(id);
	}

	public long dernierId(Client client){
		return clientdao.dernierId(client);
	}
	
	public Client findByEmail(String email){
		return clientdao.findByEmail(email);
	}
}
