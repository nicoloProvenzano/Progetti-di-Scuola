<html>
    <head>
            <link href="stile.css" rel="stylesheet" type="text/css"/>
            </head>
    <body>

<?php
    
    $ordine=$_GET["ordine"];
    $scelta=$_GET["s"];
    //echo"$ordine";
    
    
    if($scelta==0){
        echo"
        <div>dov'e' Bugo?</div>    
        <a href='game.php?ordine=$ordine&s=1&$ordine[0]'><img src='0.jpg' alt='immagine non disponibile'></a>
        <a href='game.php?ordine=$ordine&s=2&$ordine[1]'><img src='0.jpg' alt='immagine non disponibile'></a>
        <a href='game.php?ordine=$ordine&s=3&$ordine[2]'><img src='0.jpg' alt='immagine non disponibile'></a>
        ";
        
    } else if($scelta==1){
        echo"    
        <img src='$ordine[0].jpg' alt='immagine non disponibile'>
        <img src='0.jpg' alt='immagine non disponibile'>
        <img src='0.jpg' alt='immagine non disponibile'>
        ";
        if($ordine[0]==3){
            echo"<a href='index.php?ordine=$ordine&s=0'><div> Bugo trovato</div></a>";
        }else{
            echo"<a href='game.php?ordine=$ordine&s=0'><div>Ritenta, sarai piu' fortunato</div></a>";
        }
    }else if($scelta==2){
        echo"
        <img src='0.jpg' alt='immagine non disponibile'>
        <img src='$ordine[1].jpg' alt='immagine non disponibile'>
        <img src='0.jpg' alt='immagine non disponibile'>
        ";
        if($ordine[1]==3){
            echo"<a href='index.php?ordine=$ordine&s=0'><div> Bugo trovato</div></a>";
        }else{
            echo"<a href='game.php?ordine=$ordine&s=0'><div>Ritenta, sarai piu' fortunato</div></a>";
        }
    }else if($scelta==3){
        echo"
        <img src='0.jpg' alt='immagine non disponibile'>
        <img src='0.jpg' alt='immagine non disponibile'>
        <img src='$ordine[2].jpg' alt='immagine non disponibile'>
        ";
        if($ordine[2]==3){
            echo"<a href='index.php?ordine=$ordine&s=0'><div> Bugo trovato</div></a>";
        }else{
            echo"<a href='game.php?ordine=$ordine&s=0'><div>Ritenta, sarai piu' fortunato</div></a>";
        }
    }
    
    
?>
    </body>
</html>