<!-- select2 -->
        <script>
            $(document).ready(function () {
                $(".select2_single").select2({
                    placeholder: "Select a state",
                    allowClear: true
                });
                $(".select2_group").select2({});
                $(".select2_multiple").select2({
                    maximumSelectionLength: 4,
                    placeholder: "With Max Selection limit 4",
                    allowClear: true
                });
            });
        </script>
         <script type="text/javascript">
    var config = {
      '.chosen-select'           : {},
      '.chosen-select-deselect'  : {allow_single_deselect:true},
      '.chosen-select-no-single' : {disable_search_threshold:10},
      '.chosen-select-no-results': {no_results_text:'Oops, nothing found!'},
      '.chosen-select-width'     : {width:"95%"}
    }
    for (var selector in config) {
      $(selector).chosen(config[selector]);
    }
  </script>
        <!-- /select2 -->
        <script src="<%=request.getContextPath()%>/resources/js/editor/bootstrap-wysiwyg.js"></script>
        <script src="<%=request.getContextPath()%>/resources/js/editor/external/jquery.hotkeys.js"></script>
        <script src="<%=request.getContextPath()%>/resources/js/editor/external/google-code-prettify/prettify.js"></script>
        <!-- select2 -->
        <script src="<%=request.getContextPath()%>/resources/js/select/select2.full.js"></script>
        
        <script src="<%=request.getContextPath()%>/resources/js/chosen/chosen.jquery.js" ></script>
        <script src="<%=request.getContextPath()%>/resources/js/chosen/chosen.jquery.min.js" ></script>
        <script src="<%=request.getContextPath()%>/resources/js/chosen/chosen.proto.js" ></script>
        <script src="<%=request.getContextPath()%>/resources/js/chosen/chosen.prism.js" ></script>
        <script src="<%=request.getContextPath()%>/resources/js/chosen/chosen.proto.min.js" ></script>
        
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/chosen.css">	
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/chosen.min.css">	  
		
        <link href="<%=request.getContextPath()%>/resources/css/chosen/prism.css" >
         <link href="<%=request.getContextPath()%>/resources/css/chosen/style.css" >
        
<%@include file="menu.jsp" %>
		<!-- /page content -->
		<% session.setAttribute("page","ajoutFerme");%>
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
										Ajouter un groupe <small>nouveau groupe </small>
									</h2>

									<div class="clearfix"></div>
								</div>
								<div class="x_content">

									<form class="form-horizontal form-label-left" novalidate>

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
												<input id="nom" class="form-control col-md-7 col-xs-12"
													name="libelle" placeholder="Nom du groupe"
													required="required" type="text">
											</div>
										</div>
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="adresse">description <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<textarea id="description" placeholder="Description du Groupe ..."
													required="" name="description"
													class="form-control col-md-7 col-xs-12"></textarea>
											</div>
										</div>
									
										<div class="ln_solid"></div>
										<div class="form-group">
											<div class="col-md-6 col-md-offset-3">
												<button type="reset" id="nul" class="btn btn-primary">
													Annuler</button>
												<button id="send" name="submit" value="AjouterGroupe"
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