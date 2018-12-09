package sn.objis.proxibanquev3.services;

import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;

import sn.objis.proxibanquev3.entities.Client;
import sn.objis.proxibanquev3.entities.Compte;
import sn.objis.proxibanquev3.entities.Employe;
import sn.objis.proxibanquev3.entities.Operations;




public interface ICompteService {
	
	public Compte addCompte(Compte compte, Client client, Employe emp);
	
	//public Compte addCompte(Compte compte, Long codeClient, Long codeEmploye);

	//public Compte consulterCompte(Compte cpt);

	//public List<Compte> getCompteByEmploye(Long codeEmploye);
	
	public Compte findByNumeroCompte(String numCompte);
	
		public List<Compte> findByClient(Client client);
		
		public List<Compte> findByEmploye(Employe employe);
		
		public Page<Operations> findByListeOperations(Collection<Operations> listeOp, int page, int size);
	
		public Long maxIdCompte();
}

