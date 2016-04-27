<%@include file="menu.jsp" %>
<!DOCTYPE html>
<% session.setAttribute("page","listerVarietes");%>
	
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
            
            $( "#deleting" ).dialog({
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
                                    <h2>Voici la liste des Variétés <small></small></h2>
                                    
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
                                                <th>age Adulte </th>
                                                <th>Sous Famille </th>
                                                <th class=" no-link last"><span class="nobr">Action</span>
                                                </th>
                                            </tr>
                                        </thead>
										
                                        <tbody>
                                        
                                        	<c:forEach items="${Varietes }" var="li">
                                        	<tr>
                                        	<%System.out.println("heere 1"); %>
                                        		<td class=" ">${li.nom }</td>
                                        		<%System.out.println("heere 2"); %>
                                                <td class=" ">${li.ageAdulte } </td>
                                                <%System.out.println("heere 3"); %>
                                                <td class=" ">${li.sousfamille.libelle } </td>
                                                
                                                <%System.out.println("heere"); %>
                                    
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
						<div id="dialogForUpdating" title="Modification d'une Activité "
			style="display: table-cell; vertical-align: middle; text-align: center">

			<input type="hidden" value="" id="idUpdating" /> 
			<div class="item form-group hid">
									<label class="control-label col-md-3 col-sm-3 col-xs-12"
										for="nom"> Sous Famille <span class="required">*</span>
									</label>

									<div class="col-md-6 col-sm-6 col-xs-12">
										<select id="entite" class="form-control col-md-7 col-xs-12">
											<c:forEach items="${ss }" var="a">
												<option value="${a.id }">${a.libelle }</option>
											</c:forEach>

										</select>
									</div>
								</div>
								<div class="item form-group hid">
									<label class="control-label col-md-3 col-sm-3 col-xs-12"
										for="nom">libellé : </label>

									<div class="col-md-6 col-sm-6 col-xs-12">
										<input type="text" class="form-control col-md-7 col-xs-12" id="libelle" />
									</div>
								</div>
								<div class="item form-group hid">
									<label class="control-label col-md-3 col-sm-3 col-xs-12"
										for="nom">Age Adulte : </label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<input type="number" class="form-control col-md-7 col-xs-12" id="age" />
									</div>
								</div>
			<br/>	
			<button id="submitUpdating">Modifier</button>
			
		</div>
		<div id="waiting" title="wait please !">
				<p>Please wait</p>
			<img class="test" src="http://loadingapng.com/templates/4/preview.gif" alt="waiting" width="100" height="100">
		</div>
		<div id="deleting" title="supression" style="display: table-cell; vertical-align: middle; text-align: center">
			<p>Vous êtes sûre que vous voulez supprimer cette variété ? /p>
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
            		 var entitevar="Variete";
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
			          	    	  
			          	    	    
			          	    	    $("img").remove(".test");
			          	    	    $("#idUpdating").val(idvar);
			          	    	    $("#entite").val(res[0]);
			          	    	    $("#libelle").val(res[1]);
			          	    	    $("#age").val(res[2]);
			          	    	    
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
            		 var entitevar="Variete";
            		 $("#dialogForUpdating").dialog("close");
            		 $("#waiting").dialog("open");
            		 setTimeout(function(){  }, 3000);
            		 $.get('UpdateEntite', {
            	            id : idvar,
            	            entite : entitevar,
            	            libelle : $("#libelle").val(),
            	            sous : $("#entite").val(),
            	            age : $("#age").val(),
            	       }, function(response) {
            	    	   var res=response.split(":");
            	    	   $("#example").append('<tr><td class=" ">'+res[0]+'</td> <td class=" ">'+res[1]+'</td></tr>');
            	    	  
            	  	//PNotify.removeAll();
            	       });
            		 $("#waiting").dialog("close");
            		 location.reload();
            		 });
            	 
            	 
            	 
            	 $("#submitDeleting").click(function(event){
            		 var idvar= $("#idUpdating").val();
            		 var entitevar="Variete";
            		 $("#dialogForUpdating").dialog("close");
            		 $("#waiting").dialog("open");
            		//alert(idvar+" "+entitevar);	
            		alert("we are sending data to the controller");
            		 $.get('RemoveEntite', {
            	            id : idvar,
            	            entite : entitevar,
            	       }, function(response) {
            	    	  
            	    	   alert("recu : "+response);
            	    	   
            	  	//PNotify.removeAll();
            	       }); 
            		 $("#waiting").dialog("close");
            		 location.reload();
            		 });
            	 
            	 
            	 $(".remove").click(function(event){
            		 var idvar= $(this).prop("value");
            		 var entitevar="Variete";
            			 alert(idvar + "   "+ entitevar);
            		 	 $("#submitDeleting").show();
	            	     $("#deleting").dialog("open");
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
		
