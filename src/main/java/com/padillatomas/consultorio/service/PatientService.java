package com.padillatomas.consultorio.service;

import com.padillatomas.consultorio.dto.patient.PatientCompleteDTO;

public interface PatientService {

	PatientCompleteDTO saveNewPatient(PatientCompleteDTO newPatient);

}
