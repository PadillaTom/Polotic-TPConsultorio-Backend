package com.padillatomas.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.padillatomas.consultorio.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
	
	// Repositorio va a EXTENDER (Recibir los mismos Metodos y Atributos) que DATA JPA.
	// Lo vamos a usar para Mandar Java Class(Entity) a la BaseDeDatos(MYSQL).
	
	// Ejepmlo: PersonaRepository tendra los metodos de DataJPA
	// save()
	// delete()
	// findById()
		
	// Crearemos uno, por cada Class(Entidad) que necesitemos en la BaseDeDatos(MYSQL)
	

}
