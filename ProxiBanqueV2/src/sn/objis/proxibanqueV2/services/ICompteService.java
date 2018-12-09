package sn.objis.proxibanqueV2.services;

import java.util.List;

import sn.objis.proxibanqueV2.domaine.Compte;

public interface ICompteService extends IService<Compte> {
	
	public abstract Compte findByNumero(String numero);
	
	public abstract long findIdClient(Compte compte);
	
	public abstract List<Compte> findByIdClient(long id);

}
