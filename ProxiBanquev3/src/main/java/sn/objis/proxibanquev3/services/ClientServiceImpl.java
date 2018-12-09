package sn.objis.proxibanquev3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sn.objis.proxibanquev3.dao.ClientRepository;
import sn.objis.proxibanquev3.entities.Client;
import sn.objis.proxibanquev3.entities.Employe;



@Service
@Transactional
public class ClientServiceImpl implements IClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	
	/*@Override
	public List<Client> findClientsDuConseiller(Employe conseiller) {
	return clientRepository.findByEmploye(conseiller);
	}
*/
	@Override
	public Client findByEmail(String email) {
	return clientRepository.findByEmailClient(email);
	}

	
	@Override
	public Client create(Client client) {
	return clientRepository.save(client);
	}

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public Client editer(Long id) {
	Client client = clientRepository.getOne(id);
	return client;
	}

	@Override
	public Client update(Client client) {
    return clientRepository.save(client);
	}

	@Override
	public List<Client> findByEmploye(Employe conseiller) {
	return clientRepository.findByEmploye(conseiller);
	}


	@Override
	public Client findClient(Long idclient) {
	return clientRepository.findOne(idclient);
	}



}
