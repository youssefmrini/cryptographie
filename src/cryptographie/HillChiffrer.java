package cryptographie;

import java.util.ArrayList;
import java.util.Random;


public class HillChiffrer {
	static ArrayList<String> phrases= new ArrayList<String>();
	static int []tab = new int [100];
	static int [][] matrice = new int [2][2];
	static int [] res = new int[100];
	static int a,b,c,d;
	static String phrase;
	static String s="";
	static String[] stock=new String[10];
	static int n,taille;
	
	
	static void test(int taille){
		System.out.println("d="+d+""+taille%2);
		System.out.println(" ");
	}
    static void afficher(){
    	Random rand = new Random();
		b=(int) rand.nextInt(90)+1;
		c=(int) rand.nextInt(90)+1;
		d=(int) rand.nextInt(90)+1;
		a=(int)rand.nextInt(90)+1;
		int resultats=(a*d-b*c)	;	
		while(pgcd(resultats,26)!=1){
		a=(int) rand.nextInt(90)+1;
		b =(int) rand.nextInt(90)+1;
		c =(int) rand.nextInt(90)+1;
		d=(int) rand.nextInt(90)+1;
		resultats=(a*d-b*c)	;
		                            }
		
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("c="+c);
        
		
		
		matrice[0][0]=a;
		matrice[0][1]=b;
		matrice[1][0]=c;
		matrice[1][1]=d;
	
    }
    
	static int pgcd(int a, int b)
	{
	  int r;
	  while (b != 0)
	    {
	      r = a%b;
	      a = b;
	      b = r;
	    }
	  return a;
	}
	
	public static void calcule( String phrase){
		for (String retval: phrase.split(" ")){
	         phrases.add(retval);
	      }
		//System.out.println("premiere : "+phrases.get(0));
		//System.out.println("deuxieme : "+phrases.get(1));
		n=phrases.size();
		//System.out.println(n);
		
		for(int i=0;i<n;i++){
			 String mot=phrases.get(i);
		     int taille=mot.length();
		    
		for(int i1=0;i1<mot.length();i1++){
			tab[i1]=(int)(mot.charAt(i1)-97);
			//System.out.println(tab[i1]);
		}
		

		
		int tailles= taille;
		d=Integer.parseInt(d+""+taille%2);
		if(taille%2!=0) {taille++; tab[taille-1]=97;}
		
		
		// for(int i=0;i<mot.length();i++)
		//  System.out.print(tab[i]+" ");
		// G�n�rer la matrice 
		
		test(tailles);
		for(int i1=0;i1<taille;i1=i1+2){

			res[i1]=(matrice[0][0]*tab[i1]+matrice[0][1]*tab[i1+1])%26;
			res[1+i1]=(matrice[1][0]*tab[i1]+matrice[1][1]*tab[i1+1])%26;


		}
		
		for(int i1=0;i1<taille;i1++)
			s=s+((char)(res[i1]+97));
		}
		
	}

	
		
          
	}
		
