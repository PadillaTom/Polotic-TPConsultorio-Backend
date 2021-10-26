package com.padillatomas.consultorio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.padillatomas.consultorio.dto.TestDTO;
import com.padillatomas.consultorio.entity.TestEntity;
import com.padillatomas.consultorio.mapper.TestMapper;
import com.padillatomas.consultorio.repository.TestRepository;
import com.padillatomas.consultorio.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	
	// Instance: Mapper
	@Autowired
	private TestMapper testMapper;
	// Instance: Repository
	@Autowired
	private TestRepository testRepo;

	@Override
	public TestDTO saveTestEntity(TestDTO dto) {
		TestEntity testEntity = testMapper.TestDTO2TestEntity(dto);
		TestEntity savedEntity = testRepo.save(testEntity);
		TestDTO resultDTO = testMapper.TestEntity2TestDTO(savedEntity);
		
		return resultDTO;
	}

}
