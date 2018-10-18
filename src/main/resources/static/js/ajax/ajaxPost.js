$( document ).ready(function() {
	
    $("#appointmentbookForm").submit(function(event) {
		event.preventDefault();
		appointmentbookForm();
	});
    
    
    function appointmentbookForm(){
    	
        var bookappointment = new FormData($('#appointmentbookForm')[0]);

        
        $.ajax({
            type: "POST",
            url: "/book/appointment",
            data: bookappointment,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
			success : function(result) {
				if(result.status == 'OK') {
					ShowAppointmentId(result);
				} else {
					alert('Internal Server Error!!! Try Again');
				}
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
        resetappointmentbookForm();
    }
    
    function resetappointmentbookForm(){
    	document.getElementById("appointmentbookForm").reset();
    }
    
    
    
    
    $("#emergencybookForm").submit(function(event) {
		event.preventDefault();
		emergencybookForm(event);
	});
    
    function emergencybookForm(event){
    	
        var emergencybook = new FormData($('#emergencybookForm')[0]);
        
        $.ajax({
            type: "POST",
            url: "/book/emergency",
            data: emergencybook,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
			success : function(result) {
				if(result.status == 'OK') {
					ShowAppointmentId(result);
				} else {
					alert('Internal Server Error!!! Try Again');
				}
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
        resetemergencybookForm();
    }
    
    
    
    function resetemergencybookForm(){
    	document.getElementById("emergencybookForm").reset();
    }
    
    function ShowAppointmentId(result) {
    	
    	console.log(result);
    	copyToClip(result.obj.appointmentId);
    	
    	var msg = '';
		msg += 'Your Appointment is Booked\n';
		msg += 'Appointment Id: ' + result.obj.appointmentId;
		msg += '\nNote: Please Note this Unique Appointment Securely(Copied in ClipBoard).\nyou can again print your Appointment or Cancel it\nusing Appointment Id';
		alert(msg);
		
    }
    
    function copyToClip(appointId) {
    	let copyFrom = document.createElement("textarea");
        document.body.appendChild(copyFrom);
        copyFrom.textContent = appointId;
        copyFrom.select();
        document.execCommand("copy");
        copyFrom.remove();
        console.log(appointId);
    }
})