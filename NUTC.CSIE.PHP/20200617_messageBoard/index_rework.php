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

	// debug
	print_r($_POST);
	print_r(mysqli_connect_error());

	$sql = "set names utf8";
	mysqli_query($link, $sql);
	$edit = "";

	// 編輯
	if (isset($_POST["edit"])) {
		$edit = key($_POST["edit"]);
	}

	// 發布
	if (isset($_POST["post"])) {
		$sql = "INSERT INTO message_board
							(user, content) 
					VALUES ('".$_POST["user"]."',
							'".$_POST["content"]."')";
		mysqli_query($link, $sql);
	}

	// 儲存
	if (isset($_POST["save"])) {
		$sql = "UPDATE `message_board`
					SET `content` = '".$_POST["edit_content"]."' 
					WHERE `message_board`.`id` = ".key($_POST["save"]);
		mysqli_query($link, $sql);
	}

	// 刪除
	if (isset($_POST["delete"])) {
		$sql = "DELETE FROM `message_board` 
						WHERE `message_board`.`id` = ".key($_POST["delete"]);
		mysqli_query($link, $sql);
	}

	// 全部刪除
	if (isset($_POST["delete_all"])) {
		for ($i=0; $i < count($_POST["checkedId"]); $i++) { 
			$sql = "DELETE FROM `message_board` 
						WHERE `message_board`.`id` = ".$_POST["checkedId"][$i];
			mysqli_query($link, $sql);
		}
	}

	?>

	<form method="post">
	 	<table width="800" align="center">
	 		<tr>
	 			<td>
	 				留言人
	 				<input type="text" name="user">
	 			</td>
	 			<td>
	 				留言內容
	 				<textarea name="content" id="" cols="50" rows="1"></textarea>
	 			</td>
	 			<td>
	 				<input type="submit" name="post" value="留言">
	 			</td>
	 		</tr>
	 	</table>

		
 		<table width="600" border="1" align="center">
 			<tr>
				<td colspan="5">
					<input type="submit" name="delete_all" value="勾選刪除">
				</td>
			</tr>
	 		<tr>
	 			<td>選</td>
				<td>功能</td>
				<td>時間</td>
				<td>留言人</td>
				<td>內容</td>
				<td>ID</td>
	 		</tr>
			<?php 
			$sql = "SELECT * FROM `message_board`";
			$result = mysqli_query($link, $sql);
			while ($row = mysqli_fetch_assoc($result)) {
				echo "<tr>";
				echo "<td><input type='checkbox' name='checkedId[]' value='".$row["id"]."'></td>";


				echo "<td>";
				// 編輯模式
				// 長出儲存取消的按鈕
				if ($edit==$row["id"]) {
					// 儲存
					echo "<input type='submit' name='save[".$row["id"]."]' value = 儲存>";
					// 取消
					echo "<input type='submit' value = 取消>";
				} else {
					// 修改
					echo "<input type='submit' name='edit[".$row["id"]."]' value = 修改>";
					// 刪除
					echo "<input type='submit' name='delete[".$row["id"]."]' value = 刪除>";
				}
				echo "</td>";
				echo "<td>".$row["time"]."</td>";
				echo "<td>".$row["user"]."</td>";

				echo "<td>";
				// 長出編輯的輸入框
				if ($edit==$row["id"]) {
					
					echo "<input type='text' name='edit_content' value=".$row["content"].">";
				
				} else {
					echo $row["content"];
				}
				echo "</td>";

				echo "<td>".$row["id"]."</td>";

			}
			?>
		
 		</table>
	 	
	 </form>
</body>
</html>
