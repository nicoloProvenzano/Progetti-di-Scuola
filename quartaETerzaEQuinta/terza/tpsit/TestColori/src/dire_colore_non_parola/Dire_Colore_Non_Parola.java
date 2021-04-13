package dire_colore_non_parola;

/**
 *
 * @author TONETTI.DARIO
 * @class 3IA
 * @date 01/03/2019
 * @version 1.0
 *
 */
public class Dire_Colore_Non_Parola {

    /*CODICE COLORI*/
    public static final String BLACK = "\033[0;30m";   	// NERO
    public static final String RED = "\033[0;31m";     	// ROSSO
    public static final String GREEN = "\033[0;32m";   	// VERDE
    public static final String YELLOW = "\033[0;33m"; 	// GIALLO
    public static final String BLUE = "\033[0;34m";    	// BLU
    public static final String PURPLE = "\033[0;35m";  	// VIOLA
    public static final String CYAN = "\033[0;36m";    	// CIANO
    public static final String WHITE = "\033[0;37m";   	// BIANCO

    /**
     * **********************************************************************************************
     */
    /*NUMERO VOLTE*/
    public static final int NVOLTE = 4; //NUMERO VOLTE CHE VIENE RIPETUTA LA GRIGLIA

    /**
     * **********************************************************************************************
     */
    /*CODICE COLORI EVIDENZIATI*/
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[40;1m";  	// EVIDENZIATO NERO
    public static final String RED_BACKGROUND_BRIGHT = "\033[41;1m";    	// EVIDENZIATO ROSSO
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[42;1m";  	// EVIDENZIATO VERDE
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[43;1m"; 	// EVIDENZIATO GIALLO
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[44;1m";   	// EVIDENZIATO BLU
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[45;1m"; 	// EVIDENZIATO VIOLA
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[46;1m";   	// EVIDENZIATO CIANO
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[47;1m";  	// EVIDENZIATO BIANCO

    /**
     * **********************************************************************************************
     */
    /*VETTORI CONTENENTI IL NOME DEL COLORE E IL LORO CODICE*/
    public static final String[] STR = {"NERO", "ROSSO", "VERDE", "GIALLO", "BLU", "VIOLA", "CIANO", "BIANCO"}; //Vettore di stringhe utilizzato per l'inserimento dei nomi dei colori
    public static final String[] COLORS = {BLACK, RED, GREEN, YELLOW, BLUE, PURPLE, CYAN, WHITE,
        BLACK_BACKGROUND_BRIGHT, RED_BACKGROUND_BRIGHT,
        GREEN_BACKGROUND_BRIGHT, YELLOW_BACKGROUND_BRIGHT,
        BLUE_BACKGROUND_BRIGHT, PURPLE_BACKGROUND_BRIGHT,
        CYAN_BACKGROUND_BRIGHT, WHITE_BACKGROUND_BRIGHT}; //Vettore di stringhe contenenti i codici dei colori da dare ai nomi del vettore sopra indicato

    /**
     * **********************************************************************************************
     */
    /*TEMPO DI GIOCO*/
    public static final int TEMPO_GIOCO = 10000; //DURATA DEL TEMPO DI GIOCO

    /**
     * **********************************************************************************************
     */
    /**
     *
     * @function randomString : utilizzata per scegliere in maniera casuale un
     * nome di un colore
     * @param str
     * @return String
     */
    public static String randomString(String[] str) {
        int i;
        i = (int) (Math.random() * 8); //Utilizzo della funzione Math.random per scegliere un nome casuale tra tutti quelli presenti nel vettore STR
        String s = str[i];
        return s;
    }

    /**
     * **********************************************************************************************
     */
    /**
     *
     * @function randomColo : utilizzata per scegliere in maniera casuale un
     * colore da assegnare al nome randomico scelto nella funzione randomString
     * @param colors
     * @return String
     *
     */
    public static String randomColor(String[] colors) {
        int i;
        i = (int) (Math.random() * 16); //Utilizzo della funzione Math.random per scegliere un colore casuale tra tutti quelli presenti nel vettore COLORS
        String st = colors[i];
        return st;
    }

    /**
     * ***********************************************************************************************
     */
    /**
     *
     * @function parolaColorata : utilizzata per la creazione della griglia di
     * nomi colorati o evidenziati con colori scelti casualmente dalle funzioni
     * sopra indicate
     *
     */
    public static void parolaColorata() {
        System.out.println();
        int cont = 0;
        for (int i = 0; i < 15; i++) { //inizio for per la creazione della griglia
            if (cont == 3) {
                System.out.println();
                cont = 0;
            }
            System.out.print(" " + randomColor(COLORS) + " " + randomString(STR)); //Scrive il nome e il colore dato dalle funzioni sopra indicate
            cont++;
        } //fine for
        System.out.println();
    }

    /**
     * ***********************************************************************************************
     */
    /**
     * @fuction main
     * @param args
     *
     */
    public static void main(String[] args) {
        long t3;                                          //Variabile utilizzata per ritardare l'esecuzione del codice successivo
        for (int nCicli = 0; nCicli < NVOLTE; nCicli++) { //Inizio for per creare la griglia NVOLTE
            parolaColorata();
            long t1 = System.currentTimeMillis();         //Variabile che prende un valore in millisecondi
            do {                                           //Inizio ciclo do-while
                long t2 = System.currentTimeMillis();     //Variabile che prende un valore in millisecondi ogni volta che il il confronto nel while risulta vero
                t3 = t2 - t1;                               //Differenza tra t2 e t1
            } while (t3 < TEMPO_GIOCO);                     //Fine ciclo do-while
            for (int i = 0; i < 20; i++) {                //Inizio for per cancellare lo schermo
                System.out.println();
            }                                             //Fine for per cancellare lo schermo
        }                                                 //Fine For per la creare la griglia NVOLTE
    }
}
