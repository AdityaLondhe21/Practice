package com.example.demo.models.lappy;

import org.springframework.stereotype.Component;

import jakarta.annotation.Priority;

@Component("mac")
@Priority(value=3)
public class MacBook implements Laptop {
	public String toString() {
		return "Hey! You have got MAC BOOK Laptop";
	}
}
