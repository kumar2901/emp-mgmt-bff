package com.kumar.fullstack.service;

import java.util.List;
import java.util.Map;

import com.kumar.fullstack.exception.DataNotFoundException;
import com.kumar.fullstack.model.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();

	public Employee saveEmployee(Employee employee);

	public Employee updateEmployee(long id, Employee employeeDetail);

	public Map<String,Boolean> deleteEmployee(long id)throws DataNotFoundException;

	public Employee getEmployeesById(long id);


}
