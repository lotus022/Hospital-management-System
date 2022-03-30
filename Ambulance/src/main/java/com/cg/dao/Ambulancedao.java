package com.cg.dao;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Ambulance;

@Repository("ambulancedao")
public interface Ambulancedao extends JpaRepository<Ambulance, BigInteger> {



	
	
	

}
