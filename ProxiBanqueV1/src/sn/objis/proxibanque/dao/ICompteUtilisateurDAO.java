package sn.objis.proxibanque.dao;

import sn.objis.proxibanque.domaine.CompteUtilisateur;

public interface ICompteUtilisateurDAO extends IDAO<CompteUtilisateur>{

	public abstract CompteUtilisateur authentifierUser(String login, String pwd);
	
	public abstract CompteUtilisateur recupererUtilisateurParLogin(String login);
	
	public abstract CompteUtilisateur updateMdp(CompteUtilisateur compteUtilisateur,String nveMdp);

}
