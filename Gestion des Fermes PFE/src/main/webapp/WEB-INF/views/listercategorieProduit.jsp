<%@include file="menu.jsp" %>
<!DOCTYPE html>
<% session.setAttribute("page","listerModes");%>

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
<script>
         $(function() {
            $( "#dialogForUpdating" ).dialog({
               autoOpen: false,  
            });
            $( "#waiting" ).dialog({
                autoOpen: false,  
             });
            $("#deleting")dialog({
            	autoOpen: false,
            });
         });
      </script>
		
		<script src="<%=request.getContextPath()%>/resources/js/datatables/js/jquery.dataTables.js"></script>
        <script src="<%=request.getContextPath()%>/resources/js/datatables/tools/js/dataTables.tableTools.js"></script>
		
		<div class="right_col" role="main">
		
                    <div class="page-title">
                       
                    </div>
                    <div class="clearfix"></div>

                    <div class="row">

                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Voici la liste des Catégories des Produits <small></small></h2>
                                    
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
                                        
                                        	<c:forEach items="${cats }" var="li">
                                        	<tr>
                                        	
                                        		<td class=" ">${li.nom}</td>
                                        		
                                                <td class=" ">${li.description } </td>
                                                
                                                
                                                <td class=" last">

													<f:form modelAttribute="ff" action="coorMaps" method="post">
														<input name="id_Ferme" id="id_Ferme"
															value="${li.id }" type="hidden" />
														<button type="submit" class="btn  btn-xs do">
															<i class="fa"> </i> <i class="fa fa-home"></i>
															Afficher
														</button>
													</f:form>
													<button type="button" value="${li.id }" 
											class="btn update btn-xs do">
											<i class="fa"> </i> <i class="fa fa-wrench"></i>

										</button>
										<button type="button" value="${li.id }" 
											class="btn remove  btn-xs do">
											<i class="fa"> </i> <i class="fa fa-times"></i>

										</button> 

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
					<!-- 	<div id="dialogForUpdating" title="Modification d'une Activité "
			style="display: table-cell; vertical-align: middle; text-align: center">

			<input type="hidden" value="" id="idUpdating" />
			<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="nom">Nom <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input id="nom" class="form-control col-md-7 col-xs-12"
													name="nom" placeholder="Nom du mode"
													required="required" type="text">
											</div>
										</div>
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="adresse">description <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<textarea id="description" placeholder=" description du mode"
													required="required" name="adresse"
													class="form-control col-md-7 col-xs-12"></textarea>
											</div>
										</div>
			<br/>	
			<button id="submitUpdating">Modifier</button>
			
		</div>
		<div id="waiting" title="wait please !">
				<p>Please wait</p>
			<img class="test" src="http://loadingapng.com/templates/4/preview.gif" alt="waiting" width="100" height="100">
		</div>
		    </div>
                </div>
           <div id="deleting" title="suppression" >
			<p>vous êtes sûres que vous voulez supprimer ce mode d'irriguation ? </p>
			<button  id="submitDeleting">Supprimer</button>
		</div> -->
                
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
            		 var entitevar="Mode";
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
			          	    	    $("#nom").val(res[0]);
			          	    	    $("#description").val(res[1]);
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
            		 var entitevar="Mode";
            		 $("#dialogForUpdating").dialog("close");
            		 //$("#waiting").dialog("open");
            		 
            		 $.get('RemoveEntite', {
            	            id : idvar,
            	            entite : entitevar,
            	           
            	       }, function(response) {
            	    	   alert(response);
            	       });
            		 $("#waiting").dialog("close");
            		 location.reload();
            		 });
            	 $("#submitDeleting").click(function(event){
            		 var idvar= $("#idUpdating").val();
            		 var entitevar="Mode";
            		// $("#dialogForUpdating").dialog("close");
            		// $("#waiting").dialog("open");
            		//alert(idvar+" "+entitevar);	
            		 $.get('RemoveEntite', {
            	            id : idvar,
            	            entite : entitevar,
            	       }, function(response) {
            	    	  
            	    	   alert("recu : "+response);
            	    	   
            	  	//PNotify.removeAll();
            	       }); 
            		 $("#deleting").dialog("close");
            		 location.reload();
            		 });
            	 $(".remove").click(function(event){
            		 var idvar= $(this).prop("value");
            		 var entitevar="Mode";
            		 
            		 $("#submitDeleting").show();
            		 $("#submitUpdating").hide();
            		 
            		 $("#deleting").dialog("open");
            		 alert("7tal hna khdam");
            		    /* $("#dialogForUpdating").append('<img class="test" src="http://loadingapng.com/templates/4/preview.gif" alt="Smiley face" width="42" height="42">');
            		 
	       	    	    $("#libelleUpdating").hide();
	       	    	    $("#observationUpdating").hide();
	       	    	    $("#submitDeleting").hide();
	       	    	    $(".hid").hide();
	       	    	 $.get('InitialiserEntite', {
	          	            id : idvar,
	          	            entite : entitevar,
       	            
			          	       }, function(response) {
			          	    	   alert(response);
			          	    	    var res=response.split(":");
			          	    	    var nul="null";
			          	    	    $('input .hid').attr('disabled','disabled');
			          	    	    $("img").remove(".test");
			          	    	    $("#idUpdating").val(idvar);
			          	    	    $("#nom").val(res[0]);
			          	    	    $("#description").val(res[1]);
			          	    	    $("#libelleUpdating").show();
			       	    	        $("#observationUpdating").show();
					       	    	$("#submitUpdating").show();
					       	    	$(".hid").show();
					       	    	$("img").remove(".test");
			          	    	   $("#dialogForUpdating").dialog("open");
			          	    	   
		          	       		}); */
	            		 $("#idUpdating").val(idvar); 
	            		 
	            	     
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
		
