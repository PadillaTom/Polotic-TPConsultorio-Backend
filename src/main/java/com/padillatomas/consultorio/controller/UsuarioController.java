package com.padillatomas.consultorio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.padillatomas.consultorio.dto.UsuarioPersonaDto;
import com.padillatomas.consultorio.service.UsuarioService;

@RestController
public class UsuarioController {
	
	// Instanciamos: SERVICE
	@Autowired
	private UsuarioService usuSer;
	
	
	// *********************
	// Metodos
	// *********************
	
	@GetMapping
	public List<UsuarioPersonaDto> traerAllUsuarioPersona(){
		return usuSer.traerTodasPersonas();
	}

}
