
long tempoCorrente=millis();
long tempo1=0;
long tempo2=0;
long tempo3=0;

bool accesoOspento1=false;
bool accesoOspento2=false;
bool accesoOspento3=false;

void setup() {

pinMode(13,OUTPUT);
pinMode(12,OUTPUT);
pinMode(11,OUTPUT);

}

void loop() {

 tempoCorrente=millis();
 if((tempoCorrente-tempo1)>=1000){

  if(!accesoOspento1)
    digitalWrite(13, HIGH);
    else  digitalWrite(13, LOW);
    accesoOspento1=!accesoOspento1;

    tempo1=tempoCorrente;
  }

 if((tempoCorrente-tempo2)>=3000){

  if(!accesoOspento2)
    digitalWrite(12, HIGH);
    else  digitalWrite(12, LOW);
    accesoOspento2=!accesoOspento2;

    tempo1=tempoCorrente;
  }

 if((tempoCorrente-tempo3)>=4000){

  if(!accesoOspento3)
    digitalWrite(11, HIGH);
    else  digitalWrite(11, LOW);
    accesoOspento3=!accesoOspento3;

    tempo3=tempoCorrente;
  }

}
