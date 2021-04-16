APPLICAZIONE MEMO

GENERALITA'

l'applicazione Memo è suddivisa in due parti, una server e una client.
La parte Server esegue il login google tramite autenticazione Firebase e modifica il database Firestore collegato all'App.
La parte client mostra il dtabase offline costruito con floor dentro una schermata utente che mostra l'utente google con cui si è fatto l'accesso.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

IN DETTAGLIO PARTE SERVER

main.dart //runna l'app e collegga a Firebase l'app

Widget build(BuildContext context) {

    return FutureBuilder(
      future: Firebase.initializeApp(), <----------| Con questo metodo l'app si collega al progetto firebase dell'app. Il progetto Firebase si collega tramite chiave SHA-1 e nome del package.
	builder: (context, snapshot) {		   | Per chiave SHA eseguire questo comando: ./gradlew signingReport dentro la cartella android.
	  if(snapshot.hasError) {		   | Per il nome del package seguire il percorso \android\app\src\debug\AndroidManifest.xml.
	    return Text("An error has occured");   | Qui si troverà un argomento package simile a questo: package="com.example.sign_in_flutter">     
            }
          if (snapshot.connectionState == ConnectionState.done) {
        
		//costruisce la prima interfaccia

          }else{  //caricamento }
	}

Mi sono domandato ha cosa servisse la chiave SHA-1 perchè a differenza del package non ne capivo molto lo scopo.
Ho trovato che per generare una chiave API serve l'impronta digitale SHA1 del tuo keystore.
Non sapendo cos'era un keystore ho cercato su google.
Ho trovato che il keystore è fondamentalmente un luogo (virtuale) in cui vengono conservate le chiavi private della tua app. 
Non capivo molto bene e allora ho cercato nei forum.
In parole povere è un certificato generato dal programmatore per firmare un'app Android.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

sign_in.dart //questo file si occuppa totalmente ed esclusivamente della parte logica del sign in e sign out

//sono presenti molti metodi già implementati da flutter e dai package firebase_auth: ^1.0.0 google_sign_in: ^5.0.0 per poter eseguire le autenticazioni e l'accesso
//dalla vecchia versione alla nuova sono stati cambiati alcuni nomi e metodi. Il link che segue porta ad un forum dove ne si discute: https://stackoverflow.com/questions/63482162/undefined-class-firebaseuser

final FirebaseAuth _auth = FirebaseAuth.instance; //autenticazione firebase implementata dal primo package
final GoogleSignIn googleSignIn = GoogleSignIn(); //sign-in implementato dal secondo package

Future<String> signInWithGoogle() async { //metodo che usa il sign-in per autenticare l'utente e lo ritorna se il risultato è vero
  
final GoogleSignInAccount googleSignInAccount = await googleSignIn.signIn(); //metodo che aspetta il signIn (per intenderci quando si schiaccia il pulsante per il sign in su un app 
									     //appare un pop up che mostra tutti gli account con cui puoi fare l'accesso, ecco, questo è il metodo che prende l'account selezionato)

final GoogleSignInAuthentication googleSignInAuthentication = await googleSignInAccount.authentication; //metodo che controlla e verifica l'account google scelto

final AuthCredential credential = GoogleAuthProvider.credential( //metodo che creae le credenziali dell'account scelto. il perchè lo si fa è perchè consente agli utenti di 
								 //condividere dati specifici con un'applicazione mantenendo privati nomi utente, password e altre informazioni								
    accessToken: googleSignInAuthentication.accessToken,	 //link che spiega in dettaglio: https://developers.google.com/identity/protocols/oauth2/web-server?csw=1
    idToken: googleSignInAuthentication.idToken,
);

final UserCredential authResult = await _auth.signInWithCredential(credential); //metodo che restituisce le credenziali dell'utente autentificate
final User user = authResult.user; //metodo che restituisce l'utente date le credenziali autentificate

final User currentUser = _auth.currentUser;
assert(user.uid == currentUser.uid);

  return 'signInWithGoogle succeeded: $user';
}

void signOutGoogle() async{ //metodo per fare il sign-out
  await googleSignIn.signOut();

  print("User Sign Out");
}

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

guida: https://medium.com/flutter-community/flutter-implementing-google-sign-in-71888bca24ed

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

IN DETTAGLIO PARTE CLIENT

login_page.dart //interfaccia grafica del login

//pulsante che quando premuto crea il pop up con tutti gli utenti con cui puoi accedere
Widget _signInButton() {
    return OutlineButton(
      splashColor: Colors.grey,
      onPressed: () {
      signInWithGoogle().whenComplete(() {
        Navigator.of(context).push(
          MaterialPageRoute(
            builder: (context) {
              return MyApp();
            },
          ),
        );
      });
      },

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

mainDatabase.dart //interfaccia grafica del  database

//Essenzialmente è molto simile al progetto del professore Andrea Morettin am38_floor
//https://gitlab.com/divino.marchese/flutter/-/tree/master/am038_floor

//unica cosa degna di nota e' il metodo con cui aggiungo al database e alla lista dell'interfaccia i Memo.
//Si crea un nuovo memo quando si schiaccia il pulsante, le specifiche sono selezionate attraverso un apposito form (vedere in seguito)
//il contatore incrementato ogni volta che si aggiunge un memo, il contatore è l'id del del memo sostanzialmente
//metodo molto simile anche per eliminare
//tutto il resto è interfaccia grafica 

void _addMemo() {
    setState(() async {
      Memo memo = new Memo(++id, titoloController.text, accountController.text,
          categoriaController.text, corpoController.text, tagController.text);
      memoDao.insertMemo(memo); // aggiorna db (database.g.dart)
      listaMemo.add(memo); // aggiona lista

//metodo che inizializa l'app e la collega con il database locale
void initState() {
    super.initState();
    $FloorMemoDatabase.databaseBuilder('app_database.db').build().then((db) => {
          db.memoDAO.getAllMemo().then((ps) => setState(() {
                database = db;
                memoDao = db.memoDAO;
                listaMemo = ps;
              }))
        });
  }

//widget che mostra il form per le specifiche del memo con relativo pulsante che le invia al metodo che aggiungerà il memo
Widget form() {
    return Column(children: <Widget>[
      Padding(
        padding: EdgeInsets.all(1),
        child: TextField(
          controller: titoloController,
          decoration: InputDecoration(
            border: OutlineInputBorder(),
            labelText: 'Titolo Memo',
          ),
        ),
      ),
    ... //altri TextField e InputDecoration

    FloatingActionButton(
            child: Icon(Icons.add),
            backgroundColor: Colors.orangeAccent,
            onPressed: () {
              _addMemo();
            },
          ),
    ]);
  }

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

PARTE DI DATABASE 

database.dart //Entità database che serve a creare il databse vero e proprio e specifica che elementi conterrà il db

part 'database.g.dart'; <---- molto importante, serve a creare il file del db effettivo.

@Database(version:1, entities:[Memo])
abstract class MemoDatabase extends FloorDatabase{

  MemoDAO get memoDAO;

}

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

memo.dart //entity del memo con tutti i suoi attributi

class Memo {
  @PrimaryKey(autoGenerate : true)
  final int id;
  String titolo, account, categoria, corpo, tag;

  Memo(this.id,this.titolo,this.account,this.corpo, this.categoria,this.tag);

  Map<String, dynamic> toMap() {//metodo to map per poter aggiungere il memo al db su firestore
    return {
      'tag': tag,
      'account': account,
      'categoria': categoria,
      'corpo': corpo,
      'id': id,
      'titolo': titolo,     
    };
  }

}

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

memoDAO.dart //classe DAO del memo, per la spiegazione su cosa è un DAO guardare la parte su databse.g.dart in cui spiego anche tutto il funzionamento.

@dao
abstract class MemoDAO{

  @Query('SELECT * FROM memo')
  Future<List<Memo>> getAllMemo();

  @Query('SELECT * FROM memo WHERE titolo=:titolo')
  Stream<List<Memo>> getMemoByTitolo(String titolo);

  @Query('SELECT * FROM memo WHERE id=:id')
  Future<Memo> getMemoById(int id);

  @Query('DELETE FROM memo')
  Future<void> deleteAllMemo();

  @insert
  Future<void> insertMemo(Memo memo);

  @update
  Future<void> updateMemo(Memo memo);

  @delete
  Future<void> deleteMemo(Memo memo);
}

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

database.g.dart //è il database ed è generato automaticamente tramte comando flutter packages pub run build_runner build
 
//Creerà il database basandosi sui DAO, fondamentalmente un oggetto che fornisce l'accesso a un database sottostante (per capire meglio cos'è un DAO guarda https://en.wikipedia.org/wiki/Data_access_object) , e sulle Entity.
//Praticamente il databse è composto  dalle Entity e per poter fare operazioni su o con questi elementi del db serve un oggetto aka il DAO.
//Questo oggetto contiene delle funzioni che permettono di fare una serie di operazioni. Quelle basiche possono essere l'aggiunta, l'eliminazione, l'aggionramento e la ricerca.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

guide: https://pub.dev/documentation/floor/latest/#persisting-data-changes & https://www.youtube.com/watch?v=cQ7W7vpwTbk

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

ESPERIENZA PERSONALE

Per prima cosa ho pensato alla struttura che doveva avere l'app.
L'app doveva avere una schermata di login iniziale che eseguesse il login effettuato l'accesso doveva mostrare il profilo con i databse associato ad esso.
Per la creazione dell'applicazione ho cercato del materiale online per capire come fare a creare il db locale con floor, effettuare il login google e come aggiungere a Firestore il db floor locale.
Sono partito dal database in floor perchè il professore aveva già messo a dispozione un database come esempio e sulla falsa riga di esso ho costruito il mio databse da zero.
Unico problema che ho avuto è stato il databse.g.dart perchè non sapevo come crearlo. Fortuitamente ho trovato una guida che spiegava di usare il comando "flutter packages pub run build_runner build" per la creazione automatica del db.
Poi ho creato la parte del login google e dell'autenticazione. Qui ho sperimentato molto varie guide per poi decidere quella con il risultato più consono al mio progetto.
Ci sono stati dei problemi sulla parte dell'autenticazione perchè molte guide non erano aggiornate all'ultima versione del package di firebase e di google _sign_in, quindi ho cercato su vari forum finoa trovare le traduzioni dalla vecchia lla nuova versione.
Infine ho pensato al db online con firestore. Purtroppo non sono riuscito a collegare i due e tutt'ora ho un errore quando provo ad aggiungere o rimuovere un memo nel db online.
Firestore e' un db online che si collega alla tua app trmite il progetto Firebase correlato. Esso usa delle API per scambiare i dati dal db offline al db online tramite un metodo toMap(). Il metodo prende i vari prametri del memo, li imposta nel formato delle API e li invia al db online. Il metodo è presente nei DAO delle entity.
L'errore in questione: FirebaseException ([cloud_firestore/permission-denied] The caller does not have permission to execute the specified operation.)