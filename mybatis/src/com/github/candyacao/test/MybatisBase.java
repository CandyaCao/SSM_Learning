package com.github.candyacao.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.github.candyacao.bean.Student;
import com.github.candyacao.dao.IStudentMapper;
import com.github.candyacao.utils.MybatisSqlSessionFactory;

public class MybatisBase {
	@Test
	public void saveStudent() {
		/**
		 * 1. 获取SqlSession对象
		 * 2。 执行SQL语句
		 * 3.提交事务（只适用于增删改）
		 * 4.关闭资源（使用数据库连接池时，不用关）
		 */
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSession(true);
		/**
		 * 2.1 直接根据映射文件
		 * 2.2借助于映射接口
		 */
		
//		sqlSession.insert("com.github.candyacao.dao.IStudentMapper.saveStudent2");
		sqlSession.insert("com.github.candyacao.dao.IStudentMapper.saveStudent", new Student(33, "lisi", 22, "dhsjafh", "21132435"));
//		IStudentMapper mapper = sqlSession.getMapper(IStudentMapper.class);
//		mapper.saveStudent(new Student(33, "lisi", 22, "dhsjafh", "21132435"));
	}
}
