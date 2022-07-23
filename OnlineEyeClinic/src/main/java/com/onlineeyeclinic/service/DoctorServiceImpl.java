package com.onlineeyeclinic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineeyeclinic.dao.IAppointmentRepo;
import com.onlineeyeclinic.dao.IDoctorRepo;
import com.onlineeyeclinic.dao.ITestRepo;
import com.onlineeyeclinic.dto.Appointment;
import com.onlineeyeclinic.dto.Doctor;
import com.onlineeyeclinic.dto.TestModule;
import com.onlineeyeclinic.exceptions.DoctorIdNotFoundException;
import com.onlineeyeclinic.exceptions.UserNameAlreadyExistException;



@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private IDoctorRepo doctorRepo;
	
	@Autowired
	private IAppointmentRepo appointRepo;
	
	@Autowired
	private ITestRepo testRepo;

	@Override
	public List<Doctor> viewAllDoctors() {
		// TODO Auto-generated method stub
		return doctorRepo.findAll();
	}

	@Override
	public Doctor addDoctor(Doctor doctor)throws UserNameAlreadyExistException {
		// TODO Auto-generated method stub
		List<Doctor> doctors=this.viewAllDoctors();
		for(Doctor dc:doctors)
		{
			if(dc.getDoctorUserName().equals(doctor.getDoctorUserName()))
			{
				throw new UserNameAlreadyExistException("provided username is already taken...Please modify your username !");
			}
		}
	 return doctorRepo.saveAndFlush(doctor);
	}


	@Override
	public Doctor updateDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorRepo.saveAndFlush(doctor);
	}

	@Override
	public Doctor deleteDoctor(int doctorId)throws DoctorIdNotFoundException {
		// TODO Auto-generated method stub
		Supplier<DoctorIdNotFoundException> supplier=()-> new DoctorIdNotFoundException("No doctor is available with the given id");
		Optional<Doctor> doctor= Optional.ofNullable(doctorRepo.findById(doctorId).orElseThrow(supplier));
		doctorRepo.deleteById(doctorId);
		return doctor.get();
	}

	@Override
	public Doctor viewDoctor(int doctorId)throws DoctorIdNotFoundException {
		// TODO Auto-generated method stub
		Supplier<DoctorIdNotFoundException> supplier=()-> new DoctorIdNotFoundException("No doctor is available with the given id");
		Optional<Doctor> doctor= Optional.ofNullable(doctorRepo.findById(doctorId).orElseThrow(supplier));
		return doctor.get();
	}

	@Override
	public List<Appointment> viewAllAppointmentsByDoctorId(int doctorId)throws DoctorIdNotFoundException  {
		// TODO Auto-generated method stub
		
		return appointRepo.findAllAppointmentByDoctorId(doctorId);
	}

	@Override
	public void createTest(Doctor doctor) {
		// TODO Auto-generated method stub
		List<TestModule> t=new ArrayList<>();
	    doctor.setTest(t);
		
	}

	
	
}
