/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubrica;

/**
 *
 * @author Nicolo'
 */
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Nicolo'
 */
public class Contatto {
    
    //tutti gli attributi
    String nome="";
    String email="";
    String numeroDiTelefono="";
    
    
    //costruttore automatico
    public Contatto(String nome,String email,String NumeroDiTelefono) {
        
    this.nome=nome;
    this.email=email;
    this.numeroDiTelefono=NumeroDiTelefono;
        
    }
    
    public Contatto(int valore){}//costuttore per creare un oggetto con i parametri a 0 e null
    
    //costruttore per utente
    public Contatto() {
        
        Scanner tastiera = new Scanner(System.in);
        
        System.out.println("adesso ti chiedero' le varie informazioni riguardo al contatto");
        
        System.out.println("diimmi il nome");
        nome=tastiera.next();
        
        System.out.println("dimmi la email");
        email=tastiera.next();
        
        System.out.println("dimmi il numero");
        numeroDiTelefono=tastiera.next();

        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contatto other = (Contatto) obj;
        if (this.numeroDiTelefono != other.numeroDiTelefono) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    
}

