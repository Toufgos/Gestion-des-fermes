<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" >
<title>Test</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap core CSS -->
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet">


<link
	href="<%=request.getContextPath()%>/resources/fonts/css/font-awesome.min.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/animate.min.css"
	rel="stylesheet">

<!-- Custom styling plus plugins -->
<link href="<%=request.getContextPath()%>/resources/css/custom.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/css/icheck/flat/green.css"
	rel="stylesheet">


<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>

<!--[if lt IE 9]>
        <script src="../assets/js/ie8-responsive-file-warning.js"></script>
        <![endif]-->

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style.css">
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/input_mask/jquery.inputmask.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>

	<!-- chart js -->
	<script
		src="<%=request.getContextPath()%>/resources/js/chartjs/chart.min.js"></script>
	<!-- bootstrap progress js -->
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/moment.min2.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/datepicker/daterangepicker.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/progressbar/bootstrap-progressbar.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/nicescroll/jquery.nicescroll.min.js"></script>
	<!-- icheck -->
	<script
		src="<%=request.getContextPath()%>/resources/js/icheck/icheck.min.js"></script>

	<script src="<%=request.getContextPath()%>/resources/js/custom.js"></script>
	<!-- form wizard -->
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/wizard/jquery.smartWizard.js"></script>
	
	<script type="text/javascript">
	$(document).ready(function() {
		
		 $("#btn").click(function(){
			/*  $.ajax({
				 type: 'GET',
				 headers: {  
					 accept : "application/json; charset=utf-8",
					 "Content-Type": "application/json; charset=utf-8"
				 },
				 url :'http://localhost:8080/emp/result/json',
				 success : function(data){
					 $("#res").html(data.id+'   -    '+data.nom);
				 }
			 }); */
			var json= $('#ajaxGetUserServletResponse').text();
			
			 $.each($.parseJSON(json), function(idx, obj) {
				 $("#res").append("<h1> "+idx+" </h1>");
				 $("#res").append("<h4> "+obj.id+" : "+obj.Description +" </h14>");
				});
			
		 });
		 $("#res").append("Ok");
		 
	});
	
	</script>
	
	<script type="text/javascript">
	$(document).ready(function() {
        $('#userName').blur(function(event) {
                var name = $('#userName').val();
                $.get('TestAja', {
                        data : name
                }, function(responseText) {
                        $('#ajaxGetUserServletResponse').text(responseText);
                       
                });
        });
       
});
	</script>
</head>
<body>
<h1>Test réuissi :D l hamdolillah </h1>
</body>
<input type="button" id="btn" value="Click Me" />
<input id="userName" type="text" />

<div id="res"></div>
<h3>ajaxGetUserServletResponse</h3>
<div id="ajaxGetUserServletResponse"></div>
<div>Helllllllllllllllllllllll</div>

	<a href="<c:url value="/ajoutFerme"/>">Ajout Ferme</a>
	
</html>