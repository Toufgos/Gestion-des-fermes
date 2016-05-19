<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Erreur 404  </title>
 <!-- Bootstrap core CSS -->

    <link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet">

    <link href="<%=request.getContextPath()%>/resources/fonts/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/animate.min.css" rel="stylesheet">

    <!-- Custom styling plus plugins -->
    <link href="<%=request.getContextPath()%>/resources/css/custom.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/icheck/flat/green.css" rel="stylesheet">


    <script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>

    <!--[if lt IE 9]>
        <script src="../assets/js/ie8-responsive-file-warning.js"></script>
        <![endif]-->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        
           <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>

    <!-- chart js -->
    <script src="<%=request.getContextPath()%>/resources/js/chartjs/chart.min.js"></script>
    <!-- bootstrap progress js -->
    <script src="<%=request.getContextPath()%>/resources/js/progressbar/bootstrap-progressbar.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/nicescroll/jquery.nicescroll.min.js"></script>
    <!-- icheck -->
    <script src="<%=request.getContextPath()%>/resources/js/icheck/icheck.min.js"></script>

    <script src="<%=request.getContextPath()%>/resources/js/custom.js"></script>
    
    <style type="text/css">
    body {
	background-color: #f4cb25;
}
    </style>

</head>


<body class="nav-md">

    <div class="container body">

        <div class="main_container">

            <!-- page content -->
           <div id="wrapper">
            <div id="login" class="animate form">
                <section class="login_content">
                    <form>
                        <h1>Authentification</h1>
                        <div>
                            <input type="text" class="form-control" placeholder="login" required="required" />
                        </div>
                        <div>
                            <input type="password" class="form-control" placeholder="mot de passe" required="required" />
                        </div>
                        <div>
                            <!-- <a class="btn btn-default submit" href="index.html">se connecter </a> --> 
                            <input class="btn btn-default submit" value="se connecter" type="submit" />  
                            <a class="reset_pass" href="#">mot de passe oublier?</a>
                        </div>
                        <div class="clearfix"></div>
                        <div class="separator">

                           
                            <div class="clearfix"></div>
                            <br />
                            <div>
                                <h1><i><img class="logo" alt="logo" src="http://www.si-smart.ma/Logo.png"></i> SmartFerme!</h1>

                                <p>©2015 Tous les droits sont réservés</p>
                            </div>
                        </div>
                    </form>
                    <!-- form -->
                </section>
                <!-- content -->
            </div>
           
        </div>
            <!-- /page content -->

        </div>
        <!-- footer content -->
    </div>

    <div id="custom_notifications" class="custom-notifications dsp_none">
        <ul class="list-unstyled notifications clearfix" data-tabbed_notifications="notif-group">
        </ul>
        <div class="clearfix"></div>
        <div id="notif-group" class="tabbed_notifications"></div>
    </div>

    

    <!-- /footer content -->
</body>

</html>