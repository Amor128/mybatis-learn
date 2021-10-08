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
		try(SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			int effected = mapper.insertUser(999, "jiumao", "123qwe");
			System.out.println(effected);
//			sqlSession.commit();	// 注意出了查询之外的其它操作都要通过 sqlSession 提交，否则不会生效，在这里为了不破坏表信息，不提交
		}
	}

	@Test
	public void test04() {
		try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			// 在这里直接新建一个用户对象进行插入
			int effected = mapper.insertUserByUserObject(new User(789, "二毛", "111111"));
			System.out.println(effected);

			// 在这里进行插入结果的判断，成功则提交，失败则 rollback
			if (effected > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		}
	}

	@Test
	public void test05() {
		try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			int effected = mapper.updateUserByUserObject(new User(4, "sanmao", "22222"));
			if (effected > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		}
	}

	@Test
	public void test06() {
		try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			int effected = mapper.deleteUserById(5);
			if (effected > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		}
	}

	@Test
	public void test07() {
		try (final SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			HashMap<String, Object> map = new HashMap<>();
			map.put("userid", 732);
			map.put("username", "aaa");
			map.put("password", "7777");

			int effected = mapper.insertUserByMap(map);
			if (effected > 0) {
				sqlSession.commit();
			}
		}
	}

	@Test
	public void test08() {
		try (final SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			List<User> users = mapper.selectUserByNameLike("%三%");
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
