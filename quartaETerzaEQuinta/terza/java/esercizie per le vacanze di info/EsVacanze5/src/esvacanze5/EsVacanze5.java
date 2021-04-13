/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esvacanze5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Nicolo'
 */
public class EsVacanze5 {

    protected ArrayList<Integer> lista=new ArrayList <Integer>(10);
    protected int nNumeri;
    protected int numero;
    
    public EsVacanze5(){
    
    this.lista=new ArrayList<Integer>(10);
    
    }
    
    public ArrayList aggiungiNumeri() throws  IndexOutOfBoundsException, InputMismatchException {
        try{
           Scanner tastiera = new Scanner(System.in);
           System.out.println("dimmi quanti numeri vuoi massimo 10");
           nNumeri=tastiera.nextInt();
           for(int i=0;i<nNumeri;i++){
              System.out.println("dimmi che numero vuoi");
              numero=tastiera.nextInt(); 
              lista.add(numero);
          }
       }catch(IndexOutOfBoundsException | InputMismatchException ex){
            System.out.println("il valore che hai immesso non e' un numero o non e' intero oppure");
            System.out.println("il numero di numeri che volevi immettere era piu grande del numero massimo consentito che e' uguale a 10");
       }
        return lista;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        EsVacanze5 listaDiNumeri= new EsVacanze5();
        System.out.println( listaDiNumeri.aggiungiNumeri());
    }
    
}
