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
public class ClothingException extends Exception{
	
	public ClothingException(String messaggio) {
		super(messaggio);
		//System.out.println("non e' lavabile");
	}
	
}
