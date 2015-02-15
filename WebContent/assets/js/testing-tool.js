var TESTINGTOOL = (function () {
	var instance;
	
	function init() {
		
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
			console.log(data);
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
		
		function resetUI() {
			showGetOrDelete();
		}
		
		function showGetOrDelete() {
			$("#data_textarea_group").hide();
			$('#data_textarea').text("");
	    	$('#rest_output').text("");
		}
		
		function showPostOrPut() {
			$("#data_textarea_group").show();
			$('#data_textarea').text("");
			$('#rest_output').text("");
		}
		
		$("input[name=rest_http_code]").click(function() {
	        if (this.value == "get" || this.value == "delete") {
	        	showGetOrDelete();
	        } else if (this.value == "post" || this.value == "put") {
	        	showPostOrPut();
	        }
	    });
	    
		$("#submit-button").click(function() {
			var url = $("#rest_url").val();
			var httpCode = $("[name=rest_http_code]:radio:checked").val();
			var mediaType = $("[name=media_type]:radio:checked").val();
			var data = $("[name=data_textarea]").val();
			sendRequest(url, httpCode, data, mediaType);
			event.preventDefault();
		});
 
	    return {
	    	resetUI: resetUI,
    	};
    	
	};
 
	return {
		getInstance: function () {
			if (!instance) {
				instance = init();
			}
			return instance;
		}
	};
})();