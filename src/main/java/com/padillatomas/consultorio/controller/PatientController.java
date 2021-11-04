package com.padillatomas.consultorio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.padillatomas.consultorio.dto.patient.PatientCompleteDTO;
import com.padillatomas.consultorio.service.PatientService;

@RestController
@RequestMapping("patients")
public class PatientController {

	// Services:
	@Autowired
	private PatientService patientServ;
	
	// == POST ==
	@PostMapping("/create")
	public ResponseEntity<PatientCompleteDTO> createNewPatient(@RequestBody PatientCompleteDTO newPatient){
		PatientCompleteDTO createdPatient = patientServ.saveNewPatient(newPatient);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdPatient);
	}
	
	// == GET ==
	// == PUT ==
	// == DELETE ==
	
	
}
