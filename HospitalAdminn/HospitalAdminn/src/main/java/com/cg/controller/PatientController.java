package com.cg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Patient;
import com.cg.exception.PatientException;
import com.cg.service.IPatientService;

@RestController
@RequestMapping("/api")
@CrossOrigin()
public class PatientController {
	IPatientService patientService;
	
	Logger logger = LoggerFactory.getLogger(PatientController.class);
	
	@Autowired
	public PatientController(IPatientService theService) {
		patientService = theService;
		
		
	}
	
	//adding the patient
	
	@PostMapping("/addPatient")
	public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
	   // patient.setPatientId(0);
	    Patient thePatient = null;
	    try {
		thePatient = patientService.addPatient(patient);
	    }
	    catch(Exception e) {
	       return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
	    }
	    
	    logger.info("Patient addPatient()");
		return new ResponseEntity<Patient>(thePatient,HttpStatus.OK);
	}

	//updating the patient
	
	
	@PutMapping("/updatePatient")
	public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient){
		Patient thePatient =null;
		try {
		       if(patient == null) {
		    	   throw new PatientException("Invalid data");
		       }
		       
		       List<Patient> list = patientService.getAllPatient();
		       if(list.isEmpty()) {
		    	   throw new PatientException("no records found");
		       }
		       for(Patient p : list) {
		    	   
		              if(p.getPatientId()==patient.getPatientId()) {
		                 thePatient = patientService.updatePatientDetails(patient);
		              }
		       }
		       if(thePatient == null) {
		    	   throw new PatientException("no records found");
		       }
		  }
		catch(Exception e) {
			return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
		}
		       logger.info("Patient updatePatient()");
		       return new ResponseEntity<Patient>(thePatient,HttpStatus.OK);
	}
		
	
    
    
    
    
}
