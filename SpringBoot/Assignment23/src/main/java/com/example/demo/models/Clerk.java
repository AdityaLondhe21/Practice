package com.example.demo.models;

import org.springframework.stereotype.Component;

@Component
public final class Clerk extends Employee{

	private Clerk() {
		this.setSalary(20000);
		this.setDesignation("CLERK");
	}
	private Clerk(String name,int age,int ID) {
		super(name,"CLERK",20000,age,ID);
	}
	
	private Clerk(int ID) {
		super(ID,"CLERK",20000);
	}
	public static Clerk getClerk(int ID) {
		return new Clerk(ID);
	}
	
	private Clerk(String name,String designation,int salary,int age,int empID) {
		super(name,designation,salary,age,empID);
	}
	public static Clerk loadClerk(String name,String designation,int salary,int age,int empID) {
		return new Clerk(name,designation,salary,age,empID);
	}
	public void raiseSalary() {
		this.setSalary(this.getSalary()+2000);
	}
}
