package com.padillatomas.consultorio.service;

import java.util.List;

import com.padillatomas.consultorio.dto.TestDTO;

public interface TestService {

	TestDTO saveTestEntity(TestDTO dto);

	List<TestDTO> getAllTests();
}
