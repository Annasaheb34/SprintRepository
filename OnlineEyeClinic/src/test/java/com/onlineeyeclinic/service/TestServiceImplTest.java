package com.onlineeyeclinic.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.onlineeyeclinic.dao.ITestRepo;
import com.onlineeyeclinic.dto.Doctor;
import com.onlineeyeclinic.dto.TestModule;
import com.onlineeyeclinic.exceptions.TestIdNotFoundException;


@SpringBootTest
class TestServiceImplTest {
	@Autowired
	ITestService tservice;

	@MockBean
	ITestRepo repository;

	@Test
	void viewTestById() throws TestIdNotFoundException{
		{
			TestModule a1=new TestModule();
			a1.setTestId(102);
			a1.setTestName("Refraction");
			a1.setTestDescriprion("Abc");
			a1.setTest_type("Gyama");
			a1.setTestCost(150);
			Doctor d1=new Doctor();
			d1.setDoctorId(1);
			Optional<TestModule> a2=Optional.of(a1);

			Mockito.when(repository.findById(9)).thenReturn(a2);

			assertThat(tservice.viewTest(9)).isEqualTo(a1);
		}
	}

	        @Test
	        void removeTest() {
		    TestModule c1=new TestModule();
		    Doctor d3 = new Doctor();
		    c1.setTestId(120);
		    c1.setTestName("Retinoscopy");
		    c1.setTestDescriprion("Abc");
		    c1.setTest_type("X-Ray");
		    c1.setTestCost(290.50);

		    d3.setDoctorId(2);

		    Optional<TestModule> c2=Optional.of(c1);

		    Mockito.when(repository.findById(120)).thenReturn(c2);
		    Mockito.when(repository.existsById(c1.getTestId())).thenReturn(false);
		    assertFalse(repository.existsById(c1.getTestId()));
	}
}