package com.padillatomas.consultorio.repository;

import com.padillatomas.consultorio.entity.TutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<TutorEntity, Long>{

}
