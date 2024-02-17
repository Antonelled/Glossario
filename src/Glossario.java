import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

import javax.swing.BorderFactory;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Glossario extends JApplet implements ActionListener{
	String [][] categorie = new String [60000][5];
	String testo="";
	String car, str;
	String archivio;
	String archivio1="E:/DATI/Album/";
	String s;
	String stringa="";
	int i,j,indice;
	JTextField input;
	Button chirca, reset;
	Label intestazione= new Label("Uso: individuare elenchi e definizioni", Label.CENTER);
	Label campo1= new Label("  Nome",Label.LEFT);
	Label campo2= new Label("  Categorie",Label.LEFT);
	Label campo3= new Label("  Sottocategorie",Label.LEFT);
	Label campo4= new Label("Sinonimo o breve definizione (con foto, se preceduti dal segno @)",Label.CENTER);
	Image foto;
	Icon icona;
	JLabel fotografia=new JLabel("",SwingConstants.CENTER);
	JTextArea risultati;
	JTextArea risultati1;
	JTextArea risultati2;
	
	JScrollPane pannello_scorrevole;
	JScrollPane pannello_scorrevole1;
	JScrollPane pannello_scorrevole2;
	
	Font ft1 = new Font("Verdana",1,14);
	Font ft2 = new Font("Verdana",0,12);
	


	public void init() {
		archivio="DATI/Glossario1.txt";
		setLayout(null);
		intestazione.setBounds(120,5,300,20);
		intestazione.setFont(ft1);
		add(intestazione);
		input = new JTextField();
		input.setBounds(490,5,130,20);
		add(input);
		chirca=new Button("CERCA");
		chirca.setFont(ft2);
		chirca.setBounds(438,3,50,25);
		chirca.setBackground(Color.blue);
		chirca.setForeground(Color.white);
		chirca.addActionListener(this);
		add(chirca);
		reset = new Button("CANCELLA");
		reset.setFont(ft2);
		reset.setBounds(620,3,70,25);
		reset.setBackground(Color.red);
		reset.setForeground(Color.white);
		reset.addActionListener(this);
		add(reset);
		fotografia.setBounds(2,153,1240,360);
		add(fotografia);
		
		campo1.setBounds(3,30,108,18);
		campo2.setBounds(113,30,108,18);
		campo3.setBounds(223,30,108,18);
		campo4.setBounds(333,30,950,18);
		
		campo1.setBackground(Color.blue);
		campo2.setBackground(Color.blue);
		campo3.setBackground(Color.blue);
		campo4.setBackground(Color.blue);
		
		campo1.setForeground(Color.white);
		campo2.setForeground(Color.white);
		campo3.setForeground(Color.white);
		campo4.setForeground(Color.white);
		
		add(campo1);
		add(campo2);
		add(campo3);
		add(campo4);
		
		risultati=new JTextArea(20,10);
		risultati.setTabSize(20);
		
		pannello_scorrevole=new JScrollPane(risultati);
		pannello_scorrevole.setBounds(2,50,1281,600);
		pannello_scorrevole.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
		add(pannello_scorrevole);
		
	
		
		for(int i=0; i<60000;i++)
			for(int j=0;j<5;j++) categorie[i][j]="";
		try{
			InputStream in = Glossario.class.getResource(archivio).openStream();
			byte[]b=new byte[in.available()];
			in.read(b);
			testo = new String(b);
		}catch(Exception e) {}
		i=0;
		j=0;
		for(int k=1;k<testo.length();k++) {
			char chr=testo.charAt(k);
			car = ""+chr;
			
			if(!car.equals("  ")) {
				if(!car.equals("#")){
					if(!car.equals("*")) 
						stringa=stringa+car;
						else {
							categorie[i][j]=stringa;
							stringa="";
							j++;
						}
					}
					else {
						stringa="";
						i++;
						j=0;
					}
				}
			}
		}
		
		public void actionPerformed(ActionEvent e) {
			Object sorgente =  e.getSource();
			if(sorgente== chirca) {
				indice=-1;
				fotografia.setText(" ");
				for(i=0; i <categorie.length;i++) {
					while(categorie[i][1].equalsIgnoreCase(input.getText())) {
						campo1.setText("  Nome");
						campo2.setText("  Categoria");
						campo3.setText("  Sottocategoria");
						campo4.setText("  Sinonimo o brevedefinizione (con foto, se preceduti da @" );
						
						risultati.append(" "+categorie[i][0]+"\t"+categorie[i][1]+"\t" + categorie[i][2]+ "\t"+categorie[i][3]+"\n");
						
						break;
					}
					while(categorie[i][2].equalsIgnoreCase(input.getText())) {
						campo1.setText("  Nome");
						campo2.setText("  Categoria");
						campo3.setText("  Sottocategoria");
						campo4.setText("  Sinonimo o brevedefinizione (con foto, se preceduti da @" );
						
						
						
						risultati.append(" "+categorie[i][0]+"\t"+categorie[i][1]+"\t" + categorie[i][2]+ "\t"+categorie[i][3]+"\n");
						
						break;
					}
				/*	
					while(categorie[i][3].equalsIgnoreCase(input.getText())) {
						campo1.setText("  Nome");
						campo2.setText("  Categoria");
						campo3.setText("  Sottocategoria");
						campo4.setText("  Sinonimo o brevedefinizione (con foto, se preceduti da @" );
						
						risultati.append(" "+categorie[i][0]+"\t"+categorie[i][1]+"\t" + categorie[i][2]+ "\t"+categorie[i][3]+"\n");
						
						break;
					}
				*/	
					while(categorie[i][0].equalsIgnoreCase(input.getText())) {
						campo1.setText("  Nome");
						campo2.setText("  Categoria");
						campo3.setText("  Sottocategoria");
						campo4.setText("  Sinonimo o brevedefinizione (con foto, se preceduti da @" );
						
						risultati1 = new JTextArea();
						//risultati.setTabSize(10);
						risultati.setTabSize(7);
						
						pannello_scorrevole1 = new JScrollPane(risultati1);
						if(input.getText() != null)
							risultati1.setText("");
						pannello_scorrevole1.setBounds(2,50,110,600);
						pannello_scorrevole1.setBorder(BorderFactory.createLineBorder(new Color (255,0,0)));
						add(pannello_scorrevole1);
						
						pannello_scorrevole.setBounds(111,50,1170,600);
						risultati1.setForeground(Color.RED);
						risultati1.setText("");
						risultati1.append(" " + categorie[i][0]);
						risultati.append("      "+categorie[i][1]+"\t\t" + categorie[i][2]+ "\t"+categorie[i][3]+"\n");
						
						indice=i;
						
						foto = getImage(getDocumentBase(),archivio1 + categorie[indice][0]+".jpg");
						icona=new ImageIcon(foto);
						fotografia.setIcon(icona);
						risultati.add(fotografia);
						
						break;
					}
				}
			}
			
			if(indice != -1) {
				play(getCodeBase(),"DATI/SUONI/"+categorie[indice][0]+".wav");
				indice=-1;
			}
			
			if(sorgente == reset) {
				input.setText("");
				risultati.setText("");
				risultati1.setText("");
				fotografia.setIcon(null);
				pannello_scorrevole1.setBounds(0,0,0,0);
				pannello_scorrevole.setBounds(2,50,1200,600);
			}
		}
		
		public void start() {
			super.start();
		}
		public void destroy() {
			super.destroy();
		}
		
	}
//}