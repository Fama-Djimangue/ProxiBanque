package sn.objis.proxibanquev3.services;

import java.util.List;

import sn.objis.proxibanquev3.entities.Client;
import sn.objis.proxibanquev3.entities.Employe;

public interface IClientService {
	
	public List<Client> findAll();
	
	public Client create(Client client);
	
	public Client editer(Long id);
	
	public Client update(Client client);
	
	public List<Client> findByEmploye(Employe conseiller);
	
/*public abstract List<Client> findClientsDuConseiller(Employe conseiller);
	*/
	public abstract Client findByEmail(String email);
	
	public Client findClient(Long idclient);
	
	//public List<Compte> findByCodeClient(Long codeClient);
	

}
