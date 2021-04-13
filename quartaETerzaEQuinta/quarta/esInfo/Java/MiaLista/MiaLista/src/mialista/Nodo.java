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
class Nodo {
	
	protected int info;
	protected Nodo link;

	public Nodo(int info, Nodo link) {
		this.info = info;
		this.link = link;
	}

	public int getInfo() {
		return info;
	}

	public Nodo getLink() {
		return link;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public void setLink(Nodo link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Nodo{" + "info=" + info + ", link=" + link + '}';
	}
	
	
}
