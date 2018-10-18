package com.appoint.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appoint.model.Appointment;
import com.appoint.model.Emergency;

@Service
public class RegistrationControllerService {

	@Autowired
	private AppointmentService appointmentService;

	@Autowired
	private EmergencyService emergencyService;

	public Appointment saveOPDAppointment(Appointment appointment) {
		return appointmentService.save(appointment);
	}

	public Emergency saveEmergencyAppointment(Emergency emergency) {
		return emergencyService.save(emergency);
	}

	public Appointment findOPDAppointmentById(String appointmentId) {
		return appointmentService.findByAppointmentId(appointmentId);
	}

	public void deleteOPDAppointmentById(long id) {
		appointmentService.deleteByAppointmentId(id);
	}

	public Emergency findEmergencyAppointmentById(String appointmentId) {
		return emergencyService.findByAppointmentId(appointmentId);
	}

	public void deleteEmergencyAppointmentById(long id) {
		emergencyService.deleteByAppointmentId(id);
	}
	
}
