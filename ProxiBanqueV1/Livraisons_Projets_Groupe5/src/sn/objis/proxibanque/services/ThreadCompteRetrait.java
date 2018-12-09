package sn.objis.proxibanque.services;

import sn.objis.proxibanque.domaine.Compte;

public class ThreadCompteRetrait extends Thread {
	private Compte c;
	private double retrait;
	private TransactionService transactionService = new TransactionService();

	public ThreadCompteRetrait(String name, Compte compte, double retrait) {
		super(name);
		this.c = compte;
		this.retrait = retrait;
	}

	public void run() {
		synchronized (c) { // fondamental: on pose un verrou sur le compte
			try {

				transactionService.debiter(c, this.retrait);
				Thread.sleep(1000);

			} catch (InterruptedException e) {
			}
		}
	}
}
