package com.padillatomas.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.padillatomas.consultorio.entity.PatientEntity;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

    public List<PatientEntity> findAllByOrderByIdDesc();

}
