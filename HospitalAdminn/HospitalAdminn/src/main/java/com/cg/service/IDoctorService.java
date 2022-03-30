package com.cg.service;

import java.util.List;

import com.cg.entity.Doctor;

public interface IDoctorService {
	
	public Doctor addDoctor(Doctor bean);
	public Doctor updateDoctorProfile(Doctor bean);	
	
	public List<Doctor> getDoctorList();
	
}
