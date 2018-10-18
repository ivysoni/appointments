package com.appoint.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appoint.Repo.AppointmentRepo;
import com.appoint.model.Appointment;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepo appointmentRepo;

	public Appointment save(Appointment appointment) {
		return appointmentRepo.save(appointment);
	}

	public Appointment findByAppointmentId(String appointmentId) {
		return appointmentRepo.findByAppointmentId(appointmentId);
	}

	public void deleteByAppointmentId(long id) {
		appointmentRepo.deleteById(id);
	}
	
}
