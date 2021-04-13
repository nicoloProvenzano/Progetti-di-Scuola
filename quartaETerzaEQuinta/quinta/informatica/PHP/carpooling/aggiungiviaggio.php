<html>

<head>
    <title>TODO supply a title</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="cssLogin.css">
</head>
<?php
$email = $_GET['email'];
echo "
<body>
        <form action='aggiungiviaggio2.php?email=$email' method='POST'><br>";
?>
città di partenza: <input type="text" name="città_partenza"><br>
città di destinazione: <input type="text" name="città_destinazione"><br>
data di partenza: <input type="text" name="data_partenza"><br>
ora: <input type="text" name="ora"><br>
costo: <input type="text" name="costo"><br>
data di arrivo: <input type="text" name="dataarrivo"><br>
<input type="submit">
</form>
</body>

</html>