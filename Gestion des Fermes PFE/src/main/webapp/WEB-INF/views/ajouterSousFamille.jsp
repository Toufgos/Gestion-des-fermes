<%@include file="menu.jsp"%>
<!-- /page content -->
<%
	session.setAttribute("page", "ajouterSousFamille");
%>
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
						<input class="form-control col-md-7 col-xs-12" type="text"
							class="form-control" placeholder="Chercher..."> <span
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
								Ajouter une nouvelle sous famille< <small>xxxx </small>
							</h2>

							<div class="clearfix"></div>
						</div>
						<div class="x_content">

							<form class="form-horizontal form-label-left" method="post">

								<p>
									les champs notés en
									<code> * </code>
									sont des champs obligatoires.
								</p>

								<div class="item form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12"
										for="nom">Famille Mère <span class="required">*</span>
										
									</label>

									<div class="col-md-6 col-sm-6 col-xs-12">
										<select name="entite" class="form-control col-md-7 col-xs-12">
											<c:forEach items="${familles }" var="a">
												<option value="${a.id }">${a.libelle }</option>
											</c:forEach>
										</select>
									</div>
								</div>

								<div class="item form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">libellé
										 </label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<input class="form-control col-md-7 col-xs-12" type="text"
											name="libelle" />
									</div>
								</div>
								<div class="form-group">
											<div class="col-md-6 col-md-offset-3">
												<button type="reset" id="nul" class="btn btn-primary">
													Annuler</button>
												<button id="send" name="submit" value="ajouter"
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
<%@include file="footer.jsp"%>