package sn.objis.proxibanquev3.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sn.objis.proxibanquev3.entities.Compte;


//@Service
//@Transactional
public class ThreadCompteRetrait extends Thread {
	private Compte c;
	private double retrait;
	//@Autowired
	private IOperationsService operationsService;

	public ThreadCompteRetrait(String name, Compte compte, double retrait) {
		super(name);
		this.c = compte;
		this.retrait = retrait;
	}

	public void run() {
		synchronized (c) { // fondamental: on pose un verrou sur le compte
			try {

				operationsService.debiter(c, this.retrait);
				System.out.println("operation de retait");
				Thread.sleep(1000);

			} catch (InterruptedException e) {
			}
		}
	}
}
