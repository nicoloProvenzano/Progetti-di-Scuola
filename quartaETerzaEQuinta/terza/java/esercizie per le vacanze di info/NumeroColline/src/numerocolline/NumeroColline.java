/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerocolline;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Nicolo'
 */
public class NumeroColline {
    
    protected int nMonti;
    protected ArrayList<Integer> altezMont=new ArrayList<Integer>();
    protected int altezza;
    protected int piuAlto;
    Scanner tastiera=new Scanner(System.in);
    
    public NumeroColline(){
    
    System.out.println("dimmi quanti monti vuoi confrontare");    
    nMonti=tastiera.nextInt();
    piuAlto=0;
    }
    
    public void riempiListaMontagne() throws IndexOutOfBoundsException, NumberFormatException{
    try{
       for(int i=0;i<nMonti;i++){
           System.out.println("dimmi quanto alto e' il monte");
           altezza=tastiera.nextInt();
           altezMont.add(altezza);
           }
    }catch (IndexOutOfBoundsException | NumberFormatException ex){
        System.out.println("hai inserito un numero non corretto"); 
        }
    
    }
    
    
    public int getPiuAlto() throws IndexOutOfBoundsException, NumberFormatException {        
    try{
        piuAlto=altezMont.get(0);
        for(int i=1;i<nMonti;i++){       
            if(altezMont.get(i)>piuAlto){        
                piuAlto=altezMont.get(i);       
            }                      
        }
        return piuAlto; 
    }catch (IndexOutOfBoundsException | NumberFormatException ex){
        System.out.println("hai inserito un numero non corretto o troppi numeri"); 
    }
       return piuAlto;
    }

    public static void main(String[] args) {
     
     NumeroColline montagne=new NumeroColline();
     montagne.riempiListaMontagne();
        System.out.println("il monte piu alto e"+montagne.getPiuAlto());
        
    }
    
}
