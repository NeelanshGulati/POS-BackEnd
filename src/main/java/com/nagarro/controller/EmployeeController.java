package com.nagarro.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.nagarro.model.Employee;
import com.nagarro.service.EmployeeService;

@CrossOrigin("*")
@Path("/")
@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeController {
	private EmployeeService employeeService = new EmployeeService();

	@GET
	@Path("/employees")
	public List<Employee> getEmployee() {
		List<Employee> employees = employeeService.getAllEmployees();
		return employees;
	}

	@GET
	@Path("/employees/count")
	public int countEmployee() {
		return employeeService.totalEmployee();
	}
	
	@GET
	@Path("/employees/{employeeCode}")
	public Employee getEmployee(@PathParam("employeeCode") int employeeCode) {
		Employee employee = employeeService.getEmployee(employeeCode);
		return employee;
	}

	@POST
	@Path("/employees")
	public Employee addEmployee(Employee employee) {
		employeeService.addEmployee(employee);
		return employee;
	}

	@PUT
	@Path("/employees")
	public Employee updateEmployee(Employee employee) {
		employeeService.updateEmployee(employee);
		return employee;
	}

	@DELETE
	@Path("/employees/{employeeCode}")
	public Employee deleteEmployee(@PathParam("employeeCode") int employeeCode) {
		Employee employee = employeeService.deleteEmployee(employeeCode);
		return employee;
	}
}