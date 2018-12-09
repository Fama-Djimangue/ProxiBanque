package sn.objis.proxibanqueV2.services;

import java.util.List;

import sn.objis.proxibanqueV2.domaine.Client;
import sn.objis.proxibanqueV2.domaine.Employer;

public interface IClientService extends IService<Client> {
	
	public abstract List<Client> findClientsDuConseiller(Employer conseiller);
	
	public abstract long dernierId(Client client);

	public abstract Client findByEmail(String email);
	
	public abstract long AfficherLastId();

}
