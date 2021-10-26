package com.padillatomas.consultorio.mapper;

import org.springframework.stereotype.Component;

import com.padillatomas.consultorio.dto.TestDTO;
import com.padillatomas.consultorio.entity.TestEntity;

@Component
public class TestMapper {

	// DTO --> Entity
	public TestEntity TestDTO2TestEntity(TestDTO dto) {
		TestEntity newEntity = new TestEntity();
		
		newEntity.setName(dto.getName());
		newEntity.setIsTest(dto.getIsTest());
		
		return newEntity;
	}

	// Entity --> DTO
	public TestDTO TestEntity2TestDTO(TestEntity savedEntity) {
		TestDTO newDTO = new TestDTO();
		
		newDTO.setId(savedEntity.getId());
		newDTO.setName(savedEntity.getName());
		newDTO.setIsTest(savedEntity.getIsTest());
		
		return newDTO;
	}

}
