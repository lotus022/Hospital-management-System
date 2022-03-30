package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.dao.PatientRepository;
import com.cg.entity.Patient;
import com.cg.exception.PatientException;

@Service
public class PatientServiceImpl implements IPatientService {

	PatientRepository dao;
	
    //dependency injection
	@Autowired
    public PatientServiceImpl(PatientRepository theDao) {
    	dao=theDao;
    }
	
	//adding the patient
	
	@Override
	public Patient addPatient(Patient bean) throws PatientException{
		Patient patient = dao.save(bean);
	    return patient;
	}
    
	
	//updating the patient
	
	@Override
	public Patient updatePatientDetails(Patient bean) throws PatientException{
	    Patient patient = dao.saveAndFlush(bean);
	    return patient;
	}

	@Override
	public List<Patient> getAllPatient() throws PatientException{
	    List<Patient> patients = dao.findAll();
	    return patients;
	}
	
	
}




