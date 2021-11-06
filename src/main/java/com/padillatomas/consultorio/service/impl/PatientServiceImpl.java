package com.padillatomas.consultorio.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.padillatomas.consultorio.dto.patient.PatientBasicDTO;
import com.padillatomas.consultorio.dto.patient.PatientCompleteDTO;
import com.padillatomas.consultorio.entity.PatientEntity;
import com.padillatomas.consultorio.mapper.PatientMapper;
import com.padillatomas.consultorio.repository.PatientRepository;
import com.padillatomas.consultorio.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	// Mapper:
	@Autowired
	private PatientMapper patientMap;
	
	// Repository:
	@Autowired
	private PatientRepository patientRepo;
	
	
	// == POST ==
	@Override
	public PatientBasicDTO saveNewPatient(PatientBasicDTO newPatient) {
		PatientEntity newEntity = patientMap.DTO2BasicEntity(newPatient);
		PatientEntity savedEntity = patientRepo.save(newEntity);
		PatientBasicDTO resultDTO = patientMap.basicEntity2BasicDTO(savedEntity);
		return resultDTO;
	}


	// == GET ==
	@Override
	public List<PatientBasicDTO> getBasicPatients() {
		// TODO Optional
		List<PatientEntity> savedPatients = patientRepo.findAll();
		List<PatientBasicDTO> basicPatients = patientMap.entityList2BasicDTOList(savedPatients);
		return basicPatients;
	}

	@Override
	public PatientCompleteDTO getDetailsById(Long id) {
		// TODO Optional
		PatientEntity savedEntity = patientRepo.getById(id);
		PatientCompleteDTO resultDTO = patientMap.entity2DTO(savedEntity);
		return resultDTO;
	}

	// == PUT ==
	@Override
	public PatientCompleteDTO editById(Long id, PatientCompleteDTO newData) {
		// TODO Optional -  EDIT Turno
		PatientEntity foundPatient = patientRepo.getById(id);
		foundPatient.setDni(newData.getDni());
		foundPatient.setFirstName(newData.getFirstName());
		foundPatient.setLastName(newData.getLastName());
		foundPatient.setBirthDate(this.string2LocalDate(newData.getBirthDate()));
		foundPatient.setAddress(newData.getAddress());
		foundPatient.setPhoneNumber(newData.getPhoneNumber());
		foundPatient.setEmail(newData.getEmail());
		foundPatient.setHasObraSocial(newData.isHasObraSocial());
		PatientEntity editedPatient = patientRepo.save(foundPatient);
		PatientCompleteDTO resultDTO = patientMap.entity2DTO(editedPatient);
		return resultDTO;
	}
	
	// == DELETE ==
	@Override
	public void softDeleteById(Long id) {
		// TODO: Deberiamos Verificar Existencia?
		patientRepo.deleteById(id);
	}
	
	// ::: Methods :::
	// String to LocalDate:
	public LocalDate string2LocalDate (String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		LocalDate formattedDate = LocalDate.parse(dateString, formatter);	
		return formattedDate;
	}

}
