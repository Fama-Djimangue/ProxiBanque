package sn.objis.proxibanque.presentation.verification;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import sn.objis.proxibanque.services.ClientService;


public class EmailVerification extends InputVerifier {
	//Permet la représentation d'un format
	private Pattern pattern;
	//permet de savoir si une chaine de carctère correspond à une expression réguliaire
	private Matcher matcher;
	ClientService gestionnaireClient;

	//Définition de l'expression régulière de l'email
	private static final String EMAILPATTERN="^[_A-Za-z0-9]+(\\."
			+ "[_A-Za-z0-9]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*"
			+ "(\\.[A-Za-z]{2,})$";

	
	public EmailVerification() {
		//Créer le format ou le mtif de l'email
		pattern = Pattern.compile(EMAILPATTERN);
		gestionnaireClient= new ClientService();
	}

	

	@Override
	public boolean verify(JComponent input) {
		String textSaisi = ((JTextField) input).getText();
		matcher=pattern.matcher(textSaisi);
		//On Vérifie si le texte correspondant à notre expression régulière
		if(!matcher.matches()){			
			JOptionPane.showMessageDialog(null, "Format Email Invalide!");
			return false;
		}		return true;
	}
}
