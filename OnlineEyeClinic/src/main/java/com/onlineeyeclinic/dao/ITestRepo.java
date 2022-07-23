package com.onlineeyeclinic.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlineeyeclinic.dto.TestModule;

@Repository
public interface ITestRepo extends JpaRepository<TestModule, Integer> {
	@Query("from TestModule where doctor.doctorId=?1")
public List<TestModule> getTestsByDoctor(int doctorId);
}
