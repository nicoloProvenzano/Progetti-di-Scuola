#include <LiquidCrystal.h>
LiquidCrystal lcd(12, 11, 5, 4, 3, 2);

int switchState=0;

void setup() {
  lcd.begin(16,2);
}

void loop() {
  delay(500);
  lcd.clear();
  lcd.setCursor(0,0);
  lcd.print("Temperatura:");
  lcd.setCursor(0,1);
  
  float aR=analogRead(A0);
  float mV=(5000*aR)/1023;
  float C=mV/10;
  float K=C+273;
  float F=(C*9/5)+32;

  lcd.print(C);
  
}
