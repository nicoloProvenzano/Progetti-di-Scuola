/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palla;

/**
 *
 * @author Nicolo'
 */




 class PallaComune {

    protected int durezza;
    protected int grandezza;
    
    public PallaComune(int durezza,int grandezza){
        
        this.grandezza=grandezza;
        this.durezza=durezza;
        }
    
    public int quantoviaggiaveloce(){
    
    return 15;
    }
    
    
    
    @Override
    public String toString() {
        return "Palla{" + "durezza=" + durezza + ", grandezza=" + grandezza + "cm"+'}';
        }
    
    }
    
    class PallaDaCalcio extends PallaComune{
        
        protected String diCheSquadraE;
        
    
        public PallaDaCalcio(int durezza, int grandezza,String diCheSquadraE) {
            super(durezza, grandezza);
            this.diCheSquadraE=diCheSquadraE;
        }

        @Override
        public String toString() {
            return "PallaDaCalcio{"+"e' della squadra"+" " + diCheSquadraE + ", grandezza=" + grandezza + ", durezza=" + durezza + '}';
        }

    }

    
    
   
    public class Palla{
    
    public static void main(String[] args) {
        
        PallaComune persona2 = new PallaComune(5,6);
        System.out.println(persona2.toString());
        PallaDaCalcio persona = new PallaDaCalcio(2,3,"juve");
        System.out.println(persona.toString());
        System.out.println(persona.quantoviaggiaveloce()+"km/h");
    }
    
}
