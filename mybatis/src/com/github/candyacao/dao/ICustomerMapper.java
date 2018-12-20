package com.github.candyacao.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Insert;

import com.github.candyacao.bean.Customer;

public interface ICustomerMapper {
	/*@Insert("insert into candyacao_customer(id,username,password,dob,address)  " + 
			"			 values(#{id},#{username},#{password},#{dob},#{address})")*/
	public void insertCustomer(Customer customer);
	
	void insertCustomerWithAutoKeyByMysql(Customer customer);
	void insertCustomerWithAutoKeyByOracle1(Customer customer);
	void insertCustomerWithAutoKeyByOracle2(Customer customer);
	int updateCustomer(Customer customer);
	int deleteCustomerByID(Integer id);
	
	// 查询
	Customer selectCustomerByID(Integer id);
	/**
	 * List默认为arrayList，Set默认为HashSet
	 * */
	List<Customer> selectAllCustomer();
//	Set<Customer> selectAllCustomer();
	Map<String, Object> selectCustomerByIDWithMap(int id);
	List<Map<String, Object>> selectAllCustomerWithMap();
}
