package com.appoint.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.appoint.Services.RegistrationControllerService;
import com.appoint.dto.Response;
import com.appoint.model.Appointment;
import com.appoint.model.Emergency;

@RestController
public class RegistrationController {
	
	@Autowired
	private RegistrationControllerService regController;
	
	
	@PostMapping("/book/appointment")
	public Response bookAppointment(@ModelAttribute Appointment appointment) {
		try {
			appointment = regController.saveOPDAppointment(appointment);
			return new Response("Success","OK",appointment);
		}
		catch (Exception e) {
			return new Response("Internal Server Error","500",appointment);
		}
		
	}
	
	@PostMapping("/book/emergency")
	public Response bookEmergency(@ModelAttribute Emergency emergency) {
		try {	
			emergency = regController.saveEmergencyAppointment(emergency);
			return new Response("Success","OK",emergency);
		}
		catch (Exception e) {
			return new Response("Internal Server Error","500",emergency);
		}
	}
	
	@GetMapping("/search/appointment/id/{apointId}")
	public Object searchAppointment(@PathVariable("apointId") String appointmentId) {
		
		Appointment appointment = regController.findOPDAppointmentById(appointmentId);
		if(appointment!=null) {
			return new Response("Appointment Found","OK",appointment);
		}
		Emergency emergency = regController.findEmergencyAppointmentById(appointmentId);
		if(emergency!=null) {
			return new Response("Appointment Found","OK",emergency);
		}
		return new Response("Appointment Not Found","NotFound",appointmentId);
	}
	
	@GetMapping("/print/appointment/id/{apointId}")
	public Object printAppointment(@PathVariable("apointId") String appointmentId) {
		
		Appointment appointment = regController.findOPDAppointmentById(appointmentId);
		if(appointment!=null) {
			return new ModelAndView("printPresc","appointment",appointment);
		}
		Emergency emergency = regController.findEmergencyAppointmentById(appointmentId);
		if(emergency!=null) {
			return new ModelAndView("printPresc","appointment",emergency);
		}
		return "Appointment Not Found with Appointment Id: " + appointmentId;
	}
	
	@GetMapping("/delete/appointment/id/{apointId}")
	public Object deleteAppointment(@PathVariable("apointId") String appointmentId) {
		
		Appointment appointment = regController.findOPDAppointmentById(appointmentId);
		if(appointment!=null) {
			regController.deleteOPDAppointmentById(appointment.getId());
			return new Response("Appointment Deleted","OK",appointmentId);
		}
		Emergency emergency = regController.findEmergencyAppointmentById(appointmentId);
		if(emergency!=null) {
			regController.deleteEmergencyAppointmentById(emergency.getId());
			return new Response("Appointment Deleted","OK",appointmentId);
		}
		return new Response("Appointment Not Found","NotFound",appointmentId);
	}
}
