/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esverifican2;

/**
 *
 * @author Nicolo'
 */
public class EsVerificaN2 {

    public static boolean isBilanciato(int n){
        
        String str=n+"";
        int lung=(str).length();
        boolean pari=false;
        String parte1="";
        String parte2="";
        int parte1Int=0;
        int parte2Int=0;
		
		if(lung<=2){
			if(lung==1){
				return false;
			}
			return true;
		}
 //guardo se è pari
        if(lung%2==0)
            pari=true;

        if(!pari){
//tolgo la parte in mezzo
            parte1=str.substring(0,lung/2 );
            parte2=str.substring(lung/2+1, lung);
//inizializzo le due parti intere con cui farò il confronto            
            for(int i=0;i<str.length()/2;i++){
            
                parte1Int+=(parte1.charAt(i)-'0');
            }
            
            for(int i=0;i<str.length()/2;i++){
            
               parte2Int+=(parte2.charAt(i)-'0');
            }
//confronto            
            if(parte2Int==parte1Int){return true;}
            return false;
        }
        
        else {
//tolgo la parte in mezzo        
         parte1=str.substring(0,lung/2-1 );
         parte2=str.substring(lung/2+1, lung);
//inizializzo le due parti intere con cui farò il confronto         
         for(int i=0;i<str.length()/2-1;i++){
            
                parte1Int+=(parte1.charAt(i)-'0');
            }
            
         for(int i=0;i<str.length()/2-1;i++){
            
               
               parte2Int+=(parte2.charAt(i)-'0');
            }
//confronto      
            if(parte2Int==parte1Int){return true;}
            
            return false;
        }
        
    }
    
    
    
    public static void main(String[] args) {
       
        System.out.println(isBilanciato(2112));
        
    }
    
}
