/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubrica;

/**
 *
 * @author Nicolo'
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Nicolo'
 */
//collezione di oggetti che in questo caso sono contatti di una rubrica
public class Rubrica {
    
    HashMap<String, Contatto> rubrica = new HashMap<String, Contatto>(); 
    
    //costruttore che non serve a molto visto che deve contenere oggetti
    //la parte importante e complessa sono i metodi a mio riguardo
    public Rubrica() {
    }
    
    //metodo per aggiungere un contatto, questo causerà la creazione di un oggetto chiedendo gli attributi del contatto
    public String aggiungiFrancobollo(){
    
        Contatto contatto=new Contatto();
        rubrica.put(contatto.numeroDiTelefono, contatto);
        
        return "operazione riuscita";
    }
    
    //metodo per creare rapidamente quattro contatti con parametri di default.
    public void popola(){
        
        Contatto contatto;
        
        contatto=new Contatto("marco","marco@gmail.com","457693486");
        rubrica.put(contatto.numeroDiTelefono,contatto);
        
        contatto=new Contatto("nico","nico@gmail.com","235634556");
        rubrica.put(contatto.numeroDiTelefono,contatto);
        
        contatto=new Contatto("fabio","fabio@gmail.com","346367853");
        rubrica.put(contatto.numeroDiTelefono,contatto);
        
        System.out.println("operzione riuscita");
    }
    
    //metodo per trovare un contatto tramite il suo attributo numeroDiTelefono, 
    //se lo trova mostra su schermo il nome del contatto
    public void trovaContattoConNumeroDiTelefono(int numeroDiTelefono){
        
        if(!rubrica.get(numeroDiTelefono).equals(null)){
             System.out.println("il contatto con questa numero e':"+rubrica.get(numeroDiTelefono).email);
        }else
        System.out.println("non trovato");
    }
    
    //metodo per eliminare un francobollo dato il suo attributo email
    //si appoggia al metodo per trovarne uno con il email
    public void eliminaContattoNumeroDiTelefono(int numeroDiTelefono){
        
        Scanner tastiera=new Scanner(System.in);
            
            System.out.println("sicuro di volerlo eliminare? Per farlo scrivi:si");
            if(!rubrica.get(numeroDiTelefono).equals(null)){
            
            if(tastiera.next().equals("si")){ 
                
                rubrica.remove(numeroDiTelefono);
                System.out.println("elemento rimosso corretamente");
            }
            
            }else System.out.println("non trovato");
    }
    
        //metodo che usa l'attributo numeroTelefonico per trovare un francobollo
        //e' ugale identico a quello per il email
    
        /**
         * 
         * @param titolo
         * @return posizione del francobollo trovato
         */
    public void trovaContattoConEmail(String email){
      
        Contatto appoggio;
        boolean trovato=false;
        
        for (String i : rubrica.keySet()) {
            
            appoggio=rubrica.get(i);
            if(appoggio.email.equals(email)){
            
            System.out.println("il contatto con questa mail e':"+appoggio.numeroDiTelefono);
            trovato=true;
            }
        }
        if(!trovato) System.out.println("non trovato");
    }
    
    public void eliminaContattoEmail(String email){
        
        Scanner tastiera=new Scanner(System.in);
        Contatto appoggio;
        boolean trovato=false;
            
        System.out.println("sicuro di volerlo eliminare? Per farlo scrivi:si");
            if(tastiera.next().equals("si")){ 
                
                for(String i : rubrica.keySet()) {
            
                    appoggio=rubrica.get(i);
                    
                    if(appoggio.email.equals(email)){
                        
                        String numero=appoggio.numeroDiTelefono;
                        rubrica.remove(numero);
                        trovato=true;
                    }
                }
            if(!trovato) System.out.println("non trovato");
            }
        
    }
    
        
    //un toSring con nome diverso essenzialmente
    public void visualizaCollezione() {

        Contatto appoggio;
        for (String i : rubrica.keySet()) {
            appoggio=rubrica.get(i);
            System.out.println("contatto:"+appoggio.nome+" numero di telefono:"+appoggio.numeroDiTelefono+" email:"+appoggio.email);
        }
    }
        
    //metodo per salvare tutta la rubrica su un file
    //nel file viene salvato con un formato identico a quello del metodo visualizzaRubrica() qua in alto
    
    /**
     * 
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void salvataggioSuFile() throws FileNotFoundException, IOException{
    
        Scanner tastiera=new Scanner(System.in);
        String scelta="";//null
        String file="E:\\collezioneSalvata.txt";//se non esiste viene creato dopo dando la conferma
                
        System.out.println("se vuoi sceglier il file su cui salvare scrivi:si");
        scelta=tastiera.next(); 
        
        //metti quello che vuoi, ricorda che pure qua se non esiste il file viene creato lo stesso
        if(scelta.equals("si")){
        
            System.out.println("in che file vuoi salvare?");
            System.out.println("mettere tutto il percorso e l'estensione");
            file=tastiera.next();
        }
            
            PrintWriter scrittoreFile=new PrintWriter(new File(file));
            BufferedWriter tastieraFile=new BufferedWriter(scrittoreFile);
            
            Contatto appoggio;
            for (String i : rubrica.keySet()) {
                
                appoggio=rubrica.get(i);
                
                tastieraFile.write("");
                //System.out.println(""+appoggio.nome);
                tastieraFile.newLine();
                
                tastieraFile.write(appoggio.nome);
                //System.out.println(""+appoggio.nome);
                tastieraFile.newLine();
                
                tastieraFile.write(appoggio.numeroDiTelefono);//String.valueOf serve a convertire da int a string per poterlo scrivere su file
                tastieraFile.newLine();
                
                tastieraFile.write(appoggio.email);
                tastieraFile.newLine();
                
                tastieraFile.write("*----------------------------------------*");
                tastieraFile.newLine();
            }
            tastieraFile.flush();
            tastieraFile.close();
            System.out.println("operazione riuscita");
    }
    
    //metodo per salvare sulla mappat una rubrica presente su file
    //bada bene che il file deve avere un formato specifico
    public void salvaSuCollezioneDaFile() throws FileNotFoundException, IOException{
        
        Scanner tastiera=new Scanner(System.in);
        String file = "E:\\collezioneSalvata.txt";
        String scelta="";
        //mi serviva un costruttore con paramentri qualsiasi e non dovesse chiedere all'utente 
        //lo so che potevo mettere di mio a mano tutti i parametri a zero
        Contatto aggiunto = new Contatto(0);

        System.out.println("vuoi elinimare tutti i contatti presenti nella rubrica? se si scrivere:si");
        if(tastiera.next().equals("si")){
            rubrica.clear();
        }
      
        System.out.println("se vuoi sceglier il file da cui importare scrivi:si");
        scelta=tastiera.next();
        
        //metti quello che vuoi, ricorda che pure qua se non esiste il file viene creato lo stesso
        if(scelta=="si"){
        
            System.out.println("in che file vuoi salvare?");
            System.out.println("mettere tutto il percorso e l'estensione");
            file=tastiera.next();
        }
        
        FileReader lettore=new FileReader(file);
        BufferedReader buffer=new BufferedReader(lettore);//il buffer semplifica molte operazoni del file reader oltre ad aggiungerne di nuove
        
        String line="n";
        while(line!=null){//il null sarebbe la fine del file
    
            line=buffer.readLine();
            if(line!=null){
                while(!line.equals("*----------------------------------------*")){//famoso carattere speciale, legge finche non viene trovato
            
                    aggiunto.nome=buffer.readLine();
                    System.out.println(aggiunto.nome);
                
                    aggiunto.numeroDiTelefono=buffer.readLine();
                    System.out.println(aggiunto.numeroDiTelefono);
                
                    aggiunto.email=buffer.readLine();
                    System.out.println(aggiunto.email);
                
                    line=buffer.readLine();
                    System.out.println(line);
                }
            rubrica.put(aggiunto.numeroDiTelefono, aggiunto);//prova  guardare sto indice
            }
        }
        System.out.println("dowload completato");
        
    }
    
    //main gestito come un menu'
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Scanner tastiera=new Scanner(System.in);
        int scelta=0;
        int numeroTelefonico=0;
        
        //una persona puo' anche decidere di chiudere subito l'applicazione
        System.out.println("Salve! vuoi modificare o visualizzare la tua rubrica? Per farlo scrivi: si");
        if(tastiera.next().equals("si")){
            
            Rubrica rubrica = new Rubrica();
            String email="";
        
            do{//famoso menu', il do while mi e' sembrato il ciclo migliore visto che volevo che uscisse prima il menu', poi la scelta e infine la condizione
            System.out.println("bene, cosa vuoi fare:");
            System.out.println("-1 popolare velocemente la collezione");
            System.out.println("-2 aggiungere manualmente un nuovo francobollo");
            System.out.println("-3 cercare un francobollo grazie al suo numero di telefono");
            System.out.println("-4 cercare un francobollo grazie alla sua email");
            System.out.println("-5 eliminare un francobollo tramite numero di telefono");
            System.out.println("-6 eliminare un francobollo tramite email");
            System.out.println("-7 salvare su file l'intera rubrica");
            System.out.println("-8 ripristinare la rubrica da file");
            System.out.println("-9 visualizzare la rubrica");
            System.out.println("-10 uscire");
            scelta=tastiera.nextInt();
            
                switch (scelta) {//si commentano da soli i metodi, guarda il menu'...
                    
                    case 1:

                        rubrica.popola();
                        break;
                        
                    case 2:
                        rubrica.aggiungiFrancobollo();
                        break;
                        
                    case 3:                        
                        System.out.println("dimmi il numero di telefono");
                        numeroTelefonico=tastiera.nextInt();
                        rubrica.trovaContattoConNumeroDiTelefono(numeroTelefonico);
                        break;
                        
                    case 4:
                        System.out.println("dimmi la mail");
                        email=tastiera.next();
                        rubrica.trovaContattoConEmail(email);
                        break;
                        
                    case 5:
                        System.out.println("dimmi il numero di telefono");
                        numeroTelefonico=tastiera.nextInt();
                        rubrica.eliminaContattoNumeroDiTelefono(numeroTelefonico);
                        break;
                    
                    case 6:
                        System.out.println("dimmi la email");
                        email=tastiera.next();
                        rubrica.eliminaContattoEmail(email);
                        break;
                        
                    case 7:
                        rubrica.salvataggioSuFile();
                        
                        break;
                        
                    case 8:
                        rubrica.salvaSuCollezioneDaFile();
                        
                        break;
                        
                    case 9:
                         rubrica.visualizaCollezione();
                         break;
                        
                    case 10:
                        System.out.println("grazie per aver usato la mia applicazione!");
                        break;
                        
                    default:
                        System.out.println("non hai scelto un opzione valida");
                        break;
                }
            
            }while(scelta!=10);
            
            System.out.println("TERMINAZIONE PROGRAMMA");
        }
        
    }
    
}

