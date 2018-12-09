package sn.objis.proxibanque.presentation.modele;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import sn.objis.proxibanque.domaine.Transaction;
import sn.objis.proxibanque.services.TransactionService;

public class TransactionModele extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TransactionService transactionService;
	private List<Transaction> listeTransactions = new ArrayList<Transaction>();
	private final String[] entetes = { "Numero", "Montant", "Transaction"};

	
	/**
	 * 
	 */
	public TransactionModele() {
		super();
		transactionService = new TransactionService();
		listeTransactions = transactionService.findAll();
	}

	/*
	 * Cette methode retourne le nombre de colonnes du tableau
	 */

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return entetes.length;
	}

	/*
	 * Cette méthode doit retourner le nombre de lignes du tableau qui
	 * correspond à la liste des transactions
	 */

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listeTransactions.size();
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
		switch (columnIndex) {
		// Colonne Numero de la transaction
		case 0:
			return listeTransactions.get(rowIndex).getNumero_transact();
		// Colonne Montant de la transaction
		case 1:
			return listeTransactions.get(rowIndex).getMontant_transact();
		// Colonne Type de la transaction
		case 2:
			return listeTransactions.get(rowIndex).getType_transact();
		default:
			break;
		}
		return null;
	}

	public void addTransactionInModele(Transaction transaction) {
		// Ajout du nouveau Employer dans la liste
		listeTransactions.add(transaction);

		// Notification du JTable des modifications du modele
		fireTableRowsInserted(listeTransactions.size() - 1, listeTransactions.size() - 1);
	}

	public void deleteTransactionFromModele(int index) {
		// suppression d el'étudiant dans la liste
		listeTransactions.remove(index);

		// Notification du JTable des modifications du modele
		fireTableRowsDeleted(index, index);
	}

}
