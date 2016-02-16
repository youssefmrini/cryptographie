package cryptographie;



public class Cesardechiffrer {
	
	static int  cle;
	static String phrase =null;
	static char[] tab= new char[1000];
	static int [] ta= new int[1000];
	static char [] tac= new char[1000];
	static String s="";
	
	
	//Function
	static void ascii(int taille){
		    for(int i=0;i<taille;i++){
			char lettre =tab[i];
			int ascii = (int) lettre;
			
			if(ascii>96 && ascii<123){
				ta[i]= ((ascii-97-cle)%26);	
				if(ta[i]<0)
					ta[i]=ta[i]+26;
				ta[i]= ta[i]+97;
			                         }
			else
				ta[i]=ascii;	
			                             }
	                     }
	                        
     static void transformer( int taille){
	        for(int i=0;i<taille;i++){
			if(ta[i]>96 && ta[i]<123){
				tac[i]=(char)ta[i];
			    s=s+tac[i];}
			else{
			    tac[i] = (char)ta[i];
			    s=s+tac[i];
			    }
				
			                             }
                               }
 
     
     
     
			
}