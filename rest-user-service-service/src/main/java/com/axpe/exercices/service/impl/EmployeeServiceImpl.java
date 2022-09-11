package com.axpe.exercices.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axpe.exercices.persistence.entities.Employee;
import com.axpe.exercices.persistence.repository.EmployeeRepository;
import com.axpe.exercices.service.EmployeeService;
import com.axpe.exercices.service.mappers.ModelMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
    private ModelMapper modelMapper;

	@Override
	public List<Employee> getAllEmployees() {

		List<Employee> employees = employeeRepository.findAll();

		return employees;
	}

}
