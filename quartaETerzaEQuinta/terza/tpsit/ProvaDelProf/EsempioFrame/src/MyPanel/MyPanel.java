/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPanel;

/**
 *
 * @author NICOLO.PROVENZANO
 */

 
import java.awt.*; import javax.swing.*;  

public class MyPanel extends JPanel {  
  
   int lato=10;
   int x=0;
   int y=0;
   int cont=0;
   
  public MyPanel(){
  
     
  }
    
//viene mandato in esecuzione automaticamente
 public void paintComponent(Graphics g) {
       
   
//     
//     while(lato>0){
//     
//        g.drawRect(x, y, lato, lato);
//        x=x+5;
//        y=y+5;
//        lato=lato-10;
//     }

  
    g.drawOval(x, y, lato, lato);
    
    if(x<=100 && cont<100){
        x=x+5;
        cont=cont+5;
    }
    else{
        x=x-5;
        if(x==0){
            cont=0;
        }
    }
  
 }
 
  public static void main(String[] args) throws InterruptedException {    
      
      JFrame f = new JFrame("creo quadrati");  
      //metodo per uscire schiacciando la x in alto a destra
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      //metodo per impostare la gradezza della finestra
      f.setSize(100, 100);    
      
      MyPanel panel = new MyPanel();  
      //aggiungo il pannello alla finestra
      f.add(panel);  
      //rendo visibile la finestra
      f.setVisible(true);  
      
      Thread t= new Thread();
      while(1>0){
      
         f.repaint();
         t.sleep(200);
      }
      
  }
 
 
}