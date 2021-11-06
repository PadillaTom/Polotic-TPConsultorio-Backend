package com.padillatomas.consultorio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.padillatomas.consultorio.dto.WorkScheduleDTO;
import com.padillatomas.consultorio.service.WorkScheduleService;

@RestController
@RequestMapping("/schedule")
public class WorkScheduleController {

	// Services
	@Autowired
	private WorkScheduleService wsServ;
	
	// == POST ==
	@PostMapping("/create/{dentistId}")
	public ResponseEntity<WorkScheduleDTO> createNewWorkSchedule(@PathVariable Long dentistId, @RequestBody WorkScheduleDTO newWS){
		WorkScheduleDTO savedWS = wsServ.saveNewWS(dentistId, newWS);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedWS);
	}
	
	// == GET ==	
	
	// == PUT ==
	@PutMapping("/edit/{id}")
	public ResponseEntity<WorkScheduleDTO> editResponsable(
				@PathVariable Long id,
				@RequestBody WorkScheduleDTO newData
			) {
		WorkScheduleDTO editedSchedule = wsServ.editById(id, newData);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(editedSchedule);
	}
	
	// == DELETE ==
	@DeleteMapping("{scheduleId}/remove-from/{dentistId}")
	public ResponseEntity<Void> softDeleteSchedule(@PathVariable Long scheduleId, @PathVariable Long dentistId){
		wsServ.softDeleteById(scheduleId, dentistId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
