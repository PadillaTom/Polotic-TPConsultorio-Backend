package com.padillatomas.consultorio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.padillatomas.consultorio.dto.patient.PatientCompleteDTO;
import com.padillatomas.consultorio.entity.PatientEntity;
import com.padillatomas.consultorio.mapper.PatientMapper;
import com.padillatomas.consultorio.repository.PatientRepository;
import com.padillatomas.consultorio.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	// Mappers:
	@Autowired
	private PatientMapper patientMap;
	
	// Repository:
	@Autowired
	private PatientRepository patientRepo;
	
	
	// == POST ==

	@Override
	public PatientCompleteDTO saveNewPatient(PatientCompleteDTO newPatient) {
		PatientEntity newEntity = patientMap.DTO2Entity(newPatient);
		PatientEntity savedEntity = patientRepo.save(newEntity);
		PatientCompleteDTO resultDTO = patientMap.Entity2DTO(savedEntity);
		return resultDTO;
	}
	
	// == GET ==
	// == PUT ==
	// == DELETE ==
	
	// ::: Methods :::

}
