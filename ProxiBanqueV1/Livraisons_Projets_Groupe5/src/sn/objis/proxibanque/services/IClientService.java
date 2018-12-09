package sn.objis.proxibanque.services;

import sn.objis.proxibanque.domaine.Client;

public interface IClientService extends IService<Client> {
	
	public abstract long dernierId(Client client);

	public abstract Client findByEmail(String email);

}
