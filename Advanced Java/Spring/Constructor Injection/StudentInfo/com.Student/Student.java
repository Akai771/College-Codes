package com.Student;

public class Student {
	String name;
	String rollNo;
	String std;
	Address address;
	
	public String getName() {
		return name;
	}

	public String getRollNo() {
		return rollNo;
	}

	public String getStd() {
		return std;
	}

	public Address getAddress() {
		return address;
	}

	public Student(String name, String rollNo, String std, Address address) {
		super();
		this.name = name;
		this.rollNo = rollNo;
		this.std = std;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNo=" + rollNo + ", std=" + std + ", address=[" + address.getCity() + ", " + address.getState() + "]]";
	}
}