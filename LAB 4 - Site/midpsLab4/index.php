<!DOCTYPE HTML>

<head>
    <title>Retro Cars | Home</title>
    <meta charset="utf-8">
    <!-- Google Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Parisienne' rel='stylesheet' type='text/css'>
    <!-- CSS Files -->
    <link rel="stylesheet" type="text/css" media="screen" href="css/style.css">
    <link rel="stylesheet" type="text/css" media="screen" href="menu/css/simple_menu.css">
    <!-- Contact Form -->
    <link href="contact-form/css/style.css" media="screen" rel="stylesheet" type="text/css">
    <link href="contact-form/css/uniform.css" media="screen" rel="stylesheet" type="text/css">
    <link rel="icon" type="image/png" href="images/favico.png" />
    <!-- JS Files -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
    <script src="js/jquery.tools.min.js"></script>
    <script>
        function changeImage() {
            $(function () {
                $("#prod_nav ul").tabs("#panes > div", {
                    effect: 'fade'
                    , fadeOutSpeed: 400
                });
            });
        }
    </script>

    <script>
        var xmlHttp = new XMLHttpRequest();
        var url = "get_car_info.php";

        xmlHttp.onreadystatechange = function () {
            if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                parseFunction(xmlHttp.responseText);
            }
        }

        xmlHttp.open("POST", url, true);
        xmlHttp.send();

        function parseFunction(response) {
            var arr = JSON.parse(response);
            var out = "";
            var i;

            for (i = 0; i < arr.length; i++) {
                if (i == 0)
                    out += "<li><a onclick=\"changeImage()\" href=\"#" + i + "\" class= \"current\"><img src=" + arr[i].Path + " width=\"160\" height=\"90\" alt=\"\"><strong>" + arr[i].Name + "</strong> " + arr[i].Price + " </a></li>";
                else
                    out += "<li><a onclick=\"changeImage()\" href=\"#" + i + "\"><img src=" + arr[i].Path + " width=\"160\" height=\"90\" alt=\"\"><strong>" + arr[i].Name + "</strong> " + arr[i].Price + " </a></li>";


            }
            document.getElementById("jsonReq").innerHTML = out;

        }
    </script>

</head>

<body>
    <div class="header">
        <div id="site_title">
            <a href="index.php"><img style="margin-bottom: 50px; " src="images/logo.png" width=100 height=100 alt=""></a>
        </div>
        <!-- Main Menu -->
        <ol id="menu" style="">
            <li class="active_menu_item"><a class="active_menu_item" href="index.php">Home</a></li>
            <li><a href="search_car.php">Search</a></li>
            <li><a href="about.php">About</a></li>
            <li><a href="contact.php">Contact</a></li>
        </ol>
    </div>
    <!-- END header -->
    <div id="container">
        <!-- tab panes -->
        <div id="prod_wrapper">
            <div id="panes">
                <?php

                include("db.php");

                $query = "SELECT * FROM cars LIMIT 5";
                $search_query = mysqli_query($connection, $query);
                $counter = 0;

                if(!$search_query){
                    die('QUERY FAILED'.mysqli_error($connection));
                }
                

                while($row = mysqli_fetch_array($search_query)){
                    $brand = $row['cars'];
                    $year = $row['year'];
                    $image = $row['photo'];
                    $url = $row['saleUrl'];
                    $price = $row['price'];
                    $description = $row['description'];
                    if($counter == 0)
                        echo "<div style=\"display: block;\"><img width='465' height='300' src='{$image}' alt=\"\">";
                    else
                        echo "<div style=\"display: none;\"><img width='465' height='300' src='{$image}' alt=\"\">";
                    echo "<h2>{$year}, {$brand}.</h2>";
                    echo "<p>{$description}</p>";
                    echo "<p style=\"text-align:right; margin-right: 19px\"><a href=\"{$url}\" target=\"_blank\" class=\"button\">Buy Now</a></p></div>";
                    $counter++;
                }



                ?>
            </div>
            <!-- END tab panes -->
            <br clear="all">
            <!-- navigator -->
            <div id="prod_nav">
                <ul id="jsonReq">

                </ul>
            </div>
            <!-- END navigator -->
        </div>
        <!-- END prod wrapper -->
        <div style="clear:both"></div>
        <div style="clear:both"></div>
        <div class="one-half">
            <div class="heading_bg">
                <h2>About Us</h2>
            </div>
            <blockquote>Retro Cars is a monthly magazine packed with cool cars. Retro Cars focuses mainly on modified classics from the 1950s, '60s, '70s, '80s and '90s. There's no doubting the UK's modified and classic car scene is as healthy as ever, and Retro Cars magazine is here to celebrate this vibrant and varied market. Whether you're modifying a Mini, tweaking a Triumph, slamming a SAAB or jazzing up a Jaguar, Retro Cars is the motoring publication for you. </blockquote>
            <p style="text-align:right; margin-right: 16px; margin-bottom: 15px"><a href="about.php" class="button" style="font-size: 18px">Find out more</a></p>
        </div>
        <div class="one-half last">
            <div class="heading_bg">
                <h2>Retro Sensibility</h2>
            </div>
            <iframe src="https://player.vimeo.com/video/56713350?title=0&amp;byline=0&amp;portrait=0&amp;color=ffffff" width="465" height="262" frameborder="0" webkitAllowFullScreen mozallowfullscreen allowFullScreen></iframe>
        </div>
        <div style="clear:both; height: 40px"></div>
    </div>
    <!-- END container -->
    <div id="footer">
        <!-- First Column -->
        <div class="one-fourth">
            <h3>Useful Links</h3>
            <ul class="footer_links ">
                <li><a href="http://retrocarsmag.com" target="_blank">Retro Cars</a></li>
                <li>
                    <a href="http://classiccars.com" target="_blank">Classic Cars</a></li>
                <li>
                    <a href="http://retro-rides.or" target="_blank">Retro Rides</a>
                </li>
                <li>
                    <a href="http://bilenkin.ru" target="_blank">Bilenkin Cars Classic</a>
                </li>
            </ul>
        </div>
        <div class="one-fourth">
        </div>
        <!-- Third Column -->
        <div class="one-fourth">
            <h3>Information</h3> This site was created for informative purposes and for testing AJAX, on the fourth labwork of MIDPS.
            <div id="social_icons">
                <a></a>
                <br>
                <a></a>
            </div>
        </div>
        <!-- Fourth Column -->
        <div class="one-fourth last">
            <h3>Like Us</h3>
            <img src="img/icon_fb.png" alt=""> <img src="img/icon_twitter.png" alt=""> <img src="img/icon_in.png" alt=""> </div>
        <div style="clear:both"></div>
    </div>
    <!-- END footer -->
</body>

</html>