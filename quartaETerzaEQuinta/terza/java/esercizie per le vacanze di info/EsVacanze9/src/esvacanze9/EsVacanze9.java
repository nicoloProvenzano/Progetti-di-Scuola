/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esvacanze9;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Nicolo'
 */
public class EsVacanze9 {

protected int nColline;
protected ArrayList<Integer> colline=new ArrayList<Integer>(10);    
protected int nValli;
Scanner sc=new Scanner(System.in);

public EsVacanze9(int nColline){

this.nColline=nColline;

}

public void riempiLista()throws IndexOutOfBoundsException{

try{    
int altezza;    
for(int i=0;i<nColline;i++){
   altezza=sc.nextInt();
   colline.add(altezza);
   }
}catch(IndexOutOfBoundsException e){
    System.out.println("hai immesso troppi numeri");
}

}


public int quanteValliCiSono(){

int difMin=300;    
for(int i=0;i<(nColline-1);i++){
   if(abs((colline.get(i)-colline.get(i+1)))>=difMin){
     nValli++;
     }
   }
return nValli;
}


    
    public static void main(String[] args) {
    
    EsVacanze9 montanaro = new EsVacanze9(3);
    montanaro.riempiLista();
    System.out.println(montanaro.quanteValliCiSono());
    }
    
}
