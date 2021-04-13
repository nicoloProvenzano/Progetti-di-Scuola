#include <SPI.h>
#include <Ethernet.h>

byte mac[] = {
  0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0x11
};
IPAddress ip(192, 168, 8, 167);
EthernetServer server(80);
String header;
String acceso = "on";


void setup() {
  pinMode(7, OUTPUT);
  digitalWrite(7, LOW);
  Serial.begin(9600);
  Ethernet.begin(mac, ip);
  server.begin();
  Serial.print("server is at ");
  Serial.println(Ethernet.localIP());
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
          client.println("<title>Web Led Client</title>");
          client.println("</head>");
          client.println("<body style='background-color: cornsilk'>");
          
          client.println("<div style='text-align: center; background-color: red'><a href=\'/off'><button>ON</button></a></div>");
          client.println("<div style='text-align: center; background-color: green'><a href=\'/on'><button>OFF</button></a></div>");
            
          client.println("</body>");
          client.println("</html>");
          delay(1);
          break;
        }
        if (c == '\n') {
          currentLineIsBlank = true;
          if (header.indexOf("GET on") >= 0) {//header.indexof() è la posizione nell'URL e il GET cerca nell'URL "on" e restituisce la posizione di dove l'ha trovato
            Serial.println("led acceso");
            acceso = "on";
            digitalWrite(7, HIGH);
          }
          else if (header.indexOf("GET off") >= 0) {
            Serial.println("led spento");
            acceso = "off";
            digitalWrite(7, LOW);
          }
        } else if (c != '\r') {
          currentLineIsBlank = false;
        }
      }
    }
    // give the web browser time to receive the data
    delay(1);
    // close the connection:
    client.stop();
    Serial.println("client disconnected");
  }
}
