package com.onlineeyeclinic.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.onlineeyeclinic.dao.IAppointmentRepo;
import com.onlineeyeclinic.dto.Appointment;
import com.onlineeyeclinic.exceptions.AppointmentIdNotFoundException;

@Service
public class AppointmentServiceImpl implements IAppointmentService{

	@Autowired
	private IAppointmentRepo appointRepo;

	@Override
	public List<Appointment> viewAllAppointments() {

		return appointRepo.findAll();
	}

	@Override
	public Appointment bookAppointment(Appointment appoint) {

		return appointRepo.saveAndFlush(appoint);
		
	}


	@Override
	public Appointment cancelAppointment(int appointmentId)throws AppointmentIdNotFoundException {

		Supplier<AppointmentIdNotFoundException> supplier=()-> new AppointmentIdNotFoundException("No appointment is available with the given id");
	     Optional<Appointment> appoint=Optional.ofNullable(appointRepo.findById(appointmentId).orElseThrow(supplier));
	     appointRepo.deleteById(appointmentId);
	     return appoint.get();
	}

	@Override
	public Appointment viewAppointment(int appointmentId)throws AppointmentIdNotFoundException {

		Supplier<AppointmentIdNotFoundException> supplier=()-> new AppointmentIdNotFoundException("No appointment is available with the given id");
		Optional<Appointment> appoint=Optional.ofNullable(appointRepo.findById(appointmentId).orElseThrow(supplier));
		return appoint.get();
	}
	
	@Override
	public List<Appointment> viewAppointments(Date date) {

	return appointRepo.getByDate(date);
	}

	
	@Override
	public Appointment updateAppointment(Appointment appointment) {

		return appointRepo.saveAndFlush(appointment);
	}

	@Override
	public List<Appointment> viewAppointments(LocalDate date) {

		return null;
	}
}
