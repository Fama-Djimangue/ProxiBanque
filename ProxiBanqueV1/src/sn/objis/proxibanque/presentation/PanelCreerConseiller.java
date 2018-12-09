package sn.objis.proxibanque.presentation;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import sn.objis.proxibanque.domaine.CompteUtilisateur;
import sn.objis.proxibanque.domaine.Employer;
import sn.objis.proxibanque.presentation.modele.EmployerModele;
import sn.objis.proxibanque.services.CompteUtilisateurService;
import sn.objis.proxibanque.services.EmployerService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelCreerConseiller extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNom;
	private JTextField textPrenom;
	private JTextField textAdresse;
	private JTextField textCodePostal;
	private JTextField textTelephone;
	private JTextField textEmail;
	private JTextField textVille;
	private JTextField textLogin;
	private JPasswordField textPwd;

	private EmployerService employerService = new EmployerService();
	private CompteUtilisateurService compteuserService = new CompteUtilisateurService();

	private EmployerModele employerModele = new EmployerModele();
	private Employer gerantAgence;

	/**
	 * Create the panel.
	 */
	public PanelCreerConseiller() {
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

		JButton boutonValider = new JButton("Valider");
		boutonValider.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		panelBas.add(boutonValider);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		panelBas.add(btnAnnuler);

		JPanel panelCentre = new JPanel();
		panelCentre.setBackground(new Color(220, 220, 220));
		add(panelCentre, BorderLayout.WEST);
		panelCentre.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNom = new JLabel("Nom :");
		lblNom.setForeground(new Color(128, 0, 0));
		lblNom.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelCentre.add(lblNom);

		textNom = new JTextField();
		panelCentre.add(textNom);
		textNom.setColumns(10);

		JLabel labelPrenom = new JLabel("Prenom :");
		labelPrenom.setForeground(new Color(128, 0, 0));
		labelPrenom.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelCentre.add(labelPrenom);

		textPrenom = new JTextField();
		panelCentre.add(textPrenom);
		textPrenom.setColumns(10);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setForeground(new Color(128, 0, 0));
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelCentre.add(lblEmail);

		textEmail = new JTextField();
		panelCentre.add(textEmail);
		textEmail.setColumns(10);

		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setForeground(new Color(128, 0, 0));
		lblAdresse.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelCentre.add(lblAdresse);

		textAdresse = new JTextField();
		panelCentre.add(textAdresse);
		textAdresse.setColumns(50);

		JLabel lblVille = new JLabel("Ville : ");
		lblVille.setForeground(new Color(128, 0, 0));
		lblVille.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelCentre.add(lblVille);

		textVille = new JTextField();
		panelCentre.add(textVille);
		textVille.setColumns(10);

		JLabel lblTelephone = new JLabel("T\u00E9l\u00E9phone :");
		lblTelephone.setForeground(new Color(128, 0, 0));
		lblTelephone.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelCentre.add(lblTelephone);

		textTelephone = new JTextField();
		panelCentre.add(textTelephone);
		textTelephone.setColumns(10);

		JLabel lblCode = new JLabel("Code Postal :");
		lblCode.setForeground(new Color(128, 0, 0));
		lblCode.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelCentre.add(lblCode);

		textCodePostal = new JTextField();
		panelCentre.add(textCodePostal);
		textCodePostal.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setVisible(false);
		panelCentre.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Information Connexion");
		panelCentre.add(lblNewLabel);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));

		JLabel lblLogin = new JLabel("Login :");
		panelCentre.add(lblLogin);
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));

		textLogin = new JTextField();
		panelCentre.add(textLogin);
		textLogin.setColumns(10);

		JLabel lblPasswd = new JLabel("password :");
		lblPasswd.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelCentre.add(lblPasswd);

		textPwd = new JPasswordField();
		panelCentre.add(textPwd);

		btnAnnuler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textPrenom.setText("");
				textNom.setText("");
				textAdresse.setText("");
				textCodePostal.setText("");
				textTelephone.setText("");
				textEmail.setText("");
				textLogin.setText("");
				textPwd.setText("");

			}
		});

		// KeyListener est utiliser pour les événements sur le clavier
		textPrenom.addKeyListener(new KeyAdapter() {
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
		textNom.addKeyListener(new KeyAdapter() {
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
		textCodePostal.addKeyListener(new KeyAdapter() {
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
		textTelephone.addKeyListener(new KeyAdapter() {
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

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("FE:" + gerantAgence);
				// TODO Auto-generated method stub
				Employer newConseiller;
				CompteUtilisateur compteuser;
				boolean areEmpty = false;
				String nomSaisi = textNom.getText();
				String prenomSaisi = textPrenom.getText();
				String emailSaisi = textEmail.getText();
				String adresseSaisi = textAdresse.getText();
				String codeSaisi = textCodePostal.getText();
				String villeSaisi = textVille.getText();
				String telephoneSaisi = textTelephone.getText();
				String loginSaisi = textLogin.getText();
				String pwdSaisi = textPwd.getText();

				areEmpty = (!nomSaisi.isEmpty()) && (!prenomSaisi.isEmpty()) && (!emailSaisi.isEmpty())
						&& (!adresseSaisi.isEmpty()) && (!codeSaisi.isEmpty()) && (!villeSaisi.isEmpty())
						&& (!telephoneSaisi.isEmpty() && (!loginSaisi.isEmpty()) && (!pwdSaisi.isEmpty()));
				if (!areEmpty) {
					JOptionPane.showMessageDialog(panelHaut, "Veuillez renseigner tous les champs");
				} else {

					compteuser = new CompteUtilisateur(loginSaisi, pwdSaisi);
					compteuserService.create(compteuser);

					long dernierId = compteuserService.dernierIdCompteUser(compteuser);
					compteuser.setId_compte_user(dernierId);
					System.out.println(dernierId);

					newConseiller = new Employer(nomSaisi, prenomSaisi, emailSaisi, adresseSaisi, codeSaisi, villeSaisi,
							telephoneSaisi);
					employerService.createConseiller(newConseiller, compteuser, gerantAgence);

					employerModele.addEmployerInModele(newConseiller);

					resetFicheConseiller();

					JOptionPane.showMessageDialog(panelHaut, "Operation reussie");

					// Effacer les composants du panel
					removeAll();
					PanelGestionConseiller formconseil = new PanelGestionConseiller();
					add(formconseil, BorderLayout.CENTER);
					validate();

				}

			}

		});

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
	 * @return the gerantAgence
	 */
	public Employer getGerantAgence() {
		return gerantAgence;
	}

	/**
	 * @param gerantAgence
	 *            the gerantAgence to set
	 */
	public void setGerantAgence(Employer gerantAgence) {
		this.gerantAgence = gerantAgence;
	}

}
