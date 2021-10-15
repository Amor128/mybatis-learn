package com.ermao.dao;

import com.ermao.pojo.User;
import com.ermao.utils.MybatisUtils;
import com.ermao.utils.PageQueryUtil;
import com.ermao.utils.PageResult;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


import java.util.HashMap;
import java.util.List;

/**
 * @author Ermao
 * Date: 2021/7/17 9:46
 */
public class UserDAOTest {

	/**
	 * 根据数组分页，一次性把所有的结果都查询出来，然后根据分页参数只返回指定的页面数据
	 * 对于多余的数据，可以考虑存储到缓存中
	 */
	@Test
	public void pageByArray() {
		try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			List<User> users = mapper.selectAllUsers();
			int currPage = 2;
			int pageSize = 3;
			int firstIndex = pageSize * (currPage - 1);
			int lastIndex = pageSize * currPage;
			System.out.println(users.subList(firstIndex, lastIndex));
		}
	}

	@Test
	public void pageByLimit() {
		try (final SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);

			HashMap<String, Object> map = new HashMap<>();
			map.put("startIndex", 9);
			map.put("pageSize", 4);

			List<User> list = mapper.selectUsersByLimit(map);
			list.forEach(System.out::println);
		}
	}

	@Test
	public void pageByRowBounds() {
		try (final SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			final RowBounds rowBounds = new RowBounds(1, 4);
			final List<User> list = sqlSession.selectList("com.ermao.dao.UserMapper.selectUserByRowBounds", null, rowBounds);
			list.forEach(System.out::println);
		}
	}

	@Test
	public void pageByDIYUtil() {
		try (final SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			HashMap<String, String> map = new HashMap<>();
			map.put("currentPage", "2");
			map.put("pageSize", "3");
			PageQueryUtil pageQueryUtil = new PageQueryUtil(map);
			List<User> rel = mapper.selectPagedUsers(pageQueryUtil);
			PageResult<User> userPageResult = new PageResult<>(rel, 10, pageQueryUtil.getPageSize(), pageQueryUtil.getCurrentPage());
			userPageResult.getList().forEach(System.out::println);
		}
	}
}
