/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

public class Professore extends Persona{
    
    protected String materia;
    
    public Professore (){
    
        super();
    }
    
    public Professore (String nome, String cognome){
    
        super(nome, cognome);
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria() {
        System.out.println("che materia insegna?");
        materia=super.tastiera.next();
      
    }

}
