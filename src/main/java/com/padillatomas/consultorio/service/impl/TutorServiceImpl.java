package com.padillatomas.consultorio.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.padillatomas.consultorio.entity.TutorEntity;
import com.padillatomas.consultorio.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.padillatomas.consultorio.dto.TutorDTO;
import com.padillatomas.consultorio.dto.patient.PatientCompleteDTO;
import com.padillatomas.consultorio.entity.PatientEntity;
import com.padillatomas.consultorio.mapper.PatientMapper;
import com.padillatomas.consultorio.mapper.TutorMapper;
import com.padillatomas.consultorio.repository.PatientRepository;
import com.padillatomas.consultorio.repository.TutorRepository;

@Service
public class TutorServiceImpl implements TutorService {

	// Service:
	@Autowired
	private PatientServiceImpl patientServ;
	// Mapper:
	@Autowired
	private TutorMapper tutorMapper;
	@Autowired
	private PatientMapper patientMapper;
	
	// Repository:
	@Autowired
	private PatientRepository patientRepo;
	@Autowired
	private TutorRepository tutorRepo;
	
	// == POST ==
	@Override
	public TutorDTO saveNewTutor(Long patientId, TutorDTO newTutor) {
		// TODO Optional
		PatientEntity foundPatient = patientRepo.getById(patientId);
		// TODO: Error when PatientID Inexistent.
		
		TutorEntity newEntity = tutorMapper.DTO2Entity(newTutor);
		TutorEntity savedEntity = tutorRepo.save(newEntity);
		// Add To Patient-Responsables:
		foundPatient.addTutor(savedEntity);
		PatientCompleteDTO foundDTO = patientMapper.entity2DTO(foundPatient);
		patientServ.editById(patientId, foundDTO);
		
		TutorDTO resultDTO = tutorMapper.entity2DTO(savedEntity);
		return resultDTO;
	}
	
	// == GET ==
	
	// == PUT ==
	@Override
	public TutorDTO editById(Long id, TutorDTO newData) {
		// TODO: Optional
		TutorEntity foundTutor = tutorRepo.getById(id);
		foundTutor.setDni(newData.getDni());
		foundTutor.setFirstName(newData.getFirstName());
		foundTutor.setLastName(newData.getLastName());
		foundTutor.setBirthDate(this.string2LocalDate(newData.getBirthDate()));
		foundTutor.setAddress(newData.getAddress());
		foundTutor.setPhoneNumber(newData.getPhoneNumber());
		foundTutor.setEmail(newData.getEmail());
		foundTutor.setRelation(newData.getRelation());
		TutorEntity editedTutor = tutorRepo.save(foundTutor);
		TutorDTO resultDTO = tutorMapper.entity2DTO(editedTutor);
		return resultDTO;
	}
	
	// == DELETE ==
	@Override
	public void softDeleteById(Long respoId, Long patientId) {
		// TODO: Deberiamos Verificar Existencia?
		// TODO: Optional
		TutorEntity foundTutor = tutorRepo.getById(respoId);
		PatientEntity foundPatient = patientRepo.getById(patientId);
		foundPatient.removeTutor(foundTutor);
		PatientCompleteDTO foundDTO = patientMapper.entity2DTO(foundPatient);
		patientServ.editById(patientId, foundDTO);
		tutorRepo.deleteById(respoId);
	}
	
	// ::: Methods :::
	// String to LocalDate:
	public LocalDate string2LocalDate (String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		LocalDate formattedDate = LocalDate.parse(dateString, formatter);	
		return formattedDate;
	}

}
