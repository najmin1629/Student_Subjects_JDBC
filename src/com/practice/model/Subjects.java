package com.practice.model;

public class Subjects {
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Subjects(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Subjects() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Subjects [id=" + id + ", name=" + name + "]";
	}
	
	
}
