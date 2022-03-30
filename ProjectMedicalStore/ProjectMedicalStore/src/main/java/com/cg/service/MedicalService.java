package com.cg.service;

import java.util.List;

import com.cg.entity.Medicines;

public interface MedicalService {
	public Medicines addMedicines(Medicines medicines);
	public Medicines updateMedicines(Medicines medicines);
	public Medicines removeMedicines(int id);
	public List<Medicines> viewAllMedicines();
	public Medicines viewMedicines(int id);
	public Medicines getMedicineCost(int id);

}
