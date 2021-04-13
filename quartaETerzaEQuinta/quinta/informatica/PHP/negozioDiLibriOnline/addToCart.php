<?php

$mysqli = new mysqli('localhost', 'root', '', 'negozio_libri');
/* ------------------------------------------------------------------------------------------------------- 
if ($mysqli->connect_error) {
    die('Errore di connessione(' . $mysqli->connect_errno . ') ' . $mysqli->connect_error);
} else {
    echo 'Connesso. ' . $mysqli->host_info . "\n<br>";
}
/* ------------------------------------------------------------------------------------------------------ */
$date = getdate()['mday']."/".getdate()['mon']."/".getdate()['year'];
$ISBN = $_GET['ISBN'];
$cf = $_GET['user'];
$user = null;
$costoLibro = $mysqli->query("SELECT prezzo FROM libro WHERE ISBN = '$ISBN'")->fetch_assoc()['prezzo'];


$userOrders = "SELECT *
            FROM cliente
            RIGHT JOIN acquisti
            ON cliente.CF = acquisti.CF";
$allOrders = $mysqli->query($userOrders);

while($order =$allOrders->fetch_assoc()){
    $lastAc = $order['codAC'];
    if($order['CF'] === $cf){
        $user = $order;
    }
}
$lastAc++;

if($user === null){
    //se l'utente deve ancora acquistare viene creato il suo nuovo acquisto
    //e lo aggiunge nella relazione dei libri ordinati in singola copia
    $mysqli->query("INSERT INTO acquisti(codAC, costo, data, CF) VALUES ($lastAc, $costoLibro, '$date', '$cf')");
    $mysqli->query("INSERT INTO la(ISBN, codAC, Quantità) VALUES ($ISBN, $lastAc, 1)");
} else {
    //se esiste si controlla quando viene inserito, se ha già un carrello
    if($user['comprato']){
        //Se le date non corrispondono si presume un nuovo ordine
        $mysqli->query("INSERT INTO acquisti(codAC, costo, data, CF) VALUES ($lastAc, $costoLibro, '$date', '$cf')");
        $mysqli->query("INSERT INTO la(ISBN, codAC, Quantità) VALUES ($ISBN, $lastAc, 1)");
    } else {
        //altrimenti si deve aggiungere un libro all'ordine
        $qnt = $mysqli->query("SELECT Quantità
                            FROM la
                            WHERE ISBN = $ISBN AND codAC = ${user['codAC']}")->fetch_assoc();
        if(empty($qnt)){
            //se il libro non esiste non si aggiunge un'altra copia ma si aggiunge un ulteriore libro
            $mysqli->query("INSERT INTO la(ISBN, codAC, Quantità) VALUES ($ISBN, ${user['codAC']}, 1)");
            $mysqli->query("UPDATE acquisti SET `costo`=".($user['costo'] + $costoLibro)." WHERE codAC = ${user['codAC']}");
        } else {
            //Se il libro è già presente nel carrello aggiungere una copia  
            $mysqli->query("UPDATE la SET Quantità =".(++$qnt['Quantità']) ." WHERE ISBN = $ISBN AND codAC = ${user['codAC']}");
            $mysqli->query("UPDATE acquisti SET `costo`=".($user['costo'] + $costoLibro)." WHERE codAC = ${user['codAC']}");
        }
    }
}
header("Refresh:0; url=carrello.php?user=$cf");

?>