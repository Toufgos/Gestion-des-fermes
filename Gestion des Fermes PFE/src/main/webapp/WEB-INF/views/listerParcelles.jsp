<%@include file="menu.jsp" %>

	<script src="<%=request.getContextPath()%>/resources/js/datatables/js/jquery.dataTables.js"></script>
        <script src="<%=request.getContextPath()%>/resources/js/datatables/tools/js/dataTables.tableTools.js"></script>
		<!-- CSS -->
		<link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">
<script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
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
		<!-- /page content -->
		<% session.setAttribute("page","ajoutFerme");%>
		<div class="right_col" role="main">

			<div class="">
				<div class="page-title">
					<div class="title_left">
						<h3>Groupe</h3>
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
										Voici la liste des Parcelles <small>xxxx </small>
									</h2>

									<div class="clearfix"></div>
								</div>
								<div class="x_content">

									<table id="example" class="table table-striped responsive-utilities jambo_table">
                                        <thead>
                                            <tr class="headings">
                                                <!-- <th>
                                                    <input type="checkbox" class="tableflat">
                                                </th> -->
                                                <th>Libelle </th>
                                                <th> Type </th>
                                                <th> Mode irrégation </th>
                                                <th>superficie Brute </th>
                                                <th>superficie Inculte </th>
                                                <th>superficie Nette </th>
                                                <th>Ferme </th>
                                                <th>activation </th>
                                                
                                                <th class=" no-link last"><span class="nobr">Action</span>
                                                </th>
                                            </tr>
                                        </thead>
										
                                        <tbody>
                                        
                                        	<c:forEach items="${Parcelles }" var="li">
                                        	<tr>
                                        	
                                        		<td class=" ">${li.libelle }</td>
                                        		<td class=" "> 
                                        		<c:if test="${li['class'].name == 'si.smart.ferme.entities.ParcellaireBour' }">
                                        			<c:out value="Bour"></c:out>
                                        			</c:if>
                                        		<c:if test="${li['class'].name == 'si.smart.ferme.entities.ParcellaireIrregue' }">
                                        			<c:out value="Irrégué"></c:out>
                                        		</c:if>	
                                        		</td>
                                        		<td>
                                        		<c:if test="${li['class'].name == 'si.smart.ferme.entities.ParcellaireBour' }">
                                        			<c:out value=""></c:out>
                                        			</c:if>
                                        		<c:if test="${li['class'].name == 'si.smart.ferme.entities.ParcellaireIrregue' }">
                                        			<c:out value="${li.mode.nom_mode }"></c:out>
                                        		</c:if>	
                                        		</td>
                                                <td class=" ">${li.s_brute } </td>
                                                
                                                <td class=" ">${li.s_inculte } </td>
                                                
                                                <td class=" ">${li.s_net } </td>
                                                
                                                <td class=" ">${li.ferme.nom_Ferme }</td>
                                                <td class=" ">
                                                	
                                                	<%-- <button type="button" value="${li.id_parce }" 
													class="btn occupation btn-xs do">
													<i class="fa"> </i> <i class="fa fa-home"></i>
		
												</button> --%>
												<c:if test="${li.activited  }">
												<input type="checkbox" class="ok" value="${li.id_parce }"  checked data-toggle="toggle" data-on="validé" data-off="pas encore">
                                                </c:if>
                                                <c:if test="${not li.activited  }">
												<input type="checkbox" class="ok" value="${li.id_parce }"  data-toggle="toggle" data-on="validé" data-off="pas encore">
                                                </c:if>
                                                </td>
                                                
                                                
                                                <td class=" last">

													<f:form modelAttribute="pf" action="CoorMapParce" method="post">
														<input name="parcelle_id" id="parcelle_id"
															value="${li.id_parce }" type="hidden" />
														<button type="submit" class="btn  btn-xs do">
															<i class="fa"> </i> <i class="fa fa-home"></i>
															Afficher
														</button>
													</f:form>
													<button type="button" value="${li.id_parce }" 
											class="btn update btn-xs do">
											<i class="fa"> </i> <i class="fa fa-wrench"></i>

										</button>
										<button type="button" value="${li.id_parce }" 
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
					</div>
					<div id="dialogForUpdating" title="Modification d'une Activité " class="hid"
			style="display: table-cell; vertical-align: middle; text-align: center">

			<input type="hidden" value="" id="idUpdating" />
			 <label class="hid">Libelle:</label>
			<input id="libelle"  type="text">
			<label class="hid ">type:</label> <input
				id="type"  type="text">
			<label>Mode irrigation</label>
			<input id="mode" type="text" />
			<label>Superficie Brute</label>
			<input id="S_brute" type="number" />	
			<label>Superficie inculte</label>
			<input id="S_inculte" type="number" />
			<label>Superficie Nette</label>
			<input id="S_net" type="number" />
			<label>Mode irrigation</label>
			<select id="ferme">
				<c:forEach items="${fermes }" var="l">
					<option value="${l.id_Ferme }">${li.nom_Ferme }</option>
				</c:forEach>
			</select>
			<select id="occupation">
				<c:forEach items="${occupations }" var="l">
					<option value="${l.id }">${l.occupation.variete.nom } </option>
				</c:forEach>
			</select>
			<br/>	
			<button id="submitUpdating">Modifier</button>
			<button  id="submitDeleting">Supprimer</button>
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
			</div>
			
			<script>
            $(document).ready(function () {
            	$("#submitDeleting").hide();
            	$("#submitUpdating").hide();
            	//$("#waiting").hide();
            	
            	
            	$(".occupation").click(function(event){
            		
            		$.get('InitialiserEntite', {
          	            id : $(this).prop("value"),
          	            entite : "Occupation",
      	            
		          	       }, function(response) {
		          	    	   alert(response);
		          	    	   
		          	    	   
	          	       		}); 
            		
            	});
            	
            	
            	 $(".update").click(function(event){
            		 var idvar= $(this).prop("value");
            		 var entitevar="Parcelle";
            		 alert(idvar + " "+ entitevar);
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
            		
				 $("#idtodelete").val(idvar);
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
        <script type="text/javascript">
			$(".ok").change(function(){
				
				 if($(this).prop("checked") == true){
				       //run code
					    
					   
					 	$.get('InitialiserEntite', {
		      	            id : $(this).prop("value"),
		      	            val : "true",
		      	            entite : "ParcelleChecking",
		  	            
			          	       }, function(response) {
			          	    	 new PNotify({
		            	    		    title: 'activation de parcellaire !',
		            	    		    text: "vous ne pouvez plus modifier cette parcellaire !",
		            	    		    delay: 2500,
		            	    		    type: 'success'
		            	    		});
			          	    	   
			          	    	   
		          	       		});  
		          	// alert("value on ")  ;
		          	 
					 	
					 
				    }else{
				       //run code
				    	$.get('InitialiserEntite', {
		      	            id : $(this).prop("value"),
		      	            val : "false",
		      	            entite : "ParcelleChecking",
		  	            
			          	       }, function(response) {
			          	    	 new PNotify({
		            	    		    title: 'activation de parcellaire !',
		            	    		    text: "vous pouvez toujours modifier cette parcellaire !",
		            	    		    delay: 2500,
		            	    		    type: 'success'
		            	    		});
			          	    	   
			          	    	   
		          	       		});  
		          	
		          	     		
		          	  
				    }
			});
			
		</script>
        
	<!-- Datatables -->

<%@include file="footer.jsp" %>