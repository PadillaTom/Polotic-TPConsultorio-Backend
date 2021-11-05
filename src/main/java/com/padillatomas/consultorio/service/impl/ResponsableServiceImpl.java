package com.padillatomas.consultorio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.padillatomas.consultorio.dto.ResponsableDTO;
import com.padillatomas.consultorio.entity.PatientEntity;
import com.padillatomas.consultorio.entity.ResponsableEntity;
import com.padillatomas.consultorio.mapper.ResponsableMapper;
import com.padillatomas.consultorio.repository.PatientRepository;
import com.padillatomas.consultorio.repository.ResponsableRepository;
import com.padillatomas.consultorio.service.ResponsableService;

@Service
public class ResponsableServiceImpl implements ResponsableService{

	// Mappers:
	@Autowired
	private ResponsableMapper responsableMapper;
	
	// Repository:
	@Autowired
	private PatientRepository patientRepo;
	@Autowired
	private ResponsableRepository responsableRepo;
	
	// == POST ==
	@Override
	public ResponsableDTO saveNewResponsable(Long patientId, ResponsableDTO newResponsable) {
		// TODO Optional
		PatientEntity foundPatient = patientRepo.getById(patientId);
		System.out.println("Found Patient: " + foundPatient.getDni());
		
		ResponsableEntity newEntity = responsableMapper.DTO2Entity(newResponsable);
		ResponsableEntity savedEntity = responsableRepo.save(newEntity);
		ResponsableDTO resultDTO = responsableMapper.entity2DTO(savedEntity);
		
		// ADD TO LIST RESPONSABLE INSIDE PATIENT
	
		return resultDTO;
	}
	// == GET ==
	// == PUT ==
	// == DELETE ==
	
	// ::: Methods :::
}
