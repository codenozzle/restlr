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

<script>
function formatXml(xml) {
    var formatted = '';
    var reg = /(>)(<)(\/*)/g;
    xml = xml.replace(reg, '$1\r\n$2$3');
    var pad = 0;
    jQuery.each(xml.split('\r\n'), function(index, node) {
        var indent = 0;
        if (node.match( /.+<\/\w[^>]*>$/ )) {
            indent = 0;
        } else if (node.match( /^<\/\w/ )) {
            if (pad != 0) {
                pad -= 1;
            }
        } else if (node.match( /^<\w[^>]*[^\/]>.*$/ )) {
            indent = 1;
        } else {
            indent = 0;
        }
 
        var padding = '';
        for (var i = 0; i < pad; i++) {
            padding += '  ';
        }
 
        formatted += padding + node + '\r\n';
        pad += indent;
    });
 
    return formatted;
}

function sendRequest(url, httpCode, data, dataType) {
    $.ajax({
         url: url,
        type: httpCode,
        data: data,
        dataType: dataType
    })
    .done(function(returnedMedia) {
    	var output;
    	if (dataType == "json") {
    		$("pre").removeClass().addClass("prettyprint lang-json");
    		output = JSON.stringify(returnedMedia, null, '\t');
    	} else if (dataType == "xml") {
    		$("pre").removeClass().addClass("prettyprint lang-xml");
    		output = formatXml(new XMLSerializer().serializeToString(returnedMedia));
    	}
    	$("#rest_output").text(output);
    	prettyPrint();
    })
    .fail(function(returnedMedia) {
    	$("#rest_output").text("error");
    });
}

$(document).ready(function() {	
	$("form").submit(function(event) {
		var url = $("#rest_url").val();
		var httpCode = $("[name=rest_http_code]:radio:checked").val();
		var mediaType = $("[name=media_type]:radio:checked").val();
		sendRequest(url, httpCode, {}, mediaType);
		event.preventDefault();
	});  
});
</script>

<%@include file="/WEB-INF/jspf/footer-end.jspf" %>
