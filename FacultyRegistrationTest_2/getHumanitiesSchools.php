<?php


$conn = mysqli_connect("127.0.0.1","s1422085","s1422085","d1422085") or die("Connection not established".$conn->connect_error) ;
// Check connection

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$sql = "SELECT * FROM SD_SCHOOLS WHERE FACULTY_ID='HUM'"; 
$result = mysqli_query($conn,$sql);

$json = array();

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
		$json[]= $row;
    }

    echo json_encode($json);

} else {
    echo "0 results";
}


$conn->close();
?>
