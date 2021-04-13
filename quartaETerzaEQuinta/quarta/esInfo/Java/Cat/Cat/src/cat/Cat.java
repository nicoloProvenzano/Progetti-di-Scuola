/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author nicolo.provenzano
 */
public class Cat {

	protected String nome;
	private int eta;
	
	
	//TUTTI I COSTRUTTORI
	
	public Cat(){
	
		nome="Tom001";
		eta=4;
	}
	
	public Cat(String nome){
	
		this.nome=nome;
		eta=4;
	}

	public Cat(String nome, int eta) {
		
		this.nome = nome;
		this.eta = eta;
	}

	public Cat(int eta) {
		
		nome="Tom001";
		this.eta = eta;
	}
	
	
	//TUTTI I METODI GET

	public int getEta() {
		return eta;
	}

	public String getNome() {
		return nome;
	}
	
	//TUTTI I METODI SET

	public void setNome(String nome) {
		
		if((nome.length()!=0))
			this.nome = nome;
		else
			this.nome="Tom001";
	}

	public void setEta(int eta) {
		
		if(eta<0)
			this.eta = eta;
		else
			eta=4;
	}
	
	//METODO EQUALS PER NOME ED ETA

	@Override
	public int hashCode() {
		int hash = 7;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Cat other = (Cat) obj;
		if (this.eta != other.eta) {
			return false;
		}
		if (!Objects.equals(this.nome, other.nome)) {
			return false;
		}
		return true;
	}
	
	
	//METODO EQUALS PER LA CLASSE
	public boolean equals(Cat cat) {
		
		boolean b1;
		boolean b2;

		b1=nome.equals(cat.getNome());
		b2=(cat.getEta()==getEta());
		
		if(b1==true || b2==true){
		
			return true;
		}
		return false;
	}
	
	//METODO TO STRING

	@Override
	public String toString() {
		return "Cat{" + "nome=" + nome + ", eta=" + eta + '}';
	}
	

	public static void main(String[] args) {
		// TODO code application logic here
	}
	
}
