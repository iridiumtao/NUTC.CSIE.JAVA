<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>九九乘法表</title>
    <style>
    	.th {
        background: #000;
        color: #FFF;
        font-weight: bold;
        font-size: 14;
        text-align-last: center;
    	}

    	table {
        border-collapse: collapse;
    	}

    	td {
        text-align-last: justify;
        
        font-size: 18px;
        
		padding: 5px 20px 5px 20px;
    	}
    </style>
</head>

<body>

    <table align="center" border="1">
        <tr>
            <thead>
                <td colspan="3" class="th" align="center">
                    九九乘法表
                </td>
            </thead>
        </tr>
        <?php
			for ($row = 0; $row < 3; $row ++) {
			    echo "<tr>";

			    for ($col = 0; $col < 3; $col ++) {
			   		echo "<td>";
			   		for ($i=1; $i < 10; $i++) { 
			   			echo ($row * 3 + ($col + 1)), " * ", $i, " = ";
			   			if (($row * 3 + ($col + 1)) * $i < 10) {
			   				echo "&ensp;";
			   			}
			   			echo ($row * 3 + ($col + 1)) * $i,"<br>";
			   		}
			        echo "</td>";
			    }

			    echo "</tr>";
			}
		?>  
    </table>
</body>

</html>