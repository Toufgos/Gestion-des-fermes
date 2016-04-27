<%@page import="si.smart.ferme.entities.Ferme"%>
<%@include file="menu.jsp" %>

<!--  Scripts Place  -->

<link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery-1.10.2.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery-ui.js"></script>

<!-- PNotify -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/notify/pnotify.core.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/notify/pnotify.buttons.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/notify/pnotify.nonblock.js"></script>
 
<!--[if lt IE 9]>
		<script href="<%=request.getContextPath()%>/resources/../assets/js/ie8-responsive-file-warning.js"></script>
		<![endif]-->

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
		<script href="<%=request.getContextPath()%>/resources/https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script href="<%=request.getContextPath()%>/resources/https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
<script type="text/javascript"
	src="http://maps.google.com/maps/api/js?sensor=true&libraries=drawing"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.4.2.min.js"></script>
<!--Global variables!-->

<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true&libraries=drawing"></script>

<!--Global variables!-->
<script>
//This variable gets all coordinates of polygone and save them. Finally you should use this array because it contains all latitude and longitude coordinates of polygon.
var coordinates = [];

//This variable saves polygon.
var polygons = [];

function show_stack_modal(type) {
    var opts = {
        title: "Over Here",
        text: "Check me out. I'm in a different stack.",
        addclass: "stack-modal",
        stack: stack_modal
    };
    switch (type) {
    case 'error':
        opts.title = "Oh No";
        opts.text = "Watch out for that water tower!";
        opts.type = "error";
        break;
    case 'info':
        opts.title = "Breaking News";
        opts.text = "Have you met Ted?";
        opts.type = "info";
        break;
    case 'success':
        opts.title = "Good News Everyone";
        opts.text = "I've invented a device that bites shiny metal asses.";
        opts.type = "success";
        break;
    }
    new PNotify(opts);
}
</script>

<script>
//This function save latitude and longitude to the polygons[] variable after we call it.
function save_coordinates_to_array(polygon)
{
    //Save polygon to 'polygons[]' array to get its coordinate.
    polygons.push(polygon);

    //This variable gets all bounds of polygon.
    var polygonBounds = polygon.getPath();
    
	$("#dialog-1").append("<p> voici les point qui forment le polygone qui entoure le térritoire de la ferme: </p>");
	var tt="";
	 tt += "{\n"; 
	 tt +='"polygone" :'+$('#ferme_id').val()+' ,'; 
	 tt += '"coor": [' + "\n";
    for(var i = 0 ; i < polygonBounds.length ; i++)
    {
        coordinates.push(polygonBounds.getAt(i).lat(), polygonBounds.getAt(i).lng());
        //alert(polygonBounds.getAt(i).lat()+"  /   "+ polygonBounds.getAt(i).lng());
        var ii=i+1;
		$("#dialog-1").append(" Point "+ii+" :<br/>");
		 $("#dialog-1").append('<label>Latitiude  : '+polygonBounds.getAt(i).lat()+' </label>'
				 + '  <label>Latitiude  : '+polygonBounds.getAt(i).lng()+' </label>');
		
		 $("#dialog-1").append("<br/>");
		 tt += "{\n"
				tt += '"latitude" : '
						+ polygonBounds.getAt(i).lat() + ",\n";
				tt += '"longitude" : '
						+ polygonBounds.getAt(i).lng() + "\n";
				if (i != polygonBounds.length - 1)
					tt += "},\n";
				else
					tt += "}\n"; 
    }   
    $("#dialog-1").append("<div><input type=\"submit\" id=\"add\"value=\"valider\">  <input type=\"reset\"  value=\"annuler\"></div>");
	 $( "#dialog-1" ).dialog( "open" ); 
	 tt += "]}\n";
	 /* tt += "}\n";  */
	$("#txt").append(tt);
}
</script>

<script>
function initialize()
{
    //Create a Google maps.
    var map = new google.maps.Map(document.getElementById('map'), {zoom: 12, center: new google.maps.LatLng(32.344, 51.048)});

    //Create a drawing manager panel that lets you select polygon, polyline, circle, rectangle or etc and then draw it.
    var drawingManager = new google.maps.drawing.DrawingManager();
    drawingManager.setMap(map);

    //This event fires when creation of polygon is completed by user.
    google.maps.event.addDomListener(drawingManager, 'polygoncomplete', function(polygon) {
        //This line make it possible to edit polygon you have drawed.
        polygon.setEditable(true);

        //Call function to pass polygon as parameter to save its coordinated to an array.
        save_coordinates_to_array(polygon);

        //This event is inside 'polygoncomplete' and fires when you edit the polygon by moving one of its anchors.
        google.maps.event.addListener(polygon.getPath(), 'set_at', function () {
            alert('changed');
            save_coordinates_to_array(polygon);
            });

        //This event is inside 'polygoncomplete' too and fires when you edit the polygon by moving on one of its anchors.
        google.maps.event.addListener(polygon.getPath(), 'insert_at', function () {
            alert('also changed');
            save_coordinates_to_array(polygon);
            });
    });
    
    // Ajax
    var name=$("#ferme_id").val();
   
    $.get('GetCoor', {
            data : name,
            
       }, function(responseJson) {
    	   var col1="#FF0F80";
    	   var col2="#0C45F0";
    	   var filtred1= responseJson.split("|");

    	   alert(filtred1);

    	   for( i in filtred1){

    	   	 var res = filtred1[i].split("/");
    	       	  var  triangleCoords=[];
    	   		   alert("res :"+res);
    	       	for( var i=0; i< res.length-1; i++){
    	       	    var res2 = res[i].split(":");   
    	       	   //alert(res2[0]+" "+res2[1]);
    	       	  triangleCoords.push( new google.maps.LatLng(res2[0], res2[1]));
    	       	}
    	       	 
    	       	  var bermudaTriangle = new google.maps.Polygon({
    	     		    paths: triangleCoords,
    	     		    strokeColor: col1,
    	     		    strokeOpacity: 0.8,
    	     		    strokeWeight: 2,
    	     		    fillColor: col2,
    	     		    fillOpacity: 0.35
    	     		  });
    	     	bermudaTriangle.setMap(map); 
    	   	alert("bermudaTriangle" +bermudaTriangle.getPath());
    	   	col1="#F05241";
    	   	col2="#88F041";
    	   }
  	//PNotify.removeAll();
       });
    

}

google.maps.event.addDomListener(window, 'load', initialize);
</script>


<script>
	$(document).ready(
			function() {
				$('#gen')
						.click(
								function() {
									var txt = "{\n";
									for (var i = 0; i < polygons.length; i++) {
										var idx = i + 1;
										txt += '"polygone" : ' + idx + ",\n";
										var x = polygons[i].getPath();
										txt += '"coor" : [' + "\n";
										$("#data")
												.append(
														"<h3>polygone " + i
																+ " :</h3>");
										for (var j = 0; j < x.length; j++) {

											$("#data").append(
													"Lat :" + x.getAt(j).lat()
															+ " Long :"
															+ x.getAt(j).lng()
															+ ";<br/>");
											txt += "{\n"
											txt += '"latitude" : '
													+ x.getAt(j).lat() + ",\n";
											txt += '"longitude" : '
													+ x.getAt(j).lng() + "\n";

											if (j != x.length - 1)
												txt += "},\n";
											else
												txt += "}\n";
										}
										if (i != polygons.length - 1)
											txt += "],\n";
										else
											txt += "]\n";
										
									}
									txt += "}\n";

									$("#data").append(txt);
									$("#txt").val(txt);
									alert($("#txt").val());
								});
			});
</script>
<script>
	
	$(document).ready(function() {
		
		$.get('TestAja', {
            data : name
       }, function(responseJson) {
    	
    	   alert("normalement hna salina");
    	 $('#ajaxGetUserServletResponse').text(responseJson)
    	 
    		/*var coorjson='{"coor":'+responseJson+'}';
    		alert(coorjson);
    		obj = JSON.parse(coorjson);
    		var polypath=[];
    		
    		for (var i = 1; i < obj.coor.length; i++){
    			/* alert(obj.coor[i].longitude+ " " + obj.coor[i].latitude); */
    		/*	var pt=new Object();
    			pt.lat=obj.coor[i].longitude;
    			pt.lng=obj.coor[i].latitude;
    			polypath.push(new google.Maps.LatLng(obj.coor[i].latitude,obj.coor[i].longitude ));
    			
    			}
            $('#ajaxGetUserServletResponse').text(responseJson); */
            var p = new google.maps.Polygon({
			    paths: responseJson,
			    strokeColor: '#FF0F80',
			    strokeOpacity: 0.8,
			    strokeWeight: 2,
			    fillColor: '#875544',
			    fillOpacity: 0.35
			  });
            p.setMap(map);
            
            setTimeout(function(){ $('#ajaxGetUserServletResponse').remove(); alert("rederiction"); }, 10000);
        });
		
		
		$('#json').click(function() {
			var jsonStr = JSON.stringify(polygons);
			alert(jsonStr);

		});
		$('.test').click(function() {
			/* var jsonStr = JSON.stringify(polygons); */
			alert();

		});
	});
</script>
<script>
         $(function() {
            $( "#dialog-1" ).dialog({
               autoOpen: false,  
            });
            $( "#opener" ).click(function() {
               $( "#dialog-1" ).dialog( "open" );
            });
            $("#envoi").click(function(){
            	var name = $('#txt').val();
                $.get('TestAja', {
                        data : name,
                        entite : "ferme",
                }, function(responseJson) {
                	alert(responseJson);
                     $(function () {
                    	 new PNotify({
                    		    title: 'Succée !',
                    		    text: responseJson,
                    		    type: 'success'
                    		  
                    		});
                    	 document.location.reload();
                     });
                 
                    setTimeout(function(){ $('#ajaxGetUserServletResponse').remove(); alert("rederiction"); }, 10000);
                });
            });
         });
        /*  $("#send").click(function(){
        	var idvar=$("ferme_id").val();
        	var entitevar= "ferme";
        	$get('UpdateEntite',{
        		id : idvar,
        		entite : entitevar,
        		 nom;
        	 adresse;
        	 ville;
        	 titre;
        	 groupe;
        	 submit;
        	 id_Ferme;
        	}, function(res){
        		
        	});
        	
         }); */
      </script>
 <script src="<%=request.getContextPath()%>/resources/js/jquery-1.10.2.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery-ui.js"></script>
<style>
.Map{
	float: left;
    width: 500px;
    height: 500px;
}
</style>

<!-- Scripts   -->

	<%
		session.setAttribute("page", "ajoutFerme");
	%>
	<% Ferme farm= (Ferme) session.getAttribute("la_ferme"); %>
	
		<!-- /page content -->
		<div class="right_col" role="main">

			
				<div class="page-title">
				
					<div class="title_left">
						<h3>Projet Gestion des fermes</h3>
						<input id="ferme_id" value="${la_ferme.id_Ferme }" type="hidden"/>
						<%-- <c:out value="${la_ferme.nom_Ferme }"></c:out><input id="ferme_id" value="${la_ferme.id_Ferme }" type="hidden"/>
						<h4>ferme : <%=farm.getNom_Ferme() %> </h4> --%>
					</div>
					
					<div class="title_right">
						<div
							class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
							<div class="input-group">
								<input type="text" class="form-control"
									placeholder="Chercher..."> <span
									class="input-group-btn">
									<button class="btn btn-default" type="button">oK!</button>
								</span>
							</div>
						</div>
					</div>
					
				</div>
				<div class="clearfix"></div>

				<div class="row">
					
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>
										Ajouter une ferme <small>nouvelle ferme</small>
									</h2>

									<div class="clearfix"></div>
								</div>

								<div class="x_content">
								<div class="Map" >
									<f:form action="ModifierFerme" class="form-horizontal form-label-left" >

										<p>
											les champs notés en
											<code> * </code>
											sont des champs obligatoires.
										</p>
										<input id="ferme_id" name="id_Ferme" value="${la_ferme.id_Ferme }" type="hidden"/>
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="nom">Nom <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input id="nom" class="form-control col-md-7 col-xs-12"
													name="nom" 
													required="required" type="text" value="${la_ferme.nom_Ferme }" >
											</div>
										</div>
										
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="nom">proprietaire_ferme 
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input id="proprietaire_ferme" class="form-control col-md-7 col-xs-12"
													name="prop" 
													required="required" type="text" value="${la_ferme.proprietaire_ferme }" >
											</div>
										</div>
										
										
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="adresse">Adresse <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input type="text" id="adresse" placeholder="Adresse de la ferme"
													required="required" name="adresse"
													class="form-control col-md-7 col-xs-12" value="${la_ferme.adresse }">
											</div>
										</div>
										
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="ville">Ville <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input type="text" id="ville" name="ville"
													required="required" class="form-control col-md-7 col-xs-12"
													value="${la_ferme.ville_ferme }">
											</div>
										</div>
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="ville">Pays <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input type="text" id="pays" name="pays"
													required="required" class="form-control col-md-7 col-xs-12"
													value="${la_ferme.pays_ferme }">
											</div>
										</div>
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="number">Titre foncier <span class="required">*</span>
											</label>
											<div class="col-md-5 col-sm-5 col-xs-12">
												<input type="number" step="0.01" id="titre" name="titre"
													required="required" data-validate-minmax="0,100000000"
													class="form-control col-md-7 col-xs-12" value="${la_ferme.titre_foncier_ferme }" >

											</div>
											
										</div>
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="Groupe">Groupe </label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<select name="groupe" id="groupe"
													class="form-control col-md-7 col-xs-12">
														<option selected="selected" value="${la_ferme.groupe.id }">
														${la_ferme.groupe.nom }</option>
													<c:forEach items="${persos }" var="p">
														<option value="${p.id }">${p.nom }</option>
													</c:forEach>
													
												</select>
											</div>
										</div>
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="Groupe">Gérant </label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<select name="gerant" id="groupe"
													class="form-control col-md-7 col-xs-12">
														<option selected="selected" value="${la_ferme.gerant.id }">
														${la_ferme.gerant.nom }</option>
													<c:forEach items="${persos }" var="group">
														<option value="${group.id }">${group.nom }</option>
													</c:forEach>
												</select>
											</div>
										</div>
										
										<div class="form-group">
										<div class="col-md-6 col-md-offset-3"></div>
											<div class="col-md-6 col-md-offset-3">
												<button id="send" value="Modifier" name="submit"
												 type="submit"	 class="btn ">Modifier</button>
											</div>
										</div>
									</f:form>
								</div>
								<div class="Map" id="map"></div>
								
								<div id="dialog-1" 
								      title="voici les coordonnées de votre polygone: ">
								
								      <input type="button" id="envoi" value="ok" />
								</div>
								<button id="gen">Generer data</button>
								<p>.</p>
								<div id="ajaxGetUserServletResponse"></div>
								<form>
									<textarea id="txt" name="txt" rows="10" cols="10" type="hidden"></textarea>
									<input id="json" name="json" value="json" type="submit" /> 
								</form>
								
								
							</div>
						</div>
					</div>
					</div>
					</div>
       <%@include file="footer.jsp" %>