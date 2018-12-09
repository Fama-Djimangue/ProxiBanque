package sn.objis.proxibanquev3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sn.objis.proxibanquev3.entities.Compte;


//@Service
//@Transactional
public class ThreadCompteDepot extends Thread {

	private Compte c;
	private double depot;
	
	//@Autowired
	private IOperationsService operationsService;
	//private OperationsServiceImpl operationsService = new OperationsServiceImpl();
	
	
	public ThreadCompteDepot(String name, Compte compte, double depot) {
		super(name);
		this.c = compte;
		this.depot = depot;
	}
	
	public void run() {
		synchronized (c) { // fondamental: on pose un verrou sur le compte
			try {
				operationsService.crediter(c, this.depot);
				Thread.sleep(1000);				

			} catch (InterruptedException e) {

			}			
		}
	}
}
