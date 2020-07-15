<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title></title>
</head>
<body>
	<?php
		$link = mysqli_connect("localhost", "root", "", "test02");
		if (!$link) {
			echo "連接失敗";
		}
		

		print_r($_POST);
		echo "<br>";
		print_r(mysqli_connect_error());
		$sql = "set names utf8";
		echo "<br>";

		mysqli_query($link, $sql);
		$edit = "";



		// 編輯
		if (isset($_POST["edit"])) {
			$edit = key($_POST["edit"]);
		}

		// 發布
		if (isset($_POST["post"])) {
			$sql = "INSERT INTO `message_board`
								 (`user`, 
								 `content`) 
						VALUES ('".$_POST["user"]."',
								'".$_POST["content"]."')";
			print_r($sql);
			mysqli_query($link, $sql);
			
		}


		// 儲存編輯後的內容
		if (isset($_POST["save"])) {
			$sql = "UPDATE `message_board` 
						SET `content` = '".$_POST["edit_content"]."' 
						WHERE `message_board`.`id` = '".key($_POST["save"])."'";
			mysqli_query($link, $sql);
		}

		// 刪除
		if (isset($_POST["delete"])) {
			$sql = "DELETE FROM `message_board` 
						WHERE `message_board`.`id` = '".key($_POST["delete"])."'";
			mysqli_query($link, $sql);
		}

		// 全部刪除
		if (isset($_POST["delete_all"])) {
			for ($i=0; $i < count($_POST["no"]); $i++) { 
				$sql = "DELETE FROM `message_board` 
						WHERE `message_board`.`id` = '".$_POST["delete"][$i]."'";
				mysqli_query($link, $sql);
			}
			
		}


	?>
	<form method="post">
		<table border="1" width="800" align="center">
			<tr>
				<td>
				名稱
				<input type="text" name="user">
				</td>
				<td>
				內文
				<textarea name="content" id="" cols="30" rows="1"></textarea>
				</td>			
				<td>
				<input type="submit" name="post" value="提交">
				</td>			
			</tr>
		</table>

		<table border="1" width="600" align="center">
			<tr>
				<td>選擇</td>
				<td>功能</td>
				<td>ID</td>
				<td>時間</td>
				<td>使用者名稱</td>
				<td>內文</td>
			</tr>
			<?php
				$sql = "SELECT * FROM `message_board`";
				$result = mysqli_query($link, $sql);
				while ($row = mysqli_fetch_assoc($result)) {
					echo "<tr>";
					echo "<td><input type='checkbox' name='no' value='".$row["id"]."'></td>";
					echo "<td>";
					if ($edit == $row["id"]) {
						echo "<input type='submit' name='save[".$row["id"]."]' value='儲存'>";
						echo "<input type='submit' value='取消'>";
					} else {
						echo "<input type='submit' name='edit[".$row["id"]."]' value='編輯'>";
						echo "<input type='submit' name='delete[".$row["id"]."]'value='刪除'>";
					}	
					echo "</td>";

					echo "<td>".$row["id"]."</td>";
					echo "<td></td>";
					echo "<td></td>";
					if ($edit == $row["id"]) {
						echo "<td>
							<input type='text' name='edit_content' value='".$row["content"]."'>
						</td>";
					} else {
						echo "<td>".$row["content"]."</td>";
					}


					echo "</tr>";
				}



			?>
		</table>
	</form>
</body>
</html>