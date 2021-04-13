<html>
	<head>
		<title></title>
		<style>
			input {
				display: block;
			}
		</style>
	</head>
	<body>
		<?php
			
		$scelta=$_GET["op"];
                
                if($scelta=="del_layout") {
                    
                    echo"<form action='del_layout.php' method='POST'>dimmi l'id del colore che vuoi eliminare <input type='text' name='id'> <input type='submit' value='ESEGUI QUERY'></form>";
                }
                
                else {
                    echo"<form action='add_layout.php' method='POST'>dimmi l'id, ilcolore e il background <input type='text' name='id'><input type='text' name='color'> <input type='text' name='background'> <input type='submit' value='ESEGUI QUERY'></form>";
                }
                ?>
	</body>
</html>