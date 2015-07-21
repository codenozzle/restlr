<%
	String pageTitle = "Addresses";
	String pageName = "addresses";
%>
<%@include file="/WEB-INF/jspf/header.jspf" %>
						
<!-- control buttons -->
<div class="row" id="control-buttons">
	<div class="col-sm-3">
		<button type="button" class="btn btn-default btn-lg" id="create-new-button">Create New Address</button>
	</div>
	<div class="col-sm-3">
		<button type="button" class="btn btn-default btn-lg" id="refresh-button"><i class="icon-refresh"></i></button>
	</div>
</div>
					
<!-- create form -->
<div class="row" id="create-form-container" style="display: none;">
	<div class="col-sm-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">User</h4>
			</div>
			<div class="panel-body">
				<form id="create-form">
					<div class="row">
						<div class="col-sm-4">
							<div class="form-group">
								<label for="reg_input">Address 1</label>
								<input type="text" id="address1" class="form-control" name="address1" />
							</div>
							<div class="form-group">
								<label for="reg_input">Address 2</label>
								<input type="text" id="address2" class="form-control" name="address2" />
							</div>
							<div class="form-group">
								<label for="reg_input">City</label>
								<input type="text" id="city" class="form-control" name="city" />
							</div>
							<div class="form-group">
								<label for="reg_input">State</label>
								<input type="text" id="state" class="form-control" name="state" />
							</div>
							<div class="form-group">
								<label for="reg_input">Zip</label>
								<input type="text" id="zip" class="form-control" name="zip" />
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
					<button type="button" class="btn btn-default" id="update-button">Update</button>
					<button type="button" class="btn btn-danger" id="delete-button">Delete</button>
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
						<th>Address 1</th>
						<th>Address 2</th>
						<th>City</th>
						<th>State</th>
						<th>Zip</th>
						<th>&nbsp;</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</div>

<%@include file="/WEB-INF/jspf/footer-begin.jspf" %>

<script src="assets/js/datatables.js"></script>
<script>
var ui = UI.getInstance("/restlr/api/address/");

$(document).ready(function() {	
	var columnMap = [
     	{ "mDataProp": "address1" },
     	{ "mDataProp": "address2" },
     	{ "mDataProp": "city" },
     	{ "mDataProp": "state" },
     	{ "mDataProp": "zip" },
     	{ "mDataProp": "id" }
    ];

	var columnDefs = [{
		"aTargets": [5],
	    "mDataProp": "id",
	    "bSortable": false,
	    "mRender": function (data, type, row) {
	    	return '<button id="manage" onclick="ui.showEdit(' + data + ')">Manage</button>';
	    }
	}];
    
    ui.createTable(columnMap, columnDefs, "#dt_basic2");    
});
</script>

<%@include file="/WEB-INF/jspf/footer-end.jspf" %>
