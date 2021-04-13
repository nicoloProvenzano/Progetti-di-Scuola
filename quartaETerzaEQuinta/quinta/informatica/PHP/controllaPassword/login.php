<?php
$password = $_POST["password"];

if (strlen($password)<8) {
    
    echo "
    <link rel='stylesheet' type='text/css' href='cssLogin.css'>

    <body>
	<div class='messaggi'> la password richiede almeno 8 caratteri</div>
    </body>
    ";
    //header("Location: index.html");
}
else if(strpos($password, "@") || strpos($password, "£") || strpos($password, "$") || strpos($password, "&")){
    
    echo "
    <link rel='stylesheet' type='text/css' href='cssLogin.css'>
    
    <body>
        <div class='messaggi'> la password non deve contenere i caratteri:@, £, $, &</div>
    </body>
    ";
}
else if(preg_match("#^[a-z]+$#", $password)){
    
    echo "
    <link rel='stylesheet' type='text/css' href='cssLogin.css'>
    
    <body>
        <div class='messaggi'> la password richiede almeno un carattere maiuscolo</div>
    </body>
    ";

}
else if(preg_match("#^[a-zA-Z]+$#", $password)){
    
    echo "
    <link rel='stylesheet' type='text/css' href='cssLogin.css'>
    
    <body>
        <div class='messaggi'> la password richiede almeno un numero</div>
    </body>
    ";

}
else if(preg_match("#^[0-9]+$#", $password)){
    
    echo "
    <link rel='stylesheet' type='text/css' href='cssLogin.css'>
    
    <body>
        <div class='messaggi'> la password richiede almeno una lettera maiuscola</div>
    </body>
    ";

}
else{  

    echo "
    <link rel='stylesheet' type='text/css' href='cssLogin.css'>
    
    <body>
        <div class='messaggi'> password corretta</div>
    </body>
    ";
}


?>