/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collezionefrancobolli;

import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Nicolo'
 */
public class Francobollo {
    
    //tutti gli attributi
    String titolo="";
    String paese="";
    int anno=0;
    int valore=0;
    int conservazione=0;//parte da 1 con lo stato peggiore fino a 10 con lo stato migliore
    int codiceCatalogo=0;
    String descrizione="";
    String bolaffi="";
    
    
    //costruttore automatico
    public Francobollo(String titolo,String paese,int anno,int valore,int conservazione,int codiceCatalogo,String descrizione,String bolaffi) {
        
    this.titolo=titolo;
    this.paese=paese;
    this.anno=anno;
    this.valore=valore;
    this.conservazione=conservazione;
    this.codiceCatalogo=codiceCatalogo;
    this.descrizione=descrizione;
    this.bolaffi=bolaffi;
        
    }
    
    public Francobollo(int valore){}//costuttore per creare un oggetto con i parametri a 0 e null
    
    //costruttore per utente
    public Francobollo() {
        
        Scanner tastiera = new Scanner(System.in);
        
        System.out.println("adesso ti chiedero' le varie informazioni riguardo al francobollo");
        
        System.out.println("diimmi il titolo");
        titolo=tastiera.next();
        
        System.out.println("dimmi il paese");
        paese=tastiera.next();
        
        System.out.println("diimmi l'anno");
        anno=tastiera.nextInt();
        
        System.out.println("dimmi il valore");
        valore=tastiera.nextInt();
        
        System.out.println("diimmi la conservazione");
        conservazione=tastiera.nextInt();
        
        System.out.println("dimmi il codice");
        codiceCatalogo=tastiera.nextInt();
        
        System.out.println("diimmi la descrizione");
        descrizione=tastiera.next();
        
        if (paese.equals("Italia")){
        
            System.out.println("dimmi il codice bolaffi");
            bolaffi=tastiera.next();
        }
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Francobollo other = (Francobollo) obj;
        if (this.codiceCatalogo != other.codiceCatalogo) {
            return false;
        }
        if (!Objects.equals(this.titolo, other.titolo)) {
            return false;
        }
        if (!Objects.equals(this.paese, other.paese)) {
            return false;
        }
        return true;
    }


    

}
