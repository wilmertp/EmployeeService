package com.microservicio.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservicio.employeeservice.entity.Employee;

public interface EmployeRepository extends JpaRepository<Employee, Integer>{

}
