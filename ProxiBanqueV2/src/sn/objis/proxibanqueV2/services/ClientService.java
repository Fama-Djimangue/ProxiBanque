package sn.objis.proxibanqueV2.services;

import java.util.List;

import sn.objis.proxibanqueV2.dao.ClientDAO;
import sn.objis.proxibanqueV2.domaine.Client;
import sn.objis.proxibanqueV2.domaine.Employer;

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
	public Client update(Client client){
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

	public Client findByEmail(String email){
		return clientdao.findByEmail(email);
	}
	@Override
	public long AfficherLastId() {
		// TODO Auto-generated method stub
		return clientdao.findLastId();
	}
	@Override
	public List<Client> findClientsDuConseiller(Employer conseiller) {
		// TODO Auto-generated method stub
		return clientdao.findClientsDuConseiller(conseiller);
	}
	@Override
	public long dernierId(Client client) {
		// TODO Auto-generated method stub
		return 0;
	}
}
