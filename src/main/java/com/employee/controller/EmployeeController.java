package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/test")
	public String test() {
		System.out.println("Service is working");
		return "Service is UP";

	}

	@GetMapping("/readAll")
	public List<Employee> readAllEmployee() {

		List<Employee> employeeList = employeeService.readAllEmployee();
		return employeeList;
	}

	@GetMapping("/{employeeId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long employeeId){
		return ResponseEntity.ok().body(employeeService.getEmployeeById(employeeId));
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {

		return ResponseEntity.ok().body(this.employeeService.createEmployee(employee));

	}

	public ResponseEntity<Employee>  updateEmployee(@PathVariable long employeeId,  @RequestBody Employee employee) {
		
		employee.setId(employeeId);
		return ResponseEntity.ok().body(employeeService.updateEmployee(employee));

	}

	@DeleteMapping("/{employeeId}")	
	public HttpStatus deleteEmployeebyId(@PathVariable long employeeId){
		this.employeeService.deleteEmployeebyId(employeeId);
		return HttpStatus.OK;
	}
	

}
