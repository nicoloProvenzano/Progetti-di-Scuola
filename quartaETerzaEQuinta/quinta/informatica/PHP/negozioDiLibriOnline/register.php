<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Progetto GPOI</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="grafica.css" rel="stylesheet" type="text/css"/>
    </head>
    <body style="background-color: lightskyblue; text-align:center; color:white; width: 90%; height:100%;">
        <div><h2 style="font-size: 40px;">Registrati</h2></div>
        <div id="divForm">
            <form action="registrati.php" method="POST">
                <div>
                    <i style="color:white" class="fa fa-user" aria-hidden="true"></i>
                    <b style="color:blue">* Name: </b>
                    <input type="text" name="name" placeholder="Insert name..."></div>
                <p></p><br>
                <div>
                    <i style="color:white" class="fa fa-user" aria-hidden="true"></i>
                    <b style="color:blue">* Surname </b>
                    <input type="text" name="sname" placeholder="Insert surname..."></div>
                <p></p><br>
                <div>
                    <i style="color:white" class="fa fa-credit-card-alt" aria-hidden="true"></i>
                    <b style="color:blue">* Fiscal Code: </b>
                    <input type="text" name="cf" placeholder="Insert fiscal code..."></div>
                <p></p><br>
                <div>
                    <i style="color:white" class="fa fa-envelope" aria-hidden="true"></i>
                    <b style="color:blue">* Email: </b>
                    <input type="email" name="email" placeholder="Insert email..."></div>
                <p></p><br>
                <div>
                    <i style="color:white;" class="fa fa-lock" aria-hidden="true"></i>
                    <b style="color:blue">* Password: </b>
                    <input type="password" name="psw" placeholder="Insert password..."></div>
                <p></p><br>
                <div>
                    <i style="color:white;" class="fa fa-map-marker" aria-hidden="true"></i>
                    <b style="color:blue">Address: </b>
                    <input type="text" name="add" placeholder="Insert address..."></div>
                <p></p><br>
                <div><input type="submit" value="Register"></div>
            </form>
            <br>
            <form action="login.php">
                <div><input id="back" type="submit" value="Back"></div>
            </form>
        </div>
    </body>
</html>
