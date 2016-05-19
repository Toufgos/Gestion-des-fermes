<%@include file="menu.jsp"%>
<!DOCTYPE html>
<% session.setAttribute("page","listerProduits");%>
<!-- PNotify -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/notify/pnotify.core.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/notify/pnotify.buttons.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/notify/pnotify.nonblock.js"></script>
 
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
            $("#removing").dialog({
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
									<h2>
										Voici la liste des Traitement effectués <small> ! </small>
									</h2>

									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									
									<div class="" role="tabpanel" data-example-id="togglable-tabs">
                                        <ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
                                            <li role="presentation" class="active"><a href="#tab_content1" id="home-tab" role="tab" data-toggle="tab" aria-expanded="true">Tout les traitements</a>
                                            </li>
                                            <li role="presentation" class=""><a href="#tab_content2" role="tab" id="profile-tab" data-toggle="tab"  aria-expanded="false">Traitements Par parcelles</a>
                                            </li>
                                            <li role="presentation" class=""><a href="#tab_content3" role="tab" id="profile-tab2" data-toggle="tab" aria-expanded="false">Traitements Par produits</a>
                                            </li> 
                                        </ul>
                                        <div id="myTabContent" class="tab-content">
                                            <div role="tabpanel" class="tab-pane fade active in" id="tab_content1" aria-labelledby="home-tab">
                                             
									<table id="example"
										class="table table-striped responsive-utilities jambo_table">
										<thead>
											<tr class="headings">
												<!-- <th>
				                                                    <input type="checkbox" class="tableflat">
				                                                </th> -->
												<th>Parcelle</th>
												<th>Produit</th>
												<th>Quantité</th>
												<th>Date</th>
												
												<th class=" no-link last"><span class="nobr">Action</span>
												</th>
											</tr>
										</thead>
				
										<tbody>
				
											<c:forEach items="${traitements }" var="li">
												<tr>
													
													<td class=" ">${li.parcellaire.libelle }</td>
														
													<td class=" ">${li.produit.libelle }</td>
														
													<td class=" ">${li.quantite }</td>
														
													<td class=" ">${li.dateDeTraitement }</td>
													
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
									
									<div role="tabpanel" class="tab-pane fade" id="tab_content2" aria-labelledby="profile-tab">
										<h1>Une autre partie résérvée pour les traitrements par Parcelle</h1>
									</div>
									
									<div role="tabpanel" class="tab-pane fade" id="tab_content3" aria-labelledby="profile-tab">
										<h1>Une autre partie résérvée pour les traitrements par Produit</h1>
									</div>
									
								</div>
							</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
</div>
<div id="dialogForUpdating" title="Modification d'une Activité "
			style="display: table-cell; vertical-align: middle; text-align: center">

			<input type="hidden" value="" id="idUpdating" /> 
			
									<table>
									<tr>
									 <td> <label>Ferme</label></td>
									<td>	
										<select name="ferme" id="ferme">
											<c:forEach items="${fermes }" var="f" >
												<option value="${f.id_Ferme }" >${f.nom_Ferme }</option>
											</c:forEach>
										</select>
									</td>
									</tr>
									<tr>	
										<td><label>Temperature</label></td>
										<td><input type="number" id="temperature" name="temperature"  /></td>
									</tr>
									<tr>	
										<td><label>Date</label></td>
										<td><input type="date" id="date" name="date" /></td> 
									</tr>
									<tr>	
										<td><label>Pluie</label></td>
										<td><input type="number" id="pluie" name="pluie" /></td>
									</tr>	
									</table>
									
								
			<br/>	
			<button id="submitUpdating">Modifier</button>
			
		</div>
		<div id="waiting" title="wait please !">
				<p>Please wait</p>
			
		</div>
		<div id="removing" title="suppression">
			<p> vous êtes sûr de supprimer cette climat ? </p>
			<input type="hidden" value="" id="idtodelete" /> 
			<button  id="submitDeleting">Supprimer</button>
		</div>
                    </div>
                </div>
                
            <script>
            $(document).ready(function () {
            	
            	//$("#waiting").hide();
            	
            	
            	 $(".update").click(function(event){
            		 
            		 var idvar= $(this).prop("value");
            		 var entitevar="Climat";
            		 
            		
            			
	       	    	    $(".hid").hide();
	       	    	    
	       	    	    //alert(idvar+"    "+entitevar);
	       	    	   
            		 $.get('InitialiserEntite', {
	          	            id : idvar,
	          	            entite : entitevar,
          	            
			          	       }, function(response) {
			          	    	  // alert(response);
			          	    	    var res=response.split(":");
			          	    	    $("#ferme").val(res[0]);
			          	    		$("#temperature").val(res[1]);
				          	    	$("#date").val(res[3]);
				          	    	$("#pluie").val(res[2]);
			          	    	    $("#idUpdating").val(idvar);
					       	    	$(".hid").show();
			          	    	   $("#dialogForUpdating").dialog("open");
			          	    	   
		          	       		}); 
            		
	            		/*  $("#idUpdating").val(idvar);
	
	            	     $("#dialogForUpdating").dialog("open");  */
            		
            		 });
            	 $("#submitUpdating").click(function(event){
            		 var idvar= $("#idUpdating").val();
            		 var entitevar="Climat";
            		 $("#dialogForUpdating").dialog("close");
            		 $("#waiting").dialog("open");
            		 
            		 $.get('UpdateEntite', {
            	            id : idvar,
            	            entite : entitevar,
            	            ferme : $("#ferme").val(),
       	    				temperature : $("#temperature").val(),
	          	    		date :	$("#date").val(),
	          	    		pluie :	$("#pluie").val(),
            	       }, function(response) {
            	    	  // alert(response);
            	    	   $(function () {
                          	 new PNotify({
                          		    title: 'Succée !',
                          		    text: response,
                          		    type: 'success'
                          		});

                           });
            	    	  /*  var res=response.split(":");
            	    	   $("#example").append('<tr><td class=" ">'+res[0]+'</td> <td class=" ">'+res[1]+'</td></tr>');
            	    	   */
            	  	//PNotify.removeAll();
            	       });
            		 $("#waiting").dialog("close");
            		 
            		 });
            	 $("#submitDeleting").click(function(event){
            		 var idvar= $("#idtodelete").val();
            		 var entitevar="Climat";
            		 $("#removing").dialog("close");
            		 $("#waiting").dialog("open");
            		//alert(idvar+" "+entitevar);	
            		 $.get('RemoveEntite', {
            	            id : idvar,
            	            entite : entitevar,
            	       }, function(response) {
            	    	  
            	    	   alert("recu : "+response);
            	    	   
            	  	//PNotify.removeAll();
            	       }); 
            		 $("#waiting").dialog("close");
            		 
            		 });
            	 $(".remove").click(function(event){
            		 var idvar= $(this).prop("value");
            		 var entitevar="Climat";
            		 $("#idtodelete").val(idvar);
            	     $("#removing").dialog("open");
            	     
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