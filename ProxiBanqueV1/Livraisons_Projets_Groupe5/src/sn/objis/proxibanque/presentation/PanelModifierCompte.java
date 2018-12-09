package sn.objis.proxibanque.presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import sn.objis.proxibanque.dao.DataAccessException;
import sn.objis.proxibanque.domaine.Compte;
import sn.objis.proxibanque.presentation.modele.CompteModele;
import sn.objis.proxibanque.services.CompteService;

import javax.swing.DefaultComboBoxModel;

public class PanelModifierCompte extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNumero;
	private JTextField textTaux;
	private JTextField textSolde;
	private JTextField textDecouvert;

	private CompteService compteService = new CompteService();
	private CompteModele compteModele = new CompteModele();

	private JTable tableCompte;
	JScrollPane scrollpane;
	@SuppressWarnings("rawtypes")
	private ComboBoxModel typeCompte;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })

	public PanelModifierCompte() {
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));

		JPanel panelHaut = new JPanel();
		panelHaut.setBorder(new LineBorder(new Color(128, 128, 128), 5));
		panelHaut.setBackground(new Color(255, 255, 255));
		add(panelHaut, BorderLayout.NORTH);

		JLabel labelFormClient = new JLabel("Formulaire Compte");
		labelFormClient.setForeground(new Color(0, 100, 0));
		labelFormClient.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 50));
		labelFormClient.setHorizontalAlignment(SwingConstants.CENTER);
		panelHaut.add(labelFormClient);

		JPanel panelBas = new JPanel();
		panelBas.setBorder(new LineBorder(new Color(128, 128, 128), 5));
		panelBas.setBackground(new Color(255, 255, 255));
		add(panelBas, BorderLayout.SOUTH);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.setToolTipText("Enregister dans la base");
		btnModifier.setBackground(new Color(128, 128, 128));
		btnModifier.setForeground(new Color(0, 0, 0));
		btnModifier.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));

		panelBas.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelBas.add(btnModifier);

		JButton boutonAnnuler = new JButton("Annuler");
		boutonAnnuler.setToolTipText("Effacer tous les champs");
		boutonAnnuler.setBackground(new Color(128, 128, 128));
		boutonAnnuler.setForeground(new Color(0, 0, 0));
		boutonAnnuler.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		panelBas.add(boutonAnnuler);

		JPanel panelDroit = new JPanel();
		panelDroit.setForeground(Color.WHITE);
		panelDroit.setBackground(Color.GRAY);
		add(panelDroit, BorderLayout.CENTER);
		GridBagLayout gbl_panelDroit = new GridBagLayout();
		gbl_panelDroit.columnWidths = new int[] { 509, 509, 0 };
		gbl_panelDroit.rowHeights = new int[] { 44, 44, 44, 44, 44, 0 };
		gbl_panelDroit.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelDroit.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelDroit.setLayout(gbl_panelDroit);

		JLabel labelNumero = new JLabel("Numero");
		labelNumero.setHorizontalAlignment(SwingConstants.LEFT);
		labelNumero.setForeground(new Color(128, 0, 0));
		labelNumero.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		labelNumero.setBackground(Color.WHITE);
		GridBagConstraints gbc_labelNumero = new GridBagConstraints();
		gbc_labelNumero.fill = GridBagConstraints.BOTH;
		gbc_labelNumero.insets = new Insets(0, 0, 5, 5);
		gbc_labelNumero.gridx = 0;
		gbc_labelNumero.gridy = 0;
		panelDroit.add(labelNumero, gbc_labelNumero);

		textNumero = new JTextField();
		textNumero.setColumns(10);
		GridBagConstraints gbc_textNumero = new GridBagConstraints();
		gbc_textNumero.fill = GridBagConstraints.BOTH;
		gbc_textNumero.insets = new Insets(0, 0, 5, 0);
		gbc_textNumero.gridx = 1;
		gbc_textNumero.gridy = 0;
		panelDroit.add(textNumero, gbc_textNumero);

		JLabel labelSolde = new JLabel("Solde");
		labelSolde.setHorizontalAlignment(SwingConstants.LEFT);
		labelSolde.setForeground(new Color(128, 0, 0));
		labelSolde.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		labelSolde.setBackground(Color.WHITE);
		GridBagConstraints gbc_labelSolde = new GridBagConstraints();
		gbc_labelSolde.fill = GridBagConstraints.BOTH;
		gbc_labelSolde.insets = new Insets(0, 0, 5, 5);
		gbc_labelSolde.gridx = 0;
		gbc_labelSolde.gridy = 1;
		panelDroit.add(labelSolde, gbc_labelSolde);

		textSolde = new JTextField();
		textSolde.setColumns(10);
		GridBagConstraints gbc_textSolde = new GridBagConstraints();
		gbc_textSolde.fill = GridBagConstraints.BOTH;
		gbc_textSolde.insets = new Insets(0, 0, 5, 0);
		gbc_textSolde.gridx = 1;
		gbc_textSolde.gridy = 1;
		panelDroit.add(textSolde, gbc_textSolde);

		JLabel labelaux = new JLabel("Taux");
		labelaux.setHorizontalAlignment(SwingConstants.LEFT);
		labelaux.setForeground(new Color(128, 0, 0));
		labelaux.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		GridBagConstraints gbc_labelaux = new GridBagConstraints();
		gbc_labelaux.fill = GridBagConstraints.BOTH;
		gbc_labelaux.insets = new Insets(0, 0, 5, 5);
		gbc_labelaux.gridx = 0;
		gbc_labelaux.gridy = 2;
		panelDroit.add(labelaux, gbc_labelaux);

		textTaux = new JTextField();
		textTaux.setColumns(10);
		GridBagConstraints gbc_textTaux = new GridBagConstraints();
		gbc_textTaux.fill = GridBagConstraints.BOTH;
		gbc_textTaux.insets = new Insets(0, 0, 5, 0);
		gbc_textTaux.gridx = 1;
		gbc_textTaux.gridy = 2;
		panelDroit.add(textTaux, gbc_textTaux);

		JLabel labelType = new JLabel("Type Compte");
		labelType.setHorizontalAlignment(SwingConstants.LEFT);
		labelType.setForeground(new Color(128, 0, 0));
		labelType.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		GridBagConstraints gbc_labelType = new GridBagConstraints();
		gbc_labelType.fill = GridBagConstraints.BOTH;
		gbc_labelType.insets = new Insets(0, 0, 5, 5);
		gbc_labelType.gridx = 0;
		gbc_labelType.gridy = 3;
		panelDroit.add(labelType, gbc_labelType);
		JComboBox combotypeCompte = new JComboBox(
				new DefaultComboBoxModel(new String[] { "---------------", "COURANT", "EPARGNE" }));
		combotypeCompte.setBackground(Color.WHITE);
		GridBagConstraints gbc_combotypeCompte = new GridBagConstraints();
		gbc_combotypeCompte.fill = GridBagConstraints.BOTH;
		gbc_combotypeCompte.insets = new Insets(0, 0, 5, 0);
		gbc_combotypeCompte.gridx = 1;
		gbc_combotypeCompte.gridy = 3;
		panelDroit.add(combotypeCompte, gbc_combotypeCompte);

		JLabel labelDecouvert = new JLabel("Decouvert");
		labelDecouvert.setHorizontalAlignment(SwingConstants.LEFT);
		labelDecouvert.setForeground(new Color(128, 0, 0));
		labelDecouvert.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		labelDecouvert.setBackground(Color.WHITE);
		GridBagConstraints gbc_labelDecouvert = new GridBagConstraints();
		gbc_labelDecouvert.fill = GridBagConstraints.BOTH;
		gbc_labelDecouvert.insets = new Insets(0, 0, 0, 5);
		gbc_labelDecouvert.gridx = 0;
		gbc_labelDecouvert.gridy = 4;
		panelDroit.add(labelDecouvert, gbc_labelDecouvert);

		textDecouvert = new JTextField();
		textDecouvert.setColumns(10);
		GridBagConstraints gbc_textDecouvert = new GridBagConstraints();
		gbc_textDecouvert.fill = GridBagConstraints.BOTH;
		gbc_textDecouvert.gridx = 1;
		gbc_textDecouvert.gridy = 4;
		panelDroit.add(textDecouvert, gbc_textDecouvert);

		// Gestion de l'évenement sur le bouton modifier

		btnModifier.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	private void rechargementDuTableau() {

		// Ajout du JTable dans le panel centre
		tableCompte = new JTable(compteModele);
		scrollpane = new JScrollPane(tableCompte);
		// scrollpane.setPreferredSize(new Dimension(500, 300));

	}

	private void resetFicheConseiller() {
		// textNumero.setLong("");
		textSolde.setText("");
		textTaux.setText("");
		textDecouvert.setText("");
		typeCompte.setSelectedItem(typeCompte);
	}

	@SuppressWarnings({ "unused", "rawtypes", "null" })
	private void validerCompteAmodifierDansLaFiche() throws DataAccessException {

		String numMaj = textNumero.getText();
		String soldeMaj = textSolde.getText();
		String tauxMaj = textTaux.getText();
		ComboBoxModel comboBoxCompte = null;
		String typeMaj = comboBoxCompte.getSelectedItem().toString();
		String decouverteMaj = textDecouvert.getText();

		Compte compteMaj = compteService.findByNumero(numMaj);

		double solde = Double.parseDouble(soldeMaj);
		double taux = Double.parseDouble(tauxMaj);
		double decouvert = Double.parseDouble(decouverteMaj);

		compteMaj.setSolde_compte(solde);
		compteMaj.setTaux_remuneration(taux);
		compteMaj.setDecouvert(decouvert);
		java.sql.Date date_ouverture = null;
		compteMaj.setDate_ouverture(date_ouverture);
		compteMaj.setType_compte(typeMaj);

		rechargementDuTableau();

		// effacer les zones de textes
		resetFicheConseiller();

		Component panelHaut = null;
		// Message
		JOptionPane.showMessageDialog(panelHaut, "Mise à jour reussie");
	}

	/**
	 * @return the textNumero
	 */
	public JTextField getTextNumero() {
		return textNumero;
	}

	/**
	 * @param textNumero
	 *            the textNumero to set
	 */
	public void setTextNumero(JTextField textNumero) {
		this.textNumero = textNumero;
	}

	/**
	 * @return the textTaux
	 */
	public JTextField getTextTaux() {
		return textTaux;
	}

	/**
	 * @param textTaux
	 *            the textTaux to set
	 */
	public void setTextTaux(JTextField textTaux) {
		this.textTaux = textTaux;
	}

	/**
	 * @return the textSolde
	 */
	public JTextField getTextSolde() {
		return textSolde;
	}

	/**
	 * @param textSolde
	 *            the textSolde to set
	 */
	public void setTextSolde(JTextField textSolde) {
		this.textSolde = textSolde;
	}

	/**
	 * @return the textDecouvert
	 */
	public JTextField getTextDecouvert() {
		return textDecouvert;
	}

	/**
	 * @param textDecouvert
	 *            the textDecouvert to set
	 */
	public void setTextDecouvert(JTextField textDecouvert) {
		this.textDecouvert = textDecouvert;
	}

	/**
	 * @return the typeCompte
	 */
	@SuppressWarnings("rawtypes")
	public ComboBoxModel getTypeCompte() {
		return typeCompte;
	}

	/**
	 * @param typeCompte
	 *            the typeCompte to set
	 */
	@SuppressWarnings("rawtypes")
	public void setTypeCompte(ComboBoxModel typeCompte) {
		this.typeCompte = typeCompte;
	}

}
