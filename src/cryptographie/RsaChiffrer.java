package cryptographie;
import java.math.BigInteger;
public class RsaChiffrer {
	static String s="";
	static int messageCode[] = new int[1000];
	static int messageEnAscii[] = new int[1000];
	static String message;
	static int length;
	static int x,y,a,h,d;
	static BigInteger nbPremier01;
	static BigInteger nbPremier02;
	static BigInteger f;
	static  BigInteger produit;
	public static boolean estpremier(int k){
		for (int i=2;i<=(k/2);i++){
			if(k%i==0)
				return false;
			
					}return true;
	 							}
	public static void keys(int x,int y){
		nbPremier01 = BigInteger.valueOf(x);
		 nbPremier02 = BigInteger.valueOf(y);
		produit = nbPremier01.multiply(nbPremier02);
		 f = nbPremier01.subtract(BigInteger.ONE).multiply(nbPremier02.subtract(BigInteger.ONE));
		 
	}
	
	public static int  encryption(String message,int a){

		
		
		BigInteger e = BigInteger.valueOf(a);
        BigInteger d = e.modInverse(f);
		
		length = message.length();
		
		
		
		for(int i=0;i<message.length();i++)
			messageEnAscii[i]=message.charAt(i);
		

		
		char charMessage[] = message.toCharArray();
		for (int i = 0; i < length; i++) {
		   messageEnAscii[i] = (int) charMessage[i];
		}
 
		
		for (int i = 0; i < length; i++) {
		   BigInteger nb = BigInteger.valueOf(messageEnAscii[i]);

		   messageCode[i] = nb.modPow(e,produit).intValue();
		}
		
		for(int i=0;i<message.length();i++)
			s=s+messageCode[i]+" ";
	
		
		System.out.println(" ");
		h=d.intValue();
		return h;
		
	}

}
