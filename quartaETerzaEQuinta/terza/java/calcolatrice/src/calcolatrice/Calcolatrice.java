/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcolatrice;

/**
 *
 * @author Nicolo'
 */
public class Calcolatrice {
    private double primoAddendo;
    private double secondoAddendo; 
    public Calcolatrice()
    {
        primoAddendo=4;
        secondoAddendo=3;
        this.primoAddendo=primoAddendo;
        this.secondoAddendo=secondoAddendo;
    }
    public void Selezione ()
    {
        int nVolte = 2;
        for(int i=0; i<nVolte;i++)
        {
            System.out.println("1 Addizione;2 Sottrazione;3 Moltiplicazione;4 Divisione");
        int selezione = 3;
        switch(selezione)
        {
            case 1: primoAddendo=primoAddendo+secondoAddendo;
            System.out.println(primoAddendo);
             case 2: primoAddendo=primoAddendo-secondoAddendo;
            System.out.println(primoAddendo);
             case 3: primoAddendo=primoAddendo*secondoAddendo;
            System.out.println(primoAddendo);
             case 4: primoAddendo=primoAddendo/secondoAddendo;
            System.out.println(primoAddendo);
        }
    }
    }
    }
    /**
     * @param args the command line arguments
     */
    class main {
    public static void main(String[] args) {
        Calcolatrice mio= new Calcolatrice();
        mio.Selezione();
        // TODO code application logic here
    }
    
}
