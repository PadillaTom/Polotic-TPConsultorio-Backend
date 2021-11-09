package com.padillatomas.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.padillatomas.consultorio.entity.AppointmentEntity;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {

}
