package com.padillatomas.consultorio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.padillatomas.consultorio.dto.AppointmentDTO;
import com.padillatomas.consultorio.entity.AppointmentEntity;
import com.padillatomas.consultorio.entity.DentistEntity;
import com.padillatomas.consultorio.entity.PatientEntity;
import com.padillatomas.consultorio.mapper.AppointmentMapper;
import com.padillatomas.consultorio.repository.AppointmentRepository;
import com.padillatomas.consultorio.repository.DentistRepository;
import com.padillatomas.consultorio.repository.PatientRepository;
import com.padillatomas.consultorio.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	// Service:
	
	// Mapper:
	@Autowired
	private AppointmentMapper appoMapper;
	
	// Repository:
	@Autowired
	private AppointmentRepository appoRepo;
	@Autowired
	private PatientRepository patientRepo;
	@Autowired
	private DentistRepository dentistRepo;
	
	// == POST ==
	@Override
	public AppointmentDTO saveNewAppointment(Long patientId, Long dentistId, AppointmentDTO newAppo) {
		AppointmentEntity newEnt = appoMapper.DTO2Entity(newAppo);
		AppointmentEntity savedEnt = appoRepo.save(newEnt);
		AppointmentDTO resultDTO = appoMapper.entity2DTO(savedEnt);
		
		// TODO: Optional
		
		// Add to Patient List ->  Rj: id 9
		PatientEntity foundPatient = patientRepo.getById(patientId);
		foundPatient.addRdv(savedEnt);
		patientRepo.save(foundPatient);
				
		// Add to Dentist List -> Ej: id 11
		DentistEntity foundDentist = dentistRepo.getById(dentistId);
		foundDentist.addRdvs(savedEnt);
		dentistRepo.save(foundDentist);
		 
		return resultDTO;
	}
	
	// == GET ==
	
	
	// == PUT ==
	// == DELETE ==
}
