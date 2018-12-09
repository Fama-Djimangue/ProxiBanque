package sn.objis.proxibanque.services;

import sn.objis.proxibanque.domaine.CompteUtilisateur;

public interface ICompteUtilisateurService extends IService<CompteUtilisateur>{

	public abstract CompteUtilisateur authentifierUser(String login, String pwd);
	
	public abstract CompteUtilisateur recupererUtilisateurParLogin(String login);
	
	public abstract CompteUtilisateur updateMdp(CompteUtilisateur compteUtilisateur,String nveMdp);

	
}
