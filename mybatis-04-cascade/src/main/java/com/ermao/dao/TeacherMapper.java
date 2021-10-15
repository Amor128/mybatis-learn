package com.ermao.dao;

import com.ermao.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

/**
 * @author Ermao
 * Date: 2021/7/20 21:10
 */
public interface TeacherMapper {
	Teacher getTeacher(int id);

	// 获取指定老师所有学生的信息
	Teacher selectTeacherAndStudentsByTId1(@Param("tid") int id);

	Teacher selectTeacherAndHisStudentsByTId2(@Param("tid") int id);
}
