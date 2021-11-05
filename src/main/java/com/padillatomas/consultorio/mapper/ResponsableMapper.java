package com.padillatomas.consultorio.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.padillatomas.consultorio.dto.ResponsableDTO;
import com.padillatomas.consultorio.entity.ResponsableEntity;

@Component
public class ResponsableMapper {
	
	// Mappers:
	
	// === DTO -> Entity ===
	public ResponsableEntity DTO2Entity(ResponsableDTO newResponsable) {
		ResponsableEntity newEntity = new ResponsableEntity();
		newEntity.setDni(newResponsable.getDni());
		newEntity.setFirstName(newResponsable.getFirstName());
		newEntity.setLastName(newResponsable.getLastName());
		newEntity.setBirthDate(this.string2LocalDate(newResponsable.getBirthDate()));
		newEntity.setAddress(newResponsable.getAddress());
		newEntity.setPhoneNumber(newResponsable.getPhoneNumber());
		newEntity.setEmail(newResponsable.getEmail());
		newEntity.setParentesco(newResponsable.getParentesco());
		return newEntity;
	}
	
	// === Entity -> DTO ===
	public ResponsableDTO entity2DTO(ResponsableEntity savedEntity) {
		ResponsableDTO newDTO = new ResponsableDTO();
		newDTO.setId(savedEntity.getId());
		newDTO.setDni(savedEntity.getDni());
		newDTO.setFirstName(savedEntity.getFirstName());
		newDTO.setLastName(savedEntity.getLastName());
		newDTO.setBirthDate(this.localDate2String(savedEntity.getBirthDate()));
		newDTO.setAddress(savedEntity.getAddress());
		newDTO.setPhoneNumber(savedEntity.getPhoneNumber());
		newDTO.setEmail(savedEntity.getEmail());
		newDTO.setParentesco(savedEntity.getParentesco());
		return newDTO;
	}
	// === List<DTO> -> List<Entity> ===
	
	// === List<Entity> -> List<DTO> ===
	public List<ResponsableDTO> respoEntityList2DTOList(List<ResponsableEntity> entityList){
		List<ResponsableDTO> newList = new ArrayList<>();
		for(ResponsableEntity ent : entityList) {
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
