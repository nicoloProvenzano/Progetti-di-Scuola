/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progressbar;

import javax.swing.*;               // CREA UNA PROGRESS BAR 
import java.awt.event.*;

public class ProgressBar {
	
	static Timer t;
	static String[][] matrice=new String[5][8];
	static String domanda;
	static String opzione1;
	static String opzione2;
	static String opzione3;
	static String opzione4;
	static int punteggio=0;
	static int riga=0;
	static int colonna=0;
	
	public static void main(String arg[]) throws Exception {
		//INIZIALIZZAZIONE
		JFrame f = new JFrame("ProgressBar demo");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(200, 100, 400, 600);           // posizione e dimensione del frame              
		f.setLayout(null);    
		// impaginazione  
		JButton bottone = new JButton("Invia");//CREO IL BOTTONE
		JProgressBar bar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 10000);// crea una progressbar
		
		bar.setValue(0);                        // valore da cui iniziare   
		// bar.setMaximum(100);                    // valore superiore della barra 
		// bar.setMinimum(10);                    	// valore inferiore della barra
		bar.setStringPainted(true);             // mostra la percentuale sulla barra

		JTextArea ta = new JTextArea("", 10, 50); // crea una area di testo con 10 righe e 50 colonne
		ta.setEditable(false);                  // la TextArea non è modificabile dall'utente

			ta.setText("");
			// modifica il contenuto dell'area di testo
			
			JLabel l = new JLabel("Scegli una Risposta (Numero):");

			JTextField ris = new JTextField(3);
			
		matrice[0][0] = "1";
		matrice[0][1] = "3";
		matrice[0][2] = "10";
		matrice[0][3] = "cosa succede all idi di marzo?";
		matrice[0][4] = "1-viene eletto senatore un cavallo";
		matrice[0][5] = "2-brucia roma";
		matrice[0][6] = "3-muore cesare";
		matrice[0][7] = "4-nasce l'impero";

		matrice[1][0] = "2";
		matrice[1][1] = "2";
		matrice[1][2] = "10";
		matrice[1][3] = "cosa e' la bastiglia?";
		matrice[1][4] = "1-cimitero";
		matrice[1][5] = "2-prigione";
		matrice[1][6] = "3-senato";
		matrice[1][7] = "4-villa";

		matrice[2][0] = "3";
		matrice[2][1] = "1";
		matrice[2][2] = "10";
		matrice[2][3] = "quando avviene la spedizione dei mille?";
		matrice[2][4] = "1-1860";
		matrice[2][5] = "2-1845";
		matrice[2][6] = "3-1850";
		matrice[2][7] = "4-1870";
		
		matrice[3][0] = "4";
		matrice[3][1] = "1";
		matrice[3][2] = "10";
		matrice[3][3] = "chi si ritira durante la prima guerra mondiale?";
		matrice[3][4] = "1-russia";
		matrice[3][5] = "2-germania";
		matrice[3][6] = "3-francia";
		matrice[3][7] = "4-italia";
		
			domanda=matrice[colonna][3];	
			opzione1=matrice[colonna][4];
			opzione2=matrice[colonna][5];
			opzione3=matrice[colonna][6];
			opzione4=matrice[colonna][7];
			ta.setText(domanda+"\n"+opzione1+"\n"+opzione2+"\n"+opzione3+"\n"+opzione4);

			bottone.addActionListener(new ActionListener() // Ascoltatore evento bottone premuto
					
			{
				public void actionPerformed(ActionEvent e) {
										
					String Comando = e.getActionCommand();
					String risposta="";//VARIABILE DOVE PRENDO IL VALORE DELLA LABEL
						
						if (Comando.equals("Invia")) {

							risposta = ris.getText();

							if (risposta.equals(matrice[riga][1])) {
								
								punteggio++;
								System.out.println("corretto\n il tuo punteggio e'" + punteggio);

							} else {
								System.out.println("sbagliato \n il tuo punteggio e'" + punteggio);
							}
							bar.setValue(0);
							riga++;

						}	
					
					if(riga==4){
					
						ris.setText("");
						ta.setText("il tuo punteggio e':"+punteggio);
						bottone.setVisible(false);
						bar.setVisible(false);
						l.setVisible(false);
						ris.setVisible(false);
						//termina il programma
					}else{
						
						ris.setText("");
						colonna++;
						domanda=matrice[colonna][3];
						opzione1=matrice[colonna][4];
						opzione2=matrice[colonna][5];
						opzione3=matrice[colonna][6];
						opzione4=matrice[colonna][7];
						ta.setText(domanda+"\n"+opzione1+"\n"+opzione2+"\n"+opzione3+"\n"+opzione4);
					}
				}
				
				
			});

			ta.setBounds(20, 50, 320, 200);            //  (posx, posy, larghezza, altezza)
			f.add(ta);                              //  aggiunge i vari componenti al Frame

			bar.setBounds(100, 300, 130, 30);
			f.add(bar);

			l.setBounds(100, 350, 200, 30);
			f.add(l);

			ris.setBounds(100, 400, 130, 30);
			f.add(ris);

			bottone.setBounds(100, 450, 130, 30);
			f.add(bottone);

			f.setVisible(true);

			t = new Timer(2, new ActionListener() // ascoltatore per il timer 
			{                               // che viene eseguito ogni 2 milli-secondi      
			public void actionPerformed(ActionEvent ae) {
				
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}
				if (riga < 4) {
					if (bar.getValue() >= bar.getMaximum()) {

						riga++;
						bar.setValue(0);
						ris.setText("");
						colonna++;
						domanda = matrice[colonna][3];
						opzione1 = matrice[colonna][4];
						opzione2 = matrice[colonna][5];
						opzione3 = matrice[colonna][6];
						opzione4 = matrice[colonna][7];
						ta.setText(domanda + "\n" + opzione1 + "\n" + opzione2 + "\n" + opzione3 + "\n" + opzione4);

					} else {
						bar.setValue(bar.getValue() + 1000);  //incrementa la barra  
					}
				}
			}
		}
		);
		
		t.start();
		
	}

}
//if(bar.getValue()>=bar.getMaximum()){}