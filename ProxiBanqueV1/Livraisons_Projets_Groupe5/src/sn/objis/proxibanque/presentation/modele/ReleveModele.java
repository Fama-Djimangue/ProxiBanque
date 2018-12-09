package sn.objis.proxibanque.presentation.modele;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import sn.objis.proxibanque.domaine.Client;
import sn.objis.proxibanque.domaine.TransactionCompte;
import sn.objis.proxibanque.services.TransactionCompteServive;

public class ReleveModele extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TransactionCompteServive transactionCompteServive;
	private List<TransactionCompte> listeTransactionCompte = new ArrayList<TransactionCompte>();
	private final String[] entetes = { "Transaction", "Date", "Montant", "Type", "Compte"};
	//private Client client; 

	/**
	 * 
	 */
	public ReleveModele(Client client) {
		super();
		transactionCompteServive = new TransactionCompteServive();
		listeTransactionCompte = transactionCompteServive.findAllTransactClient(client);

	}

	/*
	 * Cette méthode doit retourner le nombre de lignes du tableau qui
	 * correspond à la liste des Employers
	 */
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listeTransactionCompte.size();
	}

	/*
	 * Cette methode retourne le nombre de colonnes du tableau
	 */
	@Override
	public int getColumnCount() {

		return entetes.length;
	}

	/*
	 * Retourne l'entete du tableau
	 */
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return entetes[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

	
		return null;
	}


}
