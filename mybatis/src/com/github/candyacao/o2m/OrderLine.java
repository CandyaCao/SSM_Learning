package com.github.candyacao.o2m;
//订单明细
public class OrderLine {
	private int id;
	// 商品名称
	private String name;
	// 单价
	private double price;
	//数量
	private int nums;
	// 订单明细中需要维护一个订单对象
	private Order order;
	
	
	
	public OrderLine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderLine(String name, double price, int nums, Order order) {
		super();
		this.name = name;
		this.price = price;
		this.nums = nums;
		this.order = order;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "OrderLine [id=" + id + ", name=" + name + ", price=" + price + ", nums=" + nums + ", order=" + order
				+ "]";
	}
	
	
	
}
