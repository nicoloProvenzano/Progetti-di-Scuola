
<?php
$password = $_POST["password"];
$email = $_POST["email"];

$mysqli = new mysqli('localhost', 'root', '', 'cookies');
$tab = $mysqli->query("SELECT utente.password FROM utente WHERE utente.email='$email'");
$pwa = $tab->fetch_array(MYSQLI_ASSOC);
$pw = $pwa["password"];
  if (empty($pw)) {
     header("Refresh:0; url=signin.html");
  } else if ($pw == $password) {
      setcookie("email", $email, strtotime("+1 year"));
      setcookie("password", $password, strtotime("+1 year"));
      header("Refresh:0; url=home.php?");
  } else {
     header("Refresh:0; url=login.html");
  }
?>