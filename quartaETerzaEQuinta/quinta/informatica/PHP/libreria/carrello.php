<?php
$CodAc = $_POST["CodAc"];

$negozio = new mysqli('localhost', 'root', '', 'negozio_libri');

$query=
"SELECT libro.ISBN, libro.titolo, libro.prezzo
FROM libro
INNER JOIN la
ON la.ISBN=libro.ISBN
INNER JOIN acquisti 
ON acquisti.codAC=la.codAC
WHERE acquisti.codAC = $CodAc";

$listaLibri = $negozio->query($query);

while ($book = $listaLibri->fetch_assoc()) {
  $container = "  <div class=book>
  <div></div>
    <div>
      <h3 'book_title'> ${book['titolo']} </h3>
      <p class='ISBN'>${book['ISBN']}</p>
      <p class='prezzo'>${book['prezzo']}</p>
    </div>
  </div>";
}

echo $container;
?>