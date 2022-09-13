package com.axpe.exercices.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axpe.exercices.persistence.entities.Employee;
import com.axpe.exercices.persistence.repository.EmployeeRepository;
import com.axpe.exercices.service.EmployeeService;
import com.axpe.exercices.service.dto.EmployeeDTO;
import com.axpe.exercices.service.mappers.EmployeeMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public Optional<Employee> getEmployee(long id) {

		Optional<Employee> employee = employeeRepository.findById(id);

		return employee;
	}

	@Override
	public boolean updateEmployee(long id, EmployeeDTO employeeUpdated) {

		if (employeeRepository.findById(id).isPresent()) {
			Employee employeeToUpdate = new Employee();
			employeeToUpdate.setId(id);
			employeeToUpdate.setName(employeeUpdated.getName());
			employeeToUpdate.setNif("123456789J");
			employeeToUpdate.setNickname("prueba");
			employeeToUpdate.setPassword("prueba");
			employeeToUpdate.setEntry_date(new Timestamp(System.currentTimeMillis()));

			employeeRepository.save(employeeToUpdate);

			return true;
		}

		return false;
	}

	@Override
	public boolean deleteEmployee(long id) {

		Optional<Employee> employee = employeeRepository.findById(id);

		if (employee.isPresent()) {
			employeeRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean addEmployee(EmployeeDTO employeeNew) {

		List<Employee> employees = employeeRepository.findAll();

		long id = employees.get(employees.size() - 1).getId();

		Employee employeeToAdd = new Employee();
		employeeToAdd.setId(id + 1);
		employeeToAdd.setName("Juan");
		employeeToAdd.setSurname1("Juan");
		employeeToAdd.setSurname2("Juan");
		employeeToAdd.setEmail("sara@axpe.es");
		employeeToAdd.setPhone_number("+34689456126");
		employeeToAdd.setNif("123456789J");
		employeeToAdd.setNickname("prueba");
		employeeToAdd.setPassword("prueba");
		employeeToAdd.setStatus("ACTIVO");
		employeeToAdd.setEntry_date(new Timestamp(System.currentTimeMillis()));
		employeeToAdd.setCancel_date(new Timestamp(System.currentTimeMillis()));
		employeeToAdd.setModified_date(new Timestamp(System.currentTimeMillis()));

		employeeRepository.save(employeeToAdd);

		return true;
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {

		List<Employee> employees = employeeRepository.findAll();

		List<EmployeeDTO> employeesDTO = employeeMapper.getAllEmployeesMapper(employees);

		return employeesDTO;
	}

}
