package sn.objis.proxibanquev3.services;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sn.objis.proxibanquev3.dao.CompteRepository;
import sn.objis.proxibanquev3.entities.Client;
import sn.objis.proxibanquev3.entities.Compte;
import sn.objis.proxibanquev3.entities.Employe;
import sn.objis.proxibanquev3.entities.Operations;
import sn.objis.proxibanquev3.utils.MethodUtils;



@Service
@Transactional
public class CompteServiceImpl implements ICompteService{

	@Autowired
	private CompteRepository  compteRepository;
	
	@Override
	public Compte addCompte(Compte compte, Client client, Employe emp) {
		compte.setClient(client);
		compte.setNumeroCompte(MethodUtils.genererNumero(this.maxIdCompte(), compte.getClass().getSimpleName()));
		compte.setEmploye(emp);
	  compteRepository.save(compte);
      return compte;
	}

/*

	@Override
	public Compte consulterCompte(Compte cpt) {
		Compte cp = this.findByNumeroCompte(cpt.getNumeroCompte());
		if (cp == null) throw new RuntimeException("Compte inexistant !!!");
		return cp;
	}
*/

	@Override
	public Compte findByNumeroCompte(String numCompte) {
	return  compteRepository.findByNumeroCompte(numCompte);
	}

	@Override
	public List<Compte> findByClient(Client client) {
	return compteRepository.findByClient(client);
	}

	@Override
	public List<Compte> findByEmploye(Employe employe) {
	return compteRepository.findByEmploye(employe);
	}

	@Override
	public Long maxIdCompte() {
		if (compteRepository.maxIdCompte()==null) {
			return 1L;
		}else {
			return compteRepository.maxIdCompte()+1;
		}
		
	}

	@Override
	public Page<Operations> findByListeOperations(Collection<Operations> listeOp, int page, int size) {
		// TODO Auto-generated method stub
		return compteRepository.findByListeOperations(listeOp, new PageRequest(page, size));
	}



}
