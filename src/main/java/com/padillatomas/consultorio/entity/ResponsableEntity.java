package com.padillatomas.consultorio.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "responsable")
@Getter
@Setter
@SQLDelete(sql = "UPDATE responsable SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class ResponsableEntity {
	
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
	
	// Responsable:
	private String parentesco;
	
	// SOLO Para SOFT DELETE:
	private boolean deleted = Boolean.FALSE;
	
}
