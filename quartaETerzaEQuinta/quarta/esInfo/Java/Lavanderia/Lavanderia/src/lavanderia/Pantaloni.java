/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lavanderia;

/**
 *
 * @author nicolo.provenzano
 */
public class Pantaloni extends Lavanderia {

	protected boolean lavabile;

	public Pantaloni(String pulitoOSporco, int taglia, String materiale) {

		super(pulitoOSporco, taglia, materiale);
		this.lavabile = super.generaLavabilita();
	}

	@Override
	public void pulisci(String pulitoOSporco) throws ClothingException {
		super.pulisci(pulitoOSporco); 	
	}
}
