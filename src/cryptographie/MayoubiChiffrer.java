package cryptographie;

public class MayoubiChiffrer {
	static char[] tableau = new char[26];
	static char[] leet = new char[1000];
	static int[] cara = new int[1000];
	static int   clef;
	static int[] ascii = new int[1000];
	static int   taille;
	static String phrase;
	static String s="";

	static void tableau() {

		tableau[0] = '@';
		tableau[1] = '8';
		tableau[2] = '(';
		tableau[3] = ')';
		tableau[4] = '3';
		tableau[5] = '&';
		tableau[6] = '6';
		tableau[7] = '#';
		tableau[8] = '1';
		tableau[9] = ';';
		tableau[10] = '<';
		tableau[11] = '_';
		tableau[12] = '-';
		tableau[13] = '/';
		tableau[14] = '¤';
		tableau[15] = '9';
		tableau[16] = '0';
		tableau[17] = '2';
		tableau[18] = '5';
		tableau[19] = '+';
		tableau[20] = 'j';
		tableau[21] = '*';
		tableau[22] = ':';
		tableau[23] = '4';
		tableau[24] = '7';
		tableau[25] = '>';

	}

	public static void convertir(String chaine) {
	      taille = chaine.length();
		for (int i = 0; i < taille; i++) {
			cara[i] = (int) chaine.charAt(i);
		}

		for (int i = 0; i < taille; i++) {
			if (cara[i] > 96 && cara[i] < 123) {
				cara[i] = (int) (chaine.charAt(i)) - 97;
				leet[i] = tableau[cara[i]];
				ascii[i] = (int) leet[i];
				ascii[i] = ascii[i] + clef;
			                                   }

			else {
				leet[i] = (char) cara[i];
                ascii[i]=leet[i];
			    }                
			                             }
		for (int i = 0; i < taille; i++) {
			s=s+(char) ascii[i];
		}


	}
}
