/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordinamentoarray;

import java.util.Arrays;

/**
 *
 * @author Nicolo'
 */
public class ThreadA extends Thread{
  
  //@Override
  public void run(int [] array){
   System.out.println("inizio ordinamento");
   Arrays.sort(array);
   System.out.println("ordinamento completato");
  }
}
