package sn.objis.proxibanqueV2.dao;

import java.util.List;

/**
 * Interface g�n�rique: contient uniquement des d�clarations
 * des methode communes aux classes 
 * qui vont impl�ment�s ces m�thodes
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
