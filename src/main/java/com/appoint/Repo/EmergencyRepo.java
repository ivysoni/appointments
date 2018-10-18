package com.appoint.Repo;

import org.springframework.data.repository.CrudRepository;

import com.appoint.model.Emergency;

public interface EmergencyRepo extends CrudRepository<Emergency, Long>{

	Emergency findByAppointmentId(String appointmentId);

}
