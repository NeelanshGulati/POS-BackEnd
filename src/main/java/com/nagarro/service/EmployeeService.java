package com.nagarro.service;

import java.util.List;

import com.nagarro.model.Employee;
import com.nagarro.repository.EmployeeRepository;

public class EmployeeService {
	EmployeeRepository employeeRepository = new EmployeeRepository();

	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = employeeRepository.getEmployees();

		if (employeeList == null) {
			System.err.println("Empty List found!");
		}
		return employeeList;
	}

	public Employee getEmployee(int employeeCode) {
		Employee employee = employeeRepository.getEmployee(employeeCode);
		if (employee == null) {
			System.err.println("Employee not found!");
		}
		return employee;
	}

	public void addEmployee(Employee employee) {
		employeeRepository.addEmployee(employee);
	}

	public void updateEmployee(Employee employee) {
		employeeRepository.updateEmployee(employee);
	}

	public Employee deleteEmployee(int employeeCode) {
		Employee employee = employeeRepository.deleteEmployee(employeeCode);
		return employee;
	}

	public int totalEmployee() {
		return employeeRepository.totalEmployee();
	}
}
