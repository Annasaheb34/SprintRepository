package com.onlineeyeclinic.controller;

import java.util.List;

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

import com.onlineeyeclinic.dto.Appointment;
import com.onlineeyeclinic.dto.TestModule;
import com.onlineeyeclinic.exceptions.DoctorIdNotFoundException;
import com.onlineeyeclinic.exceptions.TestIdNotFoundException;
import com.onlineeyeclinic.service.ITestService;

@RestController
@RequestMapping("test/api/v1")
public class TestController {

	@Autowired
	private ITestService ts;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/tests")
	public ResponseEntity<List<TestModule>> getAllTests(){
		List<TestModule> testModule= ts.viewAllTests();
		if(testModule.isEmpty()) {
			return new ResponseEntity("Sorry! tests not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<TestModule>>(testModule, HttpStatus.OK);
	}
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/tests")
	public ResponseEntity<TestModule> InsertTest(@RequestBody TestModule testModules){
		TestModule testModule= ts.addTest(testModules);
		if(testModule==null) {
			return new ResponseEntity("Sorry! tests not inserted!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<TestModule>(testModule, HttpStatus.OK);
	}
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @DeleteMapping("/tests/{testId}")
	public ResponseEntity<TestModule> deleteTest(
			@PathVariable("testId")Integer testId)throws TestIdNotFoundException{
		TestModule testModules= ts.removeTest(testId);
		if(testModules==null) {
			return new ResponseEntity("Sorry! tests not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<TestModule>(testModules, HttpStatus.OK);
	}
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @GetMapping("/tests/{testId}")
	public ResponseEntity<TestModule> findTest(
			@PathVariable("testId")Integer testId)throws TestIdNotFoundException{
		TestModule testModule= ts.viewTest(testId);
		if(testModule==null) {
			return new ResponseEntity("Sorry! tests not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<TestModule>(testModule, HttpStatus.OK);
	}
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @PutMapping("/tests")
	public ResponseEntity<TestModule> updateTest(
			 @RequestBody TestModule testModule){
		TestModule testModules= ts.updateTest(testModule);
		if(testModules==null)
		{
			return new ResponseEntity("Sorry! test not updated!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<TestModule>(testModules, HttpStatus.OK);
	}
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getTests/{doctorId}")
	public ResponseEntity<List<TestModule>> viewTests(@PathVariable("doctorId")Integer doctorId)throws DoctorIdNotFoundException{
		List<TestModule> doc=ts.viewTestsByDoctor(doctorId);
		if(doc.isEmpty()) {
			return new ResponseEntity("Sorry! tests not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<TestModule>>(doc, HttpStatus.OK);
	}
    
}
