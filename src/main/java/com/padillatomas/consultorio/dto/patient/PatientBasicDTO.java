package com.padillatomas.consultorio.dto.patient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientBasicDTO {
	// Returns: Patient Without Relations (NO: Turnos, Responsables)
	
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

}
