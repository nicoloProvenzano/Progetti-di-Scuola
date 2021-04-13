<?php

$server=new mysqli('localhost','root','','struzzo');

$query= "SELECT esempio.campo, secondatabella.eta FROM esempio INNER JOIN secondatabella ON secondatabella.id=esempio.id";
//$query="SELECT esempio.campo,secondatabella.eta FROM esempio,secondatabella WHERE secondatabella.id=esempio.id";

$tabella=$server -> query($query);

while( $riga=$tabella -> fetch_array(MYSQLI_ASSOC)){
        
        echo "<tr>";
            
            echo "<td>".$riga["campo"]." </td>";
            
            echo "<td>".$riga["eta"]."</td>";
            
            echo"<div></div>";
            
        echo "</tr>";
    }

//SELECT t1.*,t2.product_price  
//FROM table1 t1,table2 t2 
//WHERE t1.product_id=t2.product_id 
?>

//$query="SELECT esempio.campo,secondatabella.eta FROM esempio,secondatabella WHERE secondatabella.id=esempio.id";