package com.padillatomas.consultorio.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "patient")
@Getter
@Setter
@SQLDelete(sql = "UPDATE patient SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
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
	
	// SOLO Para SOFT DELETE:
	private boolean deleted = Boolean.FALSE;
	
	// Has Many Responsables:
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ResponsableEntity> responsables = new ArrayList<>();
	
	// Has Many Turnos:
	
	// ::: Methods :::
	
	// addResponsable - removeResponable
	public void addResponsable(ResponsableEntity responsableToAdd) {
		responsables.add(responsableToAdd);
	}
	// addTurno - removeTurno	
	
}
