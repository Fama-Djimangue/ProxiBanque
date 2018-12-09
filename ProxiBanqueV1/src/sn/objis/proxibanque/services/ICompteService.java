package sn.objis.proxibanque.services;

import sn.objis.proxibanque.domaine.Compte;

public interface ICompteService extends IService<Compte> {
	
	public abstract Compte findByNumero(String numero);
	
	public abstract long findIdClient(Compte compte);

}
