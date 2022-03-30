package com.cg.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.AppointmentRepository;
import com.cg.entity.Appointment;
@Service
public class AppointmentServiceImpl implements IAppointmentService {
    
	@Autowired
	AppointmentRepository appointmentdao;
	
	@Override
	public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = appointmentdao.findAll();  		
		return appointments;
	}

	

	@Override
	public Appointment addAppointment(Appointment app) {
        Appointment ap = appointmentdao.save(app);
		return app;
	}

	

	@Override
	public Appointment updateAppointment(Appointment app) {
        Appointment appointment = appointmentdao.saveAndFlush(app);
		return appointment;
	}

	
}

