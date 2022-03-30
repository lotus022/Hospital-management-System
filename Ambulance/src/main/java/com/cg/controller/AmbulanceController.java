package com.cg.controller;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Ambulance;
import com.cg.service.AmbulanceService;

@RestController
@RequestMapping("/ambulance")
public class AmbulanceController {

	@Autowired
	private AmbulanceService ambulanceService;
 
	Logger logger = LoggerFactory.getLogger(AmbulanceController.class);
	

	@PostMapping("/addambulance")
	public Ambulance addAmbulance(@RequestBody Ambulance ambulance)
	{
		logger.info("Ambulance addAmbulance()");
		return ambulanceService.addAmbulance(ambulance);
	}



	@GetMapping("/travelhistory")
	public ResponseEntity<List<Ambulance>> getAmbulance() {
		try {
			return new ResponseEntity<>(ambulanceService.viewTravelHistory(), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/costofAmbulance/{id}")
	public ResponseEntity<Ambulance> getCostofAmbulanceById(@PathVariable("id") BigInteger id) {
		try {
			return new ResponseEntity<>(ambulanceService.getTravelCost(id), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/updateambulances")
	public Ambulance updateAmbulance(@RequestBody Ambulance ambulance)
	{
		logger.info("Ambulance updateAmbulance()");
		return ambulanceService.updateAmbulance(ambulance);
	}


	@DeleteMapping("/deleteambulance/{id}")
	public Ambulance removeAmbulance(@PathVariable("id")BigInteger id)
	{
		logger.info("Ambulance removeAmbulance()");
		return ambulanceService.removeAmbulance(id);
	}

	@GetMapping("/viewAllAmbulances")
	public ResponseEntity<List<Ambulance>> viewAllAmbulances() {
		try {
			return new ResponseEntity<>(ambulanceService.findAll(), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/bookambulance/{id}")
	public ResponseEntity<Ambulance> bookAmbulance(@PathVariable("id") BigInteger id) {
		try {
			return new ResponseEntity<>(ambulanceService.bookAmbulance(id), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
