<%@include file="menu.jsp" %>
		<!-- /page content -->
		<% session.setAttribute("page","ajoutModeIr");%>
		<div class="right_col" role="main">

			<div class="">
				<div class="page-title">
					<div class="title_left">
						<h3>Cat�gorie de Produit</h3>
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
									<h2>
										Ajouter une nouvelle Cat�gorie  <small>de produit </small>
									</h2>

									<div class="clearfix"></div>
								</div>
								<div class="x_content">

								<form  class="form-horizontal form-label-left" novalidate>

										<p>
											les champs not�s en
											<code> * </code>
											sont des champs obligatoires.
										</p>
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="nom">Nom <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input id="nom" class="form-control col-md-7 col-xs-12"
													name="libelle" placeholder="Nom du mode"
													required="required" type="text">
											</div>
										</div>
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="adresse">Description <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<textarea id="description" placeholder=" description du cat�gorie"
													required="required" name="description"
													class="form-control col-md-7 col-xs-12"></textarea>
											</div>
										</div>
										
										<div class="form-group">
											<div class="col-md-6 col-md-offset-3">
												<button type="reset" id="nul" class="btn btn-primary">
													Annuler</button>
												<button id="send" name="submit" value="AjouterMode"
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