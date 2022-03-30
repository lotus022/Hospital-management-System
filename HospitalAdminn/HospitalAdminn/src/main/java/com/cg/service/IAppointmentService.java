package com.cg.service;

import java.util.List;

import com.cg.entity.Appointment;

public interface IAppointmentService {
 
	 List<Appointment> getAllAppointments();
	 Appointment  addAppointment(Appointment app);
	 Appointment updateAppointment(Appointment app);
	
}
