package com.padillatomas.consultorio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.padillatomas.consultorio.dto.WorkScheduleDTO;
import com.padillatomas.consultorio.service.WorkScheduleService;

@RestController
@RequestMapping("/work-schedule")
public class WorkScheduleController {

	// Services
	@Autowired
	private WorkScheduleService workScheduleServ;
	
	// == POST ==
	@PostMapping("/create")
	public ResponseEntity<WorkScheduleDTO> createNewWorkSchedule(@RequestBody WorkScheduleDTO newWS){
		WorkScheduleDTO savedWS = workScheduleServ.saveNewWS(newWS);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedWS);
	}
	// == GET ==
	// == PUT ==
	// == DELETE ==
}
