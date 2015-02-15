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
				<form id="testing-form" class="form-horizontal">
					<div class="form-group">
						<label for="http-code" class="col-sm-2 control-label">Action</label>
						<div class="col-sm-10">
							<label class="radio-inline">
								<input type="radio" name="http-code" id="http-code-get" value="get" checked> GET
							</label>
							<label class="radio-inline">
								<input type="radio" name="http-code" id="http-code-post" value="post"> POST
							</label>
							<label class="radio-inline"> 
								<input type="radio" name="http-code" id="http-code-put" value="put"> PUT
							</label>
							<label class="radio-inline">
								<input type="radio" name="http-code" id="http-code-delete" value="delete"> DELETE
							</label>
						</div>
					</div>
					<div class="form-group">
						<label for="resource-url" class="col-sm-2 control-label">Url</label>
						<div class="col-sm-10">
							<input type="text" id="resource-url" class="form-control" name="resource-url" />
						</div>
					</div>
					<div id="send-data-group" style="display: none;">
						<hr />
						<div class="form-group">
							<label for="send-data" class="col-sm-2 control-label">Send</label>
							<div class="col-sm-10">
								<textarea name="send-data" id="send-data" cols="10" rows="12" class="form-control"></textarea>
								<label class="radio-inline">
									<input type="radio" name="send-data-type" id="send-data-xml" value="xml"> XML
								</label>
								<label class="radio-inline">
									<input type="radio" name="send-data-type" id="send-data-json" value="json" checked> JSON
								</label>
							</div>
						</div>
						<hr />
					</div>
					<div class="form-group">
						<label for="receive-data-type" class="col-sm-2 control-label">Receive</label>
						<div class="col-sm-10">
							<label class="radio-inline">
								<input type="radio" name="receive-data-type" id="receive-data-type-xml" value="xml"> XML
							</label>
							<label class="radio-inline">
								<input type="radio" name="receive-data-type" id="receive-data-type-json" value="json" checked> JSON
							</label>
							<label class="radio-inline">
								<button type="submit" class="btn btn-primary" id="submit-button">Go</button>
							</label>
						</div>
					</div>
					<hr />
					<div class="form-group">
						<label for="rest-output" class="col-sm-2 control-label">Output</label>
						<div class="col-sm-10">
							<pre id="rest-output" class="prettyprint"></pre>
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
