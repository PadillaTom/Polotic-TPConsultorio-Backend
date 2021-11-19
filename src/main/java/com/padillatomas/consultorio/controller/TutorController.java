package com.padillatomas.consultorio.controller;

import com.padillatomas.consultorio.service.TutorService;
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

import com.padillatomas.consultorio.dto.TutorDTO;

@RestController
@RequestMapping("tutors")
public class TutorController {
	
	// Services:
	@Autowired
	private TutorService tutorServ;
	
	// == POST ==
	@PostMapping("/create/{patientId}")
	public ResponseEntity<TutorDTO> createNewTutor(@PathVariable Long patientId, @RequestBody TutorDTO newResponsable){
		TutorDTO createdTutor = tutorServ.saveNewTutor(patientId, newResponsable);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdTutor);
	}
	
	// == GET ==
	
	// == PUT ==
	@PutMapping("/edit/{id}")
	public ResponseEntity<TutorDTO> editTutor(
				@PathVariable Long id,
				@RequestBody TutorDTO newData
			) {
		TutorDTO editedTutor = tutorServ.editById(id, newData);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(editedTutor);
	}
	
	// == DELETE ==
	@DeleteMapping("{tutorId}/remove-from/{patientId}")
	public ResponseEntity<Void> softDeleteTutor(@PathVariable Long tutorId, @PathVariable Long patientId){
		tutorServ.softDeleteById(tutorId, patientId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
