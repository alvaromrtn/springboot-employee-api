package com.axpe.exercices.service.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class EmployeeDTO {

	private Long id;

	private String name;

	private String surname1;

	private String surname2;

	private String email;

	private String phone_number;

	private String nif;

	private String nickname;

	private String password;

	private String status;

	private Timestamp entry_date;

	private Timestamp cancel_date;

	private Timestamp modified_date;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
