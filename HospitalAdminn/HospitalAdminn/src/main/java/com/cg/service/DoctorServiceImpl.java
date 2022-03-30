package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.DoctorRepository;
import com.cg.entity.Doctor;
@Service
public class DoctorServiceImpl implements IDoctorService {

	
	@Autowired
	private DoctorRepository doctorDaoJpa ;
	
	public DoctorServiceImpl() {
	}

	@Override
	public Doctor addDoctor(Doctor bean) {
		
		return doctorDaoJpa.save(bean) ;
	}

	@Override
	public Doctor updateDoctorProfile(Doctor bean) {
		
		return doctorDaoJpa.saveAndFlush(bean);
	}
	
	@Override
	public List<Doctor> getDoctorList() {
		
		return doctorDaoJpa.findAll();
	}


}

