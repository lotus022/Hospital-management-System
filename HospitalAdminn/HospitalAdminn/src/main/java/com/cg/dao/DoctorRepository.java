package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

	
}
