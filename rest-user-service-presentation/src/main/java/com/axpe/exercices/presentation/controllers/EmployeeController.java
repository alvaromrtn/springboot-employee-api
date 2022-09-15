package com.axpe.exercices.presentation.controllers;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.axpe.exercices.presentation.http.CustomHeaders;
import com.axpe.exercices.service.dto.EmployeeAddDTO;
import com.axpe.exercices.service.dto.EmployeeDTO;

public interface EmployeeController {

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	@ResponseBody
	ResponseEntity<?> getEmployee(@PathVariable(value = "id", required = true) long id,
			@RequestHeader(value = CustomHeaders.X_REQUEST_ID, required = true) UUID xRequestID);

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.PATCH)
	@ResponseBody
	ResponseEntity<?> updateEmployee(@PathVariable(value = "id", required = true) long id,
			@RequestHeader(value = CustomHeaders.X_REQUEST_ID, required = true) UUID xRequestID,
			@RequestBody EmployeeDTO employeeDTO);

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	ResponseEntity<?> deleteEmployee(@PathVariable(value = "id", required = true) long id,
			@RequestHeader(value = CustomHeaders.X_REQUEST_ID, required = true) UUID xRequestID);

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	@ResponseBody
	ResponseEntity<?> addEmployee(@RequestHeader(value = CustomHeaders.X_REQUEST_ID, required = true) UUID xRequestID,
			@RequestBody EmployeeAddDTO employeeDTO);

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	@ResponseBody
	ResponseEntity<?> getAllEmployees(
			@RequestHeader(value = CustomHeaders.X_REQUEST_ID, required = true) UUID xRequestID);

	// BORRAR:
	@RequestMapping(value = "/employeesTodo", method = RequestMethod.GET)
	@ResponseBody
	ResponseEntity<?> getAllEmployeesTodo(
			@RequestHeader(value = CustomHeaders.X_REQUEST_ID, required = true) UUID xRequestID);

}
