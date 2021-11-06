package com.padillatomas.consultorio.mapper;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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
		newEntity.setBeginsAt(this.String2Time(newWS.getBeginsAt()));
		newEntity.setEndsAt(this.String2Time(newWS.getEndsAt()));
		newEntity.setDay(newWS.getDay());
		return newEntity;
	}
	
	//
	// === Entity -> DTO ===
	public WorkScheduleDTO entity2DTO(WorkScheduleEntity savedEntity) {
		WorkScheduleDTO newDTO = new WorkScheduleDTO();
		newDTO.setId(savedEntity.getId());
		newDTO.setBeginsAt(this.LocalTime2String(savedEntity.getBeginsAt()));
		newDTO.setEndsAt(this.LocalTime2String(savedEntity.getEndsAt()));
		newDTO.setDay(savedEntity.getDay());
		return newDTO;
	}
	
	//
	// === List<DTO> -> List<Entity> ===
	
	//
	// === List<Entity> -> List<DTO> ===
	public List<WorkScheduleDTO> wsEntityList2DTOList(List<WorkScheduleEntity> schedules) {
		List<WorkScheduleDTO> newList = new ArrayList<>();
		for(WorkScheduleEntity ent : schedules) {
			newList.add(this.entity2DTO(ent));
		}
		return newList;
	}
	
	// ::: Methods :::
	
	// String to LocalTime:
	public LocalTime String2Time(String str) {
		LocalTime myTime = LocalTime.parse(str);
		return myTime;
	}
	// LocalTime to String:
	public String LocalTime2String(LocalTime dbTime) {
		String myString = dbTime.toString();
		return myString;
	}




}
