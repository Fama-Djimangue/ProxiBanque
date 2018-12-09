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

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;

import sn.objis.proxibanque.domaine.Client;
import sn.objis.proxibanque.domaine.Compte;
import sn.objis.proxibanque.domaine.Employer;
import sn.objis.proxibanque.presentation.modele.ClientModele;
import sn.objis.proxibanque.services.ClientService;
import sn.objis.proxibanque.services.CompteService;

import javax.swing.UIManager;
import javax.swing.JCheckBox;

public class PanelCreerClient extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textPrenom;
	private JTextField textNom;
	private JTextField textAdresse;
	private JTextField textCodePostal;
	private JTextField textTelephone;
	private JTextField textEmail;
	private JTextField textVille;
	private JTextField textProfession;
	private JTextField textNumero;

	private ClientService clientService = new ClientService();
	private ClientModele clientModele = new ClientModele();

	private CompteService compteService = new CompteService();
	private Employer conseillerClient;
	private JTextField textField;

	/**
	 * Create the panel.
	 */

	public PanelCreerClient() {
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));

		JPanel panelGauche = new JPanel();
		panelGauche.setForeground(Color.WHITE);
		panelGauche.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Saisie Client",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 100, 0)));
		panelGauche.setBackground(new Color(128, 128, 128));
		add(panelGauche, BorderLayout.WEST);
		panelGauche.setLayout(new GridLayout(0, 4, 10, 30));

		JLabel labelNom = new JLabel("Nom");
		labelNom.setForeground(new Color(128, 0, 0));
		labelNom.setBackground(new Color(255, 255, 255));
		labelNom.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelGauche.add(labelNom);

		textNom = new JTextField();
		panelGauche.add(textNom);
		textNom.setColumns(10);
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

		JLabel lblPriseEnCharge = new JLabel("Code Postal");
		lblPriseEnCharge.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblPriseEnCharge.setForeground(new Color(128, 0, 0));
		panelGauche.add(lblPriseEnCharge);

		textCodePostal = new JTextField();
		panelGauche.add(textCodePostal);
		textCodePostal.setColumns(10);
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

		JLabel labelPrenom = new JLabel("Prenom");
		labelPrenom.setForeground(new Color(128, 0, 0));
		labelPrenom.setBackground(new Color(255, 255, 255));
		labelPrenom.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelGauche.add(labelPrenom);

		textPrenom = new JTextField();
		panelGauche.add(textPrenom);
		textPrenom.setColumns(10);

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

		JLabel lblVille = new JLabel("Ville");
		lblVille.setForeground(new Color(128, 0, 0));
		lblVille.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelGauche.add(lblVille);

		textVille = new JTextField();
		textVille.setColumns(10);
		panelGauche.add(textVille);

		JLabel labelEmail = new JLabel("Email");
		labelEmail.setForeground(new Color(128, 0, 0));
		labelEmail.setBackground(new Color(255, 255, 255));
		labelEmail.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelGauche.add(labelEmail);

		textEmail = new JTextField();
		// textEmail.setInputVerifier(new EmailVerification());
		panelGauche.add(textEmail);
		textEmail.setColumns(10);

		JLabel labelTelephone = new JLabel("Telephone");
		labelTelephone.setForeground(new Color(128, 0, 0));
		labelTelephone.setBackground(new Color(255, 255, 255));
		labelTelephone.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelGauche.add(labelTelephone);

		textTelephone = new JTextField();
		panelGauche.add(textTelephone);
		textTelephone.setColumns(10);
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

		JLabel labelAdresse = new JLabel("Adresse");
		labelAdresse.setForeground(new Color(128, 0, 0));
		labelAdresse.setBackground(new Color(255, 255, 255));
		labelAdresse.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelGauche.add(labelAdresse);

		textAdresse = new JTextField();
		panelGauche.add(textAdresse);
		textAdresse.setColumns(10);

		JLabel labelAge = new JLabel("Profession");
		labelAge.setForeground(new Color(128, 0, 0));
		labelAge.setBackground(new Color(255, 255, 255));
		labelAge.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelGauche.add(labelAge);

		textProfession = new JTextField();
		textProfession.setColumns(10);
		panelGauche.add(textProfession);

		JLabel label = new JLabel("");
		panelGauche.add(label);

		JLabel label_1 = new JLabel("");
		panelGauche.add(label_1);

		JLabel label_2 = new JLabel("");
		panelGauche.add(label_2);

		JLabel label_4 = new JLabel("");
		panelGauche.add(label_4);

		JPanel panelHaut = new JPanel();
		panelHaut.setBorder(new LineBorder(new Color(128, 128, 128), 5));
		panelHaut.setBackground(new Color(255, 255, 255));
		add(panelHaut, BorderLayout.NORTH);

		JLabel labelFormClient = new JLabel("Formulaire Client");
		labelFormClient.setForeground(new Color(0, 100, 0));
		labelFormClient.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 50));
		labelFormClient.setHorizontalAlignment(SwingConstants.CENTER);
		panelHaut.add(labelFormClient);

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

		JPanel panelDroit = new JPanel();
		panelDroit.setForeground(Color.WHITE);
		panelDroit.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Saisie Compte",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 100, 0)));
		panelDroit.setBackground(Color.GRAY);
		add(panelDroit);
		panelDroit.setLayout(new GridLayout(6, 2, 4, 20));

		JLabel labelNumero = new JLabel("Numero");
		labelNumero.setHorizontalAlignment(SwingConstants.LEFT);
		labelNumero.setForeground(new Color(128, 0, 0));
		labelNumero.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		labelNumero.setBackground(Color.WHITE);
		panelDroit.add(labelNumero);

		textNumero = new JTextField();
		textNumero.setColumns(10);
		panelDroit.add(textNumero);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setVisible(false);
		panelDroit.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setVisible(false);
		panelDroit.add(textField);
		textField.setColumns(10);

		JCheckBox checkBoxCptEpargne = new JCheckBox("Compte Epagne");
		panelDroit.add(checkBoxCptEpargne);

		JCheckBox checkBoxCptCourant = new JCheckBox("Compte Courant");
		panelDroit.add(checkBoxCptCourant);

		JLabel lblCompteCourant = new JLabel("");
		panelDroit.add(lblCompteCourant);

		boutonAnnuler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textPrenom.setText("");
				textNom.setText("");
				textAdresse.setText("");
				textCodePostal.setText("");
				textTelephone.setText("");
				textEmail.setText("");

			}
		});

		boutonValider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Client newClient;
				Compte newCompte;
				boolean areEmpty = false;
				String nomSaisi = textNom.getText();
				String prenomSaisi = textPrenom.getText();
				String emailSaisi = textEmail.getText();
				String adresseSaisi = textAdresse.getText();
				String codeSaisi = textCodePostal.getText();
				String villeSaisi = textVille.getText();
				String telephoneSaisi = textTelephone.getText();
				String professionSaisi = textProfession.getText();

				String numeroSaisi = textNumero.getText();

				areEmpty = (!nomSaisi.isEmpty()) && (!prenomSaisi.isEmpty()) && (!emailSaisi.isEmpty())
						&& (!adresseSaisi.isEmpty()) && (!codeSaisi.isEmpty()) && (!villeSaisi.isEmpty())
						&& (!telephoneSaisi.isEmpty() && (!professionSaisi.isEmpty()) && (!numeroSaisi.isEmpty())
								&& (checkBoxCptCourant.isSelected() || checkBoxCptEpargne.isSelected()));
				if (!areEmpty) {
					JOptionPane.showMessageDialog(panelHaut, "Veuillez renseigner tous les champs");
				} else {
					System.out.println("PanelEnregClient :" + conseillerClient);
					System.out.println("CREATION DU NOUVEAU CLIENT");
					newClient = new Client(nomSaisi, prenomSaisi, emailSaisi, adresseSaisi, codeSaisi, villeSaisi,
							telephoneSaisi, professionSaisi);

					clientService.create(newClient, conseillerClient);
					clientModele.addClientInModele(newClient);
					long id = clientService.dernierId(newClient);
					newClient.setId_client(id);

					if (checkBoxCptCourant.isSelected() && !checkBoxCptEpargne.isSelected()) {
						System.out.println("CREATION DU NOUVEAU COMPTE COURANT");
						String typeCompte = "COURANT";
						newCompte = new Compte(numeroSaisi, typeCompte);
						compteService.create(newCompte, newClient);

					}
					if (checkBoxCptEpargne.isSelected() && !checkBoxCptCourant.isSelected()) {
						System.out.println("CREATION DU NOUVEAU COMPTE EPARGNE");
						String typeCompte = "EPARGNE";
						newCompte = new Compte(numeroSaisi, typeCompte);
						compteService.create(newCompte, newClient);

					}
					if (checkBoxCptCourant.isSelected() && checkBoxCptEpargne.isSelected()) {
						System.out.println("CREATION DE COMPTE COURANT/EPARGNE");
						newCompte = new Compte(numeroSaisi, "COURANT");
						compteService.create(newCompte, newClient);

						newCompte = new Compte(numeroSaisi, "EPARGNE");
						compteService.create(newCompte, newClient);

					}

					System.out.println(newClient.getId_client());

					resetFicheConseiller();
					JOptionPane.showMessageDialog(panelHaut, "Operation reussie");

					// Effacer les composants du panel
					removeAll();
					PanelGestionClient panelClient = new PanelGestionClient();
					add(panelClient, BorderLayout.CENTER);
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
	 * @return the conseillerClient
	 */
	public Employer getConseillerClient() {
		return conseillerClient;
	}

	/**
	 * @param conseillerClient
	 *            the conseillerClient to set
	 */
	public void setConseillerClient(Employer conseillerClient) {
		this.conseillerClient = conseillerClient;
	}

}
