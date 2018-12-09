package sn.objis.proxibanquev3.utils;

import java.text.DecimalFormat;

public class MethodUtils {
	/**
	 * M�thode qui g�n�re un NumAgence
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
	 * M�thode qui g�n�re un Numcompte ou NumTranction
	 * 
	 * @param id
	 * @param type
	 * @return
	 */
	public static String genererNumero(long id, String type) {
		DecimalFormat nf = new DecimalFormat("0000000");
		String numformat = nf.format(id);
		String num = null;		
		num = numformat + type.substring(6, 9);		
		return num;
	}
	
	/**
	 * M�thode qui g�n�re un Numcompte ou NumTranction
	 * 
	 * @param id
	 * @param type
	 * @return
	 */
	public static String genererNumeroOP(long id, String type) {
		DecimalFormat nf = new DecimalFormat("0000000");
		String numformat = nf.format(id);

		String num = null;
				
		num = numformat + type.substring(0, 3);

		return num;
	}

}
