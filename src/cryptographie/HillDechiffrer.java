package cryptographie;

import java.util.ArrayList;



public class HillDechiffrer {
	static ArrayList<String> phrases= new ArrayList<String>();
	static int []tab = new int [100];
	static int [][] tcomatrice = new int [2][2];
	static int [] res = new int[100];
	static int a,b,c,d,d1;
	static String phrase;
	static String s="";
	static String[] stock=new String[10];
	static int n;
	

static void calcule(String phrase,int a,int b,int c, int d1){
		
		for (String retval: phrase.split(" ")){
	         phrases.add(retval);
	                                          }
		
		n=phrases.size();
	
		for(int i=0;i<n;i++){
		String mot=phrases.get(i);
		int taille=mot.length();
		     
	   for(int i1=0;i1<mot.length();i1++)
	   tab[i1]=(int)(mot.charAt(i1)-97);
			
       d=d1/10;
       
      int resultats=(a*d-b*c);
      int rest;
      for(rest=1;rest<100;rest++){
      if((rest*resultats)%26==1)
               break;
                          }
       
      // System.out.println(resultats);
       tcomatrice[0][0]=(d*rest)%26;  
      // System.out.println(tcomatrice[0][0]);
       
       tcomatrice[0][1]=(-b*rest)%26; 
       while(tcomatrice[0][1]<0)
    	   tcomatrice[0][1]=tcomatrice[0][1]+26;
       
     // System.out.println(tcomatrice[0][1]);
       
       tcomatrice[1][0]=(-c*rest)%26;
       
       while(tcomatrice[1][0]<0)
    	   tcomatrice[1][0]=tcomatrice[1][0]+26;
       
     // System.out.println(tcomatrice[1][0]);
      
       tcomatrice[1][1]=(a*rest)%26;
       
       for(int i1=0;i1<taille;i1=i1+2){

			res[i1]=(tcomatrice[0][0]*tab[i1]+tcomatrice[0][1]*tab[i1+1])%26;
			res[1+i1]=(tcomatrice[1][0]*tab[i1]+tcomatrice[1][1]*tab[i1+1])%26;
		}
       
       if(d1%10==1) 
       	taille--;

       for(int i1=0;i1<taille;i1++)
			s=s+((char)(res[i1]+97));
		   
		}
		   
		}
	/*public static void main( String[]args){
		
		System.out.println("Entrez le mot a decrypter");
		lecture = new Scanner(System.in);
		phrase=lecture.nextLine(); 
		
		System.out.println("Entrer a");
		a=lecture.nextInt();
		System.out.println("Entrer b");
		b=lecture.nextInt();
		System.out.println("Entrer c");
		c=lecture.nextInt();
		
		calcule(phrase,a,b,c,d);
		for(int i=0;i<n;i++)
		System.out.println(stock[i]);
		

}*/
}
