<?php
require "conn.php";
$user_Name = $_POST["username"];
$user_pass = $_POST["password"];
$mysql_query = "select * from user_data where username like '$user_Name' and password like '$user_pass';";
$mysql_result = mysqli_query($conn, $mysql_query);
if(mysqli_num_rows($mysql_result) > 0) {
    echo"Login successful";
}
else {
    echo "login not successful";
}
?>
