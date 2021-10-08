package com.ermao.dao;

import com.ermao.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

/**
 * @author Ermao
 * Date: 2021/7/20 21:10
 */
public interface TeacherMapper {
	Teacher getTeacher(int id);

	// 获取制定老师所有的学生的信息
	// select t.id as tid, t.name as tname, s.id as sid, s.name as sname from teacher t, student s where t.id = s.tid;
	Teacher getTeacher1(@Param("tid") int id);

	Teacher getTeacher2(@Param("tid") int id);
}
