<%@include file="menu.jsp" %>
		<!-- /page content -->
		<% session.setAttribute("page","ajoutFerme");%>
		<div class="right_col" role="main">

			<div class="">
				<div class="page-title">
					<div class="title_left">
						<h3>Produit</h3>
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
										Ajouter un Nouveau Produit <small>new  </small>
									</h2>

									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									
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
													for="nom">Catégorie <span class="required">*</span>
												</label> 
												
												<select  name="id_ferme" required="required">
													<option selected="selected"> </option>
													<c:forEach items="${ categories}" var="li" >
														<option value="${li.id }" > ${li.nom }</option>
													</c:forEach>							
												</select>
												
											</div>
											
												
												
											<div class="item form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12"
													for="nom">Libelle <span class="required">*</span>
												</label> <input type="text" name="libelle"
													placeholder="libelle Parcelaire " required="required" />
											</div>
											<div class="item form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12"
													for="nom">Quantité Min Au Stock <span class="required">*</span>
												</label> <input type="number" name="s_brute" step="0.01"
													placeholder="Quantité Min Au Stock" required="required" />
											</div>
											<div class="item form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12"
													for="nom">Prix Unitaire <span class="required">*</span>
												</label> <input type="number" name="s_inculte" step="0.01"
													placeholder="Prix Unitaire" required="required"/>
											</div>
											<div class="item form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12"
													for="nom">Description  
												</label> 
												<textarea rows="4" cols="8" name="mode" placeholder="description du produit"></textarea>
													
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
			</div>
</div>
<%@include file="footer.jsp" %>