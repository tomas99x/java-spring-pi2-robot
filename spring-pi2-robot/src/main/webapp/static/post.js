
$(document).ready(function() {
	$('#getAll').on('click', function(event) {

		event.preventDefault();
		ajaxPost();
	});
    
    
    function ajaxPost(){
    	var formData = {

        		stepsNumber : $(".qty").val()
        	}
    	$.ajax({

    		type : "POST",
			contentType : "application/json",
			url : window.location + "walk",
			data : JSON.stringify(formData),
			success : function() {
				
				console.log(formData);
			},
			error : function(e) {
				console.log("ERROR: ", e);
			}
		});
    	resetData();
    }
    function resetData(){
    	$("#name").val("");
    	$("#surname").val("");
    }
    
    
});