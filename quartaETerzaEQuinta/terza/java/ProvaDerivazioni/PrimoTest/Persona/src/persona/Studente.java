/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

/**
 *
 * @author Nicolo'
 */
public class Studente extends Persona {
    
    protected String classe;
    protected String matricola;
    protected int media;
    
    public Studente(){
    
    super();
    
    }
    
    public Studente(String nome, String cognome){
    
        super(nome, cognome);
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse() {
        System.out.println("dimmi la classe di appartenenza");
        classe=super.tastiera.next();
        
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola() {
        System.out.println("dimmi la matricola");
        matricola=super.tastiera.next();
        
    }

    public int getMedia() {
        return media;
    }

    public void setMedia() {
        System.out.println("dimmi la media");
        media=super.tastiera.nextInt();
       
    }
    
    
    
}
