package sn.objis.proxibanque.dao;

import sn.objis.proxibanque.domaine.Client;

public interface IClientDAO extends IDAO<Client> {

	public abstract long dernierId(Client client);

	public abstract Client findByEmail(String email);

}
