/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lavanderia;

import java.util.Random;

/**
 *
 * @author nicolo.provenzano
 */
public class Lavanderia {

	protected String pulitoOSporco;
	protected int taglia;
	protected String materiale;

	public Lavanderia(String pulitoOSporco, int taglia, String materiale) {
		this.pulitoOSporco = pulitoOSporco;
		this.taglia = taglia;
		this.materiale = materiale;
	}

	public boolean isLavabile(boolean lavabile) {

		if (!lavabile) return false;
		return true;

	}
	public boolean generaLavabilita(){
	
		Random rand=new Random();
		int n=0;
		
		if((n=rand.nextInt(2))==1)return true;
		else return false;
	
	}
	
	public void pulisci(String pulitoOSporco) throws ClothingException {

		if (pulitoOSporco.equals("sporco")) {
			
			if (isLavabile(generaLavabilita())) {

				pulitoOSporco = "pulito";
				System.out.println("e' stato pulito il capo");
			} else {
				throw new ClothingException("non e' lavabile perche' ha un tessuto troppo delicato");
			}
		} else {
			System.out.println("e' gia' pulito");
		}
	}

	public static void main(String[] args) throws ClothingException {

		Lavanderia maglietta=new Maglietta("sporco",4,"cotone");
		maglietta.pulisci("sporco");
	}

}
