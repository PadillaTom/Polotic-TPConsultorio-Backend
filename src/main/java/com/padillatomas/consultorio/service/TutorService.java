package com.padillatomas.consultorio.service;

import com.padillatomas.consultorio.dto.TutorDTO;

public interface TutorService {

	// Post
	TutorDTO saveNewTutor(Long patientId, TutorDTO newResponsable);

	// Put
	TutorDTO editById(Long responsableId, TutorDTO responsableDTO);

	// Delete
	void softDeleteById(Long id, Long paisId);

}
