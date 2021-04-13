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
	Nodo tail;
	int elementi;

	public MiaLista() {
		
		head=new Nodo(0,null);
		tail=new Nodo(0,null);
	}

	public void inserisciCodaRicorsiva(Nodo nodo) {

		if (nodo.link == null) {
			
			System.out.println("il nodo e' alla pos:" + nodo.info);
			
		} else {
			
			tail = nodo.link;
			System.out.println("il nodo e' alla pos:" + nodo.info);
			inserisciCodaRicorsiva(tail);
		}
	}

	public void inserisciTestaRicorsiva(Nodo nodo) {

		if (nodo.link==null) {
			
			System.out.println("il nodo e' alla pos:"+nodo.info);
			
		} else {
			
			head = nodo.link;
			inserisciTestaRicorsiva(head);
			System.out.println("il nodo e' alla pos:"+nodo.info);
		}
		
	}
	
	public void inserisciTesta(Nodo n1,Nodo n2) {
		
			n2.link=n1;
			System.out.println("il nodo alla pos:"+n2.info);
			System.out.println("il nodo alla pos:"+n1.info);
	}
	
	public void inserisciCoda(Nodo n1,Nodo n2) {
		
			n1.link=n2;
			System.out.println("il nodo alla pos:"+n1.info);
			System.out.println("il nodo alla pos:"+n2.info);
	}
	
	public void inserisciPos(Nodo nodoLista,Nodo nodoAgg,int pos){
	
		Nodo appoggio;
		
		if(pos==0){
		
			nodoAgg.link=nodoLista;
		}
		else {
		
			for(int i=0;i<pos-1;i++){
		
				nodoLista=nodoLista.link;
			}
			appoggio=nodoLista.link;
			nodoLista.link=nodoAgg;
			nodoAgg.link=appoggio;
		}
	}
	
	
	public static void main(String[] args) {
		
		MiaLista lista= new MiaLista();
		Nodo n1=new Nodo(7,null);
		Nodo n2=new Nodo(5,n1);
		Nodo n3=new Nodo(3,n2);
		//lista.inserisciTesta(n1,n2);
		//lista.inserisciCoda(n1,n2);
		//lista.inserisciTestaRicorsiva(n3);
		//lista.inserisciCodaRicorsiva(n3);
		Nodo n4=new Nodo(6,null);
	}
	
}
