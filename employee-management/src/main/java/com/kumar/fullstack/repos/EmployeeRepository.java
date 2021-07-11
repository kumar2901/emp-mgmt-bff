package com.kumar.fullstack.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kumar.fullstack.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
