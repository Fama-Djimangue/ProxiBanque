package sn.objis.proxibanque.presentation;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import sn.objis.proxibanque.domaine.Compte;
import sn.objis.proxibanque.presentation.modele.CompteModele;
import sn.objis.proxibanque.services.CompteService;

import java.awt.FlowLayout;

public class PanelGestionCompte extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField textRechercher;

	private CompteService compteService = new CompteService();
	private CompteModele compteModele = new CompteModele();

	@SuppressWarnings("rawtypes")
	JComboBox comboBoxCompte;
	private JTable tableCompte;
	JScrollPane scrollpane;
	JButton boutonCreer;
	PanelModifierCompte modifiercompte = new PanelModifierCompte();
	PanelCreerConseiller enregistrerConseiller = new PanelCreerConseiller();
	// EnregistrerConseiller

	/**
	 * Create the panel.
	 */
	public PanelGestionCompte() {
		setBorder(UIManager.getBorder("OptionPane.border"));
		setBackground(new Color(105, 105, 105));
		setLayout(new BorderLayout(0, 0));

		JPanel panelHaut = new JPanel();
		panelHaut.setBackground(Color.LIGHT_GRAY);
		add(panelHaut, BorderLayout.NORTH);

		JLabel lblTitre = new JLabel("Gestion des Comptes");
		lblTitre.setForeground(new Color(128, 0, 0));
		lblTitre.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 50));
		panelHaut.add(lblTitre);

		JPanel panelB = new JPanel();
		panelB.setBackground(new Color(105, 105, 105));
		add(panelB, BorderLayout.SOUTH);
		panelB.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton boutonCreer = new JButton("Creer");
		boutonCreer.setVerticalAlignment(SwingConstants.TOP);
		boutonCreer.setIcon(new ImageIcon("src/images/creer50.jpg"));
		boutonCreer.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelB.add(boutonCreer);

		JButton boutonModifier = new JButton("Modifier");
		boutonModifier.setIcon(new ImageIcon("src/images/modifier50.jpg"));
		boutonModifier.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelB.add(boutonModifier);

		JButton boutonRelever = new JButton("Relev\u00E9 Bancaire");
		boutonRelever.setIcon(new ImageIcon("src/images/relever50.jpg"));
		boutonRelever.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelB.add(boutonRelever);

		JButton boutonQuitter = new JButton("Quitter");
		boutonQuitter.setIcon(new ImageIcon("src/images/quitter50.jpg"));
		boutonQuitter.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelB.add(boutonQuitter);

		JButton boutonRechercher = new JButton("");
		boutonRechercher.setSelectedIcon(new ImageIcon("src/images/Searchtool20.jpg"));
		boutonRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		boutonRechercher.setIcon(new ImageIcon("src/images/Searchtool20.jpg"));
		boutonRechercher.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelB.add(boutonRechercher);

		textRechercher = new JTextField();
		textRechercher.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelB.add(textRechercher);
		textRechercher.setColumns(10);

		JPanel panelCentre = new JPanel();
		panelCentre.setBackground(new Color(105, 105, 105));
		add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(new GridLayout(0, 1, 0, 0));

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setViewportBorder(UIManager.getBorder("ScrollPane.border"));
		panelCentre.add(scrollPane);

		tableCompte = new JTable(compteModele);
		scrollPane.setSize(600, 400);
		scrollPane.setViewportView(tableCompte);

		boutonModifier.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Compte compte = null;
				// compteAmodifierDansLaFiche();
				if (compteAmodifierDansLaFiche() != null) {
					removeAll();
					PanelModifierCompte modifiercompte = new PanelModifierCompte();
					add(modifiercompte, BorderLayout.CENTER);
				}

				validate();
			}
		});

		boutonRelever.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Effacer les composants du panel
				removeAll();

PanelReleverBancaire panelrelever = new PanelReleverBancaire();
add(panelrelever, BorderLayout.CENTER);

validate();
			}
		});
		
	}
	public void deleteCompte() {
		// On recupère d'abord le nombre de lignes sélectionnées
		int[] ligneselect = tableCompte.getSelectedRows();
		int tailleSelection = ligneselect.length;
		Compte compteSupprimer = new Compte();
		// parcours du tableau de lignes selectionnées
		for (int i = 0; i < tailleSelection; i++) {

			// recuperation du numero de la ligne selectionnee
			int index = ligneselect[i];
			// l'email se trouve à la colonne 2 de la ligne selectionnée
			String numero = (String) tableCompte.getValueAt(index, 0).toString();
			compteSupprimer = compteService.findByNumero(numero);

			// Suppression du compte dans la base de données
			compteService.delete(compteSupprimer);
			// suppression du compte dan la JTable
			compteModele.deleteCompteFromModele(index);

		}
	}

	private Compte compteAmodifierDansLaFiche() {
		Compte compte = null;

		// récupération de la ligne à modifier

		int ligneSelectionnee = tableCompte.getSelectedRow();
		if (ligneSelectionnee == -1) {
			Component panelHaut = null;
			JOptionPane.showMessageDialog(panelHaut, "Veuillez sélectionner un enregistrement");

		} else {
			// récupération des informations de la ligne
			String numeroRecupere = (String) tableCompte.getValueAt(ligneSelectionnee, 0);		
			compte = new Compte(numeroRecupere);

			  
			// remplissage des données dans la fiche
			modifiercompte.getTextNumero().setText(numeroRecupere);

		}
		return compte;
	}

}
