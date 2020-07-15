<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<body>
	<?php
	$connect = mysqli_connect("localhost","root");
	$sql = "set names utf8";
	mysqli_query($connect, $sql);

	if (!$connect) {
		echo "失敗";
	}
	

	if (isset($_POST["sure"])) {
		echo $_POST["CONTENT"];
	}
	?>
	<form method="POST" action="">
		<input type="text" name="NAME" id="">
		<input type="SUBMIT" name="sure" value="COMMENT">
		<input type="PASSWORD">
		<input type="radio" name="" id="">
		<input type="checkbox" name="" id="">
		<select name="sex" id="">
			<option value="">select one</option>
			<option value="Male">Male</option>
			<option value="Female">Female</option>
			<option value="Other">Other</option>
		</select>
		<br>
		Comment
		<textarea name="CONTENT" name="sure" cols="40" rows="3"></textarea>
	</form>
	<?php 
	$sql = "SELECT * FROM `test_data`";
	$result = mysqli_query($connect, $sql);
	while($row = mysqli_fetch_row($result))
	{
		echo $row[0]."<br>";
	}
	?>
	
</body>
</html>