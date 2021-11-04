package com.padillatomas.consultorio.service;

import java.util.List;

import com.padillatomas.consultorio.dto.patient.PatientBasicDTO;
import com.padillatomas.consultorio.dto.patient.PatientCompleteDTO;

public interface PatientService {

	// Post
	PatientCompleteDTO saveNewPatient(PatientCompleteDTO newPatient);

	// Get
	List<PatientBasicDTO> getBasicPatients();

	PatientCompleteDTO getDetailsById(Long id);

	// Put
	PatientCompleteDTO editById(Long id, PatientCompleteDTO newData);

	// Delete
	void softDeleteById(Long id);

}
