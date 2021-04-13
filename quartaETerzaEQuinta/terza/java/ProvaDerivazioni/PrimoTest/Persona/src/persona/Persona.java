/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

import java.util.Scanner;

/**
 *
 * @author Nicolo'
 */
public class Persona {
    
    static Scanner tastiera = new Scanner(System.in);
    protected String nome;
    protected String cognome;
    protected static int cosaFare=0;
    
    public Persona(){
    
        System.out.println("Dimmi il nome");
        nome=tastiera.next();
        System.out.println("Dimmi il cognome");
        cognome=tastiera.next();
    
    }
    
    public Persona(String nome, String cognome){
    
        this.nome=nome;
        this.cognome=cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }
    
    public static int sceltaPersona(){
    
        int scelta;
        
        scelta=tastiera.nextInt();
        return scelta;
    }
    

    public static void main(String[] args) {
        
        while(cosaFare!=4){
            
            System.out.println("1 Per mettere uno studente");
            System.out.println("2 Per mettere un professore");
            System.out.println("3 Per mettere un personale atta");
            System.out.println("4 per uscire");
            cosaFare=sceltaPersona();
            
            if(cosaFare==1){
            
                Studente studente= new Studente();
                studente.setMedia();
                System.out.println("lo studente si chiama "+studente.getNome()+" "+studente.getCognome()+" ed ha la media del:"+studente.getMedia());
                System.out.println("");

            }
            
            if(cosaFare==2){
            
                Professore professore= new Professore();
                professore.setMateria();
                System.out.println("il professore si chiama "+professore.getNome()+" "+professore.getCognome()+" ed insegna "+professore.getMateria());
                System.out.println("");
            }
            
             if(cosaFare==3){
            
                PersonaleAtta bidello= new PersonaleAtta();
                bidello.setCompito();
                System.out.println("il bidello si chiama "+bidello.getNome()+" "+bidello.getCognome()+" e il suo compito e' "+bidello.getCompito());
                 System.out.println("");
            }
        }
    }
    
}
