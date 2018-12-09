package sn.objis.proxibanqueV2.services;

import java.util.List;

import sn.objis.proxibanqueV2.dao.DataAccessException;



public interface IService <T>{
	
	public abstract void create(T t);

	public abstract T find(long id);

	public abstract T find();

	public abstract List<T> findAll();
	
	public abstract T update(T t) throws DataAccessException;

	public abstract void delete(T t);

	public abstract void delete(long id);

}
