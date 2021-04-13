import 'dart:io';

// for echo server run: dart es009_web_socket_client.dart ws://localhost:8080

WebSocket ws;

void main(List<String> args) {

  args[0]='localhost:8080';
  
  if (args.length < 1) {
    print('Please specify a server URI. ex ws://example.org');
    exit(1);
  }

  var server = args[0];

  //Open the websocket and attach the callbacks
  WebSocket.connect(server).then((WebSocket socket) {
    ws = socket;
    ws.listen(onMessage, onDone: connectionClosed);
  });

  //Attach to stdin to read from the keyboard
  stdin.listen(onInput);
}

void onMessage(data) {
  String message = data.toString();
  print(message);
}

void connectionClosed() {
  print('Connection to server closed');
}

void onInput(List<int> input) {
  String msg = new String.fromCharCodes(input).trim();

  //Exit gracefully if the user types 'quit'
  if (msg == 'quit') {
    ws.close();
    exit(0);
  }
  // write msg
  ws.add(msg);
}
