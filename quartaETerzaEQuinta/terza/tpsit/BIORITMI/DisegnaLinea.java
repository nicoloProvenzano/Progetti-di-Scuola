import java.awt.*;
import javax.swing.*;
 
public class DisegnaLinea extends JPanel {
   
  public static int R(int y)			// riflessione dell'asse y
   {  return -y;}						// si potrebbe usare questo comando  g.scale(1.0, -1.0);
                                        // ma poi non tutti i metodi grafici funzionano correttamente

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    int w= getWidth(); 
    int h= getHeight(); 
	
    g2.translate(0.5 * w, 0.5 * h);		// trasla le coordinate al centro del pannello 
    g2.drawLine(-w/2, 0,  w/2, 0);		// disegna gli assi cartesiani
    g2.drawLine( 0, -h/2,  0, h/2);
	
    g2.setColor(Color.BLUE);  
    int y=60;
       
    g2.drawString("Uno", 60, R(y));		// Scrive una stringa su ogni quadrante
    g2.drawString("Due", -60,R(y));
    g2.drawString("Tre", -60, -R(y));
    g2.drawString("Qua", 60, -R(y));
     	 
    g2.drawLine(-80, R(-30),  100, R(100));				// disegna una linea diagonale
  }
 
  public static void main(String[] args) {

    JFrame f = new JFrame("Disegna Linee");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setBounds( 300, 200, 400, 400);
    DisegnaLinea panel = new DisegnaLinea();
    f.add(panel);
    f.setVisible(true);
  }
}