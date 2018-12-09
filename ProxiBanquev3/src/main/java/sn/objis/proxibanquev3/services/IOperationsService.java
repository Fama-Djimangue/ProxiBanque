package sn.objis.proxibanquev3.services;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import sn.objis.proxibanquev3.entities.Compte;
import sn.objis.proxibanquev3.entities.Operations;



public interface IOperationsService {

	public Long maxIdOperation();
	
	public  void createOperation(Operations operation);

	public abstract void crediter(Compte compte, double montant);

	public abstract void debiter(Compte compte, double montant);

	public abstract void virementComptACompte(Compte compte1, Compte compte2, double montant);

		@SuppressWarnings("rawtypes")
	public abstract Page<Operations> findByListeComptes(Collection listeComptes, int page, int size);
	
	public Page<Operations> listOperation(Collection<Operations> listeOp, int page, int size);
	public Page<Operations> listOperations(Collection<Operations> listeOp, int page, int size);


}
