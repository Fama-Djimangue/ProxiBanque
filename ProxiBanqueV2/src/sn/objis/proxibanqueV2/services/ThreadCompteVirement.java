package sn.objis.proxibanqueV2.services;

import sn.objis.proxibanqueV2.domaine.Compte;

public class ThreadCompteVirement extends Thread{

	private Compte cDeb;
	private Compte cCred;
	private double virement;
	
	private TransactionService transactionService = new TransactionService();

	public ThreadCompteVirement(String name, Compte compteDeb, Compte compteCred, double virement) {
		super(name);
		this.cDeb = compteDeb;
		this.cCred = compteCred;
		this.virement = virement;
	}

	public void run() {
		synchronized (cDeb) { // fondamental: on pose un verrou sur le compte
			try {				

				transactionService.virementComptACompte(cDeb, cCred, this.virement);
				Thread.sleep(1000);

			} catch (InterruptedException e) {
				System.out.println("depot avorte");
			}
		}
	}
	
}
