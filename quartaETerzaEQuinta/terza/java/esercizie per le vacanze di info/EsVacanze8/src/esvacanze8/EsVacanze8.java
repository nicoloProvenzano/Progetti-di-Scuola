/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esvacanze8;

import java.util.ArrayList;



/**
 *
 * @author Nicolo'
 */
public class EsVacanze8 {
    
public class Persona{

  protected String nome;
  protected String cognome;
  protected int eta; 
  
  public Persona(String nome,String cognome,int eta){
  
  this.nome=nome;
      System.out.println(nome);
  this.cognome=cognome;
      System.out.println(cognome);
  this.eta=eta;
      System.out.println(eta);
  }
} 

protected ArrayList<Persona> elenco = new ArrayList<>();
protected int nPersone;

public EsVacanze8(int nPersone){

this.elenco=new ArrayList<Persona>();
this.nPersone=nPersone;
}

public void aggiungiPersone(){

for(int i=0;i<nPersone;i++){
    elenco.add(i,new Persona("mario","rossi",12));
    System.out.println(elenco.get(i));
   }


}



    public static void main(String[] args) {
        
        EsVacanze8 prova = new EsVacanze8(2);
        prova.aggiungiPersone();
    }
    
}
