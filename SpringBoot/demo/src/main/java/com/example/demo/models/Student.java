package com.example.demo.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//if no scope mentioned the object is created at the time of loading the class
//Scope prototype means new object is created after each request
@Scope("prototype")
public class Student implements Person {
	@Value("${rno}")
	int rollNo;
	@Value("${sname}")
	String name;
	@Value("${std}")
	int standard;
	
	public Student() {
		System.out.println("Student object is created");
	}
	
	@Override
	public String toString() {
		return "Student [roll no : "+rollNo+", Name : "+name+", Standard : "+standard+"]"; 
	}
}
