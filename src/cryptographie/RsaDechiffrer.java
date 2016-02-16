package cryptographie;

import java.math.BigInteger;


public class RsaDechiffrer {
       public 	static String [] tab = new String [120];
       public static String message;
       public static int [] ta= new int[1000];
       public static String s="";
       static int x,y,a,r;
       static int decodedAscii;
       static BigInteger nbPremier01, nbPremier02,produit,f,e,d;
       static String tab1[];

	   public static void dechiffrer(String message,int x,int y,int a,int r){
		 
		nbPremier01 = BigInteger.valueOf(x);
		nbPremier02 = BigInteger.valueOf(y);
		produit = nbPremier01.multiply(nbPremier02);
	    f = nbPremier01.subtract(BigInteger.ONE).multiply(nbPremier02.subtract(BigInteger.ONE));
		e = BigInteger.valueOf(a);
		d = BigInteger.valueOf(r);
		tab1= message.split(" ");
		
        for(int i=0;i<tab1.length;i++)
         tab[i]=tab1[i];
		
	//for(int i=0;i<tab1.length;i++)
		//System.out.print(tab[i]+" ");
	
	
	for(int i=0;i<tab1.length;i++){
	
		ta[i]=Integer.parseInt(tab[i]);
	}
	
		
		
	for (int i = 0; i <tab1.length; i++) {
		   BigInteger nb = BigInteger.valueOf(ta[i]);
		 decodedAscii = nb.modPow(d,produit).intValue();
		s=s+(char) decodedAscii;
		
	}
	}
	
}
