
<?php
$password = $_POST["password"];
$email = $_POST["email"];

$mysqli = new mysqli('localhost', 'root', '', 'carpooling');
$tab = $mysqli->query("SELECT autista.password FROM `autista` WHERE autista.email='$email'");
$pwa = $tab->fetch_array(MYSQLI_ASSOC);
$pw = $pwa["password"];
  if (empty($pw)) {
     header("Refresh:0; url=signinautisti.html");
  } else if ($pw == $password) {
      header("Refresh:0; url=homeautisti.php?email=$email");
  } else {
     header("Refresh:0; url=loginautisti.html");
  }
?>