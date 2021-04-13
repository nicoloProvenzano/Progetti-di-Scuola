/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prontosoccorso;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author nicolo.provenzano
 */
public class ProntoSoccorso {

	protected ArrayList lista;
	protected int posPrimoBianco;
	protected int posPrimoGiallo;
	protected int posUltimoBianco;
	protected Scanner tastiera=new Scanner(System.in);

	public ProntoSoccorso() {
		lista = new ArrayList();
		posPrimoBianco = 0;
		posPrimoGiallo = 0;
		posUltimoBianco = 0;
	}
	
	public void aggiungiPaziente(Paziente paziente) {

		if (paziente.livelloDiEmergenza.equals("rosso")) {
			
			lista.add(posPrimoGiallo, paziente);
			//System.out.println(lista.get(posPrimoGiallo).toString());
			posPrimoGiallo++;
			posPrimoBianco++;
			posUltimoBianco++;
			System.out.println("paziente aggiunto alla pos:"+posPrimoGiallo);
			
		} else if (paziente.livelloDiEmergenza.equals("giallo")) {
			
			lista.add(posPrimoBianco, paziente);
			posPrimoBianco++;
			posUltimoBianco++;
			System.out.println("paziente aggiunto alla pos:"+posPrimoBianco);
			
		} else {
			
			lista.add(posUltimoBianco, paziente);
			posUltimoBianco++;
			System.out.println("paziente aggiunto alla pos:"+posUltimoBianco);
		}
	}
	
	public void rimuoviPazientePiuGrave(){
	
		System.out.println(lista.get(0).toString());
		lista.remove(0);
	}
	public void numeroPazienti(){
		
		int nRossi=posPrimoGiallo;
		int nGialli=posPrimoBianco-posPrimoGiallo;
		int nBianchi=posUltimoBianco-posPrimoBianco;
		
		System.out.println("numero pazienti codice rosso:"+nRossi);
		System.out.println("numero pazienti codice rosso:"+nGialli);
		System.out.println("numero pazienti codice rosso:"+nBianchi);
	}	
	
		public void rimuoviPazienteSpecifico(int pos){
	
		if(pos<=posUltimoBianco || pos>=0){
		System.out.println(lista.get(pos).toString());
		lista.remove(pos);
		}
		else System.out.println("non esiste questo paziente");
	}
		
	public void listaDiPazienti(){
	
		int nPazienti=0;
		System.out.println("quanti pazienti ci sono?");
		nPazienti=tastiera.nextInt();
		
		for(int i=0;i<nPazienti;i++){
			
			System.out.println("paziente numero:"+(i+1));
			aggiungiPazienteDaTastiera();
		}
	
	}
	
		public void aggiungiPazienteDaTastiera() {
			
		Paziente paziente=new Paziente();

		if (paziente.livelloDiEmergenza.equals("rosso")) {
			
			lista.add(posPrimoGiallo, paziente);
			//System.out.println(lista.get(posPrimoGiallo).toString());
			posPrimoGiallo++;
			posPrimoBianco++;
			posUltimoBianco++;
			System.out.println("paziente aggiunto alla pos:"+posPrimoGiallo);
			
		} else if (paziente.livelloDiEmergenza.equals("giallo")) {
			
			lista.add(posPrimoBianco, paziente);
			posPrimoBianco++;
			posUltimoBianco++;
			System.out.println("paziente aggiunto alla pos:"+posPrimoBianco);
			
		} else {
			
			lista.add(posUltimoBianco, paziente);
			posUltimoBianco++;
			System.out.println("paziente aggiunto alla pos:"+posUltimoBianco);
		}
	}

	@Override
	public String toString() {
		listaDiPazienti();
		return "ProntoSoccorso{" + "lista=" + lista.toString() + '}';
	}
	
	
	public static void main(String[] args) {
		
		ProntoSoccorso prova=new ProntoSoccorso();
		//Paziente paziente=new Paziente("dif","leo","rosso");
		//prova.aggiungiPaziente(paziente);
		//prova.listaDiPazienti();
		System.out.println(prova.toString());
	}
	
}
