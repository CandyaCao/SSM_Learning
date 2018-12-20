package com.github.candyacao.bean;

import org.apache.ibatis.type.Alias;

public class Student {
	private Integer id;
	private String name;
	private Integer age;
	private String address;
	private String phone;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, Integer age, String address, String phone) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.phone = phone;
	}
	public Student(Integer id, String name, Integer age, String address, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.phone = phone;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", phone=" + phone
				+ "]";
	}
	
	
}
