package com.cg.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.Medicinedao;
import com.cg.entity.Medicines;
import com.cg.exception.MedicineNotFoundException;


@Transactional
@Service
public class MedicalServiceImpl implements MedicalService{
	
	@Autowired
	private Medicinedao medicinedao;
	
	Logger logger = LoggerFactory.getLogger(MedicalServiceImpl.class);

	@Override
	public Medicines addMedicines(Medicines medicines) {
		// TODO Auto-generated method stub
		logger.info("Medicines addMedicines()");
		
		if(medicines == null)
			throw new MedicineNotFoundException("Medicine not Found");
		else {
			medicinedao.save(medicines);
			return medicines;
		}
	}

	@Override
	public Medicines getMedicineCost(int id) {
		// TODO Auto-generated method stub
		return medicinedao.findById(id).get();
	}

	@Override
	public Medicines updateMedicines(Medicines medicines) {
		// TODO Auto-generated method stub
		logger.info("Medicines updateMedicines()");
		if(medicines == null)
			throw new MedicineNotFoundException("Medicine Not Found");
		else {
			medicinedao.save(medicines);
			return medicines;
		}
	}

	@Override
	public Medicines removeMedicines(int id) {
		// TODO Auto-generated method stub

		logger.info("Medicines removeMedicines()");
		Optional<Medicines> medicines = medicinedao.findById(id);
		if(!medicines.isPresent())
			throw new MedicineNotFoundException("Medicine Not Found");
		else {
			medicinedao.deleteById(id);
			return medicines.get();
		}
	}

	@Override
	public List<Medicines> viewAllMedicines() {
		// TODO Auto-generated method stub
		logger.info("Medicines viewAllMedicines()");

		List<Medicines> list = medicinedao.findAll();
		if(list.isEmpty())
			throw new MedicineNotFoundException("Address Not Found");
		else
			return list;
			}

	@Override
	public Medicines viewMedicines(int id) {
		// TODO Auto-generated method stub

		logger.info("Medicines viewMedicines()");
		Optional<Medicines> viewMedicine = medicinedao.findById(id);
		if(!viewMedicine.isPresent())
			throw new MedicineNotFoundException("Address Not Found");
		else {
			return viewMedicine.get();
		}

	}
	
}