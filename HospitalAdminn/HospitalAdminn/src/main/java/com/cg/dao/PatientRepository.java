package com.cg.dao;

import java.time.LocalDate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
	

	@Query("Select p from Appointment a Join a.patient p Join a.doctor d Where d.doctorId= :doc")
	List<Patient> getPatientListByDoctor(@Param("doc") int docid);
	
	@Query("Select p From Appointment a Join a.patient p where a.appointmentDate = :date")
	List<Patient> getPatientListByDate(@Param("date") LocalDate appdate);

}

