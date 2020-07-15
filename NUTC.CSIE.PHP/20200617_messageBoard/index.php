<!DOCTYPE html>
<html>
<head>
	<meta charset=“UTF-8”>
	<title></title>
</head>
<body>
	<?php
	// “主機位置”,”帳號”,”密碼”,”預設資料庫”
	$connect = mysqli_connect("localhost","root","","test01");
	$sql = "set names utf8";
	mysqli_query($connect,$sql);
	if(!$connect)
		echo "失敗";

	//print_r("<br>Error messenge: ".mysqli_connect_error());
	
	// output the content of $_POST
	print("<br>");
	print_r($_POST);	

	if(isset($_POST["save"]))
	{
		$sql = "UPDATE `test_data`
					SET `CONTENT` = '".$POST["msg"][key($_POST["save"])]."'
					WHERE `CONETNT`.`ID` = ".key($_POST["save"]);
		mysqli_query($link,$sql);
	}
	if (isset($_POST["sure"])) {
		$sql = "INSERT INTO `test_data` 
		                    ( `NAME`, 
		                      `CONTENT`) 
		             WHERE ('".$_POST["NAME"]."', 
		                     '".$_POST["CONTENT"]."')";
		mysqli_query($connect,$sql);
	}
	if (isset($_POST["delete"])) {
		$sql = "DELETE FROM `test_data` 
					WHERE `CONTENT`.`NO` = ".key($_POST["delete"]);
		mysqli_query($link,$sql);
	}
	$number = null;
	?>
	<form method="post" enctype=”multipart/form-data”>
		留言人
		<input type="text" name="NAME" id="">
		<br>
		留言
		<textarea name="CONTENT" cols="20" rows="3"></textarea>
		<input type="submit" name="sure" value="留言">
	
	<table border="1" width="550">
		<tr>
			<td>選</td>
			<td>功能</td>
			<td>時間</td>
			<td>留言人</td>
			<td>內容</td>
			<td>圖片</td>
			<td>NO.</td>
		</tr>
			<?php
			//檔案上傳 php.ini post_max_size 以及 upload filesize 要調大，否則會出現empty file name

			$sql = "SELECT * FROM `test_data`";
			$result = mysqli_query($connect,$sql);
			while($row = mysqli_fetch_assoc($result))
			{
				echo "<tr>";
				echo "<td><input type='checkbox'></td>";
				


				if (isset($_POST['EDIT']) && (key($_POST['EDIT']) == $row['NO'])) {
					echo "<td><input type='submit' name='save[".$row['NO']."]' value='儲存'><input type='submit' name='DELETE' value='刪除'></td>";
					echo "<td>".$row["TIME"]."</td>";
					echo "<td>".$row["NAME"]."</td>";
					echo "<td><input type='text' name='msg".$row["CONTENT"]."' value='".$row["CONTENT"]."'></td>";
				} else {
					echo "<td><input type='submit' name='EDIT[".$row['NO']."]' value='編輯'><input type='submit' name='DELETE' value='刪除'></td>";
					echo "<td>".$row["TIME"]."</td>";
					echo "<td>".$row["NAME"]."</td>";
					echo "<td>".$row["CONTENT"]."</td>";


				}



				echo "<td>圖片</td>";
				echo "<td>".$row["NO"]."</td>";
				echo "<tr>";
			}
			?>
	</table>
	</form>
</body>
</html>