<style>
    table,
    td,
    th {
        border: 1px solid black;
    }

    table {
        border-collapse: collapse;
        width: 100%;
    }

    th {
        text-align: left;
    }
</style>
<?php
$scuola = new mysqli('localhost', 'root', '', 'scuola');
if ($scuola->connect_error) {
    die('Errore di connessione' . $scuola->connect_errno);
} else {
    echo 'Connessione effetuata correttamente ' . $scuola->host_info;
}
echo '<br>';
$evvia = "SELECT * FROM studente";
//$query1 = "SELECT nome FROM studente WHERE cognome='$cognome'";
//$query2 = "DELETE studente FROM studente WHERE cognome='$cognome'";
//$query3 = "UPDATE studente SET cognome='Tagliapietra', nome='Maurizio', classe='2E' WHERE cognome='$cognome'";
$elements = $scuola->query("SELECT * FROM studente");
$elements->fetch_array(MYSQLI_ASSOC);
echo "<table>";
foreach ($elements as $element) {
    echo "<tr>";
    echo "<td>" . $element['codS'] . "</td>";
    echo "<td>" . $element['nome'] . "</td>";
    echo "<td>" . $element['cognome'] . "</td>";
    echo "<td>" . $element['classe'] . "</td>";
    echo "</tr>";
}