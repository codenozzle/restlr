function UI(resourceUrl, columnMap, tableSelector, entityName) {
	this.oTable;
	this.resourceUrl = resourceUrl;
	this.columnMap = columnMap;
	this.tableSelector = tableSelector;
	this.entityName = entityName;
	this.defaults = {
        position: "top-right",
        speed: "fast",
        allowdupes: true,
        autoclose: 500,
        classList: ""
    };
}

UI.prototype = {
	init: UI,
	
	createTable: function () {
		this.oTable = $(this.tableSelector).DataTable({
			"bProcessing": false,
			"sAjaxSource": this.resourceUrl,
			"sAjaxDataProp": "",
			"aoColumns": this.columnMap
	    });
		return this.oTable;
	},
	
	resetUI: function () {
		$("#create-form").hide();
    	$('#search-results').show();
    	$("#control-buttons").show();
    	this.refresh();
	},
	
	showCreate: function () {
		$('#search-results').hide();
    	$("#create-form").show();
	},
	
	refresh: function () {
		this.oTable.fnDraw(false);
	},
	
	submitForm: function (resourceUrl) {
		$("form").submit( function(event) {
			event.preventDefault();
	        $.ajax({
	            type: "POST",
	            url: resourceUrl,
	            contentType: "application/x-www-form-urlencoded; charset=utf-8",
	            data: $("form").serialize(),
	            success: function (data) {
	            	console.log(data);
	            	$.stickyNote("New record created", $.extend({}, this.defaults, { classList: "stickyNote-success" }));
	            }
	        });
	    });
	}
}

$(document).ready(function() {	
	var columnMap = [
	    { "mDataProp": "productSku" },
	    { "mDataProp": "productName" },
	    { "mDataProp": "description" },
	    { "mDataProp": "price" },
	    { "mDataProp": "active" }
    ];
	
	var ui = new UI("/restlr/api/product/", columnMap, "#dt_basic2", "Product");
	ui.createTable();
	
	$("#cancel-button").click(function(){
		ui.resetUI();
    });

    $("#create-new-button").click(function(){
    	ui.showCreate();
    });
    
    $("#refresh-button").click(function(){
    	ui.refresh();
    });
    
	$("#submit-button").click( function() {
		ui.submitForm("/restlr/api/product/");
		ui.resetUI();
	});
    
});
