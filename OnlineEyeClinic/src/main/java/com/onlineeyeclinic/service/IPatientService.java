package com.onlineeyeclinic.service;

import java.util.List;

import com.onlineeyeclinic.dto.Patient;

public interface IPatientService {

	public List<Patient> viewAllPatients();

	public Patient addPatient(Patient patient);

}
