<?php

$codS=$_POST["codS"];
$cognome=$_POST["cognome"];
$nome=$_POST["nome"];
$anno_nascita=$_POST["anno_nascita"];
$classe=$_POST["classe"];

$query="INSERT INTO studente(codS, cognome, nome, anno_nascita, classe) VALUES ($codS,'$nome','$cognome',$anno_nascita,'$classe')";

$database = new mysqli('localhost', 'root', '', 'recupero_provenzano');

$tabella = $database->query($query);

?>