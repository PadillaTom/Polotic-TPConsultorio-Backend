package com.padillatomas.consultorio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.padillatomas.consultorio.dto.dentist.DentistBasicDTO;
import com.padillatomas.consultorio.dto.dentist.DentistCompleteDTO;
import com.padillatomas.consultorio.service.DentistService;

@RestController
@RequestMapping("dentists")
@CrossOrigin("http://localhost:3000")
public class DentistController {

	// Services:
	@Autowired
	private DentistService dentistServ;
	
	// == POST ==
	@PostMapping("/create")
	public ResponseEntity<DentistBasicDTO> createNewDentist(@RequestBody DentistBasicDTO newDentist){
		DentistBasicDTO createdDentist = dentistServ.saveNewDentist(newDentist);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdDentist);
	}
	
	// == GET ==
	@GetMapping("/all")
	public ResponseEntity<List<DentistBasicDTO>> getAllBasicPatients(){
		List<DentistBasicDTO> basicList = dentistServ.getBasicDentist();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(basicList);
	}
	
	@GetMapping("/details/{id}")
	public ResponseEntity<DentistCompleteDTO> getDetailedDentist(@PathVariable Long id){
		DentistCompleteDTO myPatient = dentistServ.getDetailsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(myPatient);
	}
		
	// == PUT ==
	@PutMapping("/edit/{id}")
	public ResponseEntity<DentistCompleteDTO> editDentist(
			@PathVariable Long id,
			@RequestBody DentistCompleteDTO newData 
			){
		DentistCompleteDTO editedDentist = dentistServ.editById(id, newData);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(editedDentist);
	}
	
	// == DELETE ==
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> softDeleteDentist(@PathVariable Long id){
		dentistServ.softDeleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
