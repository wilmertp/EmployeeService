package com.microservicio.employeeservice.controller;

import org.springframework.web.bind.annotation.*;

import com.microservicio.employeeservice.dto.ResponseDTO;
import com.microservicio.employeeservice.entity.Employee;
import com.microservicio.employeeservice.service.EmployeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employes")
@AllArgsConstructor
public class EmployeController {

	private final EmployeService employeService;
	
	@PostMapping
	public Employee saveEmploye(@RequestBody Employee employee) {
		return employeService.saveEmploye(employee);
	}
	
	@GetMapping("/{id}")
	public ResponseDTO getEmployeById(@PathVariable Integer id) {
		return employeService.getEmployeById(id);
	}

}
