<?php

$cognome=$_POST["cognome"];
$anno=$_POST["anno"];
$classe=$_POST["classe"];
$query="";

$database = new mysqli('localhost', 'root', '', 'recupero_provenzano');

 if($anno==NULL){
     
     $query="SELECT * FROM studente WHERE cognome='$cognome' AND anno_nascita<2001";//WHERE cognome=$cognome,anno_nascita=2000;
 }else{
     
     $query="SELECT * FROM studente WHERE classe='$classe' AND anno_nascita='$anno'";//WHERE classe=$classe,anno_nascita=$anno
 }


$tabella = $database->query($query);

while ($riga=$tabella->fetch_array(MYSQLI_ASSOC)) {
    
    echo "<tr>";
            
            echo "<td>".$riga["codS"]."</td>";
            
            echo "<td>".$riga["cognome"]."</td>";
            
            echo "<td>".$riga["nome"]."</td>";
            
            echo "<td>".$riga["anno_nascita"]."</td>";
            
            echo "<td>".$riga["classe"]."</td>";
           
            
        echo "</tr>";
}
?>