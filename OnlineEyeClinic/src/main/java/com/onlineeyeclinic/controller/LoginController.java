
package com.onlineeyeclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineeyeclinic.dto.Admin;
import com.onlineeyeclinic.dto.Doctor;
import com.onlineeyeclinic.dto.Patient;
import com.onlineeyeclinic.service.ILoginService;



@RestController
@RequestMapping("login/api/v1")
public class LoginController {
	@Autowired
private ILoginService ls;
	@GetMapping("/admin")
	public ResponseEntity<String> adminLogin(@RequestBody Admin admin)
	{
		return new ResponseEntity<String>(ls.adminLogin(admin.getAdminUserName(),admin.getAdminPassword()),HttpStatus.OK);
	}
	@GetMapping("/doctor")
	public ResponseEntity<String> doctorLogin(@RequestBody  Doctor doctor)
	{
		return new ResponseEntity<String>(ls.doctorLogin(doctor.getDoctorUserName(),doctor.getDoctorPassword()),HttpStatus.OK);
	}
	@GetMapping("/patient")
	public ResponseEntity<String> patientLogin(@RequestBody Patient patient)
	{
		return new ResponseEntity<String>(ls.patientLogin(patient.getPatientUserName(),patient.getPatientPassword()),HttpStatus.OK);
	}
}
