package com.axpe.exercices.service;

import java.util.List;
import java.util.Optional;

import com.axpe.exercices.persistence.entities.Employee;
import com.axpe.exercices.service.dto.EmployeeAddDTO;
import com.axpe.exercices.service.dto.EmployeeDTO;
import com.axpe.exercices.service.dto.EmployeeUpdateDTO;

public interface EmployeeService {

	EmployeeDTO getEmployee(long id);

	boolean updateEmployee(long id, EmployeeUpdateDTO employeeDTO);

	boolean deleteEmployee(long id);

	boolean addEmployee(EmployeeAddDTO employeeDTO);

	List<EmployeeDTO> getAllEmployees();

}
