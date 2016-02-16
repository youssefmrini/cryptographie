package cryptographie;


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.ComponentOrientation;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;


public class Cesar {

	private JFrame frame;
	private JTextField inputcesar;
	private JTextField outputcesar;
	private JTextField clecesar;
	private JTextField OuputVigenere;
	private JTextField key;
	private JTextField InputVigenere;
	private JTextField OutputVernam;
	private JTextField InputVernam;
	private JTextField txtKey;
	private JPanel Rsa;
	private JTextField OutputRsa;
	private JTextField x;
	private JTextField e;
	private JTextField y;
	private JTextField d;
	private JTextField InputRsa;
	private JTextField f;
	private JPanel Aes;
	private JTextField inputaes;
	private JTextField keyaes;
	private JTextField outputaes;
	private JPanel Mayoubi;
	private JTextField outputmayoubi;
	private JTextField inputmayoubi;
	private JTextField keymayoubi;
	private JTextField inputhill;
	private JTextField a;
	private JTextField b;
	private JTextField d1;
	private JTextField c;
	private JTextField outputhill;
	private JLabel lblNewLabel_1;
	private JLabel lblTaperVotreTexte;
	private JLabel lblEnterUnNombre;
	private JLabel lblClefPublique;
	private JLabel lblNonDiviseurDe;
	private JLabel lblClefSecrte;
	private JLabel lblRsultat;
	private JLabel lblNewLabel_2;
	private JLabel lblClef;
	private JLabel lblRsultat_1;
	private JLabel lblEntreVotreTexte;
	private JLabel lblClef_1;
	private JLabel lblRsultat_2;
	private JLabel lblTaperUnTexte;
	private JLabel lblClef_2;
	private JLabel lblRsultat_3;
	private JLabel lblTaperUnTexte_1;
	private JLabel lblRsultat_4;
	private JLabel lblClefDe;
	private JLabel lblTaperVoteTexte;
	private JLabel lblA;
	private JLabel lblB;
	private JLabel lblC;
	private JLabel lblD;
	private JLabel lblRsultat_5;
	private JPanel DES;
	private JTextField inputdes;
	private JTextField clefdes;
	private JTextField outputdes;

	public boolean isPrimeNumber(int number){
        
        for(int i=2; i<=number/2; i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
	
	private static int gcd(int a, int b) {
	    int t;
	    while(b != 0){
	        t = a;
	        a = b;
	        b = t%b;
	    }
	    return a;
	}
	
	private static boolean relativelyPrime(int a, int b) {
	    return gcd(a,b) == 1;
	}
	
	public static boolean isInteger(String s, int radix) {
	    if(s.isEmpty()) return false;
	    for(int i = 0; i < s.length(); i++) {
	        if(i == 0 && s.charAt(i) == '-') {
	            if(s.length() == 1) return false;
	            else continue;
	        }
	        if(Character.digit(s.charAt(i),radix) < 0) return false;
	    }
	    return true;
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cesar window = new Cesar();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cesar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Color myColore = Color.decode("#CACACA");
		frame = new JFrame();
		frame.getContentPane().setBackground(myColore);
		frame.setFont(new Font("Lucida Calligraphy", Font.BOLD, 13));
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("icone.png"));
		frame.setLocation(400,400);
		frame.setUndecorated(false);
		Color myColor = Color.decode("#252458");
		
		Color myBlue = Color.decode("#CACACA");

		frame.setBounds(600, 100, 599, 399);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(myBlue);
		tabbedPane.setBounds(0, 0, 600, 369);
		frame.getContentPane().add(tabbedPane);
		
		//int red = 153;
		//int green = 204;
		//int blue = 255;
		
		ImageIcon water = new ImageIcon("crypter.png");
		
		ImageIcon watere = new ImageIcon("decrypter.png");
		
		ImageIcon waterex = new ImageIcon("key.png");
		JPanel Vigenere = new JPanel();
		Vigenere.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		
		Vigenere.setBackground(myBlue);
		
		
		
		tabbedPane.addTab(" Vigenere ", null, Vigenere, null);
		tabbedPane.setForegroundAt(0, Color.BLUE);
		Vigenere.setLayout(null);
		
		OuputVigenere = new JTextField();
		OuputVigenere.setFont(new Font("Meiryo", Font.BOLD, 13));
		OuputVigenere.setBounds(34, 250, 535, 68);
		Vigenere.add(OuputVigenere);
		OuputVigenere.setColumns(10);
		
		JButton DecrypterVig = new JButton(watere);
		DecrypterVig.setForeground(myColor);
	
		DecrypterVig.setBorderPainted(true);
		DecrypterVig.setFocusPainted(true);
		DecrypterVig.setContentAreaFilled(true);
		
		//DecrypterVig.setBounds(50, 105, 128, 23);
		DecrypterVig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					if((key.getText().length() == 0) || (InputVigenere.getText().length() == 0)){
						throw new EmptyStringException("Chaine(s) vide(s)");
					}				
					else if (!key.getText().matches("[a-zA-Z]+")){
						   throw new Exception("La clé doit etre un mot");
					}
						VigenereDechiffrer.key=key.getText();
					    VigenereDechiffrer.cry=InputVigenere.getText();
					    VigenereDechiffrer.decrypter(VigenereDechiffrer.cry,VigenereDechiffrer.key);
						OuputVigenere.setText(VigenereDechiffrer.s);
						VigenereDechiffrer.s="";					
				}
				catch(EmptyStringException exception){
					javax.swing.JOptionPane.showMessageDialog(null, exception.getMessage());
				}	
				catch(Exception e){
					javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
				
		});
		DecrypterVig.setBounds(405, 163, 161, 39);
		Vigenere.add(DecrypterVig);
		
		JButton CrypterVig = new JButton(water);
		
		
		CrypterVig.setForeground(myColor);
		CrypterVig.setBorderPainted(true);
		CrypterVig.setFocusPainted(true);
		CrypterVig.setContentAreaFilled(true);
		//CrypterVig.setBounds(50, 105, 128, 23);
		CrypterVig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					if((key.getText().length() == 0) || (InputVigenere.getText().length() == 0)){
						throw new EmptyStringException("Chaine(s) vide(s)");
					}				
					else if (!key.getText().matches("[a-zA-Z]+")){
						   throw new Exception("La clé doit etre un mot");
					}
						VigenereChiffrer.key=key.getText();
					    VigenereChiffrer.message=InputVigenere.getText();
					    VigenereChiffrer.lecture(VigenereChiffrer.message,VigenereChiffrer.key);
						OuputVigenere.setText(VigenereChiffrer.s);
						VigenereChiffrer.s="";					
				}
				catch(EmptyStringException exception){
					javax.swing.JOptionPane.showMessageDialog(null, exception.getMessage());
				}	
				catch(Exception e){
					javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		CrypterVig.setBounds(236, 163, 159, 39);
		Vigenere.add(CrypterVig);
		
		key = new JTextField();
		key.setFont(new Font("Meiryo", Font.BOLD, 13));
		key.setToolTipText("Entrer un mot ");
		key.setBounds(61, 163, 165, 39);
		Vigenere.add(key);
		key.setColumns(10);
		
		InputVigenere = new JTextField();
		InputVigenere.setFont(new Font("Arial", Font.PLAIN, 13));
		InputVigenere.setBounds(34, 53, 535, 68);
		Vigenere.add(InputVigenere);
		InputVigenere.setColumns(10);
		
		lblTaperUnTexte = new JLabel("Taper un texte");
		lblTaperUnTexte.setFont(new Font("Arial", Font.PLAIN, 13));
		lblTaperUnTexte.setBounds(32, 28, 94, 14);
		Vigenere.add(lblTaperUnTexte);
		
		lblClef_2 = new JLabel("Clef");
		lblClef_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblClef_2.setBounds(34, 163, 28, 38);
		Vigenere.add(lblClef_2);
		
		lblRsultat_3 = new JLabel("R\u00E9sultat");
		lblRsultat_3.setFont(new Font("Arial", Font.PLAIN, 13));
		lblRsultat_3.setBounds(32, 225, 79, 14);
		Vigenere.add(lblRsultat_3);
		
		Aes = new JPanel();
		Aes.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		Aes.setBackground(myBlue);
		tabbedPane.addTab(" AES ", null, Aes, null);
		tabbedPane.setForegroundAt(1, Color.BLUE);
		Aes.setLayout(null);
		
		inputaes = new JTextField();
		inputaes.setFont(new Font("Meiryo", Font.BOLD, 13));
		inputaes.setBounds(42, 58, 510, 63);
		Aes.add(inputaes);
		inputaes.setColumns(10);
		
		JButton CrypterAes = new JButton(water);
		CrypterAes.setBorderPainted(true);
		CrypterAes.setFocusPainted(true);
		CrypterAes.setContentAreaFilled(true);
		//CrypterAes.setBounds(68, 101, 89, 63);
		CrypterAes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					if((inputaes.getText().length() == 0) || (keyaes.getText().length() == 0)){
						throw new EmptyStringException("Chaine(s) vide(s)");
					}				
					//else if (!keyaes.getText().matches("-?[0-9a-fA-F]+")){
						//   throw new Exception("La clé doit être en hexadécimal");
					//}
					String s="";
					String textClar= inputaes.getText();
					String K= keyaes.getText();
					byte[] enc = AESChiffrer.encrypt(textClar.getBytes(), K.getBytes());
					for(int i=0;i<enc.length;i++)
						s=s+enc[i]+" ";
					outputaes.setText(s);			
				}
				catch(EmptyStringException exception){
					javax.swing.JOptionPane.showMessageDialog(null, exception.getMessage());
				}	
				catch(Exception e){
					javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		CrypterAes.setBounds(245, 192, 136, 37);
		Aes.add(CrypterAes);
		
		JButton DecrypterAes = new JButton(watere);
		DecrypterAes.setBorderPainted(true);
		DecrypterAes.setFocusPainted(true);
		DecrypterAes.setContentAreaFilled(true);
		//DecrypterAes.setBounds(31, 136, 128, 23);
		DecrypterAes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					if((inputaes.getText().length() == 0) || (keyaes.getText().length() == 0)){
						throw new EmptyStringException("Chaine(s) vide(s)");
					}				
					//else if (!keyaes.getText().matches("-?[0-9a-fA-F]+")){
						//   throw new Exception("La clé doit être en hexadécimal");
					//}
					String textClar= inputaes.getText();
					 String tab1[]= textClar.split(" ");
					byte[] enc=new byte[tab1.length];
					for(int i=0;i<tab1.length;i++)					
					enc[i]=(byte)(Integer.parseInt(tab1[i]));
					String K= keyaes.getText();
				byte[] dec = AESdechiffrer.decrypt(enc, K.getBytes());
					outputaes.setText(new String(dec));
				}
				catch(EmptyStringException exception){
					javax.swing.JOptionPane.showMessageDialog(null, exception.getMessage());
				}	
				catch(Exception e){
					javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
				
				
			}
		});
		DecrypterAes.setBounds(416, 192, 136, 37);
		Aes.add(DecrypterAes);
		
		keyaes = new JTextField();
		keyaes.setFont(new Font("Meiryo", Font.BOLD, 13));
		keyaes.setToolTipText("Entrer une clef de 64 bit");
		keyaes.setBounds(159, 148, 393, 30);
		Aes.add(keyaes);
		keyaes.setColumns(10);
		
		outputaes = new JTextField();
		outputaes.setFont(new Font("Meiryo", Font.BOLD, 13));
		outputaes.setBounds(42, 255, 510, 63);
		Aes.add(outputaes);
		outputaes.setColumns(10);
		
		lblTaperUnTexte_1 = new JLabel("Taper un texte");
		lblTaperUnTexte_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblTaperUnTexte_1.setBounds(42, 36, 94, 14);
		Aes.add(lblTaperUnTexte_1);
		
		lblRsultat_4 = new JLabel("R\u00E9sultat");
		lblRsultat_4.setFont(new Font("Arial", Font.PLAIN, 13));
		lblRsultat_4.setBounds(42, 230, 75, 14);
		Aes.add(lblRsultat_4);
		
		lblClefDe = new JLabel("Clef De 128 Bits");
		lblClefDe.setFont(new Font("Arial", Font.PLAIN, 13));
		lblClefDe.setBounds(42, 147, 94, 30);
		Aes.add(lblClefDe);
		
		Rsa = new JPanel();
		Rsa.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		
		
		Rsa.setBackground(myBlue);
		
		tabbedPane.addTab("RSA", null, Rsa, null);
		tabbedPane.setForegroundAt(2, Color.BLUE);
		Rsa.setLayout(null);
		
		OutputRsa = new JTextField();
		OutputRsa.setFont(new Font("Meiryo", Font.BOLD, 13));
		OutputRsa.setBounds(28, 273, 527, 57);
		Rsa.add(OutputRsa);
		OutputRsa.setColumns(10);
		
		x = new JTextField();
		x.setToolTipText("Entrez un entier premier");
		x.setBounds(28, 153, 71, 20);
		Rsa.add(x);
		x.setColumns(10);
		
		e = new JTextField();
		e.setToolTipText("Entrer un entier premier avec F");
		e.setBounds(484, 153, 71, 20);
		Rsa.add(e);
		e.setColumns(10);
		
		y = new JTextField();
		y.setToolTipText("Entrer un nombre premier");
		y.setBounds(133, 153, 71, 20);
		Rsa.add(y);
		y.setColumns(10);
		
		d = new JTextField();
		d.setToolTipText("Cl\u00E9 secr\u00E8te ");
		d.setBounds(262, 194, 71, 20);
		Rsa.add(d);
		d.setColumns(10);
		
		
		JButton CrypterRsa = new JButton(water);
		CrypterRsa.setBorderPainted(true);
		CrypterRsa.setFocusPainted(true);
		CrypterRsa.setContentAreaFilled(true);
		//	CrypterRsa.setBounds(407, 159, 89, 38);
			CrypterRsa.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					try{	
						if(InputRsa.getText().length() == 0 ){
							throw new EmptyStringException("Input vide");
						}
						else if (!relativelyPrime(Integer.parseInt(e.getText()), Integer.parseInt(f.getText()))){
							throw new Exception("L'entier e doit être premier avec la clef publique");
						}
						RsaChiffrer.a=Integer.parseInt(e.getText());
						RsaChiffrer.message=InputRsa.getText();
						RsaChiffrer.d=RsaChiffrer.encryption(RsaChiffrer.message,RsaChiffrer.a);
						int h=RsaChiffrer.d;
						d.setText(String.valueOf(h));
						OutputRsa.setText(RsaChiffrer.s);
						RsaChiffrer.s="";		
					}
					catch(EmptyStringException exception){
						javax.swing.JOptionPane.showMessageDialog(null, exception.getMessage());
					}	
					catch(Exception e){
						javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}
			});
			CrypterRsa.setBounds(207, 226, 145, 36);
			Rsa.add(CrypterRsa);
			
			JButton DecrypterRsa = new JButton(watere);
			DecrypterRsa.setBorderPainted(true);
			DecrypterRsa.setFocusPainted(true);
			DecrypterRsa.setContentAreaFilled(true);
			//	DecrypterRsa.setBounds(512, 90, 89, 37);
				DecrypterRsa.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					
						try{	
							if(InputRsa.getText().length() == 0 ){
								throw new EmptyStringException("Input vide");
							}
							else if (!relativelyPrime(Integer.parseInt(e.getText()), Integer.parseInt(f.getText()))){
								throw new Exception("L'entier e doit être premier avec F");
							}
							RsaDechiffrer.x=Integer.parseInt(x.getText());
							RsaDechiffrer.y=Integer.parseInt(y.getText());
							RsaDechiffrer.a=Integer.parseInt(e.getText());
							RsaDechiffrer.r=Integer.parseInt(d.getText());
							RsaDechiffrer.message=InputRsa.getText();
							RsaDechiffrer.dechiffrer(RsaDechiffrer.message,RsaDechiffrer.x,RsaDechiffrer.y,RsaDechiffrer.a,RsaDechiffrer.r);
							OutputRsa.setText(RsaDechiffrer.s);
							RsaDechiffrer.s="";
						}
						catch(EmptyStringException exception){
							javax.swing.JOptionPane.showMessageDialog(null, exception.getMessage());
						}	
						catch(Exception e){
							javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
						}
					}
					
				});
				DecrypterRsa.setBounds(390, 225, 145, 36);
				Rsa.add(DecrypterRsa);
				
				InputRsa = new JTextField();
				InputRsa.setFont(new Font("Meiryo", Font.BOLD, 13));
				InputRsa.setBounds(28, 60, 527, 57);
				Rsa.add(InputRsa);
				InputRsa.setColumns(10);
				
				f = new JTextField();
				f.setToolTipText("Clef Publique");
				f.setBounds(393, 153, 71, 20);
				Rsa.add(f);
				f.setColumns(10);
				JButton Genererclef = new JButton(waterex);
				Genererclef.setBorderPainted(true);
				Genererclef.setFocusPainted(true);
				Genererclef.setContentAreaFilled(true);
				//Genererclef.setBounds(50, 105, 128, 23);
				Genererclef.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {						
						try{
							if(x.getText().length() == 0 || y.getText().length() == 0){
								throw new EmptyStringException("Champs de clé vide(s)");
							}
							if ((!isInteger(x.getText(), 10)) || (!isInteger(y.getText(), 10))){
								throw new Exception("Caractères non valides pour les nombres premiers");
							}
							if((!isPrimeNumber(Integer.parseInt(x.getText())) || (!isPrimeNumber(Integer.parseInt(y.getText()))))){
								throw new PrimeNumberException("L'un des nombres entrés n'est pas premier");								
							}
							RsaChiffrer.x=Integer.parseInt(x.getText());//x doit etre premier
							RsaChiffrer.y=Integer.parseInt(y.getText());//y doit etre premier
							RsaChiffrer.keys(RsaChiffrer.x,RsaChiffrer.y);
							f.setText(String.valueOf(RsaChiffrer.f.intValue()));
						}
						catch(PrimeNumberException exception){
							javax.swing.JOptionPane.showMessageDialog(null, exception.getMessage());
						}
						catch(Exception e){
							javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
						}
					}
				});
				Genererclef.setBounds(225, 137, 145, 36);
				Rsa.add(Genererclef);

				lblTaperVotreTexte = new JLabel("Taper votre texte");
				lblTaperVotreTexte.setFont(new Font("Arial", Font.PLAIN, 13));
				lblTaperVotreTexte.setBounds(30, 38, 104, 20);
				Rsa.add(lblTaperVotreTexte);
				
				lblEnterUnNombre = new JLabel("Enter des nombres premiers ");
				lblEnterUnNombre.setFont(new Font("Arial", Font.PLAIN, 13));
				lblEnterUnNombre.setBounds(28, 128, 168, 14);
				Rsa.add(lblEnterUnNombre);
				
				lblClefPublique = new JLabel("Clef publique");
				lblClefPublique.setFont(new Font("Arial", Font.PLAIN, 13));
				lblClefPublique.setBounds(393, 128, 80, 14);
				Rsa.add(lblClefPublique);
				
				lblNonDiviseurDe = new JLabel("non diviseur de la clef publique ");
				lblNonDiviseurDe.setBounds(237, 141, 28, -17);
				Rsa.add(lblNonDiviseurDe);
				
				lblClefSecrte = new JLabel("Clef secr\u00EAte");
				lblClefSecrte.setFont(new Font("Arial", Font.PLAIN, 13));
				lblClefSecrte.setBounds(185, 196, 71, 14);
				Rsa.add(lblClefSecrte);
				
				lblRsultat = new JLabel("R\u00E9sultat");
				lblRsultat.setFont(new Font("Arial", Font.PLAIN, 13));
				lblRsultat.setBounds(28, 248, 53, 14);
				Rsa.add(lblRsultat);
		
		JPanel Vernam = new JPanel();
		Vernam.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		Vernam.setBackground(myBlue);
		tabbedPane.addTab("Vernam", null, Vernam, null);
		tabbedPane.setForegroundAt(3, Color.BLUE);
		Vernam.setLayout(null);
		
		OutputVernam = new JTextField();
		OutputVernam.setFont(new Font("Meiryo", Font.BOLD, 13));
		OutputVernam.setBounds(43, 260, 521, 70);
		Vernam.add(OutputVernam);
		OutputVernam.setColumns(10);
		
		JButton CrypterVernam = new JButton(water);
		CrypterVernam.setBorderPainted(true);
		CrypterVernam.setFocusPainted(true);
		CrypterVernam.setContentAreaFilled(true);
		//CrypterVernam.setBounds(107, 165, 128, 23);
		CrypterVernam.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				try{
					if (InputVernam.getText().length() == 0){
						throw new EmptyStringException("Input vide");
					}
					Vernamchiffrer.phrase=InputVernam.getText();
					Vernamchiffrer.crypter(Vernamchiffrer.phrase);
					txtKey.setText(Vernamchiffrer.key);
					OutputVernam.setText(Vernamchiffrer.s);
					Vernamchiffrer.key="";
					Vernamchiffrer.s="";
				}
				catch(Exception e){
					javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		CrypterVernam.setBounds(43, 196, 142, 39);
		Vernam.add(CrypterVernam);
		
		JButton DecrypterVernam = new JButton(watere);
		DecrypterVernam.setBorderPainted(true);
		DecrypterVernam.setFocusPainted(true);
		DecrypterVernam.setContentAreaFilled(true);
		//DecrypterVernam.setBounds(339, 128, 128, 23);
		DecrypterVernam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					if (InputVernam.getText().length() == 0){
						throw new EmptyStringException("Input vide");
					}
					Vernamdechiffrer.c=InputVernam.getText();
					Vernamdechiffrer.a=txtKey.getText();
					Vernamdechiffrer.decrypter(Vernamdechiffrer.c,Vernamdechiffrer.a);
					OutputVernam.setText(Vernamdechiffrer.s);
					Vernamdechiffrer.c="";
					Vernamdechiffrer.s="";
				}
				catch(Exception e){
					javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
				
				
				
			}
		);
		DecrypterVernam.setBounds(422, 196, 142, 39);
		Vernam.add(DecrypterVernam);
		
		InputVernam = new JTextField();
		InputVernam.setFont(new Font("Meiryo", Font.BOLD, 13));
		InputVernam.setBounds(43, 54, 521, 75);
		Vernam.add(InputVernam);
		InputVernam.setColumns(10);
		
		txtKey = new JTextField();
		txtKey.setFont(new Font("Meiryo", Font.BOLD, 13));
		txtKey.setBounds(43, 155, 521, 30);
		Vernam.add(txtKey);
		txtKey.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Taper votre texte");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(43, 22, 105, 32);
		Vernam.add(lblNewLabel_2);
		
		lblClef = new JLabel("Clef");
		lblClef.setFont(new Font("Arial", Font.PLAIN, 13));
		lblClef.setBounds(43, 131, 31, 25);
		Vernam.add(lblClef);
		
		lblRsultat_1 = new JLabel("R\u00E9sultat");
		lblRsultat_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblRsultat_1.setBounds(43, 230, 53, 32);
		Vernam.add(lblRsultat_1);
		JPanel Cesar = new JPanel();
		Cesar.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		//Color myBlue = new Color(red,green,blue);
     	Cesar.setBackground(myBlue);
     	
	
     	
     	tabbedPane.addTab("Cesar", null, Cesar, null);
     	tabbedPane.setTitleAt(4, "Cesar");
     	tabbedPane.setForegroundAt(4, Color.BLUE);
     	Cesar.setLayout(null);
     	outputcesar = new JTextField();
     	outputcesar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
     	outputcesar.setBorder(null);
     	outputcesar.setFont(new Font("Meiryo", Font.BOLD | Font.ITALIC, 13));
     	outputcesar.setBounds(45, 254, 511, 63);
     	Cesar.add(outputcesar);
     	outputcesar.setColumns(10);
     	JButton CrypterCesar = new JButton(water);
     	CrypterCesar.setBackground(new Color(169, 169, 169));
     	CrypterCesar.setForeground(new Color(169, 169, 169));
     	CrypterCesar.setBorderPainted(true);
     	CrypterCesar.setFocusPainted(true);
     	CrypterCesar.setContentAreaFilled(true);
     	CrypterCesar.setBounds(45, 165, 141, 37);
     	CrypterCesar.addActionListener(new ActionListener() {
     		
     		public void actionPerformed(ActionEvent e) {
     		   
     		   try{
					if (inputcesar.getText().length() == 0 || clecesar.getText().length() == 0){
						throw new EmptyStringException("Champs vide(s)");
					}
					if(!isInteger(clecesar.getText(), 10)){
						throw new Exception("Clé non valide"); 
					}
					String	Texte = inputcesar.getText();
	     	        String  Clef = clecesar.getText();
	     	        Cesarchiffrer.cle=Integer.parseInt(Clef);
	     			Cesarchiffrer.phrase=Texte;
					int taille=Cesarchiffrer.phrase.length();
	     			for(int i=0;i<taille;i++)
	     			Cesarchiffrer.tab[i]=Cesarchiffrer.phrase.charAt(i);
	     			Cesarchiffrer.ascii(taille);
	                outputcesar.setText(Cesarchiffrer.s);
	     			Cesarchiffrer.s="";
				}
				catch(EmptyStringException ex){
					javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
				}
     		   catch (Exception exc){
     			  javax.swing.JOptionPane.showMessageDialog(null, exc.getMessage());
     		   }
     		}
     	});
     	Cesar.add(CrypterCesar);
     	
     	inputcesar = new JTextField();
     	inputcesar.setFont(new Font("Meiryo", Font.BOLD, 13));
     	inputcesar.setBounds(45, 87, 511, 63);
     	Cesar.add(inputcesar);
     	inputcesar.setColumns(10);
     	
    
     	JButton DecrypterCesar = new JButton(watere);
     	DecrypterCesar.setBorderPainted(true);
     	DecrypterCesar.setFocusPainted(true);
     	DecrypterCesar.setContentAreaFilled(true);
     	//DecrypterCesar.setBounds(424, 143, 128, 23);
     	DecrypterCesar.addActionListener(new ActionListener() {
     		
     		public void actionPerformed(ActionEvent arg0) {
     		
     			
     		  try{
					if (inputcesar.getText().length() == 0 || clecesar.getText().length() == 0){
						throw new EmptyStringException("Champs vide(s)");
					}
					if(!isInteger(clecesar.getText(), 10)){
						throw new Exception("Clé non valide"); 
					}
					String	Texte = inputcesar.getText();
     	            String  Clef = clecesar.getText();
     	            Cesardechiffrer.cle=Integer.parseInt(Clef);
	     			Cesardechiffrer.phrase=Texte;
					int taille=Cesardechiffrer.phrase.length();
	     			for(int i=0;i<taille;i++)
	     			Cesardechiffrer.tab[i]=Cesardechiffrer.phrase.charAt(i);
	     			Cesardechiffrer.ascii(taille);
	     			Cesardechiffrer.transformer(taille);
		            outputcesar.setText(Cesardechiffrer.s);
	     			Cesardechiffrer.s="";
	     			}
				
				catch(EmptyStringException ex){
					javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
				}
   		        catch (Exception exc){
   			        javax.swing.JOptionPane.showMessageDialog(null, exc.getMessage());
   		   }
   		}
     			
     			
     			
     		
     	});
     	DecrypterCesar.setBounds(419, 165, 141, 37);
     	Cesar.add(DecrypterCesar);
     	
     	clecesar = new JTextField();
     	clecesar.setToolTipText("Entrer un entier");
     	clecesar.setBounds(234, 176, 115, 26);
     	Cesar.add(clecesar);
     	clecesar.setColumns(10);
     	
     	JLabel lblAjouterVotreTexte = new JLabel("Taper votre texte ");
     	lblAjouterVotreTexte.setFont(new Font("Arial", Font.PLAIN, 13));
     	lblAjouterVotreTexte.setBounds(45, 45, 105, 23);
     	Cesar.add(lblAjouterVotreTexte);
     	
     	JLabel lblNewLabel = new JLabel("Clef");
     	lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
     	lblNewLabel.setBounds(272, 161, 31, 14);
     	Cesar.add(lblNewLabel);
     	
     	lblNewLabel_1 = new JLabel("R\u00E9sultat");
     	lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 13));
     	lblNewLabel_1.setBounds(46, 229, 58, 14);
     	Cesar.add(lblNewLabel_1);
 
     	
     	JPanel Hill = new JPanel();
     	Hill.setBorder(new LineBorder(new Color(0, 0, 0), 0));
     	Hill.setBackground(myBlue);
     	tabbedPane.addTab(" Hill ", null, Hill, null);
     	tabbedPane.setForegroundAt(5, Color.BLUE);
     	Hill.setLayout(null);
     	
     	inputhill = new JTextField();
     	inputhill.setBounds(33, 61, 524, 52);
     	Hill.add(inputhill);
     	inputhill.setColumns(10);
     	
     	a = new JTextField();
     	a.setBounds(58, 139, 53, 20);
     	Hill.add(a);
     	a.setColumns(10);
     	
     	b = new JTextField();
     	b.setBounds(207, 139, 53, 20);
     	Hill.add(b);
     	b.setColumns(10);
     	
     	d1 = new JTextField();
     	d1.setBounds(504, 139, 53, 20);
     	Hill.add(d1);
     	d1.setColumns(10);
     	
     	c = new JTextField();
     	c.setBounds(372, 139, 53, 20);
     	Hill.add(c);
     	c.setColumns(10);
     	
     	outputhill = new JTextField();
     	outputhill.setBounds(33, 251, 524, 57);
     	Hill.add(outputhill);
     	outputhill.setColumns(10);
     	
     	
     	JButton decrypterhill = new JButton(watere);
     	decrypterhill.addActionListener(new ActionListener() {
     		public void actionPerformed(ActionEvent e) {
     			
     		    HillDechiffrer.a=Integer.parseInt(a.getText());
     			HillDechiffrer.b=Integer.parseInt(b.getText());
     			HillDechiffrer.c=Integer.parseInt(c.getText());
     			HillDechiffrer.d1=Integer.parseInt(d1.getText());
     			HillDechiffrer.phrase=inputhill.getText();
                HillDechiffrer.calcule(HillDechiffrer.phrase,HillDechiffrer.a,HillDechiffrer.b,HillDechiffrer.c,HillDechiffrer.d1);
                outputhill.setText(HillDechiffrer.s);
                HillDechiffrer.s="";
     			
     		}
     	});
     	decrypterhill.setBounds(413, 178, 144, 36);
     	Hill.add(decrypterhill);
     	
     	
     	JButton crypterhill = new JButton(water);
     	crypterhill.addActionListener(new ActionListener() {
     		public void actionPerformed(ActionEvent arg0) {
     			HillChiffrer.afficher();
     			
     			a.setText(Integer.toString(HillChiffrer.a));
     			b.setText(Integer.toString(HillChiffrer.b));
     			c.setText(Integer.toString(HillChiffrer.c));
     			HillChiffrer.phrase=inputhill.getText();
     			HillChiffrer.calcule(HillChiffrer.phrase);
     			d1.setText(Integer.toString(HillChiffrer.d));
     			outputhill.setText(HillChiffrer.s);
     			HillChiffrer.s="";
     		}
     	});
     	crypterhill.setBounds(33, 178, 144, 36);
     	Hill.add(crypterhill);
     	
     	lblTaperVoteTexte = new JLabel("Taper vote texte");
     	lblTaperVoteTexte.setFont(new Font("Arial", Font.PLAIN, 13));
     	lblTaperVoteTexte.setBounds(33, 38, 92, 14);
     	Hill.add(lblTaperVoteTexte);
     	
     	lblA = new JLabel("A");
     	lblA.setFont(new Font("Arial", Font.PLAIN, 13));
     	lblA.setBounds(33, 141, 23, 14);
     	Hill.add(lblA);
     	
     	lblB = new JLabel("B");
     	lblB.setFont(new Font("Arial", Font.PLAIN, 13));
     	lblB.setBounds(182, 141, 23, 14);
     	Hill.add(lblB);
     	
     	lblC = new JLabel("C");
     	lblC.setFont(new Font("Andalus", Font.PLAIN, 13));
     	lblC.setBounds(346, 141, 23, 14);
     	Hill.add(lblC);
     	
     	lblD = new JLabel("D");
     	lblD.setFont(new Font("Arial", Font.PLAIN, 13));
     	lblD.setBounds(476, 141, 23, 14);
     	Hill.add(lblD);
     	
     	lblRsultat_5 = new JLabel("R\u00E9sultat");
     	lblRsultat_5.setFont(new Font("Arial", Font.PLAIN, 13));
     	lblRsultat_5.setBounds(33, 225, 53, 14);
     	Hill.add(lblRsultat_5);
     	
     	DES = new JPanel();
     	DES.setBorder(new LineBorder(new Color(0, 0, 0), 0));
     	DES.setBackground(myBlue);
     	tabbedPane.addTab(" Data Encryption Standard ", null, DES, null);
     	tabbedPane.setForegroundAt(6, Color.BLUE);
     	DES.setLayout(null);
     	
     	JLabel lblTaperVotreTexte_1 = new JLabel("Taper votre texte");
     	lblTaperVotreTexte_1.setFont(new Font("Arial", Font.PLAIN, 13));
     	lblTaperVotreTexte_1.setBounds(49, 27, 96, 26);
     	DES.add(lblTaperVotreTexte_1);
     	
     	inputdes = new JTextField();
     	inputdes.setBounds(49, 64, 502, 45);
     	DES.add(inputdes);
     	inputdes.setColumns(10);
     	
     	JButton decrypterdes = new JButton(watere);
     	decrypterdes.addActionListener(new ActionListener() {
     		public void actionPerformed(ActionEvent arg0) {
     			try{
					if((inputdes.getText().length() == 0) || (clefdes.getText().length() == 0)){
						throw new EmptyStringException("Champs vide(s)");
					}				
					else if (!clefdes.getText().matches("-?[0-9a-fA-F]+")){
						   throw new Exception("La clé doit être en hexadécimal");
					}
     			String msgcry=inputdes.getText();
     			String key=clefdes.getText();
     			
     	
     			StringBuffer msgclair=DESa.decrypte(msgcry,key);
     			String s=msgclair.toString();
     			outputdes.setText(s);
     		}
     			catch(EmptyStringException exception){
					javax.swing.JOptionPane.showMessageDialog(null, exception.getMessage());
				}	
				catch(Exception ex){
					javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
				}}
     		});
     	decrypterdes.setBounds(410, 187, 141, 39);
     	DES.add(decrypterdes);
     	
     	JButton crypterdes = new JButton(water);
     	crypterdes.addActionListener(new ActionListener() {
     		public void actionPerformed(ActionEvent e) {
     			try{
					if((inputdes.getText().length() == 0) || (clefdes.getText().length() == 0)){
						throw new EmptyStringException("Champs vide(s)");
					}				
					else if (!clefdes.getText().matches("-?[0-9a-fA-F]+")){
						   throw new Exception("La clé doit être en hexadécimal");
					}
					String pt=inputdes.getText();
	     			String key=clefdes.getText();
	     			outputdes.setText(DESa.crypte(pt,key));	
				}
				catch(EmptyStringException exception){
					javax.swing.JOptionPane.showMessageDialog(null, exception.getMessage());
				}	
				catch(Exception ex){
					javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
				}
     		}
     	});
     	crypterdes.setBounds(246, 187, 141, 39);
     	DES.add(crypterdes);
     	
     	clefdes = new JTextField();
     	clefdes.setBounds(144, 137, 407, 35);
     	DES.add(clefdes);
     	clefdes.setColumns(10);
     	
     	outputdes = new JTextField();
     	outputdes.setBounds(49, 255, 502, 54);
     	DES.add(outputdes);
     	outputdes.setColumns(10);
     	
     	JLabel lblRsultat_6 = new JLabel("R\u00E9sultat");
     	lblRsultat_6.setFont(new Font("Arial", Font.PLAIN, 13));
     	lblRsultat_6.setBounds(49, 228, 79, 14);
     	DES.add(lblRsultat_6);
     	
     	JLabel lblClef_3 = new JLabel("Clef de 64 Bits");
     	lblClef_3.setFont(new Font("Arial", Font.PLAIN, 13));
     	lblClef_3.setBounds(49, 140, 85, 26);
     	DES.add(lblClef_3);
     	
     	Mayoubi = new JPanel();
     	Mayoubi.setBorder(new LineBorder(new Color(0, 0, 0), 0));
     	Mayoubi.setBackground(myBlue);
     	tabbedPane.addTab("Maryoubil", null, Mayoubi, null);
     	tabbedPane.setForegroundAt(7, Color.BLUE);
     	Mayoubi.setLayout(null);
     	
     	outputmayoubi = new JTextField();
     	outputmayoubi.setFont(new Font("Arial", Font.PLAIN, 13));
     	outputmayoubi.setBounds(31, 246, 538, 63);
     	Mayoubi.add(outputmayoubi);
     	outputmayoubi.setColumns(10);
     	
     	inputmayoubi = new JTextField();
     	inputmayoubi.setFont(new Font("Meiryo", Font.BOLD, 13));
     	inputmayoubi.setColumns(10);
     	inputmayoubi.setBounds(31, 53, 538, 63);
     	Mayoubi.add(inputmayoubi);
     	
     	keymayoubi = new JTextField();
     	keymayoubi.setFont(new Font("Meiryo", Font.BOLD, 13));
     	keymayoubi.setToolTipText("Entrer une clef inf\u00E9rieur \u00E0 50");
     	keymayoubi.setBounds(86, 158, 130, 26);
     	Mayoubi.add(keymayoubi);
     	keymayoubi.setColumns(10);
     	
     	JButton DecrypterMayoubi = new JButton(watere);
     	DecrypterMayoubi.setBorderPainted(true);
     	DecrypterMayoubi.setFocusPainted(true);
     	DecrypterMayoubi.setContentAreaFilled(true);
     	//DecrypterMayoubi.setBounds(35, 175, 128, 23);
     	DecrypterMayoubi.addActionListener(new ActionListener() {
     		public void actionPerformed(ActionEvent arg0) {	
     			   try
     				{	
     				   if(keymayoubi.getText().length() == 0 || inputmayoubi.getText().length() == 0){
     					   throw new EmptyStringException("Champs vide(s)");
     				   }
     				    MayoubiDechiffrer.mot=inputmayoubi.getText();
     	     		    String key=keymayoubi.getText();
     		            MayoubiDechiffrer.clef=Integer.parseInt(key);
     		            MayoubiDechiffrer.tableau();
     	     			MayoubiDechiffrer.recuperer(MayoubiDechiffrer.mot, MayoubiDechiffrer.clef);
     	     			int taille = MayoubiDechiffrer.mot.length();
     	     			MayoubiDechiffrer.recuperer(MayoubiDechiffrer.mot, MayoubiDechiffrer.clef);
     	     			MayoubiDechiffrer.convertir(taille);
     	     			outputmayoubi.setText(MayoubiDechiffrer.s);
     	     			MayoubiDechiffrer.s="";
     				}
     				catch(NumberFormatException exception)
     				{
     					javax.swing.JOptionPane.showMessageDialog(null, exception.getMessage());

     				}
     			   catch (EmptyStringException ex){
     				  javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
     			   }
     		}
     	});
     	DecrypterMayoubi.setBounds(416, 146, 139, 38);
     	Mayoubi.add(DecrypterMayoubi);
     	
     	JButton CrypterMayoubi = new JButton(water);
     	CrypterMayoubi.setBorderPainted(true);
     	CrypterMayoubi.setFocusPainted(true);
     	CrypterMayoubi.setContentAreaFilled(true);
     	//CrypterMayoubi.setBounds(70, 111, 130, 53);
     	CrypterMayoubi.addActionListener(new ActionListener() {
     		public void actionPerformed(ActionEvent arg0) {
     			try
 				{	
 				if(keymayoubi.getText().length() == 0 || inputmayoubi.getText().length() == 0){
 					   throw new EmptyStringException("Champs vide(s)");
 				}
 				  
 				MayoubiChiffrer.phrase=inputmayoubi.getText().toLowerCase();
 	     		String key=keymayoubi.getText();
 	     		MayoubiChiffrer.clef=Integer.parseInt(key);
 	     		MayoubiChiffrer.tableau();
     			MayoubiChiffrer.convertir(MayoubiChiffrer.phrase);
     			outputmayoubi.setText(MayoubiChiffrer.s);
     			MayoubiChiffrer.s="";
 				}
 				catch(NumberFormatException exception)
 				{
 					javax.swing.JOptionPane.showMessageDialog(null, exception.getMessage());
 				}
 			    catch (EmptyStringException ex){
 				    javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
 			    }
     		}
     	});
     	CrypterMayoubi.setBounds(253, 146, 139, 38);
     	Mayoubi.add(CrypterMayoubi);
     	
     	lblEntreVotreTexte = new JLabel("Taper votre texte");
     	lblEntreVotreTexte.setFont(new Font("Arial", Font.PLAIN, 13));
     	lblEntreVotreTexte.setBounds(31, 28, 153, 14);
     	Mayoubi.add(lblEntreVotreTexte);
     	
     	lblClef_1 = new JLabel("Clef");
     	lblClef_1.setFont(new Font("Arial", Font.PLAIN, 13));
     	lblClef_1.setBounds(41, 155, 36, 32);
     	Mayoubi.add(lblClef_1);
     	
     	lblRsultat_2 = new JLabel("R\u00E9sultat");
     	lblRsultat_2.setFont(new Font("Arial", Font.PLAIN, 13));
     	lblRsultat_2.setBounds(31, 226, 56, 14);
     	Mayoubi.add(lblRsultat_2);
		
	}
}
