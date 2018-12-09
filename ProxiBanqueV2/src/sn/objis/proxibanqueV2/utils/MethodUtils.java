package sn.objis.proxibanqueV2.utils;

import java.text.DecimalFormat;


import sn.objis.proxibanqueV2.domaine.Compte;
import sn.objis.proxibanqueV2.domaine.TransactionCompte;

public class MethodUtils {
	/**
	 * Méthode qui génére un NumAgence
	 * 
	 * @param id
	 * @param nomAgence
	 * @return
	 */
	public static String genererNumAgence(long id, String nomAgence) {

		DecimalFormat nf = new DecimalFormat("00");
		String numformat = nf.format(id);

		String num = null;
		if (nomAgence.length() < 3) {
			num = numformat + nomAgence;
		} else {
			num = numformat + nomAgence.substring(0, 3);
		}

		return num;
	}

	/**
	 * Méthode qui génére un Numcompte ou NumTranction
	 * 
	 * @param id
	 * @param type
	 * @return
	 */
	public static String genererNumero(long id, String type) {
		DecimalFormat nf = new DecimalFormat("0000000");
		String numformat = nf.format(id);

		String num = null;
		
		num = numformat + type.substring(0, 3);

		return num;
	}
	//Precise le type de virement 
	public static String typeVirement(TransactionCompte transactionCompte, Compte compte){
		String type=null;

			if (transactionCompte.getId_compte_crediter()!=0 && transactionCompte.getId_compte_debiter()!=0) {
				if (transactionCompte.getId_compte_crediter()==compte.getId_compte()) {
					type="RECUE DE";
				}else {
					type="EFFECTUEE VERS";
				}
			} else {
				type=null;
			}

		return type;
		
	}

}
