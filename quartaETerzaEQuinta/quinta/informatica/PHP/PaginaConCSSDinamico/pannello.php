<html>
	<head>
		<link rel="stylesheet" href="stile.css" type="text/css">
			
	</head>
	<body>
            <?php
            $database = new mysqli('localhost', 'root', '', 'provenzanonicolo');

            $id = $_GET["id"];

            $query = "SELECT background,color FROM stili WHERE id_style=$id";

            $tabella = $database->query($query);

            while ($riga = $tabella->fetch_array(MYSQLI_ASSOC)) {

                $background = $riga["background"];
                $color = $riga["color"];
                echo"<div id='menu' style='background-color:$background; color:$color;'>";
                echo"<a href='modifica.php?op=add_layout' target='main'>Nuovo layout</a>";
                echo"<a href='modifica.php?op=del_layout' target='main'>Elimina layout</a>";
                echo"</div>";
            }

            ?>

		<iframe src="" name="main"></iframe>
		<div id="tavolozza">
			<?php
                            $database =new mysqli('localhost','root','','provenzanonicolo');
                            
                            $query="SELECT background FROM stili";
                        
                            $tabella = $database->query($query);
                            $i=0;
                        
                            while($riga=$tabella->fetch_array(MYSQLI_ASSOC)){
                                $i++;
                                $background=$riga["background"];
                                echo "<div style='background-color:$background;'>";
                                echo "<a href='pannello.php?id=$i'>";
                                //echo"<div style='background-color:$background;'></div>";
                                echo"</a>";
                                echo "</div>";
                            }
                        ?>
		</div>
	</body>
</html>