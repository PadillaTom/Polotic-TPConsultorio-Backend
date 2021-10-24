package com.padillatomas.consultorio.dto;

import lombok.Data;


@Data
public class UsuarioPersonaDto {

	// Intermedio entre Frontend//Controller y Service	
	
	// *** IDA ***
	// Controller --> Recibe JSON y con @RequestBody lo transformamos en DTO
	// DTO --> Es el JSON transformado a Java Class. Sera pasado al Service
	// Service --> Agarra el DTO y lo divide en las Java Class Necesarias(Entity) 
	// Repository --> Obtiene los metodos de DATA JPA y los utliza para subir estas 
	// 				  Java Class (Entity) a la BaseDeDatos(MYSQL)
	
	// *** VUELTA ***
	// Repository --> Pide a la BaseDeDatos la Java Class(Entity)
	// Service --> Recibe la Java Class, y la manda al Controller
	// Controller --> Enviamos la Java Class como ResponseEntity (JSON) al frontend.
	
	
	
	
	// ***************************
	//	Datos recibidos del Controller (JSON-Formulario)
	// ***************************
	// Datos USUARIO:
	private Long usuarioId;
	private String usuario;
	private String password;
	
	// Datos PERSONA:
	private String nombre;
	private String apellido;
	private String dni;
	private String telefono;	
	

	
}
