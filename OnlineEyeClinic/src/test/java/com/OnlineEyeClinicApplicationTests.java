package com;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlineeyeclinic.dao.IPatientRepo;
import com.onlineeyeclinic.dao.ITestRepo;


@SpringBootTest
class OnlineEyeClinicApplicationTests {

	@Autowired
	 IPatientRepo repo;
		@Test
	public	void patientId() {
			int id=1;
			assertNotNull(repo.findById(id).get());
		}
		@Test
		public void patientGet() {
			assertNotNull(repo.findAll());
		}
		@Autowired
		 ITestRepo repotest;
			@Test
		public	void testId() {
				int id=1;
				assertNotNull(repotest.findById(id).get());
			}
			@Test
			public void testGet() {
				assertNotNull(repotest.findAll());
			}
			
}

