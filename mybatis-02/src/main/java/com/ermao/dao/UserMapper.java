package com.ermao.dao;

import com.ermao.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author Ermao
 * Date: 2021/7/17 9:34
 */
public interface UserMapper {
	List<User> getUserList();

	List<User> getUserLike(String value);


	User getUserByID(int it);

	int addUser(User user);

	int addUser2(Map<String, Object> map);

	int updateUser(User user);

	int removeUser(int id);


}
