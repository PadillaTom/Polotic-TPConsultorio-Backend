package com.padillatomas.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.padillatomas.consultorio.entity.TestEntity;

@Repository 
public interface TestRepository extends JpaRepository<TestEntity, Long>{

}
