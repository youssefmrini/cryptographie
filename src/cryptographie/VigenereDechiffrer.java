package cryptographie;


public class VigenereDechiffrer {


	static int k=0;
	static int pos=0;
	static char [][] matrice = new char[26][26];
	//char[] msg= new char[100];
	//int [] tkey= new int[100];
	 public static String nkey;
     static char[] msgc= new char[1000];
	 static char [] tkey= new char[1000];
	 static String key="null";
	 static String cry="null" ;
	 static String s="";

	public VigenereDechiffrer(){
			
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


		   
			
			
			
			public static void decrypter(String cry, String key){
			new VigenereDechiffrer();
			int keyl=key.length();
			int msgl=cry.length();
			int nbr = 0;
			//System.out.println(keyl);
			//System.out.println(msgl);
			if(keyl<msgl){
				
				nbr=((msgl/keyl)+1);
			}
			//System.out.println(nbr);
			nkey = key;
			
			for(int i=1;i<nbr ;i++){
				if(nkey.length()!=msgl)
				nkey= nkey.concat(key);
			}
			//System.out.println(nkey);
		/*_______________________________________________________________________________
		for (int i=0;i<26;i++){
			for (int j=0;j<26;j++){
				System.out.print(matrice[i][j]+"\t");
			}
			System.out.println("");	
			}
		//System.out.println(nkey);*/
		 
		


		for(int i=0;i<msgl;i++){
		msgc[i]=cry.charAt(i); //char
		tkey[i]=nkey.charAt(i); //car

		}
		for(int i=0;i<msgl;i++){
			int a;
			char c;
			a=(int)tkey[i];
			a=a-97;
			c=msgc[i];
			if(msgc[i]>96 && msgc[i]<123){
			
			for(int j=0;j<26;j++){
				if(matrice[j][a]==(c)){
				s=s+matrice[0][j];
				}
				}
			}
			else
				s=s+msgc[i];
			
		}



	}
		


}