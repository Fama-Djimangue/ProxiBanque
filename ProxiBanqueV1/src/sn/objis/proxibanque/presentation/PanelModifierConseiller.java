package sn.objis.proxibanque.presentation;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import javax.swing.border.LineBorder;

import sn.objis.proxibanque.dao.DataAccessException;
import sn.objis.proxibanque.domaine.Employer;
import sn.objis.proxibanque.presentation.modele.EmployerModele;
import sn.objis.proxibanque.services.EmployerService;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class PanelModifierConseiller extends JPanel {
	private JTextField textNom;
	private JTextField textPrenom;
	private JTextField textAdresse;
	private JTextField textCodePostal;
	private JTextField textTelephone;
	private JTextField textEmail;
	private JTextField textVille;
	private JTextField textLogin;
	private JPasswordField FieldPwd;
	private EmployerService employerService = new EmployerService();
	private EmployerModele employerModele = new EmployerModele();
	private JTable tableConseillers;
	JScrollPane scrollpane;
	private String oldEmail;
	/**
	 * Create the panel.
	 */
	public PanelModifierConseiller() {
		setLayout(new BorderLayout(0, 0));

		JPanel panelHaut = new JPanel();
		panelHaut.setBackground(new Color(192, 192, 192));
		add(panelHaut, BorderLayout.NORTH);

		JLabel lblTitre = new JLabel("Formulaire des Conseillers");
		lblTitre.setForeground(new Color(0, 100, 0));
		lblTitre.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 50));
		panelHaut.add(lblTitre);

		JPanel panelBas = new JPanel();
		panelBas.setBorder(new LineBorder(new Color(0, 100, 0), 10));
		add(panelBas, BorderLayout.SOUTH);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		panelBas.add(btnModifier);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		panelBas.add(btnAnnuler);

		JPanel panelCentre = new JPanel();
		panelCentre.setBackground(new Color(220, 220, 220));
		add(panelCentre, BorderLayout.WEST);
		GridBagLayout gbl_panelCentre = new GridBagLayout();
		gbl_panelCentre.columnWidths = new int[] { 106, 206, 0 };
		gbl_panelCentre.rowHeights = new int[] { 40, 40, 40, 40, 40, 40, 40, 0, 40, 40, 0 };
		gbl_panelCentre.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelCentre.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panelCentre.setLayout(gbl_panelCentre);

		JLabel lblNom = new JLabel("Nom :");
		lblNom.setForeground(new Color(128, 0, 0));
		lblNom.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.fill = GridBagConstraints.BOTH;
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 0;
		gbc_lblNom.gridy = 0;
		panelCentre.add(lblNom, gbc_lblNom);

		textNom = new JTextField();
		GridBagConstraints gbc_textNom = new GridBagConstraints();
		gbc_textNom.fill = GridBagConstraints.BOTH;
		gbc_textNom.insets = new Insets(0, 0, 5, 0);
		gbc_textNom.gridx = 1;
		gbc_textNom.gridy = 0;
		panelCentre.add(textNom, gbc_textNom);
		textNom.setColumns(10);

		JLabel labelPrenom = new JLabel("Prenom :");
		labelPrenom.setForeground(new Color(128, 0, 0));
		labelPrenom.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		GridBagConstraints gbc_labelPrenom = new GridBagConstraints();
		gbc_labelPrenom.fill = GridBagConstraints.BOTH;
		gbc_labelPrenom.insets = new Insets(0, 0, 5, 5);
		gbc_labelPrenom.gridx = 0;
		gbc_labelPrenom.gridy = 1;
		panelCentre.add(labelPrenom, gbc_labelPrenom);

		textPrenom = new JTextField();
		GridBagConstraints gbc_textPrenom = new GridBagConstraints();
		gbc_textPrenom.fill = GridBagConstraints.BOTH;
		gbc_textPrenom.insets = new Insets(0, 0, 5, 0);
		gbc_textPrenom.gridx = 1;
		gbc_textPrenom.gridy = 1;
		panelCentre.add(textPrenom, gbc_textPrenom);
		textPrenom.setColumns(10);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setForeground(new Color(128, 0, 0));
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.fill = GridBagConstraints.BOTH;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 2;
		panelCentre.add(lblEmail, gbc_lblEmail);

		textEmail = new JTextField();
		GridBagConstraints gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.fill = GridBagConstraints.BOTH;
		gbc_textEmail.insets = new Insets(0, 0, 5, 0);
		gbc_textEmail.gridx = 1;
		gbc_textEmail.gridy = 2;
		panelCentre.add(textEmail, gbc_textEmail);
		textEmail.setColumns(10);

		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setForeground(new Color(128, 0, 0));
		lblAdresse.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
		gbc_lblAdresse.fill = GridBagConstraints.BOTH;
		gbc_lblAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresse.gridx = 0;
		gbc_lblAdresse.gridy = 3;
		panelCentre.add(lblAdresse, gbc_lblAdresse);

		textAdresse = new JTextField();
		GridBagConstraints gbc_textAdresse = new GridBagConstraints();
		gbc_textAdresse.fill = GridBagConstraints.BOTH;
		gbc_textAdresse.insets = new Insets(0, 0, 5, 0);
		gbc_textAdresse.gridx = 1;
		gbc_textAdresse.gridy = 3;
		panelCentre.add(textAdresse, gbc_textAdresse);
		textAdresse.setColumns(50);

		JLabel lblVille = new JLabel("Ville : ");
		lblVille.setForeground(new Color(128, 0, 0));
		lblVille.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		GridBagConstraints gbc_lblVille = new GridBagConstraints();
		gbc_lblVille.fill = GridBagConstraints.BOTH;
		gbc_lblVille.insets = new Insets(0, 0, 5, 5);
		gbc_lblVille.gridx = 0;
		gbc_lblVille.gridy = 4;
		panelCentre.add(lblVille, gbc_lblVille);

		textVille = new JTextField();
		GridBagConstraints gbc_textVille = new GridBagConstraints();
		gbc_textVille.fill = GridBagConstraints.BOTH;
		gbc_textVille.insets = new Insets(0, 0, 5, 0);
		gbc_textVille.gridx = 1;
		gbc_textVille.gridy = 4;
		panelCentre.add(textVille, gbc_textVille);
		textVille.setColumns(10);

		JLabel lblTelephone = new JLabel("T\u00E9l\u00E9phone :");
		lblTelephone.setForeground(new Color(128, 0, 0));
		lblTelephone.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		GridBagConstraints gbc_lblTelephone = new GridBagConstraints();
		gbc_lblTelephone.fill = GridBagConstraints.BOTH;
		gbc_lblTelephone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelephone.gridx = 0;
		gbc_lblTelephone.gridy = 5;
		panelCentre.add(lblTelephone, gbc_lblTelephone);

		textTelephone = new JTextField();
		GridBagConstraints gbc_textTelephone = new GridBagConstraints();
		gbc_textTelephone.fill = GridBagConstraints.BOTH;
		gbc_textTelephone.insets = new Insets(0, 0, 5, 0);
		gbc_textTelephone.gridx = 1;
		gbc_textTelephone.gridy = 5;
		panelCentre.add(textTelephone, gbc_textTelephone);
		textTelephone.setColumns(10);

		JLabel lblCode = new JLabel("Code Postal :");
		lblCode.setForeground(new Color(128, 0, 0));
		lblCode.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		GridBagConstraints gbc_lblCode = new GridBagConstraints();
		gbc_lblCode.fill = GridBagConstraints.BOTH;
		gbc_lblCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblCode.gridx = 0;
		gbc_lblCode.gridy = 6;
		panelCentre.add(lblCode, gbc_lblCode);

		textCodePostal = new JTextField();
		GridBagConstraints gbc_textCodePostal = new GridBagConstraints();
		gbc_textCodePostal.insets = new Insets(0, 0, 5, 0);
		gbc_textCodePostal.fill = GridBagConstraints.BOTH;
		gbc_textCodePostal.gridx = 1;
		gbc_textCodePostal.gridy = 6;
		panelCentre.add(textCodePostal, gbc_textCodePostal);
		textCodePostal.setColumns(10);

		// Ajout du JTable dans le panel centre
		employerModele = new EmployerModele();
		tableConseillers = new JTable(employerModele);
		scrollpane = new JScrollPane(tableConseillers);
		scrollpane.setPreferredSize(new Dimension(500, 300));

		// Gestion de l'évenement sur le bouton modifier

		btnModifier.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					validerEmployerAmodifierDansLaFiche();
				} catch (DataAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				// Effacer les composants du panel
				removeAll();
				PanelGestionConseiller formconseil = new PanelGestionConseiller();
				add(formconseil, BorderLayout.CENTER);
				validate();

			}
		});

	}

	private void validerEmployerAmodifierDansLaFiche() throws DataAccessException {

		String nomMaj = textNom.getText();
		String prenomMaj = textPrenom.getText();
		String emailMaj = textEmail.getText();
		String adresseMaj = textAdresse.getText();
		String codeMaj = textCodePostal.getText();
		String villeMaj = textVille.getText();
		String telephoneMaj = textTelephone.getText();

		Employer conseillerMaj =  employerService.findByEmail(getOldEmail());

		conseillerMaj.setNom_employer(nomMaj);
		conseillerMaj.setPrenom_employer(prenomMaj);
		conseillerMaj.setEmail_employer(emailMaj);
		conseillerMaj.setAdresse_employer(adresseMaj);
		conseillerMaj.setCode_postal(codeMaj);
		conseillerMaj.setVille_employer(villeMaj);
		conseillerMaj.setTelephone_employer(telephoneMaj);

		// Enregistrement de l'etudiant modifie dans la base
		employerService.update(conseillerMaj);

		// Enregistrement de l'etudiant modifier dans le modele
		// rechargementDuTableau();

		// effacer les zones de textes
		resetFicheConseiller();

		Component panelHaut = null;
		// Message
		JOptionPane.showMessageDialog(panelHaut, "Mise à jour reussie");
	}

	private void resetFicheConseiller() {

		textNom.setText("");
		textPrenom.setText("");
		textEmail.setText("");
		textAdresse.setText("");
		textCodePostal.setText("");
		textVille.setText("");
		textTelephone.setText("");

	}

	/**
	 * @return the textNom
	 */
	public JTextField getTextNom() {
		return textNom;
	}

	/**
	 * @param textNom
	 *            the textNom to set
	 */
	public void setTextNom(JTextField textNom) {
		this.textNom = textNom;
	}

	/**
	 * @return the textPrenom
	 */
	public JTextField getTextPrenom() {
		return textPrenom;
	}

	/**
	 * @param textPrenom
	 *            the textPrenom to set
	 */
	public void setTextPrenom(JTextField textPrenom) {
		this.textPrenom = textPrenom;
	}

	/**
	 * @return the textAdresse
	 */
	public JTextField getTextAdresse() {
		return textAdresse;
	}

	/**
	 * @param textAdresse
	 *            the textAdresse to set
	 */
	public void setTextAdresse(JTextField textAdresse) {
		this.textAdresse = textAdresse;
	}

	/**
	 * @return the textCodePostal
	 */
	public JTextField getTextCodePostal() {
		return textCodePostal;
	}

	/**
	 * @param textCodePostal
	 *            the textCodePostal to set
	 */
	public void setTextCodePostal(JTextField textCodePostal) {
		this.textCodePostal = textCodePostal;
	}

	/**
	 * @return the textTelephone
	 */
	public JTextField getTextTelephone() {
		return textTelephone;
	}

	/**
	 * @param textTelephone
	 *            the textTelephone to set
	 */
	public void setTextTelephone(JTextField textTelephone) {
		this.textTelephone = textTelephone;
	}

	/**
	 * @return the textEmail
	 */
	public JTextField getTextEmail() {
		return textEmail;
	}

	/**
	 * @param textEmail
	 *            the textEmail to set
	 */
	public void setTextEmail(JTextField textEmail) {
		this.textEmail = textEmail;
	}

	/**
	 * @return the textVille
	 */
	public JTextField getTextVille() {
		return textVille;
	}

	/**
	 * @param textVille
	 *            the textVille to set
	 */
	public void setTextVille(JTextField textVille) {
		this.textVille = textVille;
	}

	/**
	 * @return the textLogin
	 */
	public JTextField getTextLogin() {
		return textLogin;
	}

	/**
	 * @param textLogin
	 *            the textLogin to set
	 */
	public void setTextLogin(JTextField textLogin) {
		this.textLogin = textLogin;
	}

	/**
	 * @return the fieldPwd
	 */
	public JPasswordField getFieldPwd() {
		return FieldPwd;
	}

	/**
	 * @param fieldPwd
	 *            the fieldPwd to set
	 */
	public void setFieldPwd(JPasswordField fieldPwd) {
		FieldPwd = fieldPwd;
	}

	/**
	 * @return the oldEmail
	 */
	public String getOldEmail() {
		return oldEmail;
	}

	/**
	 * @param oldEmail the oldEmail to set
	 */
	public void setOldEmail(String oldEmail) {
		this.oldEmail = oldEmail;
	}



}
