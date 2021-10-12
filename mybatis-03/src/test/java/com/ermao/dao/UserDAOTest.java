package com.ermao.dao;

import com.ermao.pojo.User;
import com.ermao.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ermao
 * Date: 2021/7/17 9:46
 */
public class UserDAOTest {

	final Logger logger = Logger.getLogger(UserDAOTest.class);


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

	@Test
	public void test03() {
		try (final SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			final UserMapper mapper = sqlSession.getMapper(UserMapper.class);

			final HashMap<String, Object> map = new HashMap<>();
			map.put("startIndex", 1);
			map.put("pageSize", 2);

			List<User> list = mapper.getUserByLimit(map);
			list.forEach(System.out::println);
		}
	}

	@Test
	public void test04() {
		try (final SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			final RowBounds rowBounds = new RowBounds(1, 2);

			final List<User> list = sqlSession.selectList("com.ermao.dao.UserMapper.getUserByRowBounds", null, rowBounds);
			list.forEach(System.out::println);
		}
	}
}
