<%
	String pageTitle = "Dashboard";
	String pageName = "dashboard";
%>
<%@include file="/WEB-INF/jspf/header.jspf" %>

<div class="row">
	<div class="col-lg-3 col-md-3">
		<div class="box_stat box_ico">
			<a href="products.jsp">
				<span class="stat_ico stat_ico_1"><i class="icon-edit"></i></span>
			</a>
			<h4 id="product-count"></h4>
			<small>Products</small>
		</div>
	</div>
	<div class="col-lg-3 col-md-3">
		<div class="box_stat box_ico">
			<a href="#">
				<span class="stat_ico stat_ico_1"><i class="icon-tags"></i></span>
			</a>
			<h4 id="order-count"></h4>
			<small>Orders</small>
		</div>
	</div>
	<div class="col-lg-3 col-md-3">
		<div class="box_stat box_ico">
			<a href="users.jsp">
				<span class="stat_ico stat_ico_1"><i class="icon-group"></i></span>
			</a>
			<h4 id="user-count"></h4>
			<small>Users</small>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-lg-3 col-md-3">
		<div class="box_stat box_ico">
			<a href="#">
				<span class="stat_ico stat_ico_1"><i class="icon-camera-retro"></i></span>
			</a>
			<h4 id="image-count"></h4>
			<small>Images</small>
		</div>
	</div>
</div>

<%@include file="/WEB-INF/jspf/footer-begin.jspf" %>

<script>
$(document).ready(function() {
	$.get("/restlr/api/user/count/", function(data) {
		$("#user-count").text(data);
	});
	
	$.get("/restlr/api/product/count/", function(data) {
		$("#product-count").text(data);
	});
	
	$.get("/restlr/api/order/count/", function(data) {
		$("#order-count").text(data);
	});
	
	$.get("/restlr/api/image/count/", function(data) {
		$("#image-count").text(data);
	});
});
</script>

<%@include file="/WEB-INF/jspf/footer-end.jspf" %>