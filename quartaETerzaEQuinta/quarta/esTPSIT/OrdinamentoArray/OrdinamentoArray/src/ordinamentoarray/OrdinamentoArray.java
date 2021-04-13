/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordinamentoarray;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Nicolo'
 */
public class OrdinamentoArray {

    /**
     * @param args the command line arguments
     */
    ThreadA thread1 = new ThreadA();
    ThreadA thread2 = new ThreadA();
    int dimensione = 0;
    
    int[] array1;
    int[] array2;
    int[] array3;
    

    public void ordinamento() {
        
        
        Random random = new Random();

        Scanner tastiera = new Scanner(System.in);
        System.out.println("quanto grande lo vuoi l'array?");
        dimensione = (tastiera.nextInt()/2);

        array1 = new int[dimensione];
        array2 = new int[dimensione];
        array3 = new int[dimensione*2];
      
        for (int i = 0; i < (dimensione); i++) {

            array1[i] = random.nextInt(dimensione*2) + 1;
            array2[i] = random.nextInt(dimensione*2) + 1;
        }

        thread1.run(array1);
        thread2.run(array2);

        ordinamentoFinale(array1,array2);
        
        for(int i=0;i<array3.length;i++){
        
            System.out.println(array3[i]);
        }
        
    }
    
    public int[] ordinamentoFinale(int[] array1, int[] array2) {

    int i = 0, j = 0, k = 0;
    while (i < array1.length && j < array2.length)
    {
        if (array1[i] < array2[j])
        {
            array3[k] = array1[i];
            i++;
        }
        else
        {
            array3[k] = array2[j];
            j++;
        }
        k++;
    }

    while (i < array1.length)
    {
        array3[k] = array1[i];
        i++;
        k++;
    }

    while (j < array2.length)
    {
        array3[k] = array2[j];
        j++;
        k++;
    }

    return array3;
}
 
    public static void main(String[] args) {
        
           OrdinamentoArray demo = new OrdinamentoArray();
           demo.ordinamento();
           
    }
    
}

 
