/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;


public class PersonaleAtta extends Persona{
    
    protected String compito;
    
    public PersonaleAtta(){
    
        super();
    }
    public PersonaleAtta(String nome, String cognome){
    
        super(nome, cognome);
    }   

    public String getCompito() {
        return compito;
    }

    public void setCompito() {
        
        System.out.println("dimmi che compito ha");
        compito=tastiera.next();
    }
    
    
    
}
