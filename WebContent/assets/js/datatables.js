var UI = (function () {
	
	var instance;
	
	function init(resourceUrl) {
		
		var resourceUrl = resourceUrl;
		var oTable;
		var stickyNoteDefaults = {
	        position: "top-right",
	        speed: "fast",
	        allowdupes: true,
	        autoclose: 800,
	        classList: ""
	    };
		
		function createTable(columnMap, columnDefs, tableSelector) {
			oTable = $(tableSelector).dataTable({
				sAjaxSource: resourceUrl,
				sAjaxDataProp: "",
				aoColumns: columnMap,
				aoColumnDefs: columnDefs
			});
		}
		
		function createTable2(dataSet, columnMap, columnDefs, tableSelector) {
			oTable = $(tableSelector).dataTable({
				aaData: dataSet,
		        aoColumns: columnMap,
				aoColumnDefs: columnDefs
			});
		}
		
		function refreshResults() {
			oTable.fnClearTable();
			oTable.fnReloadAjax();
		}
		
		function createStickyNote(message) {
			$.stickyNote(message, $.extend({}, stickyNoteDefaults, { classList: "stickyNote-success" }));
		}
		
		function loadForm(id) {
			$.ajax({
		        url: resourceUrl + id,
		        type: "GET",
		        dataType: "json"
		    })
		    .done(function(returnedMedia) {
		    	$.each(returnedMedia, function(key, value){
		    		$("[name=" + key + "]", "form").val(value);
		    	});
		    });
		}
		
		function ajaxCreate() {
			ajax(resourceUrl, "post", $("form").serializeJSON(), "Record created");
		}
		
		function ajaxUpdate(id) {
			ajax(resourceUrl + id, "put", $("form").serializeJSON(), "Record updated");
		}
		
		function ajaxDelete(id) {
			ajax(resourceUrl + id, "delete", {}, "Record deleted");
		}
 
		function ajax(resourceUrl, type, data, message) {
			event.preventDefault();
			$.ajax({
	            type: type,
	            url: resourceUrl,
	            contentType: "application/json; charset=utf-8",
	            dataType: "json",
	            data: data
	        })
	        .done(function(returnedMedia) {
	        	createStickyNote(message);
		    });
		}
		

		$.fn.clearForm = function() {
			return this.each(function() {
				var type = this.type, tag = this.tagName.toLowerCase();
				if (tag == 'form')
					return $(':input', this).clearForm();
				if (type == 'text' || type == 'password' || tag == 'textarea')
					this.value = '';
				else if (type == 'checkbox')
					this.checked = false;
				else if (tag == 'select')
					this.selectedIndex = -1;
			});
		};
		
		function resetUI() {
			refreshResults();
			$("#create-form-container").hide();
	    	$('#search-results').show();
	    	$("#control-buttons").show();
		}
		
		function showCreate() {
			$('#search-results').hide();
			$("#control-buttons").hide();
			$("#update-button").hide();
			$("#delete-button").hide();
			
	    	$("#create-form-container").show();
	    	$("#submit-button").show();
	    	
	    	$('#create-form').clearForm();
		}
		
		function showEdit(id) {
			$('#search-results').hide();
			$("#control-buttons").hide();
			$("#submit-button").hide();
			
	    	$("#create-form-container").show();
	    	$("#update-button").show();
			$("#delete-button").show();	    	
	    	loadForm(id);
	    	
	    	$("#update-button").unbind("click");
	    	$("#update-button").click(function() {
	    		ajaxUpdate(id);
				resetUI();
			});
	    	
	    	$("#delete-button").unbind("click");
	    	$("#delete-button").click(function() {
	    		ajaxDelete(id);
				resetUI();
			});
		}
		
		$("#create-new-button").click(function() {
	    	showCreate();
	    });
	    
	    $("#refresh-button").click(function() {
	    	refreshResults();
	    });
	    
		$("#submit-button").click(function() {
			ajaxCreate();
			resetUI();
		});
		
		$("#cancel-button").click(function() {
			resetUI();
	    });
		
	    return {
	    	createTable: createTable,
	    	createTable2: createTable2,
	    	showEdit: showEdit
    	};
	};
 
	return {
		getInstance: function (resourceUrl) {
			if (!instance) {
				instance = init(resourceUrl);
			}
			return instance;
		}
	};
	
})();
