package sn.objis.proxibanque.presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sn.objis.proxibanque.domaine.CompteUtilisateur;
import sn.objis.proxibanque.services.CompteUtilisateurService;
import sn.objis.proxibanque.utils.CompareChaine;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;

public class FenetreChMdp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUser;
	private JTextField textAncienMdp;
	private CompteUtilisateurService compteUtilisateurService = new CompteUtilisateurService();
	private CompteUtilisateur compteUtilisateur;
	private JPasswordField textNveMdp;
	private JPasswordField textConfMdp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreChMdp frame = new FenetreChMdp("titre");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenetreChMdp(String title) {
		setTitle("Changement de Mot de Passe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel labelUser = new JLabel("Utilisateur");
		labelUser.setFont(new Font("Cambria", Font.BOLD, 12));
		labelUser.setBounds(0, 0, 106, 21);
		panel.add(labelUser);

		textUser = new JTextField();
		textUser.setBounds(212, 0, 212, 28);
		panel.add(textUser);
		textUser.setColumns(10);
		textUser.setEditable(false);

		JLabel labelAncienMpd = new JLabel("Ancien mot de passe");
		labelAncienMpd.setFont(new Font("Cambria", Font.BOLD, 12));
		labelAncienMpd.setBounds(0, 28, 124, 21);
		panel.add(labelAncienMpd);

		textAncienMdp = new JTextField();
		textAncienMdp.setBounds(212, 28, 212, 28);
		panel.add(textAncienMdp);
		textAncienMdp.setColumns(10);

		JLabel labelNouveauMdp = new JLabel("Nouveau mot de passe");
		labelNouveauMdp.setFont(new Font("Cambria", Font.BOLD, 12));
		labelNouveauMdp.setBounds(0, 60, 140, 21);
		panel.add(labelNouveauMdp);

		JLabel labelConfMpd = new JLabel("Confirmer Mot de passe");
		labelConfMpd.setFont(new Font("Cambria", Font.BOLD, 12));
		labelConfMpd.setBounds(0, 92, 146, 21);
		panel.add(labelConfMpd);

		JButton boutonValider = new JButton("Valider");
		boutonValider.setFont(new Font("Cambria", Font.BOLD, 16));
		boutonValider.setBounds(57, 149, 140, 40);
		panel.add(boutonValider);

		JButton boutonAnnuler = new JButton("Annuler");
		boutonAnnuler.setFont(new Font("Cambria", Font.BOLD, 16));
		boutonAnnuler.setBounds(247, 149, 140, 40);
		panel.add(boutonAnnuler);

		textNveMdp = new JPasswordField();
		textNveMdp.setBounds(212, 57, 212, 28);
		panel.add(textNveMdp);

		textConfMdp = new JPasswordField();
		textConfMdp.setBounds(212, 85, 212, 28);
		panel.add(textConfMdp);

		boutonValider.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				String user = textUser.getText();
				String ancienMdp = textAncienMdp.getText();
				String nveMdp = textNveMdp.getText();
				boolean areEmpty = false;
				String confMdp = textConfMdp.getText();
				areEmpty = (!ancienMdp.isEmpty()) && (!nveMdp.isEmpty()) && (!confMdp.isEmpty());
				if (!areEmpty) {
					JOptionPane.showMessageDialog(panel, "Veuillez saisir tous les champs!");
				} else {
					compteUtilisateur = compteUtilisateurService.authentifierUser(user, ancienMdp);
					System.out.println(compteUtilisateur + " est l'utilisateur trouveé");
					if (compteUtilisateur == null) {
						JOptionPane.showMessageDialog(panel, "Ancien Mot de passe incorrecte!");
					} else {
						boolean verif = CompareChaine.chaineEgale(nveMdp, confMdp);
						if (verif == true) {
							compteUtilisateurService.updateMdp(compteUtilisateur, nveMdp);
							JOptionPane.showMessageDialog(panel, "Mot de passe mis à jour!");

						} else {
							JOptionPane.showMessageDialog(panel, "Mot de confirmer different du nouveau passe!");
						}
					}
				}

			}
		});
		boutonAnnuler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FenetreConnexion accueil = new FenetreConnexion("titre");
				accueil.setVisible(true);
				FenetreChMdp fenetreMdp = new FenetreChMdp("titre");
				fenetreMdp.setVisible(false);
			}
		});

	}

	/**
	 * @return the textUser
	 */
	public JTextField getTextUser() {
		return textUser;
	}

	/**
	 * @param textUser
	 *            the textUser to set
	 */
	public void setTextUser(JTextField textUser) {
		this.textUser = textUser;
	}
}
