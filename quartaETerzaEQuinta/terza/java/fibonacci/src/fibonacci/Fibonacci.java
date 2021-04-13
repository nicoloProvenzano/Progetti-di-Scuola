/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

/**
 *
 * @author Nicolo'
 */
public class Fibonacci {

 private int t;
 private int n;
 private int fibo[];
 protected int i;
 protected int val;
 protected int f;
 protected int res[];
   
 public Fibonacci() {
    this.t=20;
    this.fibo= new int[30]; 
    i=0;
    f=0;
    this.n=n;
}
    public void somma(){
        for(int j=0;j<t;j++){
            this.n=19;
            
            while(fibo[i]<n){
                val=fibo[i];
                i++;
            }
         while(i!=0){
             val=fibo[i];
             if(fibo[i]<n){
                 res[f]=1;
                 n=n-val;
             }
             else res[f]=0;
             f++;
             i--;
   
         }
        }
}
}
    class main{
    public static void main(String[] args) {
      Fibonacci mio=new Fibonacci();
      mio.somma();
    }
    
}
//lol//