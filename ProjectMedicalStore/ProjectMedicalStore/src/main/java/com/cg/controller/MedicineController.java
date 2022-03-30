package com.cg.controller;


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

import com.cg.entity.Medicines;
import com.cg.service.MedicalService;

@RestController
@RequestMapping("/medicines")
public class MedicineController {
	
	@Autowired
	private MedicalService medService;
	

	Logger logger = LoggerFactory.getLogger(MedicineController.class);
	

	@PostMapping("/addmedicines")
	public Medicines addMedicines(@RequestBody Medicines medicines)
	{
		logger.info("Medicines addMedicines()");
		return medService.addMedicines(medicines);
	}

	@GetMapping("/costofMedicine/{id}")
	public ResponseEntity<Medicines> getCostofMedicineById(@PathVariable("id") int id) {
		try {
				return new ResponseEntity<>(medService.getMedicineCost(id), HttpStatus.OK);
		} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	@PutMapping("/updatemedicines")
	public Medicines updateMedicines(@RequestBody Medicines medicines)
	{
		logger.info("Medicines updateMedicines()");
		return medService.updateMedicines(medicines);
	}
	
	@DeleteMapping("/deletemedicines/{id}")
	public Medicines removeMedicines(@PathVariable("id")int id)
	{
		logger.info("Medicines removeMedicines()");
		return medService.removeMedicines(id);
	}
	@GetMapping("/viewmedicines/{id}")
	public Medicines viewMedicines(@PathVariable("id")int id)
	{
		logger.info("Medicines viewMedicines()");
		return medService.viewMedicines(id);
	}

	
		
}
