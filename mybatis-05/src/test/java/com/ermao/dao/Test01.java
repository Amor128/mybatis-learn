package com.ermao.dao;

import com.ermao.pojo.Student;
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
	public void test01() {
		try (final SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			final TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
			final Teacher teacher = mapper.getTeacher(1);
			System.out.println(teacher);
		}
	}

	@Test
	public void test02() {
		try (final SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			final StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
			final List<Student> student = mapper.getStudent();
			student.forEach(System.out::println);
		}
	}

	@Test
	public void test03() {
		try (final SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			final StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
			final List<Student> student = mapper.getStudent2();
			student.forEach(System.out::println);
		}
	}

	@Test
	public void test04() {
		try (final SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			final TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
			final Teacher teacher1 = mapper.getTeacher1(1);
			System.out.println(teacher1);
		}
	}

	@Test
	public void test05() {
		try (final SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			final TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
			final Teacher teacher1 = mapper.getTeacher2(1);
			System.out.println(teacher1);
		}
	}
}
