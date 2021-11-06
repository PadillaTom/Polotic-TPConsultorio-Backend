package com.padillatomas.consultorio.service;

import java.util.List;

import com.padillatomas.consultorio.dto.dentist.DentistBasicDTO;
import com.padillatomas.consultorio.dto.dentist.DentistCompleteDTO;

public interface DentistService {

	// Post
	DentistBasicDTO saveNewDentist(DentistBasicDTO newDentist);

	// Get
	List<DentistBasicDTO> getBasicDentist();
	DentistCompleteDTO getDetailsById(Long id);

	// Put
	DentistCompleteDTO editById(Long id, DentistCompleteDTO newData);

	// Delete
	void softDeleteById(Long id);


}
