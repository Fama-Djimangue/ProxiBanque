package sn.objis.proxibanqueV2.dao;

import java.util.List;

/**
 * Interface générique: contient uniquement des déclarations
 * des methode communes aux classes 
 * qui vont implémentés ces méthodes
 * 
 *@author Djimangue-Fama
 *@version 2.0 ProxiBanquev1
 *
 */
public interface IDAO <T>{
	
	public abstract void create(T t);

	public abstract T find(long id);

	public abstract T find();

	public abstract List<T> findAll();
	
	public abstract T update(T t) throws DataAccessException;

	public abstract void delete(T t);

	public abstract void delete(long id);
	
	
}
