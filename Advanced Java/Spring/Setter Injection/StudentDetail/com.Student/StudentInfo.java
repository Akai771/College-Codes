package com.Student;

public class StudentInfo {
	String name;
	String rollNo;
	String std;
	Address address;
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getStd() {
		return std;
	}
	public void setStd(String std) {
		this.std = std;
	}
	@Override
	public String toString() {
		return "StudentInfo [name = " + name + ", rollNo = " + rollNo + ", std = " + std + "]";
	}
	
}