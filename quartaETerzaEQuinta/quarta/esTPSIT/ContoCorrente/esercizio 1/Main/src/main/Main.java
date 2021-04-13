/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Nicolo'
 */
//  Attiva un  thread che preleva per 5 volte 10 euro dal conto corrente
class Consumatore extends Thread {
	private ContoCorrente account;
	public Consumatore(ContoCorrente acct) { account = acct; }
	public void run() {
	
            for(int i=0;i<20;i++){
            
                account.preleva(10);
            }
	}
}


//  Attiva un  thread che versa per 5 volte 10 euro dal conto corrente
class Produttore extends Thread {
	
        private ContoCorrente account;
	public Produttore(ContoCorrente acct) { account = acct; }
            public void run() {
	
            for(int i=0;i<20;i++){
            
                account.deposita(10);
            }
	}
    }



class ContoCorrente {

	private String intestatario;
	private int saldo;
	
	public ContoCorrente(String intestatario, int saldoInizale) {
	
            this.intestatario=intestatario;
            this.saldo=saldo;
	}
	
	public void deposita(int somma) {
       	
            saldo+=somma;
	}
	
	public void preleva(int somma) {
	
            saldo-=somma;
	}
    
	//  attende per un periodo di durata casuale non superiore a 100 ms.
	private void delay() throws InterruptedException {
	
            TimeUnit.SECONDS.sleep((long) Math.random());
	}
    
	//  restituisce nome del conto e saldo
	public String toString() {                      
            
            return intestatario+" il saldo e' di:"+saldo;
	}	
}


public class Main {
    
	public static void main(String[] args) {
            
            ContoCorrente contoCorrente=new ContoCorrente("Mario Rossi",200);
		
            Produttore produttore=new Produttore(contoCorrente);
            Consumatore consumatore = new Consumatore(contoCorrente);
            
            produttore.run();
            consumatore.run();
            
            contoCorrente.toString();
	}	
}
    

