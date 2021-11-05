package com.padillatomas.consultorio.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkScheduleDTO {

	private Long id;
	private Date beginsAt;
	private Date endsAt;
	private String day;
}
