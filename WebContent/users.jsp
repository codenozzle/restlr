<%
	String pageTitle = "Users";
	String pageName = "users";
%>
<%@include file="/WEB-INF/jspf/header.jspf" %>
						
<!-- control buttons -->
<div class="row" id="control-buttons">
	<div class="col-sm-4">
		<button type="button" class="btn btn-default btn-lg" id="create-new-button">Create New User</button>
	</div>
	<div class="col-sm-4">
		<button type="button" class="btn btn-default btn-lg" id="refresh-button">Refresh</button>
	</div>
</div>
					
<!-- create form -->
<div class="row" id="create-form" style="display: none;">
	<div class="col-sm-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">Create</h4>
			</div>
			<div class="panel-body">
				<form id="create-form">
					<div class="row">
						<div class="col-sm-4">
							<div class="form-group">
								<label for="reg_input">First Name</label>
								<input type="text" id="firstName" class="form-control" name="firstName" />
							</div>
							<div class="form-group">
								<label for="reg_input">Last Name</label>
								<input type="text" id="lastName" class="form-control" name="lastName" />
							</div>
							<div class="form-group">
								<label for="reg_input">Email</label>
								<input type="text" id="emailAddress" class="form-control" name="emailAddress" />
							</div>
						</div>
						<div class="col-sm-4">
                            <div class="form-group">
                            	<label>Active</label>
								<label class="radio-inline">
									<input type="radio" name="active" id="active" value="true" checked /> Yes
								</label>
								<label class="radio-inline">
									<input type="radio" name="active" id="not-active" value="false" /> No
								</label>
							</div>
						</div>
					</div>
					<button type="submit" class="btn btn-primary" id="submit-button">Submit</button>
					<button type="button" class="btn btn-default" id="cancel-button">Cancel</button>
				</form>
			</div>
		</div>
	</div>
</div>

<!-- search results -->
<div class="row" id="search-results">
	<div class="col-sm-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">Search Results</h4>
			</div>
			<table id="dt_basic2" class="table table-striped">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Active</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</div>

<%@include file="/WEB-INF/jspf/footer-begin.jspf" %>

<script src="assets/js/datatables.js"></script>
<script>
$(document).ready(function() {	
	var columnMap = [
     	{ "mDataProp": "firstName" },
     	{ "mDataProp": "lastName" },
     	{ "mDataProp": "emailAddress" },
     	{ "mDataProp": "active" }
     ];

    var ui = UI.getInstance("/restlr/api/user/", columnMap, "#dt_basic2");
    ui.createTable();    
});
</script>

<%@include file="/WEB-INF/jspf/footer-end.jspf" %>