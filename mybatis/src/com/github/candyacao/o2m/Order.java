package com.github.candyacao.o2m;

import java.util.Date;
import java.util.Set;

public class Order {
	// 订单编号
	private int orderID;
	//订单名称
	private String orderName;
	private Date dob;
	private double price;
	// 维护多个订单明细对象
	private Set<OrderLine> orderLine;
	
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Order(String orderName, double price, Date dob, Set<OrderLine> orderLine) {
		super();
		this.orderName = orderName;
		this.price = price;
		this.dob = dob;
		this.orderLine = orderLine;
	}

	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Set<OrderLine> getOrderLine() {
		return orderLine;
	}
	public void setOrderLine(Set<OrderLine> orderLine) {
		this.orderLine = orderLine;
	}
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", orderName=" + orderName + ", dob=" + dob + ", price=" + price
				+ ", orderLine=" + orderLine + "]";
	}
	
}
