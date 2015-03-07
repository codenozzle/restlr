var TESTINGTOOL = (function () {
	var instance;
	
	function init() {
		
		var stickyNoteDefaults = {
	        position: "top-right",
	        speed: "fast",
	        allowdupes: true,
	        autoclose: 800,
	        classList: ""
	    };
		
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
		
		function showSuccessOutput(receiveDataType, returnedMedia) {
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
		}
		
		function showErrorOutput(returnedMedia) {
			console.log(returnedMedia);
	    	$("pre").removeClass().addClass("prettyprint lang-json");
	    	$("#rest-output").text(JSON.stringify(returnedMedia, null, '\t'));
		}
		
		function resetUI() {
			showGetOrDelete();
		}
		
		function showGetOrDelete() {
			$("#send-data-group").hide();
			$("#send-file-group").hide();
			$('#send-data').val("");
	    	$('#rest-output').text("");
		}
		
		function showPostOrPut() {
			$("#send-data-group").show();
			$("#send-file-group").hide();
			$('#send-data').val("");
			$('#rest-output').text("");
		}
		
		function showFile() {
			$("#send-data-group").hide();
			$('#send-data').val("");
	    	$('#rest-output').text("");
	    	$("#send-file-group").show();
		}
		
		function createStickyNote(message) {
			$.stickyNote(message, $.extend({}, stickyNoteDefaults, { classList: "stickyNote-success" }));
		}
		
		$("input[name=http-code]").click(function() {
	        if (this.value == "get" || this.value == "delete") {
	        	showGetOrDelete();
	        } else if (this.value == "post" || this.value == "put") {
	        	showPostOrPut();
	        } else if (this.value == "file") {
	        	showFile();
	        }
	    });
	    
		function sendRequest(type, url, data, contentType, dataType, processData) {
			/*console.log(type);
			console.log(url);
			console.log(data);
			console.log(contentType);
			console.log(dataType);
			console.log(processData);*/
			$.ajax({
		         url: url,
		        type: type,
		        data: data,
		        dataType: dataType,
		        contentType: contentType,
		        processData: processData, 
		        cache: false
		    })
		    .done(function(returnedMedia) {
		    	showSuccessOutput(dataType, returnedMedia);
		    })
		    .fail(function(returnedMedia) {
		    	showErrorOutput(returnedMedia);
		    });
		}
		
		$("#submit-button").click(function() {
			var sendData;
			var sendDataType;
			var processData;
			var httpCode;
			var httpCodeVal = $("[name=http-code]:radio:checked").val();
			if (httpCodeVal == "file") {
				httpCode = "post";
				sendDataType = false;
				processData = false;
				var data = new FormData();
				$.each($('#file')[0].files, function(i, file) {
					data.append('file', file);
				});
				sendData = data;
			} else {
				httpCode = httpCodeVal;
				sendDataType = "application/" + $("[name=send-data-type]:radio:checked").val();+"; charset=UTF-8";
				processData = true;
				sendData = $("#send-data").val();
			}
			
			var resourceUrl = $("#resource-url").val();
			var receiveDataType = $("[name=receive-data-type]:radio:checked").val();
			
			sendRequest(httpCode, resourceUrl, sendData, sendDataType, receiveDataType, processData);
			event.preventDefault();
		});
		
		$("#reset-button").click(function() {
			sendRequest("get", "/restlr/api/resetappdata", {}, "application/json; charset=utf-8", "json");
			createStickyNote("App Data reset successfully!");
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