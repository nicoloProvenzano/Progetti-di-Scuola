/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdesignjava;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author nicolo.provenzano
 */
public class View extends JFrame{
	//metodo per creare e inizializzare la finestra e il bottone
	public View() {

        super("La mia finestra");
		setSize(400, 400);

        // Crea la finestra e il bottone
        JButton azzera = new JButton("azzera");
		JButton incrementa = new JButton("incrementa");

		//crea container e imposta il layout
		Container areaCentrale = getContentPane();
		areaCentrale.setLayout(new BorderLayout());
		
		//aggiunge bottoni
		areaCentrale.add(azzera,BorderLayout.NORTH );
		areaCentrale.add(incrementa,BorderLayout.SOUTH );
		
		//AscoltaFinestra af = new AscoltaFinestra();
		//addWindowListener(af);

		//rende visibile la finestra
		//e chiude la finestra quando
		//termina il programma
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}


