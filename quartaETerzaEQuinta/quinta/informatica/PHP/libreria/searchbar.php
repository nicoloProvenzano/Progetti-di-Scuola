<?php 
$ricerca=$_POST("ricerca");

$connection = mysql_connect("localhost","root","","negozio_libri");

$result = mysql_query("SELECT * FROM libro WHERE LIKE $ricerca");
while ($row = mysql_fetch_assoc($result)) {
 
     echo "<div><a href='https://pagina del libro che non sappiamo neancora/'>" .$row['titolo'].$row['autore'] .$row['prezzo'] . "</a></div>";  
 }//aggiungere il link alla pagina del libro

?>