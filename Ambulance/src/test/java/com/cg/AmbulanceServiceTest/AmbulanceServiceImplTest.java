package com.cg.AmbulanceServiceTest;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.dao.Ambulancedao;
import com.cg.entity.Ambulance;
import com.cg.service.AmbulanceService;
@SpringBootTest
public class AmbulanceServiceImplTest {
	

		
		@Autowired
		AmbulanceService ambulanceService;
		
		@MockBean
		Ambulancedao ambulanceDao;
		
		@Test
		public void testAddAmbulance() {
			Ambulance ambulance = new Ambulance();
			ambulance.setId(null);
			ambulance.setAmbulanceLoaction("gandhi nagar");
			ambulance.setBookedStatus("Booked");
			ambulance.setCost(300);
			ambulance.setAmbulanceName("Apollo");
			
						
			Mockito.when(ambulanceDao.save(ambulance)).thenReturn(ambulance);
			assertThat(ambulanceService.addAmbulance(ambulance)).isEqualTo(ambulance);
		}

}

