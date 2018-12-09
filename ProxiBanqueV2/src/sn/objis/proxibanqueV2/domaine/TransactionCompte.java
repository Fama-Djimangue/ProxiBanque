package sn.objis.proxibanqueV2.domaine;

import java.util.List;

@SuppressWarnings("unused")
public class TransactionCompte {
	
	private long id_transact;
	private long id_compte_debiter;
	private long id_compte_crediter;
	
	public TransactionCompte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public long getId_transact() {
		return id_transact;
	}


	public void setId_transact(long id_transact) {
		this.id_transact = id_transact;
	}


	public long getId_compte_debiter() {
		return id_compte_debiter;
	}
	public void setId_compte_debiter(long id_compte_debiter) {
		this.id_compte_debiter = id_compte_debiter;
	}
	public long getId_compte_crediter() {
		return id_compte_crediter;
	}
	public void setId_compte_crediter(long id_compte_crediter) {
		this.id_compte_crediter = id_compte_crediter;
	}

}
