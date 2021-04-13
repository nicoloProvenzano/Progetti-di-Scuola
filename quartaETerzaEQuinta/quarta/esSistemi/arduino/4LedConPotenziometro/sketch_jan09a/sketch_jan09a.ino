int Ledpin3 = 9;
int Ledpin1 = 5;
int Ledpin2 = 6;
int Ledpin4 = 11;
int potentiometerPin = 0;
int value = 0;


void setup() {

  Serial.begin(9600);
  pinMode(Ledpin1, OUTPUT);
  pinMode(Ledpin2, OUTPUT);
  pinMode(Ledpin3, OUTPUT);
  pinMode(Ledpin4, OUTPUT);
}

void loop(){

  value = analogRead(potentiometerPin); // leggo valore potenziometro
  Serial.println(value); // scrivo il valore sulla seriale come debugging
  delay(500);

  if(value==0){
    
    digitalWrite(Ledpin1, LOW); //Il led è acceso

    digitalWrite(Ledpin2, LOW);
    

    digitalWrite(Ledpin3, LOW);


    digitalWrite(Ledpin4, LOW);

    }

  else if(value<=255){
    
    digitalWrite(Ledpin1, HIGH); //Il led è acceso


    digitalWrite(Ledpin2, LOW);

    

    digitalWrite(Ledpin3, LOW);



    digitalWrite(Ledpin4, LOW);

  }

  else if(value<=510){
    
    digitalWrite(Ledpin1, HIGH);

        
    digitalWrite(Ledpin2, HIGH);

    digitalWrite(Ledpin3, LOW);

    digitalWrite(Ledpin4, LOW);
  }
  
  else if(value<=765){
    
    digitalWrite(Ledpin1, HIGH);
        
    digitalWrite(Ledpin2, HIGH);
    
    digitalWrite(Ledpin3, HIGH);

    digitalWrite(Ledpin4, LOW);
  }

  else if(value<=1023){
    
    digitalWrite(Ledpin1, HIGH);
        
    digitalWrite(Ledpin2, HIGH);
    
    digitalWrite(Ledpin3, HIGH);

    digitalWrite(Ledpin4, HIGH);
  }

}

