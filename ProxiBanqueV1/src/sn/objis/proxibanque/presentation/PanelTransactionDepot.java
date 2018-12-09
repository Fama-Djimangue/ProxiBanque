package sn.objis.proxibanque.presentation;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import sn.objis.proxibanque.domaine.Compte;
import sn.objis.proxibanque.domaine.Transaction;
import sn.objis.proxibanque.presentation.modele.TransactionModele;
import sn.objis.proxibanque.services.CompteService;
import sn.objis.proxibanque.services.ThreadCompteDepot;
import sn.objis.proxibanque.services.TransactionCompteServive;
import sn.objis.proxibanque.services.TransactionService;

@SuppressWarnings("serial")
public class PanelTransactionDepot extends JPanel {
	private JTextField textNumero;
	private JTextField textNumCompte;
	private JTextField textMontant;

	private TransactionService transactionService = new TransactionService();
	private TransactionModele transactionModele = new TransactionModele();
	private TransactionCompteServive  transactionCompteServive = new TransactionCompteServive();
	private CompteService compteService = new CompteService();

	/**
	 * Create the panel.
	 */
	public PanelTransactionDepot() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelHaut = new JPanel();
		add(panelHaut, BorderLayout.NORTH);
		
		JLabel lblDepot = new JLabel("Formulaire D\u00E9pot");
		lblDepot.setForeground(new Color(0, 100, 0));
		lblDepot.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 50));
		panelHaut.add(lblDepot);
		
		JPanel panelCentre = new JPanel();
		panelCentre.setBorder(new LineBorder(new Color(0, 100, 0), 3, true));
		panelCentre.setBackground(new Color(128, 128, 128));
		add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(null);
		
		JLabel labelNumero = new JLabel("Numero");
		labelNumero.setBounds(330, 14, 85, 24);
		panelCentre.add(labelNumero);
		labelNumero.setHorizontalAlignment(SwingConstants.LEFT);
		labelNumero.setForeground(new Color(128, 0, 0));
		labelNumero.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		labelNumero.setBackground(Color.WHITE);
		
		textNumero = new JTextField();
		textNumero.setBounds(435, 11, 145, 36);
		panelCentre.add(textNumero);
		textNumero.setColumns(10);
		
		JLabel lblCompte = new JLabel("Compte");
		lblCompte.setBounds(330, 92, 94, 24);
		panelCentre.add(lblCompte);
		lblCompte.setHorizontalAlignment(SwingConstants.LEFT);
		lblCompte.setForeground(new Color(128, 0, 0));
		lblCompte.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblCompte.setBackground(Color.WHITE);
		
		textNumCompte = new JTextField();
		textNumCompte.setBounds(435, 89, 145, 36);
		panelCentre.add(textNumCompte);
		textNumCompte.setColumns(10);
		
		JLabel labelMontantTransaction = new JLabel("Montant");
		labelMontantTransaction.setHorizontalAlignment(SwingConstants.LEFT);
		labelMontantTransaction.setForeground(new Color(128, 0, 0));
		labelMontantTransaction.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		labelMontantTransaction.setBounds(330, 159, 94, 33);
		panelCentre.add(labelMontantTransaction);
		
		textMontant = new JTextField();
		textMontant.setColumns(10);
		textMontant.setBounds(430, 159, 195, 28);
		panelCentre.add(textMontant);
		
		JPanel panelBas = new JPanel();
		panelBas.setBorder(new LineBorder(new Color(0, 100, 0), 3, true));
		add(panelBas, BorderLayout.SOUTH);
		
		JButton boutonValider = new JButton("Valider");
		boutonValider.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		panelBas.add(boutonValider);
		
		JButton boutonAnnuler = new JButton("Annuler");
		boutonAnnuler.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		panelBas.add(boutonAnnuler);
		
		boutonValider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ThreadCompteDepot tcd;

				Transaction newDepot;
				boolean areEmpty = false;
				String numeroSaisi = textNumero.getText();
				String numCptSaisi = textNumCompte.getText();
				String montantSaisi = textMontant.getText();
				areEmpty = (!numeroSaisi.isEmpty()) && (!numCptSaisi.isEmpty()) && (!montantSaisi.isEmpty());
				
				
				if(!areEmpty){
					JOptionPane.showMessageDialog(panelHaut, "Veuillez renseigner tous les champs");
				}else{
					Compte compte = compteService.findByNumero(numCptSaisi);
					if(compte!=null){
						double montant = Double.parseDouble(montantSaisi);
						newDepot= new Transaction(numeroSaisi, montant, "DEPOT");
						
							tcd = new ThreadCompteDepot("ThreadDepot", compte, montant);
							tcd.start();
							transactionService.create(newDepot);							
							transactionModele.addTransactionInModele(newDepot);
							long iTrans = transactionService.dernierIdTrans(newDepot);
							newDepot.setId_transact(iTrans);
							transactionCompteServive.createTransaction(newDepot, compte);
							// Effacer les composants du panel
							removeAll();

							PanelGestionTransaction panelTransaction = new PanelGestionTransaction();
							add(panelTransaction, BorderLayout.CENTER);

							validate();

					}else{

						Component panelHaut = null;
						// Message
						JOptionPane.showMessageDialog(panelHaut, "Compte inexistant");
					}
				}
			}
		});
	}
}
