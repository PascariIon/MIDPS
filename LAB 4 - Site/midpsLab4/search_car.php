<!DOCTYPE HTML>

<head>
    <title>Retro Cars | Search Page</title>
    <meta charset="utf-8">
    <!-- Google Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Parisienne' rel='stylesheet' type='text/css'>
    <!-- CSS Files -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" media="screen" href="css/style.css">
    <link rel="stylesheet" type="text/css" media="screen" href="menu/css/simple_menu.css">
    <link rel="stylesheet" href="css/nivo-slider.css" type="text/css" media="screen">
    <link rel="icon" type="image/png" href="images/favico.png" />
    <!-- JS Files -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="js/jquery.min.js"></script>

    <script src="js/scrolltop/scrolltopcontrol.js"></script>
    <script>
        $(document).ready(function () {

            $('#search').keyup(function () {

                var search = $('#search').val();

                $.ajax({
                    url: 'search.php'
                    , data: {
                        search: search
                    }
                    , type: 'POST'
                    , success: function (data) {
                        if (!data.error) {
                            $('#result').html(data);
                        }
                    }

                });
            })
        })
    </script>

    <!-- FancyBox -->
    <link rel="stylesheet" type="text/css" href="js/fancybox/jquery.fancybox.css" media="all">
    <script src="js/fancybox/jquery.fancybox-1.2.1.js"></script>
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
    <div id="container" style="margin-bottom: 75px;">

        <div class="row" style="margin-left: 50px; margin-right: 50px;">
            <h2 class="text-center">Search for your dream car</h2>

            <input class='form-control' type="text" name='search' id='search' placeholder='Search for a retro diamond, for example "Ferrari Dino 246 GT".'>

            <br>
            <br>

            <h2 id="result" style="font-family: Georgia, 'Times New Roman'">
            
            </h2>
        </div>
        <div class=" row ">
            <!--<form id="add-car-form " class="col-xs-6 " action=" ">
    <div class="form-group ">
        <input type="text " class='form-control' name="car_name ">
    </div>
    <div class="form-group ">
        <input type="submit " class="btn btn-primary " value="Add a new car ">
    </div>
</form>-->

            <div style="clear:both; height: 40px "></div>
        </div>
        <!-- close container -->
        <div id="footer" class="center-block" class="center-text">
            <!-- First Column -->
            <div style="margin-left: 13%;" class="one-fourth ">
                <h3>Useful Links</h3>
                <ul class="footer_links ">
                    <li><a href="http://retrocarsmag.com " target="_blank ">Retro Cars</a></li>
                    <li>
                        <a href="http://classiccars.com " target="_blank ">Classic Cars</a></li>
                    <li>
                        <a href="http://retro-rides.or " target="_blank ">Retro Rides</a>
                    </li>
                    <li>
                        <a href="http://bilenkin.ru " target="_blank ">Bilenkin Cars Classic</a>
                    </li>
                </ul>
            </div>
            <div class="one-fourth">
                <h3>Information</h3> This site was created for informative purposes and for testing AJAX, on the fourth labwork of MIDPS.
                <div id="social_icons">
                    <a></a>
                    <br>
                    <a></a>
                </div>
            </div>

            <!-- Fourth Column -->
            <div class="one-fourth last ">
                <h3>Like Us</h3>
                <img src="img/icon_fb.png " alt=" "> <img src="img/icon_twitter.png " alt=" "> <img src="img/icon_in.png " alt=" "> </div>
            <div style="clear:both "></div>
        </div>
        <!-- END footer -->
</body>

</html>