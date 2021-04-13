<?php

//si ottiene i valori del libro da aggiungere al carello cond codice d'acuisto CodAC
$ISBN = $_POST["ISBN"];
$CodAc = $_POST["CodAc"];

$negozio = new mysqli('localhost', 'root', '', 'negozio_libri');

//viene inserito il libro nella tabella di mezzo AL tra il carello e i libri
//questa funziona come lista dei libri contenuti dentro un acquisto
$query="INSERT INTO LA (ISBN, CodAC)VALUES ('$ISBN', '$CodAc')";
$risultato = $negozio->query($query);

//seleziono le generalità dei libri 
$queryLibri=
"SELECT acquisti.codAC, libro.titolo, libro.prezzo
FROM libro
INNER JOIN la
ON la.ISBN=libro.ISBN
INNER JOIN acquisti 
ON acquisti.codAC=la.codAC
WHERE acquisti.codAC = $CodAc";

$listaLibri = $negozio->query($queryLibri);


//selezion il totale dei prezzi
$queryAcquisti=
"SELECT SUM(libro.prezzo) AS prezzo_sum
FROM libro
INNER JOIN la
ON la.ISBN=libro.ISBN
INNER JOIN acquisti 
ON acquisti.codAC=la.codAC
WHERE acquisti.codAC = $CodAc";

$sommaPrezzo = $negozio->query($queryAcquisti);

//vengono mostrati la somma dei libri e il codice d'acquisto del carrello
$acquisto=
"<div>
      <p 'codAC'> ${$listaLibri['codAC']} </h3>
      <p class='ISBN'>${$sommaPrezzo['prezzo_sum']}</p>
</div>";
      
echo $acquisto;

//vengono mostrati tutti i libri contenuti nel carrello
while ($book = $listaLibri->fetch_assoc()) {
    
  $container = "  <div>
  <div></div>
    <div>
      <p 'codAC'> ${book['titolo']} </h3>
      <p class='ISBN'>${book['ISBN']}</p>
      <p class='prezzo'>${book['prezzo']}</p>
    </div>
  </div>";
}

echo $container;

?>