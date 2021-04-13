int ledPin = 13;
int pulsante = 7;
int altoOBasso = 0;
int contatore = 0;

void setup() {

  pinMode(ledPin, OUTPUT);
  pinMode(pulsante, INPUT);
}

void loop() {

  altoOBasso = digitalRead(pulsante);

  if (contatore == 1) {

    digitalWrite(ledPin, HIGH);
    delay(1000);
    digitalWrite(ledPin, LOW);
    delay(1000);
    if (altoOBasso == 1) {

      contatore++;
    }
  }

  else if (contatore == 2) {

    digitalWrite(ledPin, HIGH);
    delay(500);
    digitalWrite(ledPin, LOW);
    delay(500);
    if (altoOBasso == 1) {

      contatore++;
    }
  }

  else if (contatore == 3) {

    digitalWrite(ledPin, HIGH);
    delay(1500);
    digitalWrite(ledPin, LOW);
    delay(1500);
    if (altoOBasso == 1) {

      contatore = 0;
    }
  }
  else if (contatore == 0) {

    digitalWrite(ledPin, LOW);
    if (altoOBasso == 1) {

      contatore++;
    }
  }
}



