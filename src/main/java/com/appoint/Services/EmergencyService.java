package com.appoint.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appoint.Repo.EmergencyRepo;
import com.appoint.model.Emergency;

@Service
public class EmergencyService {

	@Autowired
	private EmergencyRepo emergencyRepo;

	public Emergency save(Emergency emergency) {
		return emergencyRepo.save(emergency);
	}

	public Emergency findByAppointmentId(String appointmentId) {
		return emergencyRepo.findByAppointmentId(appointmentId);
	}

	public void deleteByAppointmentId(long id) {
		emergencyRepo.deleteById(id);
	}
	
}
