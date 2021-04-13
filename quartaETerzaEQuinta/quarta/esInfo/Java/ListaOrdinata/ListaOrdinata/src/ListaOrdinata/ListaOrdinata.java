/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaOrdinata;

/**
 *
 * @author nicolo.provenzano
 */
public class ListaOrdinata {

	/**
	 * @param args the command line arguments
	 */
	
	private Nodo head;
	private int elementi;

	public ListaOrdinata(Nodo head) {
		this.head = head;
		this.elementi = 1;
	}

	public ListaOrdinata(Nodo head, int elementi) {
		this.head = head;
		this.elementi = elementi;
	}

	public int getElementi() {
		return elementi;
	}

	public boolean isEmpty() {
		return (elementi == 0);
	}

	public void inserisciTesta(Nodo nodo) {
		Nodo tmp;
		if (head == null) {
			head = nodo;
			elementi++;
		} else {
			tmp = head;
			head = nodo;
			nodo.setLink(tmp);
			elementi++;
		}
	}

	public void inserisciCoda(Nodo nodo) {
		if (head == null) {
			inserisciTesta(nodo);
		} else {
			Nodo tmp = head;
			while (tmp.getLink() != null) {
				tmp.getLink();
			}
			tmp.setLink(nodo);
			nodo.setLink(null);
			elementi++;
		}
	}

	public void sortedIns(Nodo nodo) {
		if (head == null) {
			inserisciTesta(nodo);
		} else {
			Nodo tmpInf = head;
			Nodo tmpSup = head;
			tmpSup = tmpSup.getLink();
			for (int i = 0; i < nodo.getInfo(); i++) {
				tmpInf.getLink();
				tmpSup.getLink();
				if (tmpInf.getInfo() < nodo.getInfo() && tmpSup.getInfo() > nodo.getInfo()) {
					tmpInf.setLink(nodo);
					nodo.setLink(tmpSup);
				}
			}
			elementi++;
		}
	}
	
	
	public Nodo getNextNodo(Nodo nodo){
	
		return nodo.link;
	}
		
	@Override
	public String toString() {
		String s = "";
		s = "Lista Ordinata di numero elementi: "+getElementi()+"\n";
		Nodo temporaneo=head;
		
		for(int i=0;i<this.getElementi();i++){
			s = s + temporaneo.toString()+"\n";
			temporaneo = temporaneo.getLink();
			//temporaneo=temporaneo.link;
		}
		return s;
	}
	public static void main(String[] args) {
		Nodo n = new Nodo(6,null);
		Nodo n1 = new Nodo(5);
		Nodo n4 = new Nodo(4);
		Nodo n2 = new Nodo(3);
		Nodo n3 = new Nodo(7,null);
		ListaOrdinata lista = new ListaOrdinata(n);
		lista.inserisciTesta(n2);
		//lista.inserisciCoda(n3);
		lista.sortedIns(n1);
		lista.sortedIns(n4);
		
//		System.out.println("Numero elementi nella lista: " + lista.getElementi());
//		for(int i=0;i<lista.getElementi();i++){
//		
//			System.out.println(lista.toString(i));
//		}
		
		System.out.println(lista.toString());
	}

}