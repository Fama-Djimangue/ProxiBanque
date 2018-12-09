package sn.objis.proxibanque.dao;

import sn.objis.proxibanque.domaine.Compte;

public interface ICompteDAO extends IDAO<Compte> {
	
	public abstract Compte findByNumero(String numero);

	public abstract long findIdClient(Compte compte);
}
