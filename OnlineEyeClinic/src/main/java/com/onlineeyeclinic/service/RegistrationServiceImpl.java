package com.onlineeyeclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineeyeclinic.dto.Admin;
import com.onlineeyeclinic.dto.Doctor;
import com.onlineeyeclinic.dto.Patient;
import com.onlineeyeclinic.exceptions.UserNameAlreadyExistException;



@Service
public class RegistrationServiceImpl implements IRegistrationService {
	@Autowired
	private IPatientService patientService;
	
	@Autowired
	private IDoctorService doctorService;
	
	@Autowired
	private IAdminService adminService;

	@Override
	public Patient registerPatient(Patient patient)throws UserNameAlreadyExistException{
		// TODO Auto-generated method stub
		return patientService.addPatient(patient);
	}

	@Override
	public Doctor registerDoctor(Doctor doctor)throws UserNameAlreadyExistException {
		// TODO Auto-generated method stub
		return doctorService.addDoctor(doctor);
	}

	@Override
	public Admin registerAdmin(Admin admin)throws UserNameAlreadyExistException {
		// TODO Auto-generated method stub
		return adminService.addAdmin(admin);
	}
}