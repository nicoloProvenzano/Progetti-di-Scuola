/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contaparole;

import java.util.Scanner;

/**
 *
 * @author Nicolo'
 */
public class ContaParole {

   String frase;
   String parola;
   char spazio='/';
   
   void ContaParole(){
   Scanner tastiera = new Scanner(System.in);
   this.frase=tastiera.next();
   
   }
   
   public String staccaParole(){
       
   for(int i=0;frase.charAt(i)!=spazio;i++){
       parola=parola+frase.charAt(i);
      }
   return parola;
   }
    
    
    
    public static void main(String[] args) {
        
        ContaParole bo=new ContaParole();
        bo.ContaParole();
        System.out.println(bo.staccaParole());
    }
    
}
