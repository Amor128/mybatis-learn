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

	User getByID(int id);
}
