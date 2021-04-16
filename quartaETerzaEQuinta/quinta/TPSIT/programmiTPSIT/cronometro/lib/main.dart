import 'dart:async';

import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'DEMO CRONOMETRO',
      theme: ThemeData(
          // primarySwatch: Colors.green,
          // visualDensity: VisualDensity.adaptivePlatformDensity,
          ),
      home: MyHomePage(title: 'Cronometro'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key key, this.title}) : super(key: key);
  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  List<int> tempo = [0, 0, 0];
  int secondi = 2;
  int minuti = 1;
  int ore = 0;
  String cronometro = "00:00:00";

  List<String> listaTempi = [];

  bool startato = false;
  //bool reset = false;

  IconData iconaBottone = Icons.play_arrow;

  Stream<List> _aggiornaTempo() async* {
    while (startato) {
      await Future.delayed(Duration(seconds: 1));
      tempo[secondi]++;

      if (tempo[secondi] == 60) {
        tempo[secondi] = 0;
        tempo[minuti]++;
      }
      if (tempo[minuti] == 60) {
        tempo[minuti] = 0;
        tempo[ore]++;
      }
      yield tempo; //NICE
    }
  }

  String tostring() {
    String textSecondi = "";
    String textMinuti = "";
    String textOre = "";

    if (tempo[secondi] < 10) {
      textSecondi = "0" + tempo[secondi].toString();
    } else
      textSecondi = tempo[secondi].toString();

    if (tempo[minuti] < 10) {
      textMinuti = "0" + tempo[minuti].toString();
    } else
      textMinuti = tempo[minuti].toString();

    if (tempo[ore] < 10) {
      textOre = "0" + tempo[ore].toString();
    } else
      textOre = tempo[ore].toString();

    cronometro = "" + textOre + ":" + textMinuti + ":" + textSecondi;
    return cronometro;
  }

  void start() {
    if (!startato) {
      setState(() {
        startato = true;
        iconaBottone = Icons.stop;
      });
    } else {
      setState(() {
        startato = false;
        iconaBottone = Icons.play_arrow;
      });
    }
  }

  void azzera() {
    setState(() {
      tempo = [0, 0, 0];
      cronometro = "00:00:00";
      listaTempi = [];
    });
  }

  void prendiTempo() {
    setState(() {
      listaTempi.add(cronometro);
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(

      backgroundColor: Colors.black12,
      body: Center(

        child: Column(

          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[

            SizedBox(height: 250),

            //cronometro
            StreamBuilder(
                stream:
                    _aggiornaTempo(), //lo stream si basa sulla funzione che aggiona il cronometro
                builder: (context, snapshot) {
                  if (snapshot.hasData) {
                    //se ci sono nuovi dati
                    cronometro = tempo
                        .toString(); //il cronometro che si vede assume il valore del cronometro aggionato usato nella funzione
                  }
                  return Text(
                    //mostra la stringa che e' il cronometro
                    tostring(),
                    textAlign: TextAlign.center,
                    style: TextStyle(
                        fontSize: 50.0,
                        fontWeight: FontWeight.bold,
                        color: Colors.white),
                  );
                }),

            SizedBox(height: 50),

            Row(//pulsanti
                
                mainAxisAlignment: MainAxisAlignment.center,
                children: <Widget>[

                  //PRENDERE TEMPO
                  FlatButton.icon(
                    padding: const EdgeInsets.all(10.0),
                    onPressed: () {
                      prendiTempo();
                    },
                    icon: Icon(
                      Icons.timer,
                      size: 50,
                    ),
                    color: Colors.black,
                    textColor: Colors.white,
                    label: Text(""),
                  ),

                  SizedBox(width: 10),

                  //AVVIO E PAUSA
                  FlatButton.icon(
                    padding: const EdgeInsets.all(10.0),
                    onPressed: () {
                      start();
                    },
                    icon: Icon(
                      iconaBottone,
                      size: 50,
                    ),
                    color: Colors.black,
                    textColor: Colors.white,
                    label: Text(""),
                  ),

                  SizedBox(width: 10),

                  //AZZERA
                  FlatButton.icon(
                    padding: const EdgeInsets.all(10.0),
                    onPressed: () {
                      azzera();
                    },
                    icon: Icon(
                      Icons.refresh,
                      size: 50,
                    ),
                    color: Colors.black,
                    textColor: Colors.white,
                    label: Text(""),
                  )
                ]),

            SizedBox(height: 50),

            //TEMPI SALVATI
            Expanded(

              child: Center(

                //lista
                child: ListView.builder(

                  shrinkWrap: true, //parametro che dice alla lista di OCCUPARE SOLAMENTE LO  SPAZIO RICHIESTO E NON LO SPAZIO DEL WIDGET PADRE //link utile https://stackoverflow.com/questions/54007073/what-does-the-shrink-wrap-property-do-in-flutter
                  itemCount: listaTempi.length,
                  itemBuilder: (context, index) {

                    return ListTile(

                        title: Text("${listaTempi[index]}",
                            textAlign: TextAlign.center,
                            style: TextStyle(
                                fontSize: 30.0,
                                fontWeight: FontWeight.bold,
                                color: Colors.white)));
                  }),
            ))
          ],
        ),
      ),
    );
  }
}

