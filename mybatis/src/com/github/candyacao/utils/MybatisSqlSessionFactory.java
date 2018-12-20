package com.github.candyacao.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisSqlSessionFactory {
	private static SqlSessionFactory factory;
	static {
		
		try {
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			factory = builder.build(new FileReader("src/mybatis-config.xml"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSqlSession() {
		return getSqlSession(false);
	}
	public static SqlSession getSqlSession(boolean autoCommit) {
		SqlSession session = null;
		session = factory.openSession(autoCommit);
		return session;
	}
}
