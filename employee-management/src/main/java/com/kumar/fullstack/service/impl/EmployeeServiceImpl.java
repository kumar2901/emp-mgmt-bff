package com.kumar.fullstack.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kumar.fullstack.exception.DataNotFoundException;
import com.kumar.fullstack.model.Employee;
import com.kumar.fullstack.repos.EmployeeRepository;
import com.kumar.fullstack.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(long id, Employee employeeDetail){
		try {
			Employee employee=employeeRepository.findById(id).orElseThrow(()->new DataNotFoundException("Employee not found for id "+id));
			employee.setFirstName(employeeDetail.getFirstName());
			employee.setLastName(employeeDetail.getLastName());
			employee.setEmailId(employeeDetail.getEmailId());
			
			return employeeRepository.save(employee);
		} catch (DataNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<String,Boolean> deleteEmployee(long id) throws DataNotFoundException {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new DataNotFoundException("Employee not exist with id :" + id));
		
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@Override
	public Employee getEmployeesById(long id) {
		Employee employee=null;
		try {
			employee = employeeRepository.findById(id)
					.orElseThrow(() -> new DataNotFoundException("Employee not exist with id :" + id));
		} catch (DataNotFoundException e) {
			e.printStackTrace();
		}
		return employee;
	}

}
