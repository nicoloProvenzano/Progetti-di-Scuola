/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poligoni;
/**
 *
 * @author Nicolo'
 */
public class Quadrato extends Poligoni{
    
    public Quadrato(double lato, int numeroLati) {
        super(lato, numeroLati);
        
    }
    public Quadrato(double lato){
    
        this(lato,4);
    }
    
    public double area(){
    
        return lato*lato;
    }
    
    
}
