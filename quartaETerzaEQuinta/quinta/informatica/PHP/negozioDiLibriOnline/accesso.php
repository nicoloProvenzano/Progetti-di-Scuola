<?php

$mysqli = new mysqli('localhost', 'root', '', 'negozio_libri');
/*------------------------------------------------------------------------------------------------------- /
if ($mysqli->connect_error) {
    die('Errore di connessione(' . $mysqli->connect_errno . ') ' . $mysqli->connect_error);
} else {
    echo 'Connesso. ' . $mysqli->host_info . "\n<br>";
}
/ ------------------------------------------------------------------------------------------------------ */

$email = $_POST['email'];
$password = $_POST['psw'];

$query = "SELECT CF, password FROM cliente WHERE email= '$email'";
$result = $mysqli->query($query);
$cliente = $result->fetch_array();

if (empty($cliente)) {
    //non esiste, registrazione
    //collegarsi alla schermata di registrazione
    header("Refresh:0; url=register.php");
} else {
    //account presente nel database
    //controllare la sua password

    if ($cliente['password'] === $password) {
        //utente correttamente loggato
        //collegare la pagina del negozio
        header("Refresh:0; url=paginaDue.php?user=${cliente['CF']}");

    } else {
        //password errata
        //ricaricare solo la password
        header("Refresh:0; url=login.php");
    }
}
?>