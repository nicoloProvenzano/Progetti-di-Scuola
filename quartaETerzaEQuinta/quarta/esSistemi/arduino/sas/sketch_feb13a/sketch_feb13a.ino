long cambioStato1=0;
long cambioStato2=0;
long cambioStato3=0;

bool accesoSpento1=false;
bool accesoSpento2=false;
bool accesoSpento3=true;
long tempoCorrente=millis();

void setup() {
  pinMode(13,OUTPUT);
  pinMode(10,OUTPUT);
  pinMode(9,OUTPUT);

}

void loop() {

  funzione1();
  funzione3();
  funzione2();
}

void funzione1(){

  tempoCorrente=millis();

 if(accesoSpento1){

    if((tempoCorrente-cambioStato1)>=8000){
      
        digitalWrite(13,HIGH);
        accesoSpento1=!accesoSpento1;
        cambioStato1=tempoCorrente;
      }
  }
  else{
    
    if((tempoCorrente-cambioStato1)>=500){
      
        digitalWrite(13,LOW);
        accesoSpento1=!accesoSpento1;
        cambioStato1=tempoCorrente;
      }
    }
  
}

void funzione2(){
  
if(accesoSpento2){

    if((tempoCorrente-cambioStato2)>=3000){//lavora sul valore dui questo
      
        digitalWrite(10,HIGH);
        accesoSpento2=!accesoSpento2;
        cambioStato2=tempoCorrente;
      }
  }
  else{
    
    if((tempoCorrente-cambioStato2)>=5000){
      
        digitalWrite(10,LOW);
        accesoSpento2=!accesoSpento2;
        cambioStato2=tempoCorrente;
      }
    }

}

void funzione3(){
  
if(accesoSpento3){

    if((tempoCorrente-cambioStato3)>=5000){
      
        digitalWrite(9,HIGH);
        accesoSpento3=!accesoSpento3;
        cambioStato3=tempoCorrente;
      }
  }
  else{
    
    if((tempoCorrente-cambioStato3)>=2000){
      
        digitalWrite(9,LOW);
        accesoSpento3=!accesoSpento3;
        cambioStato3=tempoCorrente;
      }
    }

}
