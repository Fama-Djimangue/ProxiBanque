package sn.objis.proxibanque.presentation;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import sn.objis.proxibanque.domaine.CompteUtilisateur;
import sn.objis.proxibanque.domaine.Employer;
import javax.swing.SwingConstants;

public class FenetreAccueil extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private Employer employer;
	private CompteUtilisateur compteUtilisateur;
	private JLabel labelAgentConnecte, labelLoginGerant, labelidGerant;
	private long id_gerant;
	private String logGeranCon;
	private JButton boutonAccueil;
	private JButton boutonGestionConseiller;
	private JButton boutonGestionClient;
	private JButton boutonGestionTransaction;
	private JButton boutonGestionCarte;
	private JButton boutonGestionCompte;
	private JButton boutonDeconnecter;

	/**
	 * @return the logGeranCon
	 */
	public String getLogGeranCon() {
		return logGeranCon;
	}

	/**
	 * @param logGeranCon
	 *            the logGeranCon to set
	 */
	public void setLogGeranCon(String logGeranCon) {
		this.logGeranCon = logGeranCon;
	}

	/**
	 * Create the frame.
	 */
	public FenetreAccueil(String title) {
		setTitle(title);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1360, 748);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panelGauche = new JPanel();
		panelGauche.setBackground(new Color(255, 255, 255));
		contentPane.add(panelGauche, BorderLayout.WEST);
		panelGauche.setLayout(new GridLayout(7, 1, 3, 3));

		boutonAccueil = new JButton("Accueil");
		boutonAccueil.setToolTipText("");
		boutonAccueil.setSelectedIcon(new ImageIcon("src/images/boutV.jpg"));
		boutonAccueil.setBackground(new Color(0, 100, 0));
		boutonAccueil.setForeground(new Color(255, 255, 255));
		boutonAccueil.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		panelGauche.add(boutonAccueil);

		boutonGestionConseiller = new JButton("Gestion des Conseillers");
		boutonGestionConseiller.setBackground(new Color(128, 0, 0));
		boutonGestionConseiller.setForeground(new Color(255, 255, 255));
		boutonGestionConseiller.setIcon(null);
		boutonGestionConseiller.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		panelGauche.add(boutonGestionConseiller);

		boutonGestionCompte = new JButton("Gestion des Comptes");
		boutonGestionCompte.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		boutonGestionCompte.setForeground(new Color(255, 255, 255));
		boutonGestionCompte.setBackground(new Color(0, 100, 0));
		panelGauche.add(boutonGestionCompte);
		
		boutonGestionClient = new JButton(" Gestion des Clients");
		boutonGestionClient.setForeground(new Color(255, 255, 255));
		boutonGestionClient.setBackground(new Color(128, 0, 0));
		boutonGestionClient.setIcon(null);
		boutonGestionClient.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		panelGauche.add(boutonGestionClient);

		boutonGestionTransaction = new JButton("Gestion transaction");
		boutonGestionTransaction.setForeground(new Color(255, 255, 255));
		boutonGestionTransaction.setBackground(new Color(0, 100, 0));
		boutonGestionTransaction.setIcon(null);
		boutonGestionTransaction.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		panelGauche.add(boutonGestionTransaction);

		boutonGestionCarte = new JButton("Gestion des cartes");
		boutonGestionCarte.setForeground(new Color(255, 255, 255));
		boutonGestionCarte.setBackground(new Color(128, 0, 0));
		boutonGestionCarte.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		panelGauche.add(boutonGestionCarte);

	

		JPanel panelCentre = new JPanel();
		panelCentre.setBackground(new Color(255, 255, 255));
		contentPane.add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon("src/images/PanneC.jpg"));
		panelCentre.add(lblNewLabel);

		JPanel panelBas = new JPanel();
		panelBas.setBackground(new Color(255, 255, 255));
		panelBas.setBorder(new LineBorder(new Color(0, 100, 0), 5, true));
		contentPane.add(panelBas, BorderLayout.SOUTH);
		panelBas.setLayout(new GridLayout(1, 1, 0, 0));
		
				boutonDeconnecter = new JButton("Deconnexion");
				boutonDeconnecter.setBackground(new Color(128, 0, 0));
				boutonDeconnecter.setForeground(new Color(255, 255, 255));
				boutonDeconnecter.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
				panelBas.add(boutonDeconnecter);

		JLabel label = new JLabel("");
		panelBas.add(label);

		JLabel label_1 = new JLabel("");
		panelBas.add(label_1);

		labelLoginGerant = new JLabel("");
		labelLoginGerant.setForeground(new Color(128, 0, 0));
		labelLoginGerant.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		labelLoginGerant.setHorizontalAlignment(SwingConstants.RIGHT);
		panelBas.add(labelLoginGerant);
		labelidGerant = new JLabel("");
		labelidGerant.setHorizontalAlignment(SwingConstants.RIGHT);
		panelBas.add(labelidGerant);
		labelAgentConnecte = new JLabel("");
		labelAgentConnecte.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		labelAgentConnecte.setForeground(new Color(128, 0, 0));
		panelBas.add(labelAgentConnecte);

		JPanel panelHaut = new JPanel();
		panelHaut.setBackground(new Color(255, 255, 255));
		contentPane.add(panelHaut, BorderLayout.NORTH);
		panelHaut.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(0, 100, 0), null, new Color(128, 0, 0), null));
		panelHaut.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblHaut = new JLabel("");
		lblHaut.setBackground(new Color(255, 255, 255));
		lblHaut.setIcon(new ImageIcon("src/images/bandeau1.jpg"));
		panelHaut.add(lblHaut);
		
		
		boutonAccueil.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Effacer les composants du panel
				panelCentre.removeAll();

				PanelAccueil panelAccueil = new PanelAccueil();
							
				panelCentre.add(panelAccueil, BorderLayout.CENTER);
				validate();

			}
		});
		

		boutonGestionClient.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Effacer les composants du panel
				panelCentre.removeAll();

				PanelGestionClient panelClient = new PanelGestionClient();
				panelClient.setConseiller(employer);
				
				panelCentre.add(panelClient, BorderLayout.CENTER);
				validate();

			}
		});

		boutonGestionTransaction.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Effacer les composants du panel
				panelCentre.removeAll();

				PanelGestionTransaction panelTransaction = new PanelGestionTransaction();
				panelCentre.add(panelTransaction, BorderLayout.CENTER);

				validate();

			}
		});

		boutonGestionCompte.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Effacer les composants du panel
				panelCentre.removeAll();

				PanelGestionCompte panelGestionCompte = new PanelGestionCompte();
				panelCentre.add(panelGestionCompte, BorderLayout.CENTER);

				validate();
			}
		});

		boutonGestionConseiller.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				panelCentre.removeAll();
				PanelGestionConseiller panelGestionConseiller = new PanelGestionConseiller();
				panelGestionConseiller.setGerant(employer);
				panelCentre.add(panelGestionConseiller);

				validate();
			}
		});

		
		boutonDeconnecter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				FenetreConnexion Fenetreconnexion = new FenetreConnexion("");
				Fenetreconnexion.setVisible(true);
				dispose();
							
				}
		});
		
	}

	/**
	 * @return the labelAgentConnecte
	 */
	public JLabel getLabelAgentConnecte() {
		return labelAgentConnecte;
	}

	/**
	 * @param labelAgentConnecte
	 *            the labelAgentConnecte to set
	 */
	public void setLabelAgentConnecte(JLabel labelAgentConnecte) {
		this.labelAgentConnecte = labelAgentConnecte;
	}

	/**
	 * @return the labelLoginGerant
	 */
	public JLabel getLabelLoginGerant() {
		return labelLoginGerant;
	}

	/**
	 * @param labelLoginGerant
	 *            the labelLoginGerant to set
	 */
	public void setLabelLoginGerant(JLabel labelLoginGerant) {
		this.labelLoginGerant = labelLoginGerant;
	}

	/**
	 * @return the labelidGerant
	 */
	public JLabel getLabelidGerant() {
		return labelidGerant;
	}

	/**
	 * @param labelidGerant
	 *            the labelidGerant to set
	 */
	public void setLabelidGerant(JLabel labelidGerant) {
		this.labelidGerant = labelidGerant;
	}

	/**
	 * @return the employer
	 */
	public Employer getEmployer() {
		return employer;
	}

	/**
	 * @param employer
	 *            the employer to set
	 */
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	/**
	 * @return the id_gerant
	 */
	public long getId_gerant() {
		return id_gerant;
	}

	/**
	 * @param id_gerant
	 *            the id_gerant to set
	 */
	public void setId_gerant(long id_gerant) {
		this.id_gerant = id_gerant;
	}

	/**
	 * @return the compteUtilisateur
	 */
	public CompteUtilisateur getCompteUtilisateur() {
		return compteUtilisateur;
	}

	/**
	 * @param compteUtilisateur
	 *            the compteUtilisateur to set
	 */
	public void setCompteUtilisateur(CompteUtilisateur compteUtilisateur) {
		this.compteUtilisateur = compteUtilisateur;
	}

	/**
	 * @return the boutonGestionConseiller
	 */
	public JButton getBoutonGestionConseiller() {
		return boutonGestionConseiller;
	}

	/**
	 * @return the boutonGestionClient
	 */
	public JButton getBoutonGestionClient() {
		return boutonGestionClient;
	}

	/**
	 * @return the boutonGestionTransaction
	 */
	public JButton getBoutonGestionTransaction() {
		return boutonGestionTransaction;
	}

	/**
	 * @return the boutonGestionCarte
	 */
	public JButton getBoutonGestionCarte() {
		return boutonGestionCarte;
	}

	/**
	 * @return the boutonGestionCompte
	 */
	public JButton getBoutonGestionCompte() {
		return boutonGestionCompte;
	}

}
