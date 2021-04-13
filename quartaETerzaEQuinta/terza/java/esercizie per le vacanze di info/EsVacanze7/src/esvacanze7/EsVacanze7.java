/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esvacanze7;

/**
 *
 * @author Nicolo'
 */
public class EsVacanze7 {
    
    protected int mese;
    protected int giorniAnno;
    protected int anno;
    protected int giorni;
    protected String data;
    protected int anno1;
    protected int anno2;
    protected int giorniAggiuntivi;
    protected int fine;
    protected int giorno;
   
    
    public EsVacanze7(int anno1,int anno2,int mese,int giorno){
    
     this.anno1=anno1;   
     this.anno2=anno2;
     this.giorno=giorno;
     this.mese=mese;
     anno=anno1-anno2;
    }
    
  public int contaGiorniBisestili(){
  
  for(int i=anno;i>2;i=i-3){ 
    giorniAggiuntivi++;
    }
  return giorniAggiuntivi;
  } 
    
  /**public void nGiorni(){
      
      if(mese==2){
          if(isBisestile()){
              giorni=29;
          }else giorni=28;
      }
      if((mese==4)||(mese==6)||(mese==9)||(mese==11)){ 
         giorni=30;
      }else giorni=31;    
  }*/ 
  
  public boolean isBisestile(){
  
  if((anno%4)==0){
          if((anno%100)==0){
              if((anno%400)==0){
              return true;
              }else return false;
          }else return true;
      }else return false;
  }
  
  

 /** public void dammiIGiorniDellAnno(){
      
      if((anno%4)==0){
          if((anno%100)==0){
              if((anno%400)==0){
              giorniAnno=366;
              }else giorniAnno=365;
          }else giorniAnno=366;
      }else giorniAnno=365;
  }*/
  
  public int giorniDaSommare(){
  
  if(mese==2){
    return giorni=31+giorno;
  }
  else  if(mese==3){
    return giorni=59+giorno;
  }
  else  if(mese==4){
    return giorni=90;
  }
  else  if(mese==5){
    return giorni=120+giorno;
  }
  else  if(mese==6){
    return giorni=151+giorno;
  }  
  else  if(mese==7){
    return giorni=181+giorno;
  }  
  else  if(mese==8){
    return giorni=212+giorno;
  }
  else  if(mese==9){
    return giorni=243+giorno;
  }
  else  if(mese==10){
    return giorni=273+giorno;
  }  
  else  if(mese==11){
    return giorni=304+giorno;
  }  
  else  if(mese==12){
    return giorni=334+giorno;
  }else return giorni=giorno;   
  }
  
  
  
  public int sommaFinale(){

  return fine=(365*(anno-1))+contaGiorniBisestili()+giorniDaSommare();
  
  }
  
  
    
    
    public static void main(String[] args) {
       EsVacanze7 diffGiorni= new EsVacanze7(2001,1998,10,25);
        System.out.println(diffGiorni.sommaFinale());
        System.out.println("immetere prima il giorno piu' grande,poi quello piu' piccolo e dopo mettere il mese e i giorni del primo anno");
    }
    
}
