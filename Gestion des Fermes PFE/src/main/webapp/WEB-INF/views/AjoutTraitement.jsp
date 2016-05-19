<%@include file="menu.jsp" %>
  <script>
  $(function() {
    $( "#date" ).datepicker();
  });
  </script>
<!DOCTYPE html>
		<!-- /page content -->
		<% session.setAttribute("page","ajoutFerme");%>
		<div class="right_col" role="main">

			<div class="">
				<div class="page-title">
					<div class="title_left">
						<h3>Traitement des parcelles</h3>
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
						<div class="col-md-8 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>
										Ajouter un traitement  <small>par parcelle </small>
									</h2>
									
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
								<form  class="form-horizontal form-label-left" >

										<p>
											les champs notés en
											<code> * </code>
											sont des champs obligatoires.
										</p>
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="Groupe">Parcelle à traiter </label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<select path="parce" name="parce" id="parce"
													class="form-control col-md-7 col-xs-12" >
													<c:forEach items="${parcellaires }" var="p">
														<option value="${p.id_parce }">${p.libelle }</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="Groupe">Produit de traitement</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<select path="prod" name="prod" id="prod"
													class="form-control col-md-7 col-xs-12" >
													<option selected="selected" ></option>
													<c:forEach items="${produits }" var="p">
														<option value="${p.id }">${p.libelle }</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="ville">Date de traitement <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input path="date" type="date" id="date" name="date" 
													required="required" class="form-control col-md-7 col-xs-12"
													placeholder="Date de traitement ..." />
											</div>
										</div>
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="number">Quantité utilisée <span class="required">*</span>
											</label>
											<div class="col-md-5 col-sm-5 col-xs-12">
												<input path="qte" type="number" step="0.01" id="qte" name="qte"
													required="required" data-validate-minmax="0,100000000"  
													placeholder="Quantité utilisée pour le traitement" class="form-control col-md-7 col-xs-12" />

											</div>
											

										<div class="ln_solid"></div>
										<div class="form-group">
											<div class="col-md-6 col-md-offset-3">
												<button type="reset" id="nul" class="btn btn-primary">
													Annuler</button>
												<button path="submit" id="send" name="submit" value="Ajouter"
													type="submit" class="btn btn-success">Ajouter</button>
											</div>
										</div>
									</form>
									

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
</div>
<%@include file="footer.jsp" %>