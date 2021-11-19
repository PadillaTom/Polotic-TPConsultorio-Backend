package com.padillatomas.consultorio.dto.patient;

import java.util.List;

import com.padillatomas.consultorio.dto.AppointmentDTO;
import com.padillatomas.consultorio.dto.TutorDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientCompleteDTO {
	// Returns: Patient Completo (Turnos, Responsables)
	
	private Long id;
	// Persona:
	private String dni;
	private String firstName;
	private String lastName;
	private String birthDate;
	private String address;
	private String phoneNumber;
	private String email;
	
	// Patient:
	private boolean hasSecurity;
	
	// Relations: Turnos, Responsables
	private List<TutorDTO> tutors;
	private List<AppointmentDTO> appointments;
}
