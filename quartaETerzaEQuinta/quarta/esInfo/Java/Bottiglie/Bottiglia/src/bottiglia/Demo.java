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
public class Demo {
    
	public static void main(String[] args) {
            
		Bottiglia<Acqua> bottiglia1= new Bottiglia<Acqua>(new Acqua());
		Bottiglia<Vino>  bottiglia2= new Bottiglia<Vino>(new Vino());
		BraccioAutomatico braccio = new BraccioAutomatico();
		braccio.prendiBottiglia(bottiglia1);
		braccio.prendiBottiglia(bottiglia2);
                
	}
}
