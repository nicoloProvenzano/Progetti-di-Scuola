/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esverifica3;

import static java.util.Arrays.sort;

/**
 *
 * @author Nicolo'
 */
public class EsVerifica3 {

    public static int cifrePiuPresenti(int []array){
        
        int[] ripetizioni=new int[array.length];
        int frequenzaMax=0;
        String strRisultato="";
        int risultato=0;
        
        //ciclo per trovare le frequenze
        for(int i=0;i<array.length;i++){
        
            ripetizioni[array[i]]++;
        }
        //ciclo per trovare la frequenza massima
        for(int i=0;i<array.length;i++){
        
            if(frequenzaMax<ripetizioni[i]){
            
                frequenzaMax=ripetizioni[i];
            }
        }
        //ciclo per trovare i nmeri con frequenza massima
        for(int i=array.length-1;i>=0;i--){
        
            if(frequenzaMax==ripetizioni[i]){
            
                strRisultato+=i+"";
            }
            
        } 
        
        risultato=Integer.parseInt(strRisultato);
        System.out.println(risultato);
        return risultato;
    }
    
    
    
    public static void main(String[] args) {
      
         cifrePiuPresenti(new int[]{1,3,0,1,0,5,3,4});
    }
    
}
