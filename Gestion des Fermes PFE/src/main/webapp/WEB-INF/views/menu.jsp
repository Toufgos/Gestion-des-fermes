<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"  %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>MyApplication| </title>

    <!-- Bootstrap core CSS -->

    <link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet">

    <link href="<%=request.getContextPath()%>/resources/fonts/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/animate.min.css" rel="stylesheet">

    <!-- Custom styling plus plugins -->
    <link href="<%=request.getContextPath()%>/resources/css/custom.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/icheck/flat/green.css" rel="stylesheet">
     <link href="<%=request.getContextPath()%>/resources/css/datatables/tools/css/dataTables.tableTools.css" rel="stylesheet">
	<!-- editor -->
    <link href="http://netdna.bootstrapcdn.com/font-awesome/3.0.2/css/font-awesome.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/editor/external/google-code-prettify/prettify.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/editor/index.css" rel="stylesheet">
    <!-- select2 -->
    <link href="<%=request.getContextPath()%>/resources/css/select/select2.min.css" rel="stylesheet">
    <!-- switchery -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/switchery/switchery.min.css" />
    <script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<link
	href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<!-- CSS -->
<style>
.ui-widget-header, .ui-state-default, ui-button {
	background: #b9cd6d;
	border: 1px solid #b9cd6d;
	color: #FFFFFF;
	font-weight: bold;
}
</style>
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
    	<!-- form validation -->
	<script
		src="<%=request.getContextPath()%>/resources/js/validator/validator.js"></script>
	<script>
			// initialize the validator function
			validator.message['date'] = 'not a real date';

			// validate a field on "blur" event, a 'select' on 'change' event & a '.reuired' classed multifield on 'keyup':
			$('form').on('blur', 'input[required], input.optional, select.required', validator.checkField).on('change', 'select.required', validator.checkField).on('keypress', 'input[required][pattern]', validator.keypress);

			$('.multi.required').on('keyup blur', 'input', function() {
				validator.checkField.apply($(this).siblings().last()[0]);
			});

			// bind the validation to the form submit event
			//$('#send').click('submit');//.prop('disabled', true);

			$('form').submit(function(e) {
				e.preventDefault();
				var submit = true;
				// evaluate the form using generic validaing
				if (!validator.checkAll($(this))) {
					submit = false;
				}

				if (submit)
					this.submit();
				return false;
			});

			/* FOR DEMO ONLY */
			$('#vfields').change(function() {
				$('form').toggleClass('mode2');
			}).prop('checked', false);

			$('#alerts').change(function() {
				validator.defaults.alerts = (this.checked) ? false : true;
				if (this.checked)
					$('form .alert').remove();
			}).prop('checked', false);
		</script>

</head>


<body class="nav-md">

    <div class="container body">


        <div class="main_container">

            <div class="col-md-3 left_col">
                <div class="left_col scroll-view">

                    <div class="navbar nav_title" style="border: 0;">
                        <a href="index.html" class="site_title"><img alt="logo" class="logo" src="http://www.si-smart.ma/Logo.png"> <span>SI-SMART</span></a>
                    </div>
                    <div class="clearfix"></div>


                    <!-- menu prile quick info -->
<!--                     <div class="profile">
                        <div class="profile_pic">
                            <img src="images/img.jpg" alt="..." class="img-circle profile_img">
                            <span class="img-circle profile_img image glyphicon glyphicon-use" ></span>
                        </div>
                        <div class="profile_info">
                            <span>Welcome,</span>
                            <h2>Anthony Fernando</h2>
                        </div>
                    </div> -->
                    <!-- /menu prile quick info -->

                    <br />

                    <!-- sidebar menu -->
                    <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

                        <div class="menu_section">
                            <h3>paramétrage</h3>
                            <ul class="nav side-menu">
                            	<li><a><i class="fa fa-home"></i> Groupe  <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="  <c:url value="ajouterGroupe" />" > Ajouter un nouveau Groupe</a>
                                        </li>
                                        <li><a href="  <c:url value="listerGroupes" />" > Afficher tout les Groupes</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-home"></i> Personnels  <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="  <c:url value="error404" />" > Ajouter un nouveau Personnel</a>
                                        </li>
                                        <li><a href="  <c:url value="error404" />" > Afficher tout les Groupes</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-home"></i> Fermes  <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="  <c:url value="ajoutFerme" />" >Ajouter une nouvelle ferme</a>
                                        </li>
                                        <li><a href="  <c:url value="afficherFerme" />" > Afficher toutes les fermes</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-edit"></i> Parcelles <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="  <c:url value="ajouterParce" />" >Ajouter une nouvelle Parcelle</a>
                                        </li>
                                        <li><a href="  <c:url value="listerParcelles" />" >Afficher Toutes Les Parcelles</a>
                                        </li>
                                        
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-table"></i> Activités  <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="  <c:url value="ajouterActivite" />" >Ajouter une nouvelle activité</a>
                                        </li>
                                        <li><a href="  <c:url value="listerActivites" />" >Afficher Toutes Les Activités</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-desktop"></i> Familles <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="  <c:url value="ajouterFamille" />" >Ajouter une nouvelle Famille</a>
                                        </li>
                                        <li><a href="  <c:url value="listerFamilles" />" >Afficher toutes les Familles</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-desktop"></i> Sous Familles <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="  <c:url value="ajouterSousFamille" />" >Ajouter une nouvelle Sous Famille</a>
                                        </li>
                                        <li><a href="  <c:url value="listerSousFamilles" />" >Afficher toutes les Sous Familles</a>
                                        </li>
                                    </ul>
                                </li>
                                 <li><a><i class="fa fa-desktop"></i> Variétés <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="  <c:url value="ajouterVariete" />" >Ajouter une nouvelle Variété</a>
                                        </li>
                                        <li><a href="  <c:url value="listerVareites" />" >Afficher toutes les Variétés</a>
                                        </li>
                                    </ul>
                                </li>
                                   <li><a><i class="fa fa-desktop"></i> Modes d'irrigation <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="  <c:url value="ajoutModeIr" />" >Ajouter une nouveau Mode d'irrigation</a>
                                        </li>
                                        <li><a href="  <c:url value="listerModes" />" >Afficher tout les Modes d'irrigation</a>
                                        </li>
                                    </ul>
                                </li>
                              
                                    </ul>
                                </li>
                            </ul>
                        </div>
                        <div class="menu_section">
                            <h3>Traitement</h3>
                            <ul class="nav side-menu">
                                <li><a><i class="fa fa-bug"></i> Exemple Pages <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="  <c:url value="error404" />" >exemple</a>
                                        </li>
                                        <li><a href="  <c:url value="ajouterClimat" />" >ajouterClimat</a>
                                        </li>
                                        <li><a href="  <c:url value="listerClimat" />" >listerClimat</a>
                                        </li>
                                        
                                    </ul>
                                </li>
                            </ul>
                        </div>
                        
                        <div class="menu_section">
                            <h3>état</h3>
                             <ul class="nav side-menu">
                                <li><a><i class="fa fa-bug"></i> Exemple Pages <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                    	<li><a href="  <c:url value="EtatSynthese" />" >Etat de synthèse</a>
                                        <li><a href="  <c:url value="error404" />" >exemple</a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </div>

                    </div>
                    <!-- /sidebar menu -->

                    <!-- /menu footer buttons -->
                    <div class="sidebar-footer hidden-small">
                        <a data-toggle="tooltip" data-placement="top" title="Settings">
                            <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                        </a>
                        <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                            <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
                        </a>
                        <a data-toggle="tooltip" data-placement="top" title="Lock">
                            <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
                        </a>
                        <a data-toggle="tooltip" data-placement="top" title="Logout">
                            <span class="glyphicon glyphicon-off" aria-hidden="true"> </span>
                        </a>
                    </div>
                    <!-- /menu footer buttons -->
                </div>
            </div>

            <!-- top navigation -->
            <div class="top_nav">

                <div class="nav_menu">
                    <nav class="" role="navigation">
                        <div class="nav toggle">
                            <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                        </div>

                        <ul class="nav navbar-nav navbar-right">
                            <li class="">
                                <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                   <span class="image fa-user" ></span>User Name
                                    <span class=" fa fa-angle-down"></span>
                                </a>
                                <ul class="dropdown-menu dropdown-usermenu animated fadeInDown pull-right">
                                    <li><a href="javascript:;">  Profile</a>
                                    </li>
                                    <li>
                                        <a href="javascript:;">
                                            <span class="badge bg-red pull-right">50%</span>
                                            <span>Settings</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="javascript:;">Help</a>
                                    </li>
                                    <li><a href="<c:url value='/j_spring_security_logout' />"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
                                    </li>
                                </ul>
                            </li>

                            <li role="presentation" class="dropdown">
                                <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                                    <i class="fa fa-envelope-o"></i>
                                    <span class="badge bg-green">1</span>
                                </a>
                                <ul id="menu1" class="dropdown-menu list-unstyled msg_list animated fadeInDown" role="menu">
                                    <li>
                                        <a>
                                            <span class="image fa-user" >
                                       
                                    </span>
                                            <span>
                                        <span>expéditeur du msg</span>
                                            <span class="time">11:32</span>
                                            </span>
                                            <span class="message">
                                        voici le contenu du message ....
                                    </span>
                                        </a>
                                    </li>
                                    
                                    <li>
                                        <div class="text-center">
                                            <a>
                                                <strong>Voir Toutes les notifications</strong>
                                                <i class="fa fa-angle-right"></i>
                                            </a>
                                        </div>
                                    </li>
                                </ul>
                            </li>

                        </ul>
                    </nav>
                </div>

            </div>
            <!-- /top navigation -->
