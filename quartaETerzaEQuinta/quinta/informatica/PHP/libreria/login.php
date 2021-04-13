<?php

$email = $_POST['email'];
$password = $_POST['psw'];

$query = "SELECT nome, cognome, password FROM cliente WHERE email= '$email'";
$result = $mysqli->query($query);
$cliente = $result->fetch_array();

if (empty($cliente)) {
    //non esiste, registrazione
    //collegarsi alla schermata di registrazione
    header("Refresh:0; url=registrazione.html");
} else {
    //account presente nel database
    //controllare la sua password

    if ($cliente['password'] === $password) {
        //utente correttamente loggato
        //collegare la pagina del negozio
        header("Refresh:0; url=../site/paginaDue.php?name=${cliente['nome']}&surname=${cliente['cognome']}");

    } else {
        //password errata
        //ricaricare solo la password
        header("Refresh:0; url=login.html");
    }
}
?>