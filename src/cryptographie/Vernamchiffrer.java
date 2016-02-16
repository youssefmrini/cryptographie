package cryptographie;

import java.util.Random;

public class Vernamchiffrer {

	
	static String a = null;
	static String phrase= null;
	
	static int[] alphabet= new int[1000];
	static int [] cle= new int[1000];
	static int [] tac= new int[1000];
	static char [] stocke= new char[1000];
	static String s="";
	static String key="";
	
	
	public static void crypter(String phrase){
		for(int i=0;i<phrase.length();i++){
			alphabet[i]=phrase.charAt(i);
		//System.out.println(alphabet[i]);
			                                  }		
			
			//Générer  la clé
			
				for(int i=0;i<phrase.length();i++){
					Random rand = new Random();
					int nombreAleatoire =(int) rand.nextInt(26)+0;
					//System.out.println(nombreAleatoire);
					cle[i]=nombreAleatoire+97;
					key=key+(char)cle[i];
					                               }
				System.out.println(key);
				
			              
			          System.out.println("  ");
			          
			for(int i=0;i<phrase.length();i++){
				if(alphabet[i]>96 && alphabet[i]<123)
				
					tac[i]=(alphabet[i]-97+cle[i]-97)%26;
				else 
					 tac[i]=alphabet[i];
			}                       
			
			
			for(int i=0;i<phrase.length();i++){
				if(alphabet[i]>96 && alphabet[i]<123)
					stocke[i]=(char)(tac[i]+97);
				else 
				   stocke[i]=(char) tac[i];
			}
			
			for(int i=0;i<phrase.length();i++)
				s=s+stocke[i];

			
			//System.out.println(s);
	
	}
		
}