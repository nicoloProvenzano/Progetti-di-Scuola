<html>
	<head>
		<title></title>
		<link rel="stylesheet" href="stile.css" type="text/css">
	</head>
	<body>
		<?php
                        $database = new mysqli('localhost', 'root', '', 'provenzanonicolo');

                        $query="SELECT background,id_style,color FROM stili";
                        
                        $tabella = $database->query($query);
                        $i=0;
                        
                        while($riga=$tabella->fetch_array(MYSQLI_ASSOC)){
                            $i++;
                            $background=$riga["background"];
                            $color = $riga["color"];
                            $id=$riga["id_style"];
                            echo"<div style='background-color:$background; color:$color;'>";
                            echo"<a href='pannello.php?id=$i'>testo</a>";
                            echo"</div>";
                        }
		?>
	</body>
</html>