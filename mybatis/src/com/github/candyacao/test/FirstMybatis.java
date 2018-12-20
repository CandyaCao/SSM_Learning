package com.github.candyacao.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.github.candyacao.bean.Student;
import com.github.candyacao.dao.IStudentMapper;

public class FirstMybatis {
	public static void main(String[] args) throws IOException {
		// 读取mybatis配置文件
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		
		// 获取SqlSessionFactory工厂对象
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
		// 获取SqlSession对象
		SqlSession session=factory.openSession();
		// 获取IStudentMapper接口对象
		IStudentMapper mapper = session.getMapper(IStudentMapper.class);
		// 调用该接口中的方法
		//Student student = new Student(3, "李四", 19, "河北", "1234567");
		//mapper.saveStudent(student);
		
		Student student = mapper.selectStudentByID(2);
		System.out.println(student);
		// 提交  mybatis必须手动提交，jdbc可以自动提交
		session.commit();
		// 关闭资源，仅仅是关闭资源
		//session.close();
	}
}
