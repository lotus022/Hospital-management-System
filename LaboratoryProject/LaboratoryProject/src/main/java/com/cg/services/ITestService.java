package com.cg.services;

import java.util.List;

import com.cg.entities.Tests;




public interface ITestService {
	
	public List<Tests> addTests(Tests bed);
	public List<Tests> viewTests();
	public Tests editBeds(int id);
	public List<Tests> removeTests(int id);
}
