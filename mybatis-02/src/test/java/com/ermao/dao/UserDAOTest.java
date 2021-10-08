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
		try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			User userByID = mapper.getUserByID(1);
			System.out.println(userByID);
		}
	}

	@Test
	public void test03() {
		try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			int i = mapper.addUser(new User(4, "二毛", "111111"));
			System.out.println(i);
			if (i > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		}

	}

	@Test
	public void test04() {
		try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			mapper.updateUser(new User(4, "san mao", "22222"));
			sqlSession.commit();
		}

	}

	@Test
	public void test05() {
		try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			mapper.removeUser(5);
			sqlSession.commit();
		}
	}

	@Test
	public void test06() {
		try (final SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			final UserMapper mapper = sqlSession.getMapper(UserMapper.class);

			final HashMap<String, Object> map = new HashMap<>();
			map.put("userid", 5);
			map.put("username", "aaa");
			map.put("password", "7777");

			final int i = mapper.addUser2(map);

			if (i > 0) {
				sqlSession.commit();
			}
		}
	}

	@Test
	public void test07() {
		try (final SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			final List<User> users = mapper.getUserLike("%三%");
			users.forEach(System.out::println);
		}
	}

	@Test
	public void test09() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection =
					DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?user=root&password=wal14.&useSSL=true&useUnicode=true&characterEncoding=utf8");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from mybatis.user");

			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3));
			}

			resultSet.close();
			statement.close();
			connection.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
