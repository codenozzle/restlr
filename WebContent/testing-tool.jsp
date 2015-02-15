<%
	String pageTitle = "Testing Tool";
	String pageName = "testing-tool";
%>
<%@include file="/WEB-INF/jspf/header.jspf" %>
					
<!-- create form -->
<div class="row" id="create-form">
	<div class="col-sm-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">Testing Tool</h4>
			</div>
			<div class="panel-body">
				<form id="testing-form">
					<div class="row">
						<div class="col-sm-10">
							<div class="form-group">
								<input type="text" id="rest_url" class="form-control" name="rest_url" placeholder="Resource Url" />
							</div>
							<div class="form-group">
								<label class="radio-inline">
									<input type="radio" name="rest_http_code" id="http_code_get" value="get" checked> GET
								</label>
								<label class="radio-inline">
									<input type="radio" name="rest_http_code" id="http_code_post" value="post"> POST
								</label>
								<label class="radio-inline"> 
									<input type="radio" name="rest_http_code" id="http_code_put" value="put"> PUT
								</label>
								<label class="radio-inline">
									<input type="radio" name="rest_http_code" id="http_code_delete" value="delete"> DELETE
								</label>
							</div>
							<div class="form-group" id="data_textarea_group" style="display: none;">
								<label for="data_textarea">Data</label>
								<textarea name="data_textarea" id="data_textarea" cols="10" rows="12" class="form-control"></textarea>
							</div>
							<div class="form-group">
								<label class="radio-inline">
									<input type="radio" name="media_type" id="media_type_xml" value="xml"> XML
								</label>
								<label class="radio-inline">
									<input type="radio" name="media_type" id="media_type_json" value="json" checked> JSON
								</label>
							</div>
							<hr />
							<div class="form-group">
								<label for="data_textarea">Output</label>
								<pre id="rest_output" class="prettyprint"></pre>
							</div>
						</div>
						<div class="col-sm-1">
							<button type="submit" class="btn btn-primary" id="submit-button">Go</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<%@include file="/WEB-INF/jspf/footer-begin.jspf" %>

<script src="assets/js/testing-tool.js"></script>
<script>

$(document).ready(function() {
	var testingTool = TESTINGTOOL.getInstance();
});
</script>

<%@include file="/WEB-INF/jspf/footer-end.jspf" %>
