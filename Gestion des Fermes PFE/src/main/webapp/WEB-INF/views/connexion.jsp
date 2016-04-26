<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"  %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

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

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css">
</head>
<%-- <body>
	<div>
		<f:form modelAttribute="AdminForm" method="post" action="login">
			<table>
				<tr>
					<td>login:</td>
					<td><f:input path="login"/></td>
					<td><f:errors path="login"></f:errors></td>
				</tr>
				<tr>
					<td>pass:</td>
					<td><f:input path="pass"/></td>
					<td><f:errors path="pass"></f:errors></td>
				</tr>
					<tr>
					<td><input type="submit" value="ok"></td>
				</tr>
			</table>
		</f:form>
		<c:if test="${not empty AdminForm.exception}">
			${AdminForm.exception }
		</c:if>
		
	</div>
</body>
 --%>
 <body style="background:#F7F7F7;">
    
    <div class="">
        <a class="hiddenanchor" id="toregister"></a>
        <a class="hiddenanchor" id="tologin"></a>

        <div id="wrapper">
            <div id="login" class="animate form">
                <section class="login_content">
                 <h1>se connecter </h1>
                    <f:form modelAttribute="AdminForm" method="post" action="login">
                        <h1>.</h1>
                        <div>
                            <f:input path="login" type="text" class="form-control" placeholder="Utilisateur" required="" />
                            <f:errors path="login"></f:errors>
                            
                        </div>
                        <div>
                            <f:input path="motpass" type="password" class="form-control" placeholder="mot de passe" required="" />
                            <f:errors path="motpass"></f:errors>
                        </div>
                        <div>
                        	<c:if test="${not empty AdminForm.exception}">
							${AdminForm.exception }
							</c:if>
                        </div>
                        <div>
                            <input type="submit" class="btn btn-default submit" value="se connecter"/>
                            <a class="reset_pass" href="#">Mot de passe oublié</a>
                        </div>
                        <div class="clearfix"></div>
                        <div class="separator">
                            <div class="clearfix"></div>
                            <br />
                            <div>
                                <h1><i class="fa fa-paw" style="font-size: 26px;"></i> TAMSAMANI & TOUFGA</h1>
                                <p>©2015 tous les droits sont reservés, TAMSAMANI & TOUFGA. Privacy and Terms</p>
                            </div>
                        </div>
                    </f:form>
                  
                    <!-- form -->
                </section>
                <!-- content -->
            </div>

        </div>
    </div>

</body>

</html>
</html>
