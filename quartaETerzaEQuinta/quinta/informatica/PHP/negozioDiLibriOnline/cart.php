<?php

$mysqli = new mysqli('localhost', 'root', '', 'negozio_libri');
/* ------------------------------------------------------------------------------------------------------- 
if ($mysqli->connect_error) {
    die('Errore di connessione(' . $mysqli->connect_errno . ') ' . $mysqli->connect_error);
} else {
    echo 'Connesso. ' . $mysqli->host_info . "\n<br>";
}
/* ------------------------------------------------------------------------------------------------------ */
@$costo;
@$ordine;
$query = "SELECT *
            FROM cliente
            INNER JOIN acquisti
            ON cliente.CF = acquisti.CF
            INNER JOIN la
            ON acquisti.codAC = la.codAC
            INNER JOIN libro
            ON la.ISBN = libro.ISBN
            INNER JOIN el
            ON el.isbn = libro.isbn
            INNER JOIN editore
            ON el.codE = editore.codE
            WHERE cliente.CF = '$cf'
            ORDER BY la.codAC DESC";

$result = $mysqli->query($query);

while($lastOrder = $result->fetch_assoc()){
    if(!$lastOrder['comprato']){
        $container = "
                <div class=book>"
        //mostra immagine
                    . " <div class='copertina'>";
                        if(file_exists("../img/${lastOrder['ISBN']}.jpg")){
                            $container= $container."<img src='../img/${lastOrder['ISBN']}.jpg' alt='cover coming soon'>";
                        } else {
                            $container= $container."<img src='../img/notFound.jpg' alt='cover coming soon'>";
                        }
        $container = $container."</div>"
            //mostra titolo e prezzo
                . " <div class='descrizione'>
                    <h3 class='book_title'> ${lastOrder['titolo']} </h3>
                    <p class='author'>Autore: ${lastOrder['cognome']} ${lastOrder['nome']}</p>
                    <p class='editore'>Editore: ${lastOrder['editore']}</p>
                    </div>"
            //mostra il costo totale ed il numero di copie presenti in carrello
                ."  <div class='vendita'>
                        <h3>Acquistati: ${lastOrder['Quantità']}</h3>
                        <br>
                        <a href='removeFromCart.php?acquisto=${lastOrder['codAC']}&ISBN=${lastOrder['ISBN']}&user=$cf'><input style='text-align:center; width:40%' type='submit' value='rimuovi un libro'></a>
                        <br>
                        <p class='prezzo'>Totale: ".($lastOrder['Quantità']*$lastOrder['prezzo'])."€</p>
                    </div>
                </div>";
        echo $container;
        $costo = $lastOrder['costo'];
        $ordine = $lastOrder['codAC'];
    }
}
$totale = "
        <div id='pagamento'>";
        if(@$costo > 0){ 
            $totale.= "
                <p class='prezzo' style='position:relative; margin:2% 3%; float:left height=5;%'>Costo totale ordine: ${costo}€</p>
                <div class='buy' style='text-align:center;'>
                    <a href='bought.php?user=$cf'><input style='text-align:center; width:45%' type='submit' value='Conferma ordine'></a>
                </div>
                ";
        }
$totale.="</div>";
echo $totale;

?>