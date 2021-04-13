<?php

function test_input($data) {
    $data = trim($data);
    $data = stripslashes($data);
    $data = htmlspecialchars($data);
    return $data;
  }

$mysqli = new mysqli('localhost', 'root', '', 'negozio_libri');
/*------------------------------------------------------------------------------------------------------- 
if ($mysqli->connect_error) {
    die('Errore di connessione(' . $mysqli->connect_errno . ') ' . $mysqli->connect_error);
} else {
    echo 'Connesso. ' . $mysqli->host_info . "\n<br>";
}
/* ------------------------------------------------------------------------------------------------------ */

$nome = $_POST['name'];
$cognome = $_POST['sname'];
$cf = $_POST['cf'];
$indirizzo = $_POST['indirizzo'];
$email = $_POST['email'];
$password = $_POST['psw'];

$query = "INSERT INTO cliente(CF, indirizzo, nome, cognome, codL, email, password) VALUES ('$cf', '$indirizzo', '$nome', '$cognome', 1, '$email', '$password')";
$queryLogin = "SELECT email FROM cliente WHERE email = '$email'";
$array = $mysqli->query($queryLogin)->fetch_array();

if(!is_null($array['email'])){
    //significa che esiste già una persona con quella mail
    header("Refresh:0; url=login.php");
} else {
    //inserire nel database il nuovo utente
    $result = $mysqli->query($query);
    header("Refresh:0; url=index.php");   
}
?>