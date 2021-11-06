package com.padillatomas.consultorio.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.padillatomas.consultorio.dto.dentist.DentistBasicDTO;
import com.padillatomas.consultorio.dto.dentist.DentistCompleteDTO;
import com.padillatomas.consultorio.entity.DentistEntity;

@Component
public class DentistMapper {
	
	// Mapper:
	@Autowired
	private WorkScheduleMapper schMapper;
	
	
	//
	// === DTO -> Entity ===
	//	
	// === Entity -> DTO ===
	public DentistCompleteDTO entity2DTO(DentistEntity foundDentist) {
		DentistCompleteDTO newDTO = new DentistCompleteDTO();
		newDTO.setId(foundDentist.getId());
		newDTO.setDni(foundDentist.getDni());
		newDTO.setFirstName(foundDentist.getFirstName());
		newDTO.setLastName(foundDentist.getLastName());
		newDTO.setBirthDate(this.localDate2String(foundDentist.getBirthDate()));
		newDTO.setAddress(foundDentist.getAddress());
		newDTO.setPhoneNumber(foundDentist.getPhoneNumber());
		newDTO.setEmail(foundDentist.getEmail());
		newDTO.setSpeciality(foundDentist.getSpeciality());
		// TODO -> Turnos, Schedule, Usuario
		newDTO.setSchedules(schMapper.wsEntityList2DTOList(foundDentist.getSchedules()));
		return newDTO;
	}

	
	//
	// === List<DTO> -> List<Entity> ===
	
	//
	// === List<Entity> -> List<DTO> ===

	// ****************
	// 	  	BASIC
	// ****************
	
	//
	// === DTO -> Entity ===
	public DentistEntity basicDTO2Entity(DentistBasicDTO newDentist) {
		DentistEntity newEntity = new DentistEntity();
		newEntity.setDni(newDentist.getDni());
		newEntity.setFirstName(newDentist.getFirstName());
		newEntity.setLastName(newDentist.getLastName());
		newEntity.setBirthDate(this.string2LocalDate(newDentist.getBirthDate()));
		newEntity.setAddress(newDentist.getAddress());
		newEntity.setPhoneNumber(newDentist.getPhoneNumber());
		newEntity.setEmail(newDentist.getEmail());	
		newEntity.setSpeciality(newDentist.getSpeciality());
		return newEntity;
	}
	
	//
	// === Entity -> DTO ===
	public DentistBasicDTO entity2BasicDTO(DentistEntity savedEnt) {
		DentistBasicDTO newDTO = new DentistBasicDTO();
		newDTO.setId(savedEnt.getId());
		newDTO.setDni(savedEnt.getDni());
		newDTO.setFirstName(savedEnt.getFirstName());
		newDTO.setLastName(savedEnt.getLastName());
		newDTO.setBirthDate(this.localDate2String(savedEnt.getBirthDate()));
		newDTO.setAddress(savedEnt.getAddress());
		newDTO.setPhoneNumber(savedEnt.getPhoneNumber());
		newDTO.setEmail(savedEnt.getEmail());
		newDTO.setSpeciality(savedEnt.getSpeciality());
		return newDTO;
	}
	
	//
	// === List<DTO> -> List<Entity> ===
	
	//
	// === List<Entity> -> List<DTO> ===
	public List<DentistBasicDTO> entityList2BasicDTOList(List<DentistEntity> savedDentists) {
		List<DentistBasicDTO> newList = new ArrayList<>();
		for (DentistEntity ent : savedDentists) {
			newList.add(this.entity2BasicDTO(ent));
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
