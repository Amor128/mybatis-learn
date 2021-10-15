package com.ermao.dao;

import com.ermao.pojo.Student;
import com.ermao.pojo.StudentTeacher;
import com.ermao.pojo.Teacher;
import com.ermao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;


/**
 * @author Ermao
 * Date: 2021/7/17 9:46
 */
public class Test01 {

	@Test
	public void selectTeacherAndHisStudents1() {
		try (final SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			final TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
			Teacher teacher = mapper.selectTeacherAndStudentsByTId1(1);
			List<Student> students = teacher.getStudents();
			students.forEach(System.out::println);
		}
	}

	@Test
	public void selectTeacherAndHisStudents2() {
		try (final SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
			Teacher teacher = mapper.selectTeacherAndHisStudentsByTId2(1);
			List<Student> students = teacher.getStudents();
			students.forEach(System.out::println);
		}
	}

	/**
	 * 多对一
	 * 分批查询
	 */
	@Test
	public void test01() {
		try (final SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
			List<StudentTeacher> student = mapper.getStudent();
			student.forEach(System.out::println);
		}
	}

	/**
	 * 多对一
	 * 组合查询
	 */
	@Test
	public void test02() {
		try (final SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
			List<StudentTeacher> student = mapper.getStudent2();
			student.forEach(System.out::println);
		}
	}

}
