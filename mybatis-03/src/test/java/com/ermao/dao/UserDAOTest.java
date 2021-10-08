package com.ermao.dao;

import com.ermao.pojo.User;
import com.ermao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.*;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ermao
 * Date: 2021/7/17 9:46
 */
public class UserDAOTest {
	@Test
	public void test01() {
		try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			List<User> userList = mapper.getUserList();
			for (User user : userList) {
				System.out.println(user);
			}
		}
	}

	@Test
	public void test02() {
		try (final SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			User user = mapper.getByID(1);
			System.out.println(user);
		}
	}
}
