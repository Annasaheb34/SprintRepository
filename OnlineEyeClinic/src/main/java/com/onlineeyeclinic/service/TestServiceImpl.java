package com.onlineeyeclinic.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineeyeclinic.dao.ITestRepo;
import com.onlineeyeclinic.dto.TestModule;
import com.onlineeyeclinic.exceptions.DoctorIdNotFoundException;
import com.onlineeyeclinic.exceptions.TestIdNotFoundException;
@Service
public class TestServiceImpl implements ITestService{
	@Autowired
private ITestRepo testRepo;

	@Override
	public TestModule addTest(TestModule testModule) {
		// TODO Auto-generated method stub
		return testRepo.saveAndFlush(testModule);
	}

	@Override
	public TestModule updateTest(TestModule testModule) {
		// TODO Auto-generated method stub
		return testRepo.saveAndFlush(testModule);
	}

	@Override
	public TestModule removeTest(int testId)throws TestIdNotFoundException {
		// TODO Auto-generated method stub
		Supplier<TestIdNotFoundException> supplier=()->new TestIdNotFoundException("test with given id is not available");
		Optional<TestModule> t=Optional.ofNullable(testRepo.findById(testId).orElseThrow(supplier));
		testRepo.deleteById(testId);
		return t.get();
	}

	@Override
	public TestModule viewTest(int testId) throws TestIdNotFoundException{
		// TODO Auto-generated method stub
		Supplier<TestIdNotFoundException> supplier=()->new TestIdNotFoundException("test with given id is not available");
		Optional<TestModule> t=Optional.ofNullable(testRepo.findById(testId).orElseThrow(supplier));
		return t.get();
	}

	@Override
	public List<TestModule> viewAllTests() {
		// TODO Auto-generated method stub
		return testRepo.findAll();
	}

	@Override
	public List<TestModule> viewTestsByDoctor(int doctorId) throws DoctorIdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


	
}
