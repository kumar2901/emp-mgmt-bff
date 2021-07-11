package com.kumar.fullstack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kumar.fullstack.exception.DataNotFoundException;
import com.kumar.fullstack.model.Employee;
import com.kumar.fullstack.service.EmployeeService;

@CrossOrigin(origins= {"http://localhost:3000"})
@RestController
@RequestMapping("api/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>>fetchAllEmployees(){
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}
	
	@GetMapping("employee/{id}")
	public ResponseEntity<Employee>getEmployeeById(@PathVariable long id){
		return ResponseEntity.ok(employeeService.getEmployeesById(id));
	}
	
	@PostMapping("/employee")
	public ResponseEntity<Employee>saveEmployee(@RequestBody Employee employee){
		return ResponseEntity.ok(employeeService.saveEmployee(employee));
	}
	
	@PutMapping("employee/{id}")
	public ResponseEntity<Employee>updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetail){
		Employee employee=employeeService.updateEmployee(id,employeeDetail);
		return ResponseEntity.ok(employee);
	}
	
	@DeleteMapping("employee/{id}")
	public ResponseEntity<Map<String,Boolean>>deleteEmployee(@PathVariable long id){
		try {
			return ResponseEntity.ok(employeeService.deleteEmployee(id));
		}catch(DataNotFoundException de) {
			de.printStackTrace();
		}
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted", false);
		return ResponseEntity.ok(response);
	}
}

