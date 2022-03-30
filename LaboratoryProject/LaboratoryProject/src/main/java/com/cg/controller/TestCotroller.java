package com.cg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.expression.EnvironmentAccessor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.entities.Tests;
import com.cg.services.ITestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


//@Api("An API for Employee CRUD Operation")
@RestController
@RequestMapping("/Laboratory-test")
public class TestCotroller {

	private static final Logger logger = LoggerFactory.getLogger(TestCotroller.class);

	private static final String LOCAL_SERVER_PORT = "local.server.port";
	RestTemplate restTemplate;
	@Autowired
	ITestService testservice;

	@Autowired
	private Environment environment;

	
	

	@PostMapping("/addTest")
	public List<Tests> addTests(Tests test) {
		// TODO Auto-generated method stub
		return testservice.addTests(test);
		
	}


	@GetMapping("/findAll")
	public List<Tests> viewTests() {
		return testservice.viewTests();
	}


	public Tests editTests(int id) {

		return null;
	}

	@DeleteMapping("remove/{eid}")
	public List<Tests> removeTests(@PathVariable int testserviceid) {
	
		System.out.println("Test Remove Successfully");
		return testservice.removeTests(testserviceid);
	}
	
	


}



