package sn.objis.proxibanqueV2.dao;

import java.util.List;

import sn.objis.proxibanqueV2.domaine.Client;
import sn.objis.proxibanqueV2.domaine.Employer;

public interface IClientDAO extends IDAO<Client> {

	public abstract List<Client> findClientsDuConseiller(Employer conseiller);
	
	public abstract long dernierId(Client client);

	public abstract Client findByEmail(String email);
	
	public abstract long findLastId();
	
	

}
