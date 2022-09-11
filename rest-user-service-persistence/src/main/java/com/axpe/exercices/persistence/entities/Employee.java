package com.axpe.exercices.persistence.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class Employee {

	@Column(name = "id")
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "surname1")
	private String surname1;

	@Column(name = "surname2")
	private String surname2;

	@Column(name = "email")
	private String email;

	@Column(name = "phone_number")
	private String phone_number;

	@Column(name = "nif")
	private String nif;

	@Column(name = "nickname")
	private String nickname;

	@Column(name = "password")
	private String password;

	@Column(name = "status")
	private String status;

	@Column(name = "entry_date")
	private Timestamp entry_date;

	@Column(name = "cancel_date")
	private Timestamp cancel_date;

	@Column(name = "modified_date")
	private Timestamp modified_date;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
