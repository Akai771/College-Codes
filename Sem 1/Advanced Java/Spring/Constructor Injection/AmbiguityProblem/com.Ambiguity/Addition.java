package com.Ambiguity;

public class Addition {
	private int a;
	private int b;
	
	public Addition(double a, double b) {
		super();
		this.a = (int) a;
		this.b = (int) b;
		System.out.println("Constructor double, double called");
	}
	
	public Addition(int a, int b) {
		super();
		this.a = a;
		this.b = b;
		System.out.println("Constructor int, int called");
	}
	
	public Addition(String a, String b) {
		super();
		this.a = Integer.parseInt(a);
		this.b = Integer.parseInt(b);
		System.out.println("Constructor String, String called");
	}
	
	@Override
	public String toString() {
		System.out.println("a = " + this.a);
		System.out.println("b = " + this.b);
		return "Addition [a=" + a + ", b=" + b + ", a+b=" + (a+b) +"]";
	}
}