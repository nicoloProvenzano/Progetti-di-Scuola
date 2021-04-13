<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>LogIn Libreria Online</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="grafica.css" rel="stylesheet" type="text/css"/>
    </head>
    <body style="background-color: lightskyblue; text-align:center; color:blue; width: 90%; height:100%;">
        <div><h2 style="font-size: 40px; color: white;">Login</h2></div>
        <form action="accesso.php" method="POST">
            <div>
                <i style="color:white" class="fa fa-envelope" aria-hidden="true"></i>
                <b style="color:blue">Email: </b>
                <input type="email" name="email" placeholder="Insert email..."></div>
            <p></p><br>
            <div>
                <i style="color:white;" class="fa fa-lock" aria-hidden="true"></i>
                <b style="color:blue">Password: </b>
                <input type="password" name="psw" placeholder="Insert password..."></div>
            <p></p><br>
            <div><input type="submit" value="Login"></div>
            <br><br>
            <a href="register.php">Register</a>
            <br>
            Forgot <a href="forgot.php">password?</a>
        </form>
        <br>
        <form action="index.php">
            <div><input id="back" type="submit" value="Back"></div>
        </form>
    </body>
</html>
