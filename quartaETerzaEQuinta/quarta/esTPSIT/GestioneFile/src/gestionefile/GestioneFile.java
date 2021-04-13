package gestionefile;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Dario.Tonetti
 * @version 1.0
 * @date
 *
 */
public class GestioneFile {
	private static int scelta;
	private final static File FILE = new File("./input.txt");
	private final static Scanner TASTIERA = new Scanner(System.in);

	public static void menu() {
		Scanner tastiera = new Scanner(System.in);
		System.out.println("\t\tMENU\n");
		System.out.println("1. Elenca i nomi e i tipi di tutti i file presenti in uno specifico.");
		System.out.println("2. Visualizza il tipo, la data e ora di creazione, data e ora ultima modifica, dimensione, valore degli attributi R,W,X,H.");
		System.out.println("3. Creare un file vuoto.");
		System.out.println("4. Rinomina file.");
		System.out.println("5. Cancella file.");
		System.out.println("6. Copia il contenuto in un'altra cartella.");
		System.out.println("7. Crea una nuova cartella.");
		System.out.println("8. Esci dal programma.");
		System.out.print("Scelta : ");
		scelta = tastiera.nextInt();
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		menu();
		File file;
		switch (scelta) {
			case 1://Elenca i nomi e i tipi di tutti i file presenti in uno specifico
				System.out.println("Lista dei nomi dei file contenuti nel file input.txt : " + FILE.list());
				break;

			case 2://Visualizza il tipo, la data e ora di creazione, data e ora ultima modifica, dimensione, valore degli attributi R,W,X,H	

				System.out.println();
				System.out.println("Nome : " + FILE.getName());
				System.out.println("Path Assoluto : " + FILE.getAbsolutePath());
				System.out.println("Path Canonico : " + FILE.getCanonicalPath());
				System.out.println("Path Relativo : " + FILE.getPath());
				System.out.println("Dimensione : " + FILE.length());
				System.out.println("Ultima modifica : " + FILE.lastModified());

				System.out.println("Può essere eseguito : " + FILE.canExecute());
				System.out.println("Può essere letto : " + FILE.canRead());
				System.out.println("Può essere scritto : " + FILE.canWrite());
				break;

			case 3://Creare un file vuoto	

				String nomeFile;
				System.out.print("Come vuoi chiamare il File da creare: ");
				nomeFile = TASTIERA.nextLine();
				File cFile = new File(nomeFile);
				cFile.createNewFile();
				System.out.println("Creazione...");
				System.out.println("Fatto");
				break;

			case 4://Rinomina file	

				String nome;
				System.out.print("Come vuoi rinominare il file input.txt ? (inserisci nome.estensione) ");
				nome = TASTIERA.nextLine();
				file = new File(nome);
				FILE.renameTo(file);
				break;

			case 5://Cancella file

				String delete;
				System.out.print("Quale file vuoi eliminare : ");
				delete = TASTIERA.nextLine();
				File fileDelete = new File(delete);
				if (fileDelete.isFile()) {
					fileDelete.delete();
					System.out.println("Eliminato");
				} else {
					fileDelete = new File(delete);
				}
				break;

			case 6://Copia il contenuto in un'altra cartella

				break;

			case 7://Crea una nuova cartella
				String nomeDirectory;
				System.out.print("Inserisci nome della cartella che vuoi creare : ");
				nomeDirectory = TASTIERA.nextLine();
				File dir = new File(nomeDirectory);
				dir.mkdir();
				break;

			case 8://Esci dal programma

				System.out.println("Uscita programma...");
				System.out.println("Fatto");
				break;
		}
	}
}
