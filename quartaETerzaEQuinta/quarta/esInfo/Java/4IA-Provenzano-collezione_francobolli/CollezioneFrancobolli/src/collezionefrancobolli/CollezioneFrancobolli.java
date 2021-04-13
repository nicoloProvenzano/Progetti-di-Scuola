/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collezionefrancobolli;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Nicolo'
 */
//collezione di oggetti che in questo caso sono francobolli
public class CollezioneFrancobolli {
    
    //uso un arraylist perche' gli conosco meglio rispetto alle mappe e mi piace piu' l'idea di una lista di francobolli che di una mappa di francobolli
    ArrayList<Francobollo> collezioneFrancobolli = new ArrayList();

    //costruttore che non serve a molto visto che deve contenere oggetti
    //la parte importante e complessa sono i metodi a mio riguardo
    public CollezioneFrancobolli() {
    }
    
    //metodo per aggiungere un francobollo, questo causerà la creazione di un oggetto chiedendo gli attributi del francobollo
    public String aggiungiFrancobollo(){
    
        Francobollo francobollo=new Francobollo();
        collezioneFrancobolli.add(francobollo);
        
        return "operazione riuscita";
    }
    
    //metodo per creare rapidamente quattro francobolli con parametri di default. Ho usato i più famosi...
    public void popola(){
        
        collezioneFrancobolli.add(new Francobollo("Rothschild","Italia",1860,200000,8,4,"bello","VD4T"));
        collezioneFrancobolli.add(new Francobollo("The Penny Black","Gran Bretagna",1840,500000,7,1,"il te delle 5",""));
        collezioneFrancobolli.add(new Francobollo("Cantone di basilea","Svizzera",1845,70000,5,2,"svizzero? no Novi",""));
        collezioneFrancobolli.add(new Francobollo("Four Annas","india",1854,1000,7,8,"thaji mahal",""));
        
        System.out.println("operzione riuscita");
    }
    
    //metodo per trovare un francobollo tramite il suo attributo codice, 
    //se lo trova mostra su schermo la posizione in cui si trova e tutte le info in suo riguardo
    public int trovaFrancobolloConCodice(int codice){
    
        //for (Francobollo collezioneFrancobolli1 : collezioneFrancobolli) {}
        //ciclo per ogni elemento dell arrylist utilizzato nella beta, 
        //funzionava molto bene ma era un po' un problema dopo con l'indice.
        //Lascialo qua, potrebbe tornare utile in seguito
        for(int i=0;i<collezioneFrancobolli.size();i++){//scorre tutto l'array finche' non lo trova   
            
            if(collezioneFrancobolli.get(i).codiceCatalogo==codice){
            
                int j=i+1;
                System.out.println("il francobollo e' stato trovato alla pos:"+j); 
                System.out.println("il suo titolo e':"+collezioneFrancobolli.get(i).titolo);
                System.out.println("e' stato stampato nell'anno:"+collezioneFrancobolli.get(i).anno);
                System.out.println("da 1 a 10 e sue condizioni sono:"+collezioneFrancobolli.get(i).conservazione);        
                System.out.println("e' stato stampato nel seguente paese:"+collezioneFrancobolli.get(i).paese); 
                //System.out.println("il suo codice e':"+collezioneFrancobolli.get(i).codiceCatalogo);
                System.out.println("ha un valore di:"+collezioneFrancobolli.get(i).valore+"euro");
                System.out.println(collezioneFrancobolli.get(i).descrizione);   
                
                if(collezioneFrancobolli.get(i).paese.equals("Italia")){
                
                    System.out.println("il suo codice bolaffi e':"+collezioneFrancobolli.get(i).bolaffi);
                }
                return i;//parametro da returnare per il metodo di eliminazione
            }
        }
        System.out.println("non trovato");
        return collezioneFrancobolli.size();
    }
    
    //metodo per eliminare un francobollo dato il suo attributo codice
    //si appoggia al metodo per trovarne uno con il codice
    public void eliminaFrancobollo(int codice){
        
        int index=0;
        Scanner tastiera=new Scanner(System.in);
        index=trovaFrancobolloConCodice(codice);
        
        if(index<collezioneFrancobolli.size()){
            
            System.out.println("sicuro di volerlo eliminare? Per farlo scrivi:si");
            
            if(tastiera.next().equals("si")) collezioneFrancobolli.remove(index);
        }
    }
    
        //metodo che usa l'attributo titolo per trovare un francobollo
        //e' ugale identico a quello per il codice
    
        /**
         * 
         * @param titolo
         * @return posizione del francobollo trovato
         */
        public int trovaFrancobolloConTitolo(String titolo){
    
        //for (Francobollo collezioneFrancobolli1 : collezioneFrancobolli) {//ciclo per ogni elemento dell arrylist
        for(int i=0;i<collezioneFrancobolli.size();i++){   
            
            if(collezioneFrancobolli.get(i).titolo.equals(titolo)){
            
                int j=i+1;
                System.out.println("il francobollo e' stato trovato alla pos:"+j); 
                //System.out.println("il suo titolo e':"+collezioneFrancobolli.get(i).titolo);
                System.out.println("il suo codice e':"+collezioneFrancobolli.get(i).codiceCatalogo);
                System.out.println("e' stato stampato nell'anno:"+collezioneFrancobolli.get(i).anno);
                System.out.println("da 1 a 10 e sue condizioni sono:"+collezioneFrancobolli.get(i).conservazione);        
                System.out.println("e' stato stampato nel seguente paese:"+collezioneFrancobolli.get(i).paese);        
                System.out.println("ha un valore di:"+collezioneFrancobolli.get(i).valore+"euro");
                System.out.println(collezioneFrancobolli.get(i).descrizione);   
                
                if(collezioneFrancobolli.get(i).paese.equals("Italia")){
                
                    System.out.println("il suo codice bolaffi e':"+collezioneFrancobolli.get(i).bolaffi);
                }
                return i;
            }
        }
        System.out.println("non trovato");
        return 0;
    }
        
    //un toSring con nome diverso essenzialmente
    public void visualizaCollezione() {

        int pos;
        for (int i = 0; i < collezioneFrancobolli.size(); i++) {

            pos=i+1;

            System.out.println("il francobollo e' stato trovato alla post:" + pos);
            System.out.println("il suo titolo e':" + collezioneFrancobolli.get(i).titolo);
            System.out.println("e' stato stampato nell'anno:" + collezioneFrancobolli.get(i).anno);
            System.out.println("da 1 a 10 e sue condizioni sono:" + collezioneFrancobolli.get(i).conservazione);
            System.out.println("e' stato stampato nel seguente paese:" + collezioneFrancobolli.get(i).paese);
            System.out.println("il suo codice e':"+collezioneFrancobolli.get(i).codiceCatalogo);
            System.out.println("ha un valore di:" + collezioneFrancobolli.get(i).valore + "euro");
            System.out.println(collezioneFrancobolli.get(i).descrizione);

            if (collezioneFrancobolli.get(i).paese.equals("Italia")) {

                System.out.println("il suo codice bolaffi e':" + collezioneFrancobolli.get(i).bolaffi);
            }
            
            //MOLTO IMPORTANTE
            //questa oltre a fare da separatore 
            //e' anche il carattere speciale per capire quando finisce un francobollo e ne inizia un altro
            //in particolare accede direttamente alla riga dopo
            System.out.println("*----------------------------------------*");
        }
    }
        
    //metodo per salvare tutta la collezione su un file
    //nel file viene salvato con un formato identico a quello del metodo visualizzaCollezioni() qua in alto
    
    /**
     * 
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void salvataggioSuFile() throws FileNotFoundException, IOException{
    
        Scanner tastiera=new Scanner(System.in);
        String scelta=null;
        String file="D:\\collezioneSalvata.txt";//se non esiste viene creato dopo dando la conferma
                
        System.out.println("se vuoi sceglier il file su cui salvare scrivi:si");
        scelta=tastiera.next();
        int pos;
        
        
        //metti quello che vuoi, ricorda che pure qua se non esiste il file viene creato lo stesso
        if(scelta=="si"){
        
            System.out.println("in che file vuoi salvare?");
            System.out.println("mettere tutto il percorso e l'estensione");
            file=tastiera.next();
        }
            
            PrintWriter scrittoreFile=new PrintWriter(new File(file));
            BufferedWriter tastieraFile=new BufferedWriter(scrittoreFile);
            
            for(int i=0;i<collezioneFrancobolli.size();i++){
                
                pos=i+1;
            
                tastieraFile.write("Francobollo alla posizione:"+pos);
                tastieraFile.newLine();
                
                tastieraFile.write(collezioneFrancobolli.get(i).titolo);
                tastieraFile.newLine();
                
                tastieraFile.write(collezioneFrancobolli.get(i).codiceCatalogo+"");
                tastieraFile.newLine();
                
                tastieraFile.write(collezioneFrancobolli.get(i).anno+"");
                tastieraFile.newLine();
                
                tastieraFile.write(collezioneFrancobolli.get(i).conservazione+"");
                tastieraFile.newLine();
                
                tastieraFile.write(collezioneFrancobolli.get(i).paese);
                tastieraFile.newLine();
                
                tastieraFile.write(collezioneFrancobolli.get(i).valore+"");
                tastieraFile.newLine();
                
                tastieraFile.write(collezioneFrancobolli.get(i).descrizione);
                tastieraFile.newLine();
                
                tastieraFile.write(collezioneFrancobolli.get(i).bolaffi);
                tastieraFile.newLine();
                
                tastieraFile.write("*----------------------------------------*");
                tastieraFile.newLine();
            }
            tastieraFile.flush();
            tastieraFile.close();
            System.out.println("operazione riuscita");
    }
    
    //metodo per salvare sull'arraylist una collezione presente su file
    //bada bene che il file deve avere un formato specifico
    public void salvaSuCollezioneDaFile() throws FileNotFoundException, IOException{
        
        Scanner tastiera=new Scanner(System.in);
        String file = "D:\\collezioneSalvata.txt";
        String scelta=null;
        //mi serviva un costruttore con paramentri qualsiasi e non dovesse chiedere all'utente 
        //lo so che potevo mettere di mio a mano tutti i parametri a zero
        Francobollo aggiunto = new Francobollo(0);

        System.out.println("vuoi elinimare tutti i francobolli presenti nella collezione? se si scrivere:si");
        if(tastiera.next().equals("si")){
            collezioneFrancobolli.clear();
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
            
                aggiunto.titolo=buffer.readLine();
                //System.out.println(aggiunto.titolo);
                
                aggiunto.codiceCatalogo= Integer.parseInt(buffer.readLine());
                //System.out.println(aggiunto.codiceCatalogo);
                
                aggiunto.anno=Integer.parseInt(buffer.readLine());
                //System.out.println(aggiunto.anno);
                
                aggiunto.conservazione=Integer.parseInt(buffer.readLine());
                //System.out.println(aggiunto.conservazione);
                
                aggiunto.paese=buffer.readLine();
                //System.out.println(aggiunto.paese);
                
                aggiunto.valore=Integer.parseInt(buffer.readLine());
                //System.out.println(aggiunto.valore);
                
                aggiunto.descrizione=buffer.readLine();
                //System.out.println(aggiunto.descrizione);
                
                aggiunto.bolaffi=buffer.readLine();
                //System.out.println(aggiunto.bolaffi);
                
                
                line=buffer.readLine();
                //System.out.println(line);
            }
            collezioneFrancobolli.add(collezioneFrancobolli.size(), aggiunto);//prova  guardare sto indice
            }
        }
        System.out.println("dowload completato");
        
    }
    
    //main gestito come un menu'
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Scanner tastiera=new Scanner(System.in);
        int scelta=0;
        String titolo="";
        
        //una persona puo' anche decidere di chiudere subito l'applicazione
        System.out.println("Salve! vuoi modificare o visualizzare la tua collezione? Per farlo scrivi: si");
        if(tastiera.next().equals("si")){
            
            CollezioneFrancobolli collezione = new CollezioneFrancobolli();
            int codice=0;
        
            do{//famoso menu', il do while mi e' sembrato il ciclo migliore visto che volevo che uscisse prima il menu', poi la scelta e infine la condizione
            System.out.println("bene, cosa vuoi fare:");
            System.out.println("-1 popolare velocemente la collezione");
            System.out.println("-2 aggiungere manualmente un nuovo francobollo");
            System.out.println("-3 cercare un francobollo grazie al suo titolo");
            System.out.println("-4 cercare un francobollo grazie al suo codice");
            System.out.println("-5 eliminare un francobollo");
            System.out.println("-6 salvare su file l'intera collezione");
            System.out.println("-7 ripristinare la colezione da file");
            System.out.println("-8 visualizzare la collezione");
            System.out.println("-9 uscire");
            scelta=tastiera.nextInt();
            
                switch (scelta) {//si commentano da soli i metodi, guarda il menu'...
                    
                    case 1:

                        collezione.popola();
                        break;
                        
                    case 2:
                        collezione.aggiungiFrancobollo();
                        break;
                        
                    case 3:                        
                        System.out.println("dimmi il titolo");
                        titolo=tastiera.next();
                        collezione.trovaFrancobolloConTitolo(titolo);
                        break;
                        
                    case 4:
                        System.out.println("dimmi il codice");
                        codice=tastiera.nextInt();
                        collezione.trovaFrancobolloConCodice(codice);
                        break;
                        
                    case 5:
                        System.out.println("dimmi il codice");
                        codice=tastiera.nextInt();
                        collezione.eliminaFrancobollo(codice);
                        break;
                    
                    case 6:
                        collezione.salvataggioSuFile();
                        
                        break;
                        
                    case 7:
                        collezione.salvaSuCollezioneDaFile();
                        
                        break;
                        
                    case 8:
                         collezione.visualizaCollezione();
                         break;
                        
                    case 9:
                        System.out.println("grazie per aver usato la mia applicazione!");
                        break;
                        
                    default:
                        System.out.println("non hai scelto un opzione valida");
                        break;
                }
            
            }while(scelta!=9);
            
            System.out.println("TERMINAZIONE PROGRAMMA");
        }
        
    }
    
}
