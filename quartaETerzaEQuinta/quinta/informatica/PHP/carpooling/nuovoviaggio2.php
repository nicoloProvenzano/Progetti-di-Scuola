<?php

$email = $_GET['email'];
$codV = $_GET['codV'];

$mysqli = new mysqli('localhost', 'root', '', 'carpooling');
if ($mysqli->connect_error) {
    die('Errore di connessione(' . $mysqli->connect_errno . ')' . $mysqli->connect_error);
}

$services = $mysqli->query("SELECT passeggero.CF_passeggero FROM `passeggero` WHERE passeggero.email='$email'");
$riga = $services->fetch_array(MYSQLI_ASSOC);
$cf = $riga['CF_passeggero'];


if ($result = $mysqli -> query("SELECT pxv.n_passeggeri FROM `pxv` WHERE codV=$codV")) {
  while ($row = $result -> fetch_row()) {
     $n_p=$row[0]+1;
  }
  $mysqli -> query("UPDATE `pxv` SET `n_passeggeri`=$n_p WHERE codV=$codV");
  
} else{ $n_p=0;}

$tabviaggi = $mysqli->query("INSERT INTO `pxv`(`n_passeggeri`, `CF_passeggero`, `codV`) VALUES ($n_p,'$cf','$codV');");
header("Refresh:0; url=homepasseggeri.php?email=$email&np=$n_p&codV=$codV");