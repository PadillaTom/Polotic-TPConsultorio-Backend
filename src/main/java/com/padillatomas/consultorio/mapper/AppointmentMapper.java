package com.padillatomas.consultorio.mapper;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.stereotype.Component;

import com.padillatomas.consultorio.dto.AppointmentDTO;
import com.padillatomas.consultorio.entity.AppointmentEntity;

@Component
public class AppointmentMapper {

	

	//
	// === DTO -> Entity ===
	public AppointmentEntity DTO2Entity(AppointmentDTO newAppo) {
		AppointmentEntity newEnt = new AppointmentEntity();
		newEnt.setDate(this.string2LocalDate(newAppo.getDate()));
		newEnt.setTime(this.string2LocalTime(newAppo.getTime()));
		newEnt.setConsultation(newAppo.getConsultation());
		newEnt.setDiagnosis(newAppo.getDiagnosis());
		return newEnt;
		
	}
	
	//	
	// === Entity -> DTO ===
	public AppointmentDTO entity2DTO(AppointmentEntity savedEnt) {
		AppointmentDTO newDTO = new AppointmentDTO();
		newDTO.setId(savedEnt.getId());
		newDTO.setDate(this.localDate2String(savedEnt.getDate()));
		newDTO.setTime(this.localTime2String(savedEnt.getTime()));
		newDTO.setConsultation(savedEnt.getConsultation());
		newDTO.setDiagnosis(savedEnt.getDiagnosis());
		return newDTO;
	}
	
	
	// ::: Methods :::	
	
	// String to LocalDate
	public LocalDate string2LocalDate (String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		LocalDate formattedDate = LocalDate.parse(dateString, formatter);	
		return formattedDate;
	}
	
	// LocalDate to String
	public String localDate2String (LocalDate date) {
		String formattedDate = date.format(DateTimeFormatter.ofPattern("d/MM/yyyy"));	
		return formattedDate;
	}
	
	// String to Time
	public LocalTime string2LocalTime(String timeString) {
		return LocalTime.parse(timeString);
	}

	// Time to String
	public String localTime2String(LocalTime time) {
		return time.format(DateTimeFormatter.ofPattern("hh:mm", Locale.ENGLISH));
	}
	
	
}
