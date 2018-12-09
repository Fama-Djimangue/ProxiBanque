package sn.objis.proxibanquev3.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sn.objis.proxibanquev3.entities.Compte;

//@Service
//@Transactional
public class ThreadCompteVirement extends Thread{

	private Compte cDeb;
	private Compte cCred;
	private double virement;
	//@Autowired
	private IOperationsService operationsService;

	public ThreadCompteVirement(String name, Compte compteDeb, Compte compteCred, double virement) {
		super(name);
		this.cDeb = compteDeb;
		this.cCred = compteCred;
		this.virement = virement;
	}

	public void run() {
		synchronized (cDeb) { // fondamental: on pose un verrou sur le compte
			try {				

				operationsService.virementComptACompte(cDeb, cCred, this.virement);
				Thread.sleep(1000);

			} catch (InterruptedException e) {
				System.out.println("depot avorte");
			}
		}
	}
	
}
