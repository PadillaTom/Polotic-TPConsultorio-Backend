package com.padillatomas.consultorio.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.padillatomas.consultorio.entity.TutorEntity;
import org.springframework.stereotype.Component;

import com.padillatomas.consultorio.dto.TutorDTO;

@Component
public class TutorMapper {
	
	// Mappers:
	
	// === DTO -> Entity ===
	public TutorEntity DTO2Entity(TutorDTO newTutor) {
		TutorEntity newEntity = new TutorEntity();
		newEntity.setDni(newTutor.getDni());
		newEntity.setFirstName(newTutor.getFirstName());
		newEntity.setLastName(newTutor.getLastName());
		newEntity.setBirthDate(this.string2LocalDate(newTutor.getBirthDate()));
		newEntity.setAddress(newTutor.getAddress());
		newEntity.setPhoneNumber(newTutor.getPhoneNumber());
		newEntity.setEmail(newTutor.getEmail());
		newEntity.setRelation(newTutor.getRelation());
		return newEntity;
	}
	
	// === Entity -> DTO ===
	public TutorDTO entity2DTO(TutorEntity savedEntity) {
		TutorDTO newDTO = new TutorDTO();
		newDTO.setId(savedEntity.getId());
		newDTO.setDni(savedEntity.getDni());
		newDTO.setFirstName(savedEntity.getFirstName());
		newDTO.setLastName(savedEntity.getLastName());
		newDTO.setBirthDate(this.localDate2String(savedEntity.getBirthDate()));
		newDTO.setAddress(savedEntity.getAddress());
		newDTO.setPhoneNumber(savedEntity.getPhoneNumber());
		newDTO.setEmail(savedEntity.getEmail());
		newDTO.setRelation(savedEntity.getRelation());
		return newDTO;
	}
	// === List<DTO> -> List<Entity> ===
	
	// === List<Entity> -> List<DTO> ===
	public List<TutorDTO> tutorEntityList2DTOList(List<TutorEntity> entityList){
		List<TutorDTO> newList = new ArrayList<>();
		for(TutorEntity ent : entityList) {
			newList.add(this.entity2DTO(ent));
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
