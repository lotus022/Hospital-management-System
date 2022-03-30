package com.cg.test.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.dao.PatientRepository;
import com.cg.entity.Patient;
import com.cg.service.IPatientService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PatientServiceImplTest {
	
	
	@Autowired
	private IPatientService patientService;
	
	@MockBean
	private PatientRepository patientRepository;
	
	
	
	@Test
	public void testAddPatient() {
		Patient patient = new Patient();
		patient.setPatientId(1);
		patient.setPatientName("varu");
		patient.setGender("male");
		patient.setEmail("varu@gmail.com");
		patient.setPassword("yrwdvhf");
		patient.setMobileNo("9876543210");
		patient.setBloodGroup("o+");
		patient.setAge(23);
		patient.setAddress("chennai");
		
		Mockito.when(patientRepository.save(patient)).thenReturn(patient);
		assertThat(patientService.addPatient(patient)).isEqualTo(patient);
	}
	
	
	@Test
	public void testUpdatePatient() {
		Patient patient = new Patient();
		patient.setPatientId(1);
		patient.setPatientName("varu");
		patient.setGender("male");
		patient.setEmail("varu@gmail.com");
		patient.setPassword("yrwdvhf");
		patient.setMobileNo("9876543210");
		patient.setBloodGroup("o+");
		patient.setAge(23);
		patient.setAddress("chennai");
		
		Mockito.when(patientRepository.save(patient)).thenReturn(patient);
		
		patient = patientService.addPatient(patient);
		//updating 
		
		patient.setPatientName("varu100");
		patient.setAge(28);
		Mockito.when(patientRepository.saveAndFlush(patient)).thenReturn(patient);
		assertThat(patientService.updatePatientDetails(patient)).isEqualTo(patient);
		
	}
	
	  
	  
	

}

