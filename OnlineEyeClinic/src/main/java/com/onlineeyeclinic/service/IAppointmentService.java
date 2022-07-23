package com.onlineeyeclinic.service;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.onlineeyeclinic.dto.Appointment;
import com.onlineeyeclinic.exceptions.AppointmentIdNotFoundException;

@Service
public interface IAppointmentService {
	
	public List<Appointment> viewAllAppointments();
	public Appointment bookAppointment(Appointment appoint);
	public Appointment cancelAppointment(int AppointmentId)throws AppointmentIdNotFoundException;
	public Appointment viewAppointment(int appointmentId)throws AppointmentIdNotFoundException;
	public List<Appointment> viewAppointments(Date date);
	public Appointment updateAppointment(Appointment appointment);
	public List<Appointment> viewAppointments(LocalDate date);
}
