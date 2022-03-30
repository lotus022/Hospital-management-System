package com.cg.test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.dao.Medicinedao;
import com.cg.entity.Medicines;
import com.cg.service.MedicalService;
@SpringBootTest
public class MedicalServiceImplTest {
	
		@Autowired
		MedicalService medService;
		
		@MockBean
		Medicinedao medDao;
		
		@Test
		public void testAddMedicine() {
			Medicines medicines = new Medicines();
			medicines.setId(12);
			medicines.setBookedStatus("Done");
			medicines.setCost(300);
			medicines.setMedicineName("Paracetmol");
			
						
			Mockito.when(medDao.save(medicines)).thenReturn(medicines);
			assertThat(medService.addMedicines(medicines)).isEqualTo(medicines);
		}
		@Test
		public void testremoveMedicine() {
			Medicines medicines = new Medicines();
			medicines.setId(11);
			medicines.setBookedStatus("Done");
			medicines.setCost(200);
			medicines.setMedicineName("losar");
			
						
			Mockito.when(medDao.findById(1)).thenReturn(Optional.of(medicines));
			Mockito.when(medDao.existsById(medicines.getId())).thenReturn(false);
			assertFalse(medDao.existsById(medicines.getId()));
		}
		@Test
		public void testupdateMedicine() {
			Medicines medicines = new Medicines();
			medicines.setId(6);
			medicines.setBookedStatus("Done");
			medicines.setCost(100);
			medicines.setMedicineName("crocin");
			
						
			Mockito.when(medDao.findById(medicines.getId())).thenReturn(Optional.of(medicines));
			medicines.setMedicineName("metmorphin");
			Mockito.when(medDao.save(medicines)).thenReturn(medicines);
			assertThat(medService.updateMedicines(medicines)).isEqualTo(medicines);
		}
		
}
