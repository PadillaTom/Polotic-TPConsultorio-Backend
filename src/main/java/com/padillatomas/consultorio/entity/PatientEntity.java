package com.padillatomas.consultorio.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "patients")
@Getter
@Setter
public class PatientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	// Persona:
	private String dni;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "birth_date")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate birthDate;
	
	private String address;
	private String phoneNumber;
	private String email;
	
	// Patient:
	private boolean hasObraSocial;
	
	// Relations:
	// Many TURNOS
	// Many RESPONSABLES
	
	// ::: Methods :::
	
}
