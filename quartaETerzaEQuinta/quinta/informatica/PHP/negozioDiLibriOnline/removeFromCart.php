<?php

$mysqli = new mysqli('localhost', 'root', '', 'negozio_libri');
/* ------------------------------------------------------------------------------------------------------- 
if ($mysqli->connect_error) {
    die('Errore di connessione(' . $mysqli->connect_errno . ') ' . $mysqli->connect_error);
} else {
    echo 'Connesso. ' . $mysqli->host_info . "\n<br>";
}
/* ------------------------------------------------------------------------------------------------------ */
$acquisto = $_GET['acquisto'];
$ISBN = $_GET['ISBN'];

$query = "SELECT *
            FROM la
            INNER JOIN acquisti
            ON la.codAC = acquisti.codAC
            INNER JOIN libro
            ON la.ISBN = libro.ISBN 
            WHERE la.codAC = $acquisto";

$result = $mysqli->query($query);

while($order = $result->fetch_assoc()){
    if($order['ISBN'] === $ISBN){
        if($order['Quantità'] > 1){
            $mysqli->query("UPDATE la SET Quantità=".(--$order['Quantità'])." WHERE ISBN = $ISBN");
        } else {
            $mysqli->query("DELETE FROM la WHERE ISBN = $ISBN AND codAC = $acquisto");
        }
        $mysqli->query("UPDATE acquisti SET costo=".($order['costo']-$order['prezzo'])." WHERE codAC = codAC");
    }
}
header("Refresh:0; url=carrello.php?user=${_GET['user']}");

?>