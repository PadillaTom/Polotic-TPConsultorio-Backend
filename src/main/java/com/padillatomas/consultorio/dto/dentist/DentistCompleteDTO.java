package com.padillatomas.consultorio.dto.dentist;

import java.util.List;

import com.padillatomas.consultorio.dto.AppointmentDTO;
import com.padillatomas.consultorio.dto.WorkScheduleDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DentistCompleteDTO {

	// Returns: Dentist Completo (Turnos, Schedules, Usuario)
	
	private Long id;
	// Persona:
	private String dni;
	private String firstName;
	private String lastName;
	private String birthDate;
	private String address;
	private String phoneNumber;
	private String email;
	private String speciality;
	
	private List<WorkScheduleDTO> schedules;
	private List<AppointmentDTO> appointments;
	
}
