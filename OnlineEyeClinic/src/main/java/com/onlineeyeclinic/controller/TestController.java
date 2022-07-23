package com.onlineeyeclinic.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineeyeclinic.dto.TestModule;
import com.onlineeyeclinic.exceptions.TestIdNotFoundException;
import com.onlineeyeclinic.service.ITestService;

import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping("/v1")
public class TestController {

	@Autowired
	public ITestService tservice;

	@GetMapping("/alltests")
	public List<TestModule> viewAllTests(){
		return tservice.viewAllTests();
	}
	
	@PostMapping("/test/add")
	public TestModule add(@Valid @RequestBody TestModule testModule)  {
		return tservice.addTest(testModule);
	}


	@DeleteMapping("/test/remove/{testId}")
	public TestModule removeTest(@PathVariable int testId) throws TestIdNotFoundException  {
		return tservice.removeTest(testId);
	}
	@PutMapping("/update/{id}")
	public TestModule updateTest (@RequestBody TestModule testModule) {
		return tservice.updateTest(testModule);
	}


	@GetMapping("/test/viewtest/{testid}")  
	private TestModule viewTest(@PathVariable("testid") int testid) throws TestIdNotFoundException   
	{  
		return tservice.viewTest(testid);
	}
}
