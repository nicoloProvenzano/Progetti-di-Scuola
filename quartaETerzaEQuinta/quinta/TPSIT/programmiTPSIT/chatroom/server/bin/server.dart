import 'dart:core';
import 'dart:io';

ServerSocket server;
List<ChatClient> clients = [];

void main() {
  ServerSocket.bind(InternetAddress.anyIPv4, 3000).then((server) {
    server.listen((client) {
      handleConnection(client);
    });
  });
}

//Funzione che connette l'IP del server e l'IP del client tra loro.
//Crea un client e lo aggiunge alla lista dei client collegati al server
void handleConnection(Socket client) {
  print('handleConnection ----------------');

  print('Connection from ${client.remoteAddress.address}:${client.remotePort}');
  var u = ChatClient(client);
  clients.add(u);
  print('numero utenti connessi: ' + clients.length.toString());
  if (clients.length > 1) {
    print('Ci sono più utenti connessi');
    u.write(clients.toString());
  }

  print('\handleConnection ----------------');
}

//Funzione utilizzata per distribuire il messaggio a tutti i client collegati alla lista dei client
void distributeMessage(ChatClient client, String message) {
  for (ChatClient c in clients) {
    if (c != client) {
      c.write(message);
    }
  }
}

//Funzione utilizzata per rimuovere un client dalla lista dei client
void removeClient(ChatClient client) {
  clients.remove(client);
}

class ChatClient {
  Socket socket;
  String get ip => socket.remoteAddress.address;
  int get port => socket.remotePort;
  var username;

  ChatClient(Socket s) {
    this.socket = s;
    socket.listen(messageHandler,
        onError: errorHandler, onDone: finishedHandler);
  }

//Funzione utilizzata per creare il formato corretto del messaggio da salvare nel server.
  void messageHandler(data) {
    print('MessageHandler ----------------');

    String message = new String.fromCharCodes(data).trim();
    print('Message: ' + message);
    var split;
    print('distribuite');
    distributeMessage(this, message);

    print('\MessageHandler ----------------\n');
  }

//Funzione che restituisce un messaggio di errore nel caso in cui la porta del server non corrisponde alla porta del client
  void errorHandler(error) {
    print('${ip}:${port} Error: $error');
    removeClient(this);
    socket.close();
  }

//Funzione che restituisce un messaggio di "fine connessione" quando il client si disconnette dal server.
//Il client disconnesso viene automaticamente eliminato dalla lista dei client presente nel server.
  void finishedHandler() {
    print('${ip}:${port} Disconnected');
    distributeMessage(this, '$username disconnected.');
    removeClient(this);
    socket.close();
  }

//Funzione utilizzata per create il messaggio del client.
  void write(String message) {
    print('Metodo write ChatClient: ' + message.toString());
    socket.write('$message');
  }

  String toString() {
    return ('$username');
  }
}

