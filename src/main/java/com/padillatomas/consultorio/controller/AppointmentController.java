package com.padillatomas.consultorio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.padillatomas.consultorio.dto.AppointmentDTO;
import com.padillatomas.consultorio.service.AppointmentService;

@RestController
@RequestMapping("appointments")
public class AppointmentController {
	
	// Services:
	@Autowired
	private AppointmentService appoServ;
	
	// == POST ==
	@PostMapping("/create")
	public ResponseEntity<AppointmentDTO> createNewAppointment(@RequestBody AppointmentDTO newAppo){
		AppointmentDTO createdAppo = appoServ.saveNewAppointment(newAppo);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdAppo);
	}
	// == GET ==
	// == PUT ==
	// == DELETE ==

}
