package sn.objis.proxibanquev3.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sn.objis.proxibanquev3.entities.Client;
import sn.objis.proxibanquev3.entities.Compte;
import sn.objis.proxibanquev3.entities.Employe;
import sn.objis.proxibanquev3.entities.Operations;



public interface CompteRepository extends JpaRepository<Compte, Long> {	
	public Compte findByNumeroCompte(String numCompte);
	public List<Compte> findByClient(Client client);	
	public List<Compte> findByEmploye(Employe employe);	
	public Page<Operations> findByListeOperations(Collection<Operations> listeOp,Pageable pageable);	
	@Query("SELECT max(idCompte) from Compte")
	public Long maxIdCompte();
}
