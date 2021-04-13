/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formula1;



public class Pista extends Formula1{
    
    protected String pista;
    protected int lunghezza;
    protected String location;
    
    public Pista(){

    }

    public String getPista() {
        return pista;
    }

    public void setPista() {
        System.out.println("dimmi il nome della pista");
        pista=tastiera.next();
    }

    public int getLunghezza() {
        return lunghezza;
    }

    public void setLunghezza() {
        System.out.println("dimmi la lunghezza della pista");
        lunghezza=tastiera.nextInt();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation() {
        System.out.println("dimmi dove si tiene la gara");
        location=tastiera.next();
    }
    
}
