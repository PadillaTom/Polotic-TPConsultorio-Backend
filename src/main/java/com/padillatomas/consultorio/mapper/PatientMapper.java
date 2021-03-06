package com.padillatomas.consultorio.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.padillatomas.consultorio.dto.patient.PatientBasicDTO;
import com.padillatomas.consultorio.dto.patient.PatientCompleteDTO;
import com.padillatomas.consultorio.entity.PatientEntity;

@Component
public class PatientMapper {
	
	// Mappers:
	@Autowired
    TutorMapper tutorMapper;
	
	@Autowired
	AppointmentMapper appointmentMapper;
	
	//
	// === DTO -> Entity ===
	
	//
	// === Entity -> DTO ===
	public PatientCompleteDTO entity2DTO(PatientEntity savedEntity) {
		PatientCompleteDTO newDTO = new PatientCompleteDTO();
		newDTO.setId(savedEntity.getId());
		newDTO.setDni(savedEntity.getDni());
		newDTO.setFirstName(savedEntity.getFirstName());
		newDTO.setLastName(savedEntity.getLastName());
		newDTO.setBirthDate(this.localDate2String(savedEntity.getBirthDate()));
		newDTO.setAddress(savedEntity.getAddress());
		newDTO.setPhoneNumber(savedEntity.getPhoneNumber());
		newDTO.setEmail(savedEntity.getEmail());
		newDTO.setHasSecurity(savedEntity.isHasSecurity());
		// TODO -> Turnos y Responsables
		newDTO.setTutors(tutorMapper.tutorEntityList2DTOList(savedEntity.getTutors()));
		newDTO.setAppointments(appointmentMapper.appoEntityList2DTOList(savedEntity.getPatientRdvs()));
		return newDTO;
	}
	
	//
	// === List<DTO> -> List<Entity> ===
	
	//
	// === List<Entity> -> List<DTO> ===
	
	
	// ****************
	// 	  	BASIC
	// ****************
	
	// === DTO -> Entity ===
	public PatientEntity DTO2BasicEntity(PatientBasicDTO newPatient) {
		PatientEntity newEntity = new PatientEntity();
		newEntity.setDni(newPatient.getDni());
		newEntity.setFirstName(newPatient.getFirstName());
		newEntity.setLastName(newPatient.getLastName());
		newEntity.setBirthDate(this.string2LocalDate(newPatient.getBirthDate()));
		newEntity.setAddress(newPatient.getAddress());
		newEntity.setPhoneNumber(newPatient.getPhoneNumber());
		newEntity.setEmail(newPatient.getEmail());
		newEntity.setHasSecurity(newPatient.isHasSecurity());
		return newEntity;
	}
	
	//
	// === Entity -> DTO ===
	public PatientBasicDTO basicEntity2BasicDTO(PatientEntity entity) {
		PatientBasicDTO newDTO = new PatientBasicDTO();
		newDTO.setId(entity.getId());
		newDTO.setDni(entity.getDni());
		newDTO.setFirstName(entity.getFirstName());
		newDTO.setLastName(entity.getLastName());
		newDTO.setBirthDate(this.localDate2String(entity.getBirthDate()));
		newDTO.setAddress(entity.getAddress());
		newDTO.setPhoneNumber(entity.getPhoneNumber());
		newDTO.setEmail(entity.getEmail());
		newDTO.setHasSecurity(entity.isHasSecurity());
		return newDTO;
	}
	
	//
	// === List<DTO> -> List<Entity> ===
	
	//
	// === List<Entity> -> List<DTO> ===
	public List<PatientBasicDTO> entityList2BasicDTOList(List<PatientEntity> savedPatients) {
		List<PatientBasicDTO> newList = new ArrayList<>();
		for(PatientEntity ent : savedPatients) {
			newList.add(this.basicEntity2BasicDTO(ent));
		}
		return newList;
	}
	
	// ::: Methods :::
	
	// String to LocalDate:
	public LocalDate string2LocalDate (String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		LocalDate formattedDate = LocalDate.parse(dateString, formatter);	
		return formattedDate;
	}
	
	// LocalDate to String:
	public String localDate2String (LocalDate date) {
		String formattedDate = date.format(DateTimeFormatter.ofPattern("d/MM/yyyy"));	
		return formattedDate;
	}


}
