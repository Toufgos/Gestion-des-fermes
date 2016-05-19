<%@include file="menu.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
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
            $("#formToAdd").dialog({
            	autoOpen: false,
            });
         });
      </script>
      
    
      
		
		<script src="<%=request.getContextPath()%>/resources/js/datatables/js/jquery.dataTables.js"></script>
        <script src="<%=request.getContextPath()%>/resources/js/datatables/tools/js/dataTables.tableTools.js"></script>
		
<div class="right_col" role="main">

	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>les Mouvements Avec leurs produits</h3>
			</div>

			<div class="title_right">
				<div
					class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Chercher...">
						<span class="input-group-btn">
							<button class="btn btn-default" type="button">oK!</button>
						</span>
					</div>
				</div>
			</div>
		</div>
		<div class="clearfix"></div>

		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="x_panel">
						<div class="x_title">
							<h2>
								xxxxxx <small>xxxx </small>
							</h2>

							<div class="clearfix"></div>
						</div>
						<div class="x_content">
							<%-- modelAttribute="cf" --%>
							<button id="add" >ajouter un produit</button>
							<button id="add2" >ajouter un produit</button>
							<div id="formToAdd" class="col-md-12 col-sm-12 col-xs-12" title="Ajouter un nouveau produit à ce mouvement">
							<!-- <form if="formL" class="form-horizontal form-label-left" action=""> -->
								<div class="form-horizontal form-label-left">
								<c:if test="${fn:length(produits) gt 0}">
								<div class="item form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Mouvement</label>

									<div class="col-md-6 col-sm-6 col-xs-12">
										<c:if test="${not empty m }">
											<select  required="required" disabled="disabled" id="mov"
											class="form-control col-md-7 col-xs-12">
											<option value="${m.id }" selected="selected"  > ${m.reference } </option>
											</select>
											</c:if>
										<c:if test="${ empty m }">
										<select  required="required"  id="mov"
											class="form-control col-md-7 col-xs-12">
											
											<c:forEach items="${mouvements }" var="m">
											
												<option value="${m.id}">${m.reference } </option>
												<%
												System.out.print("A");
												
											%>
											</c:forEach>
										</select>
										</c:if>
									</div>
								</div>
								
								<div class="item form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Produit</label>

									<div class="col-md-6 col-sm-6 col-xs-12">
										<select  id="product"  required="required"
											class="form-control col-md-7 col-xs-12">
											<option></option>
											<c:forEach items="${produits }" var="m">
												<option value="${m.id}">${m.libelle } </option>
												<% System.out.print("B"); %>
											</c:forEach>
										</select>
									</div>
								</div>
								<c:if test="${m.type == 'entree' }"> 
								<% System.out.print("C"); %>
								<div class="item form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Fournisseur</label>

									<div class="col-md-6 col-sm-6 col-xs-12">
										<select  id="fournisseur"  required="required"
											class="form-control col-md-7 col-xs-12">
											<option></option>
											<c:forEach items="${fournisseurs }" var="m">
												<option value="${m.id}">${m.nom } </option>
											</c:forEach>
										</select>
									</div>
								</div>
								</c:if>
								<div class="item form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Quantité</label>

									<div class="col-md-6 col-sm-6 col-xs-12">
										<input id="qte" type="number" step="0.01"  />
									</div>
								</div>
								
								<div class="item form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Prix Unitaire</label>

									<div class="col-md-6 col-sm-6 col-xs-12">
										<input id="pu" type="number" step="0.01"  />
									</div>
								</div>
								<div class="item form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">remise</label>

									<div class="col-md-4 col-sm-6 col-xs-12">
										<input id="rem" type="number" step="0.01"  />
									</div>
									
									<div class="col-md-2 col-sm-6 col-xs-12">
										<select id="remtype">
											<option value="0" >Dh</option>
											<option value="1" >%</option>
										</select>
									</div>
									
									<input path="remise" type="hidden" id="remise" />
								</div>
								
								<div class="form-group">
												<div class="col-md-6 col-md-offset-3">
													<input type="reset" name="nul" class="btn btn-primary"
														value="rénitilaiser" />
													<button id="test" > ok </button>
													<button id="send" name="submit" value="Ajouter" type="submit"
														class="btn btn-success">Ajouter</button>
												</div>
											</div>
								</c:if> 
								<c:if test="${ empty produits}">
									<h3>tout les produits sont inclus dans ce Mouvement, vous ne pouvez plus d'associer un nouveau produit à ce Mouvement </h3>
								</c:if> 
								</div>
							<!-- </form> -->
							</div>
							<table id="example"
										class="table table-striped responsive-utilities jambo_table">
										<thead>
											<tr class="headings">
												<!-- <th>
				                                                    <input type="checkbox" class="tableflat">
				                                                </th> -->
												<th>Mouvement</th>
												<th>Produit</th>
												<th>Prix Unitaire</th>
												<th>quantite</th>
												<th>remise</th>
												<th>Montant Total</th>
												<th class=" no-link last"><span class="nobr">Action</span>
												</th>
											</tr>
										</thead>
										
										<tbody>
											<%-- <c:if test="${empty mov }">
											<% System.out.print("mov is  null "); %>
											<c:forEach items="${ligne }" var="li">
												<tr>
													
													<td class=" ">${li.mouvement.reference }</td>
														
													<td class=" ">${li.produit.libelle}</td>
														
													<td class=" ">${li.prixUnitaire }</td>
													
													<td class=" ">${li.quantite }</td>	
														
													<td class=" ">${li.remise }</td>
													
													<td class=" ">${li.montant }</td>
													
													<td class=" last">
														<f:form modelAttribute="ff" action="#" method="post">
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
				
														</button> </f:form>
													</td>	
												</tr>
											</c:forEach>
											</c:if> --%>
											<c:if test="${not empty mov }">
											<% System.out.print("mov is not null "); %>
											<c:forEach items="${mov }" var="li">
												<tr>
													
													<td class=" ">${li.mouvement.reference }</td>
														
													<td class=" ">${li.produit.libelle}</td>
														
													<td class=" ">${li.prixUnitaire }</td>
													
													<td class=" ">${li.quantite }</td>	
														
													<td class=" ">${li.remise }</td>
													
													<td class=" ">${li.montant }</td>
													
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
											</c:if>
										</tbody>
				
									</table>

						</div>
					</div>
				</div>
			</div>
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
	       	    	    
	       	    	    alert(idvar+"    "+entitevar);
	       	    	   
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
          <script>
      
      
      $("#add2").click(function(){
    	  alert("un dialog va s'ouvrir");
    	 $("#formToAdd").dialog("open");
      });
      
      $("#add").click(function(){
    	  var oTable = $('#example').dataTable();//get the DataTable
        //  oTable.fnClearTable();//clear the DataTable
			
				//alert(c[0]+"  "+c[14]);
				oTable.fnAddData(
						["ok",
						  "<select  id='product' required='required' class='form-control col-md-7 col-xs-12'>"+
							"<option></option>"
							+"<c:forEach items='${produits }' var='m'>"
							+"	<option value='${m.id}''>${m.libelle } </option>"
							+"</c:forEach>"
						+"</select> ",
						 "ok",
						 "ok",
						 "ok",
						 "ok" ]
						);//add new row
			});
      </script> 
      
      <script>
      $("#test").click(function(){
     	 var mouv = $("#mov").val(); 
     	 var prod=$("#product").val();
     	 var qte=$("#qte").val();
     	 var remise=$("#rem").val();
     	 var four=$("#fournisseur").val();
     	 var pu=$("#pu").val();
     	 if($("#remtype").val()=="1"){
     		 if($("#rem").val()>100){
     			 alert("le pourcentage de la remise ne peut pas dépasser 100 !");
     			 return null;
     		 }
     			 
     		 remise = qte*pu*(1.00*remise)/100;
     	 }
     	 alert(
     			 "produit :"+ prod +
     			 "qantité :"+ qte +
     			 "remise :"+ remise+
     			 "prix  :"+ pu );
     	 
     	 $.get('AjoutLigneMouvementProduitAjax', {
     		 produit : prod,
 			 qantite : qte,
 			 remise : remise,
 			 prix  : pu,
 			 mouvement : mouv
 	       }, function(s) {
 	    	   
 	    	  $("#mov").val(""); 
 	     	  $("#product").val("");
 	     	  $("#qte").val("");
 	     	  $("#rem").val("");
 	     	  $("#pu").val("");
 	     	  $("#remtype").val("");
 	     	  $("#fournisseur").val("");
 	    	   //alert("recu : "+s);
 	    	   new PNotify({
				    title: 'Regular Success',
				    text: s,
				    type: 'success'
				});
 	  	//PNotify.removeAll();
 	       }); 
     	 
     	 	$("#formToAdd").dialog("close");
     	 	 setTimeout(function(){ 
     	 		// alert("Hello"); 
     	 		 location.reload(); 
     	 	 }, 
     	 	 3000); 
     	 	
       });
      
      </script>
<%@include file="footer.jsp"%>