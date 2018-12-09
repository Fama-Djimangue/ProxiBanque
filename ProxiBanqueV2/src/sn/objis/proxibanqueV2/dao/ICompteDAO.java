package sn.objis.proxibanqueV2.dao;

import java.util.List;

import sn.objis.proxibanqueV2.domaine.Compte;

public interface ICompteDAO extends IDAO<Compte> {
	
	public abstract Compte findByNumero(String numero);

	public abstract long findIdClient(Compte compte);
	
	public abstract List<Compte> findByIdClient(long id);
}
