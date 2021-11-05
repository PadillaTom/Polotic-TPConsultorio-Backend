package com.padillatomas.consultorio.service;

import com.padillatomas.consultorio.dto.ResponsableDTO;

public interface ResponsableService {

	// Post
	ResponsableDTO saveNewResponsable(Long patientId, ResponsableDTO newResponsable);

}
