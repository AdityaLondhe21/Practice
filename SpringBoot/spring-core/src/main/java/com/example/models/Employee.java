package com.example.models;

import org.springframework.stereotype.Component;

public class Employee {
	private String name;
	private int age;
	private int salary;
	private String designation;
	private Address address;
	
	@Override
	public String toString() {
		System.out.println("Employee [Name : "+name+", Age : "+age+", Salary : "+salary+", Designation : "+designation+"]");
		System.out.println(address);
		return "";
	}

	public Employee(String name, int age, int salary, String designation,Address address) {
		
		System.out.println("Employee(name,age,salary,designation,address) called");

		this.name = name;
		this.age = age;
		this.salary = salary;
		this.designation = designation;
		this.address=address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Employee() {
		System.out.println("Employee() called");
	}
}
