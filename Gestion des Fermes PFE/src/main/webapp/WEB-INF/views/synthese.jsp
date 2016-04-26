<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"  %>
<script
	src="<%=request.getContextPath()%>/resources/js/datatables/js/jquery.dataTables.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/datatables/tools/js/dataTables.tableTools.js"></script>

<table id="example"
	class="table table-striped responsive-utilities jambo_table">
	<thead>
		<tr class="headings">
			<!-- <th>
                                                    <input type="checkbox" class="tableflat">
                                                </th> -->
			<th>Libelle</th>
			<th>Type</th>
			<th>Mode irrégation</th>
			<th>superficie Brute</th>
			<th>superficie Inculte</th>
			<th>superficie Nette</th>
			<th>Ferme</th>
			<th>Occupation</th>

			<th class=" no-link last"><span class="nobr">Action</span></th>
		</tr>
	</thead>

	<tbody>

		<c:forEach items="${Parcelles }" var="li">
			<tr>

				<td class=" ">${li.libelle }</td>
				<td class=" "><c:if
						test="${li['class'].name == 'si.smart.ferme.entities.ParcellaireBour' }">
						<c:out value="Bour"></c:out>
					</c:if> <c:if
						test="${li['class'].name == 'si.smart.ferme.entities.ParcellaireIrregue' }">
						<c:out value="Irrégué"></c:out>
					</c:if></td>
				<td><c:if
						test="${li['class'].name == 'si.smart.ferme.entities.ParcellaireBour' }">
						<c:out value=""></c:out>
					</c:if> <c:if
						test="${li['class'].name == 'si.smart.ferme.entities.ParcellaireIrregue' }">
						<c:out value="${li.mode.nom_mode }"></c:out>
					</c:if></td>
				<td class=" ">${li.s_brute }</td>

				<td class=" ">${li.s_inculte }</td>

				<td class=" ">${li.s_net }</td>

				<td class=" ">${li.ferme.nom_Ferme }</td>
				<td class=" ">

					<button type="button" value="${li.id_parce }"
						class="btn occupation btn-xs do">
						<i class="fa"> </i> <i class="fa fa-home"></i>

					</button>

				</td>


				<td class=" last"><f:form modelAttribute="pf"
						action="CoorMapParce" method="post">
						<input name="parcelle_id" id="parcelle_id" value="${li.id_parce }"
							type="hidden" />
						<button type="submit" class="btn  btn-xs do">
							<i class="fa"> </i> <i class="fa fa-home"></i> Afficher
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


<script type="text/javascript">
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
