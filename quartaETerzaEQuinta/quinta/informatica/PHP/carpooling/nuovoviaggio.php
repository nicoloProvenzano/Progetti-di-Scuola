<html>

<head>
    <title>Home Autisti</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="cssLogin.css">
</head>

<body>
    <div>SEZIONE VIAGGI</div>
    <?php

    $email = $_GET['email'];
    $codVpresenti = array();
    $i = 0;

    $mysqli = new mysqli('localhost', 'root', '', 'carpooling');
    try {
        $tabviaggi = $mysqli->query("SELECT viaggio.* FROM passeggero INNER JOIN pxv ON passeggero.CF_passeggero = pxv.CF_passeggero INNER JOIN viaggio ON pxv.codV = viaggio.codV  WHERE passeggero.email='$email'");
    } catch (exception $e) {
        echo $e->getMessage() + "<br/>";
        echo "Materia not found GO BACK <--";
    } finally {
        while ($riga = $tabviaggi->fetch_array(MYSQLI_ASSOC)) {
            $codVpresenti[$i] = $riga['codV'];
            $i = $i + 1;
        }
    }

    

    if ($mysqli->connect_error) {
        die('Errore di connessione(' . $mysqli->connect_errno . ')' . $mysqli->connect_error);
    }

    try {
        $tabviaggi1 = $mysqli->query("SELECT viaggio.* FROM viaggio INNER JOIN pxv ON pxv.codV = viaggio.codV INNER JOIN  passeggero ON passeggero.CF_passeggero != pxv.CF_passeggero WHERE passeggero.email ='$email' GROUP BY viaggio.codV");
    } catch (exception $e) {
        echo $e->getMessage() + "<br/>";
        echo "Materia not found GO BACK <--";
    } finally {
        echo "<div id='nometab'>VIAGGI DISPONIBILI</div>";
        echo "<table id='tabella'>";
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
        while ($riga = $tabviaggi1->fetch_array(MYSQLI_ASSOC)) {

            $result=$mysqli -> query("SELECT pxv.n_passeggeri FROM `pxv` WHERE codV=${riga['codV']}");
            $row = $result -> fetch_row();
            
            if($row[0]<4){//controllo per vedere che siano al massimo 4 posti

            if(in_array ( $riga['codV'] , $codVpresenti )==false){
            echo "<tr id='tr'>";
            echo "<td id='td'>" . $riga['codV'] . "</td>";
            echo "<td id='td'>" . $riga['città_partenza'] . "</td>";
            echo "<td id='td'>" . $riga['città_destinazione'] . "</td>";
            echo "<td id='td'>" . $riga['data_partenza'] . "</td>";
            echo "<td id='td'>" . $riga['ora_partenza'] . "</td>";
            echo "<td id='td'>" . $riga['costo'] . "</td>";
            echo "<td id='td'>" . $riga['data_destinazione'] . "</td>";
            echo "<td id='td'>" . $riga['CF_autista'] . "</td>";
            echo "<td id='td'><a href='nuovoviaggio2.php?email=$email&codV=${riga['codV']}'>+nuovo viaggio</a></td>";
            echo "</tr>";
            }
        }
        }
    }

    try {
        $tabviaggi = $mysqli->query("SELECT viaggio.* FROM viaggio INNER JOIN pxv ON pxv.codV != viaggio.codV INNER JOIN  passeggero ON passeggero.CF_passeggero != pxv.CF_passeggero WHERE passeggero.email ='$email' GROUP BY viaggio.codV");
    } catch (exception $e) {
        echo $e->getMessage() + "<br/>";
        echo "Materia not found GO BACK <--";
    } finally {
        while ($riga = $tabviaggi->fetch_array(MYSQLI_ASSOC)) {

            $result=$mysqli -> query("SELECT pxv.n_passeggeri FROM `pxv` WHERE codV=${riga['codV']}");
            $row = $result -> fetch_row();
            
            if($row[0]<4){//controllo per vedere che siano al massimo 4 posti
            if(in_array ( $riga['codV'] , $codVpresenti )==false){
            echo "<tr id='tr'>";
            echo "<td id='td'>" . $riga['codV'] . "</td>";
            echo "<td id='td'>" . $riga['città_partenza'] . "</td>";
            echo "<td id='td'>" . $riga['città_destinazione'] . "</td>";
            echo "<td id='td'>" . $riga['data_partenza'] . "</td>";
            echo "<td id='td'>" . $riga['ora_partenza'] . "</td>";
            echo "<td id='td'>" . $riga['costo'] . "</td>";
            echo "<td id='td'>" . $riga['data_destinazione'] . "</td>";
            echo "<td id='td'>" . $riga['CF_autista'] . "</td>";
            echo "<td id='td'><a href='nuovoviaggio2.php?email=$email&codV=${riga['codV']}'>+nuovo viaggio</a></td>";
            echo "</tr>";
            }
        }
        }
    }
    echo "</table>";

    ?>
</body>

</html>