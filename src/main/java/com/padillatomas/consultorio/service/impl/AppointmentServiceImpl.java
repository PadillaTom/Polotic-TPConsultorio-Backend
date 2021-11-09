package com.padillatomas.consultorio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.padillatomas.consultorio.dto.AppointmentDTO;
import com.padillatomas.consultorio.entity.AppointmentEntity;
import com.padillatomas.consultorio.mapper.AppointmentMapper;
import com.padillatomas.consultorio.repository.AppointmentRepository;
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
	
	// == POST ==
	@Override
	public AppointmentDTO saveNewAppointment(AppointmentDTO newAppo) {
		AppointmentEntity newEnt = appoMapper.DTO2Entity(newAppo);
		AppointmentEntity savedEnt = appoRepo.save(newEnt);
		AppointmentDTO resultDTO = appoMapper.entity2DTO(savedEnt);
		return resultDTO;
	}
	
	// == GET ==
	
	
	// == PUT ==
	// == DELETE ==
}
