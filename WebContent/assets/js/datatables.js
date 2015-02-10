var UI = (function () {
	var instance;
	
	function init(resourceUrl, columnMap, tableSelector) {
		var resourceUrl = resourceUrl;
		var columnMap = columnMap;
		var tableSelector = tableSelector;
		var oTable;
		var stickyNoteDefaults = {
	        position: "top-right",
	        speed: "fast",
	        allowdupes: true,
	        autoclose: 800,
	        classList: ""
	    };
		
		$("#cancel-button").click(function() {
			resetUI();
	    });

	    $("#create-new-button").click(function() {
	    	showCreate();
	    });
	    
	    $("#refresh-button").click(function() {
	    	refresh();
	    });
	    
		$("#submit-button").click(function() {
			submitForm();
			refresh();
			resetUI();
		});
		
		function createTable() {
			oTable = $(tableSelector).dataTable({
				sAjaxSource: resourceUrl,
				sAjaxDataProp: "",
				aoColumns: columnMap
		    });
		}
		
		function resetUI() {
			$("#create-form").hide();
	    	$('#search-results').show();
	    	$("#control-buttons").show();
		}
		
		function showCreate() {
			$('#search-results').hide();
	    	$("#create-form").show();
		}
		
		function refresh() {
			oTable.fnReloadAjax();
		}
		
		function createStickyNote() {
			$.stickyNote("New record created", $.extend({}, stickyNoteDefaults, { classList: "stickyNote-success" }));
		}
		
		function submitForm() {
			$("form").submit( function(event) {
				event.preventDefault();
		        $.ajax({
		            type: "POST",
		            url: resourceUrl,
		            contentType: "application/x-www-form-urlencoded; charset=utf-8",
		            data: $("form").serialize(),
		            success: function () {
		            	createStickyNote();
		            }
		        });
		    });
		}
 
	    return {
	    	createTable: createTable,
	    	resetUI: resetUI,
	    	showCreate: showCreate,
	    	refresh: refresh,
	    	submitForm: submitForm
    	};
	};
 
	return {
		getInstance: function (resourceUrl, columnMap, tableSelector) {
			if (!instance) {
				instance = init(resourceUrl, columnMap, tableSelector);
			}
			return instance;
		}
	};
})();
