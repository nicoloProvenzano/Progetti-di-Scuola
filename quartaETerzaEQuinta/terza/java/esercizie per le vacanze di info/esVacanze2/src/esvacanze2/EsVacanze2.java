/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esvacanze2;

/**
 *
 * @author Nicolo'
 */
public class EsVacanze2 {
    
    protected String oIn;
    protected int oreIn;
    protected int minutiIn;
    protected int secondiIn;
    protected String Vdappoggio;
    
    public EsVacanze2(String oIn){
    this.oIn=oIn;
    
    
    }
    
    public int getOre(){
    for(int i=0;i<oIn.length();i++){
        if(oIn.charAt(i)==':'){
            Vdappoggio=""+oIn.charAt(i-2);
            oreIn=Integer.parseInt(Vdappoggio)*10;
            Vdappoggio=""+oIn.charAt(i-1);
            oreIn+=Integer.parseInt(Vdappoggio);
            return oreIn;
        }
    }
    return 0;
    }
   public int getMinuti(){
    for(int i=0;i<oIn.length();i++){
        if(oIn.charAt(i)==':'){
            Vdappoggio=""+oIn.charAt(i+1);
            minutiIn=Integer.parseInt(Vdappoggio)*10;
            Vdappoggio=""+oIn.charAt(i+2);
            minutiIn+=Integer.parseInt(Vdappoggio);
            return minutiIn;
        }
    }
    return 0;
    }
 
   public int getSecondi(){
    for(int i=0;i<oIn.length();i++){
        if(oIn.charAt(i)==':'){
            Vdappoggio=""+oIn.charAt(i+4);
            secondiIn=Integer.parseInt(Vdappoggio)*10;
            Vdappoggio=""+oIn.charAt(i+5);
            secondiIn+=Integer.parseInt(Vdappoggio);
            return secondiIn;
        }
    }
    return 0;
    }
   
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EsVacanze2 tempo= new EsVacanze2("22:14:34");
        System.out.println(tempo.getOre());
        System.out.println(tempo.getMinuti()); 
        System.out.println(tempo.getSecondi());
    }
    
}
