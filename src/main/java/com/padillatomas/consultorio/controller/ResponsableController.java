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

import com.padillatomas.consultorio.dto.ResponsableDTO;
import com.padillatomas.consultorio.service.ResponsableService;

@RestController
@RequestMapping("responsables")
public class ResponsableController {
	
	// Services:
	@Autowired
	private ResponsableService responsableServ;
	
	// == POST ==
	@PostMapping("/create/{patientId}")
	public ResponseEntity<ResponsableDTO> createNewResponsable(@PathVariable Long patientId, @RequestBody ResponsableDTO newResponsable){
		ResponsableDTO createdResponsable = responsableServ.saveNewResponsable(patientId, newResponsable);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdResponsable);
	}
	
	// == GET ==
	
	// == PUT ==
	@PutMapping("/edit/{id}")
	public ResponseEntity<ResponsableDTO> editResponsable(
				@PathVariable Long id,
				@RequestBody ResponsableDTO newData
			) {
		ResponsableDTO editedResponsable = responsableServ.editById(id, newData);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(editedResponsable);
	}
	
	// == DELETE ==
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> softDeleteResponsable(@PathVariable Long id){
		responsableServ.softDeleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}