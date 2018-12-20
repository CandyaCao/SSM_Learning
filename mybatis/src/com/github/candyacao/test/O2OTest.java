package com.github.candyacao.test;


import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.candyacao.o2o.Husband;
import com.github.candyacao.o2o.IO2OMapper;
import com.github.candyacao.o2o.Wife;
import com.github.candyacao.utils.MybatisSqlSessionFactory;

public class O2OTest {
	
	SqlSession sqlSession = null;
	IO2OMapper mapper = null;
	
	
	@Test
	public void save() {
		try {
			Wife wife = new Wife("lisi,wife");
			mapper.saveWife(wife);
			Husband husband = new Husband("lisi",wife);
			mapper.saveHusband(husband);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void select() {
		Wife wife = mapper.selectWifeByID(3);
		System.out.println(wife);
	}
	
	@Test
	public void select1() {
//		Husband husband = mapper.selectHusByID(1);
//		System.out.println(husband);
//		Husband husband = mapper.selectHusAndWifeByID(8);
		Husband husband = mapper.selectHusAndWifeByID2(8);
		System.out.println(husband);
	}
	
	@Before
	public void getMapper() {
		try {
			sqlSession = MybatisSqlSessionFactory.getSqlSession();
			mapper = sqlSession.getMapper(IO2OMapper.class);
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
