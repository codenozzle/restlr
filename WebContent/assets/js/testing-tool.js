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

		function sendRequest(httpCode, resourceUrl, sendData, sendDataType, receiveDataType) {
			console.log(httpCode);
			console.log(resourceUrl);
			console.log(sendData);
			console.log(sendDataType);
			console.log(receiveDataType);
			
		    $.ajax({
		         url: resourceUrl,
		        type: httpCode,
		        data: sendData,
		        dataType: receiveDataType,
		        contentType: sendDataType
		    })
		    .done(function(returnedMedia) {
		    	var output;
		    	if (receiveDataType == "json") {
		    		$("pre").removeClass().addClass("prettyprint lang-json");
		    		output = JSON.stringify(returnedMedia, null, '\t');
		    	} else if (receiveDataType == "xml") {
		    		$("pre").removeClass().addClass("prettyprint lang-xml");
		    		output = formatXml(new XMLSerializer().serializeToString(returnedMedia));
		    	}
		    	$("#rest-output").text(output);
		    	prettyPrint();
		    })
		    .fail(function(returnedMedia) {
		    	$("#rest-output").text("error");
		    });
		}
		
		function resetUI() {
			showGetOrDelete();
		}
		
		function showGetOrDelete() {
			$("#send-data-group").hide();
			$('#send-data').text("");
	    	$('#rest-output').text("");
		}
		
		function showPostOrPut() {
			$("#send-data-group").show();
			$('#send-data').text("");
			$('#rest-output').text("");
		}
		
		$("input[name=http-code]").click(function() {
	        if (this.value == "get" || this.value == "delete") {
	        	showGetOrDelete();
	        } else if (this.value == "post" || this.value == "put") {
	        	showPostOrPut();
	        }
	    });
	    
		$("#submit-button").click(function() {
			var httpCode = $("[name=http-code]:radio:checked").val();
			var resourceUrl = $("#resource-url").val();
			var sendData = $("#send-data").val();
			var sendDataType = "application/" + $("[name=send-data-type]:radio:checked").val()+"; charset=UTF-8";
			var receiveDataType = $("[name=receive-data-type]:radio:checked").val();
			sendRequest(httpCode, resourceUrl, sendData, sendDataType, receiveDataType);
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