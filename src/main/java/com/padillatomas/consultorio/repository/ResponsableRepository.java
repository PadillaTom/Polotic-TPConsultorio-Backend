package com.padillatomas.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.padillatomas.consultorio.entity.ResponsableEntity;

@Repository
public interface ResponsableRepository extends JpaRepository<ResponsableEntity, Long>{

}
