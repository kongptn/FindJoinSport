<?php
if($_SERVER["REQUEST_METHOD"]=="POST"){
    include "Connect.php";

    $stadium_name = $_POST["stadium_name"];
    $description = $_POST["description"];
    $photo = $_POST['photo'];
    $date = $_POST['date'];
    $time = $_POST['time'];
    $location = $_POST['location'];
    $type_id = $_POST['type_id'];
    $user_id = $_POST['user_id'];
    $name = $_POST['name'];
   

    $image = $_POST['image'];
    $upload_path = "uploads/$photo.jpg";
    //$photo = "http://10.13.4.80/findjoinsport/football/".$upload_path;

    $query = "INSERT INTO football_activity (stadium_name, description, photo, date, time, location, type_id, user_id, name) VALUES ('$stadium_name', '$description','$upload_path', '$date', '$time', '$location', '$type_id','$user_id', '$name')";
    if (mysqli_query($con,$query)) {
        file_put_contents($upload_path,base64_decode($image));
    } else {
        die (mysqli_error($con));
    }
    // or die (mysqli_error($con));
    mysqli_close($con);
}
?>