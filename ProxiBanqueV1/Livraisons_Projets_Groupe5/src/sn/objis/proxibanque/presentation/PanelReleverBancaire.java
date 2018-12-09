package sn.objis.proxibanque.presentation;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("serial")
public class PanelReleverBancaire extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelReleverBancaire() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Relev\u00E9 d'identit\u00E9 Bancaire");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 50));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		
		JLabel lblEnCours = new JLabel("En Cours ...");
		lblEnCours.setForeground(new Color(0, 128, 0));
		lblEnCours.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
		panel_1.add(lblEnCours);

	}

}
