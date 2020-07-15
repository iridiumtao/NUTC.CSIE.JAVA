<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>
	<?php
	$link = mysqli_connect("localhost","root","","demo");
	if(!$link)
		echo "連接失敗";
	$sql = "set names utf8";
	mysqli_query($link,$sql);
	$edit = "";
	if(isset($_POST["edit"]))
	{
		$edit = key($_POST["edit"]);
	}
	if(isset($_POST["post"]))
	{
		if(copy($_FILES["img"]["tmp_name"],"file/".$_FILES["img"]["name"]))
		{
			$sql = "INSERT INTO message
			                   (PERSON,
			                    CONTENT,
			                    IMG)
			             VALUES('".$_POST["person"]."',
			                    '".$_POST["content"]."',
			                    '".$_FILES["img"]["name"]."')";
			mysqli_query($link,$sql);
		}
	}
	if(isset($_POST["save"]))
	{
		$sql = "UPDATE `message` 
		           SET `CONTENT` = '".$_POST["edit_content"]."' 
		         WHERE `message`.`ID` = ".key($_POST["save"]);
		mysqli_query($link,$sql);
	}
	if(isset($_POST["delete"]))
	{
		$sql = "select IMG
		          from message
		         where ID = ".key($_POST["delete"]);
		$result = mysqli_query($link,$sql);
		$filename = mysqli_fetch_assoc($result);
		if($filename["IMG"]!="")
			unlink("file/".$filename["IMG"]);
		$sql = "DELETE FROM `message` 
		              WHERE `message`.`ID` = ".key($_POST["delete"]);
		mysqli_query($link,$sql);
	}
	if(isset($_POST["delete_all"]))
	{
		for($i=0;$i<count($_POST["no"]);$i++)
		{
			$sql = "DELETE FROM `message` 
			              WHERE `message`.`ID` = ".$_POST["no"][$i];
			mysqli_query($link,$sql);
		}
	}
	?>
	<form method="post" enctype="multipart/form-data">
		圖片
		<input type="file" name="img">
		留言人
		<input type="text" name="person">
		留言內容
		<textarea name="content" id="" cols="50" rows="5"></textarea>
		<input type="submit" name="post" value="留言">

		<hr>
		<table width="500" border="1" align="center">
			<tr>
				<td colspan="5">
					<input type="submit" name="delete_all" value="勾選刪除">
				</td>
			</tr>
			<tr>
				<td>選</td>
				<td>功能</td>
				<td>時間</td>
				<td>圖片</td>
				<td>留言人</td>
				<td>內容</td>
			</tr>
			<?php
			$sql = "select ID,
			               TIME,
			               PERSON,
			               CONTENT,
			               IMG
			          from message";
			$result = mysqli_query($link,$sql);
			while($row = mysqli_fetch_assoc($result))
			{
				echo "<tr>";
				echo "<td><input type='checkbox' name='no[]' value='".$row["ID"]."'></td>";
				echo "<td>";
				if($edit==$row["ID"])
				{
					echo "<input type='submit' name='save[".$row["ID"]."]' value='存'>";
					echo "<input type='submit' value='消'>";
				}
				else
				{
					echo "<input type='submit' name='edit[".$row["ID"]."]' value='編'>";
					echo "<input type='submit' name='delete[".$row["ID"]."]' value='刪'>";
				}
				echo "</td>";
				echo "<td>".$row["TIME"]."</td>";
				echo "<td><img width=100 src='file/".$row["IMG"]."'></td>";
				echo "<td>".$row["PERSON"]."</td>";
				echo "<td>";
				if($edit==$row["ID"])
					echo "<input type='text' name='edit_content' value='".$row["CONTENT"]."'>";
				else
					echo $row["CONTENT"];
				echo "</td>";
				echo "</tr>";
			}
			?>
		</table>
	</form>
</body>
</html>