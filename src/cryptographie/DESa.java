package cryptographie;



public class DESa {
	public static String crypte(String text, String key){
		String textbin=GenerateurCle.convertbin(text);
		while(textbin.length()%64!=0){
			textbin=textbin+0;
		}
		int length=textbin.length();
		//int[]binair=new int[length];
		int[] binair=GenerateurCle.gettabbin(textbin);

		int[][]bloc=new int[length/64][64];
		
		for(int i=0;i<length/64;i++){
			for(int j=0;j<64;j++)
				bloc[i][j]=binair[i*64+j];			
		}
		
		int[][]bloccry=new int[length/64][64];
		int ke[]=new int[64];
		key=GenerateurCle.hexToBin(key);
		ke=GenerateurCle.gettabbin(key);
		GenerateurCle.key(ke);

		for(int i=0;i<length/64;i++){
				int[] temp1=new int[64];
				temp1=GenerateurCle.crypteBlock(bloc[i]);
				for (int j = 0; j <64; j++) {
					bloccry[i][j]=temp1[j];
				}	
		}

		int temp[]=new int[length];
		
		for(int i=0;i<length/64;i++){
			for(int j=0;j<64;j++){
				temp[i*64+j]=bloccry[i][j];	
			}
		}
		String output="";
		for(int i=0;i<length;i++){
			output=output+""+temp[i];
		}
		
		return output ;
	}
	/////////////////////////////////////////////
	public static StringBuffer decrypte (String text, String key){
			int length=text.length();

			int[] binair=GenerateurCle.gettabbin(text);

			int[][]bloc=new int[length/64][64];
		
		for(int i=0;i<length/64;i++){
			for(int j=0;j<64;j++)
				bloc[i][j]=binair[i*64+j];			
		}

			int[][]bloccry=new int[length/64][64];
			int ke[]=new int[64];
			key=GenerateurCle.hexToBin(key);
			ke=GenerateurCle.gettabbin(key);
			GenerateurCle.dkey(ke);
		for(int i=0;i<length/64;i++){
					int[] temp1=new int[64];
					temp1=GenerateurCle.decrypteBlock(bloc[i]);

					for (int j = 0; j <64; j++) {
						bloccry[i][j]=temp1[j];
					}
		}
	
			int temp[]=new int[length];		
		for(int i=0;i<length/64;i++){
			for(int j=0;j<64;j++){
				temp[i*64+j]=bloccry[i][j];	
			}
		}
			int count=0;
		for(int i=length-1;i>=0;i--){
			if(i%8==0){
				if(temp[i]==0 && temp[i+1]==0 && temp[i+2]==0 && temp[i+3]==0 && temp[i+4]==0 && temp[i+5]==0 && temp[i+6]==0 && temp[i+7]==0){
					count=count+8;
				}
			}
		}
			int fin[]=new int[length-count];
		for (int i = 0; i < fin.length; i++) {
			fin[i]=temp[i];
		}
			StringBuffer textclair=new StringBuffer();
		for (int i = 0; i < fin.length; i++) {
			String nbr="";
			int number;
			char caracter = 0 ;
			if(i%8==0){
					nbr=fin[i]+""+fin[i+1]+""+fin[i+2]+""+fin[i+3]+""+fin[i+4]+""+fin[i+5]+""+fin[i+6]+""+fin[i+7];	
					number = Integer.parseInt(nbr, 2);
					caracter=(char) number;
					textclair = textclair.append(caracter);

				}
			
			}
		return textclair;
		}

	

		


}
