
<?php
$cf=$_POST["CF"];
$password = $_POST["password"];
$email = $_POST["email"];
$id_carta=$_POST["id_carta"];
$telefono=$_POST["telefono"];
$nome=$_POST["nome"];
$cognome=$_POST["cognome"];

$mysqli = new mysqli('localhost', 'root', '', 'carpooling');
$query="INSERT INTO `passeggero`(`CF_passeggero`, `password`, `email`, `telefono`, `documento_id`, `cognome`, `nome`) VALUES ('$cf','$password','$email',$telefono,$id_carta,'$cognome','$nome')";
$tab = $mysqli->query($query);
header("Refresh:0; url=homepasseggeri.php?email=$email");

?>
