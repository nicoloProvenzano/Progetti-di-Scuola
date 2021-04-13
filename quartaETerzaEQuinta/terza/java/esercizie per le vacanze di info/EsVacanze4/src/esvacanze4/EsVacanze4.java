/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esvacanze4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Nicolo'
 */
public class EsVacanze4 {
    
     protected String inizio;
     protected String fine;
    PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
    
    public EsVacanze4() throws FileNotFoundException, IOException{
     
    BufferedReader in= new BufferedReader(new FileReader("input.txt"));   
    inizio=in.readLine();
    in.close();
    }
    
    public void copiaTesto(){
    
    int j=0;    
    for(int i=0; i<inizio.length();i++){
        
        if(inizio.charAt(i)==' '){
            for(;j<i;j++){
            
               fine+=""+inizio.charAt(j);
               fine+=" ";
            }
            i++;
            j=i;
        }
    
    }
    
    
    }
    public void invertiTesto(){
        
    for(int i=inizio.length();i>0;i--){
        
        if(inizio.charAt(i)==' '){
            
          fine=fine+""+" ";
          }
          else{
            
              fine=fine+""+inizio.charAt(i);
              }
         }
      out.println(fine);
      out.close();
    }
    
    

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        EsVacanze4 frase = new EsVacanze4();
        frase.invertiTesto();
        
    }

}
