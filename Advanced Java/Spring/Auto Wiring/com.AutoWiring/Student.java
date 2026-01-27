package com.AutoWiring;

public class Student {
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		System.out.println("Setter called");
		this.address = address;
	}
	
	public Student(Address address) {
		super();
		System.out.println("Constructor called");
		this.address = address;
	}

	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Student [address=" + address + "]";
	}
}