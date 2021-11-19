package com.padillatomas.consultorio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TutorDTO {

	private Long id;
	// Persona:
	private String dni;
	private String firstName;
	private String lastName;
	private String birthDate;
	private String address;
	private String phoneNumber;
	private String email;
	private String relation;
}
