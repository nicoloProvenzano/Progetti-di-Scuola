<?php
$email=$_COOKIE["email"];
$password=$_COOKIE["password"];

$mysqli = new mysqli('localhost', 'root', '', 'cookies');
$tab = $mysqli->query("SELECT utente.password FROM utente WHERE utente.email='$email'");
$pwa = $tab->fetch_array(MYSQLI_ASSOC);
$pw = $pwa["password"];
if (empty($pw)) {
     header("Refresh:0; url=signin.html");
  } else if ($pw == $password) {
      header("Refresh:0; url='../home.php");
  } else {
     header("Refresh:0; url=index.html");
  }
?>