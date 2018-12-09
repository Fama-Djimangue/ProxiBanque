package sn.objis.proxibanque.services;

import sn.objis.proxibanque.domaine.Compte;

public class ThreadCompteVirement extends Thread{

	private Compte c1;
	private Compte c2;
	private double virement;

	private TransactionService transactionService = new TransactionService();

	public ThreadCompteVirement(String name, Compte compte1, Compte compte2, double virement) {
		super(name);
		this.c1 = compte1;
		this.c2 = compte2;
		this.virement = virement;
	}

	public void run() {
		synchronized (c1) { // fondamental: on pose un verrou sur le compte
			try {				

				transactionService.virementComptACompte(c1, c2, this.virement);;
				Thread.sleep(1000);

			} catch (InterruptedException e) {
				System.out.println("depot avorte");
			}
		}
	}
	
}
