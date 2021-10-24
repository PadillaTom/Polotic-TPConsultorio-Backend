package com.padillatomas.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.padillatomas.consultorio.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
