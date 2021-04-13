<?php
$conta = $_GET["conta"];
echo "<img src ='$conta.jpg'>";
$conta++;
if ($conta > 5) $conta = 1;
header("Refresh: 3; url='login.php?conta=$conta'");
?>
