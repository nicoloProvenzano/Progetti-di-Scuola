/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formula1;


public class Scuderie extends Formula1{
    
    
    protected String[] listaScuderie;
    protected int nScuderie;
    
    public Scuderie(){
    
        System.out.println("quante scuderi ci sono");
        nScuderie=tastiera.nextInt();  
        listaScuderie=new String[nScuderie];
        
    }

    public void getListaScuderie() {
        
       System.out.println("ecco la lista delle scuderie");
       for(int i=0;i<nScuderie;i++){
           
            System.out.println(listaScuderie[i]);
        }
    }

    public void setListaScuderie() {
        
        for(int i=0;i<nScuderie;i++){
        
            System.out.println("dimmi una scuderia");
            listaScuderie[i]=tastiera.next();
        }
    }
    
    
    
}
