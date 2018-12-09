package sn.objis.proxibanquev3.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.objis.proxibanquev3.entities.Client;
import sn.objis.proxibanquev3.entities.Employe;



public interface ClientRepository  extends JpaRepository<Client, Long>{
	
	public List<Client> findByEmploye(Employe conseiller);
	
	public Client findByEmailClient(String email);
	
	}
