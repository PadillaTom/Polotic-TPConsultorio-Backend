package com.padillatomas.consultorio.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "appointment")
@Getter
@Setter
@SQLDelete(sql = "UPDATE appointment SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class AppointmentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private LocalDate date;
	
	private LocalTime time;
	
	private String consultation;
	
	private String diagnosis;
	
	// PROCESO:
	// getPaciente(id),
	// addTurno a Paciente,
	// addTurno a Odontologo(id),
	// "blockear" 30min en scheduleOdontologo
	
	// Pertenece a Odontologo
	// Pertenece a Paciente
	
	

}
