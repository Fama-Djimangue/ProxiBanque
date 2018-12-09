package sn.objis.proxibanqueV2.services;

import sn.objis.proxibanqueV2.domaine.Compte;

public class ThreadCompteDepot extends Thread {

	private Compte c;
	private double depot;
	private TransactionService transactionService = new TransactionService();

	public ThreadCompteDepot(String name, Compte compte, double depot) {
		super(name);
		this.c = compte;
		this.depot = depot;
	}

	public void run() {
		synchronized (c) { // fondamental: on pose un verrou sur le compte
			try {
				
				transactionService.crediter(c, this.depot);
				Thread.sleep(1000);
				

			} catch (InterruptedException e) {

			}			
		}
	}
}
