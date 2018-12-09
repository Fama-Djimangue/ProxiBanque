package sn.objis.proxibanque.presentation;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import sn.objis.proxibanque.domaine.Client;
import sn.objis.proxibanque.domaine.Employer;
import sn.objis.proxibanque.presentation.modele.ClientModele;
import sn.objis.proxibanque.services.ClientService;

import java.awt.FlowLayout;
import java.awt.SystemColor;

public class PanelGestionClient extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textRechercher;
	private JTable tableClients;
	private ClientModele clientModele = new ClientModele();
	private ClientService clientService = new ClientService();
	private Employer conseiller;
	private PanelModifierClient panelModifierClient = new PanelModifierClient();

	/**
	 * Create the panel.
	 */
	public PanelGestionClient() {
		setBorder(UIManager.getBorder("OptionPane.border"));
		setBackground(new Color(105, 105, 105));
		setLayout(new BorderLayout(0, 0));

		JPanel panelHaut = new JPanel();
		panelHaut.setBackground(SystemColor.activeCaptionBorder);
		add(panelHaut, BorderLayout.NORTH);

		JLabel lblTitre = new JLabel("Gestion des Clients");
		lblTitre.setForeground(new Color(128, 0, 0));
		lblTitre.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 50));
		panelHaut.add(lblTitre);

		JPanel panelBas = new JPanel();
		panelBas.setBackground(new Color(105, 105, 105));
		add(panelBas, BorderLayout.SOUTH);
		panelBas.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton boutonCreer = new JButton("Creer");
		boutonCreer.setVerticalAlignment(SwingConstants.TOP);
		boutonCreer.setIcon(new ImageIcon("src/images/creer50.jpg"));
		boutonCreer.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelBas.add(boutonCreer);

		JButton boutonModifier = new JButton("Modifier");
		boutonModifier.setIcon(new ImageIcon("src/images/modifier50.jpg"));
		boutonModifier.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelBas.add(boutonModifier);

		JButton boutonSupprimer = new JButton("Supprimer");
		boutonSupprimer.setIcon(new ImageIcon("src/images/supp50.jpg"));
		boutonSupprimer.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelBas.add(boutonSupprimer);

		JButton boutonQuitter = new JButton("Quitter");
		boutonQuitter.setIcon(new ImageIcon("src/images/quitter50.jpg"));
		boutonQuitter.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelBas.add(boutonQuitter);

		JButton boutonRechercher = new JButton("");
		boutonRechercher.setSelectedIcon(new ImageIcon("src/images/Searchtool20.jpg"));
		boutonRechercher.setIcon(new ImageIcon("src/images/Searchtool20.jpg"));
		boutonRechercher.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelBas.add(boutonRechercher);

		textRechercher = new JTextField();
		textRechercher.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelBas.add(textRechercher);
		textRechercher.setColumns(10);

		JPanel panelCentre = new JPanel();
		panelCentre.setBackground(new Color(105, 105, 105));
		add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(new GridLayout(0, 1, 0, 0));

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setViewportBorder(UIManager.getBorder("ScrollPane.border"));
		panelCentre.add(scrollPane);

		tableClients = new JTable(clientModele);
		scrollPane.setSize(600, 400);
		scrollPane.setViewportView(tableClients);

		boutonCreer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Effacer les composants du panel
				removeAll();

				PanelCreerClient panelEnregClient = new PanelCreerClient();
				panelEnregClient.setConseillerClient(conseiller);

				add(panelEnregClient, BorderLayout.CENTER);

				validate();

			}
		});

		// Gestion de l'évenement sur le bouton supprimer
		boutonSupprimer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				final int[] selectionlignesupprimer = tableClients.getSelectedRows();

				if (selectionlignesupprimer.length == 0) {
					JOptionPane.showMessageDialog(panelHaut, "Merci de selectionner un client");
				} else {

					int confirmation = JOptionPane.showOptionDialog(panelHaut, "Voulez vous supprimer ce client?", null,
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
					if (confirmation == 0) {
						deleteClient();
						JOptionPane.showMessageDialog(panelHaut, "Suppression réussie");
					}

				}
			}
		});

		boutonModifier.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (clientAmodifierDansLaFiche() != null) {
					removeAll();
					add(panelModifierClient, BorderLayout.CENTER);
				}

				validate();
			}

		});
	}

	public Client clientAmodifierDansLaFiche() {
		Client client = null;
		// récupération de la ligne à modifier

		int ligneSelectionnee = tableClients.getSelectedRow();
		if (ligneSelectionnee == -1) {
			Component panelHaut = null;
			JOptionPane.showMessageDialog(panelHaut, "Veuillez sélectionner un enregistrement");

		} else {
			// récupération des informations de la ligne
			String nomRecupere = (String) tableClients.getValueAt(ligneSelectionnee, 0);
			String prenomRecupere = (String) tableClients.getValueAt(ligneSelectionnee, 1);
			String emailRecupere = (String) tableClients.getValueAt(ligneSelectionnee, 2);
			String adresseRecupere = (String) tableClients.getValueAt(ligneSelectionnee, 3);
			String CodePostalRecupere = (String) tableClients.getValueAt(ligneSelectionnee, 4);
			String villeRecupere = (String) tableClients.getValueAt(ligneSelectionnee, 5);
			String telephoneRecupere = (String) tableClients.getValueAt(ligneSelectionnee, 6);
			String professionRecupere = (String) tableClients.getValueAt(ligneSelectionnee, 7);

			client = new Client(nomRecupere, prenomRecupere, emailRecupere, adresseRecupere, CodePostalRecupere,
					villeRecupere, telephoneRecupere, professionRecupere);
			// remplissage des données dans la fiche

			panelModifierClient.getTextNom().setText(nomRecupere);
			panelModifierClient.getTextPrenom().setText(prenomRecupere);
			panelModifierClient.getTextEmail().setText(emailRecupere);
			panelModifierClient.getTextAdresse().setText(adresseRecupere);
			panelModifierClient.getTextCodePostal().setText(CodePostalRecupere);
			panelModifierClient.getTextVille().setText(villeRecupere);
			panelModifierClient.getTextTelephone().setText(telephoneRecupere);
			panelModifierClient.getTextProfession().setText(professionRecupere);
			panelModifierClient.setEmailRecupere(emailRecupere);
		}
		return client;
	}

	public void deleteClient() {
		// On recupère d'abord le nombre de lignes sélectionnées
		int[] ligneselect = tableClients.getSelectedRows();
		int tailleSelection = ligneselect.length;
		Client clientSupprimer = new Client();
		// parcours du tableau de lignes selectionnées
		for (int i = 0; i < tailleSelection; i++) {

			// recuperation du numero de la ligne selectionnee
			int index = ligneselect[i];
			// l'email se trouve à la colonne 2 de la ligne selectionnée
			String email = (String) tableClients.getValueAt(index, 2).toString();
			clientSupprimer = clientService.findByEmail(email);

			// Suppression du client dans la base de données
			clientService.delete(clientSupprimer);
			// suppression de l'etudiant dan la JTable
			clientModele.deleteClientFromModele(index);

		}
	}

	/**
	 * @return the conseiller
	 */
	public Employer getConseiller() {
		return conseiller;
	}

	/**
	 * @param conseiller
	 *            the conseiller to set
	 */
	public void setConseiller(Employer conseiller) {
		this.conseiller = conseiller;
	}

}
