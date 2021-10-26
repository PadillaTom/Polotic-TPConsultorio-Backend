package com.padillatomas.consultorio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.padillatomas.consultorio.dto.TestDTO;
import com.padillatomas.consultorio.service.TestService;


@RestController
@RequestMapping("test")
public class TestController {
	
	// Instance: SERVICE
	@Autowired
	private TestService testServ;

	
	// *********************
	// Metodos
	// *********************
	
	// === POST ===
	@PostMapping
	public ResponseEntity<TestDTO> saveNewEntity(@RequestBody TestDTO dto){
		TestDTO responseDTO = testServ.saveTestEntity(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
	}
	
	// === GET ===
	@GetMapping
	public ResponseEntity<List<TestDTO>> getAllTestEntities(){
		List<TestDTO> responseDTOList = testServ.getAllTests();
		return ResponseEntity.status(HttpStatus.OK).body(responseDTOList);
	}
	
	// === PUT ===
	// === DELETE ===


}
