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
public class Nodo {
	protected int info;
	protected Nodo link;

	public Nodo(int info) {
		this.info = info;
		this.link = null;
	}
	
	public Nodo(int info, Nodo link) {
		setInfo(info);
		setLink(link);
	}
	

	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public Nodo getLink() {
		return link;
	}

	public void setLink(Nodo link) {
		this.link = link;
	}

	@Override
	public String toString() {
		
		return "Nodo : {" + "info = " + getInfo() + '}';
	}
}
