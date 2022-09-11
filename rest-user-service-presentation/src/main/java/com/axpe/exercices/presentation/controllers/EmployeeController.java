package com.axpe.exercices.presentation.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.axpe.exercices.persistence.entities.Employee;
import com.axpe.exercices.presentation.http.CustomHeaders;

public interface EmployeeController {

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	@ResponseBody
	List<Employee> getRandomData(@PathVariable(value = "id") int id,
			@RequestHeader(value = CustomHeaders.X_REQUEST_ID, required = true) UUID xRequestID);

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	@ResponseBody
	ResponseEntity<?> getAllEmployees(
			@RequestHeader(value = CustomHeaders.X_REQUEST_ID, required = true) UUID xRequestID);

}
