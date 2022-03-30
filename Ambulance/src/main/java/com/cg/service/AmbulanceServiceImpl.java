package com.cg.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.Ambulancedao;
import com.cg.entity.Ambulance;
import com.cg.exception.AmbulanceNotFoundException;
@Transactional
@Service
public class AmbulanceServiceImpl implements AmbulanceService {

	@Autowired
	private Ambulancedao ambulancedao;
	Logger logger = LoggerFactory.getLogger(AmbulanceServiceImpl.class);
	

	@Override
	public Ambulance addAmbulance(Ambulance ambulance) {
		// TODO Auto-generated method stub
		logger.info("Ambulance addAmbulance()");
		
		if(ambulance == null)
			throw new AmbulanceNotFoundException("Ambulance not Found");
		else {
			ambulancedao.save(ambulance);
			return ambulance;
		}
	}

	@Override
	public Ambulance updateAmbulance(Ambulance ambulance) {
		// TODO Auto-generated method stub
		logger.info("Ambulance updateAmbulance()");
		if(ambulance == null)
			throw new AmbulanceNotFoundException("Ambulance Not Found");
		else {
			ambulancedao.save(ambulance);
			return ambulance;
		}
	}
	@Override
	public Ambulance removeAmbulance(BigInteger id) {
		// TODO Auto-generated method stub

		logger.info("Ambulance removeAmbulance()");
		Optional<Ambulance> ambulance = ambulancedao.findById(id);
		if(!ambulance.isPresent())
			throw new AmbulanceNotFoundException("Ambulance Not Found");
		else {
			ambulancedao.deleteById(id);
			return ambulance.get();
		}
	}
    @Override
	public Ambulance getTravelCost(BigInteger id) {
		return ambulancedao.findById(id).get();
	}

	@Override
	public Ambulance bookAmbulance(BigInteger id) {
		logger.info("Ambulance bookAmbulance()");
      Optional<Ambulance> bookAmbulance = ambulancedao.findById(id);
      if(!bookAmbulance.isPresent())
			throw new AmbulanceNotFoundException("Address Not Found");
		else {
			return bookAmbulance.get();
		}

	}
	

		
	@Override
	public List<Ambulance> viewTravelHistory() {
		logger.info("Ambulance viewTravelHistory()");
        List<Ambulance> list = ambulancedao.findAll();
		if(list.isEmpty())
			throw new AmbulanceNotFoundException("Address Not Found");
		else
			return list;
			}

	@Override
	public List<Ambulance> findAll() {
		return ambulancedao.findAll();
	}

	
	
	}


