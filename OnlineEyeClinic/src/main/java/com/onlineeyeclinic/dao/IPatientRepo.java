package com.onlineeyeclinic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineeyeclinic.dto.Patient;

@Repository
public interface IPatientRepo extends JpaRepository<Patient,Integer> {

}
