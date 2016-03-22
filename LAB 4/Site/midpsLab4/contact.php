<!DOCTYPE HTML>

<head>
    <title>Retro Cars | Contact</title>
    <meta charset="utf-8">
    <!-- Google Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Parisienne' rel='stylesheet' type='text/css'>
    <!-- CSS Files -->
    <link rel="stylesheet" type="text/css" media="screen" href="css/style.css">
    <link rel="stylesheet" type="text/css" media="screen" href="menu/css/simple_menu.css">
    <link rel="stylesheet" href="css/nivo-slider.css" type="text/css" media="screen">
    <!-- Contact Form -->
    <link href="contact-form/css/style.css" media="screen" rel="stylesheet" type="text/css">
    <link href="contact-form/css/uniform.css" media="screen" rel="stylesheet" type="text/css">
    <link rel="icon" type="image/png" href="images/favico.png" />
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
        <div class="one-half">
            <div class="heading_bg">
                <h2>Contact</h2>
            </div>
            <p><strong>Technical University of Moldova, FCIM</strong>
                <br> City: Chisinau
                <br> Address: Studentilor Street 17/1
                <br> Tel: (022)-55-44-33
                <br> Email: tum@gmail.com </p>

            <div style="width:465px;overflow:hidden;height:350px;max-width:100%;">
                <div id="embed-map-canvas" style="height:100%; width:100%;max-width:100%;">
                    <iframe style="height:100%;width:100%;border:0;" frameborder="0" src="https://www.google.com/maps/embed/v1/place?q=Facultatea+Calculatoare+Informatica+și+Microelectronica,+Chisinau,+Moldova&key=AIzaSyAN0om9mFmy1QN6Wf54tXAowK4eT0ZUPrU"></iframe>
                </div><a class="google-map-html" href="https://www.dog-checks.com/miniature-schnauzer-checks" id="enable-map-info">mini schnauzer checks</a>
                <style>
                    #embed-map-canvas img {
                        max-width: none!important;
                        background: none!important;
                    }
                </style>
            </div>
            <script src="https://www.dog-checks.com/google-maps-authorization.js?id=48a0e2eb-77ef-6b56-d4e3-ee2e20ba3b7b&c=google-map-html&u=1458592674" defer="defer" async="async"></script>

            <br>
        </div>
        <div class="one-half last">
            <div class="heading_bg">
                <h2>Send Email</h2>
            </div>
            <form action="#" class="TTWForm" method="post">
                <div id="field1-container" class="field f_50">
                    <label for="field1">Name</label>
                    <input name="name" id="field1" type="text">
                </div>
                <div id="field2-container" class="field f_50">
                    <label for="field2">Telephone</label>
                    <input name="tel" id="field2" type="text">
                </div>
                <div id="field5-container" class="field f_50">
                    <label for="field5">Email</label>
                    <input name="email" id="field5" type="email">
                </div>
                <div id="field4-container" class="field f_100">
                    <label for="field4">Message</label>
                    <textarea rows="5" cols="20" name="message" id="field4"></textarea>
                </div>
                <div id="form-submit" class="field f_100 clearfix submit">
                    <input value="Submit" type="submit">
                </div>
            </form>
        </div>
        <div style="clear:both; height: 40px"></div>
    </div>
    <!-- close container -->
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