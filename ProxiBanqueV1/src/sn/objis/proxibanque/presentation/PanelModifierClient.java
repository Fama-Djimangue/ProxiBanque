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
import javax.swing.border.TitledBorder;

import sn.objis.proxibanque.dao.DataAccessException;
import sn.objis.proxibanque.domaine.Client;
import sn.objis.proxibanque.services.ClientService;

import javax.swing.UIManager;

public class PanelModifierClient extends JPanel {
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
	private ClientService clientService = new ClientService();
	private String emailAmodifier;


	/**
	 * Create the panel.
	 */

	public PanelModifierClient() {
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));

		JPanel panelCentre = new JPanel();
		panelCentre.setForeground(Color.WHITE);
		panelCentre.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Modification du client",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 100, 0)));
		panelCentre.setBackground(new Color(128, 128, 128));
		add(panelCentre);
		panelCentre.setLayout(null);

		JLabel labelPrenom = new JLabel("Prenom");
		labelPrenom.setBounds(10, 61, 489, 29);
		labelPrenom.setForeground(new Color(128, 0, 0));
		labelPrenom.setBackground(new Color(255, 255, 255));
		labelPrenom.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelCentre.add(labelPrenom);

		textPrenom = new JTextField();
		textPrenom.setBounds(150, 61, 195, 29);
		panelCentre.add(textPrenom);
		textPrenom.setColumns(10);

		JLabel labelNom = new JLabel("Nom");
		labelNom.setBounds(10, 22, 489, 28);
		labelNom.setForeground(new Color(128, 0, 0));
		labelNom.setBackground(new Color(255, 255, 255));
		labelNom.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelCentre.add(labelNom);

		textNom = new JTextField();
		textNom.setBounds(150, 22, 195, 28);
		panelCentre.add(textNom);
		textNom.setColumns(10);

		JLabel labelAdresse = new JLabel("Adresse");
		labelAdresse.setBounds(10, 149, 489, 28);
		labelAdresse.setForeground(new Color(128, 0, 0));
		labelAdresse.setBackground(new Color(255, 255, 255));
		labelAdresse.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelCentre.add(labelAdresse);

		textAdresse = new JTextField();
		textAdresse.setBounds(150, 142, 195, 66);
		panelCentre.add(textAdresse);
		textAdresse.setColumns(10);

		JLabel labelAge = new JLabel("Profession");
		labelAge.setBounds(378, 150, 121, 30);
		labelAge.setForeground(new Color(128, 0, 0));
		labelAge.setBackground(new Color(255, 255, 255));
		labelAge.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelCentre.add(labelAge);

		textCodePostal = new JTextField();
		textCodePostal.setBounds(535, 23, 195, 28);
		panelCentre.add(textCodePostal);
		textCodePostal.setColumns(10);

		JLabel labelTelephone = new JLabel("Telephone");
		labelTelephone.setBounds(377, 109, 122, 30);
		labelTelephone.setForeground(new Color(128, 0, 0));
		labelTelephone.setBackground(new Color(255, 255, 255));
		labelTelephone.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelCentre.add(labelTelephone);

		textTelephone = new JTextField();
		textTelephone.setBounds(535, 109, 195, 28);
		panelCentre.add(textTelephone);
		textTelephone.setColumns(10);

		JLabel labelEmail = new JLabel("Email");
		labelEmail.setBounds(10, 109, 489, 29);
		labelEmail.setForeground(new Color(128, 0, 0));
		labelEmail.setBackground(new Color(255, 255, 255));
		labelEmail.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelCentre.add(labelEmail);

		textEmail = new JTextField();
		textEmail.setBounds(150, 101, 195, 29);
		// textEmail.setInputVerifier(new EmailVerification());
		panelCentre.add(textEmail);
		textEmail.setColumns(10);

		JLabel lblPriseEnCharge = new JLabel("Code Postal");
		lblPriseEnCharge.setBounds(378, 22, 121, 33);
		lblPriseEnCharge.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblPriseEnCharge.setForeground(new Color(128, 0, 0));
		panelCentre.add(lblPriseEnCharge);

		JLabel lblVille = new JLabel("Ville");
		lblVille.setForeground(new Color(128, 0, 0));
		lblVille.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblVille.setBounds(377, 61, 122, 33);
		panelCentre.add(lblVille);

		textVille = new JTextField();
		textVille.setColumns(10);
		textVille.setBounds(535, 62, 195, 28);
		panelCentre.add(textVille);

		textProfession = new JTextField();
		textProfession.setColumns(10);
		textProfession.setBounds(535, 148, 195, 29);
		panelCentre.add(textProfession);

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

		JButton boutonModifier = new JButton("Modifier");
		boutonModifier.setToolTipText("Enregister dans la base");
		boutonModifier.setBackground(new Color(128, 128, 128));
		boutonModifier.setForeground(new Color(0, 0, 0));
		boutonModifier.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		panelBas.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelBas.add(boutonModifier);

		JButton boutonAnnuler = new JButton("Annuler");
		boutonAnnuler.setToolTipText("Effacer tous les champs");
		boutonAnnuler.setBackground(new Color(128, 128, 128));
		boutonAnnuler.setForeground(new Color(0, 0, 0));
		boutonAnnuler.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		panelBas.add(boutonAnnuler);

		boutonModifier.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Client client = null;
				Client clientAmodifier;

				boolean areEmpty = false;
				String nomSaisi = textNom.getText();
				String prenomSaisi = textPrenom.getText();
				String emailSaisi = textEmail.getText();
				String adresseSaisi = textAdresse.getText();
				String codeSaisi = textCodePostal.getText();
				String villeSaisi = textVille.getText();
				String telephoneSaisi = textTelephone.getText();
				String professionSaisi = textProfession.getText();

				areEmpty = (!nomSaisi.isEmpty()) && (!prenomSaisi.isEmpty()) && (!emailSaisi.isEmpty())
						&& (!adresseSaisi.isEmpty()) && (!codeSaisi.isEmpty()) && (!villeSaisi.isEmpty())
						&& (!telephoneSaisi.isEmpty() && (!professionSaisi.isEmpty()));
				if (!areEmpty) {
					JOptionPane.showMessageDialog(panelHaut, "Veuillez renseigner tous les champs");
				} else {

					clientAmodifier = clientService.findByEmail(emailAmodifier);
					if (clientAmodifier != null)

					client = new Client(clientAmodifier.getId_client(),nomSaisi, prenomSaisi, emailSaisi, adresseSaisi, codeSaisi, villeSaisi,
							telephoneSaisi, professionSaisi);
					
					try {

						clientService.update(client);

						// effacer les zones de textes
						resetFicheClient();

						JOptionPane.showMessageDialog(panelHaut, "Operation reussie");

					} catch (DataAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
				removeAll();
				PanelGestionClient panelClient = new PanelGestionClient();
				add(panelClient, BorderLayout.CENTER);
				validate();

			}

		});

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

	}

	private void resetFicheClient() {

		textNom.setText("");
		textPrenom.setText("");
		textEmail.setText("");
		textAdresse.setText("");
		textCodePostal.setText("");
		textVille.setText("");
		textTelephone.setText("");
		textProfession.setText("");

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
	 * @return the textProfession
	 */
	public JTextField getTextProfession() {
		return textProfession;
	}

	/**
	 * @param textProfession
	 *            the textProfession to set
	 */
	public void setTextProfession(JTextField textProfession) {
		this.textProfession = textProfession;
	}

	/**
	 * @return the emailRecupere
	 */
	public String getEmailRecupere() {
		return emailAmodifier;
	}

	/**
	 * @param emailRecupere
	 *            the emailRecupere to set
	 */
	public void setEmailRecupere(String emailRecupere) {
		this.emailAmodifier = emailRecupere;
	}

}
