<%@include file="menu.jsp" %>
<!DOCTYPE html>
<% session.setAttribute("page","ajouterParce");%>

	 <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script>
	$(document).ready(function() {

		$("#ok").change(function() {
			var v = $("#ok").val();
			if (v == 1)
				$("#mode").show();
			else
				$("#mode").hide();

		});
	});
</script>

<!-- /page content -->
		
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
		 <div class="right_col col-md-12 col-sm-12 col-xs-12">
						<div class="col-md-6 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
                                    <h2>Voici la liste des Groupes  <small></small></h2>
                                    
                                    <div class="clearfix"></div>
                                </div>
					<form class="form-horizontal form-label-left" action=""
						method="post">
						<p>
							les champs notés en
							<code> * </code>
							sont des champs obligatoires.
						</p>
						<%-- <input type="hidden" name="id_ferme"
							value="${la_ferme.id }" /> --%>
						
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="nom">Ferme <span class="required">*</span>
							</label> 
							
							<select  name="id_ferme">
								<c:forEach items="${ fermes}" var="li" >
									<option value="${li.id_Ferme }" > ${li.nom_Ferme }</option>
								</c:forEach>							
							</select>
							
						</div>
						
							
							
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="nom">Libelle <span class="required">*</span>
							</label> <input type="text" name="libelle"
								placeholder="libelle Parcelaire " />
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="nom">Superficie brute <span class="required">*</span>
							</label> <input type="number" name="s_brute"
								placeholder="superficie brute" />
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="nom">Superficie inculte <span class="required">*</span>
							</label> <input type="number" name="s_inculte"
								placeholder="superficie inculte" />
						</div>
						<div class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="nom">Type : <span class="required">*</span>
							</label>
							 <select  id="ok" name="typeParcelaire">
								<option value="1">Irrégué</option>
								<option value="0">Bour</option>
							</select>
						</div>
						<div id="mode" class="item form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="nom">Mode d'irrégation <span class="required">*</span>
							</label> 
							<% System.out.println("Avant les modes "); %>
							<select name="modeIr"  >
							<c:forEach items="${modes }" var="mode">
								<option value="${mode.id_mode }">${mode.nom_mode }</option>
							</c:forEach>
							</select>
							<% System.out.println("aprés les modes "); %>
						</div>
						
						<div class="form-group">
							<div class="col-md-6 col-md-offset-3">
								<input type="reset" name="nul" class="btn btn-primary"
									value="rénitilaiser" />

								<button id="send" name="submit" value="Ajouter" type="submit"
									class="btn btn-success">Ajouter</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			</div>
			</div>
	 </div>
        
	<%@include file="footer.jsp" %>	
		
