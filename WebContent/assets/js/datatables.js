$(document).ready(function() {	
	var rootUrl = "/restlr/api/product/";
	var entityName = "Product";
	
	var defaults = {
        position: "top-right",
        speed: "fast",
        allowdupes: true,
        autoclose: 1000,
        classList: ""
    };
	
	$('#dt_basic2').dataTable({
	    "bServerSide": true,
	    "sAjaxSource": rootUrl,
	    "sAjaxDataProp" : "",
	    "bProcessing": true,
	    "aoColumns": [
		     { "mData": 0 }, 
		     { "mData": 1 },
		     { "mData": 2 }, 
		     { "mData": 3 }, 
		     { "mData": 4 }
	     ]
	});
	
	$.getJSON(rootUrl, function(json) {
		console.log(json);
	});
	
	$("#cancel-button").click(function(){
    	$("#create-form").hide();
    	$('#search-results').show();
    	$("#control-buttons").show();
    });

    $("#create-new-button").click(function(){
    	$('#search-results').hide();
    	$("#create-form").show();
    });
    
    $("#refresh-button").click(function(){
    	console.log($('#dt_basic2').DataTable());
    	$('#dt_basic2').DataTable().draw();
    });
    
	$("#submit-button").click( function() {
		$("form").submit(function() {
	        $.ajax({
	            type: "POST",
	            url: rootUrl,
	            data: $("form").serialize(),
	            success: function (data) { 
	            	console.log(data);
	            }
	        });
	        
	        $.stickyNote(entityName + " creation success", $.extend({}, defaults, {classList: 'stickyNote-success'}))
	        event.preventDefault();
	    });
	});
	
	$("#show-all").click( function() {
		$.ajax({
			type: 'GET',
			url: rootURL,
			dataType: "json", // data type of response
			success: renderList
		});
	});
	
	$("#edit").click( function() {
		$.ajax({
	        type: 'GET',
	        url: rootURL + '/' + id,
	        dataType: "json",
	        success: function(data){
	            $('#btnDelete').show();
	            renderDetails(data);
	        }
	    });
	});	

	$("#update").click( function() {
		$.ajax({
	        type: 'PUT',
	        contentType: 'application/json',
	        url: rootURL + '/' + $('#wineId').val(),
	        dataType: "json",
	        data: formToJSON(),
	        success: function(data, textStatus, jqXHR){
	            alert('Wine updated successfully');
	        },
	        error: function(jqXHR, textStatus, errorThrown){
	            alert('updateWine error: ' + textStatus);
	        }
	    });
	});
	
	$("#delete").click( function() {
		console.log('deleteWine');
	    $.ajax({
	        type: 'DELETE',
	        url: rootURL + '/' + $('#wineId').val(),
	        success: function(data, textStatus, jqXHR){
	            alert('Wine deleted successfully');
	        },
	        error: function(jqXHR, textStatus, errorThrown){
	            alert('deleteWine error');
	        }
	    });
	});
    
});

