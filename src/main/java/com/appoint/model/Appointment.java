package com.appoint.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique=true)
	private String appointmentId=RandomStringUtils.random(15, false, true);
	private String type="OPD";
	private String name="";
	private String dob="";
	private String email="";
	private String phoneNo="";
	private String appointmentDate="";
	private String hosDepartment="";
	private String problemSubject="";
	private String problemDescription="";
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	public String getDob() {
		return dob;
	}
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public String getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	public String getAppointmentDate() {
		return appointmentDate;
	}
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getHosDepartment() {
		return hosDepartment;
	}
	public void setHosDepartment(String hosDepartment) {
		this.hosDepartment = hosDepartment;
	}
	public String getProblemSubject() {
		return problemSubject;
	}
	public void setProblemSubject(String problemSubject) {
		this.problemSubject = problemSubject;
	}
	public String getProblemDescription() {
		return problemDescription;
	}
	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}
}
