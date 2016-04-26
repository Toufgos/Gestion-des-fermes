<%@page import="si.smart.ferme.entities.Famille"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Plantation et Recult</title>
<meta name="description" content="">
<meta name="author" content="TOUFGA">

<meta name="viewport" content="width=device-width; initial-scale=1.0">

<!-- Replace favicon.ico & apple-touch-icon.png in the root of your domain and delete these references -->
<link rel="shortcut icon" href="/favicon.ico">
<link rel="apple-touch-icon" href="/apple-touch-icon.png">
<!-- Bootstrap core CSS -->

<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet">

<link
	href="<%=request.getContextPath()%>/resources/fonts/css/font-awesome.min.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/animate.min.css"
	rel="stylesheet">
<script
	href="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>

<!-- chart js -->
<script
	href="<%=request.getContextPath()%>/resources/js/chartjs/chart.min.js"></script>
<!-- bootstrap progress js -->
<script
	href="<%=request.getContextPath()%>/resources/js/progressbar/bootstrap-progressbar.min.js"></script>
<script
	href="<%=request.getContextPath()%>/resources/js/nicescroll/jquery.nicescroll.min.js"></script>
<!-- icheck -->
<script
	href="<%=request.getContextPath()%>/resources/js/icheck/icheck.min.js"></script>

<script href="<%=request.getContextPath()%>/resources/js/custom.js"></script>
<!-- form validation -->
<script
	href="<%=request.getContextPath()%>/resources/js/validator/validator.js"></script>

<!-- Custom styling plus plugins -->
<link href="<%=request.getContextPath()%>/resources/css/custom.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/css/icheck/flat/green.css"
	rel="stylesheet">

<script href="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>

<!--[if lt IE 9]>
		<script href="<%=request.getContextPath()%>/resources/../assets/js/ie8-responsive-file-warning.js"></script>
		<![endif]-->

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
		<script href="<%=request.getContextPath()%>/resources/https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script href="<%=request.getContextPath()%>/resources/https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
    $('input[type=radio][name=mode]').change(function() {
        if (this.value == 'c') {
            $("#menuPlantation").hide();
        }
        else  {
        	 $("#menuPlantation").show();
        }
    });
	$("#famille").change(function() {
		var v = $("#famille").val();
		var x = 0;
		alert("1");
		   $.get('AjaxFamille', {
	            data : v,
	            work : x
	       }, function(responseJson) {
	    	   //alert(responseJson);
	    	   alert("2");
	    	   $("#sousfamille option").remove();
	    	   $("#sousfamille").append(responseJson)
	    	   
	       });

	});
	
	$("#sousfamille").change(function() {
		alert("3");
		var v = $("#sousfamille").val();
		var x = 1;
		alert("cal : "+ v);
		   $.post('AjaxFamille', {
	            data2 : v,
	            work : x
	       }, function(responseJson) {
	    	   //alert(responseJson);
	    	   alert("4");
	    	   $("#vari option").remove();
	    	   $("#vari").append(responseJson)
	    	   
	       });

	});

});
</script>
	
</head>

<body>
	<%
		session.setAttribute("page", "Plantation_Reculte");
	%>
	
	
		                
					
					
                             <f:form class="form-horizontal form-label-left" action="" modelAttribute="of"
						method="post">
						<p>
							les champs notés en
							<code> * </code>
							sont des champs obligatoires.
						</p>
						<input type="hidden" name="id_parce"
							value="5" />
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="nom">Ordre de Variété <span class="required">*</span>
							</label>
							<select name="ordrevar">
								<option value="1">1</option>
								<option value="2">2</option>
							</select>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="nom"> Famille <span class="required">* :</span>
							</label> 
							<select id="famille" name="famille">
								<c:forEach items="${fam}" var="f">
									<option value="${f.id }"> ${f.libelle } </option>
								</c:forEach> 
								
							</select>
							
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="nom"> Sous Famille <span class="required">* :</span>
							</label> 
							<select name="sousfamille" id="sousfamille" >
								<c:forEach items="${fam}" var="fa">
									<option value="${fa.id }"> ${fa.libelle } </option>
								</c:forEach>
							</select>
							
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="nom"> Variété <span class="required">* :</span>
							</label> 
							<select name="variete" id="vari">
								<c:forEach items="${fam}" var="fa">
									<option value="${fa.id }"> ${fa.libelle } </option>
								</c:forEach>
							</select>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="nom"> Mode <span class="required">* :</span>
							</label> 	
							<p>
                               Plantation  <input type="radio" class="flat" name="mode" id="plantation" value="p" checked="" required />
                               Culture  <input type="radio" class="flat" name="mode" id="culture" value="c"  required= />
                            </p>	
						</div>
						
						<div id="menuPlantation">
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="nom"> écart <span class="required">* :</span>
								</label> 
							</div>	
							<div class="item form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="nom"> longueur </label>
								 <input type="number" name="x" step="0.1" > 
								 
							</div>
							<div class="item form-group">	 
									<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="nom"> largeur </label>
									 <input type="number" name="y" step="0.1" > 
								
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="nom"> Nombre d'arbres <span class="required">* :</span>
								</label> 
								<input type="number" name="arbrenbr" />
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="nom"> Année de Plantation <span class="required">* :</span>
								</label> 
								<input type="number" name="anneeplantation" />
							</div>
						</div>
						
						
						<div class="form-group">
							<div class="col-md-6 col-md-offset-3">
								

								<button id="send" name="submit" value="update" type="submit"
									class="btn btn-success">modifier</button>
							</div>
						</div>
					</f:form>
                            
                    
	
	
</body>
</html>