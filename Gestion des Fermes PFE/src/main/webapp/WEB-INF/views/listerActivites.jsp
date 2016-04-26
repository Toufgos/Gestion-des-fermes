<%@include file="menu.jsp"%>
<!DOCTYPE html>
<% session.setAttribute("page","listerActivites");%>

<!-- /page content -->

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<!-- PNotify -->
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/notify/pnotify.core.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/notify/pnotify.buttons.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/notify/pnotify.nonblock.js"></script>

<!--[if lt IE 9]>
				<script href="<%=request.getContextPath()%>/resources/../assets/js/ie8-responsive-file-warning.js"></script>
				<![endif]-->

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
				<script href="<%=request.getContextPath()%>/resources/https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
				<script href="<%=request.getContextPath()%>/resources/https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
				<![endif]-->

<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery-1.4.2.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/datatables/js/jquery.dataTables.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/datatables/tools/js/dataTables.tableTools.js"></script>
<meta charset="utf-8">
<title>jQuery UI Dialog functionality</title>
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
<!-- Javascript -->
<script>
         $(function() {
            $( "#dialogForUpdating" ).dialog({
               autoOpen: false,  
            });
            $( "#waiting" ).dialog({
                autoOpen: false,  
             });
            $( "#deleting" ).dialog({
                autoOpen: false,  
             });
         });
      </script>


<div class="right_col" role="main">

	<div class="page-title"></div>
	<div class="clearfix"></div>

	<div class="row">

		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="x_panel">
				<div class="x_title">
					<h2>
						Voici la liste des Activités <small></small>
					</h2>

					<div class="clearfix"></div>
				</div>
				<div class="x_content">
					<table id="example"
						class="table table-striped responsive-utilities jambo_table">
						<thead>
							<tr class="headings">
								<!-- <th>
                                                    <input type="checkbox" class="tableflat">
                                                </th> -->
								<th>libelle</th>
								<th>observation</th>
								<th class=" no-link last"><span class="nobr">Action</span>
								</th>
							</tr>
						</thead>

						<tbody>

							<c:forEach items="${Activites }" var="li">
								<tr>

									<td class=" ">${li.libelle }</td>

									<td class=" ">${li.observation }</td>

									<td class=" last">
										<%-- <f:form modelAttribute="ff" action="#" method="post"> --%>
										<input name="id_Ferme" id="id_Ferme" value="${li.id }"
										type="hidden" />
										<button type="button" value="${li.id }"
											class="btn afficher btn-xs do">
											<i class="fa"> </i> <i class="fa fa-eye"></i>

										</button>
										<button type="button" value="${li.id }" 
											class="btn update btn-xs do">
											<i class="fa"> </i> <i class="fa fa-wrench"></i>

										</button>
										<button type="button" value="${li.id }" 
											class="btn remove  btn-xs do">
											<i class="fa"> </i> <i class="fa fa-times"></i>

										</button> <%-- </f:form> --%>
									</td>	
								</tr>
							</c:forEach>

						</tbody>

					</table>
				</div>
			</div>
		</div>

		<br /> <br /> <br />
		<div id="dialogForUpdating" title="Modification d'une Activité "
			style="display: table-cell; vertical-align: middle; text-align: center">

			<input type="hidden" value="" id="idUpdating" /> <label class="hid">Libelle:</label>
			<input id="libelleUpdating" name="libelleUpdating" type="text">
			<label class="hid ">Observation:</label> <input
				id="observationUpdating" name="observationUpdating" type="text">
			<br/>	
			<button id="submitUpdating">Modifier</button>
			
		</div>
		<div id="waiting" title="wait please !">
				<p>Please wait</p>
			<img class="test" src="http://loadingapng.com/templates/4/preview.gif" alt="waiting" width="100" height="100">
		</div>

		<div id="deleting" title="Attention  !">
		<input type="hidden" value="" id="idtodelete" /> 
				<p>voulez-vous vraiment supprimer cette activité </p>
				<button  id="submitDeleting">Supprimer</button>
			
		</div>


	</div>



	<script>
            $(document).ready(function () {
            	$("#submitDeleting").hide();
            	$("#submitUpdating").hide();
            	//$("#waiting").hide();
            	
            	 $(".afficher").click(function(event){
            		 
            		 var idvar= $(this).prop("value");
            		 var  entite="Activite";
            		 //alert(idvar+" "+ entite);
            		 
            		 $.get('InitialiserEntite', {
	         	            id : idvar,
	         	            entite : entitevar,
	         	            
	         	       		}, function(response) {
		         	    	   alert(response);
		         	    	    var res=response.split(":");
		         	    	    $("#idUpdating").val(idvar);
		         	    	    $("#libelleUpdating").val(res[0]);
		         	    	    $("#observationUpdating").val(res[1]);
		         	    	   $("#dialogForUpdating").dialog("open");
		         	    	   
		         	  	//PNotify.removeAll();
		         	       }); 
	            		 //alert("ok2");
            		 });
            	
            	 $(".update").click(function(event){
            		 var idvar= $(this).prop("value");
            		 var entitevar="Activite";
            			$("#submitUpdating").show();
            			$("#submitDeleting").hide();
            		    $("#dialogForUpdating").append('<img class="test" src="http://loadingapng.com/templates/4/preview.gif" alt="Smiley face" width="42" height="42">');
            		 
	       	    	    $("#libelleUpdating").hide();
	       	    	    $("#observationUpdating").hide();
	       	    	    $("#submitUpdating").hide();
	       	    	    $(".hid").hide();
            		 $.get('InitialiserEntite', {
	          	            id : idvar,
	          	            entite : entitevar,
          	            
			          	       }, function(response) {
			          	    	   alert(response);
			          	    	    var res=response.split(":");
			          	    	    var nul="null";
			          	    	    $("img").remove(".test");
			          	    	    $("#idUpdating").val(idvar);
			          	    	    $("#libelleUpdating").val(res[0]);
			          	    	    $("#observationUpdating").val(res[1]);
			          	    	    $("#libelleUpdating").show();
			       	    	        $("#observationUpdating").show();
					       	    	$("#submitUpdating").show();
					       	    	$(".hid").show();
					       	    	$("img").remove(".test");
			          	    	   $("#dialogForUpdating").dialog("open");
			          	    	   
		          	       		}); 
	            		 $("#idUpdating").val(idvar);
	
	            	     $("#dialogForUpdating").dialog("open");
            		
            		 });
            	 $("#submitUpdating").click(function(event){
            		 var idvar= $("#idUpdating").val();
            		 var entitevar="Activite";
            		 $("#deleting").dialog("close");
            		 $("#waiting").dialog("open");
            		 
            		 $.get('UpdateEntite', {
            	            id : idvar,
            	            entite : entitevar,
            	            libelle : $("#libelleUpdating").val() ,
            	            observation: $("#observationUpdating").val() ,
            	       }, function(response) {
            	    	   
            	    	   new PNotify({
            	    		    title: 'Activite Modifiée !',
            	    		    text: response,
            	    		    delay: 2500,
            	    		    type: 'success'
            	    		});
            	    	   $("#dialogForUpdating").dialog("close");
            	    	    
            	  	//PNotify.removeAll();
            	       });
            		 $("#waiting").dialog("close");
            		 
            		 });
            	 
            	 $("#submitDeleting").click(function(event){
            		 var idvar= $("#idtodelete").val();
            		 var entitevar="Activite";
            		 $("#dialogForUpdating").dialog("close");
            		 $("#waiting").dialog("open");
            		//alert(idvar+" "+entitevar);	
            		 $.get('RemoveEntite', {
            	            id : idvar,
            	            entite : entitevar,
            	       }, function(response) {
            	    	   
            	    	  
            	    	   new PNotify({
            	    		    title: 'Activite Supprimé !',
            	    		    text: response,
            	    		    delay: 2500,
            	    		    type: 'success'
            	    		});
            	     $("#deleting").dialog("close");
            	  	//PNotify.removeAll();
            	       }); 
            		 
            		 PNotify.removeAll();
            		 $("#waiting").dialog("close");
            		 $("#deleting").dialog("close");
            		
            		
            		 });
            	 $(".remove").click(function(event){
            		 var idvar= $(this).prop("value");
            		 var entitevar="Activite";
            		/*  $("#submitDeleting").show();
            		 $("#submitUpdating").hide();
            		    $("#dialogForUpdating").append('<img class="test" src="http://loadingapng.com/templates/4/preview.gif" alt="Smiley face" width="42" height="42">');
            		 
	       	    	    $("#libelleUpdating").hide();
	       	    	    $("#observationUpdating").hide();
	       	    	    $("#submitDeleting").hide();
	       	    	    $(".hid").hide();
            		 $.get('InitialiserEntite', {
	          	            id : idvar,
	          	            entite : entitevar,
          	            
			          	       }, function(response) {
			          	    	   //alert(response);
			          	    	    var res=response.split(":");
			          	    	    var nul="null";
			          	    	    $("img").remove(".test");
			          	    	    $("#idUpdating").val(idvar);
			          	    	    $("#libelleUpdating").val(res[0]);
			          	    	    $("#observationUpdating").val(res[1]);
			          	    	    $("#libelleUpdating").show();
			       	    	        $("#observationUpdating").show();
					       	    	$("#submitDeleting").show();
					       	    	$(".hid").show();
					       	    	$("img").remove(".test");
			          	    	   $("#dialogForUpdating").dialog("open");
			          	    	   
		          	       		}); 
	            		 $("#idUpdating").val(idvar);
	 */					 $("#idtodelete").val(idvar);
	            	     $("#deleting").dialog("open");
	            	     $("#submitDeleting").show();
            		 });
            	
            	
                $('input.tableflat').iCheck({
                    checkboxClass: 'icheckbox_flat-green',
                    radioClass: 'iradio_flat-green'
                });
                
            });

            var asInitVals = new Array();
            $(document).ready(function () {
                var oTable = $('#example').dataTable({
                    "oLanguage": {
                        "sSearch": "Chercher dans tout les colonnes :"
                    },
                    "aoColumnDefs": [
                        {
                            'bSortable': true,
                            'aTargets': [0]
                        } //disables sorting for column one
            ],
                    'iDisplayLength': 10,
                    "sPaginationType": "full_numbers",
                    "dom": 'T<"clear">lfrtip'
                    
                });
                $("tfoot input").keyup(function () {
                    /* Filter on the column based on the index of this element's parent <th> */
                    oTable.fnFilter(this.value, $("tfoot th").index($(this).parent()));
                });
                $("tfoot input").each(function (i) {
                    asInitVals[i] = this.value;
                });
                $("tfoot input").focus(function () {
                    if (this.className == "search_init") {
                        this.className = "";
                        this.value = "";
                    }
                });
                $("tfoot input").blur(function (i) {
                    if (this.value == "") {
                        this.className = "search_init";
                        this.value = asInitVals[$("tfoot input").index(this)];
                    }
                });
            });
        </script>
	<!-- Datatables -->

	<%@include file="footer.jsp"%>