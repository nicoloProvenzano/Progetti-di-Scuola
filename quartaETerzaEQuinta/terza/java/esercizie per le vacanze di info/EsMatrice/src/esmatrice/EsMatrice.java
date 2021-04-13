/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esmatrice;

import java.util.Random;

/**
 *
 * @author Nicolo'
 */
public class EsMatrice {

protected int x;
protected int y;
protected int n;
protected int matrice[][];
protected int nValori=0;
protected int valori[];

public EsMatrice(int n){
    
this.n=n;
this.matrice=new int[n][n];
int nMassimo=n*n;
this.valori=new int[nMassimo];
y=0;
x=0;

}

public void fill(){

Random m=new Random();
for(int i=0;i<n;i++){
    for(int j=0;j<n;j++){
    
        matrice[i][j]=m.nextInt(91);
        System.out.println(matrice[i][j]);
       }
   }   

}


public void confronta() throws IndexOutOfBoundsException{
    
    try{
    
 for(y=0;y<n;y++){
    for(x=0;x<n;x++){

if(y==0){
  if(x==0){
    if((matrice[x][y]>matrice[x+1][y+1])&&(matrice[x][y]>matrice[x][y+1])&&(matrice[x][y]>matrice[x+1][y])){
       valori[nValori]=matrice[x][y];
       nValori++;
    }
  }else if(x==(n-1)){
          if((matrice[x][y]>matrice[x-1][y+1])&&(matrice[x][y]>matrice[x][y+1])&&(matrice[x][y]>matrice[x-1][y])){
             valori[nValori]=matrice[x][y];
             nValori++;
          }
  }
}else if(y==(n-1)){
         if(x==0){
            if((matrice[x][y]>matrice[x+1][y-1])&&(matrice[x][y]>matrice[x+1][y])&&(matrice[x][y]>matrice[x][y-1])){
                valori[nValori]=matrice[x][y];
                nValori++;
               }
           }else if(x==(n-1)){
                   if((matrice[x][y]>matrice[x-1][y-1])&&(matrice[x][y]>matrice[x-1][y])&&(matrice[x][y]>matrice[x][y-1])){
                   valori[nValori]=matrice[x][y];
                   nValori++;
                  }

                 }
}else if((x==0)&&(y!=0)||(x==0)&&(y!=(n-1))){
        if((matrice[x][y]>matrice[x+1][y+1])&&(matrice[x][y]>matrice[x][y+1])&&(matrice[x][y]>matrice[x+1][y])&&(matrice[x][y]>matrice[x][y-1])&&(matrice[x][y]>matrice[x+1][y-1])){
       valori[nValori]=matrice[x][y];
       nValori++;
           }
         }else if((x==(n-1))&&(y!=0)||(x==(n-1))&&(y!=(n-1))){
                 
                  if((matrice[x][y]>matrice[x][y+1])&&(matrice[x][y]>matrice[x-1][y+1])&&(matrice[x][y]>matrice[x-1][y])&&(matrice[x][y]>matrice[x-1][y-1])&&(matrice[x][y]>matrice[x][y-1])){
                     valori[nValori]=matrice[x][y];
                     nValori++;
                     }  
                 }else{
                       if((matrice[x][y]>matrice[x-1][y-1])&&(matrice[x][y]>matrice[x][y-1])&&(matrice[x][y]>matrice[x+1][y-1])&&(matrice[x][y]>matrice[x-1][y])&&(matrice[x][y]>matrice[x+1][y])&&(matrice[x][y]>matrice[x-1][y+1])&&(matrice[x][y]>matrice[x][y+1])&&(matrice[x][y]>matrice[x+1][y+1])){
                         valori[nValori]=matrice[x][y];
                         nValori++;
                        
                         }  
                      }
           }
               
      }
    }catch(IndexOutOfBoundsException e){
        
        System.out.println("hai immesso troppi valori");
   }
}

    public int getnValori() {
        return nValori;
    }

    public String getValori() {
        
        for(int i=0;((i<valori.length) && (valori[i]!=0));i++){
        
            System.out.println(valori[i]);
        }
        return "fine";
    }



    
    
    
    public static void main(String[] args) {
  
        EsMatrice prova=new EsMatrice(4);
        prova.fill();
        prova.confronta();
        System.out.println("ecco quanti numeri max ci sono");
        System.out.println(prova.getnValori());
        System.out.println("ecco i numeri max");
        System.out.println(prova.getValori());
    }
    
}
