package com.padillatomas.consultorio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.padillatomas.consultorio.dto.patient.PatientBasicDTO;
import com.padillatomas.consultorio.dto.patient.PatientCompleteDTO;
import com.padillatomas.consultorio.service.PatientService;

@RestController
@RequestMapping("patients")
public class PatientController {
	
	
	// Services
	// == POST ==
	// == GET ==
	// == PUT ==
	// == DELETE ==

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
	@GetMapping("/all")
	public ResponseEntity<List<PatientBasicDTO>> getAllBasicPatients(){
		List<PatientBasicDTO> basicList = patientServ.getBasicPatients();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(basicList);
	}
	
	@GetMapping("/details/{id}")
	public ResponseEntity<PatientCompleteDTO> getDetailedPatient(@PathVariable Long id){
		PatientCompleteDTO myPatient = patientServ.getDetailsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(myPatient);
	}
	
	// == PUT ==
	@PutMapping("/edit/{id}")
	public ResponseEntity<PatientCompleteDTO> editPatient(
			@PathVariable Long id,
			@RequestBody PatientCompleteDTO newData 
			){
		PatientCompleteDTO editedPatient = patientServ.editById(id, newData);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(editedPatient);
	}
	
	// == DELETE ==
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> softDeletePatient(@PathVariable Long id){
		patientServ.softDeleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	
	
	
}
