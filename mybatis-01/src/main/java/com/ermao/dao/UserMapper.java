package com.ermao.dao;

import com.ermao.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Ermao
 * Date: 2021/7/17 9:34
 */
public interface UserMapper {
	List<User> getUserList();

	User getUserByID(@Param("id") int id);

	int insertUser(@Param("id") int id, @Param("name") String name, @Param("pwd") String pwd);

	int insertUserByUserObject(User user);

	int updateUserByUserObject(User user);

	int deleteUserById(int id);

	int insertUserByMap(Map<String, Object> map);

	List<User> selectUserByNameLike(String value);
}
