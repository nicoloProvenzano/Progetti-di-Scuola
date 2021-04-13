<html>

<head>
    <title>Home Autisti</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="cssLogin.css">
</head>

<body>
    <div>I MIEI VIAGGI</div>
    <?php
    $email = $_GET['email'];

    $mysqli = new mysqli('localhost', 'root', '', 'carpooling');
    if ($mysqli->connect_error) {
        die('Errore di connessione(' . $mysqli->connect_errno . ')' . $mysqli->connect_error);
    }

    try {
        $tabviaggi = $mysqli->query("SELECT viaggio.* FROM viaggio INNER JOIN autista ON autista.CF_autista = viaggio.CF_autista  WHERE autista.email='$email'");
    } catch (exception $e) {
        echo $e->getMessage() + "<br/>";
        echo "Materia not found GO BACK <--";
    } finally {
        echo "<br><div><table id='tabella'>IN CORSO</div>";
        echo "<tr>";
        echo "<th id='th'>codV</th>";
        echo "<th id='th'>città_partenza</th>";
        echo "<th id='th'>città_destinazione</th>";
        echo "<th id='th'>data_partenza</th>";
        echo "<th id='th'>ora_partenza</th>";
        echo "<th id='th'>costo</th>";
        echo "<th id='th'>data_destinazione</th>";
        echo "<th id='th'>CF_autista</th>";
        echo "</tr>";
        while ($riga = $tabviaggi->fetch_array(MYSQLI_ASSOC)) {
            if (date('d/m/Y') < $riga['data_destinazione']) {
                echo "<tr id='tr'>";
                echo "<td id='td'>" . $riga['codV'] . "</td>";
                echo "<td id='td'>" . $riga['città_partenza'] . "</td>";
                echo "<td id='td'>" . $riga['città_destinazione'] . "</td>";
                echo "<td id='td'>" . $riga['data_partenza'] . "</td>";
                echo "<td id='td'>" . $riga['ora_partenza'] . "</td>";
                echo "<td id='td'>" . $riga['costo'] . "</td>";
                echo "<td id='td'>" . $riga['data_destinazione'] . "</td>";
                echo "<td id='td'>" . $riga['CF_autista'] . "</td>";
                echo "</tr>";
            }
        }
    }
    //------------------------------TAB 2---------------------------------------//

    try {
        $tabviaggi = $mysqli->query("SELECT viaggio.* FROM viaggio INNER JOIN autista ON autista.CF_autista = viaggio.CF_autista  WHERE autista.email='$email'");
    } catch (exception $e) {
        echo $e->getMessage() + "<br/>";
        echo "Materia not found GO BACK <--";
    } finally {
        echo "<br><div><table id='tabella'>CONCLUSI</div>";
        echo "<tr>";
        echo "<th id='th'>codV</th>";
        echo "<th id='th'>città_partenza</th>";
        echo "<th id='th'>città_destinazione</th>";
        echo "<th id='th'>data_partenza</th>";
        echo "<th id='th'>ora_partenza</th>";
        echo "<th id='th'>costo</th>";
        echo "<th id='th'>data_destinazione</th>";
        echo "<th id='th'>CF_autista</th>";
        echo "</tr>";
        while ($riga = $tabviaggi->fetch_array(MYSQLI_ASSOC)) {
            if (date('d/m/Y') > $riga['data_destinazione']) {
                echo "<tr id='tr'>";
                echo "<td id='td'>" . $riga['codV'] . "</td>";
                echo "<td id='td'>" . $riga['città_partenza'] . "</td>";
                echo "<td id='td'>" . $riga['città_destinazione'] . "</td>";
                echo "<td id='td'>" . $riga['data_partenza'] . "</td>";
                echo "<td id='td'>" . $riga['ora_partenza'] . "</td>";
                echo "<td id='td'>" . $riga['costo'] . "</td>";
                echo "<td id='td'>" . $riga['data_destinazione'] . "</td>";
                echo "<td id='td'>" . $riga['CF_autista'] . "</td>";
                echo "</tr>";
            }
        }
    }
    echo "<tr>";
    echo "<th id='th'><a href='aggiungiviaggio.php?email=$email'>+aggiugi viaggio</a></th>";
    echo "</tr>";
    echo "</table>";
    ?>
</body>

</html>