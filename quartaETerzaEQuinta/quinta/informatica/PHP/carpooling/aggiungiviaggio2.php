<?php

$email = $_GET['email'];
$citta_partenza = $_POST["città_partenza"];
$città_destinazione = $_POST["città_destinazione"];
$data_partenza = $_POST["data_partenza"];
$ora = $_POST["ora"];
$costo = $_POST["costo"];
$dataarrivo = $_POST["dataarrivo"];

$mysqli = new mysqli('localhost', 'root', '', 'carpooling');
if ($mysqli->connect_error) {
    die('Errore di connessione(' . $mysqli->connect_errno . ')' . $mysqli->connect_error);
}

$services = $mysqli->query("SELECT autista.CF_autista FROM `autista` WHERE autista.email='$email'");
$riga = $services->fetch_array(MYSQLI_ASSOC);
$cf = $riga['CF_autista'];

$result = $mysqli->query("SELECT MAX(viaggio.codV) FROM `viaggio`");
$codV = $result->fetch_array()[0];
$codV=$codV+1;

$tabviaggi = $mysqli->query("INSERT INTO `viaggio` (`codV`, `città_partenza`, `città_destinazione`, `data_partenza`, `ora_partenza`, `costo`, `data_destinazione`, `CF_autista`) VALUES
    
    ($codV,'$citta_partenza','$città_destinazione','$data_partenza','$ora',$costo,'$dataarrivo','$cf');");

header("Refresh:0; url=homeautisti.php?email=$email");
