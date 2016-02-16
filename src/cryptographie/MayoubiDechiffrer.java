package cryptographie;



public class MayoubiDechiffrer {

	static char[] tableau = new char[26];
	static char[] leet = new char[1000];
	static int[] cara = new int[1000];
	static int[] stock = new int[1000];
	static int clef;
	static String mot;
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

	static void recuperer(String mot, int clef) {
		int taille = mot.length();
		for (int i = 0; i < taille; i++) {

			cara[i] = (int) mot.charAt(i);
			if (cara[i]==32){
				continue;
               }
			//if(cara[i]<96 ||cara[i]>123)
				//continue;
			else{
			    cara[i] = cara[i] - clef;
			   leet[i] = (char) cara[i];
				
			}
				
		}
		
		//for (int i = 0; i < taille; i++)
			//System.out.print(leet[i]);

	}

	static void convertir(int taille) {
		int incr = 0;
		for (int i = 0; i < taille; i++) {
			if (leet[i] == 0) {
				stock[incr] = cara[i];
				incr++;
			}
			;
			for (int j = 0; j < 26; j++) {

				String x = Integer.toString(tableau[j]);
				String y = Integer.toString(leet[i]);

				if (x.equals(y)) {
					stock[incr] = j + 97;
					incr++;
				}
			}
		}
		System.out.println(" ");
		for (int i1 = 0; i1 < taille; i1++)
			s=s+(char) stock[i1];

	
	}
}
