/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listabidirezzionale;

/**
 *
 * @author nicolo.provenzano
 */
public class ListaBidirezzionale {

	protected NodoBidirezzionale head;
	protected NodoBidirezzionale tail;
	protected int elementi;
	protected static int max;
	
	

	public ListaBidirezzionale() {
		
		head=new NodoBidirezzionale(0,tail,null);
		tail=new NodoBidirezzionale(0,null,head);
	}

//	public void inserisciCodaRicorsiva(NodoBidirezzionale nodo) {
//
//		if (nodo.successivo == null) {
//			
//			System.out.println("il nodo e' alla pos:" + nodo.info);
//			
//		} else {
//			
//			tail = nodo.successivo;
//			System.out.println("il nodo e' alla pos:" + nodo.info);
//			inserisciCodaRicorsiva(tail);
//		}
//	}
//
//	public void inserisciTestaRicorsiva(NodoBidirezzionale nodo) {
//
//		if (nodo.successivo==null) {
//			
//			System.out.println("il nodo e' alla pos:"+nodo.info);
//			
//		} else {
//			
//			head = nodo.successivo;
//			inserisciTestaRicorsiva(head);
//			System.out.println("il nodo e' alla pos:"+nodo.info);
//		}
//		
//	}
	//lo inserisce prima del nodo dato
	public void inserisciTesta(NodoBidirezzionale n2) {

		NodoBidirezzionale appoggio;

		appoggio = head;
		head = n2;
		head.successivo = appoggio;
		System.out.println("il nodo alla pos:" + n2.info);
	}
	//lo inserisce dopo il nodo dato
	public void inserisciCoda(NodoBidirezzionale n2) {

		NodoBidirezzionale appoggio;

		appoggio = head.successivo;
		head.successivo = n2;
		n2.successivo = appoggio;
		System.out.println("il nodo alla pos:" + n2.info);
	}
	
	//work in progress
	
	//inserisce ad una posizione specifica
	public void inserisciPos(NodoBidirezzionale nodoLista,NodoBidirezzionale nodoAgg,int pos){
	
		NodoBidirezzionale appoggio;
		//se lo voflio inserire all inizio
		if(pos==0){
		
			nodoLista.precedente=nodoAgg;
		}
		//se lo voflio inserire alla fine
		else if(pos>=max){
		
			while(nodoLista.successivo!=null){
			
					nodoLista=nodoLista.successivo;
			}
			nodoLista.successivo=nodoAgg;
		}
		//se lo voglio inserire nel mezzo
		else {
		
			for(int i=0;i<pos-1;i++){
		
				nodoLista=nodoLista.successivo;
			}
			appoggio=nodoLista.successivo;
			nodoLista.successivo=nodoAgg;
			nodoAgg.successivo=appoggio;
		}
		System.out.println(nodoAgg.precedente);
	}

    @Override
    public String toString() {
        return "ListaBidirezzionale{" + "elementi=" + elementi + '}';
    }
        
        
//end work in progress
	
	public static void main(String[] args) {
		
		ListaBidirezzionale lista= new ListaBidirezzionale();
		NodoBidirezzionale n1=new NodoBidirezzionale(1,null,null);
		max++;
		NodoBidirezzionale n2=new NodoBidirezzionale(2,null,null);
		max++;
		NodoBidirezzionale n3=new NodoBidirezzionale(3,null,null);
		max++;
		NodoBidirezzionale n4=new NodoBidirezzionale(3,null,null);
		max++;
		lista.inserisciTesta(n1);
		lista.inserisciCoda(n2);
		lista.inserisciCoda(n3);
		lista.inserisciPos(n1,n4,5);
	}
	
}
