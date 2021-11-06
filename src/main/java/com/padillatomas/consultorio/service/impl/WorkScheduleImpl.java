package com.padillatomas.consultorio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.padillatomas.consultorio.dto.WorkScheduleDTO;
import com.padillatomas.consultorio.dto.dentist.DentistCompleteDTO;
import com.padillatomas.consultorio.entity.DentistEntity;
import com.padillatomas.consultorio.entity.WorkScheduleEntity;
import com.padillatomas.consultorio.mapper.DentistMapper;
import com.padillatomas.consultorio.mapper.WorkScheduleMapper;
import com.padillatomas.consultorio.repository.DentistRepository;
import com.padillatomas.consultorio.repository.WorkScheduleRepository;
import com.padillatomas.consultorio.service.WorkScheduleService;

@Service
public class WorkScheduleImpl implements WorkScheduleService {

	// Service:
	@Autowired
	private DentistServiceImpl dentistServ;
	// Mapper
	@Autowired
	private WorkScheduleMapper wsMapper;
	@Autowired
	private DentistMapper dentistMapper;
	
	// Repository
	@Autowired
	private WorkScheduleRepository wsRepo;
	@Autowired
	private DentistRepository dentistRepo;
	
	// == POST ==
	@Override
	public WorkScheduleDTO saveNewWS(Long dentistId, WorkScheduleDTO newWS) {
		// TODO Optional
		DentistEntity foundDentist = dentistRepo.getById(dentistId);
		// TODO: Error when PatientID Inexistent.
		
		System.out.println(foundDentist.getDni());
		
		WorkScheduleEntity newEntity = wsMapper.DTO2Entity(newWS);
		WorkScheduleEntity savedEntity = wsRepo.save(newEntity);
		// Add To Patient-Responsables:
		foundDentist.addSchedule(savedEntity);
		DentistCompleteDTO foundDTO = dentistMapper.entity2DTO(foundDentist);
		dentistServ.editById(dentistId, foundDTO);
		
		WorkScheduleDTO resultDTO = wsMapper.entity2DTO(savedEntity);
		return resultDTO;
	}	
	
	// == GET ==
	
	// == PUT ==	
	@Override
	public WorkScheduleDTO editById(Long id, WorkScheduleDTO newData) {
		// TODO: Optional
		WorkScheduleEntity foundSchedule = wsRepo.getById(id);
		// TODO Error		
		foundSchedule.setBeginsAt(wsMapper.String2Time(newData.getBeginsAt()));
		foundSchedule.setEndsAt(wsMapper.String2Time(newData.getEndsAt()));
		foundSchedule.setDay(newData.getDay());
		WorkScheduleEntity editedSchedule = wsRepo.save(foundSchedule);
		WorkScheduleDTO resultDTO = wsMapper.entity2DTO(editedSchedule);
		return resultDTO;
	}

	// == DELETE ==
	@Override
	public void softDeleteById(Long scheduleId, Long dentistId) {
		// TODO: Deberiamos Verificar Existencia?
		// TODO: Optional
		WorkScheduleEntity foundSchedule = wsRepo.getById(scheduleId);
		DentistEntity foundDentist = dentistRepo.getById(dentistId);
		foundDentist.removeSchedule(foundSchedule);
		DentistCompleteDTO foundDTO = dentistMapper.entity2DTO(foundDentist);
		dentistServ.editById(dentistId, foundDTO);		
		wsRepo.deleteById(scheduleId);		
	}
	
}
