#include <Servo.h>
#include <Keypad.h>

Servo motore; //il servo che deve comèpiere l'azione
int angolo=0;
int angoloMax=90;

const byte ROWS = 4; //4 righe
const byte COLS = 4; //4 colonne
char keys[ROWS][COLS] = 
{
  {'1','2','3','A'},
  {'4','5','6','B'},
  {'7','8','9','C'},
  {'*','0','#','D'}
};

byte rowPins[ROWS] = {9, 8, 7, 6}; // Pin di arduino connessi ai pin 1,2,3 e 4 delle righe del keypad
byte colPins[COLS] = {5, 4, 3, 2};    // Pin di arduino connessi ai pin 5,6,7 e 8 delle righe del keypad

Keypad keypad = Keypad( makeKeymap(keys), rowPins, colPins, ROWS, COLS );

char caratterePremuto='o';
String password;

void setup()
{
  motore.attach(10);
  Serial.begin(9600);
  motore.write(angolo);
  pinMode(12, OUTPUT);
}

void loop(){

  Serial.println("premi # per immetere una nuova combinazione ");
  Serial.println("premi A per aprire ");
  Serial.println("premi C per chiudere ");
  char pulsantePremuto=keypad.waitForKey();
  
  if(pulsantePremuto=='#'){
      resettaPassword();
    }
    else
  if(pulsantePremuto=='A'){
      aperturaCassaforte();
    }
    else
  if(pulsantePremuto=='C'){
      chiusuraCassaforte();
    }
  }

  void resettaPassword(){

      password="";
      int i=0;
      while( i<10 )
      {
        Serial.println("premi un pulsante che vuoi aggiungere alla combinazione ");
        password=password+keypad.waitForKey();
        i=i+1;
        if(i>4 && password!='*')
        {
           i=10;
        }
      }
      digitalWrite(12, HIGH); // turn the LED on (HIGH is the voltage level)
      delay(500); // wait for a second
      digitalWrite(12, LOW); // turn the LED off by making the voltage LOW
      delay(500); // wait for a half second
      digitalWrite(12, HIGH); // turn the LED on (HIGH is the voltage level)
      delay(500); // wait for a half second
      digitalWrite(12, LOW); // turn the LED off by making the voltage LOW
      //Serial.println("password aggionata ");
  }

  void aperturaCassaforte(){

    String combinazione="";
    char tastoPremuto="";
    int tentativi=0;
    bool corretto=false;
    
    while(tentativi<3){
      
      Serial.println("premi un pulsante");
      tastoPremuto=keypad.waitForKey();
      
      if(tastoPremuto=='*')
       {
          if(combinazione.equals(password))
          {
            Serial.println("aperto");
            delay(20);
            motore.write(angoloMax);
            corretto=true;
            tentativi=3;
          }
          else tentativi++;
          digitalWrite(12, HIGH); // turn the LED on (HIGH is the voltage level)
          delay(500); // wait for a second
          digitalWrite(12, LOW); // turn the LED off by making the voltage LOW
          delay(500); // wait for a half second
          digitalWrite(12, HIGH); // turn the LED on (HIGH is the voltage level)
          delay(500); // wait for a half second
          digitalWrite(12, LOW); // turn the LED off by making the voltage LOW
        }
      combinazione=combinazione+tastoPremuto;
    }
    if(!corretto)
    {
    //Serial.println("errato");
    digitalWrite(12, HIGH); // turn the LED on (HIGH is the voltage level)
    delay(10000); // wait for 10 second
    digitalWrite(12, LOW); // turn the LED off by making the voltage LOW
    }
    
    combinazione="";
  }

  void chiusuraCassaforte(){

    String combinazione="";
    char tastoPremuto="";
    while(tastoPremuto!='*'){
      
      Serial.println("premi un pulsante");
      tastoPremuto=keypad.waitForKey();
      combinazione=combinazione+tastoPremuto;
    }
          if(combinazione.equals(password))
          {
            Serial.println("chiuso");
            delay(20);
            motore.write(angolo);
          }
          else{
            digitalWrite(12, HIGH); // turn the LED on (HIGH is the voltage level)
            delay(500); // wait for a half second
            digitalWrite(12, LOW); // turn the LED off by making the voltage LOW
            delay(500); // wait for a half second
            digitalWrite(12, HIGH); // turn the LED on (HIGH is the voltage level)
            delay(500); // wait for a half second
            digitalWrite(12, LOW); // turn the LED off by making the voltage LOW
            }
      combinazione="";
  }

//void loop()
//{
//  for(angolo=0;angolo<angoloMax;angolo++){
//  
//    motore.write(angolo);
//    delay(20);
//  }
//}
