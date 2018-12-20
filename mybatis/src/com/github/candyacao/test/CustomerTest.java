package com.github.candyacao.test;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.ws.Action;

import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.candyacao.bean.Address;
import com.github.candyacao.bean.Customer;
import com.github.candyacao.dao.ICustomerMapper;
import com.github.candyacao.utils.MybatisSqlSessionFactory;

public class CustomerTest {
	SqlSession sqlSession = null;
	ICustomerMapper mapper = null;
	
	
	@Test
	public void testCustomer() {
		// 手动设置mybatis日志
		LogFactory.useLog4JLogging();
		
		/**
		 * 1. 获取SqlSession对象
		 * 2. 执行Sql语句
		 * 3. 提交事务
		  */
			try {
				SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSession();
				ICustomerMapper mapper = sqlSession.getMapper(ICustomerMapper.class);
				Customer customer = new Customer();
				customer.setId(22);
				customer.setUsername("tom");
				customer.setPassword("123");
				customer.setDob(new Date());
				Address address = new Address("河北","沧州","河间");
				customer.setAddress(address);
				mapper.insertCustomer(customer);
				sqlSession.commit();
				Customer customer1 = mapper.selectCustomerByID(1);
				System.out.println(customer1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	@Before
	public void getMapper() {
		sqlSession = MybatisSqlSessionFactory.getSqlSession();
		mapper = sqlSession.getMapper(ICustomerMapper.class);
	}
	
	@After
	public void close() {
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void save() {
		try {
			Customer customer = new Customer();
//		customer.setId(12);
			customer.setUsername("tom");
			customer.setPassword("123");
			customer.setDob(new Date());
			Address address = new Address("河北","沧州","河间");
			customer.setAddress(address);
			mapper.insertCustomerWithAutoKeyByMysql(customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		try {
			Customer customer = new Customer();
			customer.setId(2);
			customer.setPassword("678");
			customer.setAddress(new Address("山西","太原","小店"));
			mapper.updateCustomer(customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void delete() {
		int len = mapper.deleteCustomerByID(2);
		System.out.println(len);
	}
	
	
	@Test
	public void select() {
		Customer customer = mapper.selectCustomerByID(3);
		System.out.println(customer);
		System.out.println("----------------");
//		Set<Customer> list = mapper.selectAllCustomer();
		List<Customer> list = mapper.selectAllCustomer();
		for(Customer c: list) {
			System.out.println(c);
		}
		
		Map<String, Object> map = mapper.selectCustomerByIDWithMap(1);
		for(String key:map.keySet()) {
			System.out.println(key+"-"+map.get(key));
		}
		
		List<Map<String,Object>> list2 = mapper.selectAllCustomerWithMap();
		for(Map<String, Object>map2: list2) {
			for(String key: map2.keySet()) {
				System.out.println(key+"-"+map.get(key));
			}
		}
	}
}
