package com.axpe.exercices.service.impl;

import java.sql.Timestamp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.axpe.exercices.persistence.entities.Employee;
import com.axpe.exercices.persistence.repository.EmployeeRepository;
import com.axpe.exercices.service.EmployeeService;
import com.axpe.exercices.service.dto.EmployeeAddDTO;
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

		Optional<Employee> employee = employeeRepository.findById(id);

		if (employee.isPresent()) {
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
			Employee employeeToDelete = employee.get();

			employeeToDelete.setStatus("ELIMINADO");
			employeeToDelete.setCancel_date(new Timestamp(System.currentTimeMillis()));

			employeeRepository.save(employeeToDelete);

			return true;
		}

		return false;
	}

	@Override
	public boolean addEmployee(EmployeeAddDTO employeeNew) {

		Employee employeeToAdd = employeeMapper.addEmployeeMapper(employeeNew);

		employeeToAdd.setId(employeeRepository.count() + 1);

		// Encrypt password:
		String salt = BCrypt.gensalt(10);
		String hashedPassword = BCrypt.hashpw(employeeToAdd.getPassword(), salt);
		employeeToAdd.setPassword(hashedPassword);

		employeeToAdd.setStatus("ACTIVO");
		employeeToAdd.setEntry_date(new Timestamp(System.currentTimeMillis()));

		employeeRepository.save(employeeToAdd);

		return true;
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {

		List<Employee> employeesActive = employeeRepository.findAllActive();

		List<EmployeeDTO> employeesDTO = employeeMapper.getAllEmployeesMapper(employeesActive);

		return employeesDTO;
	}

}
