package com.padillatomas.consultorio.service;

import com.padillatomas.consultorio.dto.AppointmentDTO;

public interface AppointmentService {

	AppointmentDTO saveNewAppointment(Long patientId, Long dentistId, AppointmentDTO newAppo);

}
