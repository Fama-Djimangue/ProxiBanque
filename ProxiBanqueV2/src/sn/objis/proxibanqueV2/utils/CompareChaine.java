package sn.objis.proxibanqueV2.utils;

public class CompareChaine {

	public static boolean chaineEgale(String chaine1, String chaine2) {

		boolean verif = false;
		String mdpDansLaBas1e= CrypterChaine.crypter(chaine1);
		String mdpDansLaBase2= CrypterChaine.crypter(chaine2);
		if (mdpDansLaBas1e.equals(mdpDansLaBase2)) {
			verif = true;
		}
		System.out.println(verif);
		return verif;
	}
}
