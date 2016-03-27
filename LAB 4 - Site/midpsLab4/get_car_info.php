<?php 
header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");

include("db.php");
//if($connection){ // echo "Yes, it is!"; //}

    $query = "SELECT * FROM cars LIMIT 5";
    $search_query = mysqli_query($connection, $query);
    $output = "[";
    
    if(!$search_query){
        die('QUERY FAILED'.mysqli_error($connection));
    }
    
        
    while($row = mysqli_fetch_array($search_query)){
        if ($output != "[") {$output .= ",";}
        $brand = $row['cars'];
        $year = $row['year'];
        $image = $row['photo'];
        $price = $row['price'];
        $description = $row['description'];
        
        $output .= '{"Name":"'  . $brand . '",';
        $output .= '"Year":"'   . $year . '",';
        $output .= '"Price":"'   . $price . '",';
        $output .= '"Path":"' . $image .'"}';
    }
$output .= "]";
echo ($output);



?>