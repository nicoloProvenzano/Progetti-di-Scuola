<?php 

$mysqli = new mysqli('localhost', 'root', '', 'negozio_libri');
/*------------------------------------------------------------------------------------------------------- 
if ($mysqli->connect_error) {
    die('Errore di connessione(' . $mysqli->connect_errno . ') ' . $mysqli->connect_error);
} else {
    echo 'Connesso. ' . $mysqli->host_info . "\n<br>";
}
/* ------------------------------------------------------------------------------------------------------ */

switch ($filter) {
    case 'autore':
        $result = $mysqli->query("SELECT *
                                    FROM libro
                                    INNER JOIN al
                                    ON libro.ISBN = al.ISBN
                                    INNER JOIN autore
                                    ON al.codA = autore.codA
                                    INNER JOIN el
                                    ON el.isbn = libro.isbn
                                    INNER JOIN editore
                                    ON el.codE = editore.codE
                                    WHERE autore.nome LIKE '%$ricerca%' OR autore.cognome LIKE '%$ricerca%'");
        while ($book = $result->fetch_assoc()) {
            $container = "
                        <div class=book>"
                //mostra immagine
                    . " <div class='copertina'>";
                    if(file_exists("../img/${book['ISBN']}.jpg")){
                        $container= $container."<img src='../img/${book['ISBN']}.jpg' alt='cover coming soon'>";
                    } else {
                        $container= $container."<img src='../img/notFound.jpg' alt='cover coming soon'>";
                    }
            $container= $container."</div>"
                //mostra titolo e prezzo
                        . " <div class='descrizione'>
                            <h3 class='book_title'> ${book['titolo']} </h3>
                            <p class='author'>Autore: ${book['cognome']} ${book['nome']}</p>
                            <p class='editore'>Editore: ${book['editore']}</p>
                            </div>
                            <div class='vendita'>
                            <p class='prezzo'>Prezzo: ${book['prezzo']}€</p>";
                            if(@$cf){                
                                $container = $container."<a class='hide' href='addTocart.php?ISBN=${book['ISBN']}&user=$cf'><button class='hideButton' type='button'>Aggiungi al Carrello</button></a>";
                            } else {                
                                $container = $container."<a class='hide' href='login.php'><button class='hideButton' type='button'>Aggiungi al Carrello</button></a>";
                            }
            $container = $container."</div>
                        </div>";
            echo $container;  
        }                         
        break;
    case 'titolo':
        $result = $mysqli->query("SELECT *
                                    FROM libro
                                    INNER JOIN al
                                    ON libro.ISBN = al.ISBN
                                    INNER JOIN autore
                                    ON al.codA = autore.codA
                                    INNER JOIN el
                                    ON el.isbn = libro.isbn
                                    INNER JOIN editore
                                    ON el.codE = editore.codE
                                    WHERE libro.titolo LIKE '%$ricerca%'");
        while ($book = $result->fetch_assoc()) {
            $container = "
                        <div class=book>"
                //mostra immagine
                    . " <div class='copertina'>";
                    if(file_exists("../img/${book['ISBN']}.jpg")){
                        $container= $container."<img src='../img/${book['ISBN']}.jpg' alt='cover coming soon'>";
                    } else {
                        $container= $container."<img src='../img/notFound.jpg' alt='cover coming soon'>";
                    }
            $container= $container."</div>"
                //mostra titolo e prezzo
                        . " <div class='descrizione'>
                            <h3 class='book_title'> ${book['titolo']} </h3>
                            <p class='author'>Autore: ${book['cognome']} ${book['nome']}</p>
                            <p class='editore'>Editore: ${book['editore']}</p>
                            </div>
                            <div class='vendita'>
                            <p class='prezzo'>Prezzo: ${book['prezzo']}€</p>";
                            if(@$cf){                
                                $container = $container."<a class='hide' href='addTocart.php?ISBN=${book['ISBN']}&user=$cf'><button class='hideButton' type='button'>Aggiungi al Carrello</button></a>";
                            } else {                
                                $container = $container."<a class='hide' href='login.php'><button class='hideButton' type='button'>Aggiungi al Carrello</button></a>";
                            }
            $container = $container."</div>
                        </div>";
            echo $container;
        }    
        break;
    default:
        $result = $mysqli->query("SELECT *
                                    FROM libro 
                                    INNER JOIN al
                                    ON libro.ISBN = al.ISBN
                                    INNER JOIN autore
                                    ON al.codA = autore.codA
                                    INNER JOIN el
                                    ON el.isbn = libro.isbn
                                    INNER JOIN editore
                                    ON el.codE = editore.codE
                                    WHERE libro.titolo LIKE '%$ricerca%'
                                     OR autore.nome LIKE '%$ricerca%'
                                     OR autore.cognome LIKE '%$ricerca%'
                                     OR editore.editore LIKE '%$ricerca%'");
    while ($book = $result->fetch_assoc()) {
            $container = "
                        <div class=book>"
                //mostra immagine
                    . " <div class='copertina'>";
                    if(file_exists("../img/${book['ISBN']}.jpg")){
                        $container= $container."<img src='../img/${book['ISBN']}.jpg' alt='cover coming soon'>";
                    } else {
                        $container= $container."<img src='../img/notFound.jpg' alt='cover coming soon'>";
                    }
            $container= $container."</div>"
                //mostra titolo e prezzo
                        . " <div class='descrizione'>
                            <h3 class='book_title'> ${book['titolo']} </h3>
                            <p class='author'>Autore: ${book['cognome']} ${book['nome']}</p>
                            <p class='editore'>Editore: ${book['editore']}</p>
                            </div>
                            <div class='vendita'>
                            <p class='prezzo'>Prezzo: ${book['prezzo']}€</p>";
                            if(@$cf){                
                                $container = $container."<a class='hide' href='addTocart.php?ISBN=${book['ISBN']}&user=$cf'><button class='hideButton' type='button'>Aggiungi al Carrello</button></a>";
                            } else {                
                                $container = $container."<a class='hide' href='login.php'><button class='hideButton' type='button'>Aggiungi al Carrello</button></a>";
                            }
            $container = $container."</div>
                        </div>";
            echo $container;
        }
        break;
    }
