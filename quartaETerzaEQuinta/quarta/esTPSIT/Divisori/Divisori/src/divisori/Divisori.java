/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package divisori;

import java.util.Scanner;

/**
 *
 * @author nicolo.provenzano
 */
public class Divisori extends Thread{

	Scanner tastiera=new Scanner(System.in);
	int max=0;
	int divisori[][];
	
	public Divisori(){
	
		max=tastiera.nextInt();
		divisori=new int[10][max];
	}
	
	public void trovaDivisori(int numero){
	
		int e=0;
		System.out.println("divisori per il numero "+numero+" sono:");
		for(int i=1;i<=numero;i++){
		
			if(numero%i==0){
			
				System.out.println(i);
				divisori[e][numero]=i;
				e++;
			}
		}
		System.out.println("\n");
	}
	
	public void run(){  
		
		for(int i=1;i<max;i++){
		
			trovaDivisori(i);
		}
	}  
	
	public static void main(String[] args) {
		
		Divisori t1=new Divisori();  
		t1.start();  
	}
	
}
