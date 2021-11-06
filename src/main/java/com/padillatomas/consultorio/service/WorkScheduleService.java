package com.padillatomas.consultorio.service;

import com.padillatomas.consultorio.dto.WorkScheduleDTO;

public interface WorkScheduleService {
	
	// Post
	WorkScheduleDTO saveNewWS(Long dentistId, WorkScheduleDTO newWS);

	// Put
	WorkScheduleDTO editById(Long id, WorkScheduleDTO newData);

	// Delete
	void softDeleteById(Long scheduleId, Long dentistId);

}
