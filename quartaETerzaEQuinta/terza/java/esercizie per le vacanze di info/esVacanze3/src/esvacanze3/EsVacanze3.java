/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esvacanze3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Nicolo'
 */
public class EsVacanze3 {
    
protected ArrayList<Integer> insieme1 = new ArrayList<Integer>(10);
protected ArrayList<Integer> insieme2 = new ArrayList<Integer>(10);
protected ArrayList<Integer> insieme3 = new ArrayList<Integer>(20);

    public void aggiungiInsieme1(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("quanti umeri vuoi massimo 10");
        int j=keyboard.nextInt();
        for(int z=0;z<j;z++){
           System.out.println("che numero vuoi?");
           int i=keyboard.nextInt();
           insieme1.add(i);
        }

    }
    public void aggiungiInsieme2(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("quanti umeri vuoi massimo 10");
        int j=keyboard.nextInt();
        for(int z=0;z<j;z++){
           System.out.println("che numero vuoi?");
           int i=keyboard.nextInt();
           insieme2.add(i);
        }
    }


public void aggiungi1Insime1(){

    Scanner tastiera= new Scanner(System.in); 
    System.out.println("che numero vuoi aggiungere?");
    int i=tastiera.nextInt();
    System.out.println("a che posizione lo vuoi? ricordati il massimo e' 9");
    int j=tastiera.nextInt();
    insieme1.add(j, i);
}    
public void aggiungi1Insime2(){

    Scanner tastiera= new Scanner(System.in); 
    System.out.println("che numero vuoi aggiungere?");
    int i=tastiera.nextInt();
    System.out.println("a che posizione lo vuoi? ricordati il massimo e' 9");
    int j=tastiera.nextInt();
    insieme2.add(j, i);
}   

public void togli1Insime1(){

    Scanner tastiera= new Scanner(System.in); 
    System.out.println("che numero vuoi togliere?");
    int i=tastiera.nextInt();
    System.out.println("a che posizione lo vuoi? ricordati il massimo e' 9");
    int j=tastiera.nextInt();
    insieme1.remove(i);
}    
public void togli1Insime2(){

    Scanner tastiera= new Scanner(System.in); 
    System.out.println("che numero vuoi togliere?");
    int i=tastiera.nextInt();
    System.out.println("a che posizione lo vuoi? ricordati il massimo e' 9");
    int j=tastiera.nextInt();
    insieme2.remove(i);
}    

public void unione(){     
    
insieme3.addAll(insieme1);
insieme3.addAll(insieme2);
    System.out.println(insieme3);
}

public void intersezzione(){
    
insieme1.removeAll(insieme2);
insieme2.removeAll(insieme1);
    System.out.println(insieme2);
}



       
        
    public static void main(String[] args) {
        // TODO code application logic here
        
        EsVacanze3 insimei=new EsVacanze3();
        
        
    }
    
}
