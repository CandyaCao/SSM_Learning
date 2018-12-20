package com.github.candyacao.test;

import java.io.FileReader;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.github.candyacao.bean.Student;
import com.github.candyacao.dao.IStudentMapper;

public class StudentTest {
	public void saveStudent(Student student) {
		try {
			// 1. 获取SqlSession对象
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = builder.build(new FileReader("src/mybatis-config.xml"));
			SqlSession session = factory.openSession();
			// 2. 获取映射接口实现类对象
			IStudentMapper mapper = session.getMapper(IStudentMapper.class);
			// 3. 调用保存学生的方法
			mapper.saveStudent(student);
			// 4. 提交事务
			session.commit();
			// 5. 关闭资源
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Student getStudent() {
		return null;
	}
}
