package cryptographie;
public class GenerateurCle {
	static int[] te = new int[64];
	static int[] pc_1 = new int[56];
	static int[] temp = new int[56];
	static int[] msgcry= new int[64];
	static int[] msgclair= new int[64];

	static int[] initp = new int[64];
	static int[][] RH = new int[17][32];
	static int[][] LH = new int[17][32];
	static int[] exp = new int[48];
	static int[] xor1 = new int[48];
	static int[] xor2 = new int[32];
	static int[] X = new int[8];
	static int[] Y = new int[8];
	static int[] binaire = new int[8];
	static int[] ke =new int[32];
	static int[] kee =new int[32];
	static int[] fct = new int[32];
	//genere 16 key est stocke dans uns tableaux de deux dim K[17][i]
	public static void key(int[] key){
	
		for(int i = 0;i<56;i++)
			pc_1[i]=key[(Permutation.PC1[i]-1)];

		for(int i = 0;i<28;i++){
			mains.C[0][i]=pc_1[i];
			mains.D[0][i]=pc_1[i+28];
		}
		
		for(int i = 1;i<17;i++){
		LS(i);
			for(int j = 0;j<28;j++){
				temp[j]=mains.C[i][j];
				temp[j+28]=mains.D[i][j];
			}
	
	
			for(int k = 0;k<48;k++)
				mains.K[i][k]=temp[Permutation.PC2[k]];
		}

		
		
	}
	public static void dkey(int[] key){
		
		for(int i = 0;i<56;i++)
			pc_1[i]=key[(Permutation.PC1[i]-1)];
	
		for(int i = 0;i<28;i++){
			mains.C[0][i]=pc_1[i];
			mains.D[0][i]=pc_1[i+28];
		}
		
		for(int i = 1,x=16;i<17;i++,x--){
		LSD(i);
			for(int j = 0;j<28;j++){
				temp[j]=mains.C[i][j];
				temp[j+28]=mains.D[i][j];
			}
	
	
			for(int k = 0;k<48;k++)
				mains.DK[x][k]=temp[Permutation.PC2[k]];
		
		
		}
		
	}
	//chercher dans les Sboxs x y deux paramettre defin
	static int[] crypteBlock(int[] bloc){

		for(int i=0;i<64;i++)
			initp[i]=bloc[(Permutation.IP[i])-1];

		
		for(int i=0;i<32;i++){
			LH[0][i]=initp[i];
			RH[0][i]=initp[i+32];
		}

		for(int K=1;K<17;K++){
			for(int i=0;i<48;i++){
				exp[i]=RH[K-1][(Permutation.E[i])-1]	;
			}


			int X=0,Y=0;
			XOR(exp,mains.K[K],48);
		
			int j=0;
			for(int i=0;i<48;i++){
				if(i%6==0){	
					X=2*xor1[i]+xor1[i+5];
					Y=xor1[i+4]+2*xor1[i+3]+4*xor1[i+2]+8*xor1[i+1];
					if(X==0){
						binaire[j]=Permutation.S[j][Y];
						j++;
					}
					if(X==1){
						binaire[j]=Permutation.S[j][16+Y];
						j++;}
					if(X==2){
						binaire[j]=Permutation.S[j][32+Y];
						j++;}
					if(X==3){
						binaire[j]=Permutation.S[j][48+Y];
						j++;}
				}			
			}
			int j1=0;
			for(int i=0;i<32;i++){
				if(i%4==0){
					
					if(binaire[j1]>7){
						ke[i+3]=binaire[j1]%2;	binaire[j1]=binaire[j1]/2;
						ke[i+2]=binaire[j1]%2;	binaire[j1]=binaire[j1]/2;
						ke[i+1]=binaire[j1]%2;	binaire[j1]=binaire[j1]/2;
						ke[i]=binaire[j1]%2;j1++;
					}
					else if(binaire[j1]>3 && binaire[j1]<8){
						ke[i]=0;
						ke[i+3]=binaire[j1]%2;binaire[j1]=binaire[j1]/2;
						ke[i+2]=binaire[j1]%2;binaire[j1]=binaire[j1]/2;
						ke[i+1]=binaire[j1]%2;j1++;						
					}
					else if(binaire[j1]>1 && binaire[j1]<4){
						ke[i]=0;
						ke[i+1]=0;
						ke[i+3]=binaire[j1]%2;binaire[j1]=binaire[j1]/2;
						ke[i+2]=binaire[j1]%2;j1++;
					}
					else if(binaire[j1]<2){
						ke[i]=0;
						ke[i+1]=0;
						ke[i+2]=0;
						ke[i+3]=binaire[j1]%2;
						j1++;}
				}
			}

			for(int i=0;i<32;i++){
				fct[i]=ke[(Permutation.P[i])-1];	
			}
		
			
			XOR(fct,LH[K-1],32);
			for(int i=0;i<32;i++){
				RH[K][i]=xor2[i];
			}
		
			
			for(int i=0;i<32;i++){
				LH[K][i]=RH[K-1][i];
			}

			}
		
		for(int i=0;i<32;i++){
			te[i+32]=LH[16][i];
			te[i]=RH[16][i];
		}

		for(int i=0;i<64;i++){
			msgcry[i]=te[(Permutation.FP[i]-1)];
		}

		return msgcry;

		
	}
	static int[] decrypteBlock(int[]pt){
		
		for(int i=0;i<64;i++)
			initp[i]=pt[(Permutation.IP[i])-1];
		
		for(int i=0;i<32;i++){
			LH[0][i]=initp[i];
			RH[0][i]=initp[i+32];
		}
		for(int K=1;K<17;K++){
			for(int i=0;i<48;i++){
				exp[i]=RH[K-1][(Permutation.E[i])-1]	;
			}
			int X=0,Y=0;
			XOR(exp,mains.DK[K],48);
		
			int j=0;
			for(int i=0;i<48;i++){
				if(i%6==0){	
					X=2*xor1[i]+xor1[i+5];
					Y=xor1[i+4]+2*xor1[i+3]+4*xor1[i+2]+8*xor1[i+1];
					if(X==0){
						binaire[j]=Permutation.S[j][Y];
						j++;
					}
					if(X==1){
						binaire[j]=Permutation.S[j][16+Y];
						j++;}
					if(X==2){
						binaire[j]=Permutation.S[j][32+Y];
						j++;}
					if(X==3){
						binaire[j]=Permutation.S[j][48+Y];
						j++;}
				}			
			}
			int j1=0;
			for(int i=0;i<32;i++){
				if(i%4==0){
					
					if(binaire[j1]>7){
						ke[i+3]=binaire[j1]%2;	binaire[j1]=binaire[j1]/2;
						ke[i+2]=binaire[j1]%2;	binaire[j1]=binaire[j1]/2;
						ke[i+1]=binaire[j1]%2;	binaire[j1]=binaire[j1]/2;
						ke[i]=binaire[j1]%2;j1++;
					}
					else if(binaire[j1]>3 && binaire[j1]<8){
						ke[i]=0;
						ke[i+3]=binaire[j1]%2;binaire[j1]=binaire[j1]/2;
						ke[i+2]=binaire[j1]%2;binaire[j1]=binaire[j1]/2;
						ke[i+1]=binaire[j1]%2;j1++;						
					}
					else if(binaire[j1]>1 && binaire[j1]<4){
						ke[i]=0;
						ke[i+1]=0;
						ke[i+3]=binaire[j1]%2;binaire[j1]=binaire[j1]/2;
						ke[i+2]=binaire[j1]%2;j1++;
					}
					else if(binaire[j1]<2){
						ke[i]=0;
						ke[i+1]=0;
						ke[i+2]=0;
						ke[i+3]=binaire[j1]%2;
						j1++;}
				}
			}
			/*for(int i=0;i<32;i++){
				System.out.print(ke[i]);
			}System.out.println();*/
			for(int i=0;i<32;i++){
				fct[i]=ke[(Permutation.P[i])-1];	
			}
			
			XOR(fct,LH[K-1],32);
			
			for(int i=0;i<32;i++){
				RH[K][i]=xor2[i];
			}
			
			for(int i=0;i<32;i++){
				LH[K][i]=RH[K-1][i];
			}
	
			}
		
		for(int i=0;i<32;i++){
			te[i+32]=LH[16][i];
			te[i]=RH[16][i];
		}
		for(int i=0;i<64;i++){
			msgclair[i]=te[(Permutation.FP[i]-1)];
		}
		return msgclair;
	}
	static void LS(int k){
    	
        // rotate the 28-bit values
        if (Permutation.rotations[k-1] == 1) {
        	// rotate by 1 bits

        	for(int i=0;i<27;i++){
        		mains.C[k][i]=mains.C[k-1][i+1];
        		mains.D[k][i]=mains.D[k-1][i+1];
    		}
        	mains.C[k][27]=mains.C[k-1][0];
    		mains.D[k][27]=mains.D[k-1][0];
        } else {
        	// rotate by 2 bits
        	for(int i=0;i<26;i++){
        		mains.C[k][i]=mains.C[k-1][i+2];
        		mains.D[k][i]=mains.D[k-1][i+2];
    		}
        	mains.C[k][26]=mains.C[k-1][0];
        	mains.C[k][27]=mains.C[k-1][1];
    		mains.D[k][26]=mains.D[k-1][0];
    		mains.D[k][27]=mains.D[k-1][1];
        }	   
	}
	static void LSD(int k){
    	
        // rotate the 28-bit values
		 if (Permutation.rotations[k-1] == 0) {
			 for(int i=0;i<28;i++){
	        		mains.C[k][i]=mains.C[k-1][i];
	        		mains.D[k][i]=mains.D[k-1][i];
	    		}
		 }
        if (Permutation.rotations[k-1] == 1) {
        	// rotate by 1 bits

        	for(int i=0;i<27;i++){
        		mains.C[k][i]=mains.C[k-1][i+1];
        		mains.D[k][i]=mains.D[k-1][i+1];
    		}
        	mains.C[k][27]=mains.C[k-1][0];
    		mains.D[k][27]=mains.D[k-1][0];
        } else {
        	// rotate by 2 bits
        	for(int i=0;i<26;i++){
        		mains.C[k][i]=mains.C[k-1][i+2];
        		mains.D[k][i]=mains.D[k-1][i+2];
    		}
        	mains.C[k][26]=mains.C[k-1][0];
        	mains.C[k][27]=mains.C[k-1][1];
    		mains.D[k][26]=mains.D[k-1][0];
    		mains.D[k][27]=mains.D[k-1][1];
        }	   
	}
	static void XOR(int[]x,int[]y,int taille){
		for(int i=0;i<taille;i++){
			if(x[i]==y[i]){
				if(taille==48)
					xor1[i]=0;
				else
					xor2[i]=0;
			}else{
				if(taille==48)
					xor1[i]=1;
				else
					xor2[i]=1;
			}				
		}		
	}

	public static String convertbin(String data){
		int length = data.length();
		int bloc[][]=new int[length/8+1][64];
		int bloccryp[][]=new int[length/8+1][64];
		int keybin[]=new int[64];
		String car="",y="";
		String d="";
		int dif=0;
		for(int i=0;i<data.length();i++){
			int x=data.charAt(i);
			car=Integer.toBinaryString(x);
			while(car.length()%8!=0){
				car=0+car;}
			y=y+car;
		}
		if(y.length()%64!=0){
			int div;
			div=y.length()/64+1;
			dif=div*64-y.length();
		}
		return y;
		}
	public static int[] gettabbin(String data){
		// on ajout des zero au premier de le bloc si la modulo du langeur !=0 de le text(padding) 
		int []temp=new int[data.length()];
		for(int i=0;i<data.length();i++){
			temp[i]=data.charAt(i)-48;
			
			}

		return temp;
		
		}
	public static String hexToBin(String hex){
	    String bin = "";
	    String binFragment = "";
	    int iHex;
	    hex = hex.trim();
	    hex = hex.replaceFirst("0x", "");

	    for(int i = 0; i < hex.length(); i++){
	        iHex = Integer.parseInt(""+hex.charAt(i),16);
	        binFragment = Integer.toBinaryString(iHex);

	        while(binFragment.length() < 4){
	            binFragment = "0" + binFragment;
	        }
	        bin += binFragment;
	    }
	    return bin;
	}
}
