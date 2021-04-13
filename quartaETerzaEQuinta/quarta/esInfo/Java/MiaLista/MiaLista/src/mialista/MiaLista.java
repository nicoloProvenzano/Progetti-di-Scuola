/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mialista;

/**
 *
 * @author nicolo.provenzano
 */
public class MiaLista {
	
	Nodo head;
	int elementi;

	public MiaLista() {
		head=new Nodo(0,null);
	}

	public void inserisciCoda(Nodo nodo){

		Nodo appoggio = null;

		if (nodo.link==null) {
			System.out.println(nodo);

		} else {
			appoggio = head;
			head = nodo;
			
			System.out.println("il nodo e' alla pos"+appoggio);
			inserisciTesta(head.link);
		}
	
	}

	public void inserisciTesta(Nodo nodo) {

		Nodo corrente = new Nodo(0,null);

		if (nodo.link==null) {
			System.out.println("fine");
			System.out.println("il nodo e' alla pos:"+nodo.info);

		} else {
			
			corrente=nodo;
			head = nodo.link;
			
			inserisciTesta(head);
			System.out.println("il nodo e' alla pos:"+corrente.info);
		}
	}
	
	public static void main(String[] args) {
		
		MiaLista lista= new MiaLista();
		Nodo n1=new Nodo(1,null);
		Nodo n2=new Nodo(2,n1);
		Nodo n3=new Nodo(3,n2);
		
		lista.inserisciTesta(n3);
	}
	
}
