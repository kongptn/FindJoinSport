<?php 
	define('DB_HOST', 'localhost');
	define('DB_USER', 'root');
	define('DB_PASS', '');
	define('DB_NAME', 'findjoinsport');
	
	//connecting to database and getting the connection object
	$con = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);
	
	//Checking if any error occured while connecting
	if (mysqli_connect_errno()) {
		echo "Failed to connect to MySQL: " . mysqli_connect_error();
		die();
	}else{
		mysqli_set_charset($con, "utf8");
	}
	
	$userid_join = isset($_POST['userid_join']) ? $_POST['userid_join'] : '';
	$user_id = isset($_POST['user_id']) ? $_POST['user_id'] : '';
//	$id = isset($_POST['id']);
	$sql ="SELECT * FROM users WHERE user_id = '$user_id' OR user_id = '$userid_join'";
//	$sql ="SELECT * FROM football_activity WHERE id = 300";
	$result = mysqli_query($con ,$sql);

while ($row = mysqli_fetch_assoc($result)) {
	
			$array[] = $row;
			echo json_encode($row,JSON_UNESCAPED_UNICODE);
	
}
//header('Content-Type:Application/json');


	mysqli_free_result($result);

	mysqli_close($con);
?>

