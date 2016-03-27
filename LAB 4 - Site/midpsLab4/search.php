<?php 

include("db.php");
//if($connection){ // echo "Yes, it is!"; //}



$search = $_POST['search'];

if(!empty($search)){

    $query = "SELECT * FROM cars WHERE cars LIKE '$search%'";
    $howManyResults = 0;
    $search_query = mysqli_query($connection, $query);
    
    if(!$search_query){
        die('QUERY FAILED'.mysqli_error($connection));
    }
    
    $num_rows = mysqli_num_rows($search_query);
        
        echo "<li class='list-unstyled'><div class=\"alert alert-success\">{$num_rows} results.</div></li>";
        
    while($row = mysqli_fetch_array($search_query)){
        $brand = $row['cars'];
        $year = $row['year'];
        $image = $row['photo'];
        $description = $row['description'];
        $url = $row['saleUrl'];
        $price = $row['price'];
        ?>
    <ul class='list-unstyled'>

        <?php
        if (mysqli_num_rows($search_query) > 0) {
        echo "<li><span class=\"badge\" style=\"font-size: 24px;\">{$year}</span> {$brand}. <br><img src='{$image}' class='img-responsive img-thumbnail center-block' alt='Cinque Terre' width='304' height='236' style=\"margin-top: 15px; margin-bottom: 15px;\"><div align=\"right\"><a href=\"{$url}\" target=\"_blank\" style=\"font-size: 24px;\" class=\"button\">Buy Now for {$price}</a></div><br><p class=\"alert alert-info\" style=\"font-size: 70%; font-family: \"Times New Roman\", Georgia, Serif;\" > {$description}</p></li>";
        } else {
            echo "<li>0 results</li>";
        }
        
        ?>
    </ul>
    <?php }
}



?>