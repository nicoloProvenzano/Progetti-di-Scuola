/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generici1;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Nicolo'
 */
public class Generici1 {
    
    protected ArrayList<String> candidati= new ArrayList<String>();
    protected int nCandidati;
    protected int posizione;
        
    public Generici1(int nCandidati) throws IndexOutOfBoundsException{
       try{
          Scanner cappelloParlante=new Scanner(System.in);
          this.nCandidati=nCandidati;
          for(int i=0;i<this.nCandidati;i++){
              candidati.add(cappelloParlante.next());
        }
          Random r1= new Random();
          posizione=r1.nextInt(nCandidati);
          
          
       }catch(IndexOutOfBoundsException e) {
           System.out.println("hai immesso troppi numeri");
       
       }
       
    }
    
    public <T> String dammiIlPrescelto() {
    
       String prescelto=candidati.get(posizione);
       return prescelto;
    }

  
    public static void main(String[] args) {
       
        Generici1 leggenda=new Generici1(4);
        System.out.println(leggenda.dammiIlPrescelto());
    }
    
}
