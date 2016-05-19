<%@include file="menu.jsp" %>
 <script>
  $(function() {
    $( "#date" ).datepicker();
  });
  </script>
		<!-- /page content -->
		<% session.setAttribute("page","ajoutFerme");%>
		<div class="right_col" role="main">

			<div class="">
				<div class="page-title">
					<div class="title_left">
						<h3>Mouvement</h3>
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
										Ajouter un Nouveau Mouvement <small> </small>
									</h2>

									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									
									<f:form modelAttribute="cf" class="form-horizontal form-label-left" action="">
										
										<div class="item form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Ferme</label>
										
									<div class="col-md-6 col-sm-6 col-xs-12">
										<f:select path="ferme" required="required" class="form-control col-md-7 col-xs-12">
											<option></option>
											<c:forEach items="${fermes }" var="f" >
												<option value="${f.id_Ferme }" >${f.nom_Ferme }</option>
											</c:forEach>
										</f:select>
									</div>
								</div>
										<%-- <div class="item form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-12">Ferme</label>
										<f:select path="ferme" required="required" class="form-control col-sm-4 col-md-4 col-xs-8" >
											<option></option>
											<c:forEach items="${fermes }" var="f" >
												<option value="${f.id_Ferme }" >${f.nom_Ferme }</option>
											</c:forEach>
										</f:select>
										</div> --%>
										<div class="item form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-12">Num�ro</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
										<f:input class="form-control col-md-7 col-xs-12" type="text" path="num" required="required" />
										</div>
										</div>
										<div class="item form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-12">Date</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
										<f:input class="form-control col-md-7 col-xs-12" type="date" id="date" path="date" required="required"  /> 
										</div>
										</div>
										<div class="item form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-12">R�f�rence</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
										<f:input class="form-control col-md-7 col-xs-12" type="text" path="ref" required="required" />
										</div>
										</div>
										<div class="item form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-12">Type de Mouvement</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
										<f:select path="type">
											<f:option value="entree">entr�e</f:option>
											<f:option value="sortie">sortie</f:option>
											<f:option value="depreciation">d�pr�ciation</f:option>
											
										</f:select>
										</div>
										</div>
										
										<div class="form-group">
											<div class="col-md-6 col-md-offset-3">
												<button type="reset" id="nul" class="btn btn-primary">
													Annuler</button>
												<!-- <button id="send" name="submit" value="ajouter"
													type="submit" class="btn btn-success">Ajouter</button> -->
													<f:input  type="submit" path="submit" class="btn btn-success" value="ajouterMouvement" />
											</div>
										</div>
									</f:form>
									

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
</div>
<%@include file="footer.jsp" %>