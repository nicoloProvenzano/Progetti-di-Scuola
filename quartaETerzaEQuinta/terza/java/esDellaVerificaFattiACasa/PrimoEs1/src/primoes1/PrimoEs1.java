/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primoes1;

/**
 *
 * @author Nicolo'
 */
public class PrimoEs1 {

    
    
    
    public static int nbDig(int n, int d){
       
        int j=0;
        int conta=0;
        if(d==0){
            
            conta++;
        }
        for(int i=0;i<=n;i++){
        
            j=i;
            j=j*j;

            while(j>0){
            
                if((j%10)==d){
                    
                    conta++;
                }
                
                j=j/10;
            }
            
        
        }
    
    
         System.out.println(conta);
         return conta;
    }
    
    
    
    
    public static void main(String[] args) {
        
        nbDig(10,0);
    }
    
}
