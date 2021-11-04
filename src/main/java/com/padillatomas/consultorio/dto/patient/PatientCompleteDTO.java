package com.padillatomas.consultorio.dto.patient;

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
	private boolean hasObraSocial;
	
	// Relations: Turnos, Responsables
}
