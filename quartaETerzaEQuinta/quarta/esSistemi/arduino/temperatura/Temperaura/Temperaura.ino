void setup() {
  Serial.begin(9600);
}

void loop() {
  delay(500);
  float aR=analogRead(A0);
  float mV=(5000*aR)/1023;
  float C=mV/10;
  Serial.println(C);
}
