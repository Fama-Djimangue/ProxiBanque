package sn.objis.proxibanque.presentation.modele;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import sn.objis.proxibanque.domaine.Client;
import sn.objis.proxibanque.services.ClientService;

public class ClientModele extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClientService clientService;
	private List<Client> listeClients = new ArrayList<Client>();
	private final String[] entetes = { "Nom", "Prenom", "Email", "Adresse", "Code Postal", "Ville", "Telephone",
			"Proffesion" };

	/**
	 * 
	 */
	public ClientModele() {
		super();
		clientService = new ClientService();
		listeClients = clientService.findAll();

	}

	/*
	 * Cette méthode doit retourner le nombre de lignes du tableau qui
	 * correspond à la liste des Employers
	 */
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listeClients.size();
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
			return listeClients.get(rowIndex).getNom_client();
		// Colonne Prenom
		case 1:
			return listeClients.get(rowIndex).getPrenom_client();
		// Colonne Email
		case 2:
			return listeClients.get(rowIndex).getEmail_client();
		// Colonne Adresse
		case 3:
			return listeClients.get(rowIndex).getAdresse_client();
		// Colonne Code Postal
		case 4:
			return listeClients.get(rowIndex).getCode_postal();
		// Colonne Ville
		case 5:
			return listeClients.get(rowIndex).getVille_client();
		// Colonne Telephone
		case 6:
			return listeClients.get(rowIndex).getTelephone_client();
		// Colonne Telephone
		case 7:
			return listeClients.get(rowIndex).getProfession_client();

		default:
			break;
		}
		return null;
	}

	public void addClientInModele(Client client) {
		// Ajout du nouveau Employer dans la liste
		listeClients.add(client);

		// Notification du JTable des modifications du modele
		fireTableRowsInserted(listeClients.size() - 1, listeClients.size() - 1);
	}

	public void deleteClientFromModele(int index) {
		// suppression d el'étudiant dans la liste
		listeClients.remove(index);

		// Notification du JTable des modifications du modele
		fireTableRowsDeleted(index, index);
	}

}
