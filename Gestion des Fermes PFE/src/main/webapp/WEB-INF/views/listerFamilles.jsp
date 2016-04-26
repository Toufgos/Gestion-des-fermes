<%@include file="menu.jsp" %>
<!DOCTYPE html>
<% session.setAttribute("page","listerFamilles");%>

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
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/notify/pnotify.core.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/notify/pnotify.buttons.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/notify/pnotify.nonblock.js"></script>


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
                                    <h2>Voici la liste des Familles <small></small></h2>
                                    
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
                                                <th>Description </th>
                                                <th>Activité </th>
                                                
                                                <th class=" no-link last"><span class="nobr">Action</span>
                                                </th>
                                            </tr>
                                        </thead>
										
                                        <tbody>
                                       
                                        	<c:forEach items="${Familles }" var="li">
                                        	<tr>
                                        	
                                        		<td class=" ">${li.libelle }</td>
                                        		
                                                <td class=" ">${li.description} </td>
                                                
                                                <td class=" ">${li.activite.libelle } </td>
                                                
                                                
                                                <td class=" last">

													
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
			
			 <div class="item form-group hid ">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Activité
										</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<select id="activite" name="entite" class="form-control col-md-7 col-xs-12">
											<c:forEach items="${activites }" var="a">
												<option value="${a.id }">${a.libelle }</option>
											</c:forEach>
										</select>
									</div>
								</div>

								<div class="item form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">libellé
										 </label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<input id="libelle" class="form-control col-md-7 col-xs-12" type="text"
											name="libelle" />
									</div>
								</div>
								<div class="item form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Description
										 </label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<input id="descripiton" class="form-control col-md-7 col-xs-12" type="text"
											name="description" />
									</div>

								</div>
			<br/>	
			<button id="submitUpdating">Modifier</button>
			
		</div>
		<div id="waiting" title="wait please !">
				<p>Please wait</p>
			<img class="test" src="http://loadingapng.com/templates/4/preview.gif" alt="waiting" width="100" height="100">
		</div>
		
		<div id="deleting" title="Attention  !">
		<input type="hidden" value="" id="idtodelete" /> 
				<p>voulez-vous vraiment supprimer cette Famille </p>
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
            		 $("#dialogForUpdating").dialog("close");
            		 var idvar= $(this).prop("value");
            		 var entitevar="Famille";
            			$("#submitUpdating").show();
            			$("#submitDeleting").hide();
            		    $("#waiting").dialog("open");
	       	    	    $(".hid").hide();
	       	    	 alert("debut  ");
            		 $.get('InitialiserEntite', {
	          	            id : idvar,
	          	            entite : entitevar,
          	            
			          	       }, function(response) {
			          	    	   alert(response);
			          	    	    var res=response.split(":");
			          	    	   
			          	    	    $("#idUpdating").val(idvar);
			          	    	    $("#activite").val(res[0]);
			          	    	    $("#libelle").val(res[1]);
			          	    	    $("#descripiton").val(res[2]);
			          	    	    $("#libelleUpdating").show();
			       	    	        $("#observationUpdating").show();
					       	    	$("#submitUpdating").show();
					       	    	$(".hid").show();
					       	    	$("img").remove(".test");
					       	    	$("#waiting").dialog("close");
			          	    
					       	    	
			          	    	   
		          	       		}); 
            		 alert("fin ");
	            		 $("#idUpdating").val(idvar);
	
	            	     $("#dialogForUpdating").dialog("open");
            		
            		 });
            	 $("#submitUpdating").click(function(event){
            		 var idvar= $("#idUpdating").val();
            		 var entitevar="Famille";
            		 $("#dialogForUpdating").dialog("close");
            		 $("#waiting").dialog("open");
            		 alert("activite : "+ $("#activite").val()+"\n description : "+$("#descripiton").val()+"\n");
            		 $.get('UpdateEntite', {
            	            id : idvar,
            	            entite : entitevar,
            	            activiteNew : $("#activite").val(),
            	            libelle : $("#libelle").val(),
            	            observation : $("#descripiton").val(),
            	       }, function(response) {
            	    	  // var res=response.split(":");
            	    	  // $("#example").append('<tr><td class=" ">'+res[0]+'</td> <td class=" ">'+res[1]+'</td></tr>');
            	    	  alert(response);
            	  	//PNotify.removeAll();
            	       });
            		 $("#waiting").dialog("close");
            		 location.reload();
            		 });
            	 $("#submitDeleting").click(function(event){
            		 var idvar= $("#idtodelete").val();
            		 var entitevar="Famille";
            		 $("#dialogForUpdating").dialog("close");
            		 $("#waiting").dialog("open");
            		alert(idvar+" "+entitevar);	
            		 $.get('RemoveEntite', {
            	            id : idvar,
            	            entite : entitevar,
            	       }, function(response) {
            	    	   
            	    	  
            	    	   new PNotify({
            	    		    title: 'Famille Supprimé !',
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
            		 var entitevar="Famille";
            		
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
                 <!-- Datatables -->
        
	<%@include file="footer.jsp" %>	
		
