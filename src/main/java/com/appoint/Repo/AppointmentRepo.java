package com.appoint.Repo;

import org.springframework.data.repository.CrudRepository;

import com.appoint.model.Appointment;

public interface AppointmentRepo extends CrudRepository<Appointment, Long>{

	Appointment findByAppointmentId(String appointmentId);

}
