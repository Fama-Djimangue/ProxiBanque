package sn.objis.proxibanque.presentation;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.Component;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import sn.objis.proxibanque.domaine.Employer;
import sn.objis.proxibanque.presentation.modele.EmployerModele;
import sn.objis.proxibanque.services.EmployerService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import java.awt.GridLayout;

public class PanelGestionConseiller extends JPanel {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textRechercher;
	private EmployerService employerService = new EmployerService();
	private EmployerModele employerModele = new EmployerModele();
	private JTable tableConseillers;
	private PanelModifierConseiller modifierconseiller;
	private Employer gerant;
	PanelCreerConseiller enregistrerConseiller = new PanelCreerConseiller();
	

	private String logGeran;
	
	/**
	 * @return the logGeran
	 */
	public String getLogGeran() {
		return logGeran;
	}


	/**
	 * @param logGeran the logGeran to set
	 */
	public void setLogGeran(String logGeran) {
		this.logGeran = logGeran;
	}


	/**
	 * Create the panel.
	 */
	public PanelGestionConseiller() {
		setBorder(UIManager.getBorder("OptionPane.border"));
		setBackground(new Color(105, 105, 105));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelHaut = new JPanel();
		panelHaut.setBackground(Color.LIGHT_GRAY);
		add(panelHaut, BorderLayout.NORTH);
		
		JLabel lblTitre = new JLabel("Gestion des Conseillers");
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
			add(panelCentre, BorderLayout.CENTER);
			panelCentre.setLayout(new GridLayout(0, 1, 0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			panelCentre.add(scrollPane);
			
				scrollPane.setViewportBorder(UIManager.getBorder("ScrollPane.border"));
				
				tableConseillers = new JTable(employerModele);
				scrollPane.setSize(600,400);
				scrollPane.setViewportView(tableConseillers);

			
			boutonCreer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				removeAll();
				PanelCreerConseiller enregistrerConseiller = new PanelCreerConseiller();
				enregistrerConseiller.setGerantAgence(gerant);
				System.out.println("FC :"+gerant);
				add(enregistrerConseiller, BorderLayout.CENTER);
				
				validate();
	
			}
		});
		
			
		boutonModifier.addActionListener(new ActionListener() {
						
			@Override
			public void actionPerformed(ActionEvent e) {
				//Employer employer = null;
				//compteAmodifierDansLaFiche();
				if (conseillerAmodifierDansLaFiche() != null){
				removeAll();
				add(modifierconseiller, BorderLayout.CENTER);
				}
				
				validate();
			}
		});
		
		

		// Gestion de l'évenement sur le bouton supprimer	
		boutonSupprimer.addActionListener(new ActionListener(){		
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub			
					final int [] selectionlignesupprimer=tableConseillers.getSelectedRows();
					
					if (selectionlignesupprimer.length==0){
						JOptionPane.showMessageDialog(panelHaut, "Merci de selectionner un employer");
					}else{
								
						int confirmation=JOptionPane.showOptionDialog(panelHaut, "Voulez vous supprimer cet employer?",null, JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
					   if(confirmation==0){
						   deleteEmployer();
						  	JOptionPane.showMessageDialog(panelHaut, "Suppression réussie");
						   }
							
						}
					}
				});
			
	
	
}

	
	
	public void deleteEmployer(){
		// On recupère d'abord le nombre de lignes sélectionnées
		int [] ligneselect = tableConseillers.getSelectedRows();				
		int tailleSelection = ligneselect.length;
		Employer conseillerSupprimer= new Employer();
		// parcours du tableau de lignes selectionnées
		for(int i =0; i < tailleSelection; i++){
			
			// recuperation du numero de la ligne selectionnee
			int index=ligneselect[i];
			// l'email se trouve à la colonne 2 de la ligne selectionnée
			String email= (String) tableConseillers.getValueAt(index,2).toString();
			System.out.println("L'email de l'employer a supprimer est :" +email);
			conseillerSupprimer = employerService.findByEmail(email);
			System.out.println("employer a supprimer "+ conseillerSupprimer.getNom_employer());
			
			// Suppression de l'etudiant dans la base de données
			employerService.delete(conseillerSupprimer);
			// suppression de l'etudiant dan la JTable
			employerModele.deleteEmployerFromModele(index);
			
		}
		}	

	

	
	
	private Employer conseillerAmodifierDansLaFiche() {		
		Employer employer = null;
		// récupération de la ligne à modifier
		
		int ligneSelectionnee = tableConseillers.getSelectedRow();
		if (ligneSelectionnee == -1) {
			Component panelHaut = null;
			JOptionPane.showMessageDialog(panelHaut,
					"Veuillez sélectionner un enregistrement");
			
		} else {
			// récupération des informations de la ligne
			String nomRecupere = (String) tableConseillers.getValueAt(ligneSelectionnee, 0);
			String prenomRecupere = (String) tableConseillers.getValueAt(ligneSelectionnee, 1);
			String emailRecupere = (String) tableConseillers.getValueAt(ligneSelectionnee, 2);
			String adresseRecupere = (String) tableConseillers.getValueAt(ligneSelectionnee, 3);
			String CodePostalRecupere = (String) tableConseillers.getValueAt(ligneSelectionnee, 4);
			String villeRecupere = (String) tableConseillers.getValueAt(ligneSelectionnee, 5);
			String telephoneRecupere = (String) tableConseillers.getValueAt(ligneSelectionnee, 6);
			
		 employer = new Employer(nomRecupere, prenomRecupere, emailRecupere, adresseRecupere, CodePostalRecupere, villeRecupere, telephoneRecupere);
			
			// remplissage des données dans la fiche
		   modifierconseiller=new PanelModifierConseiller();
		   modifierconseiller.setOldEmail(emailRecupere);
		  
		 
			
			modifierconseiller.getTextNom().setText(nomRecupere);
			modifierconseiller.getTextPrenom().setText(prenomRecupere);
			modifierconseiller.getTextEmail().setText(emailRecupere);
			modifierconseiller.getTextAdresse().setText(adresseRecupere);
			modifierconseiller.getTextCodePostal().setText(CodePostalRecupere);
			modifierconseiller.getTextVille().setText(villeRecupere);
			modifierconseiller.getTextTelephone().setText(telephoneRecupere);
		}
		return employer;	
	}



	/**
	 * @return the gerant
	 */
	public Employer getGerant() {
		return gerant;
	}



	/**
	 * @param gerant the gerant to set
	 */
	public void setGerant(Employer gerant) {
		this.gerant = gerant;
	}
	
}
