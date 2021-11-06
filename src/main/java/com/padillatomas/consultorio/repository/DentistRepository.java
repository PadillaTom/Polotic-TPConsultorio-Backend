package com.padillatomas.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.padillatomas.consultorio.entity.DentistEntity;

@Repository
public interface DentistRepository extends JpaRepository<DentistEntity, Long> {


}
