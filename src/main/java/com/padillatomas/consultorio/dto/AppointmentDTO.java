package com.padillatomas.consultorio.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentDTO {
	
	private Long id;	
	private String date;	
	private String time;	 // To be casted to LocalTime
	private String consultation;	
	private String diagnosis;

}
