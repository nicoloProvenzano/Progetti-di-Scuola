<?php

$mysqli = new mysqli('localhost', 'root', '', 'negozio_libri');
/* ------------------------------------------------------------------------------------------------------- 
if ($mysqli->connect_error) {
    die('Errore di connessione(' . $mysqli->connect_errno . ') ' . $mysqli->connect_error);
} else {
    echo 'Connesso. ' . $mysqli->host_info . "\n<br>";
}
/* ------------------------------------------------------------------------------------------------------ */

$cf = $_GET['user'];
$query = "SELECT *
            FROM cliente
            INNER JOIN acquisti
            ON cliente.CF = acquisti.CF
            INNER JOIN la
            ON acquisti.codAC = la.codAC
            WHERE acquisti.CF = '$cf'";


$result = $mysqli->query($query);

while($acquisto = $result->fetch_assoc()){
    echo $acquisto['comprato']."\n";
    if(!$acquisto['comprato']) $mysqli->query("UPDATE acquisti SET comprato=true WHERE CF = '$cf'");
}

header("Refresh:0; url=paginaDue.php?user=$cf");

?>