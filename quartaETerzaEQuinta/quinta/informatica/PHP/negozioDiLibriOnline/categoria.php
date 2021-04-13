<?php

$mysqli = new mysqli('localhost', 'root', '', 'negozio_libri');
/* ------------------------------------------------------------------------------------------------------- 
if ($mysqli->connect_error) {
    die('Errore di connessione(' . $mysqli->connect_errno . ') ' . $mysqli->connect_error);
} else {
    echo 'Connesso. ' . $mysqli->host_info . "\n<br>";
}
/* ------------------------------------------------------------------------------------------------------ */

$query = "SELECT * FROM categoria";
$result = $mysqli->query($query);
if($cf){
    while ($category = $result->fetch_assoc()) {
         echo "·<a style='color:black;' href='$homepage?category=${category['codC']}&user=$cf'>${category['denominazione']}</a><br><br>";
    }
    echo "·<a style='color:black;' href='$homepage?user=$cf'>Visualizza tutti</a><br><br>";
} else {
    while ($category = $result->fetch_assoc()) { 
        echo "·<a style='color:black;' href='$homepage?category=${category['codC']}'>${category['denominazione']}</a><br><br>";
    }
    echo "·<a style='color:black;' href='$homepage'>Visualizza tutti</a><br><br>";
}
?>