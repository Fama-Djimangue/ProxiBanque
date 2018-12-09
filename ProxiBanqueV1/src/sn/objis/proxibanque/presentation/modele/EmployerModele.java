package sn.objis.proxibanque.presentation.modele;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import sn.objis.proxibanque.domaine.Employer;
import sn.objis.proxibanque.services.EmployerService;

public class EmployerModele extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EmployerService employerService;
	private List<Employer> listeEmployers = new ArrayList<Employer>();
	private final String[] entetes = { "Nom", "Prenom", "Email", "Adresse", "Code Postal", "Ville", "Telephone" };

	/**
	 * 
	 */
	public EmployerModele() {
		super();
		employerService = new EmployerService();
		listeEmployers = employerService.findConseiller();

	}

	/*
	 * Cette méthode doit retourner le nombre de lignes du tableau qui
	 * correspond à la liste des Employers
	 */
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listeEmployers.size();
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
		// Colonne Nom
		case 0:
			return listeEmployers.get(rowIndex).getNom_employer();
		// Colonne Prenom
		case 1:
			return listeEmployers.get(rowIndex).getPrenom_employer();
		// Colonne Email
		case 2:
			return listeEmployers.get(rowIndex).getEmail_employer();
		// Colonne Adresse
		case 3:
			return listeEmployers.get(rowIndex).getAdresse_employer();
		// Colonne Code Postal
		case 4:
			return listeEmployers.get(rowIndex).getCode_postal();
		// Colonne Ville
		case 5:
			return listeEmployers.get(rowIndex).getVille_employer();
			// Colonne Telephone
		case 6:
			return listeEmployers.get(rowIndex).getTelephone_employer();
		default:
			break;
		}
		return null;
	}

	public void addEmployerInModele(Employer employer) {
		// Ajout du nouveau Employer dans la liste
		listeEmployers.add(employer);

		// Notification du JTable des modifications du modele
		fireTableRowsInserted(listeEmployers.size() - 1, listeEmployers.size() - 1);
	}

	public void deleteEmployerFromModele(int index) {
		// suppression d el'étudiant dans la liste
		listeEmployers.remove(index);

		// Notification du JTable des modifications du modele
		fireTableRowsDeleted(index, index);
	}

}
