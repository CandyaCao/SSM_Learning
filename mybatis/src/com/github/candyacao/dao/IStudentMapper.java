package com.github.candyacao.dao;

import com.github.candyacao.bean.Student;
/**
 * StudentMapper接口 
 * @author j
 *
 */
public interface IStudentMapper {
	Student selectStudentByID(Integer id);
	void saveStudent(Student student);
}
