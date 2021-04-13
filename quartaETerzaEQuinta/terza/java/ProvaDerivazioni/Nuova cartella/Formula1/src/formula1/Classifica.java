/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formula1;

/**
 *
 * @author Nicolo'
 */


public class Classifica extends Piloti{
    

    
    public Classifica(){
    
        super();
    }
    

    
    public void getClassifica(){
        
        super.assegnaPunti();
    
        for(int i = 0; i < puntiPiloti.length; i++) {
                    
            for(int j = 0; j < puntiPiloti.length-1; j++) {

                if(puntiPiloti[j]>puntiPiloti[j+1]) {
                    
                    int k=puntiPiloti[j];
                    String y=piloti[j];
                    
                    puntiPiloti[j]=puntiPiloti[j+1];
                    piloti[j]=piloti[j+1];
                    
                    puntiPiloti[j+1]=k;
                    piloti[j+1]=y;
                     
                }
                

            }           
        }
         for(int i = 0; i < puntiPiloti.length; i++) {
         
             System.out.println("il pilota "+piloti[i]+" e' arrivato alla posizione n:"+(i+1));
         }
        
    }
    
    
    
    
}
