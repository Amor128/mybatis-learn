package com.ermao.dao;

import com.ermao.utils.IDUtils;
import com.ermao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.ermao.pojo.BLOG;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ermao
 * Date: 2021/7/22 5:41
 */
public class Test01 {

	@Test
	public void addInitBlog() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BLOGMapper mapper = sqlSession.getMapper(BLOGMapper.class);
		BLOG blog = new BLOG();
		blog.setId(IDUtils.getID());
		blog.setTitle("Mybatis如此简单");
		blog.setAuthor("狂神说");
		blog.setCreateTime(new Date());
		blog.setViews(9999);

		mapper.addBlog(blog);

		blog.setId(IDUtils.getID());
		blog.setTitle("Java如此简单");
		mapper.addBlog(blog);

		blog.setId(IDUtils.getID());
		blog.setTitle("Spring如此简单");
		mapper.addBlog(blog);

		blog.setId(IDUtils.getID());
		blog.setTitle("微服务如此简单");
		mapper.addBlog(blog);

		sqlSession.commit();

		sqlSession.close();
	}

	@Test
	public void test01() {
		try (final SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			final BLOGMapper mapper = sqlSession.getMapper(BLOGMapper.class);
			final HashMap<String, Object> map = new HashMap<>();
			map.put("title", "Java");
			map.put("author", "狂神说");

			final List<BLOG> blogs = mapper.queryBlog(map);
			blogs.forEach(System.out::println);
		}
	}

	@Test
	public void test02() {
		try (final SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			final BLOGMapper mapper = sqlSession.getMapper(BLOGMapper.class);

			final HashMap<String, Object> map = new HashMap<>();
			map.put("title", "Java");
			map.put("author", "狂神");
			final List<BLOG> blogs = mapper.queryWhen(map);
			blogs.forEach(System.out::println);
		}
	}

	@Test
	public void test03() {
		try (final SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			final BLOGMapper mapper = sqlSession.getMapper(BLOGMapper.class);

			final HashMap<String, Object> map = new HashMap<>();
			map.put("title", "Java");
			map.put("author", "狂神");
			final List<BLOG> blogs = mapper.queryChoose(map);
			blogs.forEach(System.out::println);
		}
	}

	@Test
	public void test04() {
		try (final SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			final BLOGMapper mapper = sqlSession.getMapper(BLOGMapper.class);

			final HashMap<String, Object> map = new HashMap<>();
			map.put("title", "Java");
			map.put("author", "狂神");
			map.put("id", "4f0ec7523f1a4a588ca8a37e89e99b87");
			mapper.updateSet(map);
			sqlSession.commit();
		}
	}

	@Test
	public void test05() {
		try (final SqlSession sqlSession = MybatisUtils.getSqlSession()) {
			final BLOGMapper mapper = sqlSession.getMapper(BLOGMapper.class);

			final HashMap<String, Object> map = new HashMap<>();
			final HashMap<Integer, Object> ids = new HashMap<>();
			map.put("ids", ids);
			ids.put(1, "1");
			ids.put(2, "2");
			final List<BLOG> blogs = mapper.queryBlogForeach(map);
			blogs.forEach(System.out::println);

		}
	}

}
