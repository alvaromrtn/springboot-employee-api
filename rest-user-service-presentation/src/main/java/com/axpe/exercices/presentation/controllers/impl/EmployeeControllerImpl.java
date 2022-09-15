package com.axpe.exercices.presentation.controllers.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ResponseStatusException;

import com.axpe.exercices.persistence.entities.Employee;
import com.axpe.exercices.persistence.repository.EmployeeRepository;
import com.axpe.exercices.presentation.controllers.EmployeeController;
import com.axpe.exercices.service.EmployeeService;
import com.axpe.exercices.service.dto.EmployeeAddDTO;
import com.axpe.exercices.service.dto.EmployeeDTO;
import com.axpe.exercices.service.dto.EmployeeUpdateDTO;
import com.axpe.exercices.util.exception.ErrorMessage;
import com.axpe.exercices.util.exception.TypeErrorEnum;

@Controller
public class EmployeeControllerImpl implements EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Override
	public ResponseEntity<?> getEmployee(long id, UUID xRequestID) {

		Optional<Employee> employee = employeeService.getEmployee(id);

		if (employee.isEmpty()) {
			//super("No se puede encontrar el empleado con la ID: " + id);
			ErrorMessage errorMessage = new ErrorMessage();
			errorMessage.setCode("123");
			errorMessage.setDescription("prueba");
			errorMessage.setMessage("prueba");
			errorMessage.setType(TypeErrorEnum.ERROR);
			return ResponseEntity.badRequest().body(errorMessage);
		} else {
			return ResponseEntity.ok(employee);
		}
	}

	@Override
	public ResponseEntity<?> updateEmployee(long id, UUID xRequestID, EmployeeUpdateDTO employeeDTO) {

		boolean isUpdated = employeeService.updateEmployee(id, employeeDTO);

		if (isUpdated) {
			return ResponseEntity.ok(HttpStatus.CREATED);
		} else {
			//super("No se puede encontrar el empleado con la ID: " + id);
			return ResponseEntity.notFound().build();
		}
	}

	@Override
	public ResponseEntity<?> deleteEmployee(long id, UUID xRequestID) {

		boolean isDeleted = employeeService.deleteEmployee(id);

		if (isDeleted) {
			return ResponseEntity.ok(HttpStatus.OK);
		} else {
			//super("No se puede encontrar el empleado con la ID: " + id);
			return ResponseEntity.notFound().build();
		}
	}

	@Override
	public ResponseEntity<?> addEmployee(UUID xRequestID, EmployeeAddDTO employeeDTO) {

		boolean isAdded = employeeService.addEmployee(employeeDTO);

		if (isAdded) {
			return ResponseEntity.ok(HttpStatus.CREATED);
		} else {
			//super("No se puede encontrar el empleado con la ID: " + id);
			return ResponseEntity.notFound().build();
		}
	}

	@Override
	public ResponseEntity<?> getAllEmployees(UUID xRequestID) {

		List<EmployeeDTO> employees = employeeService.getAllEmployees();

		if (employees.isEmpty()) {
			ErrorMessage errorMessage = new ErrorMessage();
			errorMessage.setCode(null);
			errorMessage.setDescription(null);
			errorMessage.setMessage(null);
			errorMessage.setType(null);
			return ResponseEntity.badRequest().body(errorMessage);
		} else {
			return ResponseEntity.ok(employees);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////////////////
	
	// BORRAR:
		@Autowired
		private EmployeeRepository employeeRepository;
		
	// BORRAR:
	@Override
	public ResponseEntity<?> getAllEmployeesTodo(UUID xRequestID) {

		List<Employee> employees = employeeRepository.findAll();

		if (employees.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(employees);
		}
	}

}
