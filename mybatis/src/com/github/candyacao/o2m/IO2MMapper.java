package com.github.candyacao.o2m;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IO2MMapper {
	int saveOrder(Order o);
	int saveOrderLine(OrderLine o);
	Order selectOrderByID(int orderID);
	Order selectOrderAndLineByID(int orderID);
	Order selectOrderAndLineByID2(int orderID);
	Set<OrderLine> selectOrderLineAndOrderAll();
	List<OrderLine> searchOrderLine(String name,double min,double max);
	List<OrderLine> searchOrderLine2(OrderLine orderLine);
	List<OrderLine> searchChoose(Map<String, Object> map);
	List<OrderLine> searchTrim(Map<String, Object> map);
	
}
