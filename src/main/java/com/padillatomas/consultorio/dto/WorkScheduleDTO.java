package com.padillatomas.consultorio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkScheduleDTO {

	private Long id;
	private String beginsAt;
	private String endsAt;
	private String day;
}
