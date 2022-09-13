package com.axpe.exercices.service.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.axpe.exercices.persistence.entities.Employee;
import com.axpe.exercices.service.dto.EmployeeDTO;

@Component
public class EmployeeMapper {

	public List<EmployeeDTO> getAllEmployeesMapper(List<Employee> employees) {

		List<EmployeeDTO> employeesDTO = new ArrayList<>();

		if (!employees.isEmpty()) {
			employees.forEach(employee -> {
				EmployeeDTO employeeDTO = new EmployeeDTO();

				employeeDTO.setId(employee.getId());
				employeeDTO.setName(employee.getName());
				employeeDTO.setSurname1(employee.getSurname1());
				employeeDTO.setSurname2(employee.getSurname2());
				employeeDTO.setEmail(employee.getEmail());
				employeeDTO.setPhone_number(employee.getPhone_number());
				employeeDTO.setNif(employee.getNif());
				employeeDTO.setNickname(employee.getNickname());
				employeeDTO.setStatus(employee.getStatus());

				employeesDTO.add(employeeDTO);
			});
		}
		return employeesDTO;
	}

}
