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
public class ProntoSoccorsoProf {
	
	protected Paziente head;
	protected int elementi;
	protected Scanner tastiera=new Scanner(System.in);

	public ProntoSoccorsoProf() {
		
		head=new Paziente();
		head.livelloDiEmergenza=0;

	}
		
	public void inserisciPaziente(Paziente pazzienteAggiunto){
	
		Paziente tmp=head;
		Paziente appoggio;
				
			while(pazzienteAggiunto.livelloDiEmergenza>=tmp.livelloDiEmergenza && tmp.successivo!=null){
				
				tmp=tmp.successivo;
			}
			appoggio=tmp.successivo;
			tmp.successivo=pazzienteAggiunto;
			pazzienteAggiunto.successivo=appoggio;
	}
	
	public static void main(String[] args) {
		
		ProntoSoccorsoProf lista= new ProntoSoccorsoProf();
		Paziente n1=new Paziente();
		Paziente n2=new Paziente();
		Paziente n3=new Paziente();
		Paziente n4=new Paziente();
		
	}
	
}
