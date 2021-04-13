<?php

$conta = $_GET["conta"];

echo "<link rel='stylesheet' type='text/css' href='$conta.css'>";

echo"<div>
    <a href='login.php?conta=1'> giallo
    <a href='login.php?conta=2'> rosso
    <a href='login.php?conta=3'> verde
</div>";


echo"<img src='immagine.jpg' alt='immagine non disponibile'>";
//echo"<img src='immagine$conta.jpg' alt='immagine non disponibile'>";
?>