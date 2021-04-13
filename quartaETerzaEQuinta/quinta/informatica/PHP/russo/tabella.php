<?php

$database=new mysqli('localhost', 'root', '', 'scuola');
//$query="SELECT * FROM studente";
$tabella=$database->query("SELECT * FROM russo");

echo "<table>";
    while( $riga = $tabella->fetch_array(MYSQLI_NUM)){
        
        echo "<tr>";
            
            echo "<td>".$riga[0]."</td>";
            
            echo "<td>".$riga[1]."</td>";
            
            echo "<td>".$riga[2]."</td>";
            
            echo "<td>".$riga[3]."</td>";
            
        echo "</tr>";
    }
echo "</table>";
?>
