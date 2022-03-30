package com.cg.service;

import java.util.List;

import com.cg.entity.Patient;
import com.cg.exception.PatientException;

public interface IPatientService {
	
	Patient addPatient(Patient bean) throws PatientException;
	Patient updatePatientDetails(Patient bean) throws PatientException;
	
	List<Patient> getAllPatient() throws PatientException;
	
}

