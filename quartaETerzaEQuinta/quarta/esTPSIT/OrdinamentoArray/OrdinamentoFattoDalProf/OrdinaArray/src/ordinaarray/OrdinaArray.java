/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordinaarray;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Nicolo'
 */
public class OrdinaArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        Scanner in = new Scanner(System.in);
        
        System.out.println("dimensioni dell arraY");
        int n=in.nextInt();
        in.nextLine();
        
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=(int) (Math.random()*n);
        }
        System.out.println("numero di parti in cui dividere l'array");
        int p=in.nextInt();in.nextLine();
        
        System.out.println("array da ordinare"+Arrays.toString(a));
        
        long time = System.currentTimeMillis();
        
        int[]from=new int[p];
        int[] to= new int[p];
        int lp=n/p;
        
        
        for (int i = 0; i < p; i++) {
            from[i]=i*lp;
            to[i]=(i+p)*lp;
            
        }
        to[p-1]+=n%p;
        
        Thread[] t=new Thread[p];
        for(int i=0;i<p;i++){
        
            int fromIndex=from[i];
            int toIndex=to[i];
            t[i]=new Thread(){
        
                public void run(){
                
                    Arrays.sort(a, fromIndex, toIndex);
                }
            };
            t[i].start();
        }
        
        for(int i=0;i<p;i++){
            t[i].join();
            System.out.println("parte"+i+"ordinata:");
            System.out.println(Arrays.toString(Arrays.copyOfRange(a, from[i], to[i])));
        }
        
        int[] b = new int[n];
		for (int i = 0; i < n; i++)
		{	int j = 0;
			while (from[j] == to[j])
				j++;
			for (int k = j + 1; k < p; k++)
				if (from[k] < to[k] && a[from[k]] < a[from[j]])
					j = k;
			b[i] = a[from[j]];
			from[j]++;
		}
		time = System.currentTimeMillis() - time;
		
		//	Stampa dell'array ordinato:
		System.out.println("Array ordinato: " + Arrays.toString(b));
		
		//	Stampa del tempo impiegato per eseguire l'ordinamento:
		System.out.println("Tempo impiegato: " + time + " millisecondi");
    } 
    
}
