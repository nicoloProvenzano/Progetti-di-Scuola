/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formula1;

import java.util.Scanner;

/**
 *
 * @author Nicolo'
 */
public abstract class Formula1 {

    protected String edizione;
    protected Scanner tastiera = new Scanner(System.in);
    
    public Formula1(){
    
        System.out.println("dimmi che edizione e'");
        edizione=tastiera.next();
    }
   
    
    public static void main(String[] args) {
        
       Classifica scuderie= new Classifica();
       scuderie.setListaScuderie();
       scuderie.setPiloti();
       scuderie.getClassifica();
       
    }
    
}
