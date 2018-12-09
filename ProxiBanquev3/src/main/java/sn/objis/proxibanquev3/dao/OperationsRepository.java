package sn.objis.proxibanquev3.dao;

import java.util.Collection;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sn.objis.proxibanquev3.entities.Operations;

public interface OperationsRepository extends JpaRepository<Operations, Long> {
	@Query("select c.listeOperations from Compte c where c.listeOperations=:x")
	public Page<Operations> listOperation(@Param("x") Collection<Operations> listeOp,Pageable pageable);

	@Query("select c from Compte c where c.listeOperations=:x")
	public Page<Operations> listOperations(@Param("x") Collection<Operations> listeOp,Pageable pageable);

	@SuppressWarnings("rawtypes")
	public abstract Page<Operations> findByListeComptes(Collection listeComptes, Pageable pageable);

	@Query("SELECT max(idOperation) from Operations")
	public Long maxIdOperation();
}
