package com.onlineeyeclinic.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.onlineeyeclinic.dto.Appointment;
import com.onlineeyeclinic.dto.Patient;
import com.onlineeyeclinic.dto.Report;
import com.onlineeyeclinic.exceptions.PatientIdNotFoundException;
import com.onlineeyeclinic.exceptions.UserNameAlreadyExistException;

@Service
public interface IPatientService{
	//view all patients
	public List<Patient> viewAllPatients();
	// add patient
	public Patient addPatient(Patient patient)throws UserNameAlreadyExistException;
	//book appointment
	public Patient bookAppointmnet(Patient patient);
	//delete appointment
	public Patient deletePatient(int patientId)throws PatientIdNotFoundException;
	//updating patient
	public Patient updatePatient(Patient patient);
	//viewing patient by individual id
	public Patient viewPatient(int patientId)throws PatientIdNotFoundException;
	//viewing appointment by patient
	public List<Appointment> viewAppointmentsByPatient(int patientId)throws PatientIdNotFoundException;
	//viewing report by patient
	public List<Report> viewReportsByPatient(int patientId)throws PatientIdNotFoundException;

}
