package com.cg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Appointment;
import com.cg.exception.AppointmentException;
import com.cg.exception.PatientException;
import com.cg.service.IAppointmentService;

@RestController
@RequestMapping("/appoin")
@CrossOrigin
public class AppointmentController{
	@Autowired
	IAppointmentService service;
	Logger logger = LoggerFactory.getLogger(AppointmentController.class);
	
	
	@PostMapping("/addAppointment")
	public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment app) {
	    Appointment theApp= null;
	    try {
		theApp = service.addAppointment(app);
	    }
	    catch(Exception e) {
	       return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
	    }
	    logger.info("Appointment addAppointment()");
		return new ResponseEntity<Appointment>(theApp,HttpStatus.OK);
	}
	
	@PutMapping("/updateAppointment")
	public ResponseEntity<Appointment> updatePatient(@RequestBody Appointment app){
		Appointment theApp =null;
		try {
		       if(app == null) {
		    	   throw new PatientException("Invalid data");
		       }
		       
		       List<Appointment> list = service.getAllAppointments();
		       if(list.isEmpty()) {
		    	   throw new AppointmentException("no records found");
		       }
		       for(Appointment a : list) {
		    	   
		              if(a.getAppointmentId()==app.getAppointmentId()) {
		                 theApp = service.updateAppointment(app);
		              }
		       }
		       if(theApp== null) {
		    	   throw new AppointmentException("no records found");
		       }
		  }
		catch(Exception e) {
			return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
		}
		logger.info("Appointment UpdateAppointment()");
		       return new ResponseEntity<Appointment>(theApp,HttpStatus.OK);
	}
	  
    
    
	 @GetMapping("/getAllAppointments")
	    public ResponseEntity<List<Appointment>> getAppointments(){
	    	
	    	List<Appointment> appointments = null;
	    	try {
	    	appointments = service.getAllAppointments();
	    	if(appointments.isEmpty()) {
	    		throw new AppointmentException("No records found");
	    	}
	    	}
	    	catch(Exception e) {
	    		 return new ResponseEntity<List<Appointment>>(HttpStatus.NOT_FOUND);
	    	}
	    	return new ResponseEntity<List<Appointment>>(appointments,HttpStatus.OK);
	    }
	    
	
	
}
