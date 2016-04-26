<%@include file="menu.jsp" %>
<!DOCTYPE html>
<% session.setAttribute("page","afficherFerme");%>

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
                                    <h2>Voici la liste des Fermes <small></small></h2>
                                    
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
                                                <th>Adresse </th>
                                                <th>Ville </th>
                                                <th>Pays </th>
                                                <th>Propriétaire </th>
                                                <th>Titre Foncier </th>
                                                <th>Groupe </th>
                                                <th>Gerant </th>
                                                <th class=" no-link last"><span class="nobr">Action</span>
                                                </th>
                                            </tr>
                                        </thead>
										
                                        <tbody>
                                        
                                        	<c:forEach items="${lis }" var="li">
                                        	<tr>
                                        	
                                        		<td class=" ">${li.nom_Ferme }</td>
                                        		
                                                <td class=" ">${li.adresse } </td>
                                                
                                                <td class=" ">${li.ville_ferme } </td>
                                                
                                                <td class=" ">${li.pays_ferme } </td>
                                                
                                                <td class=" ">${li.proprietaire_ferme }</td>
                                                <td class=" ">${li.titre_foncier_ferme }</td>
                                                
                                                <td class=" ">${li.groupe.nom }</td>
                                                <td class="  ">${li.gerant.nom }</td>
                                                <td class=" last">

													<f:form modelAttribute="ff" action="coorMaps" method="post">
														<input name="id_Ferme" id="id_Ferme"
															value="${li.id_Ferme }" type="hidden" />
														<button type="submit" class="btn  btn-xs do">
															<i class="fa"> </i> <i class="fa fa-home"></i>
															Afficher
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

                    </div>
                </div>
                
                <script>
            $(document).ready(function () {
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
                    'iDisplayLength': 12,
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
		
