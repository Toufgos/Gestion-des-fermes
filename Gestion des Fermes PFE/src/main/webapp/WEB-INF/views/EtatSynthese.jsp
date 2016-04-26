<%@include file="menu.jsp"%>
<script
	src="<%=request.getContextPath()%>/resources/js/datatables/js/jquery.dataTables.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/datatables/tools/js/dataTables.tableTools.js"></script>

<style>

th{
	width: 17px;
	height: 10px;
}

table{
	font-size: 8pt;
}
#result{
margin-left: 0px;
padding-left: 0px;
}

</style>

<script>
	$(document).ready(function() {

		$("#result").hide();

		$("#ferme").change(function() {
			
			var idvar = $("#ferme").val();
			
			alert(idvar);
			$.get('etatSynthese', {
				id : idvar,
			}, function(response) {
				alert(response);
				var oTable = $('#example').dataTable();//get the DataTable
                oTable.fnClearTable();//clear the DataTable
				var a=response.split("|");
				var c=[];
				for( var b=0; b< a.length-1; b++){
					 c=a[b].split(":");
					//alert(c[0]+"  "+c[14]);
					oTable.fnAddData([c[0],c[1],c[2],c[3],c[4],c[5],c[6],c[7],c[8],c[9],c[10],c[11],c[12],c[13],c[14]]);//add new row
				}
				
				
              
                    
                    //each element in the array is a td
              $("#result").slideDown("slow");
				
				 // remove the old table
			   /* var table = $('#example').DataTable();
			    $("#example tbody").html(response);
				 
				$("#result").slideDown("slow"); */

				
			});

		});

	});
</script>
<!-- /page content -->
<%
	session.setAttribute("page", "ajoutFerme");
%>
<div class="right_col" role="main">

	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>état de synthèse</h3>
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
								état de synthèse <small>xxxx </small>
							</h2>

							<div class="clearfix"></div>
						</div>
						<div class="x_content">

							<div>
								<p>Veuillez choisir une Ferme :
								<select id="ferme">
								<option></option>
									<c:forEach items="${fermes }" var="f">
										<option value="${f.id_Ferme }">${f.nom_Ferme }</option>
									</c:forEach>
								</select>
								</p>
							</div>

							<div id="result" class="col-md-14 col-sm-12 col-xs-12">


								<table id="example" style="height: 10px; width: 10px;"
									class="table  table-striped responsive-utilities jambo_table">
								
									<thead>
										<tr class="headings">
											<!-- <th>
                                                    <input type="checkbox" class="tableflat">
                                                </th> -->
                                            <th>N° parcelle</th>
											<th>Libelle</th>
											<th>Type</th>
											<th>Mode irrégation</th>
											<th>superficie Brute</th>
											<th>superficie Inculte</th>
											<th>superficie Nette</th>
											<th>Famille</th>
											<th>SousFamille</th>
											<th>Variété</th>
											<th>Ordre</th>
											<th>Nombre d'arbres</th>
											<th>Année de Plantation</th>
											<th>EcartX</th>
											
		
											<th class=" no-link last"><span class="nobr">EcartY</span></th>
										</tr>
									</thead>

									<tbody>


									</tbody>

								</table>






							
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
	var asInitVals = new Array();

	$(document).ready(function() {
		var oTable = $('#example').dataTable({
			"oLanguage" : {
				"sSearch" : "Chercher dans tout les colonnes :"
			},
			"aoColumnDefs" : [ {
				'bSortable' : true,
				'aTargets' : [ 0 ]
			} //disables sorting for column one
			],
			'iDisplayLength' : 10,
			"sPaginationType" : "full_numbers",
			"dom" : 'T<"clear">lfrtip'

		});
		$("tfoot input").keyup(function() {
			/* Filter on the column based on the index of this element's parent <th> */
			oTable.fnFilter(this.value, $("tfoot th").index($(this).parent()));
		});
		$("tfoot input").each(function(i) {
			asInitVals[i] = this.value;
		});
		$("tfoot input").focus(function() {
			if (this.className == "search_init") {
				this.className = "";
				this.value = "";
			}
		});
		$("tfoot input").blur(function(i) {
			if (this.value == "") {
				this.className = "search_init";
				this.value = asInitVals[$("tfoot input").index(this)];
			}
		});
	});
</script>
<%@include file="footer.jsp"%>