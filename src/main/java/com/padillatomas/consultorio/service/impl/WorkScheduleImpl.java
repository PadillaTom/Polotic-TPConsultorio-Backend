package com.padillatomas.consultorio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.padillatomas.consultorio.dto.WorkScheduleDTO;
import com.padillatomas.consultorio.entity.WorkScheduleEntity;
import com.padillatomas.consultorio.mapper.WorkScheduleMapper;
import com.padillatomas.consultorio.repository.WorkScheduleRepository;
import com.padillatomas.consultorio.service.WorkScheduleService;

@Service
public class WorkScheduleImpl implements WorkScheduleService {


	// Mapper
	@Autowired
	private WorkScheduleMapper wsMapper;
	// Repository
	@Autowired
	private WorkScheduleRepository wsRepo;
	// == POST ==
	@Override
	public WorkScheduleDTO saveNewWS(WorkScheduleDTO newWS) {
		WorkScheduleEntity newEntity = wsMapper.DTO2Entity(newWS);
		WorkScheduleEntity savedEntity = wsRepo.save(newEntity);
		WorkScheduleDTO resultDTO = wsMapper.entity2DTO(savedEntity);
		return resultDTO;
	}
	// == GET ==
	// == PUT ==
	// == DELETE ==
}
