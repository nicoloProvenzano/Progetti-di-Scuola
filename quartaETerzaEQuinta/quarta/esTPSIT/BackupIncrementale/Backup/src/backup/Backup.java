/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author nicolo.provenzano
 */
public class Backup {
	
	private static int scelta;
	private final static File FILE = new File("./input.txt");
	private final static Scanner TASTIERA = new Scanner(System.in);

	public static void menu() {
		Scanner tastiera = new Scanner(System.in);
		System.out.println("\t\tMENU\n");
		System.out.println("1. Backup completo");
		System.out.println("2. Backup differenziale");
		System.out.println("3. Ripristina.");
		System.out.println("4. Esci dal programma.");
		System.out.print("Scelta : ");
		scelta = tastiera.nextInt();
	}
	
	public File creaFile() throws IOException {

		System.out.println("dimmi il percorso dove vuoi salvare il file");
		String path =TASTIERA.next();
// "C:" + File.separator + "hello" + File.separator + "hi.txt";
// Use relative path for Unix systems
		File f = new File(path);

		f.getParentFile().mkdirs();
		f.createNewFile();
		
		return f;
	}
	
	public void backupCompleto() throws IOException{
		
		File backup = creaFile();
	}
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		menu();
		
	}
	
}
