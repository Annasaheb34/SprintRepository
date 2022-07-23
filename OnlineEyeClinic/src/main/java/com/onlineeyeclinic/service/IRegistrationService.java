package com.onlineeyeclinic.service;

import org.springframework.stereotype.Service;

import com.onlineeyeclinic.dto.Admin;
import com.onlineeyeclinic.dto.Doctor;
import com.onlineeyeclinic.dto.Patient;
import com.onlineeyeclinic.exceptions.UserNameAlreadyExistException;


@Service
public interface IRegistrationService {
	//patient registration
	public Patient registerPatient(Patient patient)throws UserNameAlreadyExistException; 
    //doctor registration
	public Doctor registerDoctor(Doctor doctor)throws UserNameAlreadyExistException; 
    //admin registration
	public Admin registerAdmin(Admin admin) throws UserNameAlreadyExistException; 
}
