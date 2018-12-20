package com.github.candyacao.bean;

import java.util.Date;
/**
 * candyacao_customer
 * @author j
 *
 */
public class Customer {
	private Integer id;
	private String username;
	private String password;
	// 注册日期
	private Date dob;
	// 地址
	private Address address;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(Integer id, String username, String password, Date dob, Address address) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.dob = dob;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + ", password=" + password + ", dob=" + dob
				+ ", address=" + address + "]";
	}
	
	
}
