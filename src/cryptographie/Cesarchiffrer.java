package cryptographie;



public class Cesarchiffrer
{

    static int cle;
    static String phrase ="";
    static char[] tab= new char[1000];
    static int [] ta= new int[1000];
    static char [] tac= new char[1000];

    static String s="";


    static void ascii(int taille)
    {
        for(int i=0; i<taille; i++)
        {

            char lettre =tab[i];
            int ascii = (int) lettre;


            if((ascii>96 && ascii<123)||ascii>64 && ascii<91)
            {
                if(ascii>64 && ascii<91)
                {
                    ascii=ascii+32;
                }

                ta[i]= (ascii-97+cle)%26;
                ta[i]=ta[i]+97;
            }
            else{
              ta[i]= ascii;
            }


            if(ta[i]>96 && ta[i]<123)
            {
                tac[i]= (char)ta[i];
                s=s+tac[i];
            }
            else{
                s=s+(char)ta[i];
                }

        }



    }



}


