/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esvacanze1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Nicolo'
 */
public class EsVacanze1 {

   protected int numeroMaterie;
   protected  String nome;
   protected  String cognome;
    
    
    public EsVacanze1(String nome, String cognome, int numeroMaterie){
    this.cognome=cognome;
    this.nome=nome;
    this.numeroMaterie=numeroMaterie;
    
    
    }

    
  public int materieDaRecuperare(){
      numeroMaterie=2;
      return numeroMaterie;
    }
  
  public String getNome(){
  
  return nome;
  }
  
  
  public String getCognome(){
  
  return cognome;
  }
  
  
  public String chiSei(){

  return getNome()+" "+getCognome();
  }
  
  
      
    public class Amici extends EsVacanze1{
        
        protected String amici ;
        Scanner tastiera =new Scanner(System.in);
        protected int nAmici;
    
        public Amici(String nome, String cognome, int numeroMaterie) {
            
            super(nome, cognome, numeroMaterie);
      
            
        }
        
        @Override
        public String chiSei(){
            
            System.out.println("quanti amici hai?");
            nAmici=tastiera.nextInt();
            for(int i=0;i<nAmici;i++){
                System.out.println("come si chiama il tuo amico?");
                amici=amici+","+tastiera.next();
            }
    return super.chiSei()+amici;
    }
        
    
    }
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EsVacanze1 studente = new EsVacanze1("nicolo","provenzano",2);
        System.out.println(studente.chiSei()+" "+studente.numeroMaterie);
        
    }
    
}
