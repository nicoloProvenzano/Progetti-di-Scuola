/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poligoni;


interface Figura {

  double perimetro();
  double area();
}



public abstract class Poligoni implements Figura{
    
    
    protected double lato;
    protected int numeroLati;
    
    public Poligoni(double lato,int numeroLati){
    
        this.lato=lato;
        this.numeroLati=numeroLati;
    }
    
    @Override
    public double perimetro(){
    
        return lato*numeroLati;
    
    }

 
    public static void main(String[] args) {
        
        
        
    }
    
}
