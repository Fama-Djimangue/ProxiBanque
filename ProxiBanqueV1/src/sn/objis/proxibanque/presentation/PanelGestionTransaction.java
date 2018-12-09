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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.ImageIcon;
import sn.objis.proxibanque.domaine.Transaction;
import sn.objis.proxibanque.presentation.modele.TransactionModele;

import java.awt.FlowLayout;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class PanelGestionTransaction extends JPanel {
	private JTextField textRechercher;
	private JTable tableTransaction;
	private TransactionModele transactionModele = new TransactionModele();
	private PanelCreerTransaction panelEnregTransaction = new PanelCreerTransaction();
	
	/**
	 * Create the panel.
	 */
	public PanelGestionTransaction() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelCentre = new JPanel();
		panelCentre.setBackground(new Color(128, 128, 128));
		add(panelCentre, BorderLayout.SOUTH);
		panelCentre.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton boutonDepot = new JButton("Depot");
		boutonDepot.setIcon(new ImageIcon("src/images/depo50.jpg"));
		boutonDepot.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelCentre.add(boutonDepot);
		
		JButton boutonRetrait = new JButton("Retrait");
		boutonRetrait.setIcon(new ImageIcon("src/images/retrait50.jpg"));
		boutonRetrait.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelCentre.add(boutonRetrait);
		
		JButton boutonVirement = new JButton("Virement");
		boutonVirement.setIcon(new ImageIcon("src/images/virement50.jpg"));
		boutonVirement.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelCentre.add(boutonVirement);
		
		JButton boutonQuitter = new JButton("Quitter");
		boutonQuitter.setIcon(new ImageIcon("src/images/quitter50.jpg"));
		boutonQuitter.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelCentre.add(boutonQuitter);
		
		JButton boutonRechercher = new JButton("");
		boutonRechercher.setIcon(new ImageIcon("src/images/Searchtool20.jpg"));
		boutonRechercher.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelCentre.add(boutonRechercher);
		
		textRechercher = new JTextField();
		textRechercher.setColumns(10);
		panelCentre.add(textRechercher);
		
		JPanel panelBas = new JPanel();
		add(panelBas, BorderLayout.CENTER);
		panelBas.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelBas.add(scrollPane);
		
		tableTransaction = new JTable(transactionModele);
		scrollPane.setViewportView(tableTransaction);
		
		JPanel panelHaut = new JPanel();
		panelHaut.setBackground(SystemColor.activeCaptionBorder);
		add(panelHaut, BorderLayout.NORTH);
		
		JLabel lblFormulaireDesTransactions = new JLabel("Gestion des Transactions");
		lblFormulaireDesTransactions.setForeground(new Color(128, 0, 0));
		lblFormulaireDesTransactions.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 50));
		panelHaut.add(lblFormulaireDesTransactions);

		boutonDepot.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Effacer les composants du panel
				removeAll();
				
				PanelTransactionDepot panelTransactionDepot= new PanelTransactionDepot();				
				add(panelTransactionDepot, BorderLayout.CENTER);

				validate();
				
			}
		});
	
		boutonRetrait.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Effacer les composants du panel
				removeAll();
				
				PanelTransactionRetrait panelTransactionRetrait = new PanelTransactionRetrait();				
				add(panelTransactionRetrait, BorderLayout.CENTER);

				validate();
			}

			});
		
		boutonVirement.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Effacer les composants du panel
				removeAll();
				
				PanelTransactionVirement panelTransactionVirement = new PanelTransactionVirement();				
				add(panelTransactionVirement, BorderLayout.CENTER);

				validate();
			}

			});

	}
	

	public Transaction transactionAmodifierDansLaFiche() {
		Transaction transaction = null;
		// récupération de la ligne à modifier

		int ligneSelectionnee = tableTransaction.getSelectedRow();
		if (ligneSelectionnee == -1) {
			Component panelHaut = null;
			JOptionPane.showMessageDialog(panelHaut, "Veuillez sélectionner un enregistrement");

		} else {
			// récupération des informations de la ligne
			String numRecupere = (String) tableTransaction.getValueAt(ligneSelectionnee, 0);
			double montantRecupere = (double) tableTransaction.getValueAt(ligneSelectionnee, 1);
			String typeRecupere = (String) tableTransaction.getValueAt(ligneSelectionnee, 2);

			transaction = new Transaction(numRecupere, montantRecupere, typeRecupere);

			// remplissage des données dans la fiche
			String montant = montantRecupere+"";
			panelEnregTransaction.getTextNumero().setText(numRecupere);
			panelEnregTransaction.getTextMontant().setText(montant);;
			panelEnregTransaction.getComboTypeTransaction().getSelectedItem().toString();
		}
		return transaction;
	}


}
