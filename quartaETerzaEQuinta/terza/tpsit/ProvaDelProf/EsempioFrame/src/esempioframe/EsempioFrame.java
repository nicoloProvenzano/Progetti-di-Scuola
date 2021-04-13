/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esempioframe;

import java.awt.*;
import javax.swing.*;


/**
 *
 * @author NICOLO.PROVENZANO
 */
public class EsempioFrame {

    /**
     * @param args the command line arguments
     */
     public static void main (String args[]){   
         
        JFrame  f= new JFrame("Prova Frame");    
        f.setBounds(200,100, 300,150);        
        f.setVisible(true); 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
     }
    
}
