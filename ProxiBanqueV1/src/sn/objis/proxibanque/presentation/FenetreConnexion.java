package sn.objis.proxibanque.presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import sn.objis.proxibanque.domaine.Agence;
import sn.objis.proxibanque.domaine.CompteUtilisateur;
import sn.objis.proxibanque.domaine.Employer;
import sn.objis.proxibanque.services.AgenceService;
import sn.objis.proxibanque.services.CompteUtilisateurService;
import sn.objis.proxibanque.services.EmployerService;
import sn.objis.proxibanque.utils.CrypterChaine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class FenetreConnexion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container container;
	private JTextField textLogin;
	private static String titres;
	private CompteUtilisateurService compteUtilisateurService = new CompteUtilisateurService();
	private CompteUtilisateur compteUtilisateur;
	private EmployerService employerService = new EmployerService();
	private Agence agence = new Agence();
	private AgenceService agenceService = new AgenceService();
	private JPasswordField textMdp;

	private Employer agentConnecte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreConnexion frame = new FenetreConnexion(titres);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	/**
	 * Create the frame.
	 * 
	 * @param string
	 */

	}

	public FenetreConnexion(String titre) {
		setTitle("Accueil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 614);
		container = getContentPane();

		JPanel panelCentre = new JPanel();
		panelCentre.setBackground(new Color(255, 255, 255));
		container.add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(null);

		JLabel labelEntree = new JLabel("Authentification");
		labelEntree.setHorizontalAlignment(SwingConstants.CENTER);
		labelEntree.setIcon(new ImageIcon("src/images/connecter50.jpg"));
		labelEntree.setBounds(141, 24, 395, 49);
		labelEntree.setForeground(new Color(165, 42, 42));
		labelEntree.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		panelCentre.add(labelEntree);

		JLabel labelLogin = new JLabel("Login");
		labelLogin.setIcon(new ImageIcon("src/images/login.jpg"));
		labelLogin.setForeground(new Color(0, 128, 0));
		labelLogin.setBounds(211, 105, 95, 33);
		labelLogin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelCentre.add(labelLogin);

		textLogin = new JTextField();
		textLogin.setBounds(312, 108, 203, 32);
		panelCentre.add(textLogin);
		textLogin.setColumns(10);

		JLabel labelMdp = new JLabel("Mot de Passe");
		labelMdp.setIcon(new ImageIcon("src/images/pass30.jpg"));
		labelMdp.setForeground(new Color(0, 128, 0));
		labelMdp.setBounds(141, 150, 165, 40);
		labelMdp.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelCentre.add(labelMdp);

		JCheckBox CheckBoxChMdp = new JCheckBox("Changer de mot de passe");
		CheckBoxChMdp.setBounds(349, 227, 139, 33);
		CheckBoxChMdp.setFont(new Font("Cambria", Font.BOLD, 10));
		panelCentre.add(CheckBoxChMdp);

		JButton boutonEntree = new JButton("Entrée");
		boutonEntree.setEnabled(false);
		boutonEntree.setBounds(251, 293, 108, 33);
		boutonEntree.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelCentre.add(boutonEntree);

		JButton boutonAnnuler = new JButton("Annuler");
		boutonAnnuler.setBounds(428, 293, 108, 33);
		boutonAnnuler.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panelCentre.add(boutonAnnuler);

		textMdp = new JPasswordField();
		textMdp.setBounds(312, 156, 203, 33);
		panelCentre.add(textMdp);

		JPanel panelHaut = new JPanel();
		panelHaut.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelHaut.setBackground(new Color(255, 255, 255));
		getContentPane().add(panelHaut, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon("src/images/bandeau1.jpg"));
		panelHaut.add(lblNewLabel);

		JPanel panelBas = new JPanel();
		panelBas.setBackground(new Color(0, 100, 0));
		panelBas.setBorder(new LineBorder(new Color(0, 100, 0), 5, true));
		getContentPane().add(panelBas, BorderLayout.SOUTH);

		boutonEntree.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {

				String loginSaisi = textLogin.getText();
				String mdpSaisi = textMdp.getText();
				String mdpDansLaBase = CrypterChaine.crypter(mdpSaisi);
				compteUtilisateur = compteUtilisateurService.recupererUtilisateurParLogin(loginSaisi);

				if (compteUtilisateur != null) {
					if (mdpDansLaBase.equals(compteUtilisateur.getPassword())) {

						if (CheckBoxChMdp.isSelected() == true) {
							FenetreChMdp fenetreMdp = new FenetreChMdp("titre");
							fenetreMdp.setVisible(true);
							fenetreMdp.getTextUser().setText(loginSaisi);
						} else {

							agentConnecte = employerService.findByIdCompteUser(compteUtilisateur);
							long id_agence = employerService.findIdAgence(agentConnecte);
							agence = agenceService.find(id_agence);

							
							FenetreAccueil fenetreAccueil = new FenetreAccueil("");
							fenetreAccueil.setEmployer(agentConnecte);
							fenetreAccueil.setCompteUtilisateur(compteUtilisateur);

							fenetreAccueil.getLabelLoginGerant().setText(
									agentConnecte.getPrenom_employer() + " " + agentConnecte.getNom_employer());

							String type = agentConnecte.getType_employer();
																
							if (type.equals("GAG")) {

								fenetreAccueil.getBoutonGestionClient().setVisible(false);
								fenetreAccueil.getBoutonGestionTransaction().setVisible(false);
								fenetreAccueil.getBoutonGestionCarte().setVisible(false);
								fenetreAccueil.getBoutonGestionClient().setVisible(false);
								fenetreAccueil.getBoutonGestionCompte().setVisible(false);
								fenetreAccueil.getLabelAgentConnecte().setText("Gérant: " + agence.getLibelle_agence());
								
							} else {
								long id_gerant = employerService.findIdGerantByCons(agentConnecte);
								Employer gerant = employerService.find(id_gerant);
								id_agence = employerService.findIdAgence(gerant);
								agence = agenceService.find(id_agence);
								fenetreAccueil.getLabelAgentConnecte().setText("Conseiller: " + agence.getLibelle_agence());
								fenetreAccueil.getBoutonGestionConseiller().setVisible(false);

								fenetreAccueil.getLabelAgentConnecte().setText("Conseiller: "+ agence.getLibelle_agence());


								fenetreAccueil.getLabelAgentConnecte()
										.setText("Conseiller: "+ agence.getLibelle_agence());

							}

							fenetreAccueil.setVisible(true);
							dispose();
						}
					} else {
						JOptionPane.showMessageDialog(panelCentre, "Mot de passe incorrecte!");
					}

				} else {
					JOptionPane.showMessageDialog(panelCentre, "Utilisateur inexistant!");
				}
			}
		});

		textMdp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyPressed(e);
				if (e.getKeyChar() != ' ') {
					boutonEntree.setEnabled(true);
				}
			}
		});

		boutonAnnuler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				resetSaisi();
			}
		});
	}

	public boolean verifierConnexion(String login, String pwd) {
		boolean conn = false;
		compteUtilisateur = compteUtilisateurService.authentifierUser(login, pwd);

		if (compteUtilisateur != null) {
			conn = true;

		}
		return conn;
	}

	private void resetSaisi() {
		textLogin.setText("");
		textMdp.setText("");
	}

	/**
	 * @return the gerantConnecte
	 */
	public Employer getGerantConnecte() {
		return agentConnecte;
	}

	/**
	 * @param gerantConnecte
	 *            the gerantConnecte to set
	 */
	public void setGerantConnecte(Employer gerantConnecte) {
		this.agentConnecte = gerantConnecte;
	}

}
