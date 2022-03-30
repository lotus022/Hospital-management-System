package com.cg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Doctor;
import com.cg.exception.DoctorException;
import com.cg.service.IDoctorService;

@RestController
@RequestMapping("/booking")
public class DoctorController{
	
	@Autowired
	private IDoctorService doctorService;
	Logger logger = LoggerFactory.getLogger(DoctorController.class);
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping("/doctor/update")
	public ResponseEntity<Doctor> updateDoctor(
			@RequestBody Doctor doctor){
		Doctor doc = null;
		try {
		doc = doctorService.updateDoctorProfile(doctor);
		if(doc == null)
		{
			throw new DoctorException("Doctor not found.");
		}
		}catch(DoctorException qnfe) {
			return new ResponseEntity("Sorry! couldn't update!", 
					HttpStatus.NOT_FOUND);
		}
		logger.info("Doctor UpdateDoctor()");
		return new ResponseEntity<Doctor>(doc, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/doctor/add")
	public ResponseEntity<Doctor> insertDoctor(
			@RequestBody Doctor doctor){
		Doctor doc = doctorService.addDoctor(doctor);
		
		if(doc == null)
		{
			return new ResponseEntity("Sorry! couldn't update!", 
					HttpStatus.NOT_FOUND);
		}
		logger.info("Doctor addDoctor()");
		return new ResponseEntity<Doctor>(doc, HttpStatus.OK);
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/doctors")
	public ResponseEntity<List<Doctor>> getAllDoctors(){
		List<Doctor> doctors= doctorService.getDoctorList();
		if(doctors.isEmpty()) {
			return new ResponseEntity("Sorry! Products not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Doctor>>(doctors, HttpStatus.OK);
	}
}
