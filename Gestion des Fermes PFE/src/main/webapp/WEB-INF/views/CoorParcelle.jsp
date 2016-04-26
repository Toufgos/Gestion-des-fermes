<%@page import="si.smart.ferme.entities.Culture"%>
<%@page import="si.smart.ferme.entities.Plantation"%>
<%@page import="si.smart.ferme.entities.Parcellaire"%>
<%@page import="si.smart.ferme.entities.Ferme"%>
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
<!--Global variables!-->
<script>
//This variable gets all coordinates of polygone and save them. Finally you should use this array because it contains all latitude and longitude coordinates of polygon.
var coordinates = [];

//This variable saves polygon.
var polygons = [];
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
	 tt +='"polygone" :'+$('#idP').val()+' ,'; 
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
   // alert("ferme : "+name);
    $.get('GetCoor', {
            data : name
       }, function(responseJson) {
    	   //alert(responseJson);
    	   var col1="#FF0F80";
    	   var col2="#0C45F0";
    	   var filtred1= responseJson.split("|");

    	  // alert(filtred1);

    	   for( i in filtred1){

    	   	 var res = filtred1[i].split("/");
    	       	  var  triangleCoords=[];
    	   		  // alert("res :"+res);
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
    	   	//alert("bermudaTriangle" +bermudaTriangle.getPath());
    	   	col1="#F05241";
    	   	col2="#88F041";
    	   }
  	//PNotify.removeAll();
       });
    
    // Ajax
    name=$("#idP").val();
    //alert("parcelle : "+name);
    $.get('MapPoint', {
            data : name,
       }, function(responseJson) {
    	   //alert(responseJson);
    	    var res = responseJson.split("/");
    	    triangleCoords=[];
    	for( var i=0; i< res.length-1; i++){
    	    var res2 = res[i].split(":");   
    	   //alert(res2[0]+" "+res2[1]);
    	  triangleCoords.push( new google.maps.LatLng(res2[0], res2[1]));
    	}
    	  
    	  
    	  var bermudaTriangle = new google.maps.Polygon({
  		    paths: triangleCoords,
  		    strokeColor: '#F2CA27',
  		    strokeOpacity: 0.8,
  		    strokeWeight: 2,
  		    fillColor: '#050505',
  		    fillOpacity: 0.75
  		  });
  	bermudaTriangle.setMap(map);
       });
}
    



google.maps.event.addDomListener(window, 'load', initialize);
</script>

<style>
.Map{
	float: left;
    width: 500px;
    height: 500px;
}
</style>

 <script src="<%=request.getContextPath()%>/resources/js/jquery-1.10.2.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery-ui.js"></script>



			<div class="right_col" role="main">

			
				<div class="page-title">
				
					<div class="title_left">
						<h3>Projet Gestion des fermes</h3>
						<c:out value="${parce.libelle }"></c:out><input id="idP" value="${parce.id_parce }" type="hidden"/>
						<input id="ferme_id" value="${ferme.id_Ferme }" type="hidden"/>
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
										Ajouter une parcelle : <small>nouvelle parcelle</small>
									</h2>

									<div class="clearfix"></div>
								</div>

								<div class="x_content">
								<div class="Map" >
								<div class="" role="tabpanel" data-example-id="togglable-tabs">
                                        <ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
                                            <li role="presentation" class="active"><a href="#tab_content1" id="home-tab" role="tab" data-toggle="tab" aria-expanded="true">Infos Général</a>
                                            </li>
                                            <li role="presentation" class=""><a href="#tab_content2" role="tab" id="profile-tab" data-toggle="tab"  aria-expanded="false">Occupation</a>
                                            </li>
                                           <!--  <li role="presentation" class=""><a href="#tab_content3" role="tab" id="profile-tab2" data-toggle="tab" aria-expanded="false">Profile</a>
                                            </li> -->
                                        </ul>
                                        <div id="myTabContent" class="tab-content">
                                            <div role="tabpanel" class="tab-pane fade active in" id="tab_content1" aria-labelledby="home-tab">
                                            
                            <form id="UpdateParce">               
                                            	<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="nom">Ferme 
							</label> 
							
							<select  name="id_ferme">
								<c:forEach items="${ fermes}" var="li" >
									<option value="${li.id_Ferme }" > ${li.nom_Ferme }</option>
									<c:if test="${li.id_Ferme == parce.ferme.id_Ferme  }">
                                     <option selected="selected" value="${li.id_Ferme }" > ${li.nom_Ferme }</option>
                                 </c:if>
								</c:forEach>							
							</select>
							
						</div>
						
							
							
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="nom">Libelle 
							</label> <input type="text" name="libelle" value="${parce.libelle}"
								placeholder="libelle Parcelaire " />
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="nom">Superficie brute 
							</label> <input type="number" name="s_brute" value="${parce.s_brute}"
								placeholder="superficie brute" />
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="nom">Superficie inculte 
							</label> <input type="number" name="s_inculte" value="${parce.s_inculte}"
								placeholder="superficie inculte" />
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="nom">Type : 
							</label>
							 <select  id="ok" name="typeParcelaire">
								
								<c:if test="${parce['class'].name == 'si.smart.ferme.entities.ParcellaireBour' }">
                                       <option  value="1" >Irrégué</option>
									   <option selected="selected" value="0">Bour</option> 			
                                 </c:if>
                                <c:if test="${parce['class'].name == 'si.smart.ferme.entities.ParcellaireIrregue' }">
                                        <option selected="selected" value="1" >Irrégué</option>
									   <option value="0">Bour</option> 			
                           		</c:if>	
							</select>
						</div>
						<%-- <c:if test="${parce['class'].name == 'si.smart.ferme.entities.ParcellaireIrregue' }">
						 --%>
						<div id="mode" class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="nom">Mode d'irrégation 
							</label> 
							<% System.out.println("Avant les modes "); %>
							<select name="modeIr"  >
							<option></option>
							<c:forEach items="${modes }" var="mode">
								<option value="${mode.id_mode }">${mode.nom_mode }</option>
								<c:if test="${parce['class'].name == 'si.smart.ferme.entities.ParcellaireIrregue' }">
								<c:if test="${mode.id_mode == parce.mode.id_mode  }">
                                     <option selected="selected" value="${mode.id_mode }">${mode.nom_mode }</option>
                                 </c:if>
                                 </c:if>
							</c:forEach>
							</select>
							<% System.out.println("aprés les modes "); %>
						</div>
						<%-- </c:if> --%>
						<c:if test="${parce['class'].name == 'si.smart.ferme.entities.ParcellaireBour' }">
							<script type="text/javascript">
							$("#mode").hide();
							</script>
						</c:if>
						<div class="form-group">
							<div class="col-md-6 col-md-offset-3">
								

								<button id="send" name="submit"   value="${parce.id_parce }" type="submit"
									class="btn btn-success updateParcelle">Confimer La modification</button>
							</div>
							</form> 
						</div>
                                            	    
                                                
                                            </div>
                                            <div role="tabpanel" class="tab-pane fade" id="tab_content2" aria-labelledby="profile-tab">
                                            
                                         <f:form id="updateOCCUP" class="form-horizontal form-label-left" action="" modelAttribute="of"
						method="post">
						
						<input type="hidden" name="id_parce"
							value="${parce.id_parce }" />
						<c:if test="${empty occupation}">
						    <code> NB ! cette Parcelle n'est pas encore occupée </code>
						    
						</c:if>
						<input type="hidden" id="idOcup" value="${occupation.id }" /> 
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="nom">Ordre de Variété 
							</label>
							<select name="ordrevar">
							<option value="${occupation.ordrevariete }">${occupation.ordrevariete }</option>
								<option value="1">1</option>
								<option value="2">2</option>
							</select>
							<% System.out.println("okok ordrevariete"); %>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="nom"> Famille 
							</label> 
							<select id="famille" name="famille">
								<option></option>
								<c:forEach items="${familles}" var="f">
								
									<option value="${f.id }"> ${f.libelle } </option>
									<c:if test="${f.id == occupation.variete.sousfamille.famille.id  }">
									<option selected="selected" value="${f.id }"> ${f.libelle } </option>
									</c:if>
								</c:forEach> 
								
							</select>
							<% System.out.println("okok Famille"); %>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="nom"> Sous Famille 
							</label> 
							<select name="sousfamille" id="sousfamille" >
							<option></option>
							<option selected="selected" value="${occupation.variete.sousfamille.id }" >${occupation.variete.sousfamille.libelle}</option>
								<c:forEach items="${fam}" var="fa">
									<option value="${fa.id }"> ${fa.libelle } </option>
								</c:forEach>
							</select>
							<% System.out.println("okok SousFamille"); %>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="nom"> Variété 
							</label> 
							<select name="variete" id="vari">
							<option></option>
							<option selected="selected" value="${occupation.variete.id }" >${occupation.variete.nom}</option>
								<c:forEach items="${fam}" var="fa">
									<option value="${fa.id }"> ${fa.libelle } </option>
								</c:forEach>
							</select>
							<% System.out.println("okok Variete"); %>
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="nom"> Mode 
							</label> 	
							<label>${occupation['class'].name}</label>
							<c:choose>
						    
								<c:when test="${occupation['class'].name == 'si.smart.ferme.entities.Plantation' }">
							<p>
							   Plantation  <input type="radio" class="flat" name="mode" id="plantation" value="p" checked="checked" required />
                              
                               Culture  <input type="radio" class="flat" name="mode" id="culture" value="c"  required />
                               </p>
							</c:when>
							
							<c:when test="${occupation['class'].name == 'si.smart.ferme.entities.Culture' }">
                             <p> 
                               Plantation  <input type="radio" class="flat" name="mode" id="plantation" value="p" required />
                              
                               Culture  <input type="radio" class="flat" name="mode" id="culture" value="c" checked="checked" required />
                            </p>	
                            </c:when>
                            <c:otherwise >
                             <p> 
                               Plantation  <input type="radio" class="flat" name="mode" id="plantation" value="p" required />
                              
                               Culture  <input type="radio" class="flat" name="mode" id="culture" value="c"  required />
                            </p>	
                            </c:otherwise>
                            	</c:choose>
                            
						</div>
						<c:if test="${occupation['class'].name != 'si.smart.ferme.entities.Culture' }">
						<div id="menuPlantation">
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="nom"> écart 
								</label> 
							</div>	
							<div class="item form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="nom"> longueur </label>
								 <input type="number" name="x" value="${occupation.ecartX }"  step="0.1" > 
								 <% System.out.println("okok ecartX"); %>
								 
							</div>
							<div class="item form-group">	 
									<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="nom"> largeur </label>
									 <input type="number" name="y" value="${occupation.ecartY }"  step="0.1" > 
								<% System.out.println("okok ecartY"); %>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="nom"> Nombre d'arbres 
								</label> 
								<input type="number" value="${occupation.nbrArbres }"   name="arbrenbr" />
								<% System.out.println("okok nbrArbres"); %>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="nom"> Année de Plantation 
								</label> 
								<input type="number" value="${occupation.annePlantation }" name="anneeplantation" />
								<% System.out.println("okok annePlantation"); %>
							</div>
						</div>
						</c:if>
						
						<div class="form-group">
							<div class="col-md-6 col-md-offset-3">
								<c:if test="${empty occupation}">
						       		 <button id="AddOcup" name="submit"  value="${parce.id_parce }" type="submit"
									class="btn btn-success updateOccupation">Ajouter</button>
						        </c:if>
								
								<c:if test="${not empty occupation}">
									<button id="ocup" name="submit"  value="${parce.id_parce }" type="submit"
									class="btn btn-success updateOccupation">modifier</button>
								</c:if>	
							</div>
						</div>
					</f:form>
                                              
                                               </div>
                                           <!--  <div role="tabpanel" class="tab-pane fade" id="tab_content3" aria-labelledby="profile-tab">
                                                <p>xxFood truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo booth letterpress, commodo enim craft beer mlkshk </p>
                                            </div> -->
                                        </div>
                                    </div>
									
								</div>
								<div class="Map" id="map"></div>
								
								<div id="dialog-1" 
								      title="voici les coordonnées de votre polygone: ">
								
								      <input type="button" id="envoi" value="ok" />
								</div>
								<button class="toBeHidden" id="gen">Generer data</button>
								<p class="toBeHidden">.</p>
								<div class="toBeHidden" id="ajaxGetUserServletResponse"></div>
								<form class="toBeHidden">
									<textarea id="txt" name="txt" rows="10" cols="10" type="hidden"></textarea>
									<input id="json" name="json" value="json" type="submit" /> 
								</form>
								
								
							</div>
						</div>
					</div>
					</div>
					</div>
					
<%@include file="footer.jsp" %>	

<!-- Javascript -->
<script>
         $(function() {
            $( "#dialog-1" ).dialog({
               autoOpen: false,  
            });
            
            $(".toBeHidden").hide();
            
            
            $("#famille").change(function() {
        		var v = $("#famille").val();
        		var x = 0;
        		
        		   $.get('AjaxFamille', {
        	            data : v,
        	            
        	       }, function(responseJson) {
        	    	   //alert(responseJson);
        	    	  
        	    	   $("#sousfamille option").remove();
        	    	   $("#sousfamille").append(responseJson)
        	    	   
        	       });

        	});
        	
        	$("#sousfamille").change(function() {
        		
        		var v = $("#sousfamille").val();
        		var x = 1;
        		//alert(v);
        		   $.post('AjaxSousFamille', {
        	            data : v,
        	           
        	       }, function(responseJson) {
        	    	 //  alert(responseJson);
        	    	  
        	    	   $("#vari option").remove();
        	    	   $("#vari").append(responseJson)
        	    	   
        	       });

        	});
            
            $("#ok").blur(function(){
            	if( $("#ok").val()==1){
            		$("#mode").show();
            	}
				if( $("#ok").val()==0){
            		$("#mode").hide();
            	}
            });
            
            $(':radio[name="mode"]').change(function() {
            	  var r= $(this).filter(':checked').val();
            	  if(r=="p" ){
              		
              		$("#menuPlantation").show();
              		
              	}
  				if(r=="c" ){
  					$("#menuPlantation").hide();
              	}
            	});
            
            $("#envoi").click(function(){
            	var name = $('#txt').val();
                $.get('TestAja', {
                        data : name,
                        entite : "parce",
                }, function(responseJson) {
                	
                     $(function () {
                    	 new PNotify({
                    		    title: 'Succée !',
                    		    text: responseJson,
                    		    type: 'success'
                    		});

                     });
                 
                    setTimeout(function(){ $('#ajaxGetUserServletResponse').remove();  }, 100);
                });
            });
           
         });
         
         
         
         $(function () {
        	    $('#updateOCCUP').submit(function () {
        	    	var idvar = $("#idOcup").val();
               	 var entitevar = "Occupation";
               	 alert(idvar+" "+entitevar);
               	 $.ajax({
               		    type : 'POST',
               		    url : 'UpdateEntite',
               		    data : $('#updateOCCUP').serialize()+ "&id="+idvar+"&entite="+entitevar,
               	
               		success : function(data) {
               		     alert(data); 
               		      $(function () {
                           	 new PNotify({
                           		    title: 'Succée !',
                           		    text: data,
                           		    type: 'success'
                           		});
               		     }); 
               		     
               		}
               	 });
        	        return false;
        	    });
        	    
        	    $('#UpdateParce').submit(function () {
        	      
        	    	var idvar = $("#idP").val();
               	  var entitevar = "Parcelle";
               	
               	 $.ajax({
               		    type : 'POST',
               		    url : 'UpdateEntite',
               		    data : $('#UpdateParce').serialize()+ "&id="+idvar+"&entite="+entitevar,
               	
               		success : function(data) {
               			
               		     var res=data.split(":");
               		    
	               		 if(res[2]==0)
	               		 var typ="success";
	               		 if(res[2]==1)
	               		 var typ="error";
               		      $(function () {
                           	 new PNotify({
                           		    title:res[0],
                           		    text: res[1],
                           		    type: typ,
                           	 		delay :2500
                           		});
               		     }); 
               		     
               		}
               	 });
        	        return false;
        	    });
        	    
        	    
        	});
         
         
         /* 
         $("#ocup").click(function(){
        	 var idvar = $("#idOcup").val();
        	 var entitevar = "Occupation";
        	 alert(idvar+" "+entitevar);
        	 $.ajax({
        		    type : 'POST',
        		    url : 'UpdateEntite',
        		    data : $('#updateOCCUP').serialize()+ "&id="+idvar+"&entite="+entitevar,
        	
        		success : function(data) {
        		     alert(data); 
        		     /* $(function () {
                    	 new PNotify({
                    		    title: 'Succée !',
                    		    text: data,
                    		    type: 'success'
                    		});
        		     }); */
        		     
        	/*	}
        	 });
         }); */
      </script>
