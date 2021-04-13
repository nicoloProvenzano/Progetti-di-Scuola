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
public class Vino {
    
    public Vino(){}
    
	@Override
	public String toString(){
            
		return " una bottiglia di vino";
	}
        
        public String gradoAlcolico(String grado){
        
            return "il grado e' "+grado;
        }
}