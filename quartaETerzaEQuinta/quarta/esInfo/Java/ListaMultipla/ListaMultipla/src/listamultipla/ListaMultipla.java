/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listamultipla;

/**
 *
 * @author Nicolo'
 */
public class ListaMultipla {

        protected NodoBidirezzionale corrente;
	protected NodoBidirezzionale dx;
	protected NodoBidirezzionale sx;
        protected NodoBidirezzionale prec;
	protected int elementi;
	protected static int max;
	
	

	public ListaMultipla() {
		
		corrente=new NodoBidirezzionale(0,sx,dx,prec);
	}
        
        //lo inserisce a destra del nodo corrente
	public void inserisciDestra(NodoBidirezzionale n2) {

		NodoBidirezzionale appoggio;

		appoggio = corrente.destra;
		corrente.destra = n2;
		corrente.destra.destra = appoggio;
		System.out.println("il nodo a destra del nodo corrente e':"+corrente.destra);
	}
	//lo inserisce a sinistra del nodo corrente
	public void inserisciSinistra(NodoBidirezzionale n2) {

		NodoBidirezzionale appoggio;

		appoggio = corrente.sinistra;
		corrente.sinistra = n2;
		corrente.sinistra.sinistra = appoggio;
		System.out.println("il nodo a sinistra del nodo corrente e':"+corrente.sinistra);
	}
        //inserisco un nodo prececente al corrente
        public void inserisciPrec(){
        
        
        }
        //posso andare a destra, sinistra e al nodo padre rispetto al nodo corrente
        public void navigaTraNodi(){
        
            
        
        }
	
	//work in progress
	
	//inserisce ad una posizione specifica
	public void inserisciPos(NodoBidirezzionale nodoLista,NodoBidirezzionale nodoAgg,int pos){
	
		NodoBidirezzionale appoggio;
		//se lo voflio inserire all inizio
		if(pos==0){
		
			nodoLista.sinistra=nodoAgg;
		}
		//se lo voflio inserire alla fine
		else if(pos>=max){
		
			while(nodoLista.destra!=null){
			
					nodoLista=nodoLista.destra;
			}
			nodoLista.destra=nodoAgg;
		}
		//se lo voglio inserire nel mezzo
		else {
		
			for(int i=0;i<pos-1;i++){
		
				nodoLista=nodoLista.destra;
			}
			appoggio=nodoLista.destra;
			nodoLista.destra=nodoAgg;
			nodoAgg.destra=appoggio;
		}
		System.out.println(nodoAgg.sinistra);
	}
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
