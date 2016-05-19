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
				 $("#res").append("<h4> "+obj.id+" : "+obj.Description +" </h4>");
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
	  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
/*
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          ['Work',     11.2],
          ['Eat',      2.4],
          ['Commute',  2.3],
          ['Watch TV', 2.9],
          ['Sleep',    7.1]
        ]);
		*/
		var data = google.visualization.arrayToDataTable([
			['Task', 'Hours per Day'],
			<c:forEach items="${data}" var="d">
			['${d.key}',    parseFloat('${d.value}')],
			</c:forEach>
		]); 
        var options = {
          title: 'quatité de produit dans le stock',
          pieHole: 0.5,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
    <script type="text/javascript">
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {
      var data = google.visualization.arrayToDataTable([
        ['jour', 'température', 'eau'],
        ['1/01', 20, 12], ['2/01', 20, 12], ['3/01', 7, 12], ['4/01', 20, 12],['5/01', 26, 1],
        ['6/01', 20, 12], ['9/01', 20, 12], ['12/01', 7, 12], ['15/01', 20, 12],['18/01', 26, 1],
        ['7/01', 20, 12], ['10/01', 20, 12], ['13/01', 7, 12], ['16/01', 20, 12],['19/01', 26, 1],
        ['8/01', 20, 12], ['11/01', 20, 12], ['14/01', 12, 12], ['17/01', 20, 12],['20/01', 26, 1],
        ['21/01', 20, 12], ['23/01', 20, 12], ['25/01', 7, 12], ['27/01', 20, 12],['29/01', 26, 1],
        ['22/01', 20, 12], ['24/01', 20, 12], ['26/01', 7, 12], ['28/01', 3, 20],['30/01', 26, 1],
     ]);

      var options = {
        title: 'température Vs Pluie',
        curveType: 'function',
        legend: { position: 'bottom' }
      };


      var chart = new google.visualization.LineChart(document.getElementById('chart_div2'));
      chart.draw(data, options);
    }
    </script>
</head>
<body>
 <div id="piechart" style="width: 900px; height: 500px;"></div>
 <div id="chart_div2" style="width: 900px; height: 500px;"></div>
<h1>Test réuissi :D l hamdolillah </h1>
</body>
<input type="button" id="btn" value="Click Me" />
<input id="userName" type="text" />

<div id="res"></div>
<h3>ajaxGetUserServletResponse</h3>
<div id="ajaxGetUserServletResponse"></div>
<div>Helllllllllllllllllllllll</div>

	<a href="<c:url value="/ajoutFerme"/>">Ajout Ferme</a>
	<c:forEach items="${data}" var="d">
			['${d.key}',     '${d.value}'],
			</c:forEach>
</html>



