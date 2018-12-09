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
import sn.objis.proxibanquev3.dao.EmployeRepository;
import sn.objis.proxibanquev3.dao.OperationsRepository;
import sn.objis.proxibanquev3.entities.Compte;
import sn.objis.proxibanquev3.entities.CompteCourant;
import sn.objis.proxibanquev3.entities.CompteEpargne;
import sn.objis.proxibanquev3.entities.Operations;
import sn.objis.proxibanquev3.utils.MethodUtils;



@Service
@Transactional
public class OperationsServiceImpl implements IOperationsService {

	@Autowired
	private CompteRepository compteRepository;

	@Autowired
	private EmployeRepository employeRepository;

	@Autowired
	private OperationsRepository operationsRepository;

	@Override
	public void createOperation(Operations operation) {		
		operation.setNumeroOperation(MethodUtils.genererNumeroOP(this.maxIdOperation(), operation.getTypeOperation()));
		operationsRepository.save(operation);
	}

	@Override
	public void crediter(Compte compte, double montant) {
		double nouveauSolde = compte.getSolde() + montant;

		if (compte.getSolde() < 0) {
			double decouvertMaj = ((CompteCourant) compte).getDecouvert();
			double decouvertAutoriser = 1000;

			if (nouveauSolde > 0) {
				decouvertMaj = decouvertAutoriser;
			} else {
				decouvertMaj = decouvertMaj + montant;

			}
			// S'IL SAGIT D'UN COMPTE COURANT
			((CompteCourant) compte).setDecouvert(decouvertMaj);
		}


		compte.setSolde(nouveauSolde);
		compteRepository.flush();

		
	}

	@Override
	public void debiter(Compte compte, double montant) {
		double maxDispo = 0;
		double nouveauSolde = compte.getSolde() - montant;
		double decouvertMaj = 0;

		if (compte.getSolde() > 0) {
			//il s'agit d'un compte courant
			if (compte instanceof CompteCourant) {
				maxDispo = compte.getSolde() + ((CompteCourant) compte).getDecouvert();
			}
			//il s'agit d'un compte epargne
			if (compte instanceof CompteEpargne) {
				maxDispo = compte.getSolde();
			}
						
		} else {//Si le solde est négatif c'est forcément un compte courant
			maxDispo = ((CompteCourant) compte).getDecouvert();
		}

		if (maxDispo < montant) {//Retrait imposible
			throw new RuntimeException("Solde insuffisant");
		} else {// Retrait possible
			if (compte.getSolde() > 0) { //Le compte peut être épargne ou courant
								
				if (montant > compte.getSolde()) {  
					
					decouvertMaj = ((CompteCourant) compte).getDecouvert() + nouveauSolde;
				}
			} else {
				decouvertMaj = ((CompteCourant) compte).getDecouvert() - montant;
			}
			if(compte instanceof CompteCourant) {
				((CompteCourant) compte).setDecouvert(decouvertMaj);
			}
			
		}

		
		compte.setSolde(nouveauSolde);
		compteRepository.flush();

		
	}

	@Override
	public void virementComptACompte(Compte compteDeb, Compte compteCred, double montant) {
		if (compteDeb.equals(compteCred))
			throw new RuntimeException(
					"Operation impossile : on ne peut pas effectuer un virement vers le meme compte");
		double maxDispo =0;
		if(compteDeb instanceof CompteCourant) {
			maxDispo = compteDeb.getSolde() + ((CompteCourant) compteDeb).getDecouvert();
		}else {
			maxDispo = compteDeb.getSolde();
		}

		if (maxDispo < montant) {
			System.out.println("Vous avez atteint votre découvert autorisé!");
		} else {
			debiter(compteDeb, montant);
			crediter(compteCred, montant);

		}
			}


	@Override
	public Page<Operations> findByListeComptes(Collection listeComptes, int page, int size) {
		// TODO Auto-generated method stub
		return operationsRepository.findByListeComptes(listeComptes,  new PageRequest(page, size));
	}

	@Override
	public Page<Operations> listOperation(Collection<Operations> listeOp, int page, int size) {
		// TODO Auto-generated method stub
		return operationsRepository.listOperation(listeOp, new PageRequest(page, size));
	}

	@Override
	public Long maxIdOperation() {
		if (operationsRepository.maxIdOperation()==null) {
			return 1L;
		}else {
			return operationsRepository.maxIdOperation()+1;
		}
		
	}

	@Override
	public Page<Operations> listOperations(Collection<Operations> listeOp, int page, int size) {
		// TODO Auto-generated method stub
		return operationsRepository.listOperations(listeOp, new PageRequest(page, size));
	}

}
