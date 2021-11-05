package com.padillatomas.consultorio.mapper;

import org.springframework.stereotype.Component;

import com.padillatomas.consultorio.dto.WorkScheduleDTO;
import com.padillatomas.consultorio.entity.WorkScheduleEntity;

@Component
public class WorkScheduleMapper {

	// Service
	// Mapper
	
	//
	// === DTO -> Entity ===
	public WorkScheduleEntity DTO2Entity(WorkScheduleDTO newWS) {
		WorkScheduleEntity newEntity = new WorkScheduleEntity();
		// BUSCAR MANEJO DE DATE SOLO TIME
		newEntity.setBeginsAt(newWS.getBeginsAt());
		newEntity.setEndsAt(newWS.getEndsAt());
		newEntity.setDay(newWS.getDay());
		return newEntity;
	}
	
	//
	// === Entity -> DTO ===
	public WorkScheduleDTO entity2DTO(WorkScheduleEntity savedEntity) {
		WorkScheduleDTO newDTO = new WorkScheduleDTO();
		newDTO.setId(savedEntity.getId());
		newDTO.setBeginsAt(savedEntity.getBeginsAt());
		newDTO.setEndsAt(savedEntity.getEndsAt());
		newDTO.setDay(savedEntity.getDay());
		return newDTO;
	}
	
	//
	// === List<DTO> -> List<Entity> ===
	
	//
	// === List<Entity> -> List<DTO> ===
}
