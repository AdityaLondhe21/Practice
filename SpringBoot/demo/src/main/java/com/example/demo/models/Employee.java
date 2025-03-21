package com.example.demo.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.demo.models.lappy.Laptop;

@Component("emp")
//@Scope("prototype")
//scope singleton means only single object is created.
@Scope("singleton")   //default early instantiation
//for lazy instantiation
@Lazy
public class Employee implements Person {
	@Value("21")
	int empID;
	@Value("Ramesh")
	String name;
	@Value("24000")
	int salary;
	@Value("Programmer")
	String designation;	
	@Autowired
	Address address;
	@Autowired
	@Qualifier("mac")
	Laptop laptop;
	
	public Employee() {
		System.out.println("Employee object created");
	}
	
	@Override
	public String toString() {
		System.out.println("Employee [Employee ID : "+empID+", Name : "+name+", Salary : "+salary+", Designation : "+designation+"]");
		System.out.println(address);
		System.out.println(laptop);
		return "";
		
	}
}
