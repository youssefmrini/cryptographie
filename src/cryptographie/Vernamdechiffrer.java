package cryptographie;


public class Vernamdechiffrer {
	
	static String a = null;
	static String c= null;
	static String s="";
	static int taillea=0;
	static int taillec=0;
	
	static int[] alphabet= new int[1000];
	static int [] cle= new int[1000];
	static int [] tac= new int[1000];
	static char [] stocke= new char[1000];
	
	
	public static void decrypter(String c,String a){
		for(int i=0;i<c.length();i++){
			alphabet[i]=c.charAt(i);
		//	System.out.println(alphabet[i]);
			taillea++;                    }				
			
				for(int i=0;i<a.length();i++){
					cle[i]=(int)a.charAt(i);
					
					}
			           
			
			
			for(int i=0;i<c.length();i++){
				if(alphabet[i]>96 && alphabet[i]<123){
                 tac[i]=(alphabet[i]-97-(cle[i]-97))%26;
				
				if(tac[i]<0) tac[i]+=26;
				
				 stocke[i]=(char)(tac[i]+97);}
				
				else {
					tac[i]=alphabet[i];
				    stocke[i]=(char)tac[i];
				                    }
			}
				
				
			                               
			for(int i=0;i<c.length();i++)
			s=s+stocke[i];
	}
	
}
	