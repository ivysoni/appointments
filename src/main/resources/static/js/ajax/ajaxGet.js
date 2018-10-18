$( document ).ready(function() {

	$("#searchAppointmentBtn").click(function(event) {
		event.preventDefault();
		console.log($('#applicationIdInput').val());
		if($('#applicationIdInput').val().length != 15) {
			alert('Invalid Appointment Id');
			return;
		}
		ajaxSearchAppointment();
	});
	
	
	function ajaxSearchAppointment(){
    	
        $.ajax({
            type: "GET",
            url: "/search/appointment/id/"+$('#applicationIdInput').val(),
            success : function(result) {
            	console.log(result);
            	
            	if(result.status == 'NotFound') {
            		alert('Invalid Appointment ID');
            		return;
            	}
            	var tableBody = '<tr>';
            	tableBody += '<td>' + result.obj.appointmentId + '</td>';
            	tableBody += '<td>' + result.obj.appointmentDate + '</td>';
            	tableBody += '<td>' + result.obj.hosDepartment + '</td>';
            	tableBody += '<td>' + result.obj.type + '</td>';
            	tableBody += '<td> <button type="" class="btn btn-primary btn-xs" id="printAppointmentBtn" value="'+ result.obj.appointmentId +'" ><span class="glyphicon glyphicon-print"></span></button> </td>';
            	tableBody += '<td> <button class="btn btn-danger btn-xs" id="deleteAppointmentBtn" value="'+ result.obj.appointmentId +'" ><span class="glyphicon glyphicon-remove"></span></button> </td>';
            	tableBody += '</tr>';
            	$('#AppointmentsTableBody').html(tableBody);
            	$('#AppointmentTableId').show();
            },
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
    }

	
	
	$("#AppointmentsTableBody").on('click','#deleteAppointmentBtn', function(event) {
		event.preventDefault();
		if(confirm('Confirm Cancellation of Appointment'));
			ajaxDeleteAppointment(this.value);
	});
	
	$("#AppointmentsTableBody").on('click','#printAppointmentBtn', function(event) {
		event.preventDefault();
		window.open('/print/appointment/id/' + this.value, '_blank');
			
	});
	
	function ajaxDeleteAppointment(){
    	
        $.ajax({
            type: "GET",
            url: "/delete/appointment/id/"+$('#applicationIdInput').val(),
            success : function(result) {
            	console.log(result);
            	
            	if(result.status == 'NotFound') {
            		alert('Invalid Appointment ID');
            		return;
            	}
            	$('#AppointmentsTableBody').html('');
            	$('#AppointmentTableId').hide();
            	alert('Appointment Cancelled');
            },
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
    }
	
	
})