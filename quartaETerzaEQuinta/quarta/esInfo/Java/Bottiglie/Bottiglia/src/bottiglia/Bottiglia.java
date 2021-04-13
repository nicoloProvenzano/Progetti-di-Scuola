/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bottiglia;

/**
 *
 * @author Nicolo'
 */

public class Bottiglia<T> {
    
    private T contenuto;
    
    public Bottiglia(T t){
        
	contenuto=t;
    }
    public T getContenuto() {
        
        return contenuto;
    }
}
    

