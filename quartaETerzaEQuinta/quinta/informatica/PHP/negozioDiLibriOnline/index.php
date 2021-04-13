<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <link href="grafica.css" rel="stylesheet" type="text/css"/>
        <title>Progetto GPOI</title>
    </head>
    <body>
        <!-- -------Titolo del negozio------ -->
        <div id="titolo">
            <form class="research" action="index.php">
                <i class="fa fa-search" aria-hidden="true"></i>
                <input style="width:90%;" type="text" name="ricerca">
            </form>
            <div>
                <h2>Libreria Digitale</h2>
            </div>
            <form action="login.php">
                <input class="logBtn" id="bottone" type="submit" value="Login">
            </form>
        </div>
        <br>

        <!-- ---------Elenco categorie-------- -->
        <div id="elenco" style="width:250px;">
            <div style="color: lightskyblue; font-size:25px; text-align:center;">
                Categorie
            </div>
            <br>
            <?php 
                //modificare la path in base alla pagina usata
                @$cf = $_GET['user'];
                $path = "index.php";
                $homepage = basename($path);
                include('categoria.php') 
            ?>
        </div>

        <!-- ---------Zona libri--------------- -->
        <div id="libri">
            <?php
            //controlla se c'è stata una ricerca
            //e la salva
            @$ricerca = $_GET['ricerca'];
            if(!is_null($ricerca)){
                //filtro che serve ad indirizzare la ricerca
                //WIP
                @$filter = $_POST['filter'];
                include('research.php');
            } else {
                //altrimenti controlla se è presente una categoria 
                //in caso si mostrano tutti i libri
                @$category = $_GET['category'];
                include('books.php');
            }    
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