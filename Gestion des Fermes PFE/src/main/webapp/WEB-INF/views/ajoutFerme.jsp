<%@include file="menu.jsp" %>

<%-- 	<c:if test="${!empty errorMessage && !(fn:contains(errorMessage, 'generic'))}">
    <span>
        errorError occured<br />
    </span>
    <script>
        alert("Calling my function ...");
        myFunction(); // this is a call to your function which must be defined in the <head> section or another JS file.
    </script>
</c:if> --%>

		<!-- /page content -->
		<% session.setAttribute("page","ajoutFerme");%>
		<div class="right_col" role="main">

			<div class="">
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
									<h2>
										Ajouter une ferme <small>nouvelle ferme</small>
									</h2>

									<div class="clearfix"></div>
								</div>
								<div class="x_content">

									<f:form modelAttribute="fff" class="form-horizontal form-label-left" >

										<p>
											les champs notés en
											<code> * </code>
											sont des champs obligatoires.
										</p>
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="nom">Nom <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<f:input path="nom" id="nom" class="form-control col-md-7 col-xs-12"
													name="nom" placeholder="Nom de la ferme"
													required="required" type="text" />
											</div>
										</div>
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="adresse">Adresse <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<f:textarea path="adresse" id="adresse" placeholder="Adresse de la ferme"
													required="required" name="adresse"
													class="form-control col-md-7 col-xs-12"></f:textarea>
											</div>
										</div>
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="ville">Ville <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<f:input path="ville" type="text" id="ville" name="ville"
													required="required" class="form-control col-md-7 col-xs-12"
													placeholder="la ville ..." />
											</div>
										</div>
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="number">Titre foncier <span class="required">*</span>
											</label>
											<div class="col-md-5 col-sm-5 col-xs-12">
												<f:input path="titre" type="number" step="0.01" id="titre" name="titre"
													required="required" data-validate-minmax="0,100000000"
													class="form-control col-md-7 col-xs-12" />

											</div>
											<div class="col-md-1 col-sm-1 col-xs-12">
												<select>
													<option value="ha">Ha</option>
													<option value="a">A</option>
													<option value="km">Km²</option>
													<option value="m">M²</option>
												</select>
											</div>
										</div>
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="Groupe">Groupe </label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<f:select path="groupe" name="groupe" id="groupe"
													class="form-control col-md-7 col-xs-12"
													>

													<c:forEach items="${groupes }" var="group">
														<option value="${group.id }">${group.nom }</option>
													</c:forEach>
												</f:select>
											</div>
										</div>

										<div class="ln_solid"></div>
										<div class="form-group">
											<div class="col-md-6 col-md-offset-3">
												<button type="reset" id="nul" class="btn btn-primary">
													Annuler</button>
												<f:button path="submit" id="send" name="submit" value="AjouterFerme"
													type="submit" class="btn btn-success">Ajouter</f:button>
											</div>
										</div>
									</f:form>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- footer content -->
			<footer>
				<div class="">
					<p class="pull-right">
						Footer message | <span class="lead"> <i class="fa fa-paw"></i>
							Footer!
						</span>
					</p>
				</div>
				<div class="clearfix"></div>
			</footer>
			<!-- /footer content -->

		</div>
		<!-- /page content -->
		<div id="custom_notifications" class="custom-notifications dsp_none">
			<ul class="list-unstyled notifications clearfix"
				data-tabbed_notifications="notif-group"></ul>
			<div class="clearfix"></div>
			<div id="notif-group" class="tabbed_notifications"></div>
		</div>
	</div>
	<script
		href="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>

	<!-- chart js -->
	<script
		href="<%=request.getContextPath()%>/resources/js/chartjs/chart.min.js"></script>
	<!-- bootstrap progress js -->
	<script
		href="<%=request.getContextPath()%>/resources/js/progressbar/bootstrap-progressbar.min.js"></script>
	<script
		href="<%=request.getContextPath()%>/resources/js/nicescroll/jquery.nicescroll.min.js"></script>
	<!-- icheck -->
	<script
		href="<%=request.getContextPath()%>/resources/js/icheck/icheck.min.js"></script>

	<script href="<%=request.getContextPath()%>/resources/js/custom.js"></script>
	<!-- form validation -->
	<script
		href="<%=request.getContextPath()%>/resources/js/validator/validator.js"></script>
	<script>
			// initialize the validator function
			validator.message['date'] = 'not a real date';

			// validate a field on "blur" event, a 'select' on 'change' event & a '.reuired' classed multifield on 'keyup':
			$('form').on('blur', 'input[required], input.optional, select.required', validator.checkField).on('change', 'select.required', validator.checkField).on('keypress', 'input[required][pattern]', validator.keypress);

			$('.multi.required').on('keyup blur', 'input', function() {
				validator.checkField.apply($(this).siblings().last()[0]);
			});

			// bind the validation to the form submit event
			//$('#send').click('submit');//.prop('disabled', true);

			/* $('form').submit(function(e) {
				e.preventDefault();
				var submit = true;
				// evaluate the form using generic validaing
				if (!validator.checkAll($(this))) {
					submit = false;
				}

				if (submit)
					this.submit();
				return false;
			}); */

			/* FOR DEMO ONLY */
			$('#vfields').change(function() {
				$('form').toggleClass('mode2');
			}).prop('checked', false);

			$('#alerts').change(function() {
				validator.defaults.alerts = (this.checked) ? false : true;
				if (this.checked)
					$('form .alert').remove();
			}).prop('checked', false);
		</script>
</body>
</html>
