package com.cg.service;

import java.math.BigInteger;
import java.util.List;

import com.cg.entity.Ambulance;

public interface AmbulanceService {
	public Ambulance addAmbulance(Ambulance ambulance);
    public Ambulance updateAmbulance(Ambulance ambulance);
    public Ambulance removeAmbulance(BigInteger id);
    
	public Ambulance getTravelCost(BigInteger id);
    
	public Ambulance bookAmbulance(BigInteger id);

	public List<Ambulance> viewTravelHistory();

	public List<Ambulance> findAll();
	
	
}