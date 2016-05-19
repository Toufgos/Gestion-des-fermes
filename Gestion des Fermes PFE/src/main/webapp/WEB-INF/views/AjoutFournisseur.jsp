<%@include file="menu.jsp" %>
		<!-- /page content -->
		<% session.setAttribute("page","ajoutFerme");%>
		<div class="right_col" role="main">

			<div class="">
				<div class="page-title">
					<div class="title_left">
						<h3>Fournisseur</h3>
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
										Ajouter Un nouveau Fournisseur <small> </small>
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
												>Nom <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input path="nom" type="text" id="nom" name="nom" 
													required="required" class="form-control col-md-7 col-xs-12"
													placeholder="nom  ..." />
											</div>
										</div>
										
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												>Adresse <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<textarea name="adresse" required="required" rows="3" cols="6" placeholder="adresse"></textarea>
											</div>
										</div>
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												>tel <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input path="tel" type="tel" id="tel" name="tel" 
													required="required" class="form-control col-md-7 col-xs-12"
													placeholder="tel  ..." />
											</div>
										</div>
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												>email <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input path="email" type="email" id="email" name="email"  
													required="required" class="form-control col-md-7 col-xs-12"
													placeholder="nom  ..." />
											</div>
										</div>
										<div class="item form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												>type <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<select 
													required="required" class="form-control col-md-7 col-xs-12"
													placeholder="nom  ..." name="type">
													<option value="Fournisseur">Fournisseur</option>
													<option value="Client">Client</option>
												</select>
											</div>
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
<script>

$("#send").click(function(){
    var str = $("#tel").val();
    var patt = new RegExp("[0-9]{10}");
    var res = patt.test(str);
    var str2 = $("#email").val();
    var patt2 = new RegExp("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    var res2 = patt2.test(str2);
    if(res==false  ){
    	alert("le numero de telephone est incorrect");
    }
    else if (res2==false){
    	alert("l'email est incorrect");
    }
    else{
    	$("form").submit();
    }
});


</script>

<%@include file="footer.jsp" %>