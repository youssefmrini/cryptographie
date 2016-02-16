package cryptographie;




public class mains {
	static int[][] C = new int[17][28];
	static int[][] D = new int[17][28];
	static int[][] K = new int[17][48];	
	static int[][] DK = new int[17][48];
	static int[]plaintext= new int[64];
	//static int[] msgcry =new int[1000];
//	static int[] msgclair =new int[64];

	
public static void main(String[] arg){
	
	String key="0x133457799BBCDFF1";
	String pt="abcdefghoijklmnopqrstuvwxyz^$*�!:; 01234656789.+-*/&�'(-�_��)=";
	
	System.out.println("****************************msg crypter*************************************");
	String msgcry=DESa.crypte(pt,key);
		System.out.println(msgcry);
	System.out.println("****************************msg clair***************************************");
	StringBuffer msgclair=DESa.decrypte(msgcry,key);
	System.out.println(msgclair);

	

}
}

