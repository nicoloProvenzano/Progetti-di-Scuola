/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provarandomfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ProvaRandomFile {

	//protected String[] infoPersona=new String[5];
	protected static String dato[] = new String[5];
	protected static byte[] bytes = new byte[100];
	protected static RandomAccessFile file;
	protected static RandomAccessFile file1;

	//METODO CHE LEGGE I PRIMI 10 CARATTERI DI UN FILE
	public static String leggiFile() throws FileNotFoundException, IOException {

		file1 = new RandomAccessFile("./originale.txt", "rw");
		file1.seek(0);
		file1.read(bytes);
		file1.close();
		String s = new String(bytes);
		return s;
	}

	//METODO CHE SCRIVE SUL FILE
	public static void scriviFile() throws FileNotFoundException, IOException {

		leggiFile();
		file = new RandomAccessFile("./file.txt", "rw");
		file.write(bytes);
		file.writeBytes("\n");
		file.write(dato[0].getBytes());
		file.writeBytes(" ");
		file.write(dato[1].getBytes());
		file.writeBytes(" ");
		file.write(dato[2].getBytes());
		file.writeBytes(" ");
		file.write(dato[3].getBytes());
		file.writeBytes(" ");
		file.write(dato[4].getBytes());
		file.close();
	}

	public static void modificaFile() throws FileNotFoundException, IOException {

		leggiFile();
		int scelta = 0;
		int nScelte = 0;
		Scanner scanTastiera = new Scanner(System.in);
		file = new RandomAccessFile("./file.txt", "rw");
		file.write(bytes);
		file.writeBytes("\n");

		System.out.println("quante scelte vuoi");
		nScelte = scanTastiera.nextInt();
		System.out.println("cosa vuoi modificare");
		scelta = scanTastiera.nextInt();
		switch (scelta) {
			case 1:
				file.write(dato[0].getBytes());
				file.writeBytes(" ");
				break;
			case 2:
				file.write(dato[1].getBytes());
				file.writeBytes(" ");
				break;
			case 3:
				file.write(dato[2].getBytes());
				file.writeBytes(" ");
				break;
			case 4:
				file.write(dato[3].getBytes());
				file.writeBytes(" ");
				break;
			case 5:
				file.write(dato[4].getBytes());
				file.close();
				break;
		}
	}

	public static void main(String[] args) throws IOException {

		//DICHIARAZIONE E INIZIALIZZAZIONE DELLE VARIABILI
		int scelta = 0;
		String nome = "";
		String cognome = "";
		int eta = 0;
		String sesso = "";

		Scanner scanTastiera = new Scanner(System.in);
		ProvaRandomFile prova = new ProvaRandomFile();

		//MENU PER SCIEGLIERE CHE OPERZIONE ESEGUIRE
		while (scelta != 5) {

			System.out.println("");
			System.out.println("MENU");
			System.out.println("1 per inserire i dati");
			System.out.println("2 per modificare i dati");
			System.out.println("3 per visualizare i dati");
			System.out.println("4 per cancellare i dati");
			System.out.println("5 per uscire");
			System.out.println("");
			System.out.println("DIMMI LA TUA SCELTA");

			scelta = scanTastiera.nextInt();
			//VARIE SECLETE

			switch (scelta) {

				case 1://scrivo sul file

					//prova.scriviFile();
					System.out.println("inserisci cognome");
					dato[0] = scanTastiera.nextLine();
					System.out.println("inserisci nome");
					dato[1] = scanTastiera.nextLine();
					System.out.println("inserisci sesso");
					dato[2] = scanTastiera.nextLine();
					System.out.println("inserisci anno");
					dato[3] = scanTastiera.nextLine();
					System.out.println("inserisci indirizzo");
					dato[4] = scanTastiera.nextLine();

					scriviFile();

					break;

				case 2://per modificare i dati

					modificaFile();
					break;

				case 3://leggo i valori del file

					leggiFile();
					break;
				case 4:

					dato[0] = " ";
					dato[1] = " ";
					dato[2] = " ";
					dato[3] = " ";
					dato[4] = " ";

					scriviFile();
			}
			/*
			try {


				String dato = " INTRUSO";
				file = new RandomAccessFile(FileName, "rw");
				file.seek(30);
				file.write(dato.getBytes());                //Scrive 8 caratteri lascia \r\n  
				file.close();

				dato = "   by me\r\n";                      // appende una linea di 8 caratteri
				file = new RandomAccessFile(FileName, "rw");
				file.seek(file.length());
				System.out.println("current pointer = " + file.getFilePointer());
				file.write(dato.getBytes());
				file.close();

			} // try 
			catch (IOException e) {
				e.printStackTrace();
			}*/

		}
		
	} //main
}// class