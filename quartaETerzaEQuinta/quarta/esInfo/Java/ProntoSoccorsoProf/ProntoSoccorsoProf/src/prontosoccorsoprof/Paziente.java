/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prontosoccorsoprof;

import java.util.Scanner;


/**
 *
 * @author nicolo.provenzano
 */
public class Paziente {
	
	protected String nome;
	protected String cognome;
	protected int livelloDiEmergenza;
	protected Paziente successivo;
	protected Scanner tastiera=new Scanner(System.in);

	//public Paziente(String nome, String cognome, String livelloDiEmergenza) {
		
//		this.nome = nome;
//		this.cognome = cognome;
//		this.livelloDiEmergenza = livelloDiEmergenza;
//	
	

	public Paziente(){
		
		this.successivo=null;
		String coloreEmergenza="";
		
		System.out.println("dimmi il nome del paziente");
		nome=tastiera.next();
		System.out.println("dimmi il cognome del paziente");
		cognome=tastiera.next();
		System.out.println("dimmi il livello di  del paziente");
		coloreEmergenza=tastiera.next();
		
		if (coloreEmergenza.equals("rosso")) {
			
			livelloDiEmergenza=1;
			
		} else if (coloreEmergenza.equals("giallo")) {
			
			livelloDiEmergenza=2;
			
		} else {
			
			livelloDiEmergenza=3;
		}
		
		this.successivo = successivo;
	}
	
	

	@Override
	public String toString() {
		return "nome=" + nome + ", cognome=" + cognome;
	}
	
}
