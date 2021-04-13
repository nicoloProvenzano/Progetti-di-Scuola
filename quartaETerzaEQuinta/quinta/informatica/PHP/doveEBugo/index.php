<?php

    $combinazioni= array("123","132","213","231","312","321");
    $scelta=rand(0,5);
    header("Location: game.php?ordine=$combinazioni[$scelta]&s=0");
    
?>