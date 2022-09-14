package com.axpe.exercices.service;

import java.util.List;
import java.util.Optional;

import com.axpe.exercices.persistence.entities.Employee;
import com.axpe.exercices.service.dto.EmployeeAddDTO;
import com.axpe.exercices.service.dto.EmployeeDTO;

public interface EmployeeService {

	Optional<Employee> getEmployee(long id);

	boolean updateEmployee(long id, EmployeeDTO employeeDTO);

	boolean deleteEmployee(long id);

	boolean addEmployee(EmployeeAddDTO employeeDTO);

	List<EmployeeDTO> getAllEmployees();

}
