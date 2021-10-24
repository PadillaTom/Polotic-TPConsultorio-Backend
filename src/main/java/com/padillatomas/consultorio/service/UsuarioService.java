package com.padillatomas.consultorio.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.padillatomas.consultorio.dto.UsuarioPersonaDto;
import com.padillatomas.consultorio.entity.Usuario;
import com.padillatomas.consultorio.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	// Instanciamos REPOSITORY: par poder usar sus metodos:
	@Autowired
	private UsuarioRepository usuRepo;
	
	// *********************
	// Metodos
	// *********************
	// Convertir Java Class (Entity) a DTO
	// Para poder ser pasada a Front:
	private UsuarioPersonaDto convertirEntityToDto(Usuario usu) {
		UsuarioPersonaDto usuPersoDto = new UsuarioPersonaDto();
		// Usuario:
		usuPersoDto.setUsuarioId(usu.getId());
		usuPersoDto.setUsuario(usu.getUsuario());
		usuPersoDto.setPassword(usu.getPassword());
		// Persona:
		usuPersoDto.setNombre(usu.getUsuPersona().getNombre());
		usuPersoDto.setApellido(usu.getUsuPersona().getApellido());
		usuPersoDto.setDni(usu.getUsuPersona().getDni());
		usuPersoDto.setTelefono(usu.getUsuPersona().getTelefono());
		
		return usuPersoDto;
	}

	
	// === GET ===
	public List<UsuarioPersonaDto> traerTodasPersonas(){
		return usuRepo.findAll()
				.stream()
				.map(this::convertirEntityToDto)
				.collect(Collectors.toList());
				
	}
	
	// === POST ===
	
	
	
	
}
