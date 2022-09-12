package com.axpe.exercices.presentation.controllers.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.axpe.exercices.persistence.entities.Employee;
import com.axpe.exercices.presentation.controllers.EmployeeController;
import com.axpe.exercices.service.EmployeeService;

@Controller
public class EmployeeControllerImpl implements EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Override
	public ResponseEntity<?> getEmployee(int id, UUID xRequestID) {

		System.out.println("HOLA");
		System.out.println("HOLA");
		System.out.println("HOLA");

		return null;
	}

	@Override
	public ResponseEntity<?> updateEmployee(int id, UUID xRequestID, RequestEntity<?> data) {

		System.out.println("HOLA");
		System.out.println("HOLA");
		System.out.println("HOLA");

		return null;
	}

	@Override
	public ResponseEntity<?> deleteEmployee(int id, UUID xRequestID) {

		System.out.println("HOLA");
		System.out.println("HOLA");
		System.out.println("HOLA");

		return null;
	}

	@Override
	public ResponseEntity<?> addEmployee(UUID xRequestID, RequestEntity<?> data) {

		System.out.println("HOLA");
		System.out.println("HOLA");
		System.out.println("HOLA");

		return null;
	}

	@Override
	public ResponseEntity<?> getAllEmployees(UUID xRequestID) {

		System.out.println("HOLA");
		System.out.println("HOLA");
		System.out.println("HOLA");

		List<Employee> employees = employeeService.getAllEmployees();

		if (employees.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(employees);
		}
	}

}
