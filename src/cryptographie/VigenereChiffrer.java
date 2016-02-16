package cryptographie;

import java.util.Scanner;
public class VigenereChiffrer {
   Scanner sc = new Scanner(System.in);
 //  Scanner le = new Scanner(System.in);


static int k=0;
static int pos=0;
static char [][] matrice = new char[26][26];
static char[] msg= new char[1000];
static char [] tkey= new char[1000];
static char[] stock= new char[1000];
static String key="null";
static String message="null" ;
public static String nkey;
static String s="";


public VigenereChiffrer(){
		
	for (int i=0;i<26;i++){
		k=(k-pos);
		for (int j=0;j<26;j++){
			k=k%26;
			if(k<0)
				k=k+26;
			matrice[i][j]=((char)(k+97));
			k++;		
		}
		pos++;
		k=0;
	}	


}


public static void lecture(String message,String key){
	   
	   
		new VigenereChiffrer();
	
		
		int keyl=key.length();
		int msgl=message.length();
		int nbr = 0;
		
		if(keyl<msgl){
			
			nbr=((msgl/keyl)+1);
		}
		
		nkey = key;
		
		for(int i=1;i<nbr ;i++){
			if(nkey.length()!=msgl)
			nkey= nkey.concat(key);
		}
		
//	int keyl=key.length();
//	int msgl=message.length();

	
	/*for (int i=0;i<26;i++){
		for (int j=0;j<26;j++){
			System.out.print(matrice[i][j]+"\t");
		}
		System.out.println("");	
		}*/
	//System.out.println(nkey);
	//System.out.println(message);

	for(int i=0;i<message.length();i++){
	msg[i]=message.charAt(i);
	tkey[i]=nkey.charAt(i);
	}


	/*for(int i=0;i<message.length();i++){
		System.out.print(msg[i]+" ");
		System.out.print(tkey[i]+" ");
		System.out.println("");
		}*/
	
	for(int i=0;i<message.length();i++){
		int a,b;
		//String x =msg[i].toLowerCase();
		
		if((msg[i]>96 && msg[i]<123)||(msg[i]>64 && msg[i]<91)){
			if(msg[i]>64 && msg[i]<91){
				int x = (int)msg[i];
				x=x+32;
				msg[i]=(char)x;
			}
		a=((int)msg[i])-97;
		b=((int)tkey[i])-97;
		stock[i]=matrice[a][b];
		}
		else
			stock[i]=msg[i];
	}
	for(int i=0;i<message.length();i++){
		s=s+stock[i];
	}

}
	
}