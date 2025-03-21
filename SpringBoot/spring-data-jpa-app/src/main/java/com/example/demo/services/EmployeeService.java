package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Employee;
import com.example.demo.repos.EmpDao;

@Service
public class EmployeeService {
	@Autowired
	EmpDao dao;
	
	public Iterable<Employee> getEmployee() {
		return  dao.findAll();
	}
	
	public Optional<Employee> getEmployeeByID(int id) {
		return dao.findById(id);
	}
	
	public String addEmployee(Employee e) {
		if(dao.existsById(e.getEid()))
			return "Sorry ! Already the employee exists with given ID";
		dao.save(e);
		return  "Added employee record successfully...";
	}
	public String updateEmployee(Employee e, int id  ) {
		if(!dao.existsById(id)) {
			return "Sorry ! Employee does not exist for given ID to Update";
		}
		dao.save(e);
		return  "Updated employee record successfully...";	
	}
	
	public String deleteEmployee(int id  ) {
		if(!dao.existsById(id)) {
			return "Sorry ! Employee does not exist for given ID to Delete";
		}
		dao.deleteById(id);
		return  "Removed employee record successfully...";	
	}
	
	public List<Employee> getEmployeeByDesig(String desig){
		return dao.getByDesignation(desig);
	}
	
	public List<Employee> getEmployeeAbove(int age){
		return dao.findByAgeGreaterThan(age);
	}
	
	public List<Employee> getEmployeeBelow(int age){
		return dao.findByAgeLessThan(age);
	}
	
	public List<Employee> getCustomQuery(String desig){
		return dao.myCustomQuery(desig);
	}
	
}
