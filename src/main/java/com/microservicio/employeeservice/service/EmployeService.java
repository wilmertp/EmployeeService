package com.microservicio.employeeservice.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservicio.employeeservice.dto.DepartmentDTO;
import com.microservicio.employeeservice.dto.ResponseDTO;
import com.microservicio.employeeservice.entity.Employee;
import com.microservicio.employeeservice.repository.EmployeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeService {
	
	private final EmployeRepository employeRepository;
	private final RestTemplate restTemplate;
	
	public Employee saveEmploye(Employee employee) {
		return employeRepository.save(employee);
	}
	
	public ResponseDTO getEmployeById(Integer id) {
		
		ResponseDTO responseDTO = new ResponseDTO();
		Employee employee = new Employee();
		employee = employeRepository.findById(id).get();
		
		ResponseEntity<DepartmentDTO> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentId(), DepartmentDTO.class);
		
		DepartmentDTO departmentDTO = responseEntity.getBody();
		
		responseDTO.setEmployee(employee);
		responseDTO.setDepartmentDTO(departmentDTO);
		
		return responseDTO;
	}

}
