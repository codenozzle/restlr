<%
	String pageTitle = "Products";
	String pageName = "products";
%>
<%@include file="/WEB-INF/jspf/header.jspf" %>

<!-- control buttons -->
<div class="row" id="control-buttons">
	<div class="col-sm-3">
		<button type="button" class="btn btn-default btn-lg" id="create-new-button">Create New Product</button>
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
				<h4 class="panel-title">Product</h4>
			</div>
			<div class="panel-body">
				<form id="create-form">
					<div class="row">
						<div class="col-sm-4">
							<div class="form-group">
								<label for="reg_input">Product SKU</label>
								<input type="text" id="productSku" class="form-control" name="productSku" />
							</div>
							<div class="form-group">
								<label for="reg_input">Product Name</label>
								<input type="text" id="productName" class="form-control" name="productName" />
							</div>
							<div class="form-group">
								<label for="reg_textarea">Description</label>
								<textarea name="description" id="description" cols="10" rows="3" class="form-control"></textarea>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
                            	<label>Price</label>
                            	<div class="input-group">
									<span class="input-group-addon">$</span>
									<input class="form-control" id="price" type="text" name="price" />
									<span class="input-group-addon">.00</span>
		                        </div>
                            </div>
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
					<button type="submit" class="btn btn-primary" id="update-button">Update</button>
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
						<th>Product SKU</th>
						<th>Product Name</th>
						<th>Description</th>
						<th>Price</th>
						<th>Active</th>
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
var ui = UI.getInstance("/restlr/api/product/");

$(document).ready(function() {	
	var columnMap = [
     	{ "mDataProp": "productSku" },
     	{ "mDataProp": "productName" },
     	{ "mDataProp": "description" },
     	{ "mDataProp": "price" },
     	{ "mDataProp": "active" },
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