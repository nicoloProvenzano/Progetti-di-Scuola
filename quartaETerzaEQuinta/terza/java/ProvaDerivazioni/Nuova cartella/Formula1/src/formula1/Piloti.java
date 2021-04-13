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

public class Piloti extends Scuderie{
    
    protected String[] piloti;
    protected int nPiloti;
    protected int[] puntiPiloti;
    protected int posPilota=0;
    
    public Piloti(){
    
        super();
        nPiloti=super.nScuderie*2;
        piloti=new String[nPiloti];
        puntiPiloti=new int[nPiloti];
    }
    
    public void setPiloti(){
    
        
        int j=0;
        for(int i=0;i<nPiloti;i=i+2){
        
            System.out.println("per la scuderia "+listaScuderie[j]+" il primo pilota e':"); 
            piloti[i]=tastiera.next();
            System.out.println("il secondo e':");
            piloti[i+1]=tastiera.next();
            j++;
        }
    }
    
    public String getPilota(){
    
        for(int i=0;i<nPiloti;i++){
        
            System.out.println(piloti[i]+" e' il pilota alla posizione: "+i); 
        }
        System.out.println("vuoi il pilota di che posizione?");
        posPilota=tastiera.nextInt();
        
        return piloti[posPilota];

    }
    
    public void assegnaPunti(){
        
        for(int conta=0;conta<nPiloti;){
    
             getPilota();
             
             if(puntiPiloti[posPilota]!=0){
        
                 System.out.println("a questo pilota e' gia stato assegnato un punteggio");
            
              } else{
                  
                  System.out.println("quanti punti ha preso questo pilota, ricorda che il punteggio varia tra 1 e 10");
                  puntiPiloti[posPilota]=tastiera.nextInt();
                  conta++;
                }
        }
        
    }
    
    //fare un metodo per avere il singolo pilota e un altro per assegnare i punti ai piloti
}
