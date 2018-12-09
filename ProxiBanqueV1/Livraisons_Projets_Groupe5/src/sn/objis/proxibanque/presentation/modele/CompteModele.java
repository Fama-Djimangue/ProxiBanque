package sn.objis.proxibanque.presentation.modele;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import sn.objis.proxibanque.domaine.Compte;
import sn.objis.proxibanque.services.CompteService;


public class CompteModele extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CompteService compteService;
	private List<Compte> listecompte = new ArrayList<Compte>();
	private final String[] entetes = { "Numero Compte", "Solde Compte", "date_ouverture", "type_compte", "taux_remuneration", "decouverte" };

	/**
	 * 
	 */
	public CompteModele() {
		super();
		compteService = new CompteService();
		listecompte = compteService.findAll();

	}

	/*
	 * Cette méthode doit retourner le nombre de lignes du tableau qui
	 * correspond à la liste des Employers
	 */
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listecompte.size();
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

		switch (columnIndex) {

		case 0:
			return listecompte.get(rowIndex).getNumero_compte();

		case 1:
			return listecompte.get(rowIndex).getSolde_compte();

		case 2:
			return listecompte.get(rowIndex).getDate_ouverture();

		case 3:
			return listecompte.get(rowIndex).getType_compte();

		case 4:
			return listecompte.get(rowIndex).getTaux_remuneration();

		case 5:
			return listecompte.get(rowIndex).getDecouvert();
		default:
			break;
		}
		return null;
	}

	public void addCompteInModele(Compte compte) {
		// Ajout du nouveau Employer dans la liste
		listecompte.add(compte);

		// Notification du JTable des modifications du modele
		fireTableRowsInserted(listecompte.size() - 1, listecompte.size() - 1);
	}

	public void deleteCompteFromModele(int index) {
		// suppression d el'étudiant dans la liste
		listecompte.remove(index);

		// Notification du JTable des modifications du modele
		fireTableRowsDeleted(index, index);
	}

}
