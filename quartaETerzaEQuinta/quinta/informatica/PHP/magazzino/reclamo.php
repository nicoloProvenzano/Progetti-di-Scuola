<?php

$username=$_POST["username"];
$data=$_POST["data"];
$reclamo=$_POST["reclamo"];
$codO=$_POST["codO"];

if(!isset($username) || !isset($data) || !isset($reclamo) || !isset($codO)){
    
$timestamp = strtotime($data);
$giorno=date("j",$timestamp);
$mese=date("M",$timestamp);
$anno=date("y",$timestamp);

$codR= substr($username,0,2).$anno.$mese.$giorno.$codO.substr($username,3,2);


$query="INSERT INTO reclamo(codR, codO, tipologia) VALUES ($codR,$codO,$reclamo)";

$database = new mysqli('localhost', 'root', '', 'magazzino');

$tabella = $database->query($query);

 echo "<link href='stile.css' rel='stylesheet' type='text/css'/>";
 echo "<div class='testoErrore'>reclamo accettato con codice Reclamo:$codR<div/>";

}
else {
    echo "<link href='stile.css' rel='stylesheet' type='text/css'/>";
    echo "<div class='testoErrore'>reclamo non accettato, compilare tutti i campi<div/>";
}


?>