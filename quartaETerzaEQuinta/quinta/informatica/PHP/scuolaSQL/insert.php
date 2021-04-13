<?php
$nome = $_POST["nome"];
$cognome = $_POST["cognome"];
$classe = $_POST["classe"];
$scuola = new mysqli('localhost', 'root', '', 'scuola');
if ($scuola->connect_error) {
    die('Errore di connessione' . $scuola->connect_errno);
} else {
    echo 'Connessione effetuata correttamente ' . $scuola->host_info;
}
echo'<br>';
$query1="SELECT nome FROM studente WHERE cognome='$cognome'";
$risultato = $scuola->query($query1);
while($riga=$risultato->fetch_array(MYSQLI_ASSOC)){
    echo $riga['nome'];
}
?>