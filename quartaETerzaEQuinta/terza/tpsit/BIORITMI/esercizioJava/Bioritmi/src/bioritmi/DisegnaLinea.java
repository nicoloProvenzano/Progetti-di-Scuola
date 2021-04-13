/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioritmi;

import java.awt.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.util.Scanner;
import java.util.Date;

public class DisegnaLinea extends JPanel {

    public static int R(int y) // riflessione dell'asse y
    {
        return -y;
    }						// si potrebbe usare questo comando  g.scale(1.0, -1.0);
    // ma poi non tutti i metodi grafici funzionano correttamente

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();

        g2.translate(0.5 * w, 0.5 * h);		// trasla le coordinate al centro del pannello 
        g2.drawLine(-w / 2, 0, w / 2, 0);		// disegna gli assi cartesiani
        //g2.drawLine(0, -h / 2, 0, h / 2);

        g2.setColor(Color.BLUE);
        int y = 60;

        //PARTE MIA
        int giorni = 0;
        Scanner scan = new Scanner(System.in);

        try {

           //INIZIALIZZAZIONE  
           System.out.println("dimmi la prima data in questo formato :yyyy/MM/dd ");
           //String data1 ="2000/01/10";
           String data1 =scan.next();
           System.out.println("dimmi la seconda data in questo formato :yyyy/MM/dd ");
           //String data2 ="2019/05/17";
           String data2 =scan.next();

           SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
           fmt.setLenient(false);

            //TRASFORMO LE DUE DATE
            Date d1 = fmt.parse(data1);
            Date d2 = fmt.parse(data2);

            //CALCOLO LA DISTANZA IN MILLISECONDI
            long millisDiff = d2.getTime() - d1.getTime();

            //TROVO LA DISTANZA IN GIORNI
            giorni = (int) (millisDiff / 86400000);
            System.out.println("giorni:" + giorni);

        } catch (Exception e) {
            System.out.println("data non valida, si ricorda di immetere la data nel formato yyyy/MM/dd");
        }

    //DISEGNO I GRAFICI

    //CHIEDO DI QUANTI GIORNI VOGLIO LA CURVA
    System.out.println("dimmi di quanti giorni vuoi la curva");
    int nDurata=scan.nextInt();
    
    //LIMITI DEI GIORNI
    int Lim[]= {23, 28, 33}; 
    //COLORI DEI GRAFICI
    Color col[]= {Color.red, Color.blue, Color.green};    
     
    //CICLO CHE VIEN UTILIZZATO PER FARE £ GRAFICI
    for (int i = 0; i<3 ; i++) { 
        
        //IMPOTSAZIONE DEL COLORE
        g2.setColor(col[i]);
        
        int xp= -w/2;
        //ASSEGNAMENTO ALLA VARIABILE Y DELLA FUNZIONE DEL SENO DEL CORRISPETTIVO GRAFICO
        int yp= -(int)(Math.sin( 6.28 *(-w/2+giorni)/Lim[i])*100);
        
        //CICLO PER DISEGNARE IL GRAFICO PER LA LUNGHEZZA DELLA FINESTRA
        for (int x = -w/2; x < w/2; x++) {
                
                //INIZIALIZZO LA X CONVERTITA CON IL VALORE DI X INIZIALE DELLO SCHERMO 
                //E AGGIUNGO IL VALORE DELLA DISTANZA IN GIORNI TRA LA DATA DI NASCITA E 
                //QULLA CORRENTE PER AVEREIL GRAFICO CHE INIZIA DALLA DATA DI OGGI
                double xConv= (double) (x + giorni);
                
                double corpo=-Math.sin( 6.28 *xConv/Lim[i])*100;
                
                int funzione=(int) corpo;
                g2.drawLine(xp*nDurata, yp,  x*nDurata,funzione);
                
                xp= x;
                yp= funzione;

            }     
        }
    }

    public static void main(String[] args) {

        JFrame f = new JFrame("Disegna Linee");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setBounds(300, 200, 1000, 600);
        DisegnaLinea panel = new DisegnaLinea();
        f.add(panel);
        f.setVisible(true);
    }
}
