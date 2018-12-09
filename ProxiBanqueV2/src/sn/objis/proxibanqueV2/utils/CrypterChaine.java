package sn.objis.proxibanqueV2.utils;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CrypterChaine {

	public static String crypter(String password) {
		/*
		 * StringBuffer qui représente également une chaine de caractères mais
		 * les objets de type StringBuffer sont mutables. Dès lors, les
		 * opérations dessus seront plus rapides.
		 *
		 */		StringBuilder stringBuilder = null;

		try {

			/*
			 * Etape1: Obtention d'une l'implementation de l'agorithme de
			 * crypatge SHA-256 avec la mehode statique getInstance();
			 */

			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

			/*
			 * Etape2: Recuperation de la valeur de hachage avec la methode
			 * digest() qui prend en parametre un tableau de byte
			 */

			byte[] hash = messageDigest.digest(password.getBytes("UTF-8"));
			stringBuilder = new StringBuilder();
			
			/*Etape3: Parcour du tableau et convertion  de chaque  byte en  format hexadecimal*/
			
			for (int i = 0; i < hash.length; i++) {
				stringBuilder.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
			}
		} catch (UnsupportedEncodingException ex) {
			Logger.getLogger(CrypterChaine.class.getName()).log(Level.SEVERE, null, ex);
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(CrypterChaine.class.getName()).log(Level.SEVERE, null, ex);
		}
		return stringBuilder.toString();
	}
}
