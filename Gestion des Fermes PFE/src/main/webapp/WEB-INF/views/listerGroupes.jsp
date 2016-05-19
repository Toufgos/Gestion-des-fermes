<%@include file="menu.jsp" %>
<!DOCTYPE html>
<% session.setAttribute("page","listerGroupe");%>

<!-- /page content -->
		
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


<!-- PNotify -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/notify/pnotify.core.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/notify/pnotify.buttons.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/notify/pnotify.nonblock.js"></script>

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
		
		<script src="<%=request.getContextPath()%>/resources/js/datatables/js/jquery.dataTables.js"></script>
        <script src="<%=request.getContextPath()%>/resources/js/datatables/tools/js/dataTables.tableTools.js"></script>
		
		<div class="right_col" role="main">
		
                    <div class="page-title">
                        <div class="title_left">
							<h3>Projet Gestion des fermes</h3>
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
                                    <h2>Voici la liste des Groupes  <small></small></h2>
                                    
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <table id="example" class="table table-striped responsive-utilities jambo_table">
                                        <thead>
                                            <tr class="headings">
                                                <!-- <th>
                                                    <input type="checkbox" class="tableflat">
                                                </th> -->
                                                <th>Nom </th>
                                                <th>Description </th>
                                                
                                                <th class=" no-link last"><span class="nobr">Action</span>
                                                </th>
                                            </tr>
                                        </thead>
										
                                        <tbody>
                                        
                                        	<c:forEach items="${Groupes }" var="li">
                                        	<tr>
                                        	
                                        		<td class=" ">${li.nom }</td>
                                        		
                                                <td class=" ">${li.description } </td>
                                                
                                                
                                    
                                                <td class=" last">

													<f:form modelAttribute="ff" action="coorMaps" method="post">
														<input name="id_Ferme" id="id_Ferme"
															value="${li.id }" type="hidden" />
														<button type="submit" class="btn  btn-xs do">
															<i class="fa"> </i> <i class="fa fa-home"></i>
															Afficher
														</button>
														<button type="button" value="${li.id }" 
											class="btn update btn-xs do">
											<i class="fa"> </i> <i class="fa fa-wrench"></i>

										</button>
										<button type="button" value="${li.id }" 
											class="btn remove  btn-xs do">
											<i class="fa"> </i> <i class="fa fa-times"></i>

										</button> 
													</f:form>

                                        	</tr>
                                        	</c:forEach>
                                         
                                        </tbody>

                                    </table>
                                </div>
                            </div>
                        </div>

                        <br />
                        <br />
                        <br />
						<div id="dialogForUpdating" title="Modification d'un groupe "
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
				<p>voulez-vous vraiment supprimer ce groupe </p>
				<button  id="submitDeleting">Supprimer</button>
			
		</div>
                    </div>
                </div>
                
               <script>
            $(document).ready(function () {
            	$("#submitDeleting").hide();
            	$("#submitUpdating").hide();
            	//$("#waiting").hide();
            	
            	 
            	
            	 $(".update").click(function(event){
            		 var idvar= $(this).prop("value");
            		 var entitevar="Groupe";
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
            		 var entitevar="Groupe";
            		 $("#waiting").dialog("open");
            		 alert($("#idUpdating").val()+" / "+$("#libelleUpdating").val()+" / "+$("#observationUpdating").val());
            		 $.get('UpdateEntite', {
         	            id : idvar,
         	            entite : entitevar,
         	            libelle : $("#libelleUpdating").val() ,
         	            observation: $("#observationUpdating").val() ,
         	       }, function(response) {
         	    	   alert(response);
         	    	   new PNotify({
         	    		    title: 'Groupe Modifié !',
         	    		    text: response,
         	    		    delay: 2500,
         	    		    type: 'success'
         	    		});
         	    	   $("#dialogForUpdating").dialog("close");
         	    	    
         	  	//PNotify.removeAll();
         	       });
            		 alert("fin");
            		 $("#waiting").dialog("close");
            		 
            		 });
            	 
            	 $("#submitDeleting").click(function(event){
            		 var idvar= $("#idtodelete").val();
            		 var entitevar="Groupe";
            		 
            		 $("#waiting").dialog("open");
            		alert(idvar+" "+entitevar);	
            		 $.get('RemoveEntite', {
            	            id : idvar,
            	            entite : entitevar,
            	       }, function(response) {
            	    	  
            	    	   new PNotify({
            	    		    title: 'Groupe Supprimé !',
            	    		    text: response,
            	    		    delay: 2500,
            	    		    type: 'success'
            	    		});
            	    	   
            	  	//PNotify.removeAll();
            	       }); 
            		 PNotify.removeAll();
            		 $("#waiting").dialog("close");
            		 $("#deleting").dialog("close");
            		
            		 });
            	 $(".remove").click(function(event){
            		 var idvar= $(this).prop("value");
            		 var entitevar="Groupe";
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
        
	<%@include file="footer.jsp" %>	
		
