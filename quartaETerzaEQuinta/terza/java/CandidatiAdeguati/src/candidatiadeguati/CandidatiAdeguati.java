package candidatiadeguati;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class CandidatiAdeguati {

	protected int n = 0;
	protected int m = 0;
	protected int[] candidati;
	protected String riga = "";
	File file = new File("prova.txt");
	Scanner sc = new Scanner(file);
	int maxVoto = 0;

	public CandidatiAdeguati() throws FileNotFoundException {

		n = sc.nextInt();
		m = sc.nextInt();
		candidati = new int[n];
		sc.nextLine();

	}

	public void adegauti() {

		int pos = 0;

		while (sc.hasNextLine()) {
			riga = sc.nextLine();

			pos = (riga.charAt(4) - '0') - 1;
			
			if (riga.charAt(2) == 'I') {
				
				candidati[pos] = -1;
				
			} else if (candidati[pos] != -1) {
				
				candidati[pos]++;
			}
		}

		for (int i = 0; i < candidati.length; i++) {

			if (maxVoto < candidati[i]) {

				maxVoto = candidati[i];
			}
		}
	}

	public int nCandidatiPossibili() {

		int risultato = 0;
		for (int i = 0; i < candidati.length; i++) {

			if (maxVoto == candidati[i]) {

				risultato++;
			}
		}

		return risultato;
	}

	public static void main(String[] args) throws FileNotFoundException {

		CandidatiAdeguati candidati = new CandidatiAdeguati();
		candidati.adegauti();
		System.out.println(candidati.nCandidatiPossibili());
	}

}
