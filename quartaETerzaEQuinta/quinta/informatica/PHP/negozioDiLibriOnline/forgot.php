<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Password dimenticata</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="grafica.css" rel="stylesheet" type="text/css"/>
    </head>
    <body style="background-color: lightskyblue; text-align:center; color:white; width: 90%; height:100%;">
        <script>
            function myFunction() {
                alert("Verrà mandato un messaggio a questa email con la nuova Password");
            }
        </script>
        <div><h2 style="font-size: 40px;">Password dimenticata?</h2></div>
        <br>
        <form action="#">
            <label for="email" style="color:blue;">Insert email:</label><br>
            <input type="email" name="email" placeholder="Insert email..."><br><br>
            <input id="submit" onclick="myFunction()" type="submit" value="Submit"><br><br>
            <a href="register.php">Registrati</a>
        </form>
    </body>
</html>
