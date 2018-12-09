package sn.objis.proxibanque.presentation;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;

import sn.objis.proxibanque.domaine.Compte;
import sn.objis.proxibanque.domaine.Transaction;
import sn.objis.proxibanque.presentation.modele.TransactionModele;
import sn.objis.proxibanque.services.CompteService;
import sn.objis.proxibanque.services.ThreadCompteDepot;
import sn.objis.proxibanque.services.ThreadCompteRetrait;
import sn.objis.proxibanque.services.TransactionService;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PanelModifierTransaction extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNumero;
	private JTextField textMontant;
	private JTextField textNumCompte;
	@SuppressWarnings("rawtypes")
	private JComboBox comboTypeTransaction;
	private TransactionService transactionService = new TransactionService();
	private TransactionModele transactionModele = new TransactionModele();
	
	private CompteService compteService = new CompteService();
	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PanelModifierTransaction() {
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
		labelNumero.setBounds(103, 11, 139, 29);
		labelNumero.setForeground(new Color(128, 0, 0));
		labelNumero.setBackground(new Color(255, 255, 255));
		labelNumero.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelCentre.add(labelNumero);

		textNumero = new JTextField();
		textNumero.setBounds(317, 13, 195, 29);
		panelCentre.add(textNumero);
		textNumero.setColumns(10);

		textMontant = new JTextField();
		textMontant.setBounds(316, 136, 195, 28);
		panelCentre.add(textMontant);
		textMontant.setColumns(10);

		JLabel labelMontantTransaction = new JLabel("Montant");
		labelMontantTransaction.setHorizontalAlignment(SwingConstants.LEFT);
		labelMontantTransaction.setBounds(103, 134, 168, 33);
		labelMontantTransaction.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		labelMontantTransaction.setForeground(new Color(128, 0, 0));
		panelCentre.add(labelMontantTransaction);

		JLabel labelTypeCompte = new JLabel("Type ");
		labelTypeCompte.setHorizontalAlignment(SwingConstants.LEFT);
		labelTypeCompte.setForeground(new Color(128, 0, 0));
		labelTypeCompte.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		labelTypeCompte.setBounds(103, 193, 139, 33);
		panelCentre.add(labelTypeCompte);

		comboTypeTransaction = new JComboBox();
		comboTypeTransaction.setBackground(Color.WHITE);
		comboTypeTransaction
				.setModel(new DefaultComboBoxModel(new String[] { "------------", "DEPOT", "RETRAIT", "VIREMENT" }));
		comboTypeTransaction.setBounds(317, 198, 96, 29);
		panelCentre.add(comboTypeTransaction);

		textNumCompte = new JTextField();
		textNumCompte.setColumns(10);
		textNumCompte.setBounds(316, 72, 195, 29);
		panelCentre.add(textNumCompte);

		JLabel lblCompte = new JLabel("Compte");
		lblCompte.setHorizontalAlignment(SwingConstants.LEFT);
		lblCompte.setForeground(new Color(128, 0, 0));
		lblCompte.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblCompte.setBackground(Color.WHITE);
		lblCompte.setBounds(102, 70, 139, 29);
		panelCentre.add(lblCompte);

		JPanel panelHaut = new JPanel();
		panelHaut.setBorder(new LineBorder(new Color(128, 128, 128), 5));
		panelHaut.setBackground(new Color(255, 255, 255));
		add(panelHaut, BorderLayout.NORTH);

		JLabel labelFormTransaction = new JLabel("Formulaire Transaction");
		labelFormTransaction.setForeground(new Color(0, 100, 0));
		labelFormTransaction.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 50));
		labelFormTransaction.setHorizontalAlignment(SwingConstants.CENTER);
		panelHaut.add(labelFormTransaction);

		JPanel panelBas = new JPanel();
		panelBas.setBorder(new LineBorder(new Color(128, 128, 128), 5));
		panelBas.setBackground(new Color(255, 255, 255));
		add(panelBas, BorderLayout.SOUTH);

		JButton boutonValider = new JButton("Valider");
		boutonValider.setToolTipText("Enregister dans la base");
		boutonValider.setBackground(new Color(128, 128, 128));
		boutonValider.setForeground(new Color(0, 0, 0));
		boutonValider.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
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
		textMontant.addKeyListener(new KeyAdapter() {
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
				ThreadCompteDepot tcd;
				ThreadCompteRetrait tcr;
				Transaction newtransaction;
				boolean areEmpty = false;
				String numeroSaisi = textNumero.getText();
				String numCptSaisi = textNumCompte.getText();
				String montantSaisi = textMontant.getText();
				String typeSaisi = comboTypeTransaction.getSelectedItem().toString();
				areEmpty = (!numeroSaisi.isEmpty()) && (!numCptSaisi.isEmpty()) && (!montantSaisi.isEmpty())
						&& (!typeSaisi.isEmpty());
				
				
				if(!areEmpty){
					JOptionPane.showMessageDialog(panelHaut, "Veuillez renseigner tous les champs");
				}else{
					Compte compte = compteService.findByNumero(numCptSaisi);
					if(compte!=null){
						double montant = Double.parseDouble(montantSaisi);
						newtransaction= new Transaction(numeroSaisi, montant, typeSaisi);
						if(typeSaisi=="DEPOT"){
							tcd = new ThreadCompteDepot("ThreadDepot", compte, montant);
							tcd.start();
						}else if(typeSaisi=="RETRAIT"){

							tcr = new ThreadCompteRetrait("ThreadRetrait", compte, montant);
							tcr.start();

						}else if(typeSaisi=="VIREMENT"){

							tcr = new ThreadCompteRetrait("ThreadRetrait", compte, montant);
							tcr.start();

						}

						transactionService.create(newtransaction);
						transactionModele.addTransactionInModele(newtransaction);

						// Effacer les composants du panel
						removeAll();

						PanelGestionTransaction panelTransaction = new PanelGestionTransaction();
						add(panelTransaction, BorderLayout.CENTER);

						validate();
						// pack();// Permet à la fenetre de s'adapter au contenu


					}
				}
			}
		});

	}
	/**
	 * @return the textNumero
	 */
	public JTextField getTextNumero() {
		return textNumero;
	}
	/**
	 * @param textNumero the textNumero to set
	 */
	public void setTextNumero(JTextField textNumero) {
		this.textNumero = textNumero;
	}
	/**
	 * @return the textMontant
	 */
	public JTextField getTextMontant() {
		return textMontant;
	}
	/**
	 * @param textMontant the textMontant to set
	 */
	public void setTextMontant(JTextField textMontant) {
		this.textMontant = textMontant;
	}
	/**
	 * @return the comboTypeTransaction
	 */
	@SuppressWarnings("rawtypes")
	public JComboBox getComboTypeTransaction() {
		return comboTypeTransaction;
	}
	/**
	 * @param comboTypeTransaction the comboTypeTransaction to set
	 */
	@SuppressWarnings("rawtypes")
	public void setComboTypeTransaction(JComboBox comboTypeTransaction) {
		this.comboTypeTransaction = comboTypeTransaction;
	}
	
	
	
}
