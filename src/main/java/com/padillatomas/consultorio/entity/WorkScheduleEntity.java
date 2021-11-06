package com.padillatomas.consultorio.entity;

import java.time.LocalTime;

import javax.persistence.Column;
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
@Table(name = "schedule")
@Getter
@Setter
@SQLDelete(sql = "UPDATE schedule SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class WorkScheduleEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "begins")
	private LocalTime beginsAt;
	
	@Column(name = "ends")
	private LocalTime endsAt;
	
	private String day;
	
	private boolean deleted = Boolean.FALSE;		

}
