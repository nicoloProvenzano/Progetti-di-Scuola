/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Nicolo'
 */
class ContoCorrente {

	
    	private ArrayList <DatiOperazione>  movimenti;
        private String intestatario;
	private int saldo;
	
	public ContoCorrente(String intestatario, int saldoInizale) {
	
            this.intestatario=intestatario;
            this.saldo=saldo;
	}
	
	public void deposita(int somma) {
       	
            saldo+=somma;
            stampaListaMovimenti();
	}
	
	public void preleva(int somma) {
	
            saldo-=somma;
            stampaListaMovimenti();
	}
    
	//  attende per un periodo di durata casuale non superiore a 100 ms.
	private void delay() throws InterruptedException {
	
            TimeUnit.SECONDS.sleep((long) Math.random());
	}
    
	//  restituisce nome del conto e saldo
	public String toString() {                      
            
            return intestatario+" il saldo e' di:"+saldo;
	}
        
	public void stampaListaMovimenti() {
        
            System.out.println("movimento effetuato");
	}
 	
}
////////////////////////////////////////////////////////////////////////

class Operatore extends Thread {
    
	private ContoCorrente account;
 
	public Operatore(ContoCorrente acct) { account = acct; }
        
        @Override
	public void run() {
            
                for(int i=0;i<10;i++){
                    
                    if(Math.random()>0.5){
            
                        account.deposita(10);
                    }
                    else account.preleva(10);
                }
	}
}

//////////////////////////////////////////////////////////////////////////

class DatiOperazione  {

	private int importo;
    	private String operatore;
	
	public DatiOperazione(int importo, String operatore) {
		this.importo=importo;
                this.operatore=operatore;
	}
	
	public String toString() {
            return "l'operazione di:"+operatore+" e' avvenuta e il tuo importo e' di:"+importo;
		
	}	
}
////////////////////////////////////////////////////////////////////////////

public class Main {

	public static void main(String[] args) {
            
            ContoCorrente contoCorrente=new ContoCorrente("Mario Rossi",200);
		
            Operatore operatore=new Operatore(contoCorrente);
            
            operatore.run();
            
            contoCorrente.toString();
	}	
}

