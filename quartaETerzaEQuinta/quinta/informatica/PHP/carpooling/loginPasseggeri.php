
<?php
$password = $_POST["password"];
$email = $_POST["email"];
$mysqli = new mysqli('localhost', 'root', '', 'carpooling');
$tab = $mysqli->query("SELECT passeggero.password FROM `passeggero` WHERE passeggero.email='$email'");
$pwp = $tab->fetch_array(MYSQLI_ASSOC);
$pw = $pwp["password"];
echo "$pw";
if (empty($pw)) {
    header("Refresh:0; url=signinpasseggeri.html");
} else if ($pw == $password) {
    header("Refresh:0; url=homepasseggeri.php?email=$email");
} else {
    header("Refresh:0; url=loginpasseggeri.html");
}
?>