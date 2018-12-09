package sn.objis.proxibanque.presentation;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.border.LineBorder;


import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PanelCreerCompte extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNumero;
	private JTextField textIdClient;
	private JTextField textTaux;
	private JTextField textSolde;
	private JTextField textDecouvert;


	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PanelCreerCompte() {
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));

		JPanel panelCentre = new JPanel();
		panelCentre.setForeground(Color.WHITE);
		panelCentre.setBorder(new LineBorder(new Color(128, 128, 128), 5));
		panelCentre.setBackground(new Color(128, 128, 128));
		add(panelCentre);
		panelCentre.setLayout(null);

		JLabel labelNumero = new JLabel("Numero");
		labelNumero.setHorizontalAlignment(SwingConstants.LEFT);
		labelNumero.setBounds(10, 39, 139, 29);
		labelNumero.setForeground(new Color(128, 0, 0));
		labelNumero.setBackground(new Color(255, 255, 255));
		labelNumero.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelCentre.add(labelNumero);

		textNumero = new JTextField();
		textNumero.setBounds(224, 41, 195, 29);
		panelCentre.add(textNumero);
		textNumero.setColumns(10);

		JLabel labelIdClient = new JLabel("IdClient");
		labelIdClient.setHorizontalAlignment(SwingConstants.LEFT);
		labelIdClient.setBounds(10, 0, 139, 28);
		labelIdClient.setForeground(new Color(128, 0, 0));
		labelIdClient.setBackground(new Color(255, 255, 255));
		labelIdClient.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelCentre.add(labelIdClient);

		textIdClient = new JTextField();
		textIdClient.setEnabled(false);
		textIdClient.setBounds(224, 2, 195, 28);
		panelCentre.add(textIdClient);
		textIdClient.setColumns(10);

		textTaux = new JTextField();
		textTaux.setBounds(224, 130, 195, 28);
		panelCentre.add(textTaux);
		textTaux.setColumns(10);

		JLabel labelDecouvert = new JLabel("Decouvert");
		labelDecouvert.setHorizontalAlignment(SwingConstants.LEFT);
		labelDecouvert.setBounds(11, 227, 139, 30);
		labelDecouvert.setForeground(new Color(128, 0, 0));
		labelDecouvert.setBackground(new Color(255, 255, 255));
		labelDecouvert.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelCentre.add(labelDecouvert);

		JLabel labelSolde = new JLabel("Solde");
		labelSolde.setHorizontalAlignment(SwingConstants.LEFT);
		labelSolde.setBounds(10, 90, 139, 29);
		labelSolde.setForeground(new Color(128, 0, 0));
		labelSolde.setBackground(new Color(255, 255, 255));
		labelSolde.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelCentre.add(labelSolde);

		textSolde = new JTextField();
		textSolde.setBounds(224, 87, 195, 29);
		//textSolde.setInputVerifier(new EmailVerification());
		panelCentre.add(textSolde);
		textSolde.setColumns(10);

		JLabel labelTauxRemuneration = new JLabel("Taux Remuneration");
		labelTauxRemuneration.setHorizontalAlignment(SwingConstants.LEFT);
		labelTauxRemuneration.setBounds(11, 128, 168, 33);
		labelTauxRemuneration.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		labelTauxRemuneration.setForeground(new Color(128, 0, 0));
		panelCentre.add(labelTauxRemuneration);
		
		JLabel labelTypeCompte = new JLabel("Type Compte");
		labelTypeCompte.setHorizontalAlignment(SwingConstants.LEFT);
		labelTypeCompte.setForeground(new Color(128, 0, 0));
		labelTypeCompte.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		labelTypeCompte.setBounds(11, 183, 139, 33);
		panelCentre.add(labelTypeCompte);
		
		textDecouvert = new JTextField();
		textDecouvert.setColumns(10);
		textDecouvert.setBounds(225, 227, 195, 28);
		panelCentre.add(textDecouvert);
		
		JComboBox comboTypeCompte = new JComboBox();
		comboTypeCompte.setBackground(Color.WHITE);
		comboTypeCompte.setModel(new DefaultComboBoxModel(new String[] {"------------", "COURANT", "EPARGNE"}));
		comboTypeCompte.setBounds(225, 185, 74, 29);
		panelCentre.add(comboTypeCompte);

		JPanel panelHaut = new JPanel();
		panelHaut.setBorder(new LineBorder(new Color(128, 128, 128), 5));
		panelHaut.setBackground(new Color(255, 255, 255));
		add(panelHaut, BorderLayout.NORTH);

		JLabel labelFormCompte = new JLabel("Formulaire Compte");
		labelFormCompte.setForeground(new Color(0, 100, 0));
		labelFormCompte.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 50));
		labelFormCompte.setHorizontalAlignment(SwingConstants.CENTER);
		panelHaut.add(labelFormCompte);

		JPanel panelBas = new JPanel();
		panelBas.setBorder(new LineBorder(new Color(128, 128, 128), 5));
		panelBas.setBackground(new Color(255, 255, 255));
		add(panelBas, BorderLayout.SOUTH);

		JButton boutonValider = new JButton("Valider");
		boutonValider.setToolTipText("Enregister dans la base");
		boutonValider.setBackground(new Color(128, 128, 128));
		boutonValider.setForeground(new Color(0, 0, 0));
		boutonValider.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		boutonValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelBas.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelBas.add(boutonValider);

		JButton boutonAnnuler = new JButton("Annuler");
		boutonAnnuler.setToolTipText("Effacer tous les champs");
		boutonAnnuler.setBackground(new Color(128, 128, 128));
		boutonAnnuler.setForeground(new Color(0, 0, 0));
		boutonAnnuler.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		panelBas.add(boutonAnnuler);

				
		// KeyListener est utiliser pour les événements sur le clavier
		textNumero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyTyped(e);
				if ((e.getKeyChar() < 'a' || e.getKeyChar() > 'z') && (e.getKeyChar() < 'A' || e.getKeyChar() > 'Z')) {
					// Désactiver le pavet non numérique
					e.setKeyChar('\0');
				}
			}
		});
		textIdClient.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyTyped(e);
				if ((e.getKeyChar() < 'a' || e.getKeyChar() > 'z') && (e.getKeyChar() < 'A' || e.getKeyChar() > 'Z')) {
					// Désactiver le pavet non numérique
					e.setKeyChar('\0');
				}
			}
		});
		textTaux.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyTyped(e);
				if (e.getKeyChar() < '0' || e.getKeyChar() > '9') {
					// Désactiver le pavet alphanumérique
					e.setKeyChar('\0');
				}
			}
		});

		boutonValider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Effacer les composants du panel
				removeAll();
				
				PanelGestionCompte panelCompte= new PanelGestionCompte();				
				add(panelCompte, BorderLayout.CENTER);

				validate();
				//pack();// Permet à la fenetre de s'adapter au contenu

				
			}
		});
	}
}
