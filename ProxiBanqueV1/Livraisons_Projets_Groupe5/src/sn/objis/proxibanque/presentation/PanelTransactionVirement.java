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
import sn.objis.proxibanque.services.ThreadCompteVirement;
import sn.objis.proxibanque.services.TransactionCompteServive;
import sn.objis.proxibanque.services.TransactionService;

@SuppressWarnings("serial")
public class PanelTransactionVirement extends JPanel {
	private JTextField textNumero;
	private JTextField textNumCompteDeb;
	private JTextField textNumCompteCred;
	
	private TransactionService transactionService = new TransactionService();
	private TransactionModele transactionModele = new TransactionModele();
	private TransactionCompteServive  transactionCompteServive = new TransactionCompteServive();
	private CompteService compteService = new CompteService();
	private JTextField textMontant;



	/**
	 * Create the panel.
	 */
	public PanelTransactionVirement() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelHaut = new JPanel();
		add(panelHaut, BorderLayout.NORTH);
		
		JLabel lblDepot = new JLabel("Formulaire Virement");
		lblDepot.setForeground(new Color(0, 100, 0));
		lblDepot.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 50));
		panelHaut.add(lblDepot);
		
		JPanel panelCentre = new JPanel();
		panelCentre.setBorder(new LineBorder(new Color(0, 100, 0), 3));
		panelCentre.setBackground(new Color(128, 128, 128));
		add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(null);
		
		JLabel labelNumero = new JLabel("Numero");
		labelNumero.setBounds(216, 14, 199, 24);
		panelCentre.add(labelNumero);
		labelNumero.setHorizontalAlignment(SwingConstants.LEFT);
		labelNumero.setForeground(new Color(128, 0, 0));
		labelNumero.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		labelNumero.setBackground(Color.WHITE);
		
		textNumero = new JTextField();
		textNumero.setBounds(432, 11, 145, 36);
		panelCentre.add(textNumero);
		textNumero.setColumns(10);
		
		JLabel labelCompteDebit = new JLabel("Compte \u00E0 d\u00E9biter");
		labelCompteDebit.setBounds(216, 92, 208, 24);
		panelCentre.add(labelCompteDebit);
		labelCompteDebit.setHorizontalAlignment(SwingConstants.LEFT);
		labelCompteDebit.setForeground(new Color(128, 0, 0));
		labelCompteDebit.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		labelCompteDebit.setBackground(Color.WHITE);
		
		textNumCompteDeb = new JTextField();
		textNumCompteDeb.setBounds(430, 89, 177, 36);
		panelCentre.add(textNumCompteDeb);
		textNumCompteDeb.setColumns(10);
		
		JLabel labelCompteCredit = new JLabel("Compte \u00E0 cr\u00E9diter");
		labelCompteCredit.setHorizontalAlignment(SwingConstants.LEFT);
		labelCompteCredit.setForeground(new Color(128, 0, 0));
		labelCompteCredit.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		labelCompteCredit.setBounds(216, 159, 208, 33);
		panelCentre.add(labelCompteCredit);
		
		textNumCompteCred = new JTextField();
		textNumCompteCred.setColumns(10);
		textNumCompteCred.setBounds(430, 159, 195, 28);
		panelCentre.add(textNumCompteCred);
		
		JLabel labelMontantTransaction = new JLabel("Montant");
		labelMontantTransaction.setHorizontalAlignment(SwingConstants.LEFT);
		labelMontantTransaction.setForeground(new Color(128, 0, 0));
		labelMontantTransaction.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		labelMontantTransaction.setBounds(216, 216, 204, 33);
		panelCentre.add(labelMontantTransaction);
		
		textMontant = new JTextField();
		textMontant.setColumns(10);
		textMontant.setBounds(430, 221, 195, 28);
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
				ThreadCompteVirement tcv;

				Transaction newVirement;
				boolean areEmpty = false;
				String numeroSaisi = textNumero.getText();
				String numCptDebSaisi = textNumCompteDeb.getText();
				String numCptCredSaisi = textNumCompteCred.getText();
				String montantSaisi = textMontant.getText();
				areEmpty = (!numeroSaisi.isEmpty()) && (!numCptDebSaisi.isEmpty()) && 
						(!numCptCredSaisi.isEmpty()) && (!montantSaisi.isEmpty());
				
				
				if(!areEmpty){
					JOptionPane.showMessageDialog(panelHaut, "Veuillez renseigner tous les champs");
				}else{
					Compte compteDeb = compteService.findByNumero(numCptDebSaisi);
					Compte compteCred = compteService.findByNumero(numCptCredSaisi);
					if(compteDeb!=null && compteCred!=null){
						double montant = Double.parseDouble(montantSaisi);
						newVirement= new Transaction(numeroSaisi, montant, "VIREMENT");
						
							tcv = new ThreadCompteVirement("ThreadVirement", compteDeb, compteCred, montant);
							tcv.start();
							transactionService.create(newVirement);							
							transactionModele.addTransactionInModele(newVirement);
							long iTrans = transactionService.dernierIdTrans(newVirement);
							newVirement.setId_transact(iTrans);
							transactionCompteServive.createTransaction(newVirement, compteDeb);
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
