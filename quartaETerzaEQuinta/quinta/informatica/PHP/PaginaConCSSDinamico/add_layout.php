<?php
    
    $colore=$_POST["color"];
    $background=$_POST["background"];
    $id=$_POST["id"];
    
    $database = new mysqli('localhost', 'root', '', 'provenzanonicolo');

    $query="INSERT INTO stili(id_style, background, color) VALUES ($id,'$background','$colore')";
                        
    $tabella = $database->query($query);

?>