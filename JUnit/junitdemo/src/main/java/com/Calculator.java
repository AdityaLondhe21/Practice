package com;

public class Calculator {
	public int add(int a,int b) {
		return a+b;
	}
	public int sub(int a,int b) {
		return a-b;
	}
	public int mul(int a,int b) {
		return a*b;
	}
	public int div(int a,int b) throws ArithmeticException{
		if(b!=0) {
			return a/b;
		}
		throw new ArithmeticException();
	}
	public int mod(int a,int b) {
		return a%b;
	}
}
