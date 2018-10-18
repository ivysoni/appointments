$( document ).ready(function() {
	$(function(){
	    $('.appointmentDateVal').prop('min', function(){
	        return new Date().toJSON().split('T')[0];
	    });
	});
})