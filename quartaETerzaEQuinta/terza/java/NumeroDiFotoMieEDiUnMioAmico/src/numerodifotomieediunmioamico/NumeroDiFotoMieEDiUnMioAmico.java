/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerodifotomieediunmioamico;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author Nicolo'
 */

public class NumeroDiFotoMieEDiUnMioAmico {
    
    protected int nFoto;
    protected int[] foto;
    Scanner tastiera= new Scanner(System.in);        

     String str = "Facebook.com 13 + 3.0 = 16 true";  
     Scanner scanner = new Scanner(str);                
          
    public  NumeroDiFotoMieEDiUnMioAmico(int nFoto){
        
        this.nFoto=nFoto;   
        foto=new int[nFoto];
    }
    
    public  NumeroDiFotoMieEDiUnMioAmico( ){
    
        System.out.println("quante foto totali hai?");
        nFoto=tastiera.nextInt();
        foto=new int[nFoto];
    }
    
    
    public void inserisciFoto(int numeroFotoCorrente) {
        
        //dichiarazione variabile di appoggio
        int valoreFornito=0;
        
        System.out.println("inserisci 1 per le tue foto e due 2 per le foto del tuo amico");
        
            for(int i=0;i<nFoto;){
                
                System.out.println("numero foto rimanenti:"+(nFoto-i));
                System.out.println(""); 
                valoreFornito=tastiera.nextInt();
                    
                if(valoreFornito==1 || valoreFornito==2){
                        
                    foto[i]=valoreFornito;
                    i++;
                }
                      
                else{
                        
                    System.out.println("i valori devono essere compresi tra 1 e 2");
                }
            }
            System.out.println(""); 
    }
    
    public void contaFoto(){
        
        int fotoMie=0;
        int fotoAmico=0;
        
        inserisciFoto(0);
        
        for(int i=0;i<foto.length;i++){
        
            if(foto[i]==1) fotoMie++;
            
            else fotoAmico++;
        }
        System.out.println("Il tuo numero di foto e': " + fotoMie+ ",mentre quello del tuo amico e': "+fotoAmico);
    }
    
    public static void main(String[] args) {
        
        NumeroDiFotoMieEDiUnMioAmico test = new NumeroDiFotoMieEDiUnMioAmico();
        //NumeroDiFotoMieEDiUnMioAmico test = new NumeroDiFotoMieEDiUnMioAmico(8);
        test.contaFoto();
    }
    
}
