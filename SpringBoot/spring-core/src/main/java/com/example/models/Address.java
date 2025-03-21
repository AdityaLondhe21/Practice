package com.example.models;

import org.springframework.stereotype.Component;

public class Address {
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	private String state;
	private String city;
	private int pin;
	@Override
	public String toString() {
		return "Address [state=" + state + ", city=" + city + ", pin=" + pin + "]";
	}
	public Address() {
		System.out.println("Address() constructor");
	}
	public Address(String state, String city, int pin) {
		System.out.println("Address(state,city,pin) constructor");
		this.state = state;
		this.city = city;
		this.pin = pin;
	}
	
}
