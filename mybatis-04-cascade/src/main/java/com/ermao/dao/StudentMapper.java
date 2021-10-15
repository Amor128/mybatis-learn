package com.ermao.dao;

import com.ermao.pojo.Student;
import com.ermao.pojo.StudentTeacher;

import java.util.List;

/**
 * @author Ermao
 * Date: 2021/7/20 21:10
 */
public interface StudentMapper {

	// 查询所有的学生信息，以及对应的教师的信息
	// select * from student s, teacher t where s.tid = t.id;
	public List<StudentTeacher> getStudent();

	public List<StudentTeacher> getStudent2();
}
