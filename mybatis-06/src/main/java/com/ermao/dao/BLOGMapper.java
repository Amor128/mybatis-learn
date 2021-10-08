package com.ermao.dao;

import com.ermao.pojo.BLOG;

import java.util.List;
import java.util.Map;

/**
 * @author Ermao
 * Date: 2021/7/22 5:27
 */
public interface BLOGMapper {

	void addBlog(BLOG blog);

	List<BLOG> queryBlog(Map<String, Object> map);

	List<BLOG> queryWhen(Map<String, Object> map);

	List<BLOG> queryChoose(Map<String, Object> map);

	void updateSet(Map<String, Object> map);

	List<BLOG> queryBlogForeach(Map<String, Object> map);

}
