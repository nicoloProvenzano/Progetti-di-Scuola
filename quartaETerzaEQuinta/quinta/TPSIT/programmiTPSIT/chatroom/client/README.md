# client

Il client e' costituito da:

-messaggi
-background dove stanno i messaggi
-sendobox
-bottone per l'username
-titolo
-bottone per resettare

Le parti più facili sono stati i bottoni, il titolo, il background, come inserire i messaggi nel background e i messaggi stessi perchè già visti in cronometro.
Molto pi dificili sono stati il login per capire come creare un icona pop up, la sendbox perchè non sapevo come prendere il testo dalla tastiera.

Per la sendox ho usato un textformfield.
permette di prendere testo dalla tastiera e  dispone di una
funzione onchanged che permette di controllare se il testo sia cambiato 
e se cambia posso per esempio assegnarlo ad una variabie come il testo del messaggio.

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
                      messaggi.add(sendMessageBuilder(  //aggiungo il messaggio 
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


Per le icone pop up ho cercato in molti siti finchè non ne ho trovati di ottimi e che ho inserito nella bibliografia.

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
  
  questo e' il pulsante del login che quando viene premuto aziona la funzione per il login
  
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
                  child: TextFormField( \\il textformfield permette di prendere testo dalla tastiera e 
                    //tastiera virtuale \\dispone di una funzione onchanged che permette di controllare se il testo
                                        \\sia cambiato
                                        
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

Bibliografia:

//Funzione per mostare icone pop up
//https://medium.com/@nils.backe/flutter-alert-dialogs-9b0bb9b01d28
//https://api.flutter.dev/flutter/material/showDialog.html
//https://medium.com/flutter-community/flutter-alert-dialog-vs-dialog-in-your-flutter-application-11be20a2af

//Come prendere testo da una tastiera
//https://api.flutter.dev/flutter/material/TextFormField-class.html
//https://flutter.dev/docs/cookbook/forms/text-input
//https://flutter.dev/docs/cookbook/forms/text-field-changes
//https://api.flutter.dev/flutter/widgets/Form-class.html



