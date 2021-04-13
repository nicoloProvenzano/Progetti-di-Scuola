<?php
    $id=$_POST["id"];
    
    $database = new mysqli('localhost', 'root', '', 'provenzanonicolo');

    $query="DELETE FROM stili WHERE id_style=$id";
                        
    $tabella = $database->query($query);
?>