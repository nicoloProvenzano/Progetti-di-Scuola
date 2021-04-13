/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collezionefrancobolli;

import java.util.Scanner;

/**
 *
 * @author Nicolo'
 */
public class FrancobolloItaliano extends Francobollo{
    
    String bolaffi;
    
    //String paese
    public FrancobolloItaliano(String titolo, int anno, int valore, int conservazione, int codiceCatalogo, String descrizione,String bolaffi ) {
        
        super(titolo, "Italia", anno, valore, conservazione, codiceCatalogo, descrizione, bolaffi);
    }

    public FrancobolloItaliano() {
        
        Scanner tastiera = new Scanner(System.in);
        
        System.out.println("adesso ti chiedero' le varie informazioni riguardo al francobollo");
        
        System.out.println("diimmi il titolo");
        titolo=tastiera.next();
        
        System.out.println("diimmi il titolo");
        anno=tastiera.nextInt();
        
        System.out.println("dimmi il paese");
        valore=tastiera.nextInt();
        
        System.out.println("diimmi il titolo");
        conservazione=tastiera.nextInt();
        
        System.out.println("dimmi il paese");
        codiceCatalogo=tastiera.nextInt();
        
        System.out.println("diimmi il titolo");
        descrizione=tastiera.next();
        
        System.out.println("diimmi il codice bolaffi");
        bolaffi=tastiera.next();
    }
    
    
    
}
