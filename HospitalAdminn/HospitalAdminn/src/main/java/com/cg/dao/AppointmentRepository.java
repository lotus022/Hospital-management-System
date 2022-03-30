package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {

}
