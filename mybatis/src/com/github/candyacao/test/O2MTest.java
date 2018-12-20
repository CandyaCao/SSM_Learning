package com.github.candyacao.test;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.candyacao.o2m.IO2MMapper;
import com.github.candyacao.o2m.Order;
import com.github.candyacao.o2m.OrderLine;
import com.github.candyacao.utils.MybatisSqlSessionFactory;

public class O2MTest {
	
	SqlSession sqlSession = null;
	IO2MMapper mapper = null;
	
	@Test
	public void testTrim() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("searchName", "appl%");
		map.put("searchPrice", "30");
		List<OrderLine> list = mapper.searchChoose(map);
		list.forEach(System.out::println);
	}
	@Test
	public void testChoose() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("orderInfo", "name");
		List<OrderLine> list = mapper.searchChoose(map);
		list.forEach(System.out::println);
	}
	
	
	@Test
	public void save() {
		try {
			Order order = new Order("snack",89,new Date(),null);
			OrderLine orderLine1 = new OrderLine("pear",30,2,order);
			OrderLine orderLine2 = new OrderLine("apple",20,1,order);
			mapper.saveOrder(order);
			mapper.saveOrderLine(orderLine1);
			mapper.saveOrderLine(orderLine2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	@Test
	public void sql() {
		
		try {
			String name="apple";
			double min = 10;
			double max = 20;
			List<OrderLine> list = mapper.searchOrderLine(name,min,max);
			list.forEach(System.out::println);
			System.out.println("----------------");
			
			OrderLine orderLine = new OrderLine();
			orderLine.setName("%appl%");
			orderLine.setPrice(-1000);
			List<OrderLine> list2 = mapper.searchOrderLine2(orderLine);
			list2.forEach(System.out::println);
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void select() {
//		Order order = mapper.selectOrderByID(1);
//		Order order = mapper.selectOrderAndLineByID(1);
//		Order order = mapper.selectOrderAndLineByID2(1);
//		System.out.println(order);
		Set<OrderLine> set = mapper.selectOrderLineAndOrderAll();
		set.forEach(System.out::println);
		
	}
	
	
	
	@Before
	public void getMapper() {
		try {
			sqlSession = MybatisSqlSessionFactory.getSqlSession();
			mapper = sqlSession.getMapper(IO2MMapper.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void close() {
		
			try {
				sqlSession.commit();
				sqlSession.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
