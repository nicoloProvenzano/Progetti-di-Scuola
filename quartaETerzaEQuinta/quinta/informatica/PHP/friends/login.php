<?php

$conta = $_GET["conta"];

echo "<link rel='stylesheet' type='text/css' href='$conta.css'>";

echo "<img src='friends.jpg' alt='immagine non disponibile'>";

echo"<div>
    <a href='login.php?conta=1'> benny
    <a href='login.php?conta=2'> adolfigno
    <a href='login.php?conta=3'> nonno stalin
</div>";

//echo"<img src='immagine.jpg' alt='immagine non disponibile'>";
echo"<img src='immagine$conta.jpg' alt='immagine non disponibile'>";


?>