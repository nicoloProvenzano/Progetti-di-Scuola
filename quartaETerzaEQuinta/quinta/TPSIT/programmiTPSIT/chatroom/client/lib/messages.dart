import 'dart:io';

import 'main.dart';
import 'package:flutter/material.dart';

class Messages extends StatefulWidget {
  Messages();

  @override
  MessagesState createState() => cavalloMessages = MessagesState();
} 

//Funzione per mostare icone pop up
//https://medium.com/@nils.backe/flutter-alert-dialogs-9b0bb9b01d28 && //https://api.flutter.dev/flutter/material/showDialog.html
//https://medium.com/flutter-community/flutter-alert-dialog-vs-dialog-in-your-flutter-application-11be20a2af


class MessagesState extends State<Messages> {
  

  void reload() {
    setState(() {});
  }

  // void socketConnector() {
    
  //   Socket.connect("localhost", 3000)
  //   .then((Socket sock) {
  //     s = sock;
  //     s.listen(
  //       dataHandler, 
  //       onError: errorHandler, 
  //       onDone: doneHandler, 
  //       cancelOnError: false);
  //   })
  //   .catchError((Error e) {
  //     print("Unable to connect: $e");
  //     exit(1);
  //   });

  // // connect standard in to the socket 
  // stdin.listen((data) => s.write(
  //   String.fromCharCodes(data).trim() + '\n'));

  // }


void dataHandler(data){
  print(String.fromCharCodes(data).trim());
}

void errorHandler(error, StackTrace trace){
  print(error);
}

void doneHandler(){
  s.destroy();
  exit(0);
}

  Widget sendMessageBuilder(var username, var messaggio, var ora) {
    //colonna dei messaggi
    return Column(
      //returno una colonna, ovvero un widget
      children: <Widget>[
        Row(children: <Widget>[
          Expanded(
            child: Container(),
          ),
          Container(
            //blocco del messaggio
            child: Column(
              children: <Widget>[
                Text(username,
                    style: TextStyle(fontSize: 15, color: Colors.blue)),
                Text(messaggio, style: TextStyle(fontSize: 20)),
                Text(ora, style: TextStyle(fontSize: 15)),
              ],
            ),
          ),
          Container(
            width: 20,
          ),
        ]),
        Container(
          height: 5,
        )
      ],
    );
  }

  Widget sendBox() {
    return Row(mainAxisAlignment: MainAxisAlignment.center, children: <Widget>[
      Flexible(
        flex: 1,
        child: Form(child: Container()),
      ),
      Flexible(
        flex: 8,
        child: Form(
          child: TextFormField(
            //tastiera virtuale
            style: TextStyle(color: Colors.black, fontFamily: 'SFUIDisplay'),

            decoration: InputDecoration(
                //decoratore della tastiera virtuale
                filled: true, //colore pieno
                hintText: 'Scrivi un messaggio...', //rubato da whatsapp
                labelStyle: TextStyle(fontSize: 18)),

            onChanged: (text) {
              //se il testo dentro la tastiera e' modificato
              setState(() {
                if (text != "")
                  messaggio =
                      text; //se il testo non e' vuoto aggiorno il messaggio
              });
            },
          ),
        ),
      ),
      Flexible(
        flex: 1,
        child: Form(child: Container()),
      ),
      Flexible(
        flex: 2,
        child: Column(
          children: <Widget>[
            Container(

              width: 50,
              height: 50,
              child:  FloatingActionButton(//bottone per inviare il messaggio

                child: Icon(Icons.send), //copiato da telegram
                backgroundColor: Colors.lightBlue,
                
                onPressed: () {
                  if (messaggio != "" && username != "") {
                    setState(() {
                      messaggi.add(sendMessageBuilder(
                          username,
                          messaggio,
                          TimeOfDay.now().hour.toString() +
                              "." +
                              TimeOfDay.now().minute.toString()));
                    });
                    s.write(username + '#' + messaggio);
                  }
                },
            )
            ),
          ],
        )
      )
    ]);
  }

  Widget title() {
    return Container( 

      padding: const EdgeInsets.only(left: 20,top:50),
      child:Text(
        "ButWomanNeverWing",
        style: TextStyle(
          fontSize: 30.0, fontWeight: FontWeight.bold, color: Colors.grey[500]),
        )
    );
  }

  Widget clearMessages() {
    //pulsante per cancellare tutti i messaggi
    return Container(
        width: 50,
        height: 50,
        child: FloatingActionButton(
          child: Icon(Icons.restore),
          backgroundColor: Colors.lightBlue,
          onPressed: () {
            setState(() {
              messaggi.clear();
            });
          },
        ));
  }

  Widget usernameLogin() {
    //pulsante per aprire la schermata di nome utente
    return Container(
        width: 50,
        height: 50,
        child: FloatingActionButton(
          child: Icon(Icons.login),
          backgroundColor: Colors.lightBlue,
          onPressed: () {
            loginPopUp();
          },
        ));
  }

  void loginPopUp() {
    //il metodo non returna niente ma lo showdialog per come e' fatto retruna un widget che e' un allrt diaog o un altro tipo di dialog
    showDialog(
      context: context,
      barrierDismissible: false,
      builder: (BuildContext context) {
        return AlertDialog(
          title: Center(
            child: Text(
              'IMMETTI UN USERNAME',
              style: TextStyle(
                  fontSize: 20.0,
                  fontWeight: FontWeight.bold,
                  color: Colors.grey[500]),
            ),
          ),
          content: Row(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: <Widget>[

              SizedBox(
                  width: 100,
                  height: 50,
                  child: TextFormField(
                    //tastiera virtuale

                    decoration: InputDecoration(
                        //decoratore della tastiera virtuale
                        filled: true, //colore pieno
                        hintText: 'username', //rubato da whatsapp
                        labelStyle: TextStyle(fontSize: 18)),

                    onChanged: (text) {
                      //se il testo dentro la tastiera e' modificato
                      setState(() {
                        if (text != "")
                          username =
                              text; //se il testo non e' vuoto aggiorno il messaggio
                      });
                    },
                  ))
            ],
          ),
          actions: <Widget>[
            FlatButton(
                child: Text('salva'),
                onPressed: () {
                  Navigator.of(context).pop();
                })
          ],
        );
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    //mi connetto
    //socketConnector();

    return Column(
      children: <Widget>[

        Padding(
          padding: const EdgeInsets.all(10.0),
          child: Column(

            children: <Widget>[

              Row(
                mainAxisAlignment: MainAxisAlignment.center, //mettere al centro il titolo
                children: <Widget>[
                  title(), 
                ],
              ),
            ],
          ),
        ),


         Center(
           child: Container( 
              child: clearMessages(),
                  ),
         ),


        Expanded(
            child: new ListView.builder(
          //chat coi messaggi
          controller: c,
          addAutomaticKeepAlives: true,
          itemCount: messaggi.length,
          itemBuilder: (BuildContext ctxt, int index) {
            return (messaggi.elementAt(
                index)); //i messaggi in realta sono widget, per la precisione container con dentro un widget text
          },
        )),


        Container(
          child: usernameLogin()
        ),


        Padding(//la tasietra virtuale con il bottone
          padding: const EdgeInsets.all(10.0),
          child:  sendBox()
        ),


      ],
    );
  }
}
