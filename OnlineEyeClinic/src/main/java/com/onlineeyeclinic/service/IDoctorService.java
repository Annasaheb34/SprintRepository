package com.onlineeyeclinic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlineeyeclinic.dto.Appointment;
import com.onlineeyeclinic.dto.Doctor;
import com.onlineeyeclinic.exceptions.DoctorIdNotFoundException;
import com.onlineeyeclinic.exceptions.UserNameAlreadyExistException;



@Service
public interface IDoctorService {
	//getting list of doctors
	public List<Doctor> viewAllDoctors();
	//adding a doctor
	public Doctor addDoctor(Doctor doctor)throws UserNameAlreadyExistException;
	//updating doctor
	public Doctor updateDoctor(Doctor doctor);
	//deleting a doctor
	public Doctor deleteDoctor(int doctorId)throws DoctorIdNotFoundException;
	//viewing a doctor by individual id
	public Doctor viewDoctor(int doctorId)throws DoctorIdNotFoundException;
	//view all appointments by doctor
	public List<Appointment> viewAllAppointmentsByDoctorId(int doctorId)throws DoctorIdNotFoundException;
	public void createTest(Doctor doctor);
}
