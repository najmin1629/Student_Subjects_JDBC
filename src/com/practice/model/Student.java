package com.practice.model;

import java.util.List;

public class Student {
	private int roll;
	private String name;
	private String standard;
	private String gender;
	private List<Subjects> subjects;
	
	public List<Subjects> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", standard=" + standard + ", gender=" + gender
				+ ", subjects=" + subjects + "]";
	}
	
}
