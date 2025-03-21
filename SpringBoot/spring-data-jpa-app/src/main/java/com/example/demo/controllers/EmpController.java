package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.Bindable.BindRestriction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employee;
import com.example.demo.repos.EmpDao;
import com.example.demo.services.EmployeeService;

import jakarta.websocket.server.PathParam;

@RestController
public class EmpController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("/employees")
	public Iterable<Employee> getEmployee() {
		return  service.getEmployee();
	}
	
	@GetMapping("/employees/{id}")
	public Optional<Employee> getEmployeeByID(@PathVariable int id) {
		return service.getEmployeeByID(id);
	}
	
	@PostMapping("/employees")
	public String addEmployee(@RequestBody Employee e) {
		return  service.addEmployee(e);
	}
//	@PutMapping("/employees/{id}")
//	@PatchMapping("/employees/{id}")
//	Club more than 1 http methods
	@RequestMapping(path="/employees/{id}", method = {RequestMethod.PUT ,RequestMethod.PATCH})
	public String updateEmployee(@RequestBody Employee e, @PathVariable int id  ) {
		return  service.updateEmployee(e, id);	
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id  ) {
		return  service.deleteEmployee(id);	
	}
	
	@GetMapping("/employees/role")
	public List<Employee> getEmployeeByDesig(@RequestParam String desig){
		return service.getEmployeeByDesig(desig);
	}
	
	@GetMapping("/employees/above")
	public List<Employee> getEmployeeAbove(@RequestParam int age){
		return service.getEmployeeAbove(age);
	}
	
	@GetMapping("/employees/below")
	public List<Employee> getEmployeeBelow(@RequestParam int age){
		return service.getEmployeeBelow(age);
	}
	
	@GetMapping("/employees/custom")
	public List<Employee> getCustomQuery(@RequestParam String desig){
		return service.getCustomQuery(desig);
	}
	
}
