package com.example.demo;

import org.springframework.beans.factory.annotation.Value;

public class Student {
	int rollNo;
	String name;
	int standard;
	
	public Student() {
		System.out.println("Student() called");
	}
	@Override
	public String toString() {
		return "Student [roll no : "+rollNo+", Name : "+name+", Standard : "+standard+"]"; 
	}
}
