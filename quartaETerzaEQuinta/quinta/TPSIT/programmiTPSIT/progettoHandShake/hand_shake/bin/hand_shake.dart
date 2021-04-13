import 'dart:io';

void main() {
  HttpServer.bind(InternetAddress.anyIPv4, 8080).then((HttpServer server) {
    print("HttpServer listening...");
    server.serverHeader = "an echo server";
    server.listen((HttpRequest request) {
      // Checks whether the request is a valid WebSocket upgrade request
      if (WebSocketTransformer.isUpgradeRequest(request)){
        WebSocketTransformer.upgrade(request).then(handleWebSocket);
      }
      else {
        print("Regular ${request.method} request for: ${request.uri.path}");
        serveRequest(request);
      }
    });
  });
}

void handleWebSocket(WebSocket socket){
  print('Client connected!');
  socket.listen((data) {
    String msg = data.toString();
    print('Client sent: $msg');
    socket.add('echo: $msg');
  },
  onDone: () {
    print('Client disconnected');  
  });
}

void serveRequest(HttpRequest request){
  request.response.statusCode = HttpStatus.forbidden;
  request.response.reasonPhrase = "WebSocket connections only";
  request.response.close();
}

/* CLIENT https://en.wikipedia.org/wiki/WebSocket
* 
* curl -i -v -H 'Host: localhost:8080' \
* -H 'Upgrade: websocket' \
* -H 'Connection: Upgrade' \
* -H 'Sec-WebSocket-Key: x3JJHMbDL1EzLkh9GBhXDw==' \
* -H 'Sec-WebSocket-Version: 13' \
* -H 'Origin: http:localhost:8080' \
* localhost:8080
* 
*/