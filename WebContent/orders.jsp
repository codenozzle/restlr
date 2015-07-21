<%
	String pageTitle = "Orders";
	String pageName = "orders";
%>
<%@include file="/WEB-INF/jspf/header.jspf" %>

<div class="row">
	<div class="col-sm-12">
		<div class="panel panel-default">
			<div class="panel-heading" id="orderHeader"></div>
			<div class="panel-body">
				<div class="row">
					<div class="col-sm-12">
						<ul class="nav nav-tabs">
							<li class="active"><a data-toggle="tab" href="#tbb_order_details">Summary</a></li>
							<li class=""><a data-toggle="tab" href="#tbb_notes">Notes</a></li>
							<li class=""><a data-toggle="tab" href="#tbb_images">Images</a></li>
						</ul>
						<div class="tab-content">
							<div id="tbb_order_details" class="tab-pane active">
									<div class="row">
										<div class="col-sm-3" id="user"></div>
										<div class="col-sm-3" id="misc"></div>
										<div class="col-sm-3" id="shipTo"></div>
										<div class="col-sm-3" id="billTo"></div>
									</div>
							</div>
							<div id="tbb_notes" class="tab-pane">
								<p>Notes</p>
							</div>
							<div id="tbb_images" class="tab-pane">
								<div class="row">
									<div class="col-sm-12">
										<div class="panel panel-default">
											<div class="panel-heading">
												<h4 class="panel-title">Gallery</h4>
											</div>
											<nav class="panel_controls">
												<div class="row">
													<div class="col-sm-4">
														<span class="gal_lay_change lay_active" id="gal_toGrid"><i class="icon-th"></i></span>
														<span class="gal_lay_change" id="gal_toList"><i class="icon-align-justify"></i></span>
													</div>
													<div class="col-sm-4">
														<select name="gal_filter_a" id="gal_filter_a" class="form-control" multiple>
															<option value="user_0">Casey Wilderman</option>
															<option value="user_1">Giuseppe Funk</option>
															<option value="user_2">Terrill Purdy</option>
															<option value="user_3">Alden Cormier</option>
															<option value="user_4"> Cameron Upton</option>
														</select>
													</div>
													<div class="col-sm-4">
														<select name="gal_filter_b" id="gal_filter_b" class="form-control" multiple>
															<option value="business">business</option>
															<option value="travel">travel</option>
															<option value="family">family</option>
															<option value="nature">nature</option>
														</select>
													</div>
												</div>
											</nav>
											<ul id="gallery_grid" class="galMix grid">
												<li>
													<div class="gal_sort_list clearfix">
														<div class="img_wrapper"></div>
														<div class="meta name">Name</div>
														<div class="meta user">User</div>
														<div class="meta date">Date</div>
														<div class="meta category">Category</div>
													</div>
												</li>
												<li class="gal_no_result">Sorry, there are no images to show.</li>
																						<li class="mix user_0 business family" data-name="Image 1" data-timestamp="1383519600">
													<a href="gallery/Image01.jpg" class="img-thumbnail img_wrapper gal_lightbox">
														<img src="gallery/Image01_tn.jpg" class="img-responsive" alt="">
													</a>
													<div class="meta name">
														<h2 class="gal_title">Image01 lorem ipsum</h2>
														<span class="text-muted">gallery/Image01.jpg</span>
													</div>
													<div class="meta user">Casey Wilderman</div>
													<div class="meta date">04-11-2013</div>
													<div class="meta category">
														<span class="label label-default">business</span>
														<span class="label label-default">family</span>
													</div>
												</li>
												<li class="mix user_1 nature business" data-name="Image 2" data-timestamp="1383865200">
													<a href="gallery/Image02.jpg" class="img-thumbnail img_wrapper gal_lightbox">
														<img src="gallery/Image02_tn.jpg" class="img-responsive" alt="">
													</a>
													<div class="meta name">
														<h2 class="gal_title">Image02 lorem ipsum</h2>
														<span class="text-muted">gallery/Image02.jpg</span>
													</div>
													<div class="meta user">Giuseppe Funk</div>
													<div class="meta date">08-11-2013</div>
													<div class="meta category">
														<span class="label label-default">nature</span>
														<span class="label label-default">business</span>
													</div>
												</li>
												<li class="mix user_2 business travel" data-name="Image 3" data-timestamp="1382824800">
													<a href="gallery/Image03.jpg" class="img-thumbnail img_wrapper gal_lightbox">
														<img src="gallery/Image03_tn.jpg" class="img-responsive" alt="">
													</a>
													<div class="meta name">
														<h2 class="gal_title">Image03 lorem ipsum</h2>
														<span class="text-muted">gallery/Image03.jpg</span>
													</div>
													<div class="meta user">Terrill Purdy</div>
													<div class="meta date">27-10-2013</div>
													<div class="meta category">
														<span class="label label-default">business</span>
														<span class="label label-default">travel</span>
													</div>
												</li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="row" id="line-items">
	<div class="col-sm-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">Line Items</h4>
			</div>
			<table id="dt_basic" class="table table-striped">
				<thead>
					<tr>
						<th>Product</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Subtotal</th>
						<th>Id</th>
					</tr>
				</thead>
			</table>
		</div>
		<div class="dt-row dt-bottom-row">
			<div class="row">
				<div class="col-sm-5">
					<div class="dataTables_info" id="dt_basic_info">3 Items in this Order</div>
				</div>
				<div class="col-sm-7 text-right">
					$499.99
				</div>
			</div>
		</div>
	</div>
</div>
						
<%@include file="/WEB-INF/jspf/footer-begin.jspf" %>

<script src="assets/js/mixitup/jquery.mixitup.min.js"></script>
<script src="assets/js/multiple-select/jquery.multiple.select.js"></script>
<script src="assets/js/magnific-popup/jquery.magnific-popup.min.js"></script>
<script src="assets/js/ebro_gallery.js"></script>
<script src="assets/js/api-utils.js"></script>
<script src="assets/js/datatables.js"></script>
<script src="assets/js/handlebars-v3.0.0.js"></script>

<script id="user-template" type="text/x-handlebars-template">
	<div class="form-group">
		Created By: {{user.firstName}} {{user.lastName}}<br />
		Created On: {{created}}<br />
		Status: <span class="badge badge-success">{{orderStatus.title}}</span>
	</div>
</script>
<script id="bill-to-template" type="text/x-handlebars-template">
	<div class="form-group">
		<label for="reg_input">Bill To</label>
		{{billingAddress.name}}<br />
		{{billingAddress.address1}}<br />
		{{billingAddress.city}}, {{billingAddress.state}} {{billingAddress.zip}}
	</div>
</script>
<script id="ship-to-template" type="text/x-handlebars-template">
	<div class="form-group">
		<label for="reg_input">Ship To</label>
		{{shippingAddress.name}}<br />
		{{shippingAddress.address1}}<br />
		{{shippingAddress.city}}, {{shippingAddress.state}} {{shippingAddress.zip}}
	</div>
</script>
<script id="misc-template" type="text/x-handlebars-template">
	<div class="form-group">
		Taxes: {{taxes}}<br />
		Shipping: {{shipping}}<br />
		Subtotal: {{subTotal}}<br />
		Grand Total: {{grandTotal}}
	</div>
</script>
<script id="order-header-template" type="text/x-handlebars-template">
	<h4 class="panel-title">Order: {{id}}</h4>
</script>

<script>
var uri = "/restlr/api/order/" + 1;
var apiUtils = APIUtils.getInstance();
var ui = UI.getInstance(uri);

var columnMap = [ 
	{ "mDataProp": "product.productName" },
	{ "mDataProp": "product.price" },
	{ "mDataProp": "quantity" },
	{ "mDataProp": "subTotal" },
	{ "mDataProp": "product.id" }
];
           	
var columnDefs = [{
	"aTargets": [4],
	"mDataProp": "id",
	"bSortable": false,
	"mRender": function (data, type, row) {
		return '<button id="manage" onclick="ui.showEdit(' + data + ')">Manage</button>';
	}
}];
           	
function handleData(data, textStatus, jqXHR) {
	var orderHeaderTemplate = Handlebars.compile($("#order-header-template").html());
	var userTemplate = Handlebars.compile($("#user-template").html());
	var billToTemplate = Handlebars.compile($("#bill-to-template").html());
	var shipToTemplate = Handlebars.compile($("#ship-to-template").html());
	var miscTemplate = Handlebars.compile($("#misc-template").html());
	
	$("#orderHeader").append(orderHeaderTemplate(data));
	$("#user").append(userTemplate(data));
	$("#billTo").append(billToTemplate(data));
	$("#shipTo").append(shipToTemplate(data));
	$("#misc").append(miscTemplate(data));
	
	ui.createTable2(data.lineItems, columnMap, columnDefs, "#dt_basic");
}

$(document).ready(function() {
  	apiUtils.apiGet(uri).done(handleData);
});
</script>

<%@include file="/WEB-INF/jspf/footer-end.jspf" %>