
//import 'package:cloud_firestore/cloud_firestore.dart';
//import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:sign_in_flutter/client/database.dart';
import 'package:sign_in_flutter/client/memo.dart';
import 'package:sign_in_flutter/login_page.dart';
import 'package:sign_in_flutter/server/sign_in.dart';

import 'memoDAO.dart';

Future<void> main() async {
  WidgetsFlutterBinding.ensureInitialized();

  final database =
      await $FloorMemoDatabase.databaseBuilder('app_database.db').build();
  final dao = database.memoDAO;

  runApp(MyApp(dao: dao));
}

class MyApp extends StatelessWidget {
  final MemoDAO dao;

  MyApp({this.dao});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      home: MyHomePage(title: 'Flutter Demo Home Page', dao: dao),
    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key key, this.title, this.dao}) : super(key: key);

  final MemoDAO dao;

  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {

  static int id = 0;
  MemoDatabase database;
  MemoDAO memoDao;
  List<Memo> listaMemo = <Memo>[];

  TextEditingController titoloController = TextEditingController();
  TextEditingController accountController = TextEditingController();
  TextEditingController categoriaController = TextEditingController();
  TextEditingController corpoController = TextEditingController();
  TextEditingController tagController = TextEditingController();

  bool pressed = false;
  //bool pressedInfo=false;
  int idScelto=0;

  void _addMemo() {
    setState(() {
      Memo memo = new Memo(++id, titoloController.text, accountController.text,
          categoriaController.text, corpoController.text, tagController.text);
      memoDao.insertMemo(memo); // aggiorna db (database.g.dart)
      listaMemo.add(memo); // aggiona lista
    
      /*await FirebaseFirestore.instance
          .collection('memo')
          .doc(memo.id.toString())
          .set(memo.toMap());

      await FirebaseFirestore.instance
          .collection('users')
          .doc(FirebaseAuth.instance.currentUser.uid)
          .update(
        {
          'memos': FieldValue.arrayUnion(
            [
              memo.id,
            ],
          ),
        },
      );*/
    });
    
  }

//    void condividiMemo() {
    //setState(() async {

     // Memo memo = listaMemo[id]; // update list
    
     // await FirebaseFirestore.instance
         //   .collection('users')
          //  .doc(userIdToShare.first.id)
         //   .update({
        //  'memos': FieldValue.arrayUnion([
        //    id,
        //  ])
     //   });
  //  });
    
//  }

 /* Widget pulsanteAggiungi(){

    return Padding(
        padding: EdgeInsets.all(1),
        child: TextField(
          controller: titoloController,
          decoration: InputDecoration(
            border: OutlineInputBorder(),
            labelText: 'email utente',
          ),
        ),
      );
      
    }*/

  void _deleteAllMemo() {
    memoDao.deleteAllMemo();
    setState(() {
      listaMemo = <Memo>[];
      id = 0;
/*
      await FirebaseFirestore.instance
          .collection('memo')
          .doc(listaMemo.toString())
          .delete();

      await FirebaseFirestore.instance
          .collection('users')
          .doc(FirebaseAuth.instance.currentUser.uid)
          .update(
        {
          'memos': FieldValue.arrayRemove(
            [listaMemo.toString()],
          ),
        },
      );*/
    });
  }



  @override
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
      Padding(
        padding: EdgeInsets.all(1),
        child: TextField(
          controller: accountController,
          decoration: InputDecoration(
            border: OutlineInputBorder(),
            labelText: 'Account Google',
          ),
        ),
      ),
      Padding(
        padding: EdgeInsets.all(1),
        child: TextField(
          controller: categoriaController,
          decoration: InputDecoration(
            border: OutlineInputBorder(),
            labelText: 'Categoria',
          ),
        ),
      ),
      Padding(
        padding: EdgeInsets.all(1),
        child: TextField(
          controller: corpoController,
          decoration: InputDecoration(
            border: OutlineInputBorder(),
            labelText: 'Corpo',
          ),
        ),
      ),
      Padding(
        padding: EdgeInsets.all(1),
        child: TextField(
          controller: tagController,
          decoration: InputDecoration(
            border: OutlineInputBorder(),
            labelText: 'Tag',
          ),
        ),
      ),

      FloatingActionButton(
            child: Icon(Icons.add),
            backgroundColor: Colors.blueAccent,
            onPressed: () {
              _addMemo();
            },
          ),
    ]);
  }

 /* Future<Widget> mostraMemo(int id) async{

    Future<Memo> memoFuturo;

    $FloorMemoDatabase.databaseBuilder('database.db').build().then((db) => {
          memoFuturo=db.memoDAO.getMemoById(id)
        });

    Memo memo= await memoFuturo;

    return Column(children: <Widget>[
      Padding(
        padding: EdgeInsets.all(20),
        child: TextField(
          decoration: InputDecoration(
            border: OutlineInputBorder(),
            labelText: memo.titolo + memo.tag,
          ),
        ),
      ),

      Padding(
        padding: EdgeInsets.all(20),
        child: TextField(
          decoration: InputDecoration(
            border: OutlineInputBorder(),
            labelText: memo.corpo,
          ),
        ),
      ),

    ]);
  }*/

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        /*appBar: AppBar(
          title: Text('appMemo'),
        ),*/
        body: Container(
            decoration: BoxDecoration(
              gradient: LinearGradient(
                begin: Alignment.topRight,
                end: Alignment.bottomLeft,
                colors: [Colors.blue, Colors.purple],
              ),
            ),
            child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                mainAxisSize: MainAxisSize.max,
                children: <Widget>[

                  SizedBox(height: 30),
                  imageUrl != null
                  ? ClipOval(
                      child: Material(
                        //color: CustomColors.firebaseGrey.withOpacity(0.3),
                        child: Image.network(
                          imageUrl,
                          fit: BoxFit.scaleDown,
                          height: 50,
                          width: 50,
                        ),
                      ),
                    )
                  : ClipOval(
                      child: Material(
                        //color: CustomColors.firebaseGrey.withOpacity(0.3),
                        child: Padding(
                          padding: const EdgeInsets.all(16.0),
                          child: Icon(
                            Icons.person,
                            size: 30,
                            //color: CustomColors.firebaseGrey,
                          ),
                        ),
                      ),
                    ),
                  SizedBox(height: 10),
                  Text(
                    'Nome utente',
                    style: TextStyle(
                        fontSize: 10,
                        fontWeight: FontWeight.bold,
                        color: Colors.black),
                  ),
                  Text(
                    name,
                    style: TextStyle(
                      fontSize: 15,
                      color: Colors.deepPurple,
                    ),
                  ),
                  SizedBox(height: 10),
                  Text(
                    'account google',
                    style: TextStyle(
                        fontSize: 10,
                        fontWeight: FontWeight.bold,
                        color: Colors.black),
                  ),
                  Text(
                    email,
                    style: TextStyle(
                      fontSize: 15,
                      color: Colors.deepPurple,
                    ),
                  ),
                  SizedBox(height: 10),
                  RaisedButton(
                    onPressed: () {
                      signOutGoogle();
                      Navigator.of(context).pushAndRemoveUntil(
                          MaterialPageRoute(builder: (context) {
                        return LoginPage();
                      }), ModalRoute.withName('/'));
                    },
                    color: Colors.deepPurple,
                    child: Padding(
                      padding: const EdgeInsets.all(4.0),
                      child: Text(
                        'Sign Out',
                        style: TextStyle(
                            fontSize: 15,
                            color: Colors.white,
                            fontWeight: FontWeight.bold),
                      ),
                    ),
                    elevation: 5,
                    shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(30)),
                  ),
                  pressed ? form() : SizedBox(),
                  Container(
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: [
                        FloatingActionButton(
                          child: Icon(Icons.arrow_back, color: Colors.black),
                          backgroundColor: Colors.deepPurple,
                          onPressed: () {
                            setState(() {
                              pressed = false;
                              build(context);
                            });
                          },
                        ),
                        FloatingActionButton(
                          child:
                              Icon(Icons.account_circle, color: Colors.black),
                          backgroundColor: Colors.deepPurple,
                          onPressed: () {
                            setState(() {
                              form();
                              pressed = true;
                            });
                          },
                        ),
                        FloatingActionButton(
                          child: Icon(Icons.add, color: Colors.black),
                          backgroundColor: Colors.deepPurple,
                          onPressed: () {
                            _addMemo();
                          },
                        ),
                        FloatingActionButton(
                            child: Icon(Icons.delete, color: Colors.black),
                            backgroundColor: Colors.deepPurple,
                            onPressed: () {
                              _deleteAllMemo();
                            }),
                      ],
                    ),
                  ),
                  Expanded(
                      child: ListView.builder(
                          padding: const EdgeInsets.all(8),
                          itemCount: listaMemo.length,
                          itemBuilder: (BuildContext context, int index) {
                            return Container(
                              height: 50,
                              margin: EdgeInsets.all(2),
                              color: Colors.red[100],
                              child: Center(
                                  child: Text(
                                '${listaMemo[index].id}: ${listaMemo[index].titolo}',
                                style: TextStyle(fontSize: 18),
                              )),
                            );
                          }))
                ])));
  }
}
