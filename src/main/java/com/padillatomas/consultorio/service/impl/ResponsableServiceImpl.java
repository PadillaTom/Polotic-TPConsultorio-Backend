package com.padillatomas.consultorio.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
	@Override
	public ResponsableDTO editById(Long id, ResponsableDTO newData) {
		// TODO: Optional
		ResponsableEntity foundResponsable = responsableRepo.getById(id);
		foundResponsable.setDni(newData.getDni());
		foundResponsable.setFirstName(newData.getFirstName());
		foundResponsable.setLastName(newData.getLastName());
		foundResponsable.setBirthDate(this.string2LocalDate(newData.getBirthDate()));
		foundResponsable.setAddress(newData.getAddress());
		foundResponsable.setPhoneNumber(newData.getPhoneNumber());
		foundResponsable.setEmail(newData.getEmail());
		foundResponsable.setParentesco(newData.getParentesco());
		ResponsableEntity editedResponsable = responsableRepo.save(foundResponsable);
		ResponsableDTO resultDTO = responsableMapper.entity2DTO(editedResponsable);
		return resultDTO;
	}
	
	// == DELETE ==
	@Override
	public void softDeleteById(Long id) {
		// TODO: Deberiamos Verificar Existencia?
		responsableRepo.deleteById(id);
	}
	
	// ::: Methods :::
	// String to LocalDate:
	public LocalDate string2LocalDate (String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		LocalDate formattedDate = LocalDate.parse(dateString, formatter);	
		return formattedDate;
	}

}
