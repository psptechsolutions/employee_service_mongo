package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.exception.ResourceNotFoundException;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> readAllEmployee() {
		return employeeRepository.findAll();
	}


	public List<Employee> getEmployeeById() {
		return employeeRepository.findAll();
	}
	
	public Employee createEmployee(Employee employee) {

		return employeeRepository.save(employee);

	}

	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public void deleteEmployee(Employee employee) {
		employeeRepository.delete(employee);
	}


	public Employee getEmployeeById(long employeeId) {
		Optional<Employee> employee = this.employeeRepository.findById(employeeId);

		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + employeeId);
		}
	}


	public void deleteEmployeebyId(long employeeId) {
		Optional<Employee> employee = this.employeeRepository.findById(employeeId);

		if (employee.isPresent()) {
			this.employeeRepository.delete(employee.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + employeeId);
		}

	}

}
