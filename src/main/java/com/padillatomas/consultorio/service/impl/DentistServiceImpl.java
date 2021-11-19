package com.padillatomas.consultorio.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.padillatomas.consultorio.dto.dentist.DentistBasicDTO;
import com.padillatomas.consultorio.dto.dentist.DentistCompleteDTO;
import com.padillatomas.consultorio.entity.DentistEntity;
import com.padillatomas.consultorio.mapper.DentistMapper;
import com.padillatomas.consultorio.repository.DentistRepository;
import com.padillatomas.consultorio.service.DentistService;

@Service
public class DentistServiceImpl implements DentistService {

	// Mapper:
	@Autowired
	private DentistMapper dentistMapper;
	
	// Repository:
	@Autowired
	private DentistRepository dentistRepo;
	
	// == POST ==
	@Override
	public DentistBasicDTO saveNewDentist(DentistBasicDTO newDentist) {
		DentistEntity newEnt = dentistMapper.basicDTO2Entity(newDentist);
		DentistEntity savedEnt = dentistRepo.save(newEnt);
		DentistBasicDTO resultDTO = dentistMapper.entity2BasicDTO(savedEnt);
		return resultDTO;
	}
	
	// == GET ==
	@Override
	public List<DentistBasicDTO> getBasicDentist() {
		// TODO Optional
		List<DentistEntity> savedDentists = dentistRepo.findAllByOrderByIdDesc();
		List<DentistBasicDTO> basicDentists = dentistMapper.entityList2BasicDTOList(savedDentists);
		return basicDentists;
	}
	
	@Override
	public DentistCompleteDTO getDetailsById(Long id) {
		// TODO Optional
		// TODO Error
		DentistEntity savedEntity = dentistRepo.getById(id);
		DentistCompleteDTO resultDTO = dentistMapper.entity2DTO(savedEntity);
		return resultDTO;
	}
	
	// == PUT ==
	@Override
	public DentistCompleteDTO editById(Long id, DentistCompleteDTO newData) {	
		// TODO Optional -  EDIT Turno
		DentistEntity foundDentist = dentistRepo.getById(id);
		// TODO Error if not found by Id
		
		foundDentist.setDni(newData.getDni());
		foundDentist.setFirstName(newData.getFirstName());
		foundDentist.setLastName(newData.getLastName());
		foundDentist.setBirthDate(this.string2LocalDate(newData.getBirthDate()));
		foundDentist.setAddress(newData.getAddress());
		foundDentist.setPhoneNumber(newData.getPhoneNumber());
		foundDentist.setEmail(newData.getEmail());
		foundDentist.setSpeciality(newData.getSpeciality());
		DentistEntity editedDentist = dentistRepo.save(foundDentist);
		DentistCompleteDTO resultDTO = dentistMapper.entity2DTO(editedDentist);
		return resultDTO;		
	}

	private LocalDate string2LocalDate(String birthDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		LocalDate formattedDate = LocalDate.parse(birthDate, formatter);	
		return formattedDate;
	}

	// == DELETE ==
	@Override
	public void softDeleteById(Long id) {
		// TODO Optional?
		dentistRepo.deleteById(id);		
	}	
	
	
}
