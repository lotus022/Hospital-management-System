package com.cg.services;



import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.TestDao;
import com.cg.entities.Tests;
import java.util.List;;


@Service("/testService")
public class TestServiceImpl implements ITestService {
	
	@Autowired
	TestDao bDao;



	@Override
	public List<Tests> addTests(Tests test) {
		
		bDao.saveAndFlush(test);
		return bDao.findAll();
		
		
	}

	@Override
	public List<Tests> viewTests() {
		return bDao.findAll();
	}

	@Override
	public Tests editBeds(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tests> removeTests(int id) {
		// TODO Auto-generated method stub
		System.out.println("test Remove Successfully");
		bDao.deleteById(id);
		return bDao.findAll();
	}

	

	
}
