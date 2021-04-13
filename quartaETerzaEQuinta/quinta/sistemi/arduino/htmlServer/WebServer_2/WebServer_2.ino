#include <SPI.h>
#include <Ethernet.h>

byte mac[] = {
  0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0x0D
};
IPAddress ip(192, 168, 8, 163);

EthernetServer server(80);

String acceso="off";
int pin;

void setup() {

  Serial.begin(9600);

  Ethernet.begin(mac, ip);

  server.begin();
  
  Serial.print("server is at ");
  Serial.println(Ethernet.localIP());

  acceso=false;
  pin=2;
}


void loop() {
  EthernetClient client = server.available();
  if (client) {
    Serial.println("new client");
    boolean currentLineIsBlank = true;  
    while (client.connected()) {
      if (client.available()) {
        char c = client.read();
        
        Serial.write(c);
        
         if (c == '\n' && currentLineIsBlank) {
          
          client.println("HTTP/1.1 200 OK");
          client.println("Content-Type: text/html");
          client.println("Connection: close");  // the connection will be closed after completion of the response
          client.println();
          client.println("<!DOCTYPE HTML>");
          client.println("<html>");
          client.println("<head>");
          client.println("<title>prova per il prof</title>");
          client.println("</head>");
          client.println("<body>");
          client.println("<h1>Accensione led arduino da html</h1>");
          client.println("<form action='/https://192.168.8.163/?bottone' method='GET'>");
          client.println("<button name='bottone' type='submit' value='on'>on</button>");
          client.println("<button name='bottone' type='submit' value='off'>off</button>");
          client.println("</form>");
          client.println("</body>");
          client.println("</html>");
          break;
        }
        if (c == '\n') {
    
          currentLineIsBlank = true;
          
        } else if (c != '\r') {
          
          currentLineIsBlank = false;
        }

        accensioneLed(client);
      }
    }
    // give the web browser time to receive the data
    delay(1);
    // close the connection:
    client.stop();
    Serial.println("client disconnected");
  }
}



void accensioneLed(EthernetClient cl)
{    
    if (acceso=="off") {//LED spento
      
        digitalWrite(pin, LOW);//spengo
        cl.println("led spento");
    }
    else {// LED acceso
      
        digitalWrite(pin, HIGH);//accendo
        cl.println("led acceso");
    }
}
