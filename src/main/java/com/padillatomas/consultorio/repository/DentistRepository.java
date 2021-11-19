package com.padillatomas.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.padillatomas.consultorio.entity.DentistEntity;

import java.util.List;

@Repository
public interface DentistRepository extends JpaRepository<DentistEntity, Long> {

    public List<DentistEntity> findAllByOrderByIdDesc();

}
