package com.example.demo.models.lappy;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import jakarta.annotation.Priority;

@Component
@Primary
//@Priority(value=2)
public class LenovoLaptoo implements Laptop {
	public String toString() {
		return "Hey! You have got LENOVO Laptop";
	}
}
