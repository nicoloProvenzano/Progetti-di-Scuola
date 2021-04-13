/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esvacanze6;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Nicolo'
 */
public class EsVacanze6 {
 
    Scanner tastiera = new Scanner(System.in);
    protected int lista3[]= new int[100];
    protected int lista2[]=new int[5];
    protected int lista1[]=new int[5];
    protected int nValori1;
    protected int nValori2;
    protected int nValori3;
    
    public EsVacanze6(){
        
        System.out.println("dimmi quanti valori vuoi per il primo array");
        int nValori1=tastiera.nextInt();
        this.nValori1=nValori1;
        System.out.println("dimmi quanti valori vuoi per il secondo array");       
        int nValori2=tastiera.nextInt();
        this.nValori2=nValori2;
        this.nValori3=(nValori2+nValori1);
      
    }
    
    public void numeriRandom() throws IndexOutOfBoundsException{
        try{
           Random rand = new Random(10);
           for(int i=0;i<nValori1;i++){
           lista1[i]=rand.nextInt();
           }
           for(int i=0;i<nValori2;i++){
           lista2[i]=rand.nextInt(10);
           }
        }catch(IndexOutOfBoundsException e){
            System.out.println("hai superato la soglia massima di valori inseribili");
        }
    
    }
    
    public int[] merge() throws IndexOutOfBoundsException{
    
    try{
        int j=0;
        int e=0;
        for(int i=0;i<nValori3;i++){
            if(e==nValori1){
            
                for(;i<nValori3;i++){
                lista3[i]=lista2[j];
                j++;
                
                }
            
            }else if(j==nValori2){
            
            for(;i<nValori3;i++){
                lista3[i]=lista1[e];
                e++;
                }
            }
            if(lista1[e]<lista2[j]){
            lista3[i]=lista1[e];
            e++;
            }
            else{ 
                lista3[i]=lista2[j];
                j++;
            }
        }
    }catch(IndexOutOfBoundsException e){
            System.out.println("hai superato massa la soglia massima di valori inseribili");
        }
        return lista3;
    }
    
    
    
    public static void main(String[] args) {
        EsVacanze6 listaDefinitiva=new EsVacanze6();
        listaDefinitiva.numeriRandom();
        System.out.println(listaDefinitiva.merge());
    }
    
}
