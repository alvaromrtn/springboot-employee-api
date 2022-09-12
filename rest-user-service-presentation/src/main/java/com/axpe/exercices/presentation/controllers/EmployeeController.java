package com.axpe.exercices.presentation.controllers;

import java.util.UUID;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.axpe.exercices.presentation.http.CustomHeaders;

public interface EmployeeController {

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	ResponseEntity<?> getEmployee(@PathVariable(value = "id") int id,
			@RequestHeader(value = CustomHeaders.X_REQUEST_ID, required = true) UUID xRequestID);

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.PATCH)
	ResponseEntity<?> updateEmployee(@PathVariable(value = "id") int id,
			@RequestHeader(value = CustomHeaders.X_REQUEST_ID, required = true) UUID xRequestID,
			@RequestBody RequestEntity<?> data);

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
	ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") int id,
			@RequestHeader(value = CustomHeaders.X_REQUEST_ID, required = true) UUID xRequestID);

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	ResponseEntity<?> addEmployee(@RequestHeader(value = CustomHeaders.X_REQUEST_ID, required = true) UUID xRequestID,
			@RequestBody RequestEntity<?> data);

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	ResponseEntity<?> getAllEmployees(
			@RequestHeader(value = CustomHeaders.X_REQUEST_ID, required = true) UUID xRequestID);

}
