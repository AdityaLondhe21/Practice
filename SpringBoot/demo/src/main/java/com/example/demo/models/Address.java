package com.example.demo.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Address {
	String state;
	String city;
	int pin;
	
	public Address() {
		System.out.println("Address created");
	}
	
	@Override
	public String toString() {
		return "Address [State : "+state+", City : "+city+", Pin Code : "+pin+"]"; 
	}
}
