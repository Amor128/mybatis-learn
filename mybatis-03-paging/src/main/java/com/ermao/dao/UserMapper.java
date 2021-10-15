package com.ermao.dao;

import com.ermao.pojo.User;
import com.ermao.utils.PageQueryUtil;
import com.ermao.utils.PageResult;

import java.util.List;
import java.util.Map;

/**
 * @author Ermao
 * Date: 2021/7/17 9:34
 */
public interface UserMapper {

	List<User> selectAllUsers();

	User getByID(int id);

	List<User> selectUsersByLimit(Map<String, Object> map);

	List<User> selectUserByRowBounds();

	List<User> selectPagedUsers(PageQueryUtil pageQueryUtil);
}
