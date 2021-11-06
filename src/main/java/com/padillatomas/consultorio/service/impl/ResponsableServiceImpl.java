package com.padillatomas.consultorio.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.padillatomas.consultorio.dto.ResponsableDTO;
import com.padillatomas.consultorio.dto.patient.PatientCompleteDTO;
import com.padillatomas.consultorio.entity.PatientEntity;
import com.padillatomas.consultorio.entity.ResponsableEntity;
import com.padillatomas.consultorio.mapper.PatientMapper;
import com.padillatomas.consultorio.mapper.ResponsableMapper;
import com.padillatomas.consultorio.repository.PatientRepository;
import com.padillatomas.consultorio.repository.ResponsableRepository;
import com.padillatomas.consultorio.service.ResponsableService;

@Service
public class ResponsableServiceImpl implements ResponsableService{

	// Service:
	@Autowired
	private PatientServiceImpl patientServ;
	// Mapper:
	@Autowired
	private ResponsableMapper responsableMapper;
	@Autowired
	private PatientMapper patientMapper;
	
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
		// TODO: Error when PatientID Inexistent.
		
		ResponsableEntity newEntity = responsableMapper.DTO2Entity(newResponsable);
		ResponsableEntity savedEntity = responsableRepo.save(newEntity);
		// Add To Patient-Responsables:
		foundPatient.addResponsable(savedEntity);
		PatientCompleteDTO foundDTO = patientMapper.entity2DTO(foundPatient);
		patientServ.editById(patientId, foundDTO);
		
		ResponsableDTO resultDTO = responsableMapper.entity2DTO(savedEntity);
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
	public void softDeleteById(Long respoId, Long patientId) {
		// TODO: Deberiamos Verificar Existencia?
		// TODO: Optional
		ResponsableEntity foundResponsable = responsableRepo.getById(respoId);
		PatientEntity foundPatient = patientRepo.getById(patientId);
		foundPatient.removeResponsable(foundResponsable);
		PatientCompleteDTO foundDTO = patientMapper.entity2DTO(foundPatient);
		patientServ.editById(patientId, foundDTO);
		
		responsableRepo.deleteById(respoId);
	}
	
	// ::: Methods :::
	// String to LocalDate:
	public LocalDate string2LocalDate (String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		LocalDate formattedDate = LocalDate.parse(dateString, formatter);	
		return formattedDate;
	}

}
