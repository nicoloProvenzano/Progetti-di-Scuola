<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Compra il libro</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="grafica.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="titolo">
            <h2>Compra il libro</h2>
        </div>
        <br> 
        <div id="elenco" style="width:250px;">
            <div style="color: lightskyblue; font-size:25px; text-align:center;">
                Categorie
            </div>
            <br>
            <?php include('categoria.php') ?>
        </div>
        <div id="libri" style="width:1225px;">
            <?php include('books.php') ?>
            <form action="#">
                &nbsp<input type="submit" style="width:150px; border-color: lime;" value="Acquista il libro"><br><br>
            </form>
            <form action="#">
                &nbsp<input type="submit" style="width:150px; border-color:red;" value="Aggiungi al carrello">
            </form>
        </div>
        <br>
        <div id="contatti">
            <div style="left:50px; bottom:30px; position: absolute;">
                <a href="#"><i style="color: limegreen;" class="fa fa-whatsapp fa-3x" aria-hidden="true"></i></a><b style="color: green">&nbsp&nbsp&nbsp +39 3483274758</b>
            </div>
            <div style="left:300px; bottom:30px; position: absolute;">
                <a href="#"><i style="color: red;" class="fa fa-envelope fa-3x" aria-hidden="true"></i></a><b style="color: red">&nbsp&nbsp&nbsp libreria.online@gmail.com</b>
            </div>
            <div style="left:650px; bottom:30px; position: absolute;">
                <a href="#"><i style="color: blue;" class="fa fa-phone fa-3x" aria-hidden="true"></i></a><b style="color: blue">&nbsp&nbsp&nbsp 041 4357634</b>
            </div>
            <div style="left:900px; bottom:30px; position: absolute;">
                <a href="#"><i style="color: cyan;" class="fa fa-twitter fa-3x" aria-hidden="true"></i></a><b style="color: cyan">&nbsp&nbsp&nbsp @LibreriaOnline</b>
            </div>
            <div style="left:1180px; bottom:30px; position: absolute;">
                <a href="#"><i style="color: fuchsia;" class="fa fa-instagram fa-3x" aria-hidden="true"></i></a><b style="color: fuchsia">&nbsp&nbsp&nbsp @LibreriaOnline</b>
            </div>
        </div>
    </body>
</html>
