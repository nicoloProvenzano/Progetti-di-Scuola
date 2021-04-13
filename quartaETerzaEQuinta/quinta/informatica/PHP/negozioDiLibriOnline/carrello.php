<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Carrello</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="grafica.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!-- -------Titolo del negozio------ -->
        <div id="titolo">
            <div>
                <h2>Carrello</h2>
            </div>
            <form action="index.php">
                <input class='logBtn' id="bottone" type="submit" value="Logout">
            </form>
            <div id="carrello">
                <?php
                @$cf = $_GET['user'];
                echo "<a href='paginaDue.php?user=$cf'><i style='color:white;' class='fa fa-home fa-4x' aria-hidden='true'></i></a>";
                ?>
            </div>
        </div>
        <br>

        <!-- ---------Zona libri--------------- -->
        <div id="libri" style="position: absolute; width: 90%; right: 5%;">
            <div style="color: lightskyblue; font-size:35px; text-align:center;">
                Libri Acquistati
            </div>
            <br>
            <?php
                @$cf = $_GET['user'];
                include('cart.php');
            ?>
        </div>
        <br>
        
        <!-- --------Zona contatti------------- -->
        <div id="contatti">
            <div style="position: absolute; left:00%; bottom:15%; margin:1% 2%">
                <a href="#"><i style="color: limegreen;" class="fa fa-whatsapp fa-3x" aria-hidden="true"></i></a><b style="color: green">&nbsp&nbsp&nbsp +39 3483274758</b>
            </div>
            <div style="position: absolute; left:20%; bottom:15%; margin:1% 2%">
                <a href="#"><i style="color: red;" class="fa fa-envelope fa-3x" aria-hidden="true"></i></a><b style="color: red">&nbsp&nbsp&nbsp libreria.online@gmail.com</b>
            </div>
            <div style="position: absolute; left:42.5%; bottom:15%; margin:1% 2%">
                <a href="#"><i style="color: blue;" class="fa fa-phone fa-3x" aria-hidden="true"></i></a><b style="color: blue">&nbsp&nbsp&nbsp 041 4357634</b>
            </div>
            <div style="position: absolute; left:60%; bottom:15%; margin:1% 2%">
                <a href="#"><i style="color: cyan;" class="fa fa-twitter fa-3x" aria-hidden="true"></i></a><b style="color: cyan">&nbsp&nbsp&nbsp @LibreriaOnline</b>
            </div>
            <div style="position: absolute; left:80%; bottom:15%; margin:1% 2%">
                <a href="#"><i style="color: fuchsia;" class="fa fa-instagram fa-3x" aria-hidden="true"></i></a><b style="color: fuchsia">&nbsp&nbsp&nbsp @LibreriaOnline</b>
            </div>
        </div>
    </body>
</html>
