
<?php
$cf=$_POST["CF"];
$password = $_POST["password"];
$email = $_POST["email"];
$scadenza_patente=$_POST["scadenza_patente"];
$telefono=$_POST["telefono"];
$nome=$_POST["nome"];
$cognome=$_POST["cognome"];

$mysqli = new mysqli('localhost', 'root', '', 'carpooling');
$query="NSERT INTO `autista`(`CF_autista`, `nome`, `cognome`, `scadenza_patente`, `telefono`, `email`, `password`) VALUES ('$cf','$nome','$cognome','$scadenza_patente',$telefono,'$email','$password')";
$tab = $mysqli->query();
header("Refresh:0; url=homeautisti.php?email=$email");